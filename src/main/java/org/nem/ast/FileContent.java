package org.nem.ast;

import org.nem.ast.function.Function;

import java.util.Map;

public class FileContent {
	public Map<String, Function> functions;

	public FileContent(Map<String, Function> functions) {
		this.functions = functions;
	}
}
