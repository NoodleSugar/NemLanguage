#include "Includes.hpp"

TEST_CASE("Function")
{
	struct Data
	{
		std::string code;
		std::string name;
		size_t		paramsCount;
	};

	auto data = GENERATE(
	 Data{"fn func() int { }", "func", 0},
	 Data{"fn func(a : int, b : bool) int { }", "func", 2});

	auto ast = Parser(data.code).parse(ParserRule::fnDef);
	REQUIRE(std::holds_alternative<Function>(ast));

	auto& fun = std::get<Function>(ast);
	CHECK(data.name == fun.name.string);
	CHECK(data.paramsCount == fun.params.size());
}

TEST_CASE("Parameter")
{
	struct Data
	{
		std::string code;
	};

	auto data = GENERATE(
	 Data{"varB : bool"},
	 Data{"varI : int"},
	 Data{"varR : real"});

	auto ast = Parser(data.code).parse(ParserRule::param);
	REQUIRE(std::holds_alternative<Parameter>(ast));
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

TEST_CASE("Call")
{
	struct Data
	{
		std::string code;
		std::string name;
		size_t		argsCount;
	};

	auto data = GENERATE(
	 Data{"f()", "f", 0},
	 Data{"g(1, a)", "g", 2});

	auto ast = Parser(data.code).parse(ParserRule::call);
	REQUIRE(std::holds_alternative<Call>(ast));

	auto& call = std::get<Call>(ast);
	CHECK(data.name == call.name.string);
	CHECK(data.argsCount == call.args.size());
}
