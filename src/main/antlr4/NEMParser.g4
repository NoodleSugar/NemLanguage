parser grammar NEMParser;

options {
language   = Java;
tokenVocab = NEMLexer;
}

//////////////////
// File content //
//////////////////

file_content : top_level+ EOF;

top_level : fn_def ;

///////////////
// Functions //
///////////////

fn_def : FN fn_signature instr_block ;

fn_signature : IDENTIFIER OPEN_PARENTHESIS param_seq? CLOSE_PARENTHESIS return_type ;

param_seq : param (COMMA param)* ;

param
    : var_type
    | IDENTIFIER COLON var_type
    ;

op_call : OPEN_PARENTHESIS arg_seq? CLOSE_PARENTHESIS ;

arg_seq
	: expr
	| expr COMMA arg_seq
	;

//////////////////
// Instructions //
//////////////////

instr_block	: OPEN_BRACE instr_seq? CLOSE_BRACE ;

instr_seq : (instr SEMICOLON)+ ;

instr
	: var_decl
	| var_def
	| const_def
	| assign
	| fn_call
	;

var_decl
	: VAR IDENTIFIER COLON var_type ;

var_def
	: VAR IDENTIFIER EQ expr
	| VAR IDENTIFIER COLON var_type EQ expr
	;

const_def : CONST IDENTIFIER COLON var_type EQ expr ;

assign : lvalue assign_operator expr ;

assign_operator
	: EQ
	| EQ_ADD
	| EQ_SUB
	| EQ_MUL
	| EQ_DIV
	| EQ_MOD
	;

fn_call : lvalue op_call ;

/////////////////
// Expressions //
/////////////////

expr
	: literal
	| lvalue
	| lvalue (INCR | DECR)
	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS

	| MINUS expr
	| expr
		( MODULO
		| SLASH
		| STAR ) expr
    | expr
        ( PLUS
        | MINUS ) expr
	;

literal	: L_NUM	;

////////////////////
// Allocated data //
////////////////////

lvalue
	: IDENTIFIER
	| OPEN_PARENTHESIS lvalue CLOSE_PARENTHESIS
	| (INCR | DECR) lvalue
	;

///////////
// Types //
///////////

var_type : primitive_type ;

primitive_type : INT;

return_type
	: VOID
	| var_type
	;