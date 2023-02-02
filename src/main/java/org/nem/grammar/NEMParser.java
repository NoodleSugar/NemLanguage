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
		IL_COMMENT=1, ML_COMMENT=2, WHITESPACE=3, HASH=4, PLUS=5, MINUS=6, STAR=7, 
		SLASH=8, EQUAL=9, OPEN_PARENTHESIS=10, CLOSE_PARENTHESIS=11, OPEN_BRACKET=12, 
		CLOSE_BRACKET=13, OPEN_BRACE=14, CLOSE_BRACE=15, OPEN_CHEVRON=16, CLOSE_CHEVRON=17, 
		AMPERSAND=18, CIRCUMFLEX=19, EXCLAMATION=20, QUESTION=21, POINT=22, COMMA=23, 
		COLON=24, SEMICOLON=25, OP_OR=26, OP_AND=27, OP_EQ=28, OP_NE=29, OP_LE=30, 
		OP_GE=31, EQ_ADD=32, EQ_SUB=33, EQ_MUL=34, EQ_DIV=35, INCR=36, DECR=37, 
		ARROW=38, MODULE=39, IMPORT=40, EXPORT=41, NAMESPACE=42, TYPE=43, CLASS=44, 
		COMPTIME=45, PUBLIC=46, PRIVATE=47, PROTECTED=48, IF=49, ELSE=50, WHILE=51, 
		FOR=52, SWITCH=53, CASE=54, CONTINUE=55, BREAK=56, RETURN=57, TRUE=58, 
		FALSE=59, VOID=60, BOOL=61, CHAR=62, INT=63, FLOAT=64, DOUBLE=65, SHORT=66, 
		LONG=67, FN=68, VAR=69, CONST=70, SIGNED=71, UNSIGNED=72, LREF=73, RREF=74, 
		FREF=75, L_NUM=76, L_CHAR=77, L_STR=78, IDENTIFIER=79;
	public static final int
		RULE_file = 0, RULE_top_level = 1, RULE_module_path = 2, RULE_module_import = 3, 
		RULE_module_decl = 4, RULE_module_export = 5, RULE_class_def = 6, RULE_param = 7, 
		RULE_param_seq = 8, RULE_arg_seq = 9, RULE_fn_signature = 10, RULE_fn_decl = 11, 
		RULE_fn_def = 12, RULE_fn_call = 13, RULE_instr_block = 14, RULE_instr_seq = 15, 
		RULE_instr = 16, RULE_var_decl = 17, RULE_var_def = 18, RULE_assign = 19, 
		RULE_literal = 20, RULE_expr = 21, RULE_arith_expr = 22, RULE_bool_expr = 23, 
		RULE_lvalue = 24, RULE_if_statement = 25, RULE_primitive_type = 26, RULE_var_type_seq = 27, 
		RULE_var_type = 28, RULE_generic_arg_seq = 29, RULE_generic_arg = 30, 
		RULE_return_type = 31;
	private static String[] makeRuleNames() {
		return new String[] {
			"file", "top_level", "module_path", "module_import", "module_decl", "module_export", 
			"class_def", "param", "param_seq", "arg_seq", "fn_signature", "fn_decl", 
			"fn_def", "fn_call", "instr_block", "instr_seq", "instr", "var_decl", 
			"var_def", "assign", "literal", "expr", "arith_expr", "bool_expr", "lvalue", 
			"if_statement", "primitive_type", "var_type_seq", "var_type", "generic_arg_seq", 
			"generic_arg", "return_type"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'#'", "'+'", "'-'", "'*'", "'/'", "'='", "'('", 
			"')'", "'['", "']'", "'{'", "'}'", "'<'", "'>'", "'&'", "'^'", "'!'", 
			"'?'", "'.'", "','", "':'", "';'", "'||'", "'&&'", "'=='", "'!='", "'<='", 
			"'>='", "'+='", "'-='", "'*='", "'/='", "'++'", "'--'", "'->'", "'module'", 
			"'import'", "'export'", "'namespace'", "'type'", "'class'", "'comptime'", 
			"'public'", "'private'", "'protected'", "'if'", "'else'", "'while'", 
			"'for'", "'switch'", "'case'", "'continue'", "'break'", "'return'", "'true'", 
			"'false'", "'void'", "'bool'", "'char'", "'int'", "'float'", "'double'", 
			"'short'", "'long'", "'fn'", "'var'", "'const'", "'signed'", "'unsigned'", 
			"'l&'", "'r&'", "'f&'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "IL_COMMENT", "ML_COMMENT", "WHITESPACE", "HASH", "PLUS", "MINUS", 
			"STAR", "SLASH", "EQUAL", "OPEN_PARENTHESIS", "CLOSE_PARENTHESIS", "OPEN_BRACKET", 
			"CLOSE_BRACKET", "OPEN_BRACE", "CLOSE_BRACE", "OPEN_CHEVRON", "CLOSE_CHEVRON", 
			"AMPERSAND", "CIRCUMFLEX", "EXCLAMATION", "QUESTION", "POINT", "COMMA", 
			"COLON", "SEMICOLON", "OP_OR", "OP_AND", "OP_EQ", "OP_NE", "OP_LE", "OP_GE", 
			"EQ_ADD", "EQ_SUB", "EQ_MUL", "EQ_DIV", "INCR", "DECR", "ARROW", "MODULE", 
			"IMPORT", "EXPORT", "NAMESPACE", "TYPE", "CLASS", "COMPTIME", "PUBLIC", 
			"PRIVATE", "PROTECTED", "IF", "ELSE", "WHILE", "FOR", "SWITCH", "CASE", 
			"CONTINUE", "BREAK", "RETURN", "TRUE", "FALSE", "VOID", "BOOL", "CHAR", 
			"INT", "FLOAT", "DOUBLE", "SHORT", "LONG", "FN", "VAR", "CONST", "SIGNED", 
			"UNSIGNED", "LREF", "RREF", "FREF", "L_NUM", "L_CHAR", "L_STR", "IDENTIFIER"
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
		public Top_levelContext top_level() {
			return getRuleContext(Top_levelContext.class,0);
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
			setState(64);
			top_level();
			setState(65);
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
	public static class Top_levelContext extends ParserRuleContext {
		public Module_declContext module_decl() {
			return getRuleContext(Module_declContext.class,0);
		}
		public Module_importContext module_import() {
			return getRuleContext(Module_importContext.class,0);
		}
		public Module_exportContext module_export() {
			return getRuleContext(Module_exportContext.class,0);
		}
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public TerminalNode EXPORT() { return getToken(NEMParser.EXPORT, 0); }
		public Fn_declContext fn_decl() {
			return getRuleContext(Fn_declContext.class,0);
		}
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
		enterRule(_localctx, 2, RULE_top_level);
		int _la;
		try {
			setState(83);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(68);
				module_decl();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(69);
				module_import();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(70);
				module_export();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(71);
					match(EXPORT);
					}
				}

				setState(74);
				class_def();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(76);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(75);
					match(EXPORT);
					}
				}

				setState(78);
				fn_decl();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(80);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXPORT) {
					{
					setState(79);
					match(EXPORT);
					}
				}

				setState(82);
				fn_def();
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
	public static class Module_pathContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode POINT() { return getToken(NEMParser.POINT, 0); }
		public Module_pathContext module_path() {
			return getRuleContext(Module_pathContext.class,0);
		}
		public Module_pathContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_path; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterModule_path(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitModule_path(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitModule_path(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_pathContext module_path() throws RecognitionException {
		Module_pathContext _localctx = new Module_pathContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_module_path);
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(IDENTIFIER);
				setState(87);
				match(POINT);
				setState(88);
				module_path();
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
	public static class Module_importContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(NEMParser.IMPORT, 0); }
		public Module_pathContext module_path() {
			return getRuleContext(Module_pathContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NEMParser.SEMICOLON, 0); }
		public Module_importContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_import; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterModule_import(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitModule_import(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitModule_import(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_importContext module_import() throws RecognitionException {
		Module_importContext _localctx = new Module_importContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_module_import);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(IMPORT);
			setState(92);
			module_path();
			setState(93);
			match(SEMICOLON);
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
	public static class Module_declContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(NEMParser.MODULE, 0); }
		public Module_pathContext module_path() {
			return getRuleContext(Module_pathContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(NEMParser.SEMICOLON, 0); }
		public Module_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterModule_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitModule_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitModule_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_declContext module_decl() throws RecognitionException {
		Module_declContext _localctx = new Module_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_module_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			match(MODULE);
			setState(96);
			module_path();
			setState(97);
			match(SEMICOLON);
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
	public static class Module_exportContext extends ParserRuleContext {
		public TerminalNode EXPORT() { return getToken(NEMParser.EXPORT, 0); }
		public Module_importContext module_import() {
			return getRuleContext(Module_importContext.class,0);
		}
		public Module_declContext module_decl() {
			return getRuleContext(Module_declContext.class,0);
		}
		public Module_exportContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_module_export; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterModule_export(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitModule_export(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitModule_export(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Module_exportContext module_export() throws RecognitionException {
		Module_exportContext _localctx = new Module_exportContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_module_export);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(EXPORT);
			setState(102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				{
				setState(100);
				module_import();
				}
				break;
			case MODULE:
				{
				setState(101);
				module_decl();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class Class_defContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(NEMParser.CLASS, 0); }
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitClass_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitClass_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_class_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(104);
			match(CLASS);
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
		enterRule(_localctx, 14, RULE_param);
		try {
			setState(110);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				var_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(107);
				match(IDENTIFIER);
				setState(108);
				match(COLON);
				setState(109);
				var_type();
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
		enterRule(_localctx, 16, RULE_param_seq);
		try {
			setState(117);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(112);
				param();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(113);
				param();
				setState(114);
				match(COMMA);
				setState(115);
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
		enterRule(_localctx, 18, RULE_arg_seq);
		try {
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(120);
				expr();
				setState(121);
				match(COMMA);
				setState(122);
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
	public static class Fn_signatureContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public Param_seqContext param_seq() {
			return getRuleContext(Param_seqContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public Return_typeContext return_type() {
			return getRuleContext(Return_typeContext.class,0);
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
		enterRule(_localctx, 20, RULE_fn_signature);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(IDENTIFIER);
			setState(127);
			match(OPEN_PARENTHESIS);
			setState(128);
			param_seq();
			setState(129);
			match(CLOSE_PARENTHESIS);
			setState(130);
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
	public static class Fn_declContext extends ParserRuleContext {
		public TerminalNode FN() { return getToken(NEMParser.FN, 0); }
		public Fn_signatureContext fn_signature() {
			return getRuleContext(Fn_signatureContext.class,0);
		}
		public Fn_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterFn_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitFn_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFn_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_declContext fn_decl() throws RecognitionException {
		Fn_declContext _localctx = new Fn_declContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fn_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			match(FN);
			setState(133);
			fn_signature();
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
		enterRule(_localctx, 24, RULE_fn_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(FN);
			setState(136);
			fn_signature();
			setState(137);
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
	public static class Fn_callContext extends ParserRuleContext {
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public Arg_seqContext arg_seq() {
			return getRuleContext(Arg_seqContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public Fn_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fn_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterFn_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitFn_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitFn_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fn_callContext fn_call() throws RecognitionException {
		Fn_callContext _localctx = new Fn_callContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fn_call);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(139);
			match(OPEN_PARENTHESIS);
			setState(140);
			arg_seq();
			setState(141);
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
	public static class Instr_blockContext extends ParserRuleContext {
		public TerminalNode OPEN_BRACE() { return getToken(NEMParser.OPEN_BRACE, 0); }
		public Instr_seqContext instr_seq() {
			return getRuleContext(Instr_seqContext.class,0);
		}
		public TerminalNode CLOSE_BRACE() { return getToken(NEMParser.CLOSE_BRACE, 0); }
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
		enterRule(_localctx, 28, RULE_instr_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(OPEN_BRACE);
			setState(144);
			instr_seq();
			setState(145);
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
		enterRule(_localctx, 30, RULE_instr_seq);
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(147);
				instr();
				setState(148);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(150);
				instr();
				setState(151);
				match(SEMICOLON);
				setState(152);
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
		public AssignContext assign() {
			return getRuleContext(AssignContext.class,0);
		}
		public Fn_callContext fn_call() {
			return getRuleContext(Fn_callContext.class,0);
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
		enterRule(_localctx, 32, RULE_instr);
		try {
			setState(160);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(156);
				var_decl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(157);
				var_def();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(158);
				assign();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(159);
				fn_call();
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
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode COLON() { return getToken(NEMParser.COLON, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode CONST() { return getToken(NEMParser.CONST, 0); }
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
		enterRule(_localctx, 34, RULE_var_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			_la = _input.LA(1);
			if ( !(_la==VAR || _la==CONST) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(163);
			match(IDENTIFIER);
			setState(164);
			match(COLON);
			setState(165);
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
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(NEMParser.EQUAL, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode VAR() { return getToken(NEMParser.VAR, 0); }
		public TerminalNode CONST() { return getToken(NEMParser.CONST, 0); }
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
		enterRule(_localctx, 36, RULE_var_def);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(167);
				_la = _input.LA(1);
				if ( !(_la==VAR || _la==CONST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(168);
				match(IDENTIFIER);
				setState(169);
				match(EQUAL);
				setState(170);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				_la = _input.LA(1);
				if ( !(_la==VAR || _la==CONST) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(172);
				match(IDENTIFIER);
				setState(173);
				match(COLON);
				setState(174);
				var_type();
				setState(175);
				match(EQUAL);
				setState(176);
				expr();
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
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(NEMParser.EQUAL, 0); }
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
		enterRule(_localctx, 38, RULE_assign);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			lvalue(0);
			setState(181);
			match(EQUAL);
			setState(182);
			expr();
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
	public static class LiteralContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(NEMParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NEMParser.FALSE, 0); }
		public TerminalNode L_CHAR() { return getToken(NEMParser.L_CHAR, 0); }
		public TerminalNode L_NUM() { return getToken(NEMParser.L_NUM, 0); }
		public TerminalNode L_STR() { return getToken(NEMParser.L_STR, 0); }
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
		enterRule(_localctx, 40, RULE_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			_la = _input.LA(1);
			if ( !((((_la - 58)) & ~0x3f) == 0 && ((1L << (_la - 58)) & 1835011L) != 0) ) {
			_errHandler.recoverInline(this);
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
	public static class ExprContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
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
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_expr);
		try {
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(186);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187);
				lvalue(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(188);
				match(OPEN_PARENTHESIS);
				setState(189);
				expr();
				setState(190);
				match(CLOSE_PARENTHESIS);
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
	public static class Arith_exprContext extends ParserRuleContext {
		public TerminalNode L_NUM() { return getToken(NEMParser.L_NUM, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode MINUS() { return getToken(NEMParser.MINUS, 0); }
		public If_statementContext if_statement() {
			return getRuleContext(If_statementContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(NEMParser.ELSE, 0); }
		public TerminalNode SLASH() { return getToken(NEMParser.SLASH, 0); }
		public TerminalNode STAR() { return getToken(NEMParser.STAR, 0); }
		public TerminalNode PLUS() { return getToken(NEMParser.PLUS, 0); }
		public Arith_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arith_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterArith_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitArith_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitArith_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arith_exprContext arith_expr() throws RecognitionException {
		return arith_expr(0);
	}

	private Arith_exprContext arith_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Arith_exprContext _localctx = new Arith_exprContext(_ctx, _parentState);
		Arith_exprContext _prevctx = _localctx;
		int _startState = 44;
		enterRecursionRule(_localctx, 44, RULE_arith_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_NUM:
				{
				setState(195);
				match(L_NUM);
				}
				break;
			case OPEN_PARENTHESIS:
				{
				setState(196);
				match(OPEN_PARENTHESIS);
				setState(197);
				arith_expr(0);
				setState(198);
				match(CLOSE_PARENTHESIS);
				}
				break;
			case MINUS:
				{
				setState(200);
				match(MINUS);
				setState(201);
				arith_expr(6);
				}
				break;
			case IF:
				{
				setState(202);
				if_statement();
				setState(203);
				arith_expr(0);
				setState(206);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
				case 1:
					{
					setState(204);
					match(ELSE);
					setState(205);
					arith_expr(0);
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(222);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
					case 1:
						{
						_localctx = new Arith_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(210);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(211);
						match(SLASH);
						setState(212);
						arith_expr(6);
						}
						break;
					case 2:
						{
						_localctx = new Arith_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(213);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(214);
						match(STAR);
						setState(215);
						arith_expr(5);
						}
						break;
					case 3:
						{
						_localctx = new Arith_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(216);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(217);
						match(MINUS);
						setState(218);
						arith_expr(4);
						}
						break;
					case 4:
						{
						_localctx = new Arith_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_arith_expr);
						setState(219);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(220);
						match(PLUS);
						setState(221);
						arith_expr(3);
						}
						break;
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class Bool_exprContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(NEMParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(NEMParser.FALSE, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public List<Bool_exprContext> bool_expr() {
			return getRuleContexts(Bool_exprContext.class);
		}
		public Bool_exprContext bool_expr(int i) {
			return getRuleContext(Bool_exprContext.class,i);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public List<Arith_exprContext> arith_expr() {
			return getRuleContexts(Arith_exprContext.class);
		}
		public Arith_exprContext arith_expr(int i) {
			return getRuleContext(Arith_exprContext.class,i);
		}
		public TerminalNode OPEN_CHEVRON() { return getToken(NEMParser.OPEN_CHEVRON, 0); }
		public TerminalNode CLOSE_CHEVRON() { return getToken(NEMParser.CLOSE_CHEVRON, 0); }
		public TerminalNode OP_LE() { return getToken(NEMParser.OP_LE, 0); }
		public TerminalNode OP_GE() { return getToken(NEMParser.OP_GE, 0); }
		public TerminalNode OP_EQ() { return getToken(NEMParser.OP_EQ, 0); }
		public TerminalNode OP_NE() { return getToken(NEMParser.OP_NE, 0); }
		public TerminalNode OP_AND() { return getToken(NEMParser.OP_AND, 0); }
		public TerminalNode OP_OR() { return getToken(NEMParser.OP_OR, 0); }
		public Bool_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterBool_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitBool_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitBool_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_exprContext bool_expr() throws RecognitionException {
		return bool_expr(0);
	}

	private Bool_exprContext bool_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bool_exprContext _localctx = new Bool_exprContext(_ctx, _parentState);
		Bool_exprContext _prevctx = _localctx;
		int _startState = 46;
		enterRecursionRule(_localctx, 46, RULE_bool_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(228);
				match(TRUE);
				}
				break;
			case 2:
				{
				setState(229);
				match(FALSE);
				}
				break;
			case 3:
				{
				setState(230);
				match(OPEN_PARENTHESIS);
				setState(231);
				bool_expr(0);
				setState(232);
				match(CLOSE_PARENTHESIS);
				}
				break;
			case 4:
				{
				setState(234);
				arith_expr(0);
				setState(235);
				_la = _input.LA(1);
				if ( !(((_la) & ~0x3f) == 0 && ((1L << _la) & 3221422080L) != 0) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(236);
				arith_expr(0);
				}
				break;
			case 5:
				{
				setState(238);
				arith_expr(0);
				setState(239);
				_la = _input.LA(1);
				if ( !(_la==OP_EQ || _la==OP_NE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(240);
				arith_expr(0);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(250);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new Bool_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
						setState(244);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(245);
						match(OP_AND);
						setState(246);
						bool_expr(3);
						}
						break;
					case 2:
						{
						_localctx = new Bool_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_bool_expr);
						setState(247);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(248);
						match(OP_OR);
						setState(249);
						bool_expr(2);
						}
						break;
					}
					} 
				}
				setState(254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class LvalueContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public LvalueContext lvalue() {
			return getRuleContext(LvalueContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public TerminalNode STAR() { return getToken(NEMParser.STAR, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode INCR() { return getToken(NEMParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(NEMParser.DECR, 0); }
		public Fn_callContext fn_call() {
			return getRuleContext(Fn_callContext.class,0);
		}
		public TerminalNode OPEN_BRACKET() { return getToken(NEMParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(NEMParser.CLOSE_BRACKET, 0); }
		public TerminalNode POINT() { return getToken(NEMParser.POINT, 0); }
		public TerminalNode ARROW() { return getToken(NEMParser.ARROW, 0); }
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
		int _startState = 48;
		enterRecursionRule(_localctx, 48, RULE_lvalue, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				{
				setState(256);
				match(IDENTIFIER);
				}
				break;
			case OPEN_PARENTHESIS:
				{
				setState(257);
				match(OPEN_PARENTHESIS);
				setState(258);
				lvalue(0);
				setState(259);
				match(CLOSE_PARENTHESIS);
				}
				break;
			case STAR:
				{
				setState(261);
				match(STAR);
				setState(262);
				expr();
				}
				break;
			case INCR:
			case DECR:
				{
				setState(263);
				_la = _input.LA(1);
				if ( !(_la==INCR || _la==DECR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(264);
				lvalue(1);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(279);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(277);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(267);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(268);
						fn_call();
						}
						break;
					case 2:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(269);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(270);
						match(OPEN_BRACKET);
						setState(271);
						expr();
						setState(272);
						match(CLOSE_BRACKET);
						}
						break;
					case 3:
						{
						_localctx = new LvalueContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_lvalue);
						setState(274);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(275);
						_la = _input.LA(1);
						if ( !(_la==POINT || _la==ARROW) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(276);
						match(IDENTIFIER);
						}
						break;
					}
					} 
				}
				setState(281);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
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
	public static class If_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(NEMParser.IF, 0); }
		public TerminalNode OPEN_PARENTHESIS() { return getToken(NEMParser.OPEN_PARENTHESIS, 0); }
		public Bool_exprContext bool_expr() {
			return getRuleContext(Bool_exprContext.class,0);
		}
		public TerminalNode CLOSE_PARENTHESIS() { return getToken(NEMParser.CLOSE_PARENTHESIS, 0); }
		public If_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterIf_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitIf_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitIf_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_statementContext if_statement() throws RecognitionException {
		If_statementContext _localctx = new If_statementContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_if_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(282);
			match(IF);
			setState(283);
			match(OPEN_PARENTHESIS);
			setState(284);
			bool_expr(0);
			setState(285);
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
	public static class Primitive_typeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(NEMParser.BOOL, 0); }
		public TerminalNode CHAR() { return getToken(NEMParser.CHAR, 0); }
		public TerminalNode INT() { return getToken(NEMParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(NEMParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(NEMParser.DOUBLE, 0); }
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
		enterRule(_localctx, 52, RULE_primitive_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287);
			_la = _input.LA(1);
			if ( !((((_la - 61)) & ~0x3f) == 0 && ((1L << (_la - 61)) & 31L) != 0) ) {
			_errHandler.recoverInline(this);
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
	public static class Var_type_seqContext extends ParserRuleContext {
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(NEMParser.COMMA, 0); }
		public Var_type_seqContext var_type_seq() {
			return getRuleContext(Var_type_seqContext.class,0);
		}
		public Var_type_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_type_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterVar_type_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitVar_type_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitVar_type_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_type_seqContext var_type_seq() throws RecognitionException {
		Var_type_seqContext _localctx = new Var_type_seqContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_var_type_seq);
		try {
			setState(296);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(289);
				var_type();
				setState(290);
				match(COMMA);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(292);
				var_type();
				setState(293);
				match(COMMA);
				setState(294);
				var_type_seq();
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
	public static class Var_typeContext extends ParserRuleContext {
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
		public TerminalNode OPEN_CHEVRON() { return getToken(NEMParser.OPEN_CHEVRON, 0); }
		public Generic_arg_seqContext generic_arg_seq() {
			return getRuleContext(Generic_arg_seqContext.class,0);
		}
		public TerminalNode CLOSE_CHEVRON() { return getToken(NEMParser.CLOSE_CHEVRON, 0); }
		public TerminalNode OPEN_BRACKET() { return getToken(NEMParser.OPEN_BRACKET, 0); }
		public TerminalNode CLOSE_BRACKET() { return getToken(NEMParser.CLOSE_BRACKET, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Arith_exprContext arith_expr() {
			return getRuleContext(Arith_exprContext.class,0);
		}
		public TerminalNode STAR() { return getToken(NEMParser.STAR, 0); }
		public TerminalNode CONST() { return getToken(NEMParser.CONST, 0); }
		public TerminalNode QUESTION() { return getToken(NEMParser.QUESTION, 0); }
		public TerminalNode LREF() { return getToken(NEMParser.LREF, 0); }
		public TerminalNode RREF() { return getToken(NEMParser.RREF, 0); }
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
		enterRule(_localctx, 56, RULE_var_type);
		int _la;
		try {
			setState(321);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case CHAR:
			case INT:
			case FLOAT:
			case DOUBLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(298);
				primitive_type();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(299);
				match(IDENTIFIER);
				setState(304);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==OPEN_CHEVRON) {
					{
					setState(300);
					match(OPEN_CHEVRON);
					setState(301);
					generic_arg_seq();
					setState(302);
					match(CLOSE_CHEVRON);
					}
				}

				}
				break;
			case OPEN_BRACKET:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				match(OPEN_BRACKET);
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((_la) & ~0x3f) == 0 && ((1L << _la) & 562949953422400L) != 0 || _la==L_NUM) {
					{
					setState(307);
					arith_expr(0);
					}
				}

				setState(310);
				match(CLOSE_BRACKET);
				setState(311);
				var_type();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 4);
				{
				setState(312);
				match(STAR);
				setState(314);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CONST) {
					{
					setState(313);
					match(CONST);
					}
				}

				setState(316);
				var_type();
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 5);
				{
				setState(317);
				match(QUESTION);
				setState(318);
				var_type();
				}
				break;
			case LREF:
			case RREF:
				enterOuterAlt(_localctx, 6);
				{
				setState(319);
				_la = _input.LA(1);
				if ( !(_la==LREF || _la==RREF) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(320);
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
	public static class Generic_arg_seqContext extends ParserRuleContext {
		public Generic_argContext generic_arg() {
			return getRuleContext(Generic_argContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(NEMParser.COMMA, 0); }
		public Generic_arg_seqContext generic_arg_seq() {
			return getRuleContext(Generic_arg_seqContext.class,0);
		}
		public Generic_arg_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_arg_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterGeneric_arg_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitGeneric_arg_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitGeneric_arg_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generic_arg_seqContext generic_arg_seq() throws RecognitionException {
		Generic_arg_seqContext _localctx = new Generic_arg_seqContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_generic_arg_seq);
		try {
			setState(328);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(323);
				generic_arg();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(324);
				generic_arg();
				setState(325);
				match(COMMA);
				setState(326);
				generic_arg_seq();
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
	public static class Generic_argContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(NEMParser.VOID, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public Generic_argContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_generic_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).enterGeneric_arg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof NEMParserListener ) ((NEMParserListener)listener).exitGeneric_arg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof NEMParserVisitor ) return ((NEMParserVisitor<? extends T>)visitor).visitGeneric_arg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Generic_argContext generic_arg() throws RecognitionException {
		Generic_argContext _localctx = new Generic_argContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_generic_arg);
		try {
			setState(332);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(330);
				match(VOID);
				}
				break;
			case STAR:
			case OPEN_BRACKET:
			case QUESTION:
			case BOOL:
			case CHAR:
			case INT:
			case FLOAT:
			case DOUBLE:
			case LREF:
			case RREF:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(331);
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
	public static class Return_typeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(NEMParser.VOID, 0); }
		public Var_typeContext var_type() {
			return getRuleContext(Var_typeContext.class,0);
		}
		public TerminalNode EXCLAMATION() { return getToken(NEMParser.EXCLAMATION, 0); }
		public TerminalNode IDENTIFIER() { return getToken(NEMParser.IDENTIFIER, 0); }
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
		enterRule(_localctx, 62, RULE_return_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(338);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				{
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(334);
					match(IDENTIFIER);
					}
				}

				setState(337);
				match(EXCLAMATION);
				}
				break;
			}
			setState(342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				{
				setState(340);
				match(VOID);
				}
				break;
			case STAR:
			case OPEN_BRACKET:
			case QUESTION:
			case BOOL:
			case CHAR:
			case INT:
			case FLOAT:
			case DOUBLE:
			case LREF:
			case RREF:
			case IDENTIFIER:
				{
				setState(341);
				var_type();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 22:
			return arith_expr_sempred((Arith_exprContext)_localctx, predIndex);
		case 23:
			return bool_expr_sempred((Bool_exprContext)_localctx, predIndex);
		case 24:
			return lvalue_sempred((LvalueContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean arith_expr_sempred(Arith_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bool_expr_sempred(Bool_exprContext _localctx, int predIndex) {
		switch (predIndex) {
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
			return precpred(_ctx, 5);
		case 7:
			return precpred(_ctx, 4);
		case 8:
			return precpred(_ctx, 3);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001O\u0159\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001I\b\u0001"+
		"\u0001\u0001\u0001\u0001\u0003\u0001M\b\u0001\u0001\u0001\u0001\u0001"+
		"\u0003\u0001Q\b\u0001\u0001\u0001\u0003\u0001T\b\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0003\u0002Z\b\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005g\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007o\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\bv\b\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t}\b\t\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u009b\b\u000f\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00a1\b\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u00b3\b\u0012\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0003"+
		"\u0015\u00c1\b\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0003\u0016\u00cf\b\u0016\u0003\u0016\u00d1\b\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u00df\b\u0016\n\u0016\f\u0016\u00e2\t\u0016\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0003\u0017\u00f3\b\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017\u00fb\b\u0017\n"+
		"\u0017\f\u0017\u00fe\t\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0003\u0018\u010a\b\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0005\u0018\u0116\b\u0018\n\u0018\f\u0018\u0119\t\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0003\u001b\u0129\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0003\u001c\u0131\b\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u0135\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0003\u001c\u013b\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c"+
		"\u0001\u001c\u0001\u001c\u0003\u001c\u0142\b\u001c\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u0149\b\u001d\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u014d\b\u001e\u0001\u001f\u0003\u001f\u0150\b"+
		"\u001f\u0001\u001f\u0003\u001f\u0153\b\u001f\u0001\u001f\u0001\u001f\u0003"+
		"\u001f\u0157\b\u001f\u0001\u001f\u0000\u0003,.0 \u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>\u0000\b\u0001\u0000EF\u0002\u0000:;LN\u0002\u0000\u0010\u0011"+
		"\u001e\u001f\u0001\u0000\u001c\u001d\u0001\u0000$%\u0002\u0000\u0016\u0016"+
		"&&\u0001\u0000=A\u0001\u0000IJ\u016f\u0000@\u0001\u0000\u0000\u0000\u0002"+
		"S\u0001\u0000\u0000\u0000\u0004Y\u0001\u0000\u0000\u0000\u0006[\u0001"+
		"\u0000\u0000\u0000\b_\u0001\u0000\u0000\u0000\nc\u0001\u0000\u0000\u0000"+
		"\fh\u0001\u0000\u0000\u0000\u000en\u0001\u0000\u0000\u0000\u0010u\u0001"+
		"\u0000\u0000\u0000\u0012|\u0001\u0000\u0000\u0000\u0014~\u0001\u0000\u0000"+
		"\u0000\u0016\u0084\u0001\u0000\u0000\u0000\u0018\u0087\u0001\u0000\u0000"+
		"\u0000\u001a\u008b\u0001\u0000\u0000\u0000\u001c\u008f\u0001\u0000\u0000"+
		"\u0000\u001e\u009a\u0001\u0000\u0000\u0000 \u00a0\u0001\u0000\u0000\u0000"+
		"\"\u00a2\u0001\u0000\u0000\u0000$\u00b2\u0001\u0000\u0000\u0000&\u00b4"+
		"\u0001\u0000\u0000\u0000(\u00b8\u0001\u0000\u0000\u0000*\u00c0\u0001\u0000"+
		"\u0000\u0000,\u00d0\u0001\u0000\u0000\u0000.\u00f2\u0001\u0000\u0000\u0000"+
		"0\u0109\u0001\u0000\u0000\u00002\u011a\u0001\u0000\u0000\u00004\u011f"+
		"\u0001\u0000\u0000\u00006\u0128\u0001\u0000\u0000\u00008\u0141\u0001\u0000"+
		"\u0000\u0000:\u0148\u0001\u0000\u0000\u0000<\u014c\u0001\u0000\u0000\u0000"+
		">\u0152\u0001\u0000\u0000\u0000@A\u0003\u0002\u0001\u0000AB\u0005\u0000"+
		"\u0000\u0001B\u0001\u0001\u0000\u0000\u0000CT\u0001\u0000\u0000\u0000"+
		"DT\u0003\b\u0004\u0000ET\u0003\u0006\u0003\u0000FT\u0003\n\u0005\u0000"+
		"GI\u0005)\u0000\u0000HG\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000"+
		"IJ\u0001\u0000\u0000\u0000JT\u0003\f\u0006\u0000KM\u0005)\u0000\u0000"+
		"LK\u0001\u0000\u0000\u0000LM\u0001\u0000\u0000\u0000MN\u0001\u0000\u0000"+
		"\u0000NT\u0003\u0016\u000b\u0000OQ\u0005)\u0000\u0000PO\u0001\u0000\u0000"+
		"\u0000PQ\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0003\u0018"+
		"\f\u0000SC\u0001\u0000\u0000\u0000SD\u0001\u0000\u0000\u0000SE\u0001\u0000"+
		"\u0000\u0000SF\u0001\u0000\u0000\u0000SH\u0001\u0000\u0000\u0000SL\u0001"+
		"\u0000\u0000\u0000SP\u0001\u0000\u0000\u0000T\u0003\u0001\u0000\u0000"+
		"\u0000UZ\u0005O\u0000\u0000VW\u0005O\u0000\u0000WX\u0005\u0016\u0000\u0000"+
		"XZ\u0003\u0004\u0002\u0000YU\u0001\u0000\u0000\u0000YV\u0001\u0000\u0000"+
		"\u0000Z\u0005\u0001\u0000\u0000\u0000[\\\u0005(\u0000\u0000\\]\u0003\u0004"+
		"\u0002\u0000]^\u0005\u0019\u0000\u0000^\u0007\u0001\u0000\u0000\u0000"+
		"_`\u0005\'\u0000\u0000`a\u0003\u0004\u0002\u0000ab\u0005\u0019\u0000\u0000"+
		"b\t\u0001\u0000\u0000\u0000cf\u0005)\u0000\u0000dg\u0003\u0006\u0003\u0000"+
		"eg\u0003\b\u0004\u0000fd\u0001\u0000\u0000\u0000fe\u0001\u0000\u0000\u0000"+
		"g\u000b\u0001\u0000\u0000\u0000hi\u0005,\u0000\u0000i\r\u0001\u0000\u0000"+
		"\u0000jo\u00038\u001c\u0000kl\u0005O\u0000\u0000lm\u0005\u0018\u0000\u0000"+
		"mo\u00038\u001c\u0000nj\u0001\u0000\u0000\u0000nk\u0001\u0000\u0000\u0000"+
		"o\u000f\u0001\u0000\u0000\u0000pv\u0003\u000e\u0007\u0000qr\u0003\u000e"+
		"\u0007\u0000rs\u0005\u0017\u0000\u0000st\u0003\u0010\b\u0000tv\u0001\u0000"+
		"\u0000\u0000up\u0001\u0000\u0000\u0000uq\u0001\u0000\u0000\u0000v\u0011"+
		"\u0001\u0000\u0000\u0000w}\u0003*\u0015\u0000xy\u0003*\u0015\u0000yz\u0005"+
		"\u0017\u0000\u0000z{\u0003\u0012\t\u0000{}\u0001\u0000\u0000\u0000|w\u0001"+
		"\u0000\u0000\u0000|x\u0001\u0000\u0000\u0000}\u0013\u0001\u0000\u0000"+
		"\u0000~\u007f\u0005O\u0000\u0000\u007f\u0080\u0005\n\u0000\u0000\u0080"+
		"\u0081\u0003\u0010\b\u0000\u0081\u0082\u0005\u000b\u0000\u0000\u0082\u0083"+
		"\u0003>\u001f\u0000\u0083\u0015\u0001\u0000\u0000\u0000\u0084\u0085\u0005"+
		"D\u0000\u0000\u0085\u0086\u0003\u0014\n\u0000\u0086\u0017\u0001\u0000"+
		"\u0000\u0000\u0087\u0088\u0005D\u0000\u0000\u0088\u0089\u0003\u0014\n"+
		"\u0000\u0089\u008a\u0003\u001c\u000e\u0000\u008a\u0019\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0005\n\u0000\u0000\u008c\u008d\u0003\u0012\t\u0000"+
		"\u008d\u008e\u0005\u000b\u0000\u0000\u008e\u001b\u0001\u0000\u0000\u0000"+
		"\u008f\u0090\u0005\u000e\u0000\u0000\u0090\u0091\u0003\u001e\u000f\u0000"+
		"\u0091\u0092\u0005\u000f\u0000\u0000\u0092\u001d\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0003 \u0010\u0000\u0094\u0095\u0005\u0019\u0000\u0000\u0095"+
		"\u009b\u0001\u0000\u0000\u0000\u0096\u0097\u0003 \u0010\u0000\u0097\u0098"+
		"\u0005\u0019\u0000\u0000\u0098\u0099\u0003\u001e\u000f\u0000\u0099\u009b"+
		"\u0001\u0000\u0000\u0000\u009a\u0093\u0001\u0000\u0000\u0000\u009a\u0096"+
		"\u0001\u0000\u0000\u0000\u009b\u001f\u0001\u0000\u0000\u0000\u009c\u00a1"+
		"\u0003\"\u0011\u0000\u009d\u00a1\u0003$\u0012\u0000\u009e\u00a1\u0003"+
		"&\u0013\u0000\u009f\u00a1\u0003\u001a\r\u0000\u00a0\u009c\u0001\u0000"+
		"\u0000\u0000\u00a0\u009d\u0001\u0000\u0000\u0000\u00a0\u009e\u0001\u0000"+
		"\u0000\u0000\u00a0\u009f\u0001\u0000\u0000\u0000\u00a1!\u0001\u0000\u0000"+
		"\u0000\u00a2\u00a3\u0007\u0000\u0000\u0000\u00a3\u00a4\u0005O\u0000\u0000"+
		"\u00a4\u00a5\u0005\u0018\u0000\u0000\u00a5\u00a6\u00038\u001c\u0000\u00a6"+
		"#\u0001\u0000\u0000\u0000\u00a7\u00a8\u0007\u0000\u0000\u0000\u00a8\u00a9"+
		"\u0005O\u0000\u0000\u00a9\u00aa\u0005\t\u0000\u0000\u00aa\u00b3\u0003"+
		"*\u0015\u0000\u00ab\u00ac\u0007\u0000\u0000\u0000\u00ac\u00ad\u0005O\u0000"+
		"\u0000\u00ad\u00ae\u0005\u0018\u0000\u0000\u00ae\u00af\u00038\u001c\u0000"+
		"\u00af\u00b0\u0005\t\u0000\u0000\u00b0\u00b1\u0003*\u0015\u0000\u00b1"+
		"\u00b3\u0001\u0000\u0000\u0000\u00b2\u00a7\u0001\u0000\u0000\u0000\u00b2"+
		"\u00ab\u0001\u0000\u0000\u0000\u00b3%\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u00030\u0018\u0000\u00b5\u00b6\u0005\t\u0000\u0000\u00b6\u00b7\u0003"+
		"*\u0015\u0000\u00b7\'\u0001\u0000\u0000\u0000\u00b8\u00b9\u0007\u0001"+
		"\u0000\u0000\u00b9)\u0001\u0000\u0000\u0000\u00ba\u00c1\u0003(\u0014\u0000"+
		"\u00bb\u00c1\u00030\u0018\u0000\u00bc\u00bd\u0005\n\u0000\u0000\u00bd"+
		"\u00be\u0003*\u0015\u0000\u00be\u00bf\u0005\u000b\u0000\u0000\u00bf\u00c1"+
		"\u0001\u0000\u0000\u0000\u00c0\u00ba\u0001\u0000\u0000\u0000\u00c0\u00bb"+
		"\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000\u0000\u00c1+\u0001"+
		"\u0000\u0000\u0000\u00c2\u00c3\u0006\u0016\uffff\uffff\u0000\u00c3\u00d1"+
		"\u0005L\u0000\u0000\u00c4\u00c5\u0005\n\u0000\u0000\u00c5\u00c6\u0003"+
		",\u0016\u0000\u00c6\u00c7\u0005\u000b\u0000\u0000\u00c7\u00d1\u0001\u0000"+
		"\u0000\u0000\u00c8\u00c9\u0005\u0006\u0000\u0000\u00c9\u00d1\u0003,\u0016"+
		"\u0006\u00ca\u00cb\u00032\u0019\u0000\u00cb\u00ce\u0003,\u0016\u0000\u00cc"+
		"\u00cd\u00052\u0000\u0000\u00cd\u00cf\u0003,\u0016\u0000\u00ce\u00cc\u0001"+
		"\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000\u0000\u0000\u00cf\u00d1\u0001"+
		"\u0000\u0000\u0000\u00d0\u00c2\u0001\u0000\u0000\u0000\u00d0\u00c4\u0001"+
		"\u0000\u0000\u0000\u00d0\u00c8\u0001\u0000\u0000\u0000\u00d0\u00ca\u0001"+
		"\u0000\u0000\u0000\u00d1\u00e0\u0001\u0000\u0000\u0000\u00d2\u00d3\n\u0005"+
		"\u0000\u0000\u00d3\u00d4\u0005\b\u0000\u0000\u00d4\u00df\u0003,\u0016"+
		"\u0006\u00d5\u00d6\n\u0004\u0000\u0000\u00d6\u00d7\u0005\u0007\u0000\u0000"+
		"\u00d7\u00df\u0003,\u0016\u0005\u00d8\u00d9\n\u0003\u0000\u0000\u00d9"+
		"\u00da\u0005\u0006\u0000\u0000\u00da\u00df\u0003,\u0016\u0004\u00db\u00dc"+
		"\n\u0002\u0000\u0000\u00dc\u00dd\u0005\u0005\u0000\u0000\u00dd\u00df\u0003"+
		",\u0016\u0003\u00de\u00d2\u0001\u0000\u0000\u0000\u00de\u00d5\u0001\u0000"+
		"\u0000\u0000\u00de\u00d8\u0001\u0000\u0000\u0000\u00de\u00db\u0001\u0000"+
		"\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"+
		"\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1-\u0001\u0000\u0000"+
		"\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e4\u0006\u0017\uffff"+
		"\uffff\u0000\u00e4\u00f3\u0005:\u0000\u0000\u00e5\u00f3\u0005;\u0000\u0000"+
		"\u00e6\u00e7\u0005\n\u0000\u0000\u00e7\u00e8\u0003.\u0017\u0000\u00e8"+
		"\u00e9\u0005\u000b\u0000\u0000\u00e9\u00f3\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0003,\u0016\u0000\u00eb\u00ec\u0007\u0002\u0000\u0000\u00ec\u00ed"+
		"\u0003,\u0016\u0000\u00ed\u00f3\u0001\u0000\u0000\u0000\u00ee\u00ef\u0003"+
		",\u0016\u0000\u00ef\u00f0\u0007\u0003\u0000\u0000\u00f0\u00f1\u0003,\u0016"+
		"\u0000\u00f1\u00f3\u0001\u0000\u0000\u0000\u00f2\u00e3\u0001\u0000\u0000"+
		"\u0000\u00f2\u00e5\u0001\u0000\u0000\u0000\u00f2\u00e6\u0001\u0000\u0000"+
		"\u0000\u00f2\u00ea\u0001\u0000\u0000\u0000\u00f2\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f3\u00fc\u0001\u0000\u0000\u0000\u00f4\u00f5\n\u0002\u0000\u0000"+
		"\u00f5\u00f6\u0005\u001b\u0000\u0000\u00f6\u00fb\u0003.\u0017\u0003\u00f7"+
		"\u00f8\n\u0001\u0000\u0000\u00f8\u00f9\u0005\u001a\u0000\u0000\u00f9\u00fb"+
		"\u0003.\u0017\u0002\u00fa\u00f4\u0001\u0000\u0000\u0000\u00fa\u00f7\u0001"+
		"\u0000\u0000\u0000\u00fb\u00fe\u0001\u0000\u0000\u0000\u00fc\u00fa\u0001"+
		"\u0000\u0000\u0000\u00fc\u00fd\u0001\u0000\u0000\u0000\u00fd/\u0001\u0000"+
		"\u0000\u0000\u00fe\u00fc\u0001\u0000\u0000\u0000\u00ff\u0100\u0006\u0018"+
		"\uffff\uffff\u0000\u0100\u010a\u0005O\u0000\u0000\u0101\u0102\u0005\n"+
		"\u0000\u0000\u0102\u0103\u00030\u0018\u0000\u0103\u0104\u0005\u000b\u0000"+
		"\u0000\u0104\u010a\u0001\u0000\u0000\u0000\u0105\u0106\u0005\u0007\u0000"+
		"\u0000\u0106\u010a\u0003*\u0015\u0000\u0107\u0108\u0007\u0004\u0000\u0000"+
		"\u0108\u010a\u00030\u0018\u0001\u0109\u00ff\u0001\u0000\u0000\u0000\u0109"+
		"\u0101\u0001\u0000\u0000\u0000\u0109\u0105\u0001\u0000\u0000\u0000\u0109"+
		"\u0107\u0001\u0000\u0000\u0000\u010a\u0117\u0001\u0000\u0000\u0000\u010b"+
		"\u010c\n\u0005\u0000\u0000\u010c\u0116\u0003\u001a\r\u0000\u010d\u010e"+
		"\n\u0004\u0000\u0000\u010e\u010f\u0005\f\u0000\u0000\u010f\u0110\u0003"+
		"*\u0015\u0000\u0110\u0111\u0005\r\u0000\u0000\u0111\u0116\u0001\u0000"+
		"\u0000\u0000\u0112\u0113\n\u0003\u0000\u0000\u0113\u0114\u0007\u0005\u0000"+
		"\u0000\u0114\u0116\u0005O\u0000\u0000\u0115\u010b\u0001\u0000\u0000\u0000"+
		"\u0115\u010d\u0001\u0000\u0000\u0000\u0115\u0112\u0001\u0000\u0000\u0000"+
		"\u0116\u0119\u0001\u0000\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000"+
		"\u0117\u0118\u0001\u0000\u0000\u0000\u01181\u0001\u0000\u0000\u0000\u0119"+
		"\u0117\u0001\u0000\u0000\u0000\u011a\u011b\u00051\u0000\u0000\u011b\u011c"+
		"\u0005\n\u0000\u0000\u011c\u011d\u0003.\u0017\u0000\u011d\u011e\u0005"+
		"\u000b\u0000\u0000\u011e3\u0001\u0000\u0000\u0000\u011f\u0120\u0007\u0006"+
		"\u0000\u0000\u01205\u0001\u0000\u0000\u0000\u0121\u0122\u00038\u001c\u0000"+
		"\u0122\u0123\u0005\u0017\u0000\u0000\u0123\u0129\u0001\u0000\u0000\u0000"+
		"\u0124\u0125\u00038\u001c\u0000\u0125\u0126\u0005\u0017\u0000\u0000\u0126"+
		"\u0127\u00036\u001b\u0000\u0127\u0129\u0001\u0000\u0000\u0000\u0128\u0121"+
		"\u0001\u0000\u0000\u0000\u0128\u0124\u0001\u0000\u0000\u0000\u01297\u0001"+
		"\u0000\u0000\u0000\u012a\u0142\u00034\u001a\u0000\u012b\u0130\u0005O\u0000"+
		"\u0000\u012c\u012d\u0005\u0010\u0000\u0000\u012d\u012e\u0003:\u001d\u0000"+
		"\u012e\u012f\u0005\u0011\u0000\u0000\u012f\u0131\u0001\u0000\u0000\u0000"+
		"\u0130\u012c\u0001\u0000\u0000\u0000\u0130\u0131\u0001\u0000\u0000\u0000"+
		"\u0131\u0142\u0001\u0000\u0000\u0000\u0132\u0134\u0005\f\u0000\u0000\u0133"+
		"\u0135\u0003,\u0016\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0134\u0135"+
		"\u0001\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137"+
		"\u0005\r\u0000\u0000\u0137\u0142\u00038\u001c\u0000\u0138\u013a\u0005"+
		"\u0007\u0000\u0000\u0139\u013b\u0005F\u0000\u0000\u013a\u0139\u0001\u0000"+
		"\u0000\u0000\u013a\u013b\u0001\u0000\u0000\u0000\u013b\u013c\u0001\u0000"+
		"\u0000\u0000\u013c\u0142\u00038\u001c\u0000\u013d\u013e\u0005\u0015\u0000"+
		"\u0000\u013e\u0142\u00038\u001c\u0000\u013f\u0140\u0007\u0007\u0000\u0000"+
		"\u0140\u0142\u00038\u001c\u0000\u0141\u012a\u0001\u0000\u0000\u0000\u0141"+
		"\u012b\u0001\u0000\u0000\u0000\u0141\u0132\u0001\u0000\u0000\u0000\u0141"+
		"\u0138\u0001\u0000\u0000\u0000\u0141\u013d\u0001\u0000\u0000\u0000\u0141"+
		"\u013f\u0001\u0000\u0000\u0000\u01429\u0001\u0000\u0000\u0000\u0143\u0149"+
		"\u0003<\u001e\u0000\u0144\u0145\u0003<\u001e\u0000\u0145\u0146\u0005\u0017"+
		"\u0000\u0000\u0146\u0147\u0003:\u001d\u0000\u0147\u0149\u0001\u0000\u0000"+
		"\u0000\u0148\u0143\u0001\u0000\u0000\u0000\u0148\u0144\u0001\u0000\u0000"+
		"\u0000\u0149;\u0001\u0000\u0000\u0000\u014a\u014d\u0005<\u0000\u0000\u014b"+
		"\u014d\u00038\u001c\u0000\u014c\u014a\u0001\u0000\u0000\u0000\u014c\u014b"+
		"\u0001\u0000\u0000\u0000\u014d=\u0001\u0000\u0000\u0000\u014e\u0150\u0005"+
		"O\u0000\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000"+
		"\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0153\u0005\u0014"+
		"\u0000\u0000\u0152\u014f\u0001\u0000\u0000\u0000\u0152\u0153\u0001\u0000"+
		"\u0000\u0000\u0153\u0156\u0001\u0000\u0000\u0000\u0154\u0157\u0005<\u0000"+
		"\u0000\u0155\u0157\u00038\u001c\u0000\u0156\u0154\u0001\u0000\u0000\u0000"+
		"\u0156\u0155\u0001\u0000\u0000\u0000\u0157?\u0001\u0000\u0000\u0000!H"+
		"LPSYfnu|\u009a\u00a0\u00b2\u00c0\u00ce\u00d0\u00de\u00e0\u00f2\u00fa\u00fc"+
		"\u0109\u0115\u0117\u0128\u0130\u0134\u013a\u0141\u0148\u014c\u014f\u0152"+
		"\u0156";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}