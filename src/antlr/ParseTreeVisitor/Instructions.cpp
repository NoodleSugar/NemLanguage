#include <algorithm>

#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitInstrTerminated(NEMParser::InstrTerminatedContext* ctx)
{
	return ctx->terminatedInstr()->accept(this);
}

std::any ParseTreeVisitor::visitInstrVarDecl(NEMParser::InstrVarDeclContext* ctx)
{
	const auto identifier = computeIdentifierNode(ctx->IDENTIFIER());
	const auto type		  = visitType(ctx->type());

	return buildNodeValue<Declaration>(ctx, identifier, type);
}

std::any ParseTreeVisitor::visitInstrVarDefWithType(NEMParser::InstrVarDefWithTypeContext* ctx)
{
	const auto identifier = computeIdentifierNode(ctx->IDENTIFIER());
	const auto type		  = visitType(ctx->type());
	const auto value	  = visitExpression(ctx->expr());

	return buildNodeValue<Definition>(ctx, identifier, type, value);
}

std::any ParseTreeVisitor::visitInstrVarDefWithoutType(NEMParser::InstrVarDefWithoutTypeContext* ctx)
{
	const auto identifier = computeIdentifierNode(ctx->IDENTIFIER());
	const auto value	  = visitExpression(ctx->expr());

	return buildNodeValue<Definition>(ctx, identifier, std::nullopt, value);
}

} // namespace nem::antlr
