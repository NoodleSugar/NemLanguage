#pragma once

////////////////////////////////////
// List of ast structs attributes //
////////////////////////////////////

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_File \
	(FunctionNodeList, functions)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Function \
	(IdentifierNode, identifier),                  \
	 (TypeNodeOpt, returnType),                    \
	 (ParameterNodeList, parameters),              \
	 (InstructionNodeList, instructions)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Parameter \
	(IdentifierNode, identifier),                   \
	 (TypeNode, type)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Block \
	(InstructionNodeList, instructions)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Call \
	(IdentifierNode, name),                    \
	 (ExpressionNodeList, arguments)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Literal \
	(std::string, value)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Identifier \
	(std::string, name)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Minus \
	(ExpressionNodePtr, expression)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Arithmetic \
	(ArithOp, op),                                   \
	 (ExpressionNodePtr, left),                      \
	 (ExpressionNodePtr, right)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Declaration \
	(IdentifierNode, identifier),                     \
	 (TypeNode, type)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Definition \
	(IdentifierNode, identifier),                    \
	 (TypeNodeOpt, type),                            \
	 (ExpressionNode, value)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Assignment \
	(AssignOp, op),                                  \
	 (IdentifierNode, left),                         \
	 (ExpressionNode, right)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_Return \
	(ExpressionNodeOpt, value)

#define NEM_LIST_OF_AST_STRUCT_ATTRIBS_OF_ConstType \
	(UnqualifiedTypeNode, type)
