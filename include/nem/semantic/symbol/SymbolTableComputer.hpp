#pragma once

#include <nem/ast/Visitor.hpp>
#include <nem/semantic/symbol/SymbolTable.hpp>
#include <nem/semantic/symbol/SymbolTableBuilder.hpp>

namespace nem::semantic
{

class SymbolTableComputer : private ast::Visitor
{
public:
	SymbolTable computeTable(ast::File&);

private:
	void tryAndCatchAddSymbol(const ast::IdentifierNode&);
	void addSymbol(const ast::IdentifierNode&);
	void addSymbolRedefinitionError(const ast::IdentifierNode&, const Symbol*);
	void addUndefinedSymbolError(const ast::IdentifierNode&);

	std::optional<Symbol*> getPreviousSymbolDefinition(const std::string&);

	void visit(ast::FunctionNode&) override;
	void visit(ast::ParameterNode&) override;
	void visit(ast::BlockNode&) override;
	void visit(ast::DeclarationNode&) override;
	void visit(ast::DefinitionNode&) override;
	void visit(ast::IdentifierNode&) override;

	SymbolTableBuilder* m_currentBuilder;
};

} // namespace nem::semantic