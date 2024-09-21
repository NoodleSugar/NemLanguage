#pragma once

#include <string>

#include "../Node.hpp"

namespace nem::ast
{

enum class LiteralType
{
	Bool,
	Int,
	Real
};

struct Literal : Node
{
	LiteralType type;
	std::string value;
};

enum class UnaryOp
{
	Minus
};

struct UnaryOperation : Node
{
	UnaryOp		  op;
	ExpressionPtr expr;
};

enum class BinaryOp
{
	Or,
	And,
	EQ,
	NE,
	LE,
	GE,
	LT,
	GT,
	Plus,
	Minus,
	Star,
	Slash
};

struct BinaryOperation : Node
{
	BinaryOp	  op;
	ExpressionPtr left, right;
};

} // namespace nem::ast
