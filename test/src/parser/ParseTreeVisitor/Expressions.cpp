#include "Includes.hpp"

TEST_CASE("Literal")
{
	struct Data
	{
		std::string value;
		LiteralType type;
	};

	auto data = GENERATE(
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
