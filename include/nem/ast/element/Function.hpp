#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"
#include "Block.hpp"
#include "Identifier.hpp"
#include "Types.hpp"

namespace nem::ast
{

struct Function : Node
{
	Identifier name;
	Type	   returnType;
	Block	   body;
};

} // namespace nem::ast
