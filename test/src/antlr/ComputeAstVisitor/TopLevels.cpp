#include "Fixture.hpp"

using namespace nem::ast;

TEST_CASE_METHOD(AntlrVisitorFixture, "File")
{
	struct Data
	{
		std::string string;
		size_t		funcCount;
	};

	auto data = GENERATE(
	 Data{"fn myFunction() void { }",
		  1},
	 Data{"fn myFunction(a : int, b : int) void { var v : int; }"
		  "fn otherFunction(a : int) void {  }",
		  2});

	auto ast = getAst<File>(data.string, ruleFile);
	CHECK(data.funcCount == ast.functions.size());
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Parameter")
{
	struct Data
	{
		std::string string;
		std::string name;
	};

	auto data = GENERATE(
	 Data{"p : int", "p"},
	 Data{"param : int", "param"});

	auto ast = getAst<Parameter>(data.string, ruleParam);
	CHECK(data.name == ast.name);
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Function")
{
	struct Data
	{
		std::string string;
		std::string name;
		size_t		paramCount;
		size_t		instrCount;
	};

	auto data = GENERATE(
	 Data{"fn myFunction(a : int, b : int) void { var v : int; }",
		  "myFunction", 2, 1});

	auto ast = getAst<Function>(data.string, ruleFnDef);
	CHECK(data.name == ast.name);
	CHECK(data.paramCount == ast.parameters.size());
	CHECK(data.instrCount == ast.block.instructions.size());
}