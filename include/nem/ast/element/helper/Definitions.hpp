#pragma once

#include "ForEach.hpp"

///////////////////////
// Definition macros //
///////////////////////

#define NEM_DEFINE_ALL_AST_TYPES \
	NEM_EVAL(NEM_FOR_EACH_AST_STRUCTS(NEM_DEFINE_AST_STRUCT))

#define NEM_DEFINE_AST_STRUCT(S)                                          \
	struct S                                                              \
	{                                                                     \
		NEM_FOR_EACH_AST_STRUCT_ATTRIB_OF(S, NEM_DEFINE_AST_STRUCT_FIELD) \
	};

#define NEM_DEFINE_AST_STRUCT_FIELD(F)			  NEM_DEFINE_AST_STRUCT_FIELD_DETAILS F
#define NEM_DEFINE_AST_STRUCT_FIELD_DETAILS(T, N) T N;
