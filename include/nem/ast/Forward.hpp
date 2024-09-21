#pragma once

#include <memory>
#include <optional>
#include <variant>
#include <vector>

#include "nem/util/Macros.hpp"

namespace nem::ast
{

struct Node;

enum class UnaryOp;
enum class BinaryOp;

#define NEM_AST_LIST_OF_INSTRUCTION_NODES \
	Block,                                \
	 If,                                  \
	 Return
#define NEM_AST_LIST_OF_EXPRESSION_NODES \
	Literal,                             \
	 Identifier,                         \
	 UnaryOperation,                     \
	 BinaryOperation,                    \
	 Call
#define NEM_AST_LIST_OF_TYPE_NODES \
	NativeType

#define NEM_AST_LIST_OF_NODES \
	File,                     \
	 Identifier,              \
	 Function,                \
	 Parameter,               \
	 Block,                   \
	 If,                      \
	 Return,                  \
	 Literal,                 \
	 UnaryOperation,          \
	 BinaryOperation,         \
	 Call,                    \
	 NativeType

NEM_FOR_EACH(NEM_DECLARE_STRUCT, NEM_AST_LIST_OF_NODES)
using AstElement = std::variant<NEM_AST_LIST_OF_NODES>;

using Instruction = std::variant<NEM_AST_LIST_OF_INSTRUCTION_NODES>;
using Expression  = std::variant<NEM_AST_LIST_OF_EXPRESSION_NODES>;
using Type		  = std::variant<NEM_AST_LIST_OF_TYPE_NODES>;

using FunctionList = std::vector<Function>;
using ParameterSeq = std::vector<Parameter>;

using InstructionPtr = std::shared_ptr<Instruction>;
using InstructionOpt = std::optional<InstructionPtr>;
using InstructionSeq = std::vector<Instruction>;

using ExpressionPtr = std::shared_ptr<Expression>;
using ExpressionSeq = std::vector<Expression>;

} // namespace nem::ast
