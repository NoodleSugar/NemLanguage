#pragma once

#include "../ListOfEnumValues.hpp"
#include "../ListOfStructAttribs.hpp"
#include "../ListOfUnionTypes.hpp"

//////////////////////////////////////////
// Utilities for NEM_LIST_OF_XXX macros //
//////////////////////////////////////////

#define NEM_LIST_OF_AST_UNION_TYPES_OF(U) \
	NEM_LIST_OF_AST_UNION_TYPES_OF_##U

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF(S) \
	NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_##S

#define NEM_LIST_OF_AST_ENUM_VALUES_OF(E) \
	NEM_LIST_OF_AST_ENUM_VALUES_OF_##E