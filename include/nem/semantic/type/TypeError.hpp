#pragma once

#include <nem/ast/Node.hpp>

namespace nem::semantic
{

enum class SymbolType
{
	Function,
	Variable
};

enum class SymbolUsage
{
	Call,
	Arithmetic
};

struct TypeError
{
	SymbolType	type;
	SymbolUsage usage;

	nem::ast::NodePtr dataType;

	virtual ~SymbolError() {}

protected:
	SymbolError(Type t) :
		type(t) {}
}

} // namespace nem::semantic