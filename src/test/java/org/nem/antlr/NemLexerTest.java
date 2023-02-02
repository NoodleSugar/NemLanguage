package org.nem.antlr;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.TokenStream;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.junit.Test;

public class NemLexerTest {

    @Test
    public void a()
    {
        String s = "1";
        Lexer lexer = new NEMLexer(CharStreams.fromString(s));

        TokenStream tokens = new CommonTokenStream(lexer);

        NEMParser parser = new NEMParser(tokens);
        parser.prog();

        System.out.println();
    }
}
