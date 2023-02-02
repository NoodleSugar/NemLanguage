#pragma once

#include <sstream>

#include <catch2/catch_test_macros.hpp>

#include <nem/ast/Serialization.hpp>

using namespace nem::ast;

class AstSerializerFixture
{
	std::stringstream stream;

protected:
	const Node::Ptr myExprNode{new LiteralNode{Literal::Type::Integer, "10"}};
	const Node::Ptr myInstrNode{new ReturnNode{}};
	const Node::Ptr myTypeNode{new NativeTypeNode{NativeType::Name::Int}};
	const Node::Ptr myLValueNode{new VariableNode{"maVar"}};

	template<class T>
	struct Data
	{
		T in;
		T out;
	};

	template<class T, class... Args>
	Data<T> prepareData(Args&&... args)
	{
		T dataIn{args...};
		T dataOut;

		serialize(dataIn, stream);
		deserialize(dataOut, stream);

		return {dataIn, dataOut};
	}
};