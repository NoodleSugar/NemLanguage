#include "Fixture.hpp"

using namespace nem::ast;

TEST_CASE_METHOD(AntlrVisitorFixture, "QualifiedType")
{
	struct Data
	{
		std::string				 string;
		QualifiedType::Qualifier qualifier;
	};

	auto data = GENERATE(
	 Data{"const int", QualifiedType::Qualifier::Const});

	auto  ast  = getAst<Node::Ptr>(data.string, ruleType);
	auto& type = derefPtr<QualifiedTypeNode>(ast);

	CHECK(data.qualifier == type.qualifier);
}

TEST_CASE_METHOD(AntlrVisitorFixture, "NativeType")
{
	struct Data
	{
		std::string		 string;
		NativeType::Name type;
	};

	auto data = GENERATE(
	 Data{"void", NativeType::Name::Void},
	 Data{"int", NativeType::Name::Int});

	auto  ast  = getAst<Node::Ptr>(data.string, ruleType);
	auto& type = derefPtr<NativeTypeNode>(ast);

	CHECK(data.type == type.name);
}