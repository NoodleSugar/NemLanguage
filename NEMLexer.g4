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

EQ : '=' ;

PLUS  : '+' ;
MINUS : '-' ;
STAR  : '*' ;
SLASH : '/' ;

OPEN_PARENTHESIS  : '(' ;
CLOSE_PARENTHESIS : ')' ;
OPEN_BRACE        : '{' ;
CLOSE_BRACE       : '}' ;

POINT     : '.' ;
SEMICOLON : ';' ;

//////////////
// Keywords //
//////////////

FN : 'fn' ;

RETURN : 'return' ;

OR  : 'or' ;
AND : 'and' ;

// Native types
BOOL : 'bool' ;
INT  : 'int' ;
REAL : 'real' ;

//////////////
// Literals //
//////////////

fragment L_TRUE  : 'true' ;
fragment L_FALSE : 'false' ;

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

L_BOOL : L_TRUE | L_FALSE ;

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
