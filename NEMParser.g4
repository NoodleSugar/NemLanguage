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

fnDef : FN IDENTIFIER OPEN_PARENTHESIS paramSeq? CLOSE_PARENTHESIS type? block ;

paramSeq : param (COMMA param)* ;

param : IDENTIFIER COLON type ;

call : IDENTIFIER OPEN_PARENTHESIS argSeq? CLOSE_PARENTHESIS ;

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
	: VAR   IDENTIFIER COLON type         #InstrVarDecl
	| VAR   IDENTIFIER COLON type EQ expr #InstrVarDefWithType
	| VAR   IDENTIFIER            EQ expr #InstrVarDefWithoutType

	| IDENTIFIER EQ     expr #InstrAssign
	| IDENTIFIER ADD_EQ expr #InstrAssignAdd
	| IDENTIFIER SUB_EQ expr #InstrAssignSub
	| IDENTIFIER MUL_EQ expr #InstrAssignMul
	| IDENTIFIER DIV_EQ expr #InstrAssignDiv
	| IDENTIFIER MOD_EQ expr #InstrAssignMod

	| call #InstrCall

	| RETURN expr #InstrReturnValue
	| RETURN      #InstrReturn
	;

/////////////////
// Expressions //
/////////////////

expr
	: literal    #ExprLiteral
	| IDENTIFIER #ExprIdentifier
	| call       #ExprCall
	| OPEN_PARENTHESIS expr CLOSE_PARENTHESIS #ExprParenthesis

	| MINUS expr #ExprMinus
	| left = expr MODULO right = expr #ExprMod
	| left = expr SLASH  right = expr #ExprDiv
	| left = expr STAR   right = expr #ExprMul
	| left = expr MINUS  right = expr #ExprSub
	| left = expr PLUS   right = expr #ExprAdd
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
	| CONST unqualifiedType #TypeWithConst
	;
