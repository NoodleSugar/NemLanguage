lexer grammar NEMLexer;

options {
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

PLUS   : '+' ;
MINUS  : '-' ;
STAR   : '*' ;
SLASH  : '/' ;
MODULO : '%' ;

OPEN_PARENTHESIS  : '(' ;
CLOSE_PARENTHESIS : ')' ;
OPEN_BRACE        : '{' ;
CLOSE_BRACE       : '}' ;
OPEN_CHEVRON      : '<' ;
CLOSE_CHEVRON     : '>' ;

POINT       : '.' ;
COMMA       : ',' ;
COLON       : ':' ;
SEMICOLON   : ';' ;
EXCLAMATION : '!' ;

///////////////
// Operators //
///////////////

// Assignement operators

EQ     : '=' ;
ADD_EQ : '+=' ;
SUB_EQ : '-=' ;
MUL_EQ : '*=' ;
DIV_EQ : '/=' ;
MOD_EQ : '%=' ;

//////////////
// Keywords //
//////////////

FN    : 'fn' ;
VAR   : 'var' ;
CONST : 'const' ;

RETURN : 'return' ;

// Native types
BOOL : 'bool' ;
INT  : 'int' ;
UINT : 'uint' ;
REAL : 'real' ;

//////////////
// Literals //
//////////////

fragment Z : '0' ;
fragment B : [01] ;
fragment O : [0-7] ;
fragment D : [0-9] ;
fragment H : [0-9a-fA-F] ;

fragment L_BIN : Z [bB] B+ (['] B+)* ;
fragment L_OCT : Z [oO] O+ (['] O+)* ;
fragment L_HEX : Z [xX] H+ (['] H+)* ;
fragment L_DEC : D+;

fragment L_FLOAT: L_DEC POINT L_DEC;
fragment L_EXP  : (L_DEC | L_FLOAT) 'e' MINUS? L_DEC;

L_BOOL
	: 'true'
	| 'false'
	;

L_INT
	: L_BIN
	| L_OCT
	| L_HEX
	| L_DEC
	;

L_REAL
	: L_FLOAT
	| L_EXP
	;

IDENTIFIER : [_a-zA-Z][_a-zA-Z0-9]* ;

ANY: . ;
