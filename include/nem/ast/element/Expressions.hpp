#pragma once

#include <string>

#include "../Node.hpp"

namespace nem::ast
{

enum class LiteralType
{
	Int,
	Real
};

struct Literal : Node
{
	LiteralType type;
	std::string	 value;
};

} // namespace nem::ast
