#pragma once

#include <cereal/archives/xml.hpp>

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

// TODO move this method in another place
template<class Archive>
void serialize(Archive& ar, SourceInfo& info)
{
	ar(cereal::make_nvp("startLine", info.start.line),
	   cereal::make_nvp("startColumn", info.start.column),
	   cereal::make_nvp("stopLine", info.stop.line),
	   cereal::make_nvp("stopColumn", info.stop.column));
}

} // namespace nem
