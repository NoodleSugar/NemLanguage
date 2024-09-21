#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"
#include "nem/util/VisitorHelper.hpp"

#define NEM_IR_DEFINE_VISITOR_METHOD(I) \
	[this](const I& x) -> void { build(x); },

namespace nem::ir
{

using namespace nem::ast;

// clang-format off
void IRBuilder::build(const Instruction& instr)
{
	const auto visitor = VisitorOverload
	{
		NEM_FOR_EACH(NEM_IR_DEFINE_VISITOR_METHOD, NEM_AST_LIST_OF_INSTRUCTION_NODES)
		[](const auto& x) -> llvm::Instruction*
		{
			llvm::errs() << "IRBuilder::build(const Instruction&) : Unhandled instruction\n";
		}
	};

	std::visit(visitor, instr);
}
// clang-format on

void IRBuilder::build(const Block& block)
{
	namedValues.pushLayer();
	for(const auto& instr: block.instructions)
		build(instr);
	namedValues.popLayer();
}

void IRBuilder::build(const VarDef& i)
{
	const auto& name  = i.name.string;
	const auto	type  = build(i.type);
	const auto	value = build(i.value);

	auto function = builder.GetInsertBlock()->getParent();

	llvm::IRBuilder<> tmpBuilder(&function->getEntryBlock(),
								 function->getEntryBlock().begin());

	auto alloc = tmpBuilder.CreateAlloca(type, nullptr, name);
	tmpBuilder.CreateStore(value, alloc);

	namedValues.add(name, alloc);
}

void IRBuilder::build(const If& i)
{
	const auto cond		= build(i.cond);
	const auto function = builder.GetInsertBlock()->getParent();

	auto thenBB = llvm::BasicBlock::Create(llvmContext, "ifThen");
	auto elseBB = llvm::BasicBlock::Create(llvmContext, "ifElse");
	auto endBB	= llvm::BasicBlock::Create(llvmContext, "ifEnd");

	builder.CreateCondBr(cond, thenBB, elseBB);

	{
		function->insert(function->end(), thenBB);
		builder.SetInsertPoint(thenBB);
		build(*i.then);
		builder.CreateBr(endBB);
	}

	{
		function->insert(function->end(), elseBB);
		builder.SetInsertPoint(elseBB);
		if(i.else_)
			build(**i.else_);
		builder.CreateBr(endBB);
	}

	function->insert(function->end(), endBB);
	builder.SetInsertPoint(endBB);
}

void IRBuilder::build(const Return& ret)
{
	builder.CreateRet(build(ret.value));
}

} // namespace nem::ir
