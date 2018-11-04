// Generated from D:/simplelang/src/main/java/me/learn/simplelang\SimpleLang.g4 by ANTLR 4.7
package me.learn.simplelang;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, VAR=11, INT=12, FLOAT=13, CHARSTRING=14, STRING=15, MUL=16, DIV=17, 
		ADD=18, SUB=19, COMMENT=20, LINE_COMMENT=21, WS=22;
	public static final int
		RULE_simpleLang = 0, RULE_block = 1, RULE_stat = 2, RULE_returnStat = 3, 
		RULE_functionCall = 4, RULE_expr = 5, RULE_functionDef = 6, RULE_opMudAndDiv = 7, 
		RULE_opAddAndSub = 8, RULE_opUnary = 9, RULE_var = 10, RULE_string = 11, 
		RULE_number = 12;
	public static final String[] ruleNames = {
		"simpleLang", "block", "stat", "returnStat", "functionCall", "expr", "functionDef", 
		"opMudAndDiv", "opAddAndSub", "opUnary", "var", "string", "number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'='", "'return'", "'('", "')'", "'nil'", "'false'", "'true'", 
		"'function'", "'end'", null, null, null, null, null, "'*'", "'/'", "'+'", 
		"'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, "VAR", 
		"INT", "FLOAT", "CHARSTRING", "STRING", "MUL", "DIV", "ADD", "SUB", "COMMENT", 
		"LINE_COMMENT", "WS"
	};
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
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SimpleLangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SimpleLangContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode EOF() { return getToken(SimpleLangParser.EOF, 0); }
		public SimpleLangContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleLang; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitSimpleLang(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleLangContext simpleLang() throws RecognitionException {
		SimpleLangContext _localctx = new SimpleLangContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_simpleLang);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(26);
			block();
			setState(27);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public ReturnStatContext returnStat() {
			return getRuleContext(ReturnStatContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__8 || _la==VAR) {
				{
				{
				setState(29);
				stat();
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(36);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(35);
				returnStat();
				}
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

	public static class StatContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(SimpleLangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(SimpleLangParser.VAR, i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		int _la;
		try {
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(38);
				match(VAR);
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(39);
					match(T__0);
					setState(40);
					match(VAR);
					}
					}
					setState(45);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(46);
				match(T__1);
				setState(47);
				expr(0);
				setState(52);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__0) {
					{
					{
					setState(48);
					match(T__0);
					setState(49);
					expr(0);
					}
					}
					setState(54);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(55);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(56);
				functionDef();
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

	public static class ReturnStatContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ReturnStatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStat; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatContext returnStat() throws RecognitionException {
		ReturnStatContext _localctx = new ReturnStatContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_returnStat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(T__2);
			setState(62);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(60);
				expr(0);
				}
				break;
			case 2:
				{
				setState(61);
				var();
				}
				break;
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(SimpleLangParser.VAR, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(VAR);
			setState(65);
			match(T__3);
			setState(66);
			expr(0);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(67);
				match(T__0);
				setState(68);
				expr(0);
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
			match(T__4);
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

	public static class ExprContext extends ParserRuleContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public OpUnaryContext opUnary() {
			return getRuleContext(OpUnaryContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public OpMudAndDivContext opMudAndDiv() {
			return getRuleContext(OpMudAndDivContext.class,0);
		}
		public OpAddAndSubContext opAddAndSub() {
			return getRuleContext(OpAddAndSubContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitExpr(this);
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
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(77);
				match(T__5);
				}
				break;
			case 2:
				{
				setState(78);
				match(T__6);
				}
				break;
			case 3:
				{
				setState(79);
				match(T__7);
				}
				break;
			case 4:
				{
				setState(80);
				number();
				}
				break;
			case 5:
				{
				setState(81);
				string();
				}
				break;
			case 6:
				{
				setState(82);
				var();
				}
				break;
			case 7:
				{
				setState(83);
				opUnary();
				setState(84);
				expr(5);
				}
				break;
			case 8:
				{
				setState(86);
				match(T__3);
				setState(87);
				expr(0);
				setState(88);
				match(T__4);
				}
				break;
			case 9:
				{
				setState(90);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(103);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(101);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(93);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(94);
						opMudAndDiv();
						setState(95);
						expr(3);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(98);
						opAddAndSub();
						setState(99);
						expr(2);
						}
						break;
					}
					} 
				}
				setState(105);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
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

	public static class FunctionDefContext extends ParserRuleContext {
		public List<TerminalNode> VAR() { return getTokens(SimpleLangParser.VAR); }
		public TerminalNode VAR(int i) {
			return getToken(SimpleLangParser.VAR, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(T__8);
			setState(107);
			match(VAR);
			setState(108);
			match(T__3);
			setState(109);
			match(VAR);
			setState(114);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__0) {
				{
				{
				setState(110);
				match(T__0);
				setState(111);
				match(VAR);
				}
				}
				setState(116);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			match(T__4);
			setState(118);
			block();
			setState(119);
			match(T__9);
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

	public static class OpMudAndDivContext extends ParserRuleContext {
		public OpMudAndDivContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opMudAndDiv; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOpMudAndDiv(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpMudAndDivContext opMudAndDiv() throws RecognitionException {
		OpMudAndDivContext _localctx = new OpMudAndDivContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_opMudAndDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			_la = _input.LA(1);
			if ( !(_la==MUL || _la==DIV) ) {
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

	public static class OpAddAndSubContext extends ParserRuleContext {
		public OpAddAndSubContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opAddAndSub; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOpAddAndSub(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpAddAndSubContext opAddAndSub() throws RecognitionException {
		OpAddAndSubContext _localctx = new OpAddAndSubContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_opAddAndSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
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

	public static class OpUnaryContext extends ParserRuleContext {
		public OpUnaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_opUnary; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitOpUnary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OpUnaryContext opUnary() throws RecognitionException {
		OpUnaryContext _localctx = new OpUnaryContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_opUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(SimpleLangParser.VAR, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(VAR);
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

	public static class StringContext extends ParserRuleContext {
		public TerminalNode CHARSTRING() { return getToken(SimpleLangParser.CHARSTRING, 0); }
		public TerminalNode STRING() { return getToken(SimpleLangParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129);
			_la = _input.LA(1);
			if ( !(_la==CHARSTRING || _la==STRING) ) {
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

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(SimpleLangParser.INT, 0); }
		public TerminalNode FLOAT() { return getToken(SimpleLangParser.FLOAT, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			_la = _input.LA(1);
			if ( !(_la==INT || _la==FLOAT) ) {
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\30\u0088\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\3\2\3\2\3\2\3\3\7\3!\n\3\f\3\16\3$\13"+
		"\3\3\3\5\3\'\n\3\3\4\3\4\3\4\7\4,\n\4\f\4\16\4/\13\4\3\4\3\4\3\4\3\4\7"+
		"\4\65\n\4\f\4\16\48\13\4\3\4\3\4\5\4<\n\4\3\5\3\5\3\5\5\5A\n\5\3\6\3\6"+
		"\3\6\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7^\n\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\7\7h\n\7\f\7\16\7k\13\7\3\b\3\b\3\b\3\b\3\b\3\b\7\bs\n\b\f\b\16"+
		"\bv\13\b\3\b\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16"+
		"\3\16\3\16\2\3\f\17\2\4\6\b\n\f\16\20\22\24\26\30\32\2\6\3\2\22\23\3\2"+
		"\24\25\3\2\20\21\3\2\16\17\2\u008d\2\34\3\2\2\2\4\"\3\2\2\2\6;\3\2\2\2"+
		"\b=\3\2\2\2\nB\3\2\2\2\f]\3\2\2\2\16l\3\2\2\2\20{\3\2\2\2\22}\3\2\2\2"+
		"\24\177\3\2\2\2\26\u0081\3\2\2\2\30\u0083\3\2\2\2\32\u0085\3\2\2\2\34"+
		"\35\5\4\3\2\35\36\7\2\2\3\36\3\3\2\2\2\37!\5\6\4\2 \37\3\2\2\2!$\3\2\2"+
		"\2\" \3\2\2\2\"#\3\2\2\2#&\3\2\2\2$\"\3\2\2\2%\'\5\b\5\2&%\3\2\2\2&\'"+
		"\3\2\2\2\'\5\3\2\2\2(-\7\r\2\2)*\7\3\2\2*,\7\r\2\2+)\3\2\2\2,/\3\2\2\2"+
		"-+\3\2\2\2-.\3\2\2\2.\60\3\2\2\2/-\3\2\2\2\60\61\7\4\2\2\61\66\5\f\7\2"+
		"\62\63\7\3\2\2\63\65\5\f\7\2\64\62\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66"+
		"\67\3\2\2\2\67<\3\2\2\28\66\3\2\2\29<\5\n\6\2:<\5\16\b\2;(\3\2\2\2;9\3"+
		"\2\2\2;:\3\2\2\2<\7\3\2\2\2=@\7\5\2\2>A\5\f\7\2?A\5\26\f\2@>\3\2\2\2@"+
		"?\3\2\2\2A\t\3\2\2\2BC\7\r\2\2CD\7\6\2\2DI\5\f\7\2EF\7\3\2\2FH\5\f\7\2"+
		"GE\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JL\3\2\2\2KI\3\2\2\2LM\7\7\2\2"+
		"M\13\3\2\2\2NO\b\7\1\2O^\7\b\2\2P^\7\t\2\2Q^\7\n\2\2R^\5\32\16\2S^\5\30"+
		"\r\2T^\5\26\f\2UV\5\24\13\2VW\5\f\7\7W^\3\2\2\2XY\7\6\2\2YZ\5\f\7\2Z["+
		"\7\7\2\2[^\3\2\2\2\\^\5\n\6\2]N\3\2\2\2]P\3\2\2\2]Q\3\2\2\2]R\3\2\2\2"+
		"]S\3\2\2\2]T\3\2\2\2]U\3\2\2\2]X\3\2\2\2]\\\3\2\2\2^i\3\2\2\2_`\f\4\2"+
		"\2`a\5\20\t\2ab\5\f\7\5bh\3\2\2\2cd\f\3\2\2de\5\22\n\2ef\5\f\7\4fh\3\2"+
		"\2\2g_\3\2\2\2gc\3\2\2\2hk\3\2\2\2ig\3\2\2\2ij\3\2\2\2j\r\3\2\2\2ki\3"+
		"\2\2\2lm\7\13\2\2mn\7\r\2\2no\7\6\2\2ot\7\r\2\2pq\7\3\2\2qs\7\r\2\2rp"+
		"\3\2\2\2sv\3\2\2\2tr\3\2\2\2tu\3\2\2\2uw\3\2\2\2vt\3\2\2\2wx\7\7\2\2x"+
		"y\5\4\3\2yz\7\f\2\2z\17\3\2\2\2{|\t\2\2\2|\21\3\2\2\2}~\t\3\2\2~\23\3"+
		"\2\2\2\177\u0080\t\3\2\2\u0080\25\3\2\2\2\u0081\u0082\7\r\2\2\u0082\27"+
		"\3\2\2\2\u0083\u0084\t\4\2\2\u0084\31\3\2\2\2\u0085\u0086\t\5\2\2\u0086"+
		"\33\3\2\2\2\r\"&-\66;@I]git";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}