#pragma once

#include "ForwardAst.hpp"

namespace nem::ast
{

template<AstType>
struct _getClass;

template<AstType T>
using getClass = typename _getClass<T>::Type;

#define X(T)                     \
	template<>                   \
	struct _getClass<AstType::T> \
	{                            \
		using Type = T;          \
	};
LIST_OF_AST_TYPES
#undef X

template<class>
AstType getAstType();

template<class>
const char* getAstCode();

char getOpCode(ArithOp);

const char* getOpCode(AssignOp);

const char* getQCode(QualifiedType::Qualifier);

const char* getTyCode(Literal::Type);

const char* getTyCode(NativeType::Name);

} // namespace nem::ast