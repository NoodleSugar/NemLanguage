#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

llvm::Type* ComputeIRVisitor::visitType(const Node& node)
{
	switch(node.getType())
	{
	case AstType::QualifiedType:
		return visit(node_cast<QualifiedType>(node));
	case AstType::NativeType:
		return visit(node_cast<NativeType>(node));
	default:
		llvm::errs() << "ComputeIRVisitor::visitType : Unexpected node type\n";
		return nullptr;
	}
}

llvm::Type* ComputeIRVisitor::visit(const QualifiedType& type)
{
	return visitType(*type.type);
}

llvm::Type* ComputeIRVisitor::visit(const NativeType& type)
{
	switch(type.name)
	{
	case NativeType::Name::Void:
		return m_builder.getVoidTy();
	case NativeType::Name::Int:
		return (llvm::Type*)m_builder.getInt64Ty();
	}
}