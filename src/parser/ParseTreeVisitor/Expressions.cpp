#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

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

} // namespace nem::parser
