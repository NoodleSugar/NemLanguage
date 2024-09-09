#pragma once

#include <cstddef>

namespace nem::ast
{

struct SourcePosition
{
	size_t line, column;
};

struct SourceInfo
{
	SourcePosition start, stop;
};

struct Node
{
	SourceInfo info;
};

} // namespace nem::ast
