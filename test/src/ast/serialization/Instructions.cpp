#include "Fixture.hpp"

TEST_CASE_METHOD(AstSerializerFixture, "FunctionCallNode")
{
	auto args	   = {myExprNode};
	auto [in, out] = prepareData<FunctionCallNode>("f", args);

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "BlockNode")
{
	auto instrs	   = {myInstrNode};
	auto [in, out] = prepareData<BlockNode>(instrs);

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "DeclarationNode")
{
	auto [in, out] = prepareData<DeclarationNode>("v", myTypeNode);

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "DefinitionNode")
{
	auto [in, out] = prepareData<DefinitionNode>("v", myTypeNode, myExprNode);

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "AssignmentNode")
{
	auto [in, out] = prepareData<AssignmentNode>(AssignOp::Equal, myLValueNode, myExprNode);

	CHECK(in == out);
}

TEST_CASE_METHOD(AstSerializerFixture, "ReturnNode")
{
	auto [in, out] = prepareData<ReturnNode>();

	CHECK(in == out);
}
