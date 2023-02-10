package org.nem.ast.value;

public class LValueIncr implements LValue {
	public final LValue lValue;

	public LValueIncr(LValue lValue) {
		this.lValue = lValue;
	}
}
