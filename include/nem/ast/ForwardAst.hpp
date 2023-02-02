#pragma once

#define LIST_OF_AST_TYPES \
	X(File)               \
	X(Function)           \
	X(Parameter)          \
	X(FunctionCall)       \
	X(Block)              \
	X(Declaration)        \
	X(Definition)         \
	X(Assignment)         \
	X(Return)             \
	X(Literal)            \
	X(Minus)              \
	X(Arithmetic)         \
	X(QualifiedType)      \
	X(NativeType)         \
	X(Variable)

namespace nem::ast
{

enum class AstType;

enum class ArithOp;
enum class AssignOp;

class Node;

#define X(T) \
	struct T;
LIST_OF_AST_TYPES
#undef X

} // namespace nem::ast