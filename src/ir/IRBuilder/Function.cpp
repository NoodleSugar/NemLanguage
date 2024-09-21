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

	for(const auto& param: function.params)
		llvmParamTypes.push_back(build(param.type));

	auto llvmFunctionType = llvm::FunctionType::get(llvmReturnType, llvmParamTypes, false);

	llvmFunction = llvm::Function::Create(
	 llvmFunctionType, llvm::Function::ExternalLinkage, function.name.string, llvmModule);

	for(auto pair: llvm::zip(llvmFunction->args(), function.params))
	{
		auto& llvmArg = std::get<0>(pair);
		auto& param	  = std::get<1>(pair);

		llvmArg.setName(param.name.string);
	}

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

	namedValues.pushLayer();
	for(auto& llvmArg: llvmFunction->args())
	{
		auto alloc = builder.CreateAlloca(llvmArg.getType(), nullptr, llvmArg.getName());

		builder.CreateStore(&llvmArg, alloc);

		namedValues.add(llvmArg.getName(), alloc);
	}

	for(const auto& inst: function.body.instructions)
		build(inst);
	namedValues.popLayer();

	llvm::verifyFunction(*llvmFunction, &llvm::errs());

	optimizer.run(*llvmFunction);

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
	args.reserve(call.args.size());
	for(const auto& arg: call.args)
		args.push_back(build(arg));

	return builder.CreateCall(function, args, "calltmp");
}

} // namespace nem::ir
