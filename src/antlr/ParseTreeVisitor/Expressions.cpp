#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>

namespace nem::antlr
{

using namespace nem::ast;

std::any ParseTreeVisitor::visitLiteralInt(NEMParser::LiteralIntContext* ctx)
{
	const auto value = ctx->L_INT()->getText();

	return buildNodeValue<Literal>(ctx, value);
}

} // namespace nem::antlr
