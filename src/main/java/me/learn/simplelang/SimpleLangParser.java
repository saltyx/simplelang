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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, VAR=8, INT=9, 
		FLOAT=10, CHARSTRING=11, STRING=12, MUL=13, DIV=14, ADD=15, SUB=16, COMMENT=17, 
		LINE_COMMENT=18, WS=19;
	public static final int
		RULE_simpleLang = 0, RULE_block = 1, RULE_stat = 2, RULE_returnStat = 3, 
		RULE_functionCall = 4, RULE_expr = 5, RULE_calExpr = 6, RULE_functionDef = 7, 
		RULE_opMudAndDiv = 8, RULE_opAddAndSub = 9, RULE_opUnary = 10, RULE_var = 11, 
		RULE_string = 12, RULE_number = 13;
	public static final String[] ruleNames = {
		"simpleLang", "block", "stat", "returnStat", "functionCall", "expr", "calExpr", 
		"functionDef", "opMudAndDiv", "opAddAndSub", "opUnary", "var", "string", 
		"number"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "'return'", "'('", "','", "')'", "'function'", "'end'", null, 
		null, null, null, null, "'*'", "'/'", "'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, "VAR", "INT", "FLOAT", 
		"CHARSTRING", "STRING", "MUL", "DIV", "ADD", "SUB", "COMMENT", "LINE_COMMENT", 
		"WS"
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
			setState(28);
			block();
			setState(29);
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
			setState(34);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5 || _la==VAR) {
				{
				{
				setState(31);
				stat();
				}
				}
				setState(36);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__1) {
				{
				setState(37);
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
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
	 
		public StatContext() { }
		public void copyFrom(StatContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefFunctionContext extends StatContext {
		public FunctionDefContext functionDef() {
			return getRuleContext(FunctionDefContext.class,0);
		}
		public DefFunctionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitDefFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallFunctionContext extends StatContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CallFunctionContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitCallFunction(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignContext extends StatContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public AssignContext(StatContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAssign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_stat);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new AssignContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				var();
				setState(41);
				match(T__0);
				setState(42);
				expr();
				}
				break;
			case 2:
				_localctx = new CallFunctionContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(44);
				functionCall();
				}
				break;
			case 3:
				_localctx = new DefFunctionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(45);
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
			setState(48);
			match(T__1);
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(49);
				expr();
				}
				break;
			case 2:
				{
				setState(50);
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
			setState(53);
			match(VAR);
			setState(54);
			match(T__2);
			setState(55);
			expr();
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(56);
				match(T__3);
				setState(57);
				expr();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CalExprContext calExpr() {
			return getRuleContext(CalExprContext.class,0);
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
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_expr);
		try {
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				string();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				var();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				functionCall();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				calExpr(0);
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

	public static class CalExprContext extends ParserRuleContext {
		public CalExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_calExpr; }
	 
		public CalExprContext() { }
		public void copyFrom(CalExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NumberCalExprContext extends CalExprContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public NumberCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitNumberCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarCalExprContext extends CalExprContext {
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public VarCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitVarCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddOrSubCalExprContext extends CalExprContext {
		public List<CalExprContext> calExpr() {
			return getRuleContexts(CalExprContext.class);
		}
		public CalExprContext calExpr(int i) {
			return getRuleContext(CalExprContext.class,i);
		}
		public OpAddAndSubContext opAddAndSub() {
			return getRuleContext(OpAddAndSubContext.class,0);
		}
		public AddOrSubCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitAddOrSubCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketsCalExprContext extends CalExprContext {
		public CalExprContext calExpr() {
			return getRuleContext(CalExprContext.class,0);
		}
		public BracketsCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitBracketsCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FunctionCalExprContext extends CalExprContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public FunctionCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitFunctionCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MudOrDivCalExprContext extends CalExprContext {
		public List<CalExprContext> calExpr() {
			return getRuleContexts(CalExprContext.class);
		}
		public CalExprContext calExpr(int i) {
			return getRuleContext(CalExprContext.class,i);
		}
		public OpMudAndDivContext opMudAndDiv() {
			return getRuleContext(OpMudAndDivContext.class,0);
		}
		public MudOrDivCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitMudOrDivCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UnaryCalExprContext extends CalExprContext {
		public OpUnaryContext opUnary() {
			return getRuleContext(OpUnaryContext.class,0);
		}
		public CalExprContext calExpr() {
			return getRuleContext(CalExprContext.class,0);
		}
		public UnaryCalExprContext(CalExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SimpleLangVisitor ) return ((SimpleLangVisitor<? extends T>)visitor).visitUnaryCalExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CalExprContext calExpr() throws RecognitionException {
		return calExpr(0);
	}

	private CalExprContext calExpr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		CalExprContext _localctx = new CalExprContext(_ctx, _parentState);
		CalExprContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_calExpr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				{
				_localctx = new NumberCalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(72);
				number();
				}
				break;
			case 2:
				{
				_localctx = new VarCalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				var();
				}
				break;
			case 3:
				{
				_localctx = new UnaryCalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				opUnary();
				setState(75);
				calExpr(5);
				}
				break;
			case 4:
				{
				_localctx = new BracketsCalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(77);
				match(T__2);
				setState(78);
				calExpr(0);
				setState(79);
				match(T__4);
				}
				break;
			case 5:
				{
				_localctx = new FunctionCalExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				functionCall();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(94);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(92);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
					case 1:
						{
						_localctx = new AddOrSubCalExprContext(new CalExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calExpr);
						setState(84);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(85);
						opAddAndSub();
						setState(86);
						calExpr(3);
						}
						break;
					case 2:
						{
						_localctx = new MudOrDivCalExprContext(new CalExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_calExpr);
						setState(88);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(89);
						opMudAndDiv();
						setState(90);
						calExpr(2);
						}
						break;
					}
					} 
				}
				setState(96);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
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
		enterRule(_localctx, 14, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			match(T__5);
			setState(98);
			match(VAR);
			setState(99);
			match(T__2);
			setState(100);
			match(VAR);
			setState(105);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(101);
				match(T__3);
				setState(102);
				match(VAR);
				}
				}
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(108);
			match(T__4);
			setState(109);
			block();
			setState(110);
			match(T__6);
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
		enterRule(_localctx, 16, RULE_opMudAndDiv);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
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
		enterRule(_localctx, 18, RULE_opAddAndSub);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
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
		enterRule(_localctx, 20, RULE_opUnary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
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
		enterRule(_localctx, 22, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118);
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
		enterRule(_localctx, 24, RULE_string);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
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
		enterRule(_localctx, 26, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(122);
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
		case 6:
			return calExpr_sempred((CalExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean calExpr_sempred(CalExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\25\177\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3\2\3\3\7\3#\n\3\f\3\16"+
		"\3&\13\3\3\3\5\3)\n\3\3\4\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\5\5"+
		"\5\66\n\5\3\6\3\6\3\6\3\6\3\6\7\6=\n\6\f\6\16\6@\13\6\3\6\3\6\3\7\3\7"+
		"\3\7\3\7\5\7H\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\bU\n\b"+
		"\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\7\b_\n\b\f\b\16\bb\13\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\7\tj\n\t\f\t\16\tm\13\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3"+
		"\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17\2\3\16\20\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\2\6\3\2\17\20\3\2\21\22\3\2\r\16\3\2\13\f\2\u0080\2\36"+
		"\3\2\2\2\4$\3\2\2\2\6\60\3\2\2\2\b\62\3\2\2\2\n\67\3\2\2\2\fG\3\2\2\2"+
		"\16T\3\2\2\2\20c\3\2\2\2\22r\3\2\2\2\24t\3\2\2\2\26v\3\2\2\2\30x\3\2\2"+
		"\2\32z\3\2\2\2\34|\3\2\2\2\36\37\5\4\3\2\37 \7\2\2\3 \3\3\2\2\2!#\5\6"+
		"\4\2\"!\3\2\2\2#&\3\2\2\2$\"\3\2\2\2$%\3\2\2\2%(\3\2\2\2&$\3\2\2\2\')"+
		"\5\b\5\2(\'\3\2\2\2()\3\2\2\2)\5\3\2\2\2*+\5\30\r\2+,\7\3\2\2,-\5\f\7"+
		"\2-\61\3\2\2\2.\61\5\n\6\2/\61\5\20\t\2\60*\3\2\2\2\60.\3\2\2\2\60/\3"+
		"\2\2\2\61\7\3\2\2\2\62\65\7\4\2\2\63\66\5\f\7\2\64\66\5\30\r\2\65\63\3"+
		"\2\2\2\65\64\3\2\2\2\66\t\3\2\2\2\678\7\n\2\289\7\5\2\29>\5\f\7\2:;\7"+
		"\6\2\2;=\5\f\7\2<:\3\2\2\2=@\3\2\2\2><\3\2\2\2>?\3\2\2\2?A\3\2\2\2@>\3"+
		"\2\2\2AB\7\7\2\2B\13\3\2\2\2CH\5\32\16\2DH\5\30\r\2EH\5\n\6\2FH\5\16\b"+
		"\2GC\3\2\2\2GD\3\2\2\2GE\3\2\2\2GF\3\2\2\2H\r\3\2\2\2IJ\b\b\1\2JU\5\34"+
		"\17\2KU\5\30\r\2LM\5\26\f\2MN\5\16\b\7NU\3\2\2\2OP\7\5\2\2PQ\5\16\b\2"+
		"QR\7\7\2\2RU\3\2\2\2SU\5\n\6\2TI\3\2\2\2TK\3\2\2\2TL\3\2\2\2TO\3\2\2\2"+
		"TS\3\2\2\2U`\3\2\2\2VW\f\4\2\2WX\5\24\13\2XY\5\16\b\5Y_\3\2\2\2Z[\f\3"+
		"\2\2[\\\5\22\n\2\\]\5\16\b\4]_\3\2\2\2^V\3\2\2\2^Z\3\2\2\2_b\3\2\2\2`"+
		"^\3\2\2\2`a\3\2\2\2a\17\3\2\2\2b`\3\2\2\2cd\7\b\2\2de\7\n\2\2ef\7\5\2"+
		"\2fk\7\n\2\2gh\7\6\2\2hj\7\n\2\2ig\3\2\2\2jm\3\2\2\2ki\3\2\2\2kl\3\2\2"+
		"\2ln\3\2\2\2mk\3\2\2\2no\7\7\2\2op\5\4\3\2pq\7\t\2\2q\21\3\2\2\2rs\t\2"+
		"\2\2s\23\3\2\2\2tu\t\3\2\2u\25\3\2\2\2vw\t\3\2\2w\27\3\2\2\2xy\7\n\2\2"+
		"y\31\3\2\2\2z{\t\4\2\2{\33\3\2\2\2|}\t\5\2\2}\35\3\2\2\2\f$(\60\65>GT"+
		"^`k";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}