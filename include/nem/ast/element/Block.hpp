#pragma once

#include "../Forward.hpp"
#include "../Node.hpp"

namespace nem::ast
{

struct Block : Node
{
	InstructionSeq instructions;
};

} // namespace nem::ast
