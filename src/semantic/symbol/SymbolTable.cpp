#include <nem/semantic/symbol/SymbolTable.hpp>

namespace nem::semantic
{

std::optional<Symbol*> SymbolTable::lookUp(const char* symName)
{
	auto sym = m_symbols.find(symName);
	if(sym != m_symbols.end())
		return &sym->second;

	if(m_parent)
		return (*m_parent)->lookUp(symName);

	return std::nullopt;
}

std::optional<SymbolTable*>				   SymbolTable::getParent() { return m_parent; }
std::vector<std::unique_ptr<SymbolTable>>& SymbolTable::getChildren() { return m_children; }
std::map<std::string, Symbol>&			   SymbolTable::getSymbols() { return m_symbols; }
std::vector<std::unique_ptr<SymbolError>>& SymbolTable::getErrors() { return m_errors; }

SymbolTable::SymbolTable(SymbolTable&& table) :
	m_parent(std::move(table.m_parent)),
	m_children(std::move(table.m_children)),
	m_symbols(std::move(table.m_symbols)),
	m_errors(std::move(table.m_errors))
{
	for(auto& child: m_children)
		child->m_parent = this;
}

SymbolTable::SymbolTable(std::optional<SymbolTable*> p) :
	m_parent(p) {}

} // namespace nem::semantic
