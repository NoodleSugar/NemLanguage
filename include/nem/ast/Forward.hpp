#pragma once

#include <memory>
#include <variant>
#include <vector>

#include "nem/util/Macros.hpp"

namespace nem::ast
{

struct Node;

enum class UnaryOp;
enum class BinaryOp;

#define NEM_AST_LIST_OF_INSTRUCTION_NODES \
	Return
#define NEM_AST_LIST_OF_EXPRESSION_NODES \
	Literal,                             \
	 UnaryOperation,                     \
	 BinaryOperation
#define NEM_AST_LIST_OF_TYPE_NODES \
	NativeType

#define NEM_AST_LIST_OF_NODES           \
	File,                               \
	 Identifier,                        \
	 Function,                          \
	 Block,                             \
	 NEM_AST_LIST_OF_INSTRUCTION_NODES, \
	 NEM_AST_LIST_OF_EXPRESSION_NODES,  \
	 NEM_AST_LIST_OF_TYPE_NODES

NEM_FOR_EACH(NEM_DECLARE_STRUCT, NEM_AST_LIST_OF_NODES)
using AstElement = std::variant<NEM_AST_LIST_OF_NODES>;

using Instruction = std::variant<NEM_AST_LIST_OF_INSTRUCTION_NODES>;
using Expression  = std::variant<NEM_AST_LIST_OF_EXPRESSION_NODES>;
using Type		  = std::variant<NEM_AST_LIST_OF_TYPE_NODES>;

using FunctionList = std::vector<Function>;

using InstructionSeq = std::vector<Instruction>;

using ExpressionPtr = std::shared_ptr<Expression>;

template<class T>
const auto MakePtr = std::make_shared<T>;

} // namespace nem::ast
