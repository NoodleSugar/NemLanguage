#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Variable")
{
	struct Data
	{
		std::string name;
	};

	auto data = GENERATE(
	 Data{"v"},
	 Data{"variable"});

	auto lValue = getAst(data.name, ruleLValue);
	REQUIRE(std::holds_alternative<IdentifierNode>(lValue));

	auto& identifier = std::get<IdentifierNode>(lValue);
	CHECK(data.name == identifier.name);
}