package org.nem.ast;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;
import org.nem.grammar.NEMLexer;
import org.nem.grammar.NEMParser;
import org.nem.ast.visitor.FileContentVisitor;

import java.io.IOException;
import java.io.InputStream;

public class AstComputer {

	public static FileContent parseFileContent(InputStream inputStream) throws IOException {
		Lexer lexer = new NEMLexer(CharStreams.fromStream(inputStream));
		TokenStream tokenStream = new CommonTokenStream(lexer);
		NEMParser parser = new NEMParser(tokenStream);

		return parser.fileContent().accept(new FileContentVisitor());
	}
}