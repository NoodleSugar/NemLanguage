#pragma once

////////////////////////////////////
// List of ast structs attributes //
////////////////////////////////////

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Literal \
	(std::string, value)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Identifier \
	(std::string, name)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Declaration \
	(IdentifierNode, identifier),                     \
	 (TypeNode, type)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Definition \
	(IdentifierNode, identifier),                    \
	 (TypeNodeOpt, type),                            \
	 (ExpressionNode, value)

