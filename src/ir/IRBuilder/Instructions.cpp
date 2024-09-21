#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"
#include "nem/util/VisitorHelper.hpp"

#define NEM_IR_DEFINE_VISITOR_METHOD(I) \
	[this](const I& x) -> llvm::Instruction* { return build(x); },

namespace nem::ir
{

using namespace nem::ast;

// clang-format off
llvm::Instruction* IRBuilder::build(const Instruction& instr)
{
	const auto visitor = VisitorOverload
	{
		NEM_FOR_EACH(NEM_IR_DEFINE_VISITOR_METHOD, NEM_AST_LIST_OF_INSTRUCTION_NODES)
		[](const auto& x) -> llvm::Instruction*
		{
			llvm::errs() << "IRBuilder::build(const Instruction&) : Unhandled instruction\n";
			return nullptr;
		}
	};

	return std::visit(visitor, instr);
}
// clang-format on

llvm::Instruction* IRBuilder::build(const Block& block)
{
	llvm::Instruction* last;

	for(const auto& inst: block.instructions)
		last = build(inst);

	return last;
}

llvm::BranchInst* IRBuilder::build(const If& i)
{
	const auto cond		= build(i.cond);
	const auto function = builder.GetInsertBlock()->getParent();

	auto thenBB = llvm::BasicBlock::Create(llvmContext, "ifThen");
	auto elseBB = llvm::BasicBlock::Create(llvmContext, "ifElse");
	auto endBB	= llvm::BasicBlock::Create(llvmContext, "ifEnd");

	auto ret = builder.CreateCondBr(cond, thenBB, elseBB);

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

	return ret;
}

llvm::ReturnInst* IRBuilder::build(const Return& ret)
{
	return builder.CreateRet(build(ret.value));
}

} // namespace nem::ir
