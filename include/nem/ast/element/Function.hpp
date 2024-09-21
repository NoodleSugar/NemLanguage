#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"
#include "Block.hpp"
#include "Identifier.hpp"
#include "Types.hpp"

namespace nem::ast
{

struct Parameter : Node
{
	Identifier name;
	Type	   type;
};

struct Function : Node
{
	Identifier	 name;
	Type		 returnType;
	ParameterSeq params;
	Block		 body;
};

} // namespace nem::ast
