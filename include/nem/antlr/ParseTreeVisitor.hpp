#pragma once

#include <NEMParserBaseVisitor.h>

#include "ParseTreeValue.hpp"
#include <nem/ast/Node.hpp>

namespace nem::antlr
{

class ParseTreeVisitor : public NEMParserBaseVisitor
{
public:
	std::any visitLiteralInt(NEMParser::LiteralIntContext*) override;
	std::any visitLiteralReal(NEMParser::LiteralRealContext*) override;

private:
	SourceInfo			computeSourceInfo(const antlr4::ParserRuleContext*);
	SourceInfo			computeSourceInfo(const antlr4::Token*, const antlr4::Token*);

	template<class T, class... Args>
	inline auto buildNodeValue(const antlr4::ParserRuleContext* ctx, Args&&... args)
	{
		const auto info = computeSourceInfo(ctx);
		return ParseTreeValue{ast::Node<T>(info, std::forward<Args>(args)...)};
	}
};

} // namespace nem::antlr
