#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitInstrTerminated(NEMParser::InstrTerminatedContext* ctx)
{
	return ctx->terminatedInstr()->accept(this);
}

std::any ParseTreeVisitor::visitInstrVarDef(NEMParser::InstrVarDefContext* ctx)
{
	auto name  = computeIdentifier(ctx->IDENTIFIER());
	auto type  = visitType(ctx->type());
	auto value = visitExpression(ctx->expr());

	return buildAstElement<VarDef>(ctx,
								   std::move(name),
								   std::move(type),
								   std::move(value));
}

std::any ParseTreeVisitor::visitInstrIf(NEMParser::InstrIfContext* ctx)
{
	auto cond  = visitExpression(ctx->cond);
	auto then  = std::make_shared<Instruction>(visitInstruction(ctx->then));
	auto else_ = ctx->else_ ?
				  (InstructionOpt)std::make_shared<Instruction>(visitInstruction(ctx->else_)) :
				  (InstructionOpt)std::nullopt;

	return buildAstElement<If>(ctx, cond, then, else_);
}

std::any ParseTreeVisitor::visitInstrReturnValue(NEMParser::InstrReturnValueContext* ctx)
{
	const auto value = visitExpression(ctx->expr());

	return buildAstElement<Return>(ctx, value);
}

} // namespace nem::parser
