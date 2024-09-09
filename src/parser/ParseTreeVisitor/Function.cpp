#include <algorithm>

#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitFnDef(NEMParser::FnDefContext* ctx)
{
	const auto returnTypeCtx = ctx->type();
	const auto blockCtx		 = ctx->block();

	const auto name		  = computeIdentifier(ctx->IDENTIFIER());
	const auto returnType = visitType(returnTypeCtx);
	const auto body		  = visitTreeValue<Block>(blockCtx);

	return buildParseTreeValue<Function>(ctx, name, returnType, body);
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

	return buildParseTreeValue<Block>(ctx, std::move(instructions));
}

} // namespace nem::parser