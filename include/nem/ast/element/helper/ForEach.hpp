#pragma once

#include "../ListOfTypes.hpp"
#include "ListOf.hpp"
#include "nem/util/Macros.hpp"

////////////////////
// ForEach macros //
////////////////////

#define NEM_FOR_EACH_AST_STRUCTS(X) NEM_FOR_EACH(X, NEM_LIST_OF_AST_STRUCTS)
#define NEM_FOR_EACH_AST_TYPES(X)	NEM_FOR_EACH(X, NEM_LIST_OF_AST_TYPES)

#define NEM_FOR_EACH_AST_STRUCT_ATTRIB_OF(S, X) NEM_FOR_EACH_DEFERED(X, NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF(S))