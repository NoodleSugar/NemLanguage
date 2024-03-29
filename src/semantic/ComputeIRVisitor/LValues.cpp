#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

llvm::AllocaInst* ComputeIRVisitor::visitLValue(const Node& node)
{
	switch(node.getType())
	{
	case AstType::Variable:
		return visit(node_cast<Variable>(node));
	default:
		llvm::errs() << "ComputeIRVisitor::visitLValue : Unexpected node type\n";
		return nullptr;
	}
}

llvm::AllocaInst* ComputeIRVisitor::visit(const Variable& lValue)
{
	if(!m_variableRegister.contains(lValue.name))
	{
		llvm::errs() << "ComputeIRVisitor::visit(Definition) : variable \""
					 << lValue.name
					 << "\" not declared\n";
		return nullptr;
	}

	return m_variableRegister.get(lValue.name);
}