#include <algorithm>

#include <nem/antlr/ParseTreeVisitor.hpp>
#include <nem/ast/Ast.hpp>
#include <nem/util/VisitorHelper.hpp>

namespace nem::antlr
{

using namespace nem::ast;

constexpr auto functionNodeVisitor =
 VisitorOverload{
  [](const FunctionNode& f) -> FunctionNode
  { return f; },
  [](const auto& t) -> FunctionNode
  { throw std::domain_error("Excepted a Function"); }};

constexpr auto parameterNodeVisitor =
 VisitorOverload{
  [](const ParameterNode& t) -> ParameterNode
  { return t; },
  [](const auto& t) -> ParameterNode
  { throw std::domain_error("Excepted a Parameter"); }};

constexpr auto unqualifiedTypeNodeVisitor =
 VisitorOverload{
  [](const NativeTypeNode& t) -> UnqualifiedTypeNode
  { return t; },
  [](const auto& t) -> UnqualifiedTypeNode
  { throw std::domain_error("Excepted an Unqualified Type"); }};

constexpr auto typeNodeVisitor =
 VisitorOverload{
  [](const NativeTypeNode& t) -> TypeNode
  { return t; },
  [](const ConstTypeNode& t) -> TypeNode
  { return t; },
  [](const auto& t) -> TypeNode
  { throw std::domain_error("Excepted a Type"); }};

constexpr auto expressionNodeVisitor =
 VisitorOverload{
  [](const CallNode& e) -> ExpressionNode
  { return e; },
  [](const IdentifierNode& e) -> ExpressionNode
  { return e; },
  [](const LiteralNode& e) -> ExpressionNode
  { return e; },
  [](const MinusNode& e) -> ExpressionNode
  { return e; },
  [](const ArithmeticNode& e) -> ExpressionNode
  { return e; },
  [](const auto& e) -> ExpressionNode
  { throw std::domain_error("Excepted an Expression"); }};

constexpr auto instructionNodeVisitor =
 VisitorOverload{
  [](const CallNode& i) -> InstructionNode
  { return i; },
  [](const DeclarationNode& i) -> InstructionNode
  { return i; },
  [](const DefinitionNode& i) -> InstructionNode
  { return i; },
  [](const AssignmentNode& i) -> InstructionNode
  { return i; },
  [](const ReturnNode& i) -> InstructionNode
  { return i; },
  [](const auto& i) -> InstructionNode
  { throw std::domain_error("Excepted an Instruction"); }};

ParseTreeValue ParseTreeVisitor::visitTreeValue(antlr4::ParserRuleContext* ctx)
{
	return visitAndCast<ParseTreeValue>(ctx);
}

FunctionNode ParseTreeVisitor::visitFunction(antlr4::ParserRuleContext* ctx)
{
	return std::visit(functionNodeVisitor, visitTreeValue(ctx));
}

ParameterNode ParseTreeVisitor::visitParameter(antlr4::ParserRuleContext* ctx)
{
	return std::visit(parameterNodeVisitor, visitTreeValue(ctx));
}

ExpressionNode ParseTreeVisitor::visitExpression(antlr4::ParserRuleContext* ctx)
{
	return std::visit(expressionNodeVisitor, visitTreeValue(ctx));
}

InstructionNode ParseTreeVisitor::visitInstruction(antlr4::ParserRuleContext* ctx)
{
	return std::visit(instructionNodeVisitor, visitTreeValue(ctx));
}

UnqualifiedTypeNode ParseTreeVisitor::visitUnqualifiedType(antlr4::ParserRuleContext* ctx)
{
	return std::visit(unqualifiedTypeNodeVisitor, visitTreeValue(ctx));
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

ParseTreeValue ParseTreeVisitor::buildExprArith(ArithOp					   op,
												antlr4::ParserRuleContext* globalCtx,
												NEMParser::ExprContext*	   leftCtx,
												NEMParser::ExprContext*	   rightCtx)
{
	const auto left	 = makeExpressionNodePtr(visitExpression(leftCtx));
	const auto right = makeExpressionNodePtr(visitExpression(rightCtx));

	return buildNodeValue<Arithmetic>(globalCtx, op, left, right);
}

ParseTreeValue ParseTreeVisitor::buildInstrAssign(AssignOp					  op,
												  antlr4::ParserRuleContext*  globalCtx,
												  antlr4::tree::TerminalNode* identifier,
												  NEMParser::ExprContext*	  exprCtx)
{
	auto left  = computeIdentifierNode(identifier);
	auto right = visitExpression(exprCtx);

	return buildNodeValue<Assignment>(globalCtx, op, left, right);
}

} // namespace nem::antlr
