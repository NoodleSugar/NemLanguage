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

fnDef : FN IDENTIFIER OPEN_PARENTHESIS paramSeq? CLOSE_PARENTHESIS type block ;

paramSeq : param (COMMA param)* ;

param : IDENTIFIER COLON type ;

call : IDENTIFIER OPEN_PARENTHESIS argSeq? CLOSE_PARENTHESIS ;

argSeq : expr (COMMA expr)* ;

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
	: literal    #ExprLiteral
	| IDENTIFIER #ExprIdentifier
	| call       #ExprCall

	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS #ExprParan

	| MINUS expr                      #ExprUnMinus
	| left = expr AND      right = expr #ExprBinAnd
	| left = expr OR       right = expr #ExprBinOr
	| left = expr C_EQ     right = expr #ExprBinEQ
	| left = expr C_NE     right = expr #ExprBinNE
	| left = expr C_LE     right = expr #ExprBinLE
	| left = expr C_GE     right = expr #ExprBinGE
	| left = expr LCHEVRON right = expr #ExprBinLT
	| left = expr RCHEVRON right = expr #ExprBinGT
	| left = expr SLASH    right = expr #ExprBinSlash
	| left = expr STAR     right = expr #ExprBinStar
	| left = expr MINUS    right = expr #ExprBinMinus
	| left = expr PLUS     right = expr #ExprBinPlus
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
