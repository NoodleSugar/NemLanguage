#pragma once

#include "Ast.hpp"
#include "Node.hpp"

#define LIST_OF_NODE_TYPES \
	X(FunctionCall)        \
	X(Block)               \
	X(Declaration)         \
	X(Definition)          \
	X(Assignment)          \
	X(Return)              \
	X(Literal)             \
	X(Minus)               \
	X(Arithmetic)          \
	X(QualifiedType)       \
	X(NativeType)          \
	X(Variable)

namespace nem::ast
{

template<class T>
AstType getAstType();

template<class T>
class ImplNode : public Node, public T
{
public:
	using UnderType = T;

	template<class... Args>
	ImplNode(Args... args) :
		T{args...}
	{
	}

	AstType		getType() const override { return getAstType<T>(); }
};

template<class T>
inline const T& node_cast(const Node& node)
{
	return static_cast<const T&>(static_cast<const ImplNode<T>&>(node));
}

#define X(T)                     \
	using T##Node = ImplNode<T>; \
	bool operator==(const T##Node&, const T##Node&);
LIST_OF_NODE_TYPES
#undef X

} // namespace nem::ast
