#pragma once

#include "ForEach.hpp"

///////////////////////
// Definition macros //
///////////////////////

#define NEM_DEFINE_ALL_AST_TYPES                                  \
	NEM_EVAL(NEM_FOR_EACH_AST_ENUMS(NEM_DEFINE_AST_ENUM))         \
	NEM_EVAL(NEM_FOR_EACH_AST_ENUMS(NEM_DEFINE_AST_ENUM_WRAPPER)) \
	NEM_EVAL(NEM_FOR_EACH_AST_STRUCTS(NEM_DEFINE_AST_STRUCT))

#define NEM_DEFINE_AST_STRUCT(S)                                          \
	struct S                                                              \
	{                                                                     \
		NEM_FOR_EACH_AST_STRUCT_ATTRIB_OF(S, NEM_DEFINE_AST_STRUCT_FIELD) \
	};

#define NEM_DEFINE_AST_STRUCT_FIELD(F)			  NEM_DEFINE_AST_STRUCT_FIELD_DETAILS F
#define NEM_DEFINE_AST_STRUCT_FIELD_DETAILS(T, N) T N;

#define NEM_DEFINE_AST_ENUM_WRAPPER(E) \
	struct E                           \
	{                                  \
		E##Enum value;                 \
	};

#define NEM_DEFINE_AST_ENUM(E) enum class E##Enum{NEM_LIST_OF_AST_ENUM_VALUES_OF(E)};
