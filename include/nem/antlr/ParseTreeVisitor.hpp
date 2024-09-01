#pragma once

#include <NEMParserBaseVisitor.h>

#include "ParseTreeValue.hpp"
#include <nem/ast/Node.hpp>

namespace nem::antlr
{

class ParseTreeVisitor : public NEMParserBaseVisitor
{
public:
	std::any visitFile(NEMParser::FileContext*) override;
	std::any visitFnDef(NEMParser::FnDefContext*) override;
	std::any visitParamSeq(NEMParser::ParamSeqContext*) override;
	std::any visitParam(NEMParser::ParamContext*) override;
	std::any visitBlock(NEMParser::BlockContext*) override;
	std::any visitCall(NEMParser::CallContext*) override;
	std::any visitArgSeq(NEMParser::ArgSeqContext*) override;

	std::any visitInstrTerminated(NEMParser::InstrTerminatedContext*) override;
	std::any visitInstrBlock(NEMParser::InstrBlockContext*) override;
	std::any visitInstrVarDecl(NEMParser::InstrVarDeclContext*) override;
	std::any visitInstrVarDefWithType(NEMParser::InstrVarDefWithTypeContext*) override;
	std::any visitInstrVarDefWithoutType(NEMParser::InstrVarDefWithoutTypeContext*) override;
	std::any visitInstrAssign(NEMParser::InstrAssignContext*) override;
	std::any visitInstrAssignAdd(NEMParser::InstrAssignAddContext*) override;
	std::any visitInstrAssignSub(NEMParser::InstrAssignSubContext*) override;
	std::any visitInstrAssignMul(NEMParser::InstrAssignMulContext*) override;
	std::any visitInstrAssignDiv(NEMParser::InstrAssignDivContext*) override;
	std::any visitInstrAssignMod(NEMParser::InstrAssignModContext*) override;
	std::any visitInstrReturnValue(NEMParser::InstrReturnValueContext*) override;
	std::any visitInstrReturn(NEMParser::InstrReturnContext*) override;

	std::any visitLiteralBool(NEMParser::LiteralBoolContext*) override;
	std::any visitLiteralInt(NEMParser::LiteralIntContext*) override;
	std::any visitLiteralReal(NEMParser::LiteralRealContext*) override;

	std::any visitExprIdentifier(NEMParser::ExprIdentifierContext*) override;
	std::any visitExprParenthesis(NEMParser::ExprParenthesisContext*) override;
	std::any visitExprMinus(NEMParser::ExprMinusContext*) override;
	std::any visitExprAdd(NEMParser::ExprAddContext*) override;
	std::any visitExprSub(NEMParser::ExprSubContext*) override;
	std::any visitExprMul(NEMParser::ExprMulContext*) override;
	std::any visitExprDiv(NEMParser::ExprDivContext*) override;
	std::any visitExprMod(NEMParser::ExprModContext*) override;

	std::any visitTypeWithConst(NEMParser::TypeWithConstContext*) override;
	std::any visitTypeBool(NEMParser::TypeBoolContext*) override;
	std::any visitTypeInt(NEMParser::TypeIntContext*) override;
	std::any visitTypeUInt(NEMParser::TypeUIntContext*) override;
	std::any visitTypeReal(NEMParser::TypeRealContext*) override;

private:
	ParseTreeValue visitTreeValue(antlr4::ParserRuleContext*);

	ast::FunctionNode		 visitFunction(antlr4::ParserRuleContext*);
	ast::ParameterNode		 visitParameter(antlr4::ParserRuleContext*);
	ast::ExpressionNode		 visitExpression(antlr4::ParserRuleContext*);
	ast::InstructionNode	 visitInstruction(antlr4::ParserRuleContext*);
	ast::UnqualifiedTypeNode visitUnqualifiedType(antlr4::ParserRuleContext*);
	ast::TypeNode			 visitType(antlr4::ParserRuleContext*);

	SourceInfo			computeSourceInfo(const antlr4::ParserRuleContext*);
	SourceInfo			computeSourceInfo(const antlr4::Token*, const antlr4::Token*);
	ast::IdentifierNode computeIdentifierNode(antlr4::tree::TerminalNode*);

	ParseTreeValue buildExprArith(ast::ArithOp, antlr4::ParserRuleContext*, NEMParser::ExprContext*, NEMParser::ExprContext*);
	ParseTreeValue buildInstrAssign(ast::AssignOp, antlr4::ParserRuleContext*, antlr4::tree::TerminalNode*, NEMParser::ExprContext*);

	template<class T>
	inline auto visitAndCast(antlr4::ParserRuleContext* ctx)
	{
		auto result = ctx->accept(this);
		return std::any_cast<T>(result);
	}

	template<class T, class... Args>
	inline auto buildNodeValue(const antlr4::ParserRuleContext* ctx, Args&&... args)
	{
		const auto info = computeSourceInfo(ctx);
		return ParseTreeValue{ast::Node<T>(info, std::forward<Args>(args)...)};
	}
};

} // namespace nem::antlr
