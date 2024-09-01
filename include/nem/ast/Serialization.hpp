#pragma once

#include <cereal/archives/xml.hpp>

#include <cereal/types/memory.hpp>
#include <cereal/types/optional.hpp>
#include <cereal/types/string.hpp>
#include <cereal/types/variant.hpp>
#include <cereal/types/vector.hpp>

#include <nem/ast/Ast.hpp>
#include <nem/ast/Node.hpp>
#include <nem/ast/element/helper/Serialization.hpp>

namespace nem::ast
{

template<class T>
void serialize(T& object, std::ostream& out)
{
	cereal::XMLOutputArchive archive(out);
	archive(object);
}

template<class T>
void deserialize(T& object, std::istream& in)
{
	cereal::XMLInputArchive archive(in);
	archive(object);
}

NEM_DEFINE_ALL_AST_TYPES_SERIALIZATION

} // namespace nem::ast