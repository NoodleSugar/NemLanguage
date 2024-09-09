#include "Fixture.hpp"

TEST_CASE_METHOD(JitFixture, "return_int")
{
	struct Data
	{
		std::string filename;
		int			expectedResult;
	};

	auto data = GENERATE(
	 Data{"return_zero.ir", 0},
	 Data{"return_one.ir", 1});

	auto result = getResultFromFile(data.filename);
	CHECK(data.expectedResult == result);
}
