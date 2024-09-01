#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitLiteralBool(NEMParser::LiteralBoolContext* ctx)
{
	const auto value = ctx->L_BOOL()->getText();

	return buildNodeValue<Literal>(ctx, value);
}

std::any ParseTreeVisitor::visitLiteralInt(NEMParser::LiteralIntContext* ctx)
{
	const auto value = ctx->L_INT()->getText();

	return buildNodeValue<Literal>(ctx, value);
}

std::any ParseTreeVisitor::visitLiteralReal(NEMParser::LiteralRealContext* ctx)
{
	const auto value = ctx->L_REAL()->getText();

	return buildNodeValue<Literal>(ctx, value);
}

std::any ParseTreeVisitor::visitExprIdentifier(NEMParser::ExprIdentifierContext* ctx)
{
	return buildNodeValue<Identifier>(ctx, ctx->IDENTIFIER()->getText());
}

std::any ParseTreeVisitor::visitExprParenthesis(NEMParser::ExprParenthesisContext* ctx)
{
	return ctx->expr()->accept(this);
}

std::any ParseTreeVisitor::visitExprMinus(NEMParser::ExprMinusContext* ctx)
{
	const auto expr = makeExpressionNodePtr(visitExpression(ctx->expr()));

	return buildNodeValue<Minus>(ctx, expr);
}

std::any ParseTreeVisitor::visitExprAdd(NEMParser::ExprAddContext* ctx)
{
	return buildExprArith(ArithOp::Addition,
						  ctx,
						  ctx->left,
						  ctx->right);
}

std::any ParseTreeVisitor::visitExprSub(NEMParser::ExprSubContext* ctx)
{
	return buildExprArith(ArithOp::Substraction,
						  ctx,
						  ctx->left,
						  ctx->right);
}

std::any ParseTreeVisitor::visitExprMul(NEMParser::ExprMulContext* ctx)
{
	return buildExprArith(ArithOp::Multiplication,
						  ctx,
						  ctx->left,
						  ctx->right);
}

std::any ParseTreeVisitor::visitExprDiv(NEMParser::ExprDivContext* ctx)
{
	return buildExprArith(ArithOp::Division,
						  ctx,
						  ctx->left,
						  ctx->right);
}

std::any ParseTreeVisitor::visitExprMod(NEMParser::ExprModContext* ctx)
{
	return buildExprArith(ArithOp::Modulo,
						  ctx,
						  ctx->left,
						  ctx->right);
}

} // namespace nem::antlr
