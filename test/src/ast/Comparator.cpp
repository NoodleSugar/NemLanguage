#include <nem/ast/Ast.hpp>

namespace nem::ast
{

bool operator==(const Node& o1, const Node& o2)
{
	if(o1.type != o2.type)
		return false;
	switch(o1.type)
	{
#define X(T)          \
	case NodeType::T: \
		return ast_cast<T>(o1) == ast_cast<T>(o2);
		LIST_OF_AST_NODES
#undef X
	case NodeType::Invalid:
		// TODO Error
		return false;
	}
}

bool operator==(const NodePtrList& o1, const NodePtrList& o2)
{
	return o1.size() == o2.size() &&
		   std::equal(o1.cbegin(), o1.cend(), o2.cbegin(),
					  [](const auto& n1, const auto& n2)
					  { return *n1 == *n2; });
}

bool operator==(const NodePtrOpt& o1, const NodePtrOpt& o2)
{
	if(o1.has_value() != o2.has_value())
		return false;

	if(!o1.has_value())
		return true;

	return *o1.value() == *o2.value();
}

bool operator==(const File& o1, const File& o2)
{
	return o1.functions == o2.functions;
}

bool operator==(const Function& o1, const Function& o2)
{
	return o1.name == o2.name &&
		   *o1.returnType == *o2.returnType &&
		   o1.parameters == o2.parameters &&
		   o1.block == o2.block;
}

bool operator==(const Parameter& o1, const Parameter& o2)
{
	return o1.name == o2.name &&
		   *o1.type == *o2.type;
}

bool operator==(const Block& o1, const Block& o2)
{
	return o1.instructions == o2.instructions;
}

bool operator==(const Declaration& o1, const Declaration& o2)
{
	return o1.name == o2.name &&
		   *o1.type == *o2.type;
}

bool operator==(const Definition& o1, const Definition& o2)
{
	return o1.name == o2.name &&
		   o1.type == o2.type &&
		   *o1.value == *o2.value;
}

bool operator==(const Assignment& o1, const Assignment& o2)
{
	return o1.op == o2.op &&
		   *o1.left == *o2.left &&
		   *o1.right == *o2.right;
}

bool operator==(const Return& o1, const Return& o2)
{
	return o1.value == o2.value;
}

bool operator==(const FunctionCall& o1, const FunctionCall& o2)
{
	return o1.name == o2.name &&
		   o1.arguments == o2.arguments;
}

bool operator==(const Literal& o1, const Literal& o2)
{
	return o1.type == o2.type &&
		   o1.value == o2.value;
}

bool operator==(const Minus& o1, const Minus& o2)
{
	return *o1.expression == *o2.expression;
}

bool operator==(const Arithmetic& o1, const Arithmetic& o2)
{
	return o1.op == o2.op &&
		   *o1.left == *o2.left &&
		   *o1.right == *o2.right;
}

bool operator==(const QualifiedType& o1, const QualifiedType& o2)
{
	return o1.qualifier == o2.qualifier &&
		   *o1.type == *o2.type;
}

bool operator==(const NativeType& o1, const NativeType& o2)
{
	return o1.name == o2.name;
}

bool operator==(const Identifier& o1, const Identifier& o2)
{
	return o1.name == o2.name;
}

} // namespace nem::ast