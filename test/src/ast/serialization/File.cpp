#include <iostream>
#include <sstream>

#include <catch2/catch_test_macros.hpp>

#include <nem/antlr/AstComputer.hpp>
#include <nem/ast/Serialization.hpp>

TEST_CASE("File")
{
	std::stringstream input(
	 "fn myFunction(a : int, b : int) { var v : int; }"
	 "fn otherFunction(a : int) int { return 0; }");
	std::stringstream output;

	auto data = nem::antlr::computeAstFile(input);

	serialize(data, output);
	std::cout << output.str() << std::endl;
}
