#include <algorithm>

#include <nem/ast/Ast.hpp>
#include <nem/ast/Info.hpp>

#define LIST_OF_AST_CODES \
	X(File, file)         \
	X(Function, fun)      \
	X(Parameter, par)     \
	X(FunctionCall, call) \
	X(Block, bl)          \
	X(Declaration, decl)  \
	X(Definition, def)    \
	X(Assignment, assign) \
	X(Return, ret)        \
	X(Literal, lit)       \
	X(Minus, min)         \
	X(Arithmetic, arith)  \
	X(QualifiedType, qty) \
	X(NativeType, nty)    \
	X(Variable, var)

namespace nem::ast
{

/*************
 * Ast Types *
 *************/

#define X(T)                      \
	template<>                    \
	AstType getAstType<T>()       \
	{                             \
		return AstType::T; \
	}
LIST_OF_AST_TYPES
#undef X

/*************
 * Ast Codes *
 *************/

#define X(T, name)              \
	template<>                  \
	const char* getAstCode<T>() \
	{                           \
		return #name;           \
	}
LIST_OF_AST_CODES
#undef X

/******************
 * Operator Codes *
 ******************/

char getOpCode(ArithOp op)
{
	switch(op)
	{
	case ArithOp::Addition:
		return '+';
	case ArithOp::Substraction:
		return '-';
	case ArithOp::Multiplication:
		return '*';
	case ArithOp::Division:
		return '/';
	case ArithOp::Modulo:
		return '%';
	}
}

const char* getOpCode(AssignOp op)
{
	switch(op)
	{
	case AssignOp::Equal:
		return "=";
	case AssignOp::AddEqual:
		return "+=";
	case AssignOp::SubEqual:
		return "-=";
	case AssignOp::MulEqual:
		return "*+";
	case AssignOp::DivEqual:
		return "/=";
	case AssignOp::ModEqual:
		return "%=";
	}
}

/***************
 * Types Codes *
 ***************/
const char* getQCode(QualifiedType::Qualifier qualifier)
{
	switch(qualifier)
	{
	case QualifiedType::Qualifier::Const:
		return "const";
	}
}

const char* getTyCode(Literal::Type type)
{
	switch(type)
	{
	case Literal::Type::Integer:
		return "int";
	}
}

const char* getTyCode(NativeType::Name type)
{
	switch(type)
	{
	case NativeType::Name::Void:
		return "void";
	case NativeType::Name::Int:
		return "int";
	}
}

} // namespace nem::ast