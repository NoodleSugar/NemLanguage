package org.nem.ast.expression;

public class ExprNum implements Expression {
	public final String value;

	public ExprNum(String value){
		this.value = value;
	}
}
