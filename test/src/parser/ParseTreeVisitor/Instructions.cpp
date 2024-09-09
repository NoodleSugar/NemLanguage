#include "Includes.hpp"

TEST_CASE("Return")
{
	struct Data
	{
		std::string code;
	};

	auto data = GENERATE(
	 Data{"return 1;"});

	auto ast = Parser(data.code).parse(ParserRule::instr);
	REQUIRE(std::holds_alternative<Return>(ast));
}
