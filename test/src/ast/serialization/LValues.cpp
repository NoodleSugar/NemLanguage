#include "Fixture.hpp"

TEST_CASE_METHOD(AstSerializerFixture, "VariableNode")
{
	auto [in, out] = prepareData<VariableNode>("v");

	CHECK(in == out);
}