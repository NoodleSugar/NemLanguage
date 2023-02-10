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
		EXCLAMATION=19, EQ=20, ADD_EQ=21, SUB_EQ=22, MUL_EQ=23, DIV_EQ=24, MOD_EQ=25, 
		INCR=26, DECR=27, FN=28, VAR=29, CONST=30, RETURN=31, VOID=32, INT=33, 
		L_NUM=34, IDENTIFIER=35;
	public static final int
		RULE_fileContent = 0, RULE_topLevel = 1, RULE_fnDef = 2, RULE_fnSignature = 3, 
		RULE_paramSeq = 4, RULE_param = 5, RULE_callOp = 6, RULE_argSeq = 7, RULE_instrBlock = 8, 
		RULE_instr = 9, RULE_incrInstr = 10, RULE_varDecl = 11, RULE_varDef = 12, 
		RULE_constDef = 13, RULE_assign = 14, RULE_assignOp = 15, RULE_fnCall = 16, 
		RULE_expr = 17, RULE_literal = 18, RULE_lValue = 19, RULE_varType = 20, 
		RULE_returnType = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"fileContent", "topLevel", "fnDef", "fnSignature", "paramSeq", "param", 
			"callOp", "argSeq", "instrBlock", "instr", "incrInstr", "varDecl", "varDef", 
			"constDef", "assign", "assignOp", "fnCall", "expr", "literal", "lValue", 
			"varType", "returnType"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'+'", "'-'", "'*'", "'/'", "'%'", "'('", "')'", 
			"'{'", "'}'", "'<'", "'>'", "'.'", "','", "':'", "';'", "'!'", "'='", 
			"'+='", "'-='", "'*='", "'/='", "'%='", "'++'", "'--'", "'fn'", "'var'", 
			"'const'", "'return'", "'void'", "'int'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IL_COMMENT", "ML_COMMENT", "WHITESPACE", "PLUS", "MINUS", "STAR", 
			"SLASH", "MODULO", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", "OPEN_BRACE", 
			"CLOSE_BRACE", "OPEN_CHEVRON", "CLOSE_CHEVRON", "POINT", "COMMA", "COLON", 
			"SEMICOLON", "EXCLAMATION", "EQ", "ADD_EQ", "SUB_EQ", "MUL_EQ", "DIV_EQ", 
			"MOD_EQ", "INCR", "DECR", "FN", "VAR", "CONST", "RETURN", "VOID", "INT", 
			"L_NUM", "IDENTIFIER"
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
	public static class FileContentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(NEMParser.EOF, 0); }
		public List<TopLevelContext> topLevel() {
			return getRuleContexts(TopLevelContext.class);
		}
		public TopLevelContext topLevel(int i) {
			return getRuleContext(TopLevelContext.class,i);
		}
		public FileContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fileContent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFileContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FileContentContext fileContent() throws RecognitionException {
		FileContentContext _localctx = new FileContentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_fileContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(45); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(44);
				topLevel();
				}
				}
				setState(47); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FN );
			setState(49);
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
	public static class TopLevelContext extends ParserRuleContext {
		public FnDefContext fnDef() {
			return getRuleContext(FnDefContext.class,0);
		}
		public TopLevelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topLevel; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitTopLevel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TopLevelContext topLevel() throws RecognitionException {
		TopLevelContext _localctx = new TopLevelContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_topLevel);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			fnDef();
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
	public static class FnDefContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(NEMParser.FN, 0); }
		public FnSignatureContext fnSignature() {
			return getRuleContext(FnSignatureContext.class,0);
		}
		public InstrBlockContext instrBlock() {
			return getRuleContext(InstrBlockContext.class,0);
		}
		public FnDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFnDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnDefContext fnDef() throws RecognitionException {
		FnDefContext _localctx = new FnDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_fnDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(FN);
			setState(54);
			fnSignature();
			setState(55);
			instrBlock();
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
	public static class FnSignatureContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public ParamSeqContext paramSeq() {
			return getRuleContext(ParamSeqContext.class,0);
		}
		public FnSignatureContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnSignature; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFnSignature(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnSignatureContext fnSignature() throws RecognitionException {
		FnSignatureContext _localctx = new FnSignatureContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fnSignature);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(IDENTIFIER);
			setState(58);
			match(OPEN_PARENTHESIS);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INT || _la==IDENTIFIER) {
				{
				setState(59);
				paramSeq();
				}
			}

			setState(62);
			match(CLOSE_PARENTHESIS);
			setState(63);
			returnType();
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
	public static class ParamSeqContext extends ParserRuleContext {
		public List<ParamContext> param() {
			return getRuleContexts(ParamContext.class);
		}
		public ParamContext param(int i) {
			return getRuleContext(ParamContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(NEMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NEMParser.COMMA, i);
		}
		public ParamSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paramSeq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitParamSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamSeqContext paramSeq() throws RecognitionException {
		ParamSeqContext _localctx = new ParamSeqContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_paramSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			param();
			setState(70);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(66);
				match(COMMA);
				setState(67);
				param();
				}
				}
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
	 
		public ParamContext() { }
		public void copyFrom(ParamContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamWithoutNameContext extends ParamContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ParamWithoutNameContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitParamWithoutName(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParamWithNameContext extends ParamContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ParamWithNameContext(ParamContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitParamWithName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_param);
		try {
			setState(77);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
				_localctx = new ParamWithoutNameContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(73);
				varType();
				}
				break;
			case IDENTIFIER:
				_localctx = new ParamWithNameContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				match(IDENTIFIER);
				setState(75);
				match(COLON);
				setState(76);
				varType();
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
	public static class CallOpContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public ArgSeqContext argSeq() {
			return getRuleContext(ArgSeqContext.class,0);
		}
		public CallOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitCallOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallOpContext callOp() throws RecognitionException {
		CallOpContext _localctx = new CallOpContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_callOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(OPEN_PARENTHESIS);
			setState(81);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((_la) & ~0x3f) == 0 && ((1L << _la) & 51740934688L) != 0) {
				{
				setState(80);
				argSeq();
				}
			}

			setState(83);
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
	public static class ArgSeqContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(NEMParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(NEMParser.COMMA, i);
		}
		public ArgSeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argSeq; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitArgSeq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgSeqContext argSeq() throws RecognitionException {
		ArgSeqContext _localctx = new ArgSeqContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_argSeq);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			expr(0);
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(86);
				match(COMMA);
				setState(87);
				expr(0);
				}
				}
				setState(92);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
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
	public static class InstrBlockContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(NEMParser.OPEN_BRACE, 0); }
		public TerminalNode CLOSE_BRACE() { return getToken(NEMParser.CLOSE_BRACE, 0); }
		public List<InstrContext> instr() {
			return getRuleContexts(InstrContext.class);
		}
		public InstrContext instr(int i) {
			return getRuleContext(InstrContext.class,i);
		}
		public List<TerminalNode> SEMICOLON() { return getTokens(NEMParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(NEMParser.SEMICOLON, i);
		}
		public InstrBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instrBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstrBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrBlockContext instrBlock() throws RecognitionException {
		InstrBlockContext _localctx = new InstrBlockContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_instrBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(OPEN_BRACE);
			setState(99);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((_la) & ~0x3f) == 0 && ((1L << _la) & 36171678208L) != 0) {
				{
				{
				setState(94);
				instr();
				setState(95);
				match(SEMICOLON);
				}
				}
				setState(101);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(102);
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
	public static class InstrContext extends ParserRuleContext {
		public VarDeclContext varDecl() {
			return getRuleContext(VarDeclContext.class,0);
		}
		public VarDefContext varDef() {
			return getRuleContext(VarDefContext.class,0);
		}
		public ConstDefContext constDef() {
			return getRuleContext(ConstDefContext.class,0);
		}
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public FnCallContext fnCall() {
			return getRuleContext(FnCallContext.class,0);
		}
		public IncrInstrContext incrInstr() {
			return getRuleContext(IncrInstrContext.class,0);
		}
		public InstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InstrContext instr() throws RecognitionException {
		InstrContext _localctx = new InstrContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_instr);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(104);
				varDecl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(105);
				varDef();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(106);
				constDef();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(107);
				assign();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(108);
				fnCall();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(109);
				incrInstr();
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
	public static class IncrInstrContext extends ParserRuleContext {
		public IncrInstrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrInstr; }
	 
		public IncrInstrContext() { }
		public void copyFrom(IncrInstrContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrPostIncrContext extends IncrInstrContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public TerminalNode INCR() { return getToken(NEMParser.INCR, 0); }
		public InstrPostIncrContext(IncrInstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstrPostIncr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrPreDecrContext extends IncrInstrContext {
		public TerminalNode DECR() { return getToken(NEMParser.DECR, 0); }
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public InstrPreDecrContext(IncrInstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstrPreDecr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrPreIncrContext extends IncrInstrContext {
		public TerminalNode INCR() { return getToken(NEMParser.INCR, 0); }
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public InstrPreIncrContext(IncrInstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstrPreIncr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstrPostDecrContext extends IncrInstrContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public TerminalNode DECR() { return getToken(NEMParser.DECR, 0); }
		public InstrPostDecrContext(IncrInstrContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInstrPostDecr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IncrInstrContext incrInstr() throws RecognitionException {
		IncrInstrContext _localctx = new IncrInstrContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_incrInstr);
		try {
			setState(122);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new InstrPreIncrContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				match(INCR);
				setState(113);
				lValue();
				}
				break;
			case 2:
				_localctx = new InstrPreDecrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				match(DECR);
				setState(115);
				lValue();
				}
				break;
			case 3:
				_localctx = new InstrPostIncrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(116);
				lValue();
				setState(117);
				match(INCR);
				}
				break;
			case 4:
				_localctx = new InstrPostDecrContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(119);
				lValue();
				setState(120);
				match(DECR);
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
	public static class VarDeclContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public VarDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDecl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVarDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDeclContext varDecl() throws RecognitionException {
		VarDeclContext _localctx = new VarDeclContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_varDecl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(VAR);
			setState(125);
			match(IDENTIFIER);
			setState(126);
			match(COLON);
			setState(127);
			varType();
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
	public static class VarDefContext extends ParserRuleContext {
		public VarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varDef; }
	 
		public VarDefContext() { }
		public void copyFrom(VarDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDefWithTypeContext extends VarDefContext {
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefWithTypeContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVarDefWithType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VarDefWithoutTypeContext extends VarDefContext {
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarDefWithoutTypeContext(VarDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVarDefWithoutType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarDefContext varDef() throws RecognitionException {
		VarDefContext _localctx = new VarDefContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_varDef);
		try {
			setState(140);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				_localctx = new VarDefWithoutTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(VAR);
				setState(130);
				match(IDENTIFIER);
				setState(131);
				match(EQ);
				setState(132);
				expr(0);
				}
				break;
			case 2:
				_localctx = new VarDefWithTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				match(VAR);
				setState(134);
				match(IDENTIFIER);
				setState(135);
				match(COLON);
				setState(136);
				varType();
				setState(137);
				match(EQ);
				setState(138);
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
	public static class ConstDefContext extends ParserRuleContext {
		public ConstDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDef; }
	 
		public ConstDefContext() { }
		public void copyFrom(ConstDefContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstDefWithoutTypeContext extends ConstDefContext {
		public TerminalNode CONST() { return getToken(NEMParser.CONST, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstDefWithoutTypeContext(ConstDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitConstDefWithoutType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConstDefWithTypeContext extends ConstDefContext {
		public TerminalNode CONST() { return getToken(NEMParser.CONST, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ConstDefWithTypeContext(ConstDefContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitConstDefWithType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstDefContext constDef() throws RecognitionException {
		ConstDefContext _localctx = new ConstDefContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constDef);
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				_localctx = new ConstDefWithoutTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(142);
				match(CONST);
				setState(143);
				match(IDENTIFIER);
				setState(144);
				match(EQ);
				setState(145);
				expr(0);
				}
				break;
			case 2:
				_localctx = new ConstDefWithTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(146);
				match(CONST);
				setState(147);
				match(IDENTIFIER);
				setState(148);
				match(COLON);
				setState(149);
				varType();
				setState(150);
				match(EQ);
				setState(151);
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
	public static class AssignContext extends ParserRuleContext {
		public LValueContext left;
		public ExprContext right;
		public AssignOpContext assignOp() {
			return getRuleContext(AssignOpContext.class,0);
		}
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignContext assign() throws RecognitionException {
		AssignContext _localctx = new AssignContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			((AssignContext)_localctx).left = lValue();
			setState(156);
			assignOp();
			setState(157);
			((AssignContext)_localctx).right = expr(0);
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
	public static class AssignOpContext extends ParserRuleContext {
		public Token op;
		public TerminalNode EQ() { return getToken(NEMParser.EQ, 0); }
		public TerminalNode ADD_EQ() { return getToken(NEMParser.ADD_EQ, 0); }
		public TerminalNode SUB_EQ() { return getToken(NEMParser.SUB_EQ, 0); }
		public TerminalNode MUL_EQ() { return getToken(NEMParser.MUL_EQ, 0); }
		public TerminalNode DIV_EQ() { return getToken(NEMParser.DIV_EQ, 0); }
		public TerminalNode MOD_EQ() { return getToken(NEMParser.MOD_EQ, 0); }
		public AssignOpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignOp; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitAssignOp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignOpContext assignOp() throws RecognitionException {
		AssignOpContext _localctx = new AssignOpContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_assignOp);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			((AssignOpContext)_localctx).op = _input.LT(1);
			_la = _input.LA(1);
			if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 66060288L) != 0) ) {
				((AssignOpContext)_localctx).op = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
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
	public static class FnCallContext extends ParserRuleContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public CallOpContext callOp() {
			return getRuleContext(CallOpContext.class,0);
		}
		public FnCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fnCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFnCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FnCallContext fnCall() throws RecognitionException {
		FnCallContext _localctx = new FnCallContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_fnCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			lValue();
			setState(162);
			callOp();
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprFnCallContext extends ExprContext {
		public FnCallContext fnCall() {
			return getRuleContext(FnCallContext.class,0);
		}
		public ExprFnCallContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprFnCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprlValueContext extends ExprContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public ExprlValueContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprlValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMinusContext extends ExprContext {
		public TerminalNode MINUS() { return getToken(NEMParser.MINUS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public ExprMinusContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprMinus(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprDecrContext extends ExprContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public TerminalNode DECR() { return getToken(NEMParser.DECR, 0); }
		public ExprDecrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprDecr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprSubContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode MINUS() { return getToken(NEMParser.MINUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprSubContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprSub(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprLiteralContext extends ExprContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public ExprLiteralContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprParenthesisContext extends ExprContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public ExprParenthesisContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprIncrContext extends ExprContext {
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public TerminalNode INCR() { return getToken(NEMParser.INCR, 0); }
		public ExprIncrContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprIncr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprMulContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode STAR() { return getToken(NEMParser.STAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprMulContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprMul(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprDivContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode SLASH() { return getToken(NEMParser.SLASH, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprDivContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprDiv(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprAddContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode PLUS() { return getToken(NEMParser.PLUS, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprAddContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprAdd(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExprModContext extends ExprContext {
		public ExprContext left;
		public ExprContext right;
		public TerminalNode MODULO() { return getToken(NEMParser.MODULO, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprModContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitExprMod(this);
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
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				_localctx = new ExprLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(165);
				literal();
				}
				break;
			case 2:
				{
				_localctx = new ExprlValueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(166);
				lValue();
				}
				break;
			case 3:
				{
				_localctx = new ExprIncrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(167);
				lValue();
				setState(168);
				match(INCR);
				}
				break;
			case 4:
				{
				_localctx = new ExprDecrContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				lValue();
				setState(171);
				match(DECR);
				}
				break;
			case 5:
				{
				_localctx = new ExprFnCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(173);
				fnCall();
				}
				break;
			case 6:
				{
				_localctx = new ExprParenthesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(OPEN_PARENTHESIS);
				setState(175);
				expr(0);
				setState(176);
				match(CLOSE_PARENTHESIS);
				}
				break;
			case 7:
				{
				_localctx = new ExprMinusContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(178);
				match(MINUS);
				setState(179);
				expr(6);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(199);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(197);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
					case 1:
						{
						_localctx = new ExprModContext(new ExprContext(_parentctx, _parentState));
						((ExprModContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(182);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(183);
						match(MODULO);
						setState(184);
						((ExprModContext)_localctx).right = expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprDivContext(new ExprContext(_parentctx, _parentState));
						((ExprDivContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(185);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(186);
						match(SLASH);
						setState(187);
						((ExprDivContext)_localctx).right = expr(5);
						}
						break;
					case 3:
						{
						_localctx = new ExprMulContext(new ExprContext(_parentctx, _parentState));
						((ExprMulContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(188);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(189);
						match(STAR);
						setState(190);
						((ExprMulContext)_localctx).right = expr(4);
						}
						break;
					case 4:
						{
						_localctx = new ExprSubContext(new ExprContext(_parentctx, _parentState));
						((ExprSubContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(191);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(192);
						match(MINUS);
						setState(193);
						((ExprSubContext)_localctx).right = expr(3);
						}
						break;
					case 5:
						{
						_localctx = new ExprAddContext(new ExprContext(_parentctx, _parentState));
						((ExprAddContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(194);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(195);
						match(PLUS);
						setState(196);
						((ExprAddContext)_localctx).right = expr(2);
						}
						break;
					}
					} 
				}
				setState(201);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
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
	public static class LValueContext extends ParserRuleContext {
		public LValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lValue; }
	 
		public LValueContext() { }
		public void copyFrom(LValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LValueDecrContext extends LValueContext {
		public TerminalNode DECR() { return getToken(NEMParser.DECR, 0); }
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public LValueDecrContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLValueDecr(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LValueParenthesisContext extends LValueContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public LValueParenthesisContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLValueParenthesis(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LValueIdContext extends LValueContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public LValueIdContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLValueId(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LValueIncrContext extends LValueContext {
		public TerminalNode INCR() { return getToken(NEMParser.INCR, 0); }
		public LValueContext lValue() {
			return getRuleContext(LValueContext.class,0);
		}
		public LValueIncrContext(LValueContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitLValueIncr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LValueContext lValue() throws RecognitionException {
		LValueContext _localctx = new LValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_lValue);
		try {
			setState(213);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				_localctx = new LValueIdContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(204);
				match(IDENTIFIER);
				}
				break;
			case INCR:
				_localctx = new LValueIncrContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(INCR);
				setState(206);
				lValue();
				}
				break;
			case DECR:
				_localctx = new LValueDecrContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(207);
				match(DECR);
				setState(208);
				lValue();
				}
				break;
			case OPEN_PARENTHESIS:
				_localctx = new LValueParenthesisContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(209);
				match(OPEN_PARENTHESIS);
				setState(210);
				lValue();
				setState(211);
				match(CLOSE_PARENTHESIS);
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
	public static class VarTypeContext extends ParserRuleContext {
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	 
		public VarTypeContext() { }
		public void copyFrom(VarTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerContext extends VarTypeContext {
		public TerminalNode INT() { return getToken(NEMParser.INT, 0); }
		public IntegerContext(VarTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_varType);
		try {
			_localctx = new IntegerContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(215);
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
	public static class ReturnTypeContext extends ParserRuleContext {
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	 
		public ReturnTypeContext() { }
		public void copyFrom(ReturnTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WithoutReturnTypeContext extends ReturnTypeContext {
		public TerminalNode VOID() { return getToken(NEMParser.VOID, 0); }
		public WithoutReturnTypeContext(ReturnTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitWithoutReturnType(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class WithReturnTypeContext extends ReturnTypeContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public WithReturnTypeContext(ReturnTypeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitWithReturnType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_returnType);
		try {
			setState(219);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				_localctx = new WithoutReturnTypeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				match(VOID);
				}
				break;
			case INT:
				_localctx = new WithReturnTypeContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(218);
				varType();
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
		case 17:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#\u00de\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0004\u0000.\b\u0000\u000b\u0000\f\u0000/\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003=\b\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0005"+
		"\u0004E\b\u0004\n\u0004\f\u0004H\t\u0004\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005N\b\u0005\u0001\u0006\u0001\u0006\u0003"+
		"\u0006R\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0005\u0007Y\b\u0007\n\u0007\f\u0007\\\t\u0007\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0005\bb\b\b\n\b\f\be\t\b\u0001\b\u0001\b\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\to\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n{\b"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0001\f\u0003\f\u008d\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0003\r\u009a\b\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u00b5\b\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011"+
		"\u00c6\b\u0011\n\u0011\f\u0011\u00c9\t\u0011\u0001\u0012\u0001\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00d6\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0003\u0015\u00dc\b\u0015\u0001\u0015\u0000"+
		"\u0001\"\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*\u0000\u0001\u0001\u0000\u0014\u0019\u00e7"+
		"\u0000-\u0001\u0000\u0000\u0000\u00023\u0001\u0000\u0000\u0000\u00045"+
		"\u0001\u0000\u0000\u0000\u00069\u0001\u0000\u0000\u0000\bA\u0001\u0000"+
		"\u0000\u0000\nM\u0001\u0000\u0000\u0000\fO\u0001\u0000\u0000\u0000\u000e"+
		"U\u0001\u0000\u0000\u0000\u0010]\u0001\u0000\u0000\u0000\u0012n\u0001"+
		"\u0000\u0000\u0000\u0014z\u0001\u0000\u0000\u0000\u0016|\u0001\u0000\u0000"+
		"\u0000\u0018\u008c\u0001\u0000\u0000\u0000\u001a\u0099\u0001\u0000\u0000"+
		"\u0000\u001c\u009b\u0001\u0000\u0000\u0000\u001e\u009f\u0001\u0000\u0000"+
		"\u0000 \u00a1\u0001\u0000\u0000\u0000\"\u00b4\u0001\u0000\u0000\u0000"+
		"$\u00ca\u0001\u0000\u0000\u0000&\u00d5\u0001\u0000\u0000\u0000(\u00d7"+
		"\u0001\u0000\u0000\u0000*\u00db\u0001\u0000\u0000\u0000,.\u0003\u0002"+
		"\u0001\u0000-,\u0001\u0000\u0000\u0000./\u0001\u0000\u0000\u0000/-\u0001"+
		"\u0000\u0000\u0000/0\u0001\u0000\u0000\u000001\u0001\u0000\u0000\u0000"+
		"12\u0005\u0000\u0000\u00012\u0001\u0001\u0000\u0000\u000034\u0003\u0004"+
		"\u0002\u00004\u0003\u0001\u0000\u0000\u000056\u0005\u001c\u0000\u0000"+
		"67\u0003\u0006\u0003\u000078\u0003\u0010\b\u00008\u0005\u0001\u0000\u0000"+
		"\u00009:\u0005#\u0000\u0000:<\u0005\t\u0000\u0000;=\u0003\b\u0004\u0000"+
		"<;\u0001\u0000\u0000\u0000<=\u0001\u0000\u0000\u0000=>\u0001\u0000\u0000"+
		"\u0000>?\u0005\n\u0000\u0000?@\u0003*\u0015\u0000@\u0007\u0001\u0000\u0000"+
		"\u0000AF\u0003\n\u0005\u0000BC\u0005\u0010\u0000\u0000CE\u0003\n\u0005"+
		"\u0000DB\u0001\u0000\u0000\u0000EH\u0001\u0000\u0000\u0000FD\u0001\u0000"+
		"\u0000\u0000FG\u0001\u0000\u0000\u0000G\t\u0001\u0000\u0000\u0000HF\u0001"+
		"\u0000\u0000\u0000IN\u0003(\u0014\u0000JK\u0005#\u0000\u0000KL\u0005\u0011"+
		"\u0000\u0000LN\u0003(\u0014\u0000MI\u0001\u0000\u0000\u0000MJ\u0001\u0000"+
		"\u0000\u0000N\u000b\u0001\u0000\u0000\u0000OQ\u0005\t\u0000\u0000PR\u0003"+
		"\u000e\u0007\u0000QP\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000ST\u0005\n\u0000\u0000T\r\u0001\u0000\u0000"+
		"\u0000UZ\u0003\"\u0011\u0000VW\u0005\u0010\u0000\u0000WY\u0003\"\u0011"+
		"\u0000XV\u0001\u0000\u0000\u0000Y\\\u0001\u0000\u0000\u0000ZX\u0001\u0000"+
		"\u0000\u0000Z[\u0001\u0000\u0000\u0000[\u000f\u0001\u0000\u0000\u0000"+
		"\\Z\u0001\u0000\u0000\u0000]c\u0005\u000b\u0000\u0000^_\u0003\u0012\t"+
		"\u0000_`\u0005\u0012\u0000\u0000`b\u0001\u0000\u0000\u0000a^\u0001\u0000"+
		"\u0000\u0000be\u0001\u0000\u0000\u0000ca\u0001\u0000\u0000\u0000cd\u0001"+
		"\u0000\u0000\u0000df\u0001\u0000\u0000\u0000ec\u0001\u0000\u0000\u0000"+
		"fg\u0005\f\u0000\u0000g\u0011\u0001\u0000\u0000\u0000ho\u0003\u0016\u000b"+
		"\u0000io\u0003\u0018\f\u0000jo\u0003\u001a\r\u0000ko\u0003\u001c\u000e"+
		"\u0000lo\u0003 \u0010\u0000mo\u0003\u0014\n\u0000nh\u0001\u0000\u0000"+
		"\u0000ni\u0001\u0000\u0000\u0000nj\u0001\u0000\u0000\u0000nk\u0001\u0000"+
		"\u0000\u0000nl\u0001\u0000\u0000\u0000nm\u0001\u0000\u0000\u0000o\u0013"+
		"\u0001\u0000\u0000\u0000pq\u0005\u001a\u0000\u0000q{\u0003&\u0013\u0000"+
		"rs\u0005\u001b\u0000\u0000s{\u0003&\u0013\u0000tu\u0003&\u0013\u0000u"+
		"v\u0005\u001a\u0000\u0000v{\u0001\u0000\u0000\u0000wx\u0003&\u0013\u0000"+
		"xy\u0005\u001b\u0000\u0000y{\u0001\u0000\u0000\u0000zp\u0001\u0000\u0000"+
		"\u0000zr\u0001\u0000\u0000\u0000zt\u0001\u0000\u0000\u0000zw\u0001\u0000"+
		"\u0000\u0000{\u0015\u0001\u0000\u0000\u0000|}\u0005\u001d\u0000\u0000"+
		"}~\u0005#\u0000\u0000~\u007f\u0005\u0011\u0000\u0000\u007f\u0080\u0003"+
		"(\u0014\u0000\u0080\u0017\u0001\u0000\u0000\u0000\u0081\u0082\u0005\u001d"+
		"\u0000\u0000\u0082\u0083\u0005#\u0000\u0000\u0083\u0084\u0005\u0014\u0000"+
		"\u0000\u0084\u008d\u0003\"\u0011\u0000\u0085\u0086\u0005\u001d\u0000\u0000"+
		"\u0086\u0087\u0005#\u0000\u0000\u0087\u0088\u0005\u0011\u0000\u0000\u0088"+
		"\u0089\u0003(\u0014\u0000\u0089\u008a\u0005\u0014\u0000\u0000\u008a\u008b"+
		"\u0003\"\u0011\u0000\u008b\u008d\u0001\u0000\u0000\u0000\u008c\u0081\u0001"+
		"\u0000\u0000\u0000\u008c\u0085\u0001\u0000\u0000\u0000\u008d\u0019\u0001"+
		"\u0000\u0000\u0000\u008e\u008f\u0005\u001e\u0000\u0000\u008f\u0090\u0005"+
		"#\u0000\u0000\u0090\u0091\u0005\u0014\u0000\u0000\u0091\u009a\u0003\""+
		"\u0011\u0000\u0092\u0093\u0005\u001e\u0000\u0000\u0093\u0094\u0005#\u0000"+
		"\u0000\u0094\u0095\u0005\u0011\u0000\u0000\u0095\u0096\u0003(\u0014\u0000"+
		"\u0096\u0097\u0005\u0014\u0000\u0000\u0097\u0098\u0003\"\u0011\u0000\u0098"+
		"\u009a\u0001\u0000\u0000\u0000\u0099\u008e\u0001\u0000\u0000\u0000\u0099"+
		"\u0092\u0001\u0000\u0000\u0000\u009a\u001b\u0001\u0000\u0000\u0000\u009b"+
		"\u009c\u0003&\u0013\u0000\u009c\u009d\u0003\u001e\u000f\u0000\u009d\u009e"+
		"\u0003\"\u0011\u0000\u009e\u001d\u0001\u0000\u0000\u0000\u009f\u00a0\u0007"+
		"\u0000\u0000\u0000\u00a0\u001f\u0001\u0000\u0000\u0000\u00a1\u00a2\u0003"+
		"&\u0013\u0000\u00a2\u00a3\u0003\f\u0006\u0000\u00a3!\u0001\u0000\u0000"+
		"\u0000\u00a4\u00a5\u0006\u0011\uffff\uffff\u0000\u00a5\u00b5\u0003$\u0012"+
		"\u0000\u00a6\u00b5\u0003&\u0013\u0000\u00a7\u00a8\u0003&\u0013\u0000\u00a8"+
		"\u00a9\u0005\u001a\u0000\u0000\u00a9\u00b5\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0003&\u0013\u0000\u00ab\u00ac\u0005\u001b\u0000\u0000\u00ac\u00b5"+
		"\u0001\u0000\u0000\u0000\u00ad\u00b5\u0003 \u0010\u0000\u00ae\u00af\u0005"+
		"\t\u0000\u0000\u00af\u00b0\u0003\"\u0011\u0000\u00b0\u00b1\u0005\n\u0000"+
		"\u0000\u00b1\u00b5\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005\u0005\u0000"+
		"\u0000\u00b3\u00b5\u0003\"\u0011\u0006\u00b4\u00a4\u0001\u0000\u0000\u0000"+
		"\u00b4\u00a6\u0001\u0000\u0000\u0000\u00b4\u00a7\u0001\u0000\u0000\u0000"+
		"\u00b4\u00aa\u0001\u0000\u0000\u0000\u00b4\u00ad\u0001\u0000\u0000\u0000"+
		"\u00b4\u00ae\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000"+
		"\u00b5\u00c7\u0001\u0000\u0000\u0000\u00b6\u00b7\n\u0005\u0000\u0000\u00b7"+
		"\u00b8\u0005\b\u0000\u0000\u00b8\u00c6\u0003\"\u0011\u0006\u00b9\u00ba"+
		"\n\u0004\u0000\u0000\u00ba\u00bb\u0005\u0007\u0000\u0000\u00bb\u00c6\u0003"+
		"\"\u0011\u0005\u00bc\u00bd\n\u0003\u0000\u0000\u00bd\u00be\u0005\u0006"+
		"\u0000\u0000\u00be\u00c6\u0003\"\u0011\u0004\u00bf\u00c0\n\u0002\u0000"+
		"\u0000\u00c0\u00c1\u0005\u0005\u0000\u0000\u00c1\u00c6\u0003\"\u0011\u0003"+
		"\u00c2\u00c3\n\u0001\u0000\u0000\u00c3\u00c4\u0005\u0004\u0000\u0000\u00c4"+
		"\u00c6\u0003\"\u0011\u0002\u00c5\u00b6\u0001\u0000\u0000\u0000\u00c5\u00b9"+
		"\u0001\u0000\u0000\u0000\u00c5\u00bc\u0001\u0000\u0000\u0000\u00c5\u00bf"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c2\u0001\u0000\u0000\u0000\u00c6\u00c9"+
		"\u0001\u0000\u0000\u0000\u00c7\u00c5\u0001\u0000\u0000\u0000\u00c7\u00c8"+
		"\u0001\u0000\u0000\u0000\u00c8#\u0001\u0000\u0000\u0000\u00c9\u00c7\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005\"\u0000\u0000\u00cb%\u0001\u0000"+
		"\u0000\u0000\u00cc\u00d6\u0005#\u0000\u0000\u00cd\u00ce\u0005\u001a\u0000"+
		"\u0000\u00ce\u00d6\u0003&\u0013\u0000\u00cf\u00d0\u0005\u001b\u0000\u0000"+
		"\u00d0\u00d6\u0003&\u0013\u0000\u00d1\u00d2\u0005\t\u0000\u0000\u00d2"+
		"\u00d3\u0003&\u0013\u0000\u00d3\u00d4\u0005\n\u0000\u0000\u00d4\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d5\u00cc\u0001\u0000\u0000\u0000\u00d5\u00cd"+
		"\u0001\u0000\u0000\u0000\u00d5\u00cf\u0001\u0000\u0000\u0000\u00d5\u00d1"+
		"\u0001\u0000\u0000\u0000\u00d6\'\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005"+
		"!\u0000\u0000\u00d8)\u0001\u0000\u0000\u0000\u00d9\u00dc\u0005 \u0000"+
		"\u0000\u00da\u00dc\u0003(\u0014\u0000\u00db\u00d9\u0001\u0000\u0000\u0000"+
		"\u00db\u00da\u0001\u0000\u0000\u0000\u00dc+\u0001\u0000\u0000\u0000\u0010"+
		"/<FMQZcnz\u008c\u0099\u00b4\u00c5\u00c7\u00d5\u00db";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}