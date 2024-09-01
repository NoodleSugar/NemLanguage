#include <nem/ast/Ast.hpp>
#include <nem/semantic/symbol/SymbolTableBuilder.hpp>
#include <nem/semantic/symbol/SymbolTableComputer.hpp>

namespace nem::semantic
{

using namespace nem::ast;

SymbolTable SymbolTableComputer::computeTable(File& file)
{
	SymbolTableBuilder builder;
	m_currentBuilder = &builder;

	Visitor::visit(file.functions);

	return builder.build();
}

void SymbolTableComputer::tryAndCatchAddSymbol(const IdentifierNode& id)
{
	const auto previousDefinition = getPreviousSymbolDefinition(id.name);
	if(!previousDefinition)
		addSymbol(id);
	else
		addSymbolRedefinitionError(id.info, *previousDefinition);
}

void SymbolTableComputer::addSymbol(const IdentifierNode& id)
{
	m_currentBuilder->addSymbol(id.info, id.name);
}

void SymbolTableComputer::addSymbolRedefinitionError(const IdentifierNode& id, const Symbol* previousDefinition)
{
	m_currentBuilder->addError(
	 std::make_unique<SymbolRedefinitionError>(id.info, previousDefinition));
}

void SymbolTableComputer::addUndefinedSymbolError(const IdentifierNode& id)
{
	m_currentBuilder->addError(
	 std::make_unique<UndefinedSymbolError>(id.info, id.name));
}

std::optional<Symbol*> SymbolTableComputer::getPreviousSymbolDefinition(const std::string& name)
{
	return m_currentBuilder->lookUp(name.c_str());
}

void SymbolTableComputer::visit(FunctionNode& funNode)
{
	tryAndCatchAddSymbol(funNode.identifier);

	auto builder	= m_currentBuilder->newChild();
	auto oldBuilder = std::exchange(m_currentBuilder, builder);
	Visitor::visit(funNode.parameters);
	Visitor::visit(funNode.instructions);
	std::exchange(m_currentBuilder, oldBuilder);
}

void SymbolTableComputer::visit(ParameterNode& paramNode)
{
	tryAndCatchAddSymbol(paramNode.identifier);
}

void SymbolTableComputer::visit(BlockNode& blockNode)
{
	auto builder	= m_currentBuilder->newChild();
	auto oldBuilder = std::exchange(m_currentBuilder, builder);
	Visitor::visit(blockNode.instructions);
	std::exchange(m_currentBuilder, oldBuilder);
}

void SymbolTableComputer::visit(DeclarationNode& declNode)
{
	tryAndCatchAddSymbol(declNode.identifier);
}

void SymbolTableComputer::visit(DefinitionNode& defNode)
{
	tryAndCatchAddSymbol(defNode.identifier);
	Visitor::visit(defNode.value);
}

void SymbolTableComputer::visit(IdentifierNode& idNode)
{
	const auto previousDefinition = getPreviousSymbolDefinition(idNode.name);

	if(!previousDefinition)
		addUndefinedSymbolError(idNode);
}

} // namespace nem::semantic