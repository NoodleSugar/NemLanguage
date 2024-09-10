#pragma once

#include <type_traits>

#include <NEMParser.h>

#include "ParseTreeVisitor.hpp"

#define NEM_PARSER_LIST_OF_RULE \
	file,                       \
	 topLevel,                  \
	 fnDef,                     \
	 block,                     \
	 call,                      \
	 instr,                     \
	 terminatedInstr,           \
	 expr,                      \
	 literal,                   \
	 type

#define NEM_PARSER_DEFINE_PARSER_RULE(R) \
	inline antlr4::ParserRuleContext* R(NEMParser& p) { return p.R(); }

namespace nem::parser
{

using namespace nem::antlr;

namespace ParserRule
{

using Type = std::add_pointer_t<antlr4::ParserRuleContext*(NEMParser&)>;

NEM_FOR_EACH(NEM_PARSER_DEFINE_PARSER_RULE, NEM_PARSER_LIST_OF_RULE)

}; // namespace ParserRule

} // namespace nem::parser
