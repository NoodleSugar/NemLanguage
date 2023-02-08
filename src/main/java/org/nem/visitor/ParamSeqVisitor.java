package org.nem.visitor;

import org.nem.ast.function.Parameter;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

import java.util.List;

public class ParamSeqVisitor extends NEMParserBaseVisitor<List<Parameter>> {
	@Override
	public List<Parameter> visitParam_seq(NEMParser.Param_seqContext ctx) {
		ParamVisitor paramVisitor = new ParamVisitor();

		return ctx
			.param()
			.stream()
			.map(param -> param.accept(paramVisitor))
			.toList();
	}
}
