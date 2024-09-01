#include <algorithm>

#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitFnDef(NEMParser::FnDefContext* ctx)
{
	const auto returnTypeCtx = ctx->type();
	const auto paramSeqCtx	 = ctx->paramSeq();
	const auto blockCtx		 = ctx->block();

	const auto identifier = computeIdentifierNode(ctx->IDENTIFIER());
	const auto returnType = returnTypeCtx == nullptr ?
							 TypeNodeOpt() :
							 visitType(returnTypeCtx);
	const auto parameters = paramSeqCtx == nullptr ?
							 ParameterNodeList() :
							 visitAndCast<ParameterNodeList>(paramSeqCtx);
	const auto block	  = visitAndCast<Block>(blockCtx);

	return buildNodeValue<Function>(ctx, identifier, returnType, parameters, block.instructions);
}

std::any ParseTreeVisitor::visitParamSeq(NEMParser::ParamSeqContext* ctx)
{
	const auto paramCtx = ctx->param();

	ParameterNodeList parameters;
	parameters.reserve(paramCtx.size());
	std::transform(paramCtx.cbegin(), paramCtx.cend(),
				   std::back_inserter(parameters),
				   [&](const auto elt)
				   { return visitParameter(elt); });

	return parameters;
}

std::any ParseTreeVisitor::visitParam(NEMParser::ParamContext* ctx)
{
	const auto identifier = computeIdentifierNode(ctx->IDENTIFIER());
	const auto type		  = visitType(ctx->type());

	return buildNodeValue<Parameter>(ctx, identifier, type);
}

std::any ParseTreeVisitor::visitBlock(NEMParser::BlockContext* ctx)
{
	const auto instrCtx = ctx->instr();

	Block block;
	block.instructions.reserve(instrCtx.size());

	std::transform(instrCtx.cbegin(), instrCtx.cend(),
				   std::back_inserter(block.instructions),
				   [this](const auto elt)
				   { return visitInstruction(elt); });

	return block;
}

std::any ParseTreeVisitor::visitCall(NEMParser::CallContext* ctx)
{
	const auto identifier = computeIdentifierNode(ctx->IDENTIFIER());
	const auto argSeqCtx  = ctx->argSeq();

	const auto arguments = argSeqCtx == nullptr ?
							ExpressionNodeList() :
							visitAndCast<ExpressionNodeList>(argSeqCtx);

	return buildNodeValue<Call>(ctx, identifier, arguments);
}

std::any ParseTreeVisitor::visitArgSeq(NEMParser::ArgSeqContext* ctx)
{
	ExpressionNodeList arguments;

	auto args = ctx->expr();
	arguments.reserve(args.size());

	std::transform(args.cbegin(), args.cend(),
				   std::back_inserter(arguments),
				   [&](const auto elt)
				   { return visitExpression(elt); });

	return arguments;
}

} // namespace nem::antlr