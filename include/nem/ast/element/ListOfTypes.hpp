#pragma once

///////////////////////
// List of ast types //
///////////////////////

#define NEM_LIST_OF_AST_UNIONS \
	Expression,                \
	 Instruction,              \
	 UnqualifiedType,          \
	 Type

#define NEM_LIST_OF_AST_STRUCTS \
	Identifier,                 \
	 ConstType,                 \
	 Parameter,                 \
	 Literal,                   \
	 Minus,                     \
	 Arithmetic,                \
	 Call,                      \
	 Declaration,               \
	 Definition,                \
	 Assignment,                \
	 Return,                    \
	 Block,                     \
	 Function,                  \
	 File

#define NEM_LIST_OF_AST_ENUMS \
	NativeType

#define NEM_LIST_OF_AST_TYPES \
	NEM_LIST_OF_AST_STRUCTS,  \
	 NEM_LIST_OF_AST_ENUMS
