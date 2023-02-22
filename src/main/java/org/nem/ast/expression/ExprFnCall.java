package org.nem.ast.expression;

import org.nem.ast.instruction.Instruction;
import org.nem.ast.value.LValue;

import java.util.List;

public record ExprFnCall(LValue fnName, List<Expression> arguments) implements Expression {
}
