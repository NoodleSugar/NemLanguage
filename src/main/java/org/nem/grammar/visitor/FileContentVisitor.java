package org.nem.grammar.visitor;

import org.nem.ast.FileContent;
import org.nem.ast.function.Function;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

import java.util.Map;
import java.util.stream.Collectors;

public class FileContentVisitor extends NEMParserBaseVisitor<FileContent> {

	@Override
	public FileContent visitFileContent(NEMParser.FileContentContext ctx) {
		FnVisitor fnVisitor = new FnVisitor();

		Map<String, Function> functionMap = ctx
			.topLevel()
			.stream()
			.filter(top -> !top.fnDef().isEmpty())
			.map(top -> top.fnDef().accept(fnVisitor))
			.collect(Collectors.toMap(f -> f.name(), f -> f));

		return new FileContent(functionMap);
	}
}
