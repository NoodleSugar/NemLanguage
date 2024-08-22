#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Literal")
{
	struct Data
	{
		std::string value;
	};

	auto data = GENERATE(
	 Data{"0"},
	 Data{"0001"},
	 Data{"1"},
	 Data{"1234"});

	auto expr = getAst(data.value, ruleExpr);
	REQUIRE(std::holds_alternative<LiteralNode>(expr));

	auto& lit = std::get<LiteralNode>(expr);
	CHECK(data.value == lit.value);
}
