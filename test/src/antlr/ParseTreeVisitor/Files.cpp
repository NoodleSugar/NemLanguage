#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "File")
{
	struct Data
	{
		size_t		funcCount;
		std::string code;
	};

	auto data = GENERATE(
	 Data{1, "fn myFunction() { }"},
	 Data{2, "fn myFunction(a : int, b : int) { var v : int; }"
			 "fn otherFunction(a : int) {  }"});

	auto ast = getAst(data.code, ruleFile);
	REQUIRE(std::holds_alternative<FileNode>(ast));

	auto& file = std::get<FileNode>(ast);
	CHECK(data.funcCount == file.functions.size());
}