package org.nem.ast.instruction;

import org.nem.ast.expression.Expression;
import org.nem.ast.value.LValue;

import java.util.List;

public record FnCall(LValue fnName, List<Expression> arguments) implements Instruction {
}
