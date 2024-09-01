
#include <antlr4-runtime.h>

#include <NEMLexer.h>
#include <NEMParser.h>

#include <nem/antlr/AstComputer.hpp>
#include <nem/antlr/ParseTreeValue.hpp>
#include <nem/antlr/ParseTreeVisitor.hpp>

namespace nem::antlr
{

ast::FileNode computeAstFile(std::istream& inStream)
{
	antlr4::ANTLRInputStream  input(inStream);
	NEMLexer				  lexer(&input);
	antlr4::CommonTokenStream tokens(&lexer);
	NEMParser				  parser(&tokens);

	ParseTreeVisitor visitor;

	auto anyValue		= parser.file()->accept(&visitor);
	auto parseTreeValue = std::any_cast<ParseTreeValue>(anyValue);
	return std::get<ast::FileNode>(parseTreeValue);
}

} // namespace nem::antlr
