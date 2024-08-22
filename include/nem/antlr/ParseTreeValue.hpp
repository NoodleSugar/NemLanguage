#pragma once

#include <variant>

#include "nem/ast/Forward.hpp"
#include "nem/ast/element/helper/Adapters.hpp"

namespace nem::antlr
{

using ParseTreeValue = std::variant<NEM_ADAPT_LIST(NEM_AST_NODE_ADAPTER, NEM_LIST_OF_AST_TYPES)>;

} // namespace nem::antlr
