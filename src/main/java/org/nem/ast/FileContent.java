package org.nem.ast;

import org.nem.ast.function.Function;

import java.util.Map;

public record FileContent(Map<String, Function> functions) {
}
