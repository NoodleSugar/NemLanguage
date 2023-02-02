#include "Fixture.hpp"

TEST_CASE_METHOD(AstSerializerFixture, "LiteralNode")
{
	auto [in, out] = prepareData<LiteralNode>(Literal::Type::Integer, "0");

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "MinusNode")
{
	auto [in, out] = prepareData<MinusNode>(myExprNode);

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "ArithmeticNode")
{
	auto [in, out] = prepareData<ArithmeticNode>(ArithOp::Modulo, myExprNode, myExprNode);

	CHECK(in == out);
}
