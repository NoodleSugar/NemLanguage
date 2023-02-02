#include "Fixture.hpp"

using namespace nem::ast;

TEST_CASE_METHOD(AntlrVisitorFixture, "Literal")
{
	struct Data
	{
		Literal::Type type;
		std::string	  value;
	};

	auto data = GENERATE(
	 Data{Literal::Type::Integer, "0"},
	 Data{Literal::Type::Integer, "01"},
	 Data{Literal::Type::Integer, "1234"},
	 Data{Literal::Type::Integer, "0b1011'0100"},
	 Data{Literal::Type::Integer, "0o27'17"},
	 Data{Literal::Type::Integer, "0x10CD'FFFF"});

	auto  ast	  = getAst<Node::Ptr>(data.value, ruleExpr);
	auto& literal = derefPtr<LiteralNode>(ast);
	CHECK(data.type == literal.type);
	CHECK(data.value == literal.value);
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Minus")
{
	struct Data
	{
		std::string string;
	};

	auto data = GENERATE(
	 Data{"-666"});

	auto ast = getAst<Node::Ptr>(data.string, ruleExpr);
	derefPtr<MinusNode>(ast);
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Arith")
{
	struct Data
	{
		std::string string;
		ArithOp		op;
	};

	auto data = GENERATE(
	 Data{"1 + 2", ArithOp::Addition},
	 Data{"1 - 2", ArithOp::Substraction},
	 Data{"1 / 2", ArithOp::Division},
	 Data{"1 * 2", ArithOp::Multiplication},
	 Data{"1 % 2", ArithOp::Modulo});

	auto  ast	= getAst<Node::Ptr>(data.string, ruleExpr);
	auto& arith = derefPtr<ArithmeticNode>(ast);
	CHECK(data.op == arith.op);
}