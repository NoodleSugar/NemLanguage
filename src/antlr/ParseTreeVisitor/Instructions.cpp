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

std::any ParseTreeVisitor::visitInstrBlock(NEMParser::InstrBlockContext* ctx)
{
	const auto block = visitAndCast<Block>(ctx->block());

	return buildNodeValue<Block>(ctx, block);
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

std::any ParseTreeVisitor::visitInstrAssign(NEMParser::InstrAssignContext* ctx)
{
	return buildInstrAssign(AssignOp::Equal,
							  ctx,
							  ctx->IDENTIFIER(),
							  ctx->expr());
}

std::any ParseTreeVisitor::visitInstrAssignAdd(NEMParser::InstrAssignAddContext* ctx)
{
	return buildInstrAssign(AssignOp::AddEqual,
							  ctx,
							  ctx->IDENTIFIER(),
							  ctx->expr());
}

std::any ParseTreeVisitor::visitInstrAssignSub(NEMParser::InstrAssignSubContext* ctx)
{
	return buildInstrAssign(AssignOp::SubEqual,
							  ctx,
							  ctx->IDENTIFIER(),
							  ctx->expr());
}

std::any ParseTreeVisitor::visitInstrAssignMul(NEMParser::InstrAssignMulContext* ctx)
{
	return buildInstrAssign(AssignOp::MulEqual,
							  ctx,
							  ctx->IDENTIFIER(),
							  ctx->expr());
}

std::any ParseTreeVisitor::visitInstrAssignDiv(NEMParser::InstrAssignDivContext* ctx)
{
	return buildInstrAssign(AssignOp::DivEqual,
							  ctx,
							  ctx->IDENTIFIER(),
							  ctx->expr());
}

std::any ParseTreeVisitor::visitInstrAssignMod(NEMParser::InstrAssignModContext* ctx)
{
	return buildInstrAssign(AssignOp::ModEqual,
							  ctx,
							  ctx->IDENTIFIER(),
							  ctx->expr());
}

std::any ParseTreeVisitor::visitInstrReturnValue(NEMParser::InstrReturnValueContext* ctx)
{
	const auto value = visitExpression(ctx->expr());

	return buildNodeValue<Return>(ctx, value);
}

std::any ParseTreeVisitor::visitInstrReturn(NEMParser::InstrReturnContext* ctx)
{
	return buildNodeValue<Return>(ctx);
}

} // namespace nem::antlr
