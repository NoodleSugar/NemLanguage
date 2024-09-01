#pragma once

#include <map>
#include <memory>
#include <optional>
#include <vector>

#include "Symbol.hpp"
#include "SymbolError.hpp"

namespace nem::semantic
{

class SymbolTable
{
public:
	std::optional<Symbol*> lookUp(const char*);

	std::optional<SymbolTable*>				   getParent();
	std::vector<std::unique_ptr<SymbolTable>>& getChildren();
	std::map<std::string, Symbol>&			   getSymbols();
	std::vector<std::unique_ptr<SymbolError>>& getErrors();

	SymbolTable(SymbolTable&&);
	SymbolTable(const SymbolTable&) = delete;

protected:
	SymbolTable(std::optional<SymbolTable*> parent = std::nullopt);

	std::optional<SymbolTable*>				  m_parent;
	std::vector<std::unique_ptr<SymbolTable>> m_children;

	std::map<std::string, Symbol>			  m_symbols;
	std::vector<std::unique_ptr<SymbolError>> m_errors;
};

} // namespace nem::semantic