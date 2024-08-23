#include "Fixture.hpp"


TEST_CASE_METHOD(ParseTreeVisitorFixture, "Declaration")
{
	struct Data
	{
		std::string code;
		std::string name;
	};

	auto data = GENERATE(
	 Data{"var variable : int;", "variable"});

	auto instr = getAst(data.code, ruleInstr);
	REQUIRE(std::holds_alternative<DeclarationNode>(instr));

	auto& decl = std::get<DeclarationNode>(instr);
	CHECK(data.name == decl.identifier.name);
}

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Definition")
{
	struct Data
	{
		std::string code;
		std::string name;
		bool		hasType;
	};

	auto data = GENERATE(
	 Data{"var variable = 1;", "variable", false},
	 Data{"var typedVar : int = 1;", "typedVar", true});

	auto instr = getAst(data.code, ruleInstr);
	REQUIRE(std::holds_alternative<DefinitionNode>(instr));

	auto& def = std::get<DefinitionNode>(instr);
	CHECK(data.name == def.identifier.name);
	CHECK(data.hasType == def.type.has_value());
}

