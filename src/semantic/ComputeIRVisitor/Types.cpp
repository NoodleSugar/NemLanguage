#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>
#include <nem/ast/Info.hpp>
#include <nem/semantic/ComputeIRVisitor.hpp>

using namespace nem::ast;
using namespace nem::semantic;

llvm::Type* ComputeIRVisitor::visitType(const Node& node)
{
	switch(node.type)
	{
	case NodeType::QualifiedType:
		return visit(ast_cast<QualifiedType>(node));
	case NodeType::NativeType:
		return visit(ast_cast<NativeType>(node));
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
	case NativeTypeEnum::Void:
		return m_builder.getVoidTy();
	case NativeTypeEnum::Bool:
		return (llvm::Type*)m_builder.getInt1Ty();
	case NativeTypeEnum::Int:
	case NativeTypeEnum::Int64:
	case NativeTypeEnum::UInt:
	case NativeTypeEnum::UInt64:
		return (llvm::Type*)m_builder.getInt64Ty();
	case NativeTypeEnum::Int16:
	case NativeTypeEnum::UInt16:
		return (llvm::Type*)m_builder.getInt16Ty();
	case NativeTypeEnum::Int32:
	case NativeTypeEnum::UInt32:
		return (llvm::Type*)m_builder.getInt32Ty();
	case NativeTypeEnum::Real:
	case NativeTypeEnum::Real64:
		return (llvm::Type*)m_builder.getDoubleTy();
	case NativeTypeEnum::Real16:
		return (llvm::Type*)m_builder.getHalfTy();
	case NativeTypeEnum::Real32:
		return (llvm::Type*)m_builder.getFloatTy();
	}
}