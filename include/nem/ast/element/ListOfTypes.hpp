#pragma once

///////////////////////
// List of ast types //
///////////////////////

#define NEM_LIST_OF_AST_UNIONS \
	Expression,                \
	Type

#define NEM_LIST_OF_AST_STRUCTS \
	Literal

#define NEM_LIST_OF_AST_ENUMS \
	NativeType

#define NEM_LIST_OF_AST_TYPES \
	NEM_LIST_OF_AST_STRUCTS,  \
	 NEM_LIST_OF_AST_ENUMS
