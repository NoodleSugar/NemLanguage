#pragma once

#include "SymbolTable.hpp"

namespace nem::semantic
{

class SymbolTableBuilder : public SymbolTable
{
public:
	SymbolTable build();

	SymbolTableBuilder* newChild();

	void addSymbol(SourceInfo, const std::string&);

	void addError(std::unique_ptr<SymbolError>&&);

	SymbolTableBuilder()						  = default;
	SymbolTableBuilder(const SymbolTableBuilder&) = delete;
	SymbolTableBuilder(SymbolTableBuilder&&)	  = delete;
};

} // namespace nem::semantic
