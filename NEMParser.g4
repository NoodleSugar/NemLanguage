parser grammar NEMParser;

options {
tokenVocab = NEMLexer;
}

//////////
// File //
//////////

file : topLevel+ EOF;

topLevel : fnDef ;

///////////////
// Functions //
///////////////

fnDef : FN IDENTIFIER OPEN_PARENTHESIS CLOSE_PARENTHESIS type block ;

//////////////////
// Instructions //
//////////////////

block : OPEN_BRACE instr* CLOSE_BRACE ;

instr : terminatedInstr SEMICOLON #InstrTerminated ;

terminatedInstr : RETURN expr #InstrReturnValue ;

/////////////////
// Expressions //
/////////////////

expr : literal #ExprLiteral ;
literal
	: L_INT  #LiteralInt
	| L_REAL #LiteralReal
	;

///////////
// Types //
///////////

type
	: INT  #TypeInt
	| REAL #TypeReal
	;
