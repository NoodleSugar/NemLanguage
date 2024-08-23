#pragma once

#include "ForEach.hpp"

////////////////////////
// Declaration macros //
////////////////////////

#define NEM_DECLARE_ALL_AST_UNIONS NEM_FOR_EACH_AST_UNIONS(NEM_DECLARE_AST_UNION)
#define NEM_DECLARE_ALL_AST_TYPES                \
	NEM_FOR_EACH_AST_ENUMS(NEM_DECLARE_AST_ENUM) \
	NEM_FOR_EACH_AST_TYPES(NEM_DECLARE_AST_STRUCT)
#define NEM_DECLARE_ALL_AST_NODE_ALIASES NEM_FOR_EACH_AST_TYPES(NEM_DECLARE_AST_NODE_ALIAS)

#define NEM_DECLARE_AST_UNION(U)	  using U##Node = std::variant<NEM_LIST_OF_AST_UNION_TYPES_OF(U)>;
#define NEM_DECLARE_AST_STRUCT(S)	  struct S;
#define NEM_DECLARE_AST_ENUM(E)		  enum class E##Enum;
#define NEM_DECLARE_AST_NODE_ALIAS(T) using T##Node = nem::ast::Node<T>;