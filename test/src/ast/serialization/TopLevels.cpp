#include "Fixture.hpp"

TEST_CASE_METHOD(AstSerializerFixture, "File")
{
	auto [in, out] = prepareData<File>();

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "Function")
{
	auto params = std::vector<Parameter>{};
	auto instrs = Block{{myInstrNode}};

	auto [in, out] = prepareData<Function>("f", myTypeNode, params, instrs);

	CHECK(in == out);
}