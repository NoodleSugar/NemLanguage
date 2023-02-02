#pragma once

#include <string>
#include <vector>
#include <optional>

#include "ForwardAst.hpp"
#include "Node.hpp"

namespace nem::ast
{

using NodePtrList	= std::vector<Node::Ptr>;
using NodePtrOpt	= std::optional<Node::Ptr>;
using ParameterList = std::vector<Parameter>;
using FunctionList	= std::vector<Function>;

enum class AstType
{
#define X(T) T,
	LIST_OF_AST_TYPES
#undef X
};

enum class ArithOp
{
	Addition,
	Substraction,
	Multiplication,
	Division,
	Modulo
};

enum class AssignOp
{
	Equal,
	AddEqual,
	SubEqual,
	MulEqual,
	DivEqual,
	ModEqual
};

struct Block
{
	NodePtrList instructions;
};

struct Parameter
{
	std::string name;
	Node::Ptr	type;
};

struct Function
{
	std::string	  name;
	Node::Ptr	  returnType;
	ParameterList parameters;
	Block		  block;
};

struct File
{
	FunctionList functions;
};

struct FunctionCall
{
	std::string name;
	NodePtrList arguments;
};

struct Declaration
{
	std::string name;
	Node::Ptr	type;
};

struct Definition
{
	std::string name;
	NodePtrOpt	type;
	Node::Ptr	value;
};

struct Assignment
{
	AssignOp  op;
	Node::Ptr left, right;
};

struct Return
{
	NodePtrOpt value;
};

struct Literal
{
	enum class Type
	{
		Integer
	};

	Type		type;
	std::string value;
};

struct Minus
{
	Node::Ptr expression;
};

struct Arithmetic
{
	ArithOp	  op;
	Node::Ptr left, right;
};

struct QualifiedType
{
	enum class Qualifier
	{
		Const
	};

	Qualifier qualifier;
	Node::Ptr type;
};

struct NativeType
{
	enum class Name
	{
		Void,
		Int
	};

	Name name;
};

struct Variable
{
	std::string name;
};

bool operator==(const Node&, const Node&);
#define X(T) bool operator==(const T&, const T&);
LIST_OF_AST_TYPES
#undef X

} // namespace nem::ast