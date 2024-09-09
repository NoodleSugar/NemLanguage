#pragma once

#include <NEMLexer.h>
#include <NEMParser.h>

#include "ParseTreeVisitor.hpp"
#include "ParserRule.hpp"

namespace nem::parser
{

using namespace nem::antlr;

class Parser
{
	ParseTreeVisitor visitor;

	antlr4::ANTLRInputStream  antlrInput;
	NEMLexer				  antlrLexer;
	antlr4::CommonTokenStream antlrTokens;
	NEMParser				  antlrParser;

public:
	explicit Parser(std::string_view);
	explicit Parser(std::istream&);

	AstElement parse(ParserRule::Type);
};

} // namespace nem::parser
