#pragma once

#include "../Node.hpp"

namespace nem::ast
{

enum class NativeTypeE
{
	Int,
	Real
};

struct NativeType : Node
{
	NativeTypeE type;
};

} // namespace nem::ast
