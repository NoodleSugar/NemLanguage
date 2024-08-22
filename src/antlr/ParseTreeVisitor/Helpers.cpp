#include <nem/antlr/ParseTreeVisitor.hpp>

namespace nem::antlr
{

SourceInfo ParseTreeVisitor::computeSourceInfo(const antlr4::ParserRuleContext* ctx)
{
	const auto start = ctx->getStart();
	const auto stop	 = ctx->getStop();

	return computeSourceInfo(start, stop);
}

SourceInfo ParseTreeVisitor::computeSourceInfo(const antlr4::Token* start, const antlr4::Token* stop)
{
	return SourceInfo{
	 {start->getLine(), start->getCharPositionInLine()},
	 {stop->getLine(), stop->getCharPositionInLine()}};
}


} // namespace nem::antlr
