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
	 Data{"1234"},
	 Data{"0b1011'0100"},
	 Data{"0o27'17"},
	 Data{"0x10CD'FFFF"},
	 Data{"0.0"},
	 Data{"1e02"},
	 Data{"0.12e-654"});

	auto expr = getAst(data.value, ruleExpr);
	REQUIRE(std::holds_alternative<LiteralNode>(expr));

	auto& lit = std::get<LiteralNode>(expr);
	CHECK(data.value == lit.value);
}
