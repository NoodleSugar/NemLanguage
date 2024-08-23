parser grammar NEMParser;

options {
tokenVocab = NEMLexer;
}

//////////////////
// Instructions //
//////////////////


instr
	: terminatedInstr SEMICOLON #InstrTerminated
	;

terminatedInstr
	: VAR   IDENTIFIER COLON type         #InstrVarDecl
	| VAR   IDENTIFIER COLON type EQ expr #InstrVarDefWithType
	| VAR   IDENTIFIER            EQ expr #InstrVarDefWithoutType
	;

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
