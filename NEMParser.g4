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

call : IDENTIFIER OPEN_PARENTHESIS CLOSE_PARENTHESIS ;

//////////////////
// Instructions //
//////////////////

block : OPEN_BRACE instr* CLOSE_BRACE ;

instr : terminatedInstr SEMICOLON #InstrTerminated ;

terminatedInstr
	: IF OPEN_PARENTHESIS cond = expr CLOSE_PARENTHESIS then = block (ELSE else = block)? #InstrIf

	| RETURN expr #InstrReturnValue
	;

/////////////////
// Expressions //
/////////////////

expr
	: literal #ExprLiteral
	| call    #ExprCall

	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS #ExprParan

	| MINUS expr                      #ExprUnMinus
	| left = expr AND    right = expr #ExprBinAnd
	| left = expr OR     right = expr #ExprBinOr
	| left = expr SLASH  right = expr #ExprBinSlash
	| left = expr STAR   right = expr #ExprBinStar
	| left = expr MINUS  right = expr #ExprBinMinus
	| left = expr PLUS   right = expr #ExprBinPlus
	;

literal
	: L_BOOL #LiteralBool
	| L_INT  #LiteralInt
	| L_REAL #LiteralReal
	;

///////////
// Types //
///////////

type
	: BOOL #TypeBool
	| INT  #TypeInt
	| REAL #TypeReal
	;
