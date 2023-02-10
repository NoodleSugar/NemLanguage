package org.nem.ast.value;

public class LValueDecr implements LValue {
	public final LValue lValue;

	public LValueDecr(LValue lValue) {
		this.lValue = lValue;
	}
}
