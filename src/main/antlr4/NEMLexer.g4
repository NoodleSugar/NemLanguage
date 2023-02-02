lexer grammar NEMLexer;

options {
language = Java;
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
EQ_ADD : '+=' ;
EQ_SUB : '-=' ;
EQ_MUL : '*=' ;
EQ_DIV : '/=' ;
EQ_MOD : '%=' ;

// Increment operators

INCR : '++' ;
DECR : '--' ;

//////////////
// Keywords //
//////////////

FN    : 'fn' ;
VAR   : 'var' ;
CONST : 'const' ;

RETURN   : 'return' ;

// Primitives types
VOID   : 'void' ;
INT    : 'int' ;

///////////////
// Litterals //
///////////////

fragment Z : '0' ;
fragment B : [01] ;
fragment O : [0-7] ;
fragment D : [0-9] ;
fragment H : [0-9a-fA-F] ;

fragment L_BIN : Z [bB] B+ (['] B+)* ? ;
fragment L_OCT : Z [oO] O+ (['] O+)* ? ;
fragment L_HEX : Z [xX] H+ (['] H+)* ? ;
fragment L_INT : D+?;

L_NUM
	: L_BIN
	| L_OCT
	| L_HEX
	| L_INT
	;

IDENTIFIER : [_a-zA-Z][_a-zA-Z0-9]* ;