#include "Fixture.hpp"

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Function")
{
	struct Data
	{
		std::string code;
		std::string name;
		bool		hasReturnType;
		size_t		paramCount;
		size_t		instrCount;
	};

	auto data = GENERATE(
	 Data{"fn f() int { }",
		  "f", true, 0, 0},
	 Data{"fn myFun() { }",
		  "myFun", false, 0, 0},
	 Data{"fn f(a : int) { }",
		  "f", false, 1, 0},
	 Data{"fn f() { var v : int; }",
		  "f", false, 0, 1},
	 Data{"fn myFun(a : int, b : int) int { var v : int; return 0; }",
		  "myFun", true, 2, 2});

	auto ast = getAst(data.code, ruleFnDef);
	REQUIRE(std::holds_alternative<FunctionNode>(ast));

	auto& fun = std::get<FunctionNode>(ast);
	CHECK(data.name == fun.identifier.name);
	CHECK(data.hasReturnType == fun.returnType.has_value());
	CHECK(data.paramCount == fun.parameters.size());
	CHECK(data.instrCount == fun.instructions.size());
}

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Parameter")
{
	struct Data
	{
		std::string code;
		std::string name;
	};

	auto data = GENERATE(
	 Data{"p : int", "p"},
	 Data{"param : int", "param"});

	auto ast = getAst(data.code, ruleParam);
	REQUIRE(std::holds_alternative<ParameterNode>(ast));

	auto& param = std::get<ParameterNode>(ast);
	CHECK(data.name == param.identifier.name);
}

TEST_CASE_METHOD(ParseTreeVisitorFixture, "Call")
{
	struct Data
	{
		std::string code;
		size_t		argCount;
	};

	auto data = GENERATE(
	 Data{"f()", 0},
	 Data{"myFunction(0, a, 1 + 2, -3)", 4});

	auto ast = getAst(data.code, ruleCall);
	REQUIRE(std::holds_alternative<CallNode>(ast));

	auto& call = std::get<CallNode>(ast);
	CHECK(data.argCount == call.arguments.size());
}