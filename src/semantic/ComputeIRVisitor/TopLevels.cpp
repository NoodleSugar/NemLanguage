#include <llvm/IR/Verifier.h>

#include <nem/ast/Ast.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

llvm::Function* ComputeIRVisitor::createFunctionPrototype(const Function& function)
{
	if(auto f = m_llvmModule->getFunction(function.name); f != nullptr)
	{
		llvm::errs()
		 << "Function prototype error ["
		 << function.name
		 << "] : Function cannot be redeclared";
		return nullptr;
	}

	auto llvmreturnType = visitType(*function.returnType);
	auto llvmParamTypes = std::vector<llvm::Type*>();
	llvmParamTypes.reserve(function.parameters.size());

	for(const auto& param: function.parameters)
		llvmParamTypes.push_back(visitType(*param.type));

	auto* llvmFunctionType = llvm::FunctionType::get(llvmreturnType, llvmParamTypes, false);

	auto llvmFunction = llvm::Function::Create(
	 llvmFunctionType, llvm::Function::ExternalLinkage, function.name, m_llvmModule.get());

	for(auto pair: llvm::zip(llvmFunction->args(), function.parameters))
	{
		auto& llvmArg	= std::get<0>(pair);
		auto& parameter = std::get<1>(pair);

		llvmArg.setName(parameter.name);
	}

	return llvmFunction;
}

void ComputeIRVisitor::visit(const File& file)
{
	for(const auto& function: file.functions)
		createFunctionPrototype(function);

	for(const auto& function: file.functions)
		visit(function);
}

llvm::Function* ComputeIRVisitor::visit(const Function& function)
{
	auto llvmFunction = m_llvmModule->getFunction(function.name);
	if(!llvmFunction)
	{
		llvm::errs()
		 << "Function definition error ["
		 << function.name
		 << "] : Function prototypeshould have been generated";
		return nullptr;
	}

	if(!llvmFunction->empty())
	{
		llvm::errs()
		 << "Function definition error ["
		 << function.name
		 << "] : Function cannot be redefined";
		return nullptr;
	}

	auto entryBlock = llvm::BasicBlock::Create(*m_llvmContext, "entry", llvmFunction);
	m_builder.SetInsertPoint(entryBlock);

	m_variableRegister.pushLayer();
	for(auto& llvmArg: llvmFunction->args())
	{
		auto name		= llvmArg.getName();
		auto llvmType	= llvmArg.getType();
		auto llvmAlloca = m_builder.CreateAlloca(llvmType, nullptr, name);

		m_builder.CreateStore(&llvmArg, llvmAlloca);
		m_variableRegister.add(name, llvmAlloca);
	}

	for(auto& inst: function.block.instructions)
		visitInstr(*inst);
	m_variableRegister.popLayer();

	llvm::verifyFunction(*llvmFunction, &llvm::errs());

	return llvmFunction;
}