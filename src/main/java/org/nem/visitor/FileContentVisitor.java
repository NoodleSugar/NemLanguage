package org.nem.visitor;

import org.nem.ast.FileContent;
import org.nem.ast.function.Function;
import org.nem.grammar.NEMParser;
import org.nem.grammar.NEMParserBaseVisitor;

import java.util.Map;
import java.util.stream.Collectors;

public class FileContentVisitor extends NEMParserBaseVisitor<FileContent> {

	@Override
	public FileContent visitFile_content(NEMParser.File_contentContext ctx) {
		FnVisitor fnVisitor = new FnVisitor();

		Map<String, Function> functionMap = ctx
			.top_level()
			.stream()
			.filter(top -> !top.fn_def().isEmpty())
			.map(top -> top.fn_def().accept(fnVisitor))
			.collect(Collectors.toMap(f -> f.name, f -> f));

		return new FileContent(functionMap);
	}
}
