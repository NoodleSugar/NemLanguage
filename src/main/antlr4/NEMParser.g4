parser grammar NEMParser;

options {
language   = Java;
tokenVocab = NEMLexer;
}

//////////////////
// File content //
//////////////////

fileContent : topLevel+ EOF;

topLevel : fnDef ;

///////////////
// Functions //
///////////////

fnDef : FN fnSignature instrBlock ;

fnSignature : IDENTIFIER OPEN_PARENTHESIS paramSeq? CLOSE_PARENTHESIS returnType ;

paramSeq : param (COMMA param)* ;

param
    : varType                  #ParamWithoutName
    | IDENTIFIER COLON varType #ParamWithName
    ;

callOp : OPEN_PARENTHESIS argSeq? CLOSE_PARENTHESIS ;

argSeq : expr (COMMA expr)* ;

//////////////////
// Instructions //
//////////////////

instrBlock : OPEN_BRACE (instr SEMICOLON)* CLOSE_BRACE ;

instr
	: varDecl
	| varDef
	| constDef
	| assign
	| fnCall
	| incrInstr
	;

incrInstr
	: INCR lValue # InstrPreIncr
	| DECR lValue # InstrPreDecr
	| lValue INCR # InstrPostIncr
	| lValue DECR # InstrPostDecr
	;

varDecl
	: VAR IDENTIFIER COLON varType ;

varDef
	: VAR IDENTIFIER EQ expr               #VarDefWithoutType
	| VAR IDENTIFIER COLON varType EQ expr #VarDefWithType
	;

constDef
	: CONST IDENTIFIER EQ expr               #ConstDefWithoutType
	| CONST IDENTIFIER COLON varType EQ expr #ConstDefWithType
	;

assign : left = lValue assignOp right = expr ;

assignOp : op =
	( EQ
	| ADD_EQ
	| SUB_EQ
	| MUL_EQ
	| DIV_EQ
	| MOD_EQ)
	;

fnCall : lValue callOp ;

/////////////////
// Expressions //
/////////////////

expr
	: literal     # ExprLiteral
	| lValue      # ExprlValue
	| lValue INCR # ExprIncr
	| lValue DECR # ExprDecr
	| fnCall      # ExprFnCall
	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS #ExprParenthesis

	| MINUS expr #ExprMinus
	| left = expr MODULO right = expr #ExprMod
	| left = expr SLASH  right = expr #ExprDiv
	| left = expr STAR   right = expr #ExprMul
	| left = expr MINUS  right = expr #ExprSub
	| left = expr PLUS   right = expr #ExprAdd
	;

literal	: L_NUM	;

////////////////////
// Allocated data //
////////////////////

lValue
	: IDENTIFIER  #LValueId
	| INCR lValue #LValueIncr
	| DECR lValue #LValueDecr
	| OPEN_PARENTHESIS lValue CLOSE_PARENTHESIS #LValueParenthesis
	;

///////////
// Types //
///////////

varType
	: INT #Integer
	;

returnType
	: VOID    #WithoutReturnType
	| varType #WithReturnType
	;