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
public class LenguajeLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, MAS=2, MENOS=3, MULT=4, DIV=5, MOD=6, IGUAL=7, PARENTESIS_IZQ=8, 
		PARENTESIS_DER=9, PUNTOYCOMA=10, IMPRIMIR=11, MAYOR=12, MENOR=13, MAYOR_IGUAL=14, 
		MENOR_IGUAL=15, IGUALDAD=16, DIFERENTE=17, VERDADERO=18, FALSO=19, NULO=20, 
		LIT_STRING=21, LIT_RUNE=22, LIT_FLOAT=23, LIT_ENTERO=24, IDENTIFICADOR=25, 
		ESPACIOS=26, COMENTARIO=27, COMENTARIO_MULTILINEA=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "MAS", "MENOS", "MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", 
			"PARENTESIS_DER", "PUNTOYCOMA", "IMPRIMIR", "MAYOR", "MENOR", "MAYOR_IGUAL", 
			"MENOR_IGUAL", "IGUALDAD", "DIFERENTE", "VERDADERO", "FALSO", "NULO", 
			"LIT_STRING", "LIT_RUNE", "LIT_FLOAT", "LIT_ENTERO", "IDENTIFICADOR", 
			"ESPACIOS", "COMENTARIO", "COMENTARIO_MULTILINEA"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "','", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", 
			"';'", "'fmt.Println'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'true'", "'false'", "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, "MAS", "MENOS", "MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", 
			"PARENTESIS_DER", "PUNTOYCOMA", "IMPRIMIR", "MAYOR", "MENOR", "MAYOR_IGUAL", 
			"MENOR_IGUAL", "IGUALDAD", "DIFERENTE", "VERDADERO", "FALSO", "NULO", 
			"LIT_STRING", "LIT_RUNE", "LIT_FLOAT", "LIT_ENTERO", "IDENTIFICADOR", 
			"ESPACIOS", "COMENTARIO", "COMENTARIO_MULTILINEA"
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


	public LenguajeLexer(CharStream input) {
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
		"\u0004\u0000\u001c\u00bc\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001"+
		"\u0014\u0005\u0014{\b\u0014\n\u0014\f\u0014~\t\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0004"+
		"\u0016\u0087\b\u0016\u000b\u0016\f\u0016\u0088\u0001\u0016\u0001\u0016"+
		"\u0004\u0016\u008d\b\u0016\u000b\u0016\f\u0016\u008e\u0001\u0017\u0004"+
		"\u0017\u0092\b\u0017\u000b\u0017\f\u0017\u0093\u0001\u0018\u0001\u0018"+
		"\u0005\u0018\u0098\b\u0018\n\u0018\f\u0018\u009b\t\u0018\u0001\u0019\u0004"+
		"\u0019\u009e\b\u0019\u000b\u0019\f\u0019\u009f\u0001\u0019\u0001\u0019"+
		"\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u00a8\b\u001a"+
		"\n\u001a\f\u001a\u00ab\t\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0005\u001b\u00b3\b\u001b\n\u001b\f\u001b"+
		"\u00b6\t\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u00b4\u0000\u001c\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004"+
		"\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017"+
		"\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'"+
		"\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c\u0001\u0000"+
		"\u0007\u0001\u0000\"\"\u0003\u0000\n\n\r\r\'\'\u0001\u000009\u0003\u0000"+
		"AZ__az\u0004\u000009AZ__az\u0003\u0000\t\n\r\r  \u0002\u0000\n\n\r\r\u00c3"+
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
		"\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"+
		"\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"+
		"\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"+
		"\u00019\u0001\u0000\u0000\u0000\u0003;\u0001\u0000\u0000\u0000\u0005="+
		"\u0001\u0000\u0000\u0000\u0007?\u0001\u0000\u0000\u0000\tA\u0001\u0000"+
		"\u0000\u0000\u000bC\u0001\u0000\u0000\u0000\rE\u0001\u0000\u0000\u0000"+
		"\u000fG\u0001\u0000\u0000\u0000\u0011I\u0001\u0000\u0000\u0000\u0013K"+
		"\u0001\u0000\u0000\u0000\u0015M\u0001\u0000\u0000\u0000\u0017Y\u0001\u0000"+
		"\u0000\u0000\u0019[\u0001\u0000\u0000\u0000\u001b]\u0001\u0000\u0000\u0000"+
		"\u001d`\u0001\u0000\u0000\u0000\u001fc\u0001\u0000\u0000\u0000!f\u0001"+
		"\u0000\u0000\u0000#i\u0001\u0000\u0000\u0000%n\u0001\u0000\u0000\u0000"+
		"\'t\u0001\u0000\u0000\u0000)x\u0001\u0000\u0000\u0000+\u0081\u0001\u0000"+
		"\u0000\u0000-\u0086\u0001\u0000\u0000\u0000/\u0091\u0001\u0000\u0000\u0000"+
		"1\u0095\u0001\u0000\u0000\u00003\u009d\u0001\u0000\u0000\u00005\u00a3"+
		"\u0001\u0000\u0000\u00007\u00ae\u0001\u0000\u0000\u00009:\u0005,\u0000"+
		"\u0000:\u0002\u0001\u0000\u0000\u0000;<\u0005+\u0000\u0000<\u0004\u0001"+
		"\u0000\u0000\u0000=>\u0005-\u0000\u0000>\u0006\u0001\u0000\u0000\u0000"+
		"?@\u0005*\u0000\u0000@\b\u0001\u0000\u0000\u0000AB\u0005/\u0000\u0000"+
		"B\n\u0001\u0000\u0000\u0000CD\u0005%\u0000\u0000D\f\u0001\u0000\u0000"+
		"\u0000EF\u0005=\u0000\u0000F\u000e\u0001\u0000\u0000\u0000GH\u0005(\u0000"+
		"\u0000H\u0010\u0001\u0000\u0000\u0000IJ\u0005)\u0000\u0000J\u0012\u0001"+
		"\u0000\u0000\u0000KL\u0005;\u0000\u0000L\u0014\u0001\u0000\u0000\u0000"+
		"MN\u0005f\u0000\u0000NO\u0005m\u0000\u0000OP\u0005t\u0000\u0000PQ\u0005"+
		".\u0000\u0000QR\u0005P\u0000\u0000RS\u0005r\u0000\u0000ST\u0005i\u0000"+
		"\u0000TU\u0005n\u0000\u0000UV\u0005t\u0000\u0000VW\u0005l\u0000\u0000"+
		"WX\u0005n\u0000\u0000X\u0016\u0001\u0000\u0000\u0000YZ\u0005>\u0000\u0000"+
		"Z\u0018\u0001\u0000\u0000\u0000[\\\u0005<\u0000\u0000\\\u001a\u0001\u0000"+
		"\u0000\u0000]^\u0005>\u0000\u0000^_\u0005=\u0000\u0000_\u001c\u0001\u0000"+
		"\u0000\u0000`a\u0005<\u0000\u0000ab\u0005=\u0000\u0000b\u001e\u0001\u0000"+
		"\u0000\u0000cd\u0005=\u0000\u0000de\u0005=\u0000\u0000e \u0001\u0000\u0000"+
		"\u0000fg\u0005!\u0000\u0000gh\u0005=\u0000\u0000h\"\u0001\u0000\u0000"+
		"\u0000ij\u0005t\u0000\u0000jk\u0005r\u0000\u0000kl\u0005u\u0000\u0000"+
		"lm\u0005e\u0000\u0000m$\u0001\u0000\u0000\u0000no\u0005f\u0000\u0000o"+
		"p\u0005a\u0000\u0000pq\u0005l\u0000\u0000qr\u0005s\u0000\u0000rs\u0005"+
		"e\u0000\u0000s&\u0001\u0000\u0000\u0000tu\u0005n\u0000\u0000uv\u0005i"+
		"\u0000\u0000vw\u0005l\u0000\u0000w(\u0001\u0000\u0000\u0000x|\u0005\""+
		"\u0000\u0000y{\b\u0000\u0000\u0000zy\u0001\u0000\u0000\u0000{~\u0001\u0000"+
		"\u0000\u0000|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f"+
		"\u0001\u0000\u0000\u0000~|\u0001\u0000\u0000\u0000\u007f\u0080\u0005\""+
		"\u0000\u0000\u0080*\u0001\u0000\u0000\u0000\u0081\u0082\u0005\'\u0000"+
		"\u0000\u0082\u0083\b\u0001\u0000\u0000\u0083\u0084\u0005\'\u0000\u0000"+
		"\u0084,\u0001\u0000\u0000\u0000\u0085\u0087\u0007\u0002\u0000\u0000\u0086"+
		"\u0085\u0001\u0000\u0000\u0000\u0087\u0088\u0001\u0000\u0000\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0088\u0089\u0001\u0000\u0000\u0000\u0089"+
		"\u008a\u0001\u0000\u0000\u0000\u008a\u008c\u0005.\u0000\u0000\u008b\u008d"+
		"\u0007\u0002\u0000\u0000\u008c\u008b\u0001\u0000\u0000\u0000\u008d\u008e"+
		"\u0001\u0000\u0000\u0000\u008e\u008c\u0001\u0000\u0000\u0000\u008e\u008f"+
		"\u0001\u0000\u0000\u0000\u008f.\u0001\u0000\u0000\u0000\u0090\u0092\u0007"+
		"\u0002\u0000\u0000\u0091\u0090\u0001\u0000\u0000\u0000\u0092\u0093\u0001"+
		"\u0000\u0000\u0000\u0093\u0091\u0001\u0000\u0000\u0000\u0093\u0094\u0001"+
		"\u0000\u0000\u0000\u00940\u0001\u0000\u0000\u0000\u0095\u0099\u0007\u0003"+
		"\u0000\u0000\u0096\u0098\u0007\u0004\u0000\u0000\u0097\u0096\u0001\u0000"+
		"\u0000\u0000\u0098\u009b\u0001\u0000\u0000\u0000\u0099\u0097\u0001\u0000"+
		"\u0000\u0000\u0099\u009a\u0001\u0000\u0000\u0000\u009a2\u0001\u0000\u0000"+
		"\u0000\u009b\u0099\u0001\u0000\u0000\u0000\u009c\u009e\u0007\u0005\u0000"+
		"\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000\u0000"+
		"\u0000\u009f\u009d\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000"+
		"\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006\u0019\u0000"+
		"\u0000\u00a24\u0001\u0000\u0000\u0000\u00a3\u00a4\u0005/\u0000\u0000\u00a4"+
		"\u00a5\u0005/\u0000\u0000\u00a5\u00a9\u0001\u0000\u0000\u0000\u00a6\u00a8"+
		"\b\u0006\u0000\u0000\u00a7\u00a6\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001"+
		"\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00a9\u00aa\u0001"+
		"\u0000\u0000\u0000\u00aa\u00ac\u0001\u0000\u0000\u0000\u00ab\u00a9\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0006\u001a\u0000\u0000\u00ad6\u0001\u0000"+
		"\u0000\u0000\u00ae\u00af\u0005/\u0000\u0000\u00af\u00b0\u0005*\u0000\u0000"+
		"\u00b0\u00b4\u0001\u0000\u0000\u0000\u00b1\u00b3\t\u0000\u0000\u0000\u00b2"+
		"\u00b1\u0001\u0000\u0000\u0000\u00b3\u00b6\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b6\u00b4\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b8\u0005*\u0000\u0000\u00b8\u00b9\u0005/\u0000\u0000\u00b9\u00ba\u0001"+
		"\u0000\u0000\u0000\u00ba\u00bb\u0006\u001b\u0000\u0000\u00bb8\u0001\u0000"+
		"\u0000\u0000\t\u0000|\u0088\u008e\u0093\u0099\u009f\u00a9\u00b4\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}