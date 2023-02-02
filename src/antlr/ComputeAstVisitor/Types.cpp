#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>

using namespace nem::antlr;
using namespace nem::ast;

std::any ComputeAstVisitor::visitTypeWithConst(NEMParser::TypeWithConstContext* ctx)
{
	auto type = nodeFromVisit(ctx->unqualifiedType());

	return Node::Ptr(new QualifiedTypeNode{QualifiedType::Qualifier::Const, type});
}

std::any ComputeAstVisitor::visitTypeVoid(NEMParser::TypeVoidContext* ctx)
{
	return Node::Ptr(new NativeTypeNode{NativeType::Name::Void});
}

std::any ComputeAstVisitor::visitTypeInteger(NEMParser::TypeIntegerContext* ctx)
{
	return Node::Ptr(new NativeTypeNode{NativeType::Name::Int});
}
