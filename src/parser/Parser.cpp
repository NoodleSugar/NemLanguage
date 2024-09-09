#include "nem/parser/Parser.hpp"

namespace nem::parser
{

Parser::Parser(std::string_view in) :
	antlrInput(in),
	antlrLexer(&antlrInput),
	antlrTokens(&antlrLexer),
	antlrParser(&antlrTokens) {}

Parser::Parser(std::istream& in) :
	antlrInput(in),
	antlrLexer(&antlrInput),
	antlrTokens(&antlrLexer),
	antlrParser(&antlrTokens) {}

AstElement Parser::parse(ParserRule::Type rule)
{
	return std::any_cast<AstElement>(visitor.visit(rule(antlrParser)));
}

} // namespace nem::parser
