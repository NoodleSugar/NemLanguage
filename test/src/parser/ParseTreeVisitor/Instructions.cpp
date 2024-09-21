#include "Includes.hpp"

TEST_CASE("If")
{
	struct Data
	{
		std::string code;
		bool		hasElse;
	};

	auto data = GENERATE(
	 Data{"if(true) return 1;", false},
	 Data{"if(true) return 1; else return 0;", true});

	auto ast = Parser(data.code).parse(ParserRule::instr);
	REQUIRE(std::holds_alternative<If>(ast));

	auto ifInstr = std::get<If>(ast);
	CHECK(data.hasElse == ifInstr.else_.has_value());
}

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
