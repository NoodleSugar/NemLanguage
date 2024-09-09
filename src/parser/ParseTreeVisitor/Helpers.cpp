#include <algorithm>

#include "nem/parser/ParseTreeVisitor.hpp"
#include "nem/util/Macros.hpp"
#include "nem/util/VisitorHelper.hpp"

namespace nem::parser
{

using namespace nem::ast;

#define NEM_IR_DEFINE_INSTRUCTION_VISITOR_METHOD(I) \
	[](const I& i) -> Instruction { return i; },

#define NEM_IR_DEFINE_EXPRESSION_VISITOR_METHOD(E) \
	[](const E& e) -> Expression { return e; },

#define NEM_IR_DEFINE_TYPE_VISITOR_METHOD(T) \
	[](const T& t) -> Type { return t; },

// clang-format off

constexpr auto instructionVisitor = VisitorOverload
{
  NEM_FOR_EACH(NEM_IR_DEFINE_INSTRUCTION_VISITOR_METHOD, NEM_AST_LIST_OF_INSTRUCTION_NODES)
  [](const auto& i) -> Instruction { throw std::domain_error("Excepted an Instruction"); }
};

constexpr auto expressionVisitor = VisitorOverload
{
  NEM_FOR_EACH(NEM_IR_DEFINE_EXPRESSION_VISITOR_METHOD, NEM_AST_LIST_OF_EXPRESSION_NODES)
  [](const auto& e) -> Expression { throw std::domain_error("Excepted an Expression"); }
};

constexpr auto typeVisitor = VisitorOverload
{
  NEM_FOR_EACH(NEM_IR_DEFINE_TYPE_VISITOR_METHOD, NEM_AST_LIST_OF_TYPE_NODES)
  [](const auto& t) -> Type { throw std::domain_error("Excepted a Type"); }
};

// clang-format on

Expression ParseTreeVisitor::visitExpression(antlr4::ParserRuleContext* ctx)
{
	return std::visit(expressionVisitor, visitTreeValue(ctx));
}

Instruction ParseTreeVisitor::visitInstruction(antlr4::ParserRuleContext* ctx)
{
	return std::visit(instructionVisitor, visitTreeValue(ctx));
}

Type ParseTreeVisitor::visitType(antlr4::ParserRuleContext* ctx)
{
	return std::visit(typeVisitor, visitTreeValue(ctx));
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

Identifier ParseTreeVisitor::computeIdentifier(antlr4::tree::TerminalNode* id)
{
	const auto text	  = id->getText();
	const auto size	  = text.size();
	const auto symbol = id->getSymbol();
	const auto line	  = symbol->getLine();
	const auto column = symbol->getCharPositionInLine();
	const auto info	  = SourceInfo{
	   {line, column},
	   {line, column + size}};

	return Identifier{{info}, text};
}

} // namespace nem::parser
