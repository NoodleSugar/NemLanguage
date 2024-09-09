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

llvm::ReturnInst* IRBuilder::build(const Return& ret)
{
	return builder.CreateRet(build(ret.value));
}

} // namespace nem::ir
