package org.nem.visitor;

import org.nem.ast.instruction.Instruction;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

public class InstrVisitor extends NEMParserBaseVisitor<Instruction> {
	@Override
	public Instruction visitInstr(NEMParser.InstrContext ctx) {
		return super.visitInstr(ctx);
	}
}
