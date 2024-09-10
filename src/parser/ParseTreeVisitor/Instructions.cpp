#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitInstrTerminated(NEMParser::InstrTerminatedContext* ctx)
{
	return ctx->terminatedInstr()->accept(this);
}

std::any ParseTreeVisitor::visitInstrReturnValue(NEMParser::InstrReturnValueContext* ctx)
{
	const auto value = visitExpression(ctx->expr());

	return buildAstElement<Return>(ctx, value);
}

} // namespace nem::parser
