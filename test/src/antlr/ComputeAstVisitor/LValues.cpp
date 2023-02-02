#include "Fixture.hpp"

using namespace nem::ast;

TEST_CASE_METHOD(AntlrVisitorFixture, "Variable")
{
	struct Data
	{
		std::string name;
	};

	auto data = GENERATE(
	 Data{"v"},
	 Data{"variable"});

	auto  ast	   = getAst<Node::Ptr>(data.name, ruleLValue);
	auto& variable = derefPtr<VariableNode>(ast);
	CHECK(data.name == variable.name);
}