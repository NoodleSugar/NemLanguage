#pragma once

#include <cstring>

#include <catch2/catch_test_macros.hpp>
#include <catch2/generators/catch_generators.hpp>

#include <antlr4-runtime.h>

#include <NEMLexer.h>
#include <NEMParser.h>

#include <nem/ast/Ast.hpp>

#include <nem/antlr/ComputeAstVisitor.hpp>
#include <nem/ast/ImplNode.hpp>

using antlr4::ANTLRInputStream;
using antlr4::CommonTokenStream;
using antlr4::ParserRuleContext;

using nem::antlr::NEMLexer;
using nem::antlr::NEMParser;

template<class T, class Ptr>
inline T& derefPtr(Ptr& ptr)
{
	return static_cast<T&>(*ptr);
}

class AntlrVisitorFixture
{
protected:
	nem::antlr::ComputeAstVisitor visitor;

	template<class T, class Fn>
	T getAst(const std::string& str, Fn getRule)
	{
		ANTLRInputStream  input(str);
		NEMLexer		  lexer(&input);
		CommonTokenStream tokens(&lexer);
		NEMParser		  parser(&tokens);

		return std::any_cast<T>(getRule(parser)->accept(&visitor));
	}

	static constexpr auto ruleFunctionCall =
	 [](NEMParser& parser)
	{ return parser.fnCall(); };

	static constexpr auto ruleType =
	 [](NEMParser& parser)
	{ return parser.type(); };

	static constexpr auto ruleExpr =
	 [](NEMParser& parser)
	{ return parser.expr(); };

	static constexpr auto ruleFile =
	 [](NEMParser& parser)
	{ return parser.file(); };

	static constexpr auto ruleParam =
	 [](NEMParser& parser)
	{ return parser.param(); };

	static constexpr auto ruleFnDef =
	 [](NEMParser& parser)
	{ return parser.fnDef(); };

	static constexpr auto ruleInstr =
	 [](NEMParser& parser)
	{ return parser.instr(); };

	static constexpr auto ruleLValue =
	 [](NEMParser& parser)
	{ return parser.lValue(); };
};