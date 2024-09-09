#include "Includes.hpp"

TEST_CASE("File")
{
	struct Data
	{
		size_t		funcCount;
		std::string code;
	};

	auto data = GENERATE(
	 Data{2, "fn f() int { }"
			 "fn g() real{ }"});

	auto ast = Parser(data.code).parse(ParserRule::file);
	REQUIRE(std::holds_alternative<File>(ast));

	auto& file = std::get<File>(ast);
	CHECK(data.funcCount == file.functions.size());
}
