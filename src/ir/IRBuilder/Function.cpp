#include <llvm/IR/Verifier.h>

#include "nem/ast/Ast.hpp"
#include "nem/ir/IRBuilder.hpp"

namespace nem::ir
{

using namespace nem::ast;

llvm::Function* IRBuilder::createFunctionPrototype(const Function& function)
{
	auto llvmFunction = llvmModule.getFunction(function.name.string);
	if(llvmFunction != nullptr)
	{
		llvm::errs()
		 << "IRBuilder::createFunctionPrototype(const Function&) : ["
		 << function.name.string
		 << "] has already a prototype\n";
		return nullptr;
	}

	auto llvmReturnType = build(function.returnType);
	auto llvmParamTypes = std::vector<llvm::Type*>();

	auto llvmFunctionType = llvm::FunctionType::get(llvmReturnType, llvmParamTypes, false);

	llvmFunction = llvm::Function::Create(
	 llvmFunctionType, llvm::Function::ExternalLinkage, function.name.string, llvmModule);

	return llvmFunction;
}

llvm::Function* IRBuilder::build(const Function& function)
{
	auto llvmFunction = llvmModule.getFunction(function.name.string);

	if(llvmFunction == nullptr)
		llvmFunction = createFunctionPrototype(function);
	else if(!llvmFunction->empty())
	{
		llvm::errs()
		 << "IRBuilder::build(const Function&) : ["
		 << function.name.string
		 << "] cannot be redefined\n";
		return nullptr;
	}

	auto entryBlock = llvm::BasicBlock::Create(llvmContext, "entry", llvmFunction);
	builder.SetInsertPoint(entryBlock);

	for(const auto& inst: function.body.instructions)
		build(inst);

	llvm::verifyFunction(*llvmFunction, &llvm::errs());

	return llvmFunction;
}

llvm::CallInst* IRBuilder::build(const ast::Call& call)
{
	auto function = llvmModule.getFunction(call.name.string);

	if(function == nullptr)
	{
		llvm::errs() << "IRBuilder::build(const ast::Call&) : "
						"Function ["
					 << call.name.string
					 << "] not declared\n";
		return nullptr;
	}

	auto args = std::vector<llvm::Value*>();

	return builder.CreateCall(function, args, "calltmp");
}

} // namespace nem::ir
