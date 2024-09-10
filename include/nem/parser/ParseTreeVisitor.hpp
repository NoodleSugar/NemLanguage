#pragma once

#include <NEMParserBaseVisitor.h>

#include "nem/ast/Ast.hpp"

namespace nem::parser
{

using antlr::NEMParser;
using antlr::NEMParserBaseVisitor;
using nem::ast::AstElement;

class ParseTreeVisitor : public NEMParserBaseVisitor
{
public:
	std::any visitFile(NEMParser::FileContext*) override;
	std::any visitFnDef(NEMParser::FnDefContext*) override;
	std::any visitBlock(NEMParser::BlockContext*) override;

	std::any visitInstrTerminated(NEMParser::InstrTerminatedContext*) override;
	std::any visitInstrReturnValue(NEMParser::InstrReturnValueContext*) override;

	std::any visitLiteralInt(NEMParser::LiteralIntContext*) override;
	std::any visitLiteralReal(NEMParser::LiteralRealContext*) override;

	std::any visitTypeInt(NEMParser::TypeIntContext*) override;
	std::any visitTypeReal(NEMParser::TypeRealContext*) override;

private:
	template<class T = AstElement>
	T visitTreeValue(antlr4::ParserRuleContext* ctx)
	{
		return std::get<T>(visitTreeValue(ctx));
	}

	template<>
	AstElement visitTreeValue<AstElement>(antlr4::ParserRuleContext* ctx)
	{
		auto result = ctx->accept(this);
		return std::any_cast<AstElement>(result);
	}

	ast::Expression	 visitExpression(antlr4::ParserRuleContext*);
	ast::Instruction visitInstruction(antlr4::ParserRuleContext*);
	ast::Type		 visitType(antlr4::ParserRuleContext*);

	ast::SourceInfo computeSourceInfo(const antlr4::ParserRuleContext*);
	ast::SourceInfo computeSourceInfo(const antlr4::Token*, const antlr4::Token*);
	ast::Identifier computeIdentifier(antlr4::tree::TerminalNode*);

	template<class T, class... Args>
	inline auto buildAstElement(const antlr4::ParserRuleContext* ctx, Args&&... args)
	{
		static_assert(std::is_base_of_v<ast::Node, T>,
					  "Template argument T should be derived from Node class");

		const auto info = computeSourceInfo(ctx);
		return AstElement{T{{info}, std::forward<Args>(args)...}};
	}
};

} // namespace nem::parser
