#pragma once

#include <cstring>

#include <catch2/catch_test_macros.hpp>
#include <catch2/generators/catch_generators.hpp>

#include <antlr4-runtime.h>

#include <NEMLexer.h>
#include <NEMParser.h>

#include <nem/ast/Ast.hpp>

#include <nem/antlr/ParseTreeVisitor.hpp>

using antlr4::ANTLRInputStream;
using antlr4::CommonTokenStream;
using antlr4::ParserRuleContext;

using nem::antlr::NEMLexer;
using nem::antlr::NEMParser;

using namespace nem::ast;

class ParseTreeVisitorFixture
{
protected:
	nem::antlr::ParseTreeVisitor visitor;

	template<class Fn>
	auto getAst(const std::string& str, Fn getRule)
	{
		ANTLRInputStream  input(str);
		NEMLexer		  lexer(&input);
		CommonTokenStream tokens(&lexer);
		NEMParser		  parser(&tokens);

		auto rule = getRule(parser);
		auto ast  = rule->accept(&visitor);
		return std::any_cast<nem::antlr::ParseTreeValue>(ast);
	}


	static constexpr auto ruleType =
	 [](NEMParser& parser)
	{ return parser.type(); };

	static constexpr auto ruleExpr =
	 [](NEMParser& parser)
	{ return parser.expr(); };
};
