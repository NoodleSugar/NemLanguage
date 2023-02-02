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

fnDef : FN fnSignature block ;

fnSignature : IDENTIFIER OPEN_PARENTHESIS paramSeq? CLOSE_PARENTHESIS type ;

paramSeq : param (COMMA param)* ;

param : IDENTIFIER COLON varType ;

fnCall : IDENTIFIER OPEN_PARENTHESIS argSeq? CLOSE_PARENTHESIS ;

argSeq : expr (COMMA expr)* ;

//////////////////
// Instructions //
//////////////////

block : OPEN_BRACE instr* CLOSE_BRACE ;

 instr
	: terminatedInstr SEMICOLON #InstrTerminated
	| block                     #InstrBlock
	;

terminatedInstr
	: VAR   IDENTIFIER COLON varType         #InstrVarDecl
	| VAR   IDENTIFIER COLON varType EQ expr #InstrVarDefWithType
	| VAR   IDENTIFIER               EQ expr #InstrVarDefWithoutType

	| lValue EQ     expr #InstrAssignSimple
	| lValue ADD_EQ expr #InstrAssignAdd
	| lValue SUB_EQ expr #InstrAssignSub
	| lValue MUL_EQ expr #InstrAssignMul
	| lValue DIV_EQ expr #InstrAssignDiv
	| lValue MOD_EQ expr #InstrAssignMod

	| fnCall   #InstrFnCall

	| RETURN expr #InstrReturnWithValue
	| RETURN      #InstrReturnWithoutValue
	;

/////////////////
// Expressions //
/////////////////

expr
	: literal  #ExprLiteral
	| lValue   #ExprLValue
	| fnCall   #ExprFnCall
	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS #ExprParenthesis

	| MINUS expr #ExprMinus
	| left = expr MODULO right = expr #ExprMod
	| left = expr SLASH  right = expr #ExprDiv
	| left = expr STAR   right = expr #ExprMul
	| left = expr MINUS  right = expr #ExprSub
	| left = expr PLUS   right = expr #ExprAdd
	;

literal	: L_INT	#LiteralInteger;

////////////////////
// Allocated data //
////////////////////

lValue : IDENTIFIER #Variable ;

///////////
// Types //
///////////

unqualifiedType
	: INT #TypeInteger
	;

varType
	:       unqualifiedType #TypeWithoutQualifier
	| CONST unqualifiedType #TypeWithConst
	;

type
	: VOID    #TypeVoid
	| varType #TypeNonVoid
	;