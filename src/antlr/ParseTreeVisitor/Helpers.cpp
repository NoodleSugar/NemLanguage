#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/util/VisitorHelper.hpp>

namespace nem::antlr
{

using namespace nem::ast;

constexpr auto typeNodeVisitor =
 VisitorOverload{
  [](const NativeTypeNode& t) -> TypeNode
  { return t; },
  [](const auto& t) -> TypeNode
  { throw std::domain_error("Excepted a Type"); }};

constexpr auto expressionNodeVisitor =
 VisitorOverload{
  [](const LiteralNode& e) -> ExpressionNode
  { return e; },
  [](const auto& e) -> ExpressionNode
  { throw std::domain_error("Excepted an Expression"); }};

ParseTreeValue ParseTreeVisitor::visitTreeValue(antlr4::ParserRuleContext* ctx)
{
	return visitAndCast<ParseTreeValue>(ctx);
}
ExpressionNode ParseTreeVisitor::visitExpression(antlr4::ParserRuleContext* ctx)
{
	return std::visit(expressionNodeVisitor, visitTreeValue(ctx));
}

TypeNode ParseTreeVisitor::visitType(antlr4::ParserRuleContext* ctx)
{
	return std::visit(typeNodeVisitor, visitTreeValue(ctx));
}

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

IdentifierNode ParseTreeVisitor::computeIdentifierNode(antlr4::tree::TerminalNode* id)
{
	const auto text	  = id->getText();
	const auto size	  = text.size();
	const auto symbol = id->getSymbol();
	const auto line	  = symbol->getLine();
	const auto column = symbol->getCharPositionInLine();
	const auto info	  = SourceInfo{
	   {line, column},
	   {line, column + size}};

	return IdentifierNode(info, text);
}

} // namespace nem::antlr
