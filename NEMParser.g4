parser grammar NEMParser;

options {
tokenVocab = NEMLexer;
}

/////////////////
// Expressions //
/////////////////

expr
	: literal #ExprLiteral
	;

literal
	: L_INT  #LiteralInt
	| L_REAL #LiteralReal
	;

///////////
// Types //
///////////

unqualifiedType
	: INT  #TypeInt
	| UINT #TypeUInt
	| REAL #TypeReal
	;

type
	:       unqualifiedType #TypeWithoutQualifier
	;
