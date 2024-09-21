#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"
#include "Identifier.hpp"

namespace nem::ast
{

struct Call : Node
{
	Identifier	  name;
	ExpressionSeq args;
};

} // namespace nem::ast
