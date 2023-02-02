package org.nem;

import org.antlr.v4.runtime.*;
import org.nem.grammar.NEMLexer;
import org.nem.grammar.NEMParser;

public class App {
    public static void main(String[] args) throws Exception {
        //InputStream inputStream = Main.class.getResourceAsStream("/example1.txt");

        Lexer lexer = new NEMLexer(CharStreams.fromString("fn main() void {}"));
        TokenStream tokenStream = new CommonTokenStream(lexer);

        NEMParser parser = new NEMParser(tokenStream);

        NEMParser.FileContext rule = parser.file();
        System.out.println(rule.toStringTree());
    }
}