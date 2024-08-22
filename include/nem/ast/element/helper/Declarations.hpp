#pragma once

#include "ForEach.hpp"

////////////////////////
// Declaration macros //
////////////////////////

#define NEM_DECLARE_ALL_AST_TYPES \
	NEM_FOR_EACH_AST_TYPES(NEM_DECLARE_AST_STRUCT)
#define NEM_DECLARE_ALL_AST_NODE_ALIASES NEM_FOR_EACH_AST_TYPES(NEM_DECLARE_AST_NODE_ALIAS)

#define NEM_DECLARE_AST_STRUCT(S)	  struct S;
#define NEM_DECLARE_AST_NODE_ALIAS(T) using T##Node = nem::ast::Node<T>;