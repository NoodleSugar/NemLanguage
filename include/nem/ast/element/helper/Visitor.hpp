#pragma once

////////////////////
// Visitor macros //
////////////////////

#define NEM_DECLARE_ALL_AST_TYPES_VISIT_METHOD NEM_FOR_EACH_AST_TYPES(NEM_DECLARE_AST_TYPE_VISIT_METHOD)

#define NEM_DEFINE_ALL_AST_TYPES_VISIT_METHOD                       \
	NEM_EVAL(NEM_FOR_EACH_AST_STRUCTS(NEM_DEFINE_AST_STRUCT_VISIT)) \
	NEM_EVAL(NEM_FOR_EACH_AST_ENUMS(NEM_DEFINE_AST_ENUM_VISIT))

#define NEM_DECLARE_AST_TYPE_VISIT_METHOD(T) virtual void visit(T##Node&);

#define NEM_DEFINE_AST_ENUM_VISIT(E) void Visitor::visit(E##Node& n){}

#define NEM_DEFINE_AST_STRUCT_VISIT(S)                  \
	void Visitor::visit(S##Node& n)                     \
	{                                                   \
		NEM_FOR_EACH_AST_STRUCT_ATTRIB_OF(S, NEM_VISIT) \
	}

#define NEM_VISIT(F)			NEM_VISIT_DETAILS F
#define NEM_VISIT_DETAILS(T, N) visit(n.N);