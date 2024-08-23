#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "NativeType")
{
	struct Data
	{
		std::string	   code;
		NativeTypeEnum type;
	};

	auto data = GENERATE(
	 Data{"int", NativeTypeEnum::Int},
	 Data{"uint", NativeTypeEnum::UInt},
	 Data{"real", NativeTypeEnum::Real});

	auto type = getAst(data.code, ruleType);
	REQUIRE(std::holds_alternative<NativeTypeNode>(type));

	auto& nat = std::get<NativeTypeNode>(type);
	CHECK(data.type == nat.value);
}
