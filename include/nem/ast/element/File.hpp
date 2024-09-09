#pragma once

#include "../Forward.hpp"

namespace nem::ast
{

struct File : Node
{
	FunctionList functions;
};

} // namespace nem::ast
