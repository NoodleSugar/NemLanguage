lexer grammar NEMLexer;

options {

language   = Java;

}

////////////////////////
// Ignored characters //
////////////////////////

IL_COMMENT : '//' .*? ('\n' '\r'? | EOF) -> skip ;
ML_COMMENT : '/*' .*? '*/'-> skip ;

WHITESPACE : [\t\r\n ]+ -> skip ;

///////////////////////
// Simple characters //
///////////////////////

HASH  : '#' ;

PLUS  : '+' ;
MINUS : '-' ;
STAR  : '*' ;
SLASH : '/' ;
EQUAL : '=' ;

OPEN_PARENTHESIS  : '(' ;
CLOSE_PARENTHESIS : ')' ;
OPEN_BRACKET      : '[' ;
CLOSE_BRACKET     : ']' ;
OPEN_BRACE        : '{' ;
CLOSE_BRACE       : '}' ;
OPEN_CHEVRON      : '<' ;
CLOSE_CHEVRON     : '>' ;

AMPERSAND   : '&' ;
CIRCUMFLEX  : '^' ;
EXCLAMATION : '!' ;
QUESTION    : '?' ;
POINT       : '.' ;
COMMA       : ',' ;
COLON       : ':' ;
SEMICOLON   : ';' ;

///////////////
// Operators //
///////////////

// Boolean operators

OP_OR  : '||' ;
OP_AND : '&&' ;
OP_EQ  : '==' ;
OP_NE  : '!=' ;
OP_LE  : '<=' ;
OP_GE  : '>=' ;

// Assignement operators

EQ_ADD : '+=' ;
EQ_SUB : '-=' ;
EQ_MUL : '*=' ;
EQ_DIV : '/=' ;

// Increment operators

INCR : '++' ;
DECR : '--' ;

ARROW : '->' ;

//////////////
// Keywords //
//////////////

MODULE    : 'module' ;
IMPORT    : 'import' ;
EXPORT    : 'export' ;
NAMESPACE : 'namespace' ;
TYPE      : 'type' ;
CLASS     : 'class' ;
COMPTIME  : 'comptime' ;

// Access modifier

PUBLIC    : 'public' ;
PRIVATE   : 'private' ;
PROTECTED : 'protected' ;

// Control structures
IF       : 'if' ;
ELSE     : 'else' ;
WHILE    : 'while' ;
FOR      : 'for' ;
SWITCH   : 'switch' ;
CASE     : 'case' ;
CONTINUE : 'continue' ;
BREAK    : 'break' ;
RETURN   : 'return' ;

// Booleans
TRUE : 'true' ;
FALSE : 'false' ;

// Primitives types
VOID   : 'void' ;
BOOL   : 'bool' ;
CHAR   : 'char' ;
INT    : 'int' ;
FLOAT  : 'float' ;
DOUBLE : 'double' ;
SHORT  : 'short' ;
LONG   : 'long' ;

FN    : 'fn' ;
VAR   : 'var' ;
CONST : 'const' ;

SIGNED   : 'signed' ;
UNSIGNED : 'unsigned' ;

LREF  : 'l&' ;
RREF  : 'r&' ;
FREF  : 'f&' ;

///////////////
// Litterals //
///////////////

fragment Z : '0' ;
fragment B : [01] ;
fragment O : [0-7] ;
fragment D : [0-9] ;
fragment H : [0-9a-fA-F] ;

fragment INT_SUFFIX : [uUlL];
fragment FLOAT_SUFFIX : [fF];

fragment L_INT : D+ INT_SUFFIX?;
fragment L_DEC
	: L_INT? POINT L_INT FLOAT_SUFFIX?
	| L_INT POINT L_INT? FLOAT_SUFFIX?
	;
fragment L_EXP : (L_INT | L_DEC) [eE][+-]? L_INT FLOAT_SUFFIX? ;

fragment L_BIN : Z [bB] B+ (['] B+)* INT_SUFFIX? ;
fragment L_OCT : Z [oO] O+ (['] O+)* INT_SUFFIX? ;
fragment L_HEX : Z [xX] H+ (['] H+)* INT_SUFFIX? ;

L_NUM
	: L_INT
    | L_DEC
    | L_EXP
    | L_BIN
    | L_OCT
    | L_HEX
	;

L_CHAR : '\'' ( '\\'. | ~[\\'] ) '\'' ;

L_STR : '"' ( '\\'. | ~[\\"] )*? '"' ;

IDENTIFIER : [_a-zA-Z][_a-zA-Z0-9]* ;

/* TODO
 * - conditions et boucles
 * - fonctions
 * - classes
 */