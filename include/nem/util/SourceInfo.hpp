#pragma once

namespace nem
{

struct SourcePosition
{
	size_t line, column;
};

struct SourceInfo
{
	SourcePosition start, stop;
};

} // namespace nem
