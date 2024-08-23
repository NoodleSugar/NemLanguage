#pragma once

//////////////////////////////
// List of ast unions types //
//////////////////////////////

#define NEM_LIST_OF_AST_UNION_TYPES_OF_Expression \
	 LiteralNode,                                 \
	 IdentifierNode

#define NEM_LIST_OF_AST_UNION_TYPES_OF_Instruction \
	 DeclarationNode,                              \
	 DefinitionNode

#define NEM_LIST_OF_AST_UNION_TYPES_OF_UnqualifiedType \
	NativeTypeNode

#define NEM_LIST_OF_AST_UNION_TYPES_OF_Type \
	NativeTypeNode
