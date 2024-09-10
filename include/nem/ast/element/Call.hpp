#pragma once

#include "../Node.hpp"
#include "Identifier.hpp"

namespace nem::ast
{

struct Call : Node
{
	Identifier name;
};

} // namespace nem::ast
