package org.nem.ast.instruction;

public sealed interface Instruction permits
		VarDecl,
		VarDef,
		ConstDef,
		Assign,
		FnCall,
		PreIncr,
		PostIncr,
		PreDecr,
		PostDecr {
}
