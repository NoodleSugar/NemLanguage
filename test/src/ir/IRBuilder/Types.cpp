#include "Fixture.hpp"

TEST_CASE_METHOD(IRBuilderFixture, "NativeType")
{
	struct Data
	{
		std::string code;
		std::string expectedIr;
	};

	auto data = GENERATE(
	 Data{"bool", "i1"},
	 Data{"int", "i64"},
	 Data{"real", "double"});

	CHECK(data.expectedIr == getIRString<NativeType>(data.code, ParserRule::type));
}
