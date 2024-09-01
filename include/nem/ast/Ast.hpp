#pragma once

#include <string>

#include "element/helper/Definitions.hpp"

#include "Forward.hpp"
#include "Node.hpp"

namespace nem::ast
{

NEM_DEFINE_ALL_AST_TYPES

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

} // namespace nem::ast
