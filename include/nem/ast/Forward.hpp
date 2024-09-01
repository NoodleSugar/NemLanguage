#pragma once

#include <memory>
#include <optional>
#include <variant>
#include <vector>

#include "element/helper/Declarations.hpp"

namespace nem::ast
{

template<class T>
struct Node;

NEM_DECLARE_ALL_AST_TYPES
NEM_DECLARE_ALL_AST_NODE_ALIASES
NEM_DECLARE_ALL_AST_UNIONS

using ParameterNodeList = std::vector<ParameterNode>;
using FunctionNodeList	= std::vector<FunctionNode>;

using ExpressionNodePtr	 = std::shared_ptr<ExpressionNode>;
using ExpressionNodeList = std::vector<ExpressionNode>;
using ExpressionNodeOpt	 = std::optional<ExpressionNode>;

using InstructionNodeList = std::vector<InstructionNode>;

using TypeNodeOpt = std::optional<TypeNode>;

template<class... Args>
auto makeExpressionNodePtr(Args&&... args)
{
	return std::make_shared<ExpressionNode>(std::forward<Args>(args)...);
}

enum class ArithOp;
enum class AssignOp;

} // namespace nem::ast