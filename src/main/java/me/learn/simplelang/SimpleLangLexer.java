// Generated from D:/simplelang/src/main/java/me/learn/simplelang\SimpleLang.g4 by ANTLR 4.7
package me.learn.simplelang;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SimpleLangLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, VAR=8, INT=9, 
		FLOAT=10, CHARSTRING=11, STRING=12, MUL=13, DIV=14, ADD=15, SUB=16, COMMENT=17, 
		LINE_COMMENT=18, WS=19;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "VAR", "INT", 
		"FLOAT", "CHARSTRING", "STRING", "MUL", "DIV", "ADD", "SUB", "Digit", 
		"ExponentPart", "EscapeSequence", "COMMENT", "LINE_COMMENT", "WS"
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


	public SimpleLangLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SimpleLang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\25\u00c8\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t\3\t\7\tN\n\t\f\t\16\tQ\13\t\3\n\6\nT"+
		"\n\n\r\n\16\nU\3\13\6\13Y\n\13\r\13\16\13Z\3\13\3\13\7\13_\n\13\f\13\16"+
		"\13b\13\13\3\13\5\13e\n\13\3\13\3\13\6\13i\n\13\r\13\16\13j\3\13\5\13"+
		"n\n\13\3\13\6\13q\n\13\r\13\16\13r\3\13\3\13\5\13w\n\13\3\f\3\f\3\f\7"+
		"\f|\n\f\f\f\16\f\177\13\f\3\f\3\f\3\r\3\r\3\r\7\r\u0086\n\r\f\r\16\r\u0089"+
		"\13\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3"+
		"\23\5\23\u0099\n\23\3\23\6\23\u009c\n\23\r\23\16\23\u009d\3\24\3\24\3"+
		"\24\3\24\5\24\u00a4\n\24\3\24\5\24\u00a7\n\24\3\25\3\25\3\25\3\25\7\25"+
		"\u00ad\n\25\f\25\16\25\u00b0\13\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26"+
		"\3\26\3\26\7\26\u00bb\n\26\f\26\16\26\u00be\13\26\3\26\3\26\3\27\6\27"+
		"\u00c3\n\27\r\27\16\27\u00c4\3\27\3\27\3\u00ae\2\30\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\2%\2\'\2"+
		")\23+\24-\25\3\2\f\5\2C\\aac|\6\2\62;C\\aac|\4\2))^^\4\2$$^^\3\2\62;\4"+
		"\2GGgg\4\2--//\f\2$$))^^cdhhppttvvxx||\4\2\f\f\17\17\5\2\13\f\17\17\""+
		"\"\2\u00d9\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\3/\3\2\2\2\5\61\3\2\2\2\78\3\2\2\2"+
		"\t:\3\2\2\2\13<\3\2\2\2\r>\3\2\2\2\17G\3\2\2\2\21K\3\2\2\2\23S\3\2\2\2"+
		"\25v\3\2\2\2\27x\3\2\2\2\31\u0082\3\2\2\2\33\u008c\3\2\2\2\35\u008e\3"+
		"\2\2\2\37\u0090\3\2\2\2!\u0092\3\2\2\2#\u0094\3\2\2\2%\u0096\3\2\2\2\'"+
		"\u00a6\3\2\2\2)\u00a8\3\2\2\2+\u00b6\3\2\2\2-\u00c2\3\2\2\2/\60\7?\2\2"+
		"\60\4\3\2\2\2\61\62\7t\2\2\62\63\7g\2\2\63\64\7v\2\2\64\65\7w\2\2\65\66"+
		"\7t\2\2\66\67\7p\2\2\67\6\3\2\2\289\7*\2\29\b\3\2\2\2:;\7.\2\2;\n\3\2"+
		"\2\2<=\7+\2\2=\f\3\2\2\2>?\7h\2\2?@\7w\2\2@A\7p\2\2AB\7e\2\2BC\7v\2\2"+
		"CD\7k\2\2DE\7q\2\2EF\7p\2\2F\16\3\2\2\2GH\7g\2\2HI\7p\2\2IJ\7f\2\2J\20"+
		"\3\2\2\2KO\t\2\2\2LN\t\3\2\2ML\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P"+
		"\22\3\2\2\2QO\3\2\2\2RT\5#\22\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2V\24\3\2\2\2WY\5#\22\2XW\3\2\2\2YZ\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3"+
		"\2\2\2\\`\7\60\2\2]_\5#\22\2^]\3\2\2\2_b\3\2\2\2`^\3\2\2\2`a\3\2\2\2a"+
		"d\3\2\2\2b`\3\2\2\2ce\5%\23\2dc\3\2\2\2de\3\2\2\2ew\3\2\2\2fh\7\60\2\2"+
		"gi\5#\22\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2ln\5%\23\2"+
		"ml\3\2\2\2mn\3\2\2\2nw\3\2\2\2oq\5#\22\2po\3\2\2\2qr\3\2\2\2rp\3\2\2\2"+
		"rs\3\2\2\2st\3\2\2\2tu\5%\23\2uw\3\2\2\2vX\3\2\2\2vf\3\2\2\2vp\3\2\2\2"+
		"w\26\3\2\2\2x}\7)\2\2y|\5\'\24\2z|\n\4\2\2{y\3\2\2\2{z\3\2\2\2|\177\3"+
		"\2\2\2}{\3\2\2\2}~\3\2\2\2~\u0080\3\2\2\2\177}\3\2\2\2\u0080\u0081\7)"+
		"\2\2\u0081\30\3\2\2\2\u0082\u0087\7$\2\2\u0083\u0086\5\'\24\2\u0084\u0086"+
		"\n\5\2\2\u0085\u0083\3\2\2\2\u0085\u0084\3\2\2\2\u0086\u0089\3\2\2\2\u0087"+
		"\u0085\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008a\3\2\2\2\u0089\u0087\3\2"+
		"\2\2\u008a\u008b\7$\2\2\u008b\32\3\2\2\2\u008c\u008d\7,\2\2\u008d\34\3"+
		"\2\2\2\u008e\u008f\7\61\2\2\u008f\36\3\2\2\2\u0090\u0091\7-\2\2\u0091"+
		" \3\2\2\2\u0092\u0093\7/\2\2\u0093\"\3\2\2\2\u0094\u0095\t\6\2\2\u0095"+
		"$\3\2\2\2\u0096\u0098\t\7\2\2\u0097\u0099\t\b\2\2\u0098\u0097\3\2\2\2"+
		"\u0098\u0099\3\2\2\2\u0099\u009b\3\2\2\2\u009a\u009c\5#\22\2\u009b\u009a"+
		"\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"&\3\2\2\2\u009f\u00a0\7^\2\2\u00a0\u00a7\t\t\2\2\u00a1\u00a3\7^\2\2\u00a2"+
		"\u00a4\7\17\2\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5\3"+
		"\2\2\2\u00a5\u00a7\7\f\2\2\u00a6\u009f\3\2\2\2\u00a6\u00a1\3\2\2\2\u00a7"+
		"(\3\2\2\2\u00a8\u00a9\7\61\2\2\u00a9\u00aa\7,\2\2\u00aa\u00ae\3\2\2\2"+
		"\u00ab\u00ad\13\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00af"+
		"\3\2\2\2\u00ae\u00ac\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7,\2\2\u00b2\u00b3\7\61\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00b5\b\25"+
		"\2\2\u00b5*\3\2\2\2\u00b6\u00b7\7\61\2\2\u00b7\u00b8\7\61\2\2\u00b8\u00bc"+
		"\3\2\2\2\u00b9\u00bb\n\n\2\2\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc"+
		"\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\u00bf\3\2\2\2\u00be\u00bc\3\2"+
		"\2\2\u00bf\u00c0\b\26\2\2\u00c0,\3\2\2\2\u00c1\u00c3\t\13\2\2\u00c2\u00c1"+
		"\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5"+
		"\u00c6\3\2\2\2\u00c6\u00c7\b\27\3\2\u00c7.\3\2\2\2\27\2OUZ`djmrv{}\u0085"+
		"\u0087\u0098\u009d\u00a3\u00a6\u00ae\u00bc\u00c4\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}