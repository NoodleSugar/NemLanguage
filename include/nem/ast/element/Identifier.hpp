#pragma once

#include <string>

#include "../Node.hpp"

namespace nem::ast
{

struct Identifier : Node
{
	std::string string;
};

} // namespace nem::ast
