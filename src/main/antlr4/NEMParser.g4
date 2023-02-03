parser grammar NEMParser;

// TODO Classes et interfaces paramétrées

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

file : top_level_seq EOF;

top_level_seq
	: top_level SEMICOLON
	| top_level SEMICOLON top_level_seq
	;

top_level
	:
	| module_decl
	| module_import
	| module_export
	| EXPORT? interface_def
	| EXPORT? class_def
	| EXPORT? struct_def
	| EXPORT? fn_def
	;

/////////////
// Modules //
/////////////

module_path
	: IDENTIFIER
	| IDENTIFIER POINT module_path
	;

module_decl	  : MODULE module_path ;
module_import : IMPORT module_path ;
module_export : EXPORT (module_import | module_decl) ;

//////////////////
// Custom types //
//////////////////

access_modifier
	: PUBLIC
	| PRIVATE
	| PROTECTED
	;

interface_content
	: CONST? fn_decl SEMICOLON
	;

class_content
	: STATIC? var_decl   SEMICOLON
	| STATIC? var_def    SEMICOLON
	| STATIC? const_decl SEMICOLON
	| STATIC? const_def  SEMICOLON
	| CONST? fn_def OVERRIDE?
	| VIRTUAL CONST? fn_def
	| STATIC fn_def
	;

struct_content
	: var_decl   SEMICOLON
	| const_decl SEMICOLON
	;

enum_content : IDENTIFIER ;


interface_def : INTERFACE IDENTIFIER OPEN_BRACE interface_content+ CLOSE_BRACE ;

class_def : FINAL? CLASS IDENTIFIER OPEN_BRACE (access_modifier COLON class_content+)+ CLOSE_BRACE ;

struct_def : STRUCT IDENTIFIER OPEN_BRACE struct_content+ CLOSE_BRACE ;

enum_def : ENUM IDENTIFIER OPEN_BRACE enum_content+ CLOSE_BRACE ;

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

fn_signature :	IDENTIFIER OPEN_PARENTHESIS param_seq? CLOSE_PARENTHESIS return_type ;

fn_decl : FN fn_signature ;
fn_def  : FN fn_signature instr_block ;

op_call : OPEN_PARENTHESIS arg_seq? CLOSE_PARENTHESIS ;

//////////////////
// Instructions //
//////////////////

instr_block	: OPEN_BRACE instr_seq? CLOSE_BRACE ;

instr_seq
	: instr SEMICOLON
	| instr SEMICOLON instr_seq
	;

instr
	: var_decl
	| var_def
	| const_def
	| assign
	| lvalue op_call
	;

var_decl
	: VAR IDENTIFIER COLON var_type ;
var_def
	: VAR IDENTIFIER EQ expr
	| VAR IDENTIFIER COLON var_type EQ expr
	;

const_decl : CONST IDENTIFIER COLON var_type ;
const_def  : CONST IDENTIFIER COLON var_type EQ expr ;

assign
	: lvalue EQ expr
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
	| array_init
	| struct_init
	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS
	| if_statement expr (ELSE expr)?

	| MINUS expr
	| expr
		( MODULO
		| SLASH
		| STAR ) expr
    | expr
        ( PLUS
        | MINUS ) expr

    | expr
        ( OPEN_CHEVRON
        | CLOSE_CHEVRON
        | OP_LE
        | OP_GE ) expr
    | expr
        ( OP_EQ
        | OP_NE) expr
    | expr OP_AND expr
    | expr OP_OR expr
	;

array_init : OPEN_BRACE arg_seq? CLOSE_BRACE ;
struct_init : IDENTIFIER? OPEN_BRACE (struct_member_init_seq)* CLOSE_BRACE ;

struct_member_init : IDENTIFIER EQ expr ;
struct_member_init_seq
	: struct_member_init
	| struct_member_init COMMA struct_member_init_seq
	;

////////////////////
// Allocated data //
////////////////////

lvalue
	: IDENTIFIER
	| OPEN_PARENTHESIS lvalue CLOSE_PARENTHESIS
	| lvalue op_call
	| lvalue OPEN_BRACKET expr CLOSE_BRACKET
	| lvalue (POINT | ARROW) IDENTIFIER
	| STAR expr
	| (INCR | DECR) lvalue
	;

////////////////
// Conditions //
////////////////

if_statement: IF OPEN_PARENTHESIS expr CLOSE_PARENTHESIS ;

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
	| IDENTIFIER (OPEN_CHEVRON type_arg_seq CLOSE_CHEVRON)?
	| OPEN_BRACKET expr? CLOSE_BRACKET var_type
	| STAR CONST? var_type
	| QUESTION var_type
	| (LREF | RREF) var_type
	;

return_type	: (IDENTIFIER? EXCLAMATION)? (VOID | var_type)	;

type_arg_seq
	: type_arg
	| type_arg COMMA type_arg_seq ;

type_arg
	: VOID
	| var_type
	;
