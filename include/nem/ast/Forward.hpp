#pragma once

#include <optional>
#include <variant>

#include "element/helper/Declarations.hpp"

namespace nem::ast
{

template<class T>
struct Node;

NEM_DECLARE_ALL_AST_TYPES
NEM_DECLARE_ALL_AST_NODE_ALIASES
NEM_DECLARE_ALL_AST_UNIONS

using TypeNodeOpt = std::optional<TypeNode>;

} // namespace nem::ast