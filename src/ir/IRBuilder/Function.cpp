#include <llvm/IR/Verifier.h>

#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"

namespace nem::ir
{

using namespace nem::ast;

llvm::Function* IRBuilder::createFunctionPrototype(const Function& function)
{
	auto llvmReturnType = build(function.returnType);
	auto llvmParamTypes = std::vector<llvm::Type*>();

	auto llvmFunctionType = llvm::FunctionType::get(llvmReturnType, llvmParamTypes, false);

	auto llvmFunction = llvm::Function::Create(
	 llvmFunctionType, llvm::Function::ExternalLinkage, function.name.string, llvmModule);

	return llvmFunction;
}

llvm::Function* IRBuilder::build(const Function& function)
{
	auto llvmFunction = llvmModule.getFunction(function.name.string);
	if(llvmFunction != nullptr &&
	   !llvmFunction->empty())
	{
		llvm::errs()
		 << "Function definition error : ["
		 << function.name.string
		 << "] cannot be redefined";
		return nullptr;
	}

	llvmFunction = createFunctionPrototype(function);

	auto entryBlock = llvm::BasicBlock::Create(llvmContext, "entry", llvmFunction);
	builder.SetInsertPoint(entryBlock);

	for(const auto& inst: function.body.instructions)
		build(inst);

	llvm::verifyFunction(*llvmFunction, &llvm::errs());

	return llvmFunction;
}

} // namespace nem::ir
