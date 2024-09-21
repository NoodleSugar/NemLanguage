#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"
#include "Expressions.hpp"

namespace nem::ast
{

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
