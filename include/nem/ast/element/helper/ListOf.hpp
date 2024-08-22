#pragma once

#include "../ListOfStructAttribs.hpp"

//////////////////////////////////////////
// Utilities for NEM_LIST_OF_XXX macros //
//////////////////////////////////////////

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF(S) \
	NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_##S
