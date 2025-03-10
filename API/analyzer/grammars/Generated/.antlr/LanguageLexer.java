// Generated from /home/joshipanda2002/Descargas/OLC2_PROYECTO1_202112012/API/analyzer/grammars/Generated/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class LanguageLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PLUS=1, MINUS=2, MULT=3, DIV=4, MOD=5, ASSIGN=6, LPAREN=7, RPAREN=8, SEMI=9, 
		PRINT=10, TRUE=11, FALSE=12, NIL=13, STRING_LIT=14, RUNE_LIT=15, FLOAT_LIT=16, 
		INT_LIT=17, ID=18, WS=19, COMMENT=20, MULTILINE_COMMENT=21;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PLUS", "MINUS", "MULT", "DIV", "MOD", "ASSIGN", "LPAREN", "RPAREN", 
			"SEMI", "PRINT", "TRUE", "FALSE", "NIL", "STRING_LIT", "RUNE_LIT", "FLOAT_LIT", 
			"INT_LIT", "ID", "WS", "COMMENT", "MULTILINE_COMMENT"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", "';'", 
			"'print'", "'true'", "'false'", "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PLUS", "MINUS", "MULT", "DIV", "MOD", "ASSIGN", "LPAREN", "RPAREN", 
			"SEMI", "PRINT", "TRUE", "FALSE", "NIL", "STRING_LIT", "RUNE_LIT", "FLOAT_LIT", 
			"INT_LIT", "ID", "WS", "COMMENT", "MULTILINE_COMMENT"
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


	public LanguageLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Language.g4"; }

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
		"\u0004\u0000\u0015\u0096\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0005\rU"+
		"\b\r\n\r\f\rX\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0004\u000fa\b\u000f\u000b\u000f\f\u000fb\u0001"+
		"\u000f\u0001\u000f\u0004\u000fg\b\u000f\u000b\u000f\f\u000fh\u0001\u0010"+
		"\u0004\u0010l\b\u0010\u000b\u0010\f\u0010m\u0001\u0011\u0001\u0011\u0005"+
		"\u0011r\b\u0011\n\u0011\f\u0011u\t\u0011\u0001\u0012\u0004\u0012x\b\u0012"+
		"\u000b\u0012\f\u0012y\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u0082\b\u0013\n\u0013\f\u0013\u0085"+
		"\t\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0005\u0014\u008d\b\u0014\n\u0014\f\u0014\u0090\t\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u008e\u0000\u0015"+
		"\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r"+
		"\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e"+
		"\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014)\u0015\u0001\u0000"+
		"\u0007\u0001\u0000\"\"\u0003\u0000\n\n\r\r\'\'\u0001\u000009\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u009d"+
		"\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000"+
		"\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000"+
		"\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000"+
		"\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"+
		"\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"+
		"\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"+
		"\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"+
		"\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"+
		"\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"+
		"\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"+
		"\u0001+\u0001\u0000\u0000\u0000\u0003-\u0001\u0000\u0000\u0000\u0005/"+
		"\u0001\u0000\u0000\u0000\u00071\u0001\u0000\u0000\u0000\t3\u0001\u0000"+
		"\u0000\u0000\u000b5\u0001\u0000\u0000\u0000\r7\u0001\u0000\u0000\u0000"+
		"\u000f9\u0001\u0000\u0000\u0000\u0011;\u0001\u0000\u0000\u0000\u0013="+
		"\u0001\u0000\u0000\u0000\u0015C\u0001\u0000\u0000\u0000\u0017H\u0001\u0000"+
		"\u0000\u0000\u0019N\u0001\u0000\u0000\u0000\u001bR\u0001\u0000\u0000\u0000"+
		"\u001d[\u0001\u0000\u0000\u0000\u001f`\u0001\u0000\u0000\u0000!k\u0001"+
		"\u0000\u0000\u0000#o\u0001\u0000\u0000\u0000%w\u0001\u0000\u0000\u0000"+
		"\'}\u0001\u0000\u0000\u0000)\u0088\u0001\u0000\u0000\u0000+,\u0005+\u0000"+
		"\u0000,\u0002\u0001\u0000\u0000\u0000-.\u0005-\u0000\u0000.\u0004\u0001"+
		"\u0000\u0000\u0000/0\u0005*\u0000\u00000\u0006\u0001\u0000\u0000\u0000"+
		"12\u0005/\u0000\u00002\b\u0001\u0000\u0000\u000034\u0005%\u0000\u0000"+
		"4\n\u0001\u0000\u0000\u000056\u0005=\u0000\u00006\f\u0001\u0000\u0000"+
		"\u000078\u0005(\u0000\u00008\u000e\u0001\u0000\u0000\u00009:\u0005)\u0000"+
		"\u0000:\u0010\u0001\u0000\u0000\u0000;<\u0005;\u0000\u0000<\u0012\u0001"+
		"\u0000\u0000\u0000=>\u0005p\u0000\u0000>?\u0005r\u0000\u0000?@\u0005i"+
		"\u0000\u0000@A\u0005n\u0000\u0000AB\u0005t\u0000\u0000B\u0014\u0001\u0000"+
		"\u0000\u0000CD\u0005t\u0000\u0000DE\u0005r\u0000\u0000EF\u0005u\u0000"+
		"\u0000FG\u0005e\u0000\u0000G\u0016\u0001\u0000\u0000\u0000HI\u0005f\u0000"+
		"\u0000IJ\u0005a\u0000\u0000JK\u0005l\u0000\u0000KL\u0005s\u0000\u0000"+
		"LM\u0005e\u0000\u0000M\u0018\u0001\u0000\u0000\u0000NO\u0005n\u0000\u0000"+
		"OP\u0005i\u0000\u0000PQ\u0005l\u0000\u0000Q\u001a\u0001\u0000\u0000\u0000"+
		"RV\u0005\"\u0000\u0000SU\b\u0000\u0000\u0000TS\u0001\u0000\u0000\u0000"+
		"UX\u0001\u0000\u0000\u0000VT\u0001\u0000\u0000\u0000VW\u0001\u0000\u0000"+
		"\u0000WY\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000YZ\u0005\"\u0000"+
		"\u0000Z\u001c\u0001\u0000\u0000\u0000[\\\u0005\'\u0000\u0000\\]\b\u0001"+
		"\u0000\u0000]^\u0005\'\u0000\u0000^\u001e\u0001\u0000\u0000\u0000_a\u0007"+
		"\u0002\u0000\u0000`_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"b`\u0001\u0000\u0000\u0000bc\u0001\u0000\u0000\u0000cd\u0001\u0000\u0000"+
		"\u0000df\u0005.\u0000\u0000eg\u0007\u0002\u0000\u0000fe\u0001\u0000\u0000"+
		"\u0000gh\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000i \u0001\u0000\u0000\u0000jl\u0007\u0002\u0000\u0000kj\u0001"+
		"\u0000\u0000\u0000lm\u0001\u0000\u0000\u0000mk\u0001\u0000\u0000\u0000"+
		"mn\u0001\u0000\u0000\u0000n\"\u0001\u0000\u0000\u0000os\u0007\u0003\u0000"+
		"\u0000pr\u0007\u0004\u0000\u0000qp\u0001\u0000\u0000\u0000ru\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t$\u0001"+
		"\u0000\u0000\u0000us\u0001\u0000\u0000\u0000vx\u0007\u0005\u0000\u0000"+
		"wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000yw\u0001\u0000\u0000"+
		"\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{|\u0006\u0012"+
		"\u0000\u0000|&\u0001\u0000\u0000\u0000}~\u0005/\u0000\u0000~\u007f\u0005"+
		"/\u0000\u0000\u007f\u0083\u0001\u0000\u0000\u0000\u0080\u0082\b\u0006"+
		"\u0000\u0000\u0081\u0080\u0001\u0000\u0000\u0000\u0082\u0085\u0001\u0000"+
		"\u0000\u0000\u0083\u0081\u0001\u0000\u0000\u0000\u0083\u0084\u0001\u0000"+
		"\u0000\u0000\u0084\u0086\u0001\u0000\u0000\u0000\u0085\u0083\u0001\u0000"+
		"\u0000\u0000\u0086\u0087\u0006\u0013\u0000\u0000\u0087(\u0001\u0000\u0000"+
		"\u0000\u0088\u0089\u0005/\u0000\u0000\u0089\u008a\u0005*\u0000\u0000\u008a"+
		"\u008e\u0001\u0000\u0000\u0000\u008b\u008d\t\u0000\u0000\u0000\u008c\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u0090\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008f\u0091"+
		"\u0001\u0000\u0000\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0091\u0092"+
		"\u0005*\u0000\u0000\u0092\u0093\u0005/\u0000\u0000\u0093\u0094\u0001\u0000"+
		"\u0000\u0000\u0094\u0095\u0006\u0014\u0000\u0000\u0095*\u0001\u0000\u0000"+
		"\u0000\t\u0000Vbhmsy\u0083\u008e\u0001\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}