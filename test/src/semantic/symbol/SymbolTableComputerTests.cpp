#include <catch2/catch_test_macros.hpp>

#include <fstream>
#include <iostream>

#include <nem/antlr/AstComputer.hpp>
#include <nem/semantic/symbol/SymbolTableComputer.hpp>

using namespace nem::semantic;
using namespace nem::antlr;
using namespace nem::ast;

TEST_CASE("Function")
{
	std::fstream file("../../../resources/symbol.nem");

	if(!file.is_open())
		FAIL("File not found");

	auto ast = nem::antlr::computeAstFile(file);

	SymbolTableComputer symTableComputer;

	auto symTable = symTableComputer.computeTable(ast);
	for(const auto& child: symTable.getChildren())
	{
		for(const auto& error: child->getErrors())
		{
			std::cout << 'l'
					  << error->info.start.line
					  << 'c'
					  << error->info.start.column
					  << ':'
					  << 'l'
					  << error->info.stop.line
					  << 'c'
					  << error->info.stop.column
					  << ' ';
			switch(error->type)
			{
			case SymbolError::Type::Undefined:
				std::cout << "Undefined symbol '"
						  << static_cast<const UndefinedSymbolError&>(*error).name
						  << '\'';
				break;
			case SymbolError::Type::Redefinition:

				std::cout << "Symbol redefinition of '"
						  << static_cast<const SymbolRedefinitionError&>(*error).symbol->name
						  << '\'';

				break;
			}

			std::cout << std::endl;
		}
	}
}