#include "Fixture.hpp"

using namespace nem::ast;

TEST_CASE_METHOD(AntlrVisitorFixture, "FunctionCall")
{
	struct Data
	{
		std::string string;
		std::string name;
		size_t		argCount;
	};

	auto data = GENERATE(
	 Data{"f()", "f", 0},
	 Data{"myFunction(0, a, 1 + 2, -3)", "myFunction", 4});

	auto ast	  = getAst<Node::Ptr>(data.string, ruleFunctionCall);
	auto function = derefPtr<FunctionCallNode>(ast);
	CHECK(data.name == function.name);
	CHECK(data.argCount == function.arguments.size());
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Block")
{
	struct Data
	{
		std::string string;
		size_t		instrCount;
	};

	auto data = GENERATE(
	 Data{"{ }", 0},
	 Data{"{ var n : int; }", 1});

	auto  ast	= getAst<Node::Ptr>(data.string, ruleInstr);
	auto& block = derefPtr<BlockNode>(ast);
	CHECK(data.instrCount == block.instructions.size());
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Declaration")
{
	struct Data
	{
		std::string string;
		std::string name;
	};

	auto data = GENERATE(
	 Data{"var variable : int;", "variable"});

	auto  ast  = getAst<Node::Ptr>(data.string, ruleInstr);
	auto& decl = derefPtr<DeclarationNode>(ast);
	CHECK(data.name == decl.name);
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Definition")
{
	struct Data
	{
		std::string string;
		bool		hasType;
		std::string name;
	};

	auto data = GENERATE(
	 Data{"var variable = 1;", false, "variable"},
	 Data{"var typedVar : int = 1;", true, "typedVar"});

	auto  ast = getAst<Node::Ptr>(data.string, ruleInstr);
	auto& def = derefPtr<DefinitionNode>(ast);
	CHECK(data.hasType == def.type.has_value());
	CHECK(data.name == def.name);
}

TEST_CASE_METHOD(AntlrVisitorFixture, "Assignement")
{
	struct Data
	{
		std::string string;
		std::string name;
		AssignOp	op;
	};

	auto data = GENERATE(
	 Data{"variable = 1;", "variable", AssignOp::Equal},
	 Data{"aVar += 1;", "aVar", AssignOp::AddEqual},
	 Data{"sVar -= 1;", "sVar", AssignOp::SubEqual},
	 Data{"dVar /= 1;", "dVar", AssignOp::DivEqual},
	 Data{"mVar *= 1;", "mVar", AssignOp::MulEqual},
	 Data{"mVar %= 1;", "mVar", AssignOp::ModEqual});

	auto  ast	 = getAst<Node::Ptr>(data.string, ruleInstr);
	auto& assign = derefPtr<AssignmentNode>(ast);
	CHECK(data.op == assign.op);
}