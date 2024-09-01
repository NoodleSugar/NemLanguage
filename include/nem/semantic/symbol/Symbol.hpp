#pragma once

#include <string>

#include <nem/util/SourceInfo.hpp>

namespace nem::semantic
{

struct Symbol
{
	SourceInfo	info;
	std::string name;
};

} // namespace nem::semantic