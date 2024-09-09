#include "Includes.hpp"

TEST_CASE("Function")
{
	struct Data
	{
		std::string code;
		std::string name;
	};

	auto data = GENERATE(
	 Data{"fn func() int { }", "func"});

	auto ast = Parser(data.code).parse(ParserRule::fnDef);
	REQUIRE(std::holds_alternative<Function>(ast));

	auto& fun = std::get<Function>(ast);
	CHECK(data.name == fun.name.string);
}

TEST_CASE("Block")
{
	struct Data
	{
		size_t		instrCount;
		std::string code;
	};

	auto data = GENERATE(
	 Data{0, "{ }"},
	 Data{3, "{"
			 "	return 0;"
			 "  return 1;"
			 "  return 2;"
			 "}"});

	auto ast = Parser(data.code).parse(ParserRule::block);
	REQUIRE(std::holds_alternative<Block>(ast));

	auto& block = std::get<Block>(ast);
	CHECK(data.instrCount == block.instructions.size());
}
