// Generated from java-escape by ANTLR 4.11.1
package org.nem.grammar;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class NEMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		IL_COMMENT=1, ML_COMMENT=2, WHITESPACE=3, PLUS=4, MINUS=5, STAR=6, SLASH=7, 
		MODULO=8, OPEN_PARENTHESIS=9, CLOSE_PARENTHESIS=10, OPEN_BRACE=11, CLOSE_BRACE=12, 
		OPEN_CHEVRON=13, CLOSE_CHEVRON=14, POINT=15, COMMA=16, COLON=17, SEMICOLON=18, 
		EXCLAMATION=19, EQ=20, EQ_ADD=21, EQ_SUB=22, EQ_MUL=23, EQ_DIV=24, INCR=25, 
		DECR=26, FN=27, VAR=28, CONST=29, RETURN=30, VOID=31, INT=32, L_NUM=33, 
		IDENTIFIER=34, OP_LE=35, OP_GE=36, OP_EQ=37, OP_NE=38, OP_AND=39, OP_OR=40;
	public static final int
		RULE_file = 0, RULE_top_level_seq = 1, RULE_top_level = 2, RULE_fn_def = 3, 
		RULE_fn_signature = 4, RULE_param_seq = 5, RULE_param = 6, RULE_op_call = 7, 
		RULE_arg_seq = 8, RULE_instr_block = 9, RULE_instr_seq = 10, RULE_instr = 11, 
		RULE_var_decl = 12, RULE_var_def = 13, RULE_const_def = 14, RULE_assign = 15, 
		RULE_expr = 16, RULE_literal = 17, RULE_lvalue = 18, RULE_var_type = 19, 
		RULE_primitive_type = 20, RULE_return_type = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "top_level_seq", "top_level", "fn_def", "fn_signature", "param_seq", 
			"param", "op_call", "arg_seq", "instr_block", "instr_seq", "instr", "var_decl", 
			"var_def", "const_def", "assign", "expr", "literal", "lvalue", "var_type", 
			"primitive_type", "return_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", 
			"'{'", "'}'", "'<'", "'>'", "'.'", "','", "':'", "';'", "'!'", "'='", 
			"'+='", "'-='", "'*='", "'/='", "'++'", "'--'", "'fn'", "'var'", "'const'", 
			"'return'", "'void'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IL_COMMENT", "ML_COMMENT", "WHITESPACE", "PLUS", "MINUS", "STAR", 
			"SLASH", "MODULO", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_CHEVRON", "CLOSE_CHEVRON", "POINT", "COMMA", "COLON", 
			"SEMICOLON", "EXCLAMATION", "EQ", "EQ_ADD", "EQ_SUB", "EQ_MUL", "EQ_DIV", 
			"INCR", "DECR", "FN", "VAR", "CONST", "RETURN", "VOID", "INT", "L_NUM", 
			"IDENTIFIER", "OP_LE", "OP_GE", "OP_EQ", "OP_NE", "OP_AND", "OP_OR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "java-escape"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public NEMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FileContext extends ParserRuleContext {
		public Top_level_seqContext top_level_seq() {
			return getRuleContext(Top_level_seqContext.class,0);
		}
		public TerminalNode EOF() { return getToken(NEMParser.EOF, 0); }
		public FileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterFile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitFile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContext file() throws RecognitionException {
		FileContext _localctx = new FileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			top_level_seq();
			setState(45);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Top_level_seqContext extends ParserRuleContext {
		public Top_levelContext top_level() {
			return getRuleContext(Top_levelContext.class,0);
		}
		public Top_level_seqContext top_level_seq() {
			return getRuleContext(Top_level_seqContext.class,0);
		}
		public Top_level_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top_level_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterTop_level_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitTop_level_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitTop_level_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Top_level_seqContext top_level_seq() throws RecognitionException {
		Top_level_seqContext _localctx = new Top_level_seqContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_top_level_seq);
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(47);
				top_level();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(48);
				top_level();
				setState(49);
				top_level_seq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Top_levelContext extends ParserRuleContext {
		public Fn_defContext fn_def() {
			return getRuleContext(Fn_defContext.class,0);
		}
		public Top_levelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_top_level; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterTop_level(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitTop_level(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitTop_level(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Top_levelContext top_level() throws RecognitionException {
		Top_levelContext _localctx = new Top_levelContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_top_level);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			fn_def();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fn_defContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(NEMParser.FN, 0); }
		public Fn_signatureContext fn_signature() {
			return getRuleContext(Fn_signatureContext.class,0);
		}
		public Instr_blockContext instr_block() {
			return getRuleContext(Instr_blockContext.class,0);
		}
		public Fn_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterFn_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitFn_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFn_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_defContext fn_def() throws RecognitionException {
		Fn_defContext _localctx = new Fn_defContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fn_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			match(FN);
			setState(56);
			fn_signature();
			setState(57);
			instr_block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fn_signatureContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
		}
		public Param_seqContext param_seq() {
			return getRuleContext(Param_seqContext.class,0);
		}
		public Fn_signatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_signature; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterFn_signature(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitFn_signature(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFn_signature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_signatureContext fn_signature() throws RecognitionException {
		Fn_signatureContext _localctx = new Fn_signatureContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_fn_signature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(IDENTIFIER);
			setState(60);
			match(OPEN_PARENTHESIS);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==IDENTIFIER) {
				{
				setState(61);
				param_seq();
				}
			}

			setState(64);
			match(CLOSE_PARENTHESIS);
			setState(65);
			return_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Param_seqContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(NEMParser.COMMA, 0); }
		public Param_seqContext param_seq() {
			return getRuleContext(Param_seqContext.class,0);
		}
		public Param_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterParam_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitParam_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitParam_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_seqContext param_seq() throws RecognitionException {
		Param_seqContext _localctx = new Param_seqContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param_seq);
		try {
			setState(72);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(67);
				param();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				param();
				setState(69);
				match(COMMA);
				setState(70);
				param_seq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParamContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_param);
		try {
			setState(78);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(74);
				var_type();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(75);
				match(IDENTIFIER);
				setState(76);
				match(COLON);
				setState(77);
				var_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Op_callContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public Arg_seqContext arg_seq() {
			return getRuleContext(Arg_seqContext.class,0);
		}
		public Op_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_op_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterOp_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitOp_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitOp_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Op_callContext op_call() throws RecognitionException {
		Op_callContext _localctx = new Op_callContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_op_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(OPEN_PARENTHESIS);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 25870467616L) != 0) {
				{
				setState(81);
				arg_seq();
				}
			}

			setState(84);
			match(CLOSE_PARENTHESIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Arg_seqContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(NEMParser.COMMA, 0); }
		public Arg_seqContext arg_seq() {
			return getRuleContext(Arg_seqContext.class,0);
		}
		public Arg_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterArg_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitArg_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitArg_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arg_seqContext arg_seq() throws RecognitionException {
		Arg_seqContext _localctx = new Arg_seqContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_arg_seq);
		try {
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(87);
				expr(0);
				setState(88);
				match(COMMA);
				setState(89);
				arg_seq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Instr_blockContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(NEMParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(NEMParser.CLOSE_BRACE, 0); }
		public Instr_seqContext instr_seq() {
			return getRuleContext(Instr_seqContext.class,0);
		}
		public Instr_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterInstr_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitInstr_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstr_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instr_blockContext instr_block() throws RecognitionException {
		Instr_blockContext _localctx = new Instr_blockContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instr_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(OPEN_BRACE);
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 18085839360L) != 0) {
				{
				setState(94);
				instr_seq();
				}
			}

			setState(97);
			match(CLOSE_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Instr_seqContext extends ParserRuleContext {
		public InstrContext instr() {
			return getRuleContext(InstrContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NEMParser.SEMICOLON, 0); }
		public Instr_seqContext instr_seq() {
			return getRuleContext(Instr_seqContext.class,0);
		}
		public Instr_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterInstr_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitInstr_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstr_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Instr_seqContext instr_seq() throws RecognitionException {
		Instr_seqContext _localctx = new Instr_seqContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_instr_seq);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(99);
				instr();
				setState(100);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				instr();
				setState(103);
				match(SEMICOLON);
				setState(104);
				instr_seq();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InstrContext extends ParserRuleContext {
		public Var_declContext var_decl() {
			return getRuleContext(Var_declContext.class,0);
		}
		public Var_defContext var_def() {
			return getRuleContext(Var_defContext.class,0);
		}
		public Const_defContext const_def() {
			return getRuleContext(Const_defContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public Op_callContext op_call() {
			return getRuleContext(Op_callContext.class,0);
		}
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterInstr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitInstr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_instr);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(109);
				var_def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(110);
				const_def();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(111);
				assign();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(112);
				lvalue(0);
				setState(113);
				op_call();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_declContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Var_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterVar_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitVar_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVar_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_declContext var_decl() throws RecognitionException {
		Var_declContext _localctx = new Var_declContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_var_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(VAR);
			setState(118);
			match(IDENTIFIER);
			setState(119);
			match(COLON);
			setState(120);
			var_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_defContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Var_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterVar_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitVar_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVar_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_defContext var_def() throws RecognitionException {
		Var_defContext _localctx = new Var_defContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_var_def);
		try {
			setState(133);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(122);
				match(VAR);
				setState(123);
				match(IDENTIFIER);
				setState(124);
				match(EQ);
				setState(125);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(VAR);
				setState(127);
				match(IDENTIFIER);
				setState(128);
				match(COLON);
				setState(129);
				var_type();
				setState(130);
				match(EQ);
				setState(131);
				expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Const_defContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(NEMParser.CONST, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Const_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterConst_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitConst_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitConst_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Const_defContext const_def() throws RecognitionException {
		Const_defContext _localctx = new Const_defContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_const_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(CONST);
			setState(136);
			match(IDENTIFIER);
			setState(137);
			match(COLON);
			setState(138);
			var_type();
			setState(139);
			match(EQ);
			setState(140);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignContext extends ParserRuleContext {
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterAssign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitAssign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			lvalue(0);
			setState(143);
			match(EQ);
			setState(144);
			expr(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode MINUS() { return getToken(NEMParser.MINUS, 0); }
		public TerminalNode MODULO() { return getToken(NEMParser.MODULO, 0); }
		public TerminalNode SLASH() { return getToken(NEMParser.SLASH, 0); }
		public TerminalNode STAR() { return getToken(NEMParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(NEMParser.PLUS, 0); }
		public TerminalNode OPEN_CHEVRON() { return getToken(NEMParser.OPEN_CHEVRON, 0); }
		public TerminalNode CLOSE_CHEVRON() { return getToken(NEMParser.CLOSE_CHEVRON, 0); }
		public TerminalNode OP_LE() { return getToken(NEMParser.OP_LE, 0); }
		public TerminalNode OP_GE() { return getToken(NEMParser.OP_GE, 0); }
		public TerminalNode OP_EQ() { return getToken(NEMParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(NEMParser.OP_NE, 0); }
		public TerminalNode OP_AND() { return getToken(NEMParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(NEMParser.OP_OR, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(147);
				literal();
				}
				break;
			case 2:
				{
				setState(148);
				lvalue(0);
				}
				break;
			case 3:
				{
				setState(149);
				match(OPEN_PARENTHESIS);
				setState(150);
				expr(0);
				setState(151);
				match(CLOSE_PARENTHESIS);
				}
				break;
			case 4:
				{
				setState(153);
				match(MINUS);
				setState(154);
				expr(7);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(177);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(175);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(157);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(158);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 448L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(159);
						expr(7);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(161);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(162);
						expr(6);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(163);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(164);
						_la = _input.LA(1);
						if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 103079239680L) != 0) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(165);
						expr(5);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(166);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(167);
						_la = _input.LA(1);
						if ( !(_la==OP_EQ || _la==OP_NE) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(168);
						expr(4);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(169);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(170);
						match(OP_AND);
						setState(171);
						expr(3);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(172);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(173);
						match(OP_OR);
						setState(174);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(179);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode L_NUM() { return getToken(NEMParser.L_NUM, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(L_NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode INCR() { return getToken(NEMParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(NEMParser.DECR, 0); }
		public Op_callContext op_call() {
			return getRuleContext(Op_callContext.class,0);
		}
		public LvalueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lvalue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterLvalue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitLvalue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLvalue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LvalueContext lvalue() throws RecognitionException {
		return lvalue(0);
	}

	private LvalueContext lvalue(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LvalueContext _localctx = new LvalueContext(_ctx, _parentState);
		LvalueContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_lvalue, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(190);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(183);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PARENTHESIS:
				{
				setState(184);
				match(OPEN_PARENTHESIS);
				setState(185);
				lvalue(0);
				setState(186);
				match(CLOSE_PARENTHESIS);
				}
				break;
			case INCR:
			case DECR:
				{
				setState(188);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(189);
				lvalue(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(196);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new LvalueContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
					setState(192);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(193);
					op_call();
					}
					} 
				}
				setState(198);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Var_typeContext extends ParserRuleContext {
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public Var_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterVar_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitVar_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVar_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_typeContext var_type() throws RecognitionException {
		Var_typeContext _localctx = new Var_typeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_var_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			primitive_type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primitive_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(NEMParser.INT, 0); }
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterPrimitive_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitPrimitive_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitPrimitive_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_primitive_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			match(INT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Return_typeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(NEMParser.VOID, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Return_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterReturn_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitReturn_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitReturn_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_typeContext return_type() throws RecognitionException {
		Return_typeContext _localctx = new Return_typeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_return_type);
		try {
			setState(205);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(203);
				match(VOID);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(204);
				var_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 16:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 18:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 4);
		case 3:
			return precpred(_ctx, 3);
		case 4:
			return precpred(_ctx, 2);
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean lvalue_sempred(LvalueContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001(\u00d0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00014\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0003\u0004?\b\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005I\b\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006O\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0003\u0007S\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\\\b\b\u0001\t\u0001\t"+
		"\u0003\t`\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0001\n\u0003\nk\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000bt\b\u000b\u0001"+
		"\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u0086\b\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u009c\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00b0\b\u0010\n"+
		"\u0010\f\u0010\u00b3\t\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0003\u0012\u00bf\b\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u00c3"+
		"\b\u0012\n\u0012\f\u0012\u00c6\t\u0012\u0001\u0013\u0001\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00ce\b\u0015\u0001\u0015"+
		"\u0000\u0002 $\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0005\u0001\u0000\u0006\b"+
		"\u0001\u0000\u0004\u0005\u0002\u0000\r\u000e#$\u0001\u0000%&\u0001\u0000"+
		"\u0019\u001a\u00d3\u0000,\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000"+
		"\u0000\u00045\u0001\u0000\u0000\u0000\u00067\u0001\u0000\u0000\u0000\b"+
		";\u0001\u0000\u0000\u0000\nH\u0001\u0000\u0000\u0000\fN\u0001\u0000\u0000"+
		"\u0000\u000eP\u0001\u0000\u0000\u0000\u0010[\u0001\u0000\u0000\u0000\u0012"+
		"]\u0001\u0000\u0000\u0000\u0014j\u0001\u0000\u0000\u0000\u0016s\u0001"+
		"\u0000\u0000\u0000\u0018u\u0001\u0000\u0000\u0000\u001a\u0085\u0001\u0000"+
		"\u0000\u0000\u001c\u0087\u0001\u0000\u0000\u0000\u001e\u008e\u0001\u0000"+
		"\u0000\u0000 \u009b\u0001\u0000\u0000\u0000\"\u00b4\u0001\u0000\u0000"+
		"\u0000$\u00be\u0001\u0000\u0000\u0000&\u00c7\u0001\u0000\u0000\u0000("+
		"\u00c9\u0001\u0000\u0000\u0000*\u00cd\u0001\u0000\u0000\u0000,-\u0003"+
		"\u0002\u0001\u0000-.\u0005\u0000\u0000\u0001.\u0001\u0001\u0000\u0000"+
		"\u0000/4\u0003\u0004\u0002\u000001\u0003\u0004\u0002\u000012\u0003\u0002"+
		"\u0001\u000024\u0001\u0000\u0000\u00003/\u0001\u0000\u0000\u000030\u0001"+
		"\u0000\u0000\u00004\u0003\u0001\u0000\u0000\u000056\u0003\u0006\u0003"+
		"\u00006\u0005\u0001\u0000\u0000\u000078\u0005\u001b\u0000\u000089\u0003"+
		"\b\u0004\u00009:\u0003\u0012\t\u0000:\u0007\u0001\u0000\u0000\u0000;<"+
		"\u0005\"\u0000\u0000<>\u0005\t\u0000\u0000=?\u0003\n\u0005\u0000>=\u0001"+
		"\u0000\u0000\u0000>?\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000"+
		"@A\u0005\n\u0000\u0000AB\u0003*\u0015\u0000B\t\u0001\u0000\u0000\u0000"+
		"CI\u0003\f\u0006\u0000DE\u0003\f\u0006\u0000EF\u0005\u0010\u0000\u0000"+
		"FG\u0003\n\u0005\u0000GI\u0001\u0000\u0000\u0000HC\u0001\u0000\u0000\u0000"+
		"HD\u0001\u0000\u0000\u0000I\u000b\u0001\u0000\u0000\u0000JO\u0003&\u0013"+
		"\u0000KL\u0005\"\u0000\u0000LM\u0005\u0011\u0000\u0000MO\u0003&\u0013"+
		"\u0000NJ\u0001\u0000\u0000\u0000NK\u0001\u0000\u0000\u0000O\r\u0001\u0000"+
		"\u0000\u0000PR\u0005\t\u0000\u0000QS\u0003\u0010\b\u0000RQ\u0001\u0000"+
		"\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000TU\u0005"+
		"\n\u0000\u0000U\u000f\u0001\u0000\u0000\u0000V\\\u0003 \u0010\u0000WX"+
		"\u0003 \u0010\u0000XY\u0005\u0010\u0000\u0000YZ\u0003\u0010\b\u0000Z\\"+
		"\u0001\u0000\u0000\u0000[V\u0001\u0000\u0000\u0000[W\u0001\u0000\u0000"+
		"\u0000\\\u0011\u0001\u0000\u0000\u0000]_\u0005\u000b\u0000\u0000^`\u0003"+
		"\u0014\n\u0000_^\u0001\u0000\u0000\u0000_`\u0001\u0000\u0000\u0000`a\u0001"+
		"\u0000\u0000\u0000ab\u0005\f\u0000\u0000b\u0013\u0001\u0000\u0000\u0000"+
		"cd\u0003\u0016\u000b\u0000de\u0005\u0012\u0000\u0000ek\u0001\u0000\u0000"+
		"\u0000fg\u0003\u0016\u000b\u0000gh\u0005\u0012\u0000\u0000hi\u0003\u0014"+
		"\n\u0000ik\u0001\u0000\u0000\u0000jc\u0001\u0000\u0000\u0000jf\u0001\u0000"+
		"\u0000\u0000k\u0015\u0001\u0000\u0000\u0000lt\u0003\u0018\f\u0000mt\u0003"+
		"\u001a\r\u0000nt\u0003\u001c\u000e\u0000ot\u0003\u001e\u000f\u0000pq\u0003"+
		"$\u0012\u0000qr\u0003\u000e\u0007\u0000rt\u0001\u0000\u0000\u0000sl\u0001"+
		"\u0000\u0000\u0000sm\u0001\u0000\u0000\u0000sn\u0001\u0000\u0000\u0000"+
		"so\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000\u0000t\u0017\u0001\u0000"+
		"\u0000\u0000uv\u0005\u001c\u0000\u0000vw\u0005\"\u0000\u0000wx\u0005\u0011"+
		"\u0000\u0000xy\u0003&\u0013\u0000y\u0019\u0001\u0000\u0000\u0000z{\u0005"+
		"\u001c\u0000\u0000{|\u0005\"\u0000\u0000|}\u0005\u0014\u0000\u0000}\u0086"+
		"\u0003 \u0010\u0000~\u007f\u0005\u001c\u0000\u0000\u007f\u0080\u0005\""+
		"\u0000\u0000\u0080\u0081\u0005\u0011\u0000\u0000\u0081\u0082\u0003&\u0013"+
		"\u0000\u0082\u0083\u0005\u0014\u0000\u0000\u0083\u0084\u0003 \u0010\u0000"+
		"\u0084\u0086\u0001\u0000\u0000\u0000\u0085z\u0001\u0000\u0000\u0000\u0085"+
		"~\u0001\u0000\u0000\u0000\u0086\u001b\u0001\u0000\u0000\u0000\u0087\u0088"+
		"\u0005\u001d\u0000\u0000\u0088\u0089\u0005\"\u0000\u0000\u0089\u008a\u0005"+
		"\u0011\u0000\u0000\u008a\u008b\u0003&\u0013\u0000\u008b\u008c\u0005\u0014"+
		"\u0000\u0000\u008c\u008d\u0003 \u0010\u0000\u008d\u001d\u0001\u0000\u0000"+
		"\u0000\u008e\u008f\u0003$\u0012\u0000\u008f\u0090\u0005\u0014\u0000\u0000"+
		"\u0090\u0091\u0003 \u0010\u0000\u0091\u001f\u0001\u0000\u0000\u0000\u0092"+
		"\u0093\u0006\u0010\uffff\uffff\u0000\u0093\u009c\u0003\"\u0011\u0000\u0094"+
		"\u009c\u0003$\u0012\u0000\u0095\u0096\u0005\t\u0000\u0000\u0096\u0097"+
		"\u0003 \u0010\u0000\u0097\u0098\u0005\n\u0000\u0000\u0098\u009c\u0001"+
		"\u0000\u0000\u0000\u0099\u009a\u0005\u0005\u0000\u0000\u009a\u009c\u0003"+
		" \u0010\u0007\u009b\u0092\u0001\u0000\u0000\u0000\u009b\u0094\u0001\u0000"+
		"\u0000\u0000\u009b\u0095\u0001\u0000\u0000\u0000\u009b\u0099\u0001\u0000"+
		"\u0000\u0000\u009c\u00b1\u0001\u0000\u0000\u0000\u009d\u009e\n\u0006\u0000"+
		"\u0000\u009e\u009f\u0007\u0000\u0000\u0000\u009f\u00b0\u0003 \u0010\u0007"+
		"\u00a0\u00a1\n\u0005\u0000\u0000\u00a1\u00a2\u0007\u0001\u0000\u0000\u00a2"+
		"\u00b0\u0003 \u0010\u0006\u00a3\u00a4\n\u0004\u0000\u0000\u00a4\u00a5"+
		"\u0007\u0002\u0000\u0000\u00a5\u00b0\u0003 \u0010\u0005\u00a6\u00a7\n"+
		"\u0003\u0000\u0000\u00a7\u00a8\u0007\u0003\u0000\u0000\u00a8\u00b0\u0003"+
		" \u0010\u0004\u00a9\u00aa\n\u0002\u0000\u0000\u00aa\u00ab\u0005\'\u0000"+
		"\u0000\u00ab\u00b0\u0003 \u0010\u0003\u00ac\u00ad\n\u0001\u0000\u0000"+
		"\u00ad\u00ae\u0005(\u0000\u0000\u00ae\u00b0\u0003 \u0010\u0002\u00af\u009d"+
		"\u0001\u0000\u0000\u0000\u00af\u00a0\u0001\u0000\u0000\u0000\u00af\u00a3"+
		"\u0001\u0000\u0000\u0000\u00af\u00a6\u0001\u0000\u0000\u0000\u00af\u00a9"+
		"\u0001\u0000\u0000\u0000\u00af\u00ac\u0001\u0000\u0000\u0000\u00b0\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1\u00b2"+
		"\u0001\u0000\u0000\u0000\u00b2!\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0005!\u0000\u0000\u00b5#\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0006\u0012\uffff\uffff\u0000\u00b7\u00bf\u0005\"\u0000"+
		"\u0000\u00b8\u00b9\u0005\t\u0000\u0000\u00b9\u00ba\u0003$\u0012\u0000"+
		"\u00ba\u00bb\u0005\n\u0000\u0000\u00bb\u00bf\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bd\u0007\u0004\u0000\u0000\u00bd\u00bf\u0003$\u0012\u0001\u00be\u00b6"+
		"\u0001\u0000\u0000\u0000\u00be\u00b8\u0001\u0000\u0000\u0000\u00be\u00bc"+
		"\u0001\u0000\u0000\u0000\u00bf\u00c4\u0001\u0000\u0000\u0000\u00c0\u00c1"+
		"\n\u0002\u0000\u0000\u00c1\u00c3\u0003\u000e\u0007\u0000\u00c2\u00c0\u0001"+
		"\u0000\u0000\u0000\u00c3\u00c6\u0001\u0000\u0000\u0000\u00c4\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000\u00c5%\u0001\u0000"+
		"\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c8\u0003(\u0014"+
		"\u0000\u00c8\'\u0001\u0000\u0000\u0000\u00c9\u00ca\u0005 \u0000\u0000"+
		"\u00ca)\u0001\u0000\u0000\u0000\u00cb\u00ce\u0005\u001f\u0000\u0000\u00cc"+
		"\u00ce\u0003&\u0013\u0000\u00cd\u00cb\u0001\u0000\u0000\u0000\u00cd\u00cc"+
		"\u0001\u0000\u0000\u0000\u00ce+\u0001\u0000\u0000\u0000\u00103>HNR[_j"+
		"s\u0085\u009b\u00af\u00b1\u00be\u00c4\u00cd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}