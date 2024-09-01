#pragma once

#include "Symbol.hpp"

namespace nem::semantic
{

struct SymbolError
{
	enum class Type
	{
		Undefined,
		Redefinition
	};

	const Type		 type;
	const SourceInfo info;

	virtual ~SymbolError() {}

protected:
	SymbolError(Type t, SourceInfo i) :
		type(t), info(i) {}
};

struct UndefinedSymbolError : public SymbolError
{
	std::string name;

	UndefinedSymbolError(SourceInfo i, const std::string& n) :
		SymbolError(Type::Undefined, i), name(n) {}
};

struct SymbolRedefinitionError : public SymbolError
{
	const Symbol* symbol;

	SymbolRedefinitionError(SourceInfo i, const Symbol* s) :
		SymbolError(Type::Redefinition, i), symbol(s) {}
};

} // namespace nem::semantic