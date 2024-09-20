#include "nem/ast/Ast.hpp"
#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitLiteralBool(NEMParser::LiteralBoolContext* ctx)
{
	const auto value = ctx->L_BOOL()->getText();

	return buildAstElement<Literal>(ctx, LiteralType::Bool, value);
}

std::any ParseTreeVisitor::visitLiteralInt(NEMParser::LiteralIntContext* ctx)
{
	const auto value = ctx->L_INT()->getText();

	return buildAstElement<Literal>(ctx, LiteralType::Int, value);
}

std::any ParseTreeVisitor::visitLiteralReal(NEMParser::LiteralRealContext* ctx)
{
	const auto value = ctx->L_REAL()->getText();

	return buildAstElement<Literal>(ctx, LiteralType::Real, value);
}

std::any ParseTreeVisitor::visitExprParan(NEMParser::ExprParanContext* ctx)
{
	return ctx->expr()->accept(this);
}

std::any ParseTreeVisitor::visitExprUnMinus(NEMParser::ExprUnMinusContext* ctx)
{
	const auto expr = MakePtr<Expression>();
	*expr			= visitExpression(ctx->expr());

	return buildAstElement<UnaryOperation>(ctx, UnaryOp::Minus, expr);
}

std::any ParseTreeVisitor::visitExprBinAnd(NEMParser::ExprBinAndContext* ctx)
{
	return AstElement{computeBinaryOperation(ctx, BinaryOp::And, ctx->left, ctx->right)};
}

std::any ParseTreeVisitor::visitExprBinOr(NEMParser::ExprBinOrContext* ctx)
{
	return AstElement{computeBinaryOperation(ctx, BinaryOp::Or, ctx->left, ctx->right)};
}

std::any ParseTreeVisitor::visitExprBinSlash(NEMParser::ExprBinSlashContext* ctx)
{
	return AstElement{computeBinaryOperation(ctx, BinaryOp::Slash, ctx->left, ctx->right)};
}

std::any ParseTreeVisitor::visitExprBinStar(NEMParser::ExprBinStarContext* ctx)
{
	return AstElement{computeBinaryOperation(ctx, BinaryOp::Star, ctx->left, ctx->right)};
}

std::any ParseTreeVisitor::visitExprBinMinus(NEMParser::ExprBinMinusContext* ctx)
{
	return AstElement{computeBinaryOperation(ctx, BinaryOp::Minus, ctx->left, ctx->right)};
}

std::any ParseTreeVisitor::visitExprBinPlus(NEMParser::ExprBinPlusContext* ctx)
{
	return AstElement{computeBinaryOperation(ctx, BinaryOp::Plus, ctx->left, ctx->right)};
}

} // namespace nem::parser
