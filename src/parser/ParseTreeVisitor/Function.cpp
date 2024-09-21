#include <algorithm>

#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitFnDef(NEMParser::FnDefContext* ctx)
{
	const auto name		  = computeIdentifier(ctx->IDENTIFIER());
	const auto returnType = visitType(ctx->type());
	const auto params	  = computeParamSeq(ctx->paramSeq());
	const auto body		  = visitAstElement<Block>(ctx->block());

	return buildAstElement<Function>(ctx,
									 std::move(name),
									 std::move(returnType),
									 std::move(params),
									 std::move(body));
}

std::any ParseTreeVisitor::visitParam(NEMParser::ParamContext* ctx)
{
	const auto name = computeIdentifier(ctx->IDENTIFIER());
	const auto type = visitType(ctx->type());

	return buildAstElement<Parameter>(ctx,
									  std::move(name),
									  std::move(type));
}

std::any ParseTreeVisitor::visitBlock(NEMParser::BlockContext* ctx)
{
	const auto instrCtx = ctx->instr();

	InstructionSeq instructions;
	instructions.reserve(instrCtx.size());

	std::transform(instrCtx.cbegin(), instrCtx.cend(),
				   std::back_inserter(instructions),
				   [this](const auto elt)
				   { return visitInstruction(elt); });

	return buildAstElement<Block>(ctx, std::move(instructions));
}

std::any ParseTreeVisitor::visitCall(NEMParser::CallContext* ctx)
{
	const auto name = computeIdentifier(ctx->IDENTIFIER());
	const auto args = computeArgSeq(ctx->argSeq());

	return buildAstElement<Call>(ctx,
								 std::move(name),
								 std::move(args));
}

} // namespace nem::parser
