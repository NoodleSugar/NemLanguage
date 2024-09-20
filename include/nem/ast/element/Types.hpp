#pragma once

#include "../Node.hpp"

namespace nem::ast
{

enum class NativeTypeE
{
	Bool,
	Int,
	Real
};

struct NativeType : Node
{
	NativeTypeE type;
};

} // namespace nem::ast
