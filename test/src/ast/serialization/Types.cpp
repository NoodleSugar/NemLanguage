#include "Fixture.hpp"

TEST_CASE_METHOD(AstSerializerFixture, "NativeTypeNode")
{
	auto [in, out] = prepareData<NativeTypeNode>();

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "QualifiedTypeNode")
{
	auto [in, out] = prepareData<QualifiedTypeNode>(QualifiedType::Qualifier::Const, myTypeNode);

	CHECK(in == out);
}