#include "Fixture.hpp"

TEST_CASE_METHOD(IRBuilderInstructionFixture, "Return")
{
	struct Data
	{
		std::string code;
		std::string expectedIr;
	};

	auto data = GENERATE(
	 Data{"return 0", "  ret i64 0"},
	 Data{"return 0.0", "  ret double 0.000000e+00"});

	CHECK(data.expectedIr == getIRString<Return>(data.code, ParserRule::terminatedInstr));
}
