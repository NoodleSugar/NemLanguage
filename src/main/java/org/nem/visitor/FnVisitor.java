package org.nem.visitor;

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
	public Function visitFn_def(NEMParser.Fn_defContext ctx) {
		final ParamVisitor paramVisitor = new ParamVisitor();
		final InstrVisitor instrVisitor = new InstrVisitor();

		final String name = ctx.fn_signature().IDENTIFIER().getText();
		final Type returnType = TypeFactory.get(ctx.fn_signature().return_type().getText());

		final NEMParser.Param_seqContext paramSeqCtx = ctx
			.fn_signature()
			.param_seq();

		final List<Parameter> parameterList =
			(paramSeqCtx == null)
				? new ArrayList<>()
				: paramSeqCtx
				.param()
				.stream()
				.map(param -> param.accept(paramVisitor))
				.toList();

		final NEMParser.Instr_seqContext instrSeqCtx = ctx
			.instr_block()
			.instr_seq();

		final List<Instruction> instructionList =
			(instrSeqCtx == null)
				? new ArrayList<>()
				: instrSeqCtx
				.instr()
				.stream()
				.map(param -> param.accept(instrVisitor))
				.toList();

		return new Function(name, returnType, parameterList, instructionList);
	}
}
