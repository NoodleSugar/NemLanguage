#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Block")
{
	struct Data
	{
		size_t		instrCount;
		std::string code;
	};

	auto data = GENERATE(
	 Data{0, "{ }"},
	 Data{1, "{ var n : int; }"},
	 Data{3, "{ var n : int;"
			 "  var n : int;"
			 "  var n : int; }"});

	auto instr = getAst(data.code, ruleInstr);
	REQUIRE(std::holds_alternative<BlockNode>(instr));

	auto& block = std::get<BlockNode>(instr);
	CHECK(data.instrCount == block.instructions.size());
}

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

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Assignment")
{
	struct Data
	{
		std::string code;
		AssignOp	op;
	};

	auto data = GENERATE(
	 Data{"variable = 1;", AssignOp::Equal},
	 Data{"aVar += 1;", AssignOp::AddEqual},
	 Data{"sVar -= 1;", AssignOp::SubEqual},
	 Data{"dVar /= 1;", AssignOp::DivEqual},
	 Data{"mVar *= 1;", AssignOp::MulEqual},
	 Data{"mVar %= 1;", AssignOp::ModEqual});

	auto instr = getAst(data.code, ruleInstr);
	REQUIRE(std::holds_alternative<AssignmentNode>(instr));

	auto& assign = std::get<AssignmentNode>(instr);
	CHECK(data.op == assign.op);
}
