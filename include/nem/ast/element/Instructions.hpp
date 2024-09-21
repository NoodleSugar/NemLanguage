#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"
#include "Expressions.hpp"
#include "Identifier.hpp"
#include "Types.hpp"

namespace nem::ast
{

struct VarDef : Node
{
	Identifier name;
	Type	   type;
	Expression value;
};

struct If : Node
{
	Expression	   cond;
	InstructionPtr then;
	InstructionOpt else_;
};

struct Return : Node
{
	Expression value;
};

} // namespace nem::ast
