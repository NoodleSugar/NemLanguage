#include <nem/semantic/symbol/SymbolTableBuilder.hpp>

namespace nem::semantic
{

SymbolTable SymbolTableBuilder::build()
{
	return SymbolTable(std::move(*this));
}

SymbolTableBuilder* SymbolTableBuilder::newChild()
{
	auto child		= std::make_unique<SymbolTableBuilder>();
	auto result		= child.get();
	child->m_parent = std::make_optional(this);

	m_children.emplace_back(std::move(child));

	return result;
}

void SymbolTableBuilder::addSymbol(SourceInfo info, const std::string& name)
{
	m_symbols.insert({name, Symbol{info, name}});
}

void SymbolTableBuilder::addError(std::unique_ptr<SymbolError>&& error)
{
	m_errors.emplace_back(std::move(error));
}

} // namespace nem::semantic
