lexer grammar NEMLexer;

options {
}

////////////////////////
// Ignored characters //
////////////////////////

IL_COMMENT : '//' .*? ('\n' '\r'? | EOF) -> skip ;
ML_COMMENT : '/*' .*? '*/'-> skip ;

WHITESPACE : [\t\r\n ]+ -> skip ;

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

L_INT
	: L_BIN
	| L_OCT
	| L_HEX
	| L_DEC
	;

ANY: . ;
