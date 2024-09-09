#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"
#include "Expressions.hpp"

namespace nem::ast
{

struct Return : Node
{
	Expression value;
};

} // namespace nem::ast
