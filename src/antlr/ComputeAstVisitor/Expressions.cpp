#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/ast/ImplNode.hpp>

using namespace nem::antlr;
using namespace nem::ast;

Node::Ptr ComputeAstVisitor::computeExprArith(ArithOp				   op,
												   NEMParser::ExprContext* leftCtx,
												   NEMParser::ExprContext* rightCtx)
{
	auto left  = nodeFromVisit(leftCtx);
	auto right = nodeFromVisit(rightCtx);

	return Node::Ptr(new ArithmeticNode{op, left, right});
}

std::any ComputeAstVisitor::visitLiteralInteger(NEMParser::LiteralIntegerContext* ctx)
{
	auto value = ctx->L_INT()->getText();

	return Node::Ptr(new LiteralNode{Literal::Type::Integer, value});
}

std::any ComputeAstVisitor::visitExprParenthesis(NEMParser::ExprParenthesisContext* ctx)
{
	return ctx->expr()->accept(this);
}

std::any ComputeAstVisitor::visitExprMinus(NEMParser::ExprMinusContext* ctx)
{
	auto expr = nodeFromVisit(ctx->expr());

	return Node::Ptr(new MinusNode{expr});
}

std::any ComputeAstVisitor::visitExprAdd(NEMParser::ExprAddContext* ctx)
{
	return computeExprArith(ArithOp::Addition, ctx->left, ctx->right);
}

std::any ComputeAstVisitor::visitExprSub(NEMParser::ExprSubContext* ctx)
{
	return computeExprArith(ArithOp::Substraction, ctx->left, ctx->right);
}

std::any ComputeAstVisitor::visitExprMul(NEMParser::ExprMulContext* ctx)
{
	return computeExprArith(ArithOp::Multiplication, ctx->left, ctx->right);
}

std::any ComputeAstVisitor::visitExprDiv(NEMParser::ExprDivContext* ctx)
{
	return computeExprArith(ArithOp::Division, ctx->left, ctx->right);
}

std::any ComputeAstVisitor::visitExprMod(NEMParser::ExprModContext* ctx)
{
	return computeExprArith(ArithOp::Modulo, ctx->left, ctx->right);
}
