#include "Fixture.hpp"

TEST_CASE_METHOD(IRBuilderFixture, "Literal")
{
	struct Data
	{
		std::string code;
		std::string expectedIr;
	};

	auto data = GENERATE(
	 Data{"true", "i1 true"},
	 Data{"false", "i1 false"},
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

TEST_CASE_METHOD(IRBuilderFixture, "UnaryOperation")
{
	struct Data
	{
		std::string code;
		std::string expectedIr;
	};

	auto data = GENERATE(
	 Data{"-1", "i64 -1"},
	 Data{"-1.0", "double -1.000000e+00"});

	CHECK(data.expectedIr == getIRString<UnaryOperation>(data.code, ParserRule::expr));
}

TEST_CASE_METHOD(IRBuilderFixture, "BinaryOperation")
{
	struct Data
	{
		std::string code;
		std::string expectedIr;
	};

	auto data = GENERATE(
	 Data{"true and false", "i1 false"},
	 Data{"true or false", "i1 true"},
	 Data{"1 + 2", "i64 3"},
	 Data{"1.0 + 2.0", "double 3.000000e+00"},
	 Data{"1 == 2", "i1 false"},
	 Data{"1 != 2", "i1 true"},
	 Data{"1 <= 2", "i1 true"},
	 Data{"1 >= 2", "i1 false"},
	 Data{"1 < 2", "i1 true"},
	 Data{"1 > 2", "i1 false"},
	 Data{"1.0 == 2.0", "i1 false"},
	 Data{"1.0 != 2.0", "i1 true"},
	 Data{"1.0 <= 2.0", "i1 true"},
	 Data{"1.0 >= 2.0", "i1 false"},
	 Data{"1.0 < 2.0", "i1 true"},
	 Data{"1.0 > 2.0", "i1 false"});

	CHECK(data.expectedIr == getIRString<BinaryOperation>(data.code, ParserRule::expr));
}
