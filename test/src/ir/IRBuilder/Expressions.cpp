#include "Fixture.hpp"

TEST_CASE_METHOD(IRBuilderFixture, "Literal")
{
	struct Data
	{
		std::string code;
		std::string expectedIr;
	};

	auto data = GENERATE(
	 Data{"0", "i64 0"},
	 Data{"0001", "i64 1"},
	 Data{"1234", "i64 1234"},
	 Data{"0b1011'0100", "i64 180"},
	 Data{"0o27'17", "i64 1487"},
	 Data{"0x10CD'FFFF", "i64 281935871"},
	 Data{"0.0", "double 0.000000e+00"},
	 Data{"1e02", "double 1.000000e+02"},
	 Data{"0.12e-6", "double 1.200000e-07"});

	CHECK(data.expectedIr == getIRString<Literal>(data.code, ParserRule::literal));
}
