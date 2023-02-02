#pragma once

#include <NEMParserBaseVisitor.h>

#include <nem/ast/ForwardAst.hpp>
#include <nem/ast/Node.hpp>

namespace nem::antlr
{

using antlr::NEMParser;
using antlr::NEMParserBaseVisitor;

// TODO Add Semantic Analysis

class ComputeAstVisitor : public NEMParserBaseVisitor
{
	template<class Context>
	inline auto nodeFromVisit(Context* ctx)
	{
		auto a = ctx->accept(this);
		return std::any_cast<ast::Node::Ptr>(a);
	}

	ast::Node::Ptr computeExprArith(ast::ArithOp, NEMParser::ExprContext*, NEMParser::ExprContext*);
	ast::Node::Ptr computeInstrAssign(ast::AssignOp, NEMParser::LValueContext*, NEMParser::ExprContext*);

public:
	std::any visitFile(NEMParser::FileContext*) override;
	std::any visitFnDef(NEMParser::FnDefContext*) override;
	std::any visitParamSeq(NEMParser::ParamSeqContext*) override;
	std::any visitParam(NEMParser::ParamContext*) override;

	std::any visitBlock(NEMParser::BlockContext*) override;
	std::any visitInstrTerminated(NEMParser::InstrTerminatedContext*) override;
	std::any visitInstrBlock(NEMParser::InstrBlockContext*) override;
	std::any visitInstrVarDecl(NEMParser::InstrVarDeclContext*) override;
	std::any visitInstrVarDefWithType(NEMParser::InstrVarDefWithTypeContext*) override;
	std::any visitInstrVarDefWithoutType(NEMParser::InstrVarDefWithoutTypeContext*) override;
	std::any visitInstrAssignSimple(NEMParser::InstrAssignSimpleContext*) override;
	std::any visitInstrAssignAdd(NEMParser::InstrAssignAddContext*) override;
	std::any visitInstrAssignSub(NEMParser::InstrAssignSubContext*) override;
	std::any visitInstrAssignMul(NEMParser::InstrAssignMulContext*) override;
	std::any visitInstrAssignDiv(NEMParser::InstrAssignDivContext*) override;
	std::any visitInstrAssignMod(NEMParser::InstrAssignModContext*) override;
	std::any visitInstrReturnWithValue(NEMParser::InstrReturnWithValueContext*) override;
	std::any visitInstrReturnWithoutValue(NEMParser::InstrReturnWithoutValueContext*) override;

	std::any visitFnCall(NEMParser::FnCallContext*) override;

	std::any visitLiteralInteger(NEMParser::LiteralIntegerContext*) override;
	std::any visitExprParenthesis(NEMParser::ExprParenthesisContext*) override;
	std::any visitExprMinus(NEMParser::ExprMinusContext*) override;
	std::any visitExprAdd(NEMParser::ExprAddContext*) override;
	std::any visitExprSub(NEMParser::ExprSubContext*) override;
	std::any visitExprMul(NEMParser::ExprMulContext*) override;
	std::any visitExprDiv(NEMParser::ExprDivContext*) override;
	std::any visitExprMod(NEMParser::ExprModContext*) override;

	std::any visitTypeWithConst(NEMParser::TypeWithConstContext*) override;
	std::any visitTypeVoid(NEMParser::TypeVoidContext*) override;
	std::any visitTypeInteger(NEMParser::TypeIntegerContext*) override;

	std::any visitVariable(NEMParser::VariableContext*) override;
};

} // namespace nem::antlr