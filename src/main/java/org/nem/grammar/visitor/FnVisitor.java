package org.nem.grammar.visitor;

import org.nem.ast.function.Function;
import org.nem.ast.function.Parameter;
import org.nem.ast.instruction.Instruction;
import org.nem.ast.type.Type;
import org.nem.ast.type.TypeFactory;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

import java.util.ArrayList;
import java.util.List;

public class FnVisitor extends NEMParserBaseVisitor<Function> {
	@Override
	public Function visitFnDef(NEMParser.FnDefContext ctx) {
		final ParamVisitor paramVisitor = new ParamVisitor();
		final InstrVisitor instrVisitor = new InstrVisitor();

		final String name = ctx.fnSignature().IDENTIFIER().getText();
		final Type returnType = TypeFactory.get(ctx.fnSignature().returnType().getText());

		final NEMParser.ParamSeqContext paramSeqCtx = ctx
			.fnSignature()
			.paramSeq();

		final List<Parameter> parameterList =
			(paramSeqCtx == null)
				? new ArrayList<>()
				: paramSeqCtx
				.param()
				.stream()
				.map(param -> param.accept(paramVisitor))
				.toList();

		final List<Instruction> instructionList = ctx
				.instrBlock()
				.instr()
				.stream()
				.map(param -> param.accept(instrVisitor))
				.toList();

		return new Function(name, returnType, parameterList, instructionList);
	}
}
