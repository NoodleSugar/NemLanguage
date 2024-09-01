#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Literal")
{
	struct Data
	{
		std::string value;
	};

	auto data = GENERATE(
	 Data{"true"},
	 Data{"false"},
	 Data{"0"},
	 Data{"0001"},
	 Data{"1"},
	 Data{"1234"},
	 Data{"0b1011'0100"},
	 Data{"0o27'17"},
	 Data{"0x10CD'FFFF"},
	 Data{"0.0"},
	 Data{"1e02"},
	 Data{"0.12e-654"});

	auto expr = getAst(data.value, ruleExpr);
	REQUIRE(std::holds_alternative<LiteralNode>(expr));

	auto& lit = std::get<LiteralNode>(expr);
	CHECK(data.value == lit.value);
}

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Minus")
{
	struct Data
	{
		std::string code;
	};

	auto data = GENERATE(
	 Data{"-666"});

	auto expr = getAst(data.code, ruleExpr);
	REQUIRE(std::holds_alternative<MinusNode>(expr));
}

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Arith")
{
	struct Data
	{
		std::string code;
		ArithOp		op;
	};

	auto data = GENERATE(
	 Data{"1 + 2", ArithOp::Addition},
	 Data{"1 - 2", ArithOp::Substraction},
	 Data{"1 / 2", ArithOp::Division},
	 Data{"1 * 2", ArithOp::Multiplication},
	 Data{"1 % 2", ArithOp::Modulo});

	auto expr = getAst(data.code, ruleExpr);
	REQUIRE(std::holds_alternative<ArithmeticNode>(expr));

	auto& arith = std::get<ArithmeticNode>(expr);
	CHECK(data.op == arith.op);
}