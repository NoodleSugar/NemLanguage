#include <algorithm>

#include "nem/parser/ParseTreeVisitor.hpp"

namespace nem::parser
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitFile(NEMParser::FileContext* ctx)
{
	const auto topLevelCtx = ctx->topLevel();

	FunctionList functions;
	functions.reserve(topLevelCtx.size());

	std::transform(topLevelCtx.cbegin(), topLevelCtx.cend(),
				   std::back_inserter(functions),
				   [&](const auto elt)
				   { return visitTreeValue<Function>(elt); });

	return buildParseTreeValue<File>(ctx, functions);
}

} // namespace nem::parser
