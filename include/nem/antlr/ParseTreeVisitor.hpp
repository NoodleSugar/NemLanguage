#pragma once

#include <NEMParserBaseVisitor.h>

#include "ParseTreeValue.hpp"
#include <nem/ast/Node.hpp>

namespace nem::antlr
{

class ParseTreeVisitor : public NEMParserBaseVisitor
{
public:
	std::any visitInstrTerminated(NEMParser::InstrTerminatedContext*) override;
	std::any visitInstrVarDecl(NEMParser::InstrVarDeclContext*) override;
	std::any visitInstrVarDefWithType(NEMParser::InstrVarDefWithTypeContext*) override;
	std::any visitInstrVarDefWithoutType(NEMParser::InstrVarDefWithoutTypeContext*) override;

	std::any visitLiteralInt(NEMParser::LiteralIntContext*) override;
	std::any visitLiteralReal(NEMParser::LiteralRealContext*) override;

	std::any visitTypeInt(NEMParser::TypeIntContext*) override;
	std::any visitTypeUInt(NEMParser::TypeUIntContext*) override;
	std::any visitTypeReal(NEMParser::TypeRealContext*) override;

private:
	ParseTreeValue visitTreeValue(antlr4::ParserRuleContext*);

	ast::ExpressionNode		 visitExpression(antlr4::ParserRuleContext*);
	ast::TypeNode			 visitType(antlr4::ParserRuleContext*);

	SourceInfo			computeSourceInfo(const antlr4::ParserRuleContext*);
	SourceInfo			computeSourceInfo(const antlr4::Token*, const antlr4::Token*);
	ast::IdentifierNode computeIdentifierNode(antlr4::tree::TerminalNode*);

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
