#include <nem/ast/Ast.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

ComputeIRVisitor::ComputeIRVisitor() :
	m_llvmContext(std::make_unique<llvm::LLVMContext>()),
	m_llvmModule(std::make_unique<llvm::Module>("default", *m_llvmContext)),
	m_builder(*m_llvmContext) {}

std::unique_ptr<llvm::LLVMContext>&& ComputeIRVisitor::getContext() { return std::move(m_llvmContext); }
std::unique_ptr<llvm::Module>&&		 ComputeIRVisitor::getModule() { return std::move(m_llvmModule); }

llvm::Value* ComputeIRVisitor::visit(const FunctionCall& funCall)
{
	auto function = m_llvmModule->getFunction(funCall.name);
	if(function == nullptr)
	{
		llvm::errs() << "ComputeIRVisitor::visit(FunctionCall) : Function \""
					 << funCall.name
					 << "\" not declared\n";
		return nullptr;
	}

	auto expectedArgCount = function->arg_size();
	auto argCount		  = funCall.arguments.size();
	if(expectedArgCount != argCount)
	{
		llvm::errs() << "ComputeIRVisitor::visit(FunctionCall) : Function \""
					 << funCall.name
					 << "\" expected "
					 << expectedArgCount
					 << " arguments, but"
					 << argCount
					 << " were given\n";
		return nullptr;
	}

	std::vector<llvm::Value*> values;
	values.reserve(argCount);

	for(auto& arg: funCall.arguments)
	{
		auto value = visitExpr(*arg);
		values.push_back(value);
	}

	if(function->getReturnType()->isVoidTy())
		return m_builder.CreateCall(function, values);
	return m_builder.CreateCall(function, values, "calltmp");
}