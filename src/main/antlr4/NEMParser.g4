parser grammar NEMParser;

options {

language   = Java;
tokenVocab = NEMLexer;

}

/*
    skip: Skips the matched text, no token will be emited
    channel(n): Emits the token on a different channel
    type(n): Changes the emitted token type
    mode(n), pushMode(n), popMode, more: Controls lexer modes
*/

/////////////////////////
// Operator Precedence //
/////////////////////////
/*
________________________________________________________________________________
++ --		Suffix/postfix increment and decrement 				| Left-to-right
()			Function call										|
[]			Array subscripting									|
.			Structure and union member access					|
->			Structure and union member access through pointer	|
________________________________________________________________|_______________
++ --		Prefix increment and decrement						| Right-to-left
+ -			Unary plus and minus								|
! ~			Logical NOT and bitwise NOT							|
(type)		Cast												|
*			Indirection (dereference)							|
&			Address-of											|
sizeof		Size-of                 							|
_Alignof	Alignment requirement(C11)							|
________________________________________________________________|_______________
* / %		Multiplication, division, and remainder 			| Left-to-right
________________________________________________________________|
+ -			Addition and subtraction							|
________________________________________________________________|
<< >>		Bitwise left shift and right shift					|
________________________________________________________________|
< <=		For relational operators < and ≤ respectively		|
> >=		For relational operators > and ≥ respectively		|
________________________________________________________________|
== !=		For relational = and ≠ respectively					|
________________________________________________________________|
&			Bitwise AND											|
________________________________________________________________|
^			Bitwise XOR (exclusive or)							|
________________________________________________________________|
|			Bitwise OR (inclusive or)							|
________________________________________________________________|
&&			Logical AND											|
________________________________________________________________|
||			Logical OR											|
________________________________________________________________|_______________
=			Simple assignment									| Right-to-left
+= -=		Assignment by sum and difference					|
*= /= %=	Assignment by product, quotient, and remainder		|
<<= >>=		Assignment by bitwise left shift and right shift	|
&= ^= |=	Assignment by bitwise AND, XOR, and OR				|
________________________________________________________________|_______________
 */

//////////////////
// File content //
//////////////////

file : top_level EOF;

top_level
	:
	| module_decl
	| module_import
	| module_export
	| EXPORT? class_def
	| EXPORT? fn_decl
	| EXPORT? fn_def
	;

/////////////
// Modules //
/////////////

module_path
	: IDENTIFIER
	| IDENTIFIER POINT module_path
	;

module_import : IMPORT module_path SEMICOLON ;

module_decl	: MODULE module_path SEMICOLON ;

module_export : EXPORT (module_import | module_decl) ;

///////////
// Class //
///////////

class_def : CLASS
	;

///////////////
// Functions //
///////////////

param
	: var_type
	| IDENTIFIER COLON var_type
	;

param_seq
	: param
	| param COMMA param_seq
	;

arg_seq
	: expr
	| expr COMMA arg_seq
	;

fn_signature :	IDENTIFIER OPEN_PARENTHESIS param_seq CLOSE_PARENTHESIS return_type ;

fn_decl : FN fn_signature ;

fn_def : FN fn_signature instr_block ;

fn_call : OPEN_PARENTHESIS arg_seq CLOSE_PARENTHESIS ;

//////////////////
// Instructions //
//////////////////

instr_block	: OPEN_BRACE instr_seq CLOSE_BRACE ;

instr_seq
	: instr SEMICOLON
	| instr SEMICOLON instr_seq
	;

instr
	: var_decl
	| var_def
	| assign
	| fn_call
	;

var_decl : (VAR | CONST) IDENTIFIER COLON var_type ;

var_def
	: (VAR | CONST) IDENTIFIER EQUAL expr
	| (VAR | CONST) IDENTIFIER COLON var_type EQUAL expr
	;

assign
	: lvalue EQUAL expr
	;

/////////////////
// Expressions //
/////////////////

literal
	: TRUE
	| FALSE
	| L_CHAR
	| L_NUM
	| L_STR
	;

expr
	: literal
	| lvalue
	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS
	;


arith_expr
	: L_NUM
	| OPEN_PARENTHESIS arith_expr CLOSE_PARENTHESIS
	| MINUS arith_expr
	| arith_expr SLASH arith_expr
    | arith_expr STAR arith_expr
    | arith_expr MINUS arith_expr
    | arith_expr PLUS arith_expr
	| if_statement arith_expr (ELSE arith_expr)?
	;

bool_expr
	: TRUE
	| FALSE
	| OPEN_PARENTHESIS bool_expr CLOSE_PARENTHESIS
	| arith_expr
		( OPEN_CHEVRON
		| CLOSE_CHEVRON
		| OP_LE
		| OP_GE ) arith_expr
	| arith_expr
		( OP_EQ
		| OP_NE) arith_expr
	| bool_expr OP_AND bool_expr
	| bool_expr OP_OR bool_expr
	;

////////////////////
// Allocated data //
////////////////////

lvalue
	: IDENTIFIER
	| OPEN_PARENTHESIS lvalue CLOSE_PARENTHESIS
	| lvalue fn_call
	| lvalue OPEN_BRACKET expr CLOSE_BRACKET
	| lvalue (POINT | ARROW) IDENTIFIER
	| STAR expr
	| (INCR | DECR) lvalue
	;

////////////////
// Conditions //
////////////////

if_statement: IF OPEN_PARENTHESIS bool_expr CLOSE_PARENTHESIS ;

///////////
// Types //
///////////

primitive_type
	: BOOL
	| CHAR
	| INT
	| FLOAT
	| DOUBLE
	;

var_type_seq
	: var_type COMMA
	| var_type COMMA var_type_seq ;

var_type
	: primitive_type
	| IDENTIFIER (OPEN_CHEVRON generic_arg_seq CLOSE_CHEVRON)?
	| OPEN_BRACKET arith_expr? CLOSE_BRACKET var_type
	| STAR CONST? var_type
	| QUESTION var_type
	| (LREF | RREF) var_type
	;

generic_arg_seq
	: generic_arg
	| generic_arg COMMA generic_arg_seq ;

generic_arg
	: VOID
	| var_type
	;

return_type	: (IDENTIFIER? EXCLAMATION)? (VOID | var_type)	;