#include <algorithm>

#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitFile(NEMParser::FileContext* ctx)
{
	const auto topLevelCtx = ctx->topLevel();

	FunctionNodeList functions;
	functions.reserve(topLevelCtx.size());
	std::transform(topLevelCtx.cbegin(), topLevelCtx.cend(),
				   std::back_inserter(functions),
				   [&](const auto elt)
				   { return visitFunction(elt); });

	return buildNodeValue<File>(ctx, functions);
}

} // namespace nem::antlr