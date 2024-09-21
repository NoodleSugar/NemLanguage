#include "Fixture.hpp"

TEST_CASE_METHOD(IRBuilderFixture, "Function")
{
	struct Data
	{
		std::string filename;
	};

	auto data = GENERATE(
	 Data{"function_main"},
	 Data{"call_f"});

	const auto code		  = getFileContent(data.filename + ".nem");
	const auto expectedIr = getFileContent(data.filename + ".ir");

	CHECK(expectedIr == getIRString(code, ParserRule::file));
}
