#include "Includes.hpp"

TEST_CASE("NativeType")
{
	struct Data
	{
		std::string code;
		NativeTypeE type;
	};

	auto data = GENERATE(
	 Data{"bool", NativeTypeE::Bool},
	 Data{"int", NativeTypeE::Int},
	 Data{"real", NativeTypeE::Real});

	auto ast = Parser(data.code).parse(ParserRule::type);
	REQUIRE(std::holds_alternative<NativeType>(ast));

	auto& nat = std::get<NativeType>(ast);
	CHECK(data.type == nat.type);
}
