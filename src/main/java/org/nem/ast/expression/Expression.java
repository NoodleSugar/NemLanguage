package org.nem.ast.expression;

public sealed interface Expression permits
		ExprNum,
		ExprLValue,
		ExprIncr,
		ExprDecr,
		ExprFnCall,
		ExprMinus,
		ExprArith {
}
