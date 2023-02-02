package org.nem.ast;

import org.nem.ast.function.Function;

import java.util.HashMap;
import java.util.Map;

public class FileContent {
	private Map<String, Function> functions;

	FileContent() {
		functions = new HashMap<>();
	}

	public void addFunction(Function f) {
		functions.put(f.name, f);
	}
}
