#include "Includes.hpp"

TEST_CASE("Literal")
{
	struct Data
	{
		std::string value;
		LiteralType type;
	};

	auto data = GENERATE(
	 Data{"true", LiteralType::Bool},
	 Data{"false", LiteralType::Bool},
	 Data{"0", LiteralType::Int},
	 Data{"0001", LiteralType::Int},
	 Data{"1", LiteralType::Int},
	 Data{"1234", LiteralType::Int},
	 Data{"0b1011'0100", LiteralType::Int},
	 Data{"0o27'17", LiteralType::Int},
	 Data{"0x10CD'FFFF", LiteralType::Int},
	 Data{"0.0", LiteralType::Real},
	 Data{"1e02", LiteralType::Real},
	 Data{"0.12e-654", LiteralType::Real});

	auto ast = Parser(data.value).parse(ParserRule::literal);
	REQUIRE(std::holds_alternative<Literal>(ast));

	auto& lit = std::get<Literal>(ast);
	CHECK(data.value == lit.value);
	CHECK(data.type == lit.type);
}

TEST_CASE("Identifier")
{
	struct Data
	{
		std::string name;
	};

	auto data = GENERATE(
	 Data{"pouet"},
	 Data{"Pouet0_1"});

	auto ast = Parser(data.name).parse(ParserRule::expr);
	REQUIRE(std::holds_alternative<Identifier>(ast));

	auto& id = std::get<Identifier>(ast);
	CHECK(data.name == id.string);
}

TEST_CASE("UnaryOperation")
{
	struct Data
	{
		std::string value;
		UnaryOp		op;
	};

	auto data = GENERATE(
	 Data{"-0", UnaryOp::Minus},
	 Data{"-1.0e+10", UnaryOp::Minus});

	auto ast = Parser(data.value).parse(ParserRule::expr);
	REQUIRE(std::holds_alternative<UnaryOperation>(ast));

	auto& unOp = std::get<UnaryOperation>(ast);
	CHECK(data.op == unOp.op);
}

TEST_CASE("BinaryOperation")
{
	struct Data
	{
		std::string value;
		BinaryOp	op;
	};

	auto data = GENERATE(
	 Data{"true or true", BinaryOp::Or},
	 Data{"true and true", BinaryOp::And},
	 Data{"true or true and true", BinaryOp::Or},
	 Data{"true and true or true", BinaryOp::Or},
	 Data{"true and (true or true)", BinaryOp::And},
	 Data{"(true or true) and true", BinaryOp::And},
	 Data{"1 == 1", BinaryOp::EQ},
	 Data{"1 != 1", BinaryOp::NE},
	 Data{"1 <= 1", BinaryOp::LE},
	 Data{"1 >= 1", BinaryOp::GE},
	 Data{"1 < 1", BinaryOp::LT},
	 Data{"1 > 1", BinaryOp::GT},
	 Data{"1 + 1", BinaryOp::Plus},
	 Data{"1 - 1", BinaryOp::Minus},
	 Data{"1 * 1", BinaryOp::Star},
	 Data{"1 / 1", BinaryOp::Slash},
	 Data{"1 - 1 + 1", BinaryOp::Plus},
	 Data{"1 + 1 - 1", BinaryOp::Plus},
	 Data{"1 - (1 + 1)", BinaryOp::Minus},
	 Data{"(1 + 1) - 1", BinaryOp::Minus},
	 Data{"1 * 1 - 1", BinaryOp::Minus},
	 Data{"1 - 1 * 1", BinaryOp::Minus},
	 Data{"1 * (1 - 1)", BinaryOp::Star},
	 Data{"(1 - 1) * 1", BinaryOp::Star},
	 Data{"1 * 1 / 1", BinaryOp::Star},
	 Data{"1 / 1 * 1", BinaryOp::Star},
	 Data{"(1 * 1) / 1", BinaryOp::Slash},
	 Data{"1 / (1 * 1)", BinaryOp::Slash});

	auto ast = Parser(data.value).parse(ParserRule::expr);
	REQUIRE(std::holds_alternative<BinaryOperation>(ast));

	auto& binOp = std::get<BinaryOperation>(ast);
	CHECK(data.op == binOp.op);
}
