#pragma once

//////////////////////////////
// List of ast unions types //
//////////////////////////////

#define NEM_LIST_OF_AST_UNION_TYPES_OF_Expression \
	CallNode,                                     \
	 LiteralNode,                                 \
	 IdentifierNode,                              \
	 MinusNode,                                   \
	 ArithmeticNode

#define NEM_LIST_OF_AST_UNION_TYPES_OF_Instruction \
	CallNode,                                      \
	 BlockNode,                                    \
	 DeclarationNode,                              \
	 DefinitionNode,                               \
	 AssignmentNode,                               \
	 ReturnNode

#define NEM_LIST_OF_AST_UNION_TYPES_OF_UnqualifiedType \
	NativeTypeNode

#define NEM_LIST_OF_AST_UNION_TYPES_OF_Type \
	NativeTypeNode,                         \
	 ConstTypeNode
