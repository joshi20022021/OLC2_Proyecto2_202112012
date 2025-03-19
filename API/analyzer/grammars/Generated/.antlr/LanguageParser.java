// Generated from /home/joshipanda2002/Descargas/OLC2_PROYECTO1_202112012/API/analyzer/grammars/Generated/Language.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LanguageParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, MAS=9, 
		MENOS=10, MULT=11, DIV=12, MOD=13, IGUAL=14, PARENTESIS_IZQ=15, PARENTESIS_DER=16, 
		PUNTOYCOMA=17, IMPRIMIR=18, MAYOR=19, MENOR=20, MAYOR_IGUAL=21, MENOR_IGUAL=22, 
		IGUALDAD=23, DIFERENTE=24, VERDADERO=25, FALSO=26, NULO=27, LIT_STRING=28, 
		LIT_RUNE=29, LIT_FLOAT=30, LIT_ENTERO=31, IDENTIFICADOR=32, ESPACIOS=33, 
		COMENTARIO=34, COMENTARIO_MULTILINEA=35;
	public static final int
		RULE_programa = 0, RULE_funcionMain = 1, RULE_bloque = 2, RULE_sentencia = 3, 
		RULE_asignacion = 4, RULE_imprimir = 5, RULE_expresion = 6;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "funcionMain", "bloque", "sentencia", "asignacion", "imprimir", 
			"expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'{'", "'}'", "','", "'&&'", "'||'", "'!'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", "';'", "'fmt.Println'", 
			"'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'true'", "'false'", "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, "MAS", "MENOS", 
			"MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", "PARENTESIS_DER", "PUNTOYCOMA", 
			"IMPRIMIR", "MAYOR", "MENOR", "MAYOR_IGUAL", "MENOR_IGUAL", "IGUALDAD", 
			"DIFERENTE", "VERDADERO", "FALSO", "NULO", "LIT_STRING", "LIT_RUNE", 
			"LIT_FLOAT", "LIT_ENTERO", "IDENTIFICADOR", "ESPACIOS", "COMENTARIO", 
			"COMENTARIO_MULTILINEA"
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
	public String getGrammarFileName() { return "Language.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public LanguageParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramaContext extends ParserRuleContext {
		public FuncionMainContext funcionMain() {
			return getRuleContext(FuncionMainContext.class,0);
		}
		public ProgramaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programa; }
	}

	public final ProgramaContext programa() throws RecognitionException {
		ProgramaContext _localctx = new ProgramaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_programa);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(14);
			funcionMain();
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
	public static class FuncionMainContext extends ParserRuleContext {
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public FuncionMainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcionMain; }
	}

	public final FuncionMainContext funcionMain() throws RecognitionException {
		FuncionMainContext _localctx = new FuncionMainContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_funcionMain);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16);
			match(T__0);
			setState(17);
			match(T__1);
			setState(18);
			match(PARENTESIS_IZQ);
			setState(19);
			match(PARENTESIS_DER);
			setState(20);
			bloque();
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
	public static class BloqueContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BloqueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bloque; }
	}

	public final BloqueContext bloque() throws RecognitionException {
		BloqueContext _localctx = new BloqueContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(22);
			match(T__2);
			setState(26);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8556675328L) != 0)) {
				{
				{
				setState(23);
				sentencia();
				}
				}
				setState(28);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(29);
			match(T__3);
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
	public static class SentenciaContext extends ParserRuleContext {
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	 
		public SentenciaContext() { }
		public void copyFrom(SentenciaContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaImprimirContext extends SentenciaContext {
		public ImprimirContext imprimir() {
			return getRuleContext(ImprimirContext.class,0);
		}
		public TerminalNode PUNTOYCOMA() { return getToken(LanguageParser.PUNTOYCOMA, 0); }
		public SentenciaImprimirContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaAsignacionContext extends SentenciaContext {
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public TerminalNode PUNTOYCOMA() { return getToken(LanguageParser.PUNTOYCOMA, 0); }
		public SentenciaAsignacionContext(SentenciaContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaExpresionContext extends SentenciaContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PUNTOYCOMA() { return getToken(LanguageParser.PUNTOYCOMA, 0); }
		public SentenciaExpresionContext(SentenciaContext ctx) { copyFrom(ctx); }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentencia);
		try {
			setState(40);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SentenciaAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(31);
				asignacion();
				setState(32);
				match(PUNTOYCOMA);
				}
				break;
			case 2:
				_localctx = new SentenciaImprimirContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				imprimir();
				setState(35);
				match(PUNTOYCOMA);
				}
				break;
			case 3:
				_localctx = new SentenciaExpresionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(37);
				expresion(0);
				setState(38);
				match(PUNTOYCOMA);
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
	public static class AsignacionContext extends ParserRuleContext {
		public AsignacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_asignacion; }
	 
		public AsignacionContext() { }
		public void copyFrom(AsignacionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignarContext extends AsignacionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public AsignarContext(AsignacionContext ctx) { copyFrom(ctx); }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_asignacion);
		try {
			_localctx = new AsignarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(42);
			match(IDENTIFICADOR);
			setState(43);
			match(IGUAL);
			setState(44);
			expresion(0);
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
	public static class ImprimirContext extends ParserRuleContext {
		public ImprimirContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imprimir; }
	 
		public ImprimirContext() { }
		public void copyFrom(ImprimirContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ImprimeContext extends ImprimirContext {
		public TerminalNode IMPRIMIR() { return getToken(LanguageParser.IMPRIMIR, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ImprimeContext(ImprimirContext ctx) { copyFrom(ctx); }
	}

	public final ImprimirContext imprimir() throws RecognitionException {
		ImprimirContext _localctx = new ImprimirContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_imprimir);
		int _la;
		try {
			_localctx = new ImprimeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(46);
			match(IMPRIMIR);
			setState(47);
			match(PARENTESIS_IZQ);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8556413184L) != 0)) {
				{
				setState(48);
				expresion(0);
				setState(53);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__4) {
					{
					{
					setState(49);
					match(T__4);
					setState(50);
					expresion(0);
					}
					}
					setState(55);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(58);
			match(PARENTESIS_DER);
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
	public static class ExpresionContext extends ParserRuleContext {
		public ExpresionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresion; }
	 
		public ExpresionContext() { }
		public void copyFrom(ExpresionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparacionDiferenteContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode DIFERENTE() { return getToken(LanguageParser.DIFERENTE, 0); }
		public ComparacionDiferenteContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparacionIgualContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode IGUALDAD() { return getToken(LanguageParser.IGUALDAD, 0); }
		public ComparacionIgualContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public OrContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralCadenaContext extends ExpresionContext {
		public TerminalNode LIT_STRING() { return getToken(LanguageParser.LIT_STRING, 0); }
		public LiteralCadenaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParentesisContext extends ExpresionContext {
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public ParentesisContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ModuloContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MOD() { return getToken(LanguageParser.MOD, 0); }
		public ModuloContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralEnteroContext extends ExpresionContext {
		public TerminalNode LIT_ENTERO() { return getToken(LanguageParser.LIT_ENTERO, 0); }
		public LiteralEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralRuneContext extends ExpresionContext {
		public TerminalNode LIT_RUNE() { return getToken(LanguageParser.LIT_RUNE, 0); }
		public LiteralRuneContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicacionContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(LanguageParser.MULT, 0); }
		public MultiplicacionContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralVerdaderoContext extends ExpresionContext {
		public TerminalNode VERDADERO() { return getToken(LanguageParser.VERDADERO, 0); }
		public LiteralVerdaderoContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralFlotanteContext extends ExpresionContext {
		public TerminalNode LIT_FLOAT() { return getToken(LanguageParser.LIT_FLOAT, 0); }
		public LiteralFlotanteContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SumaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAS() { return getToken(LanguageParser.MAS, 0); }
		public SumaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public NotContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MenorOIgualContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MENOR_IGUAL() { return getToken(LanguageParser.MENOR_IGUAL, 0); }
		public MenorOIgualContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AndContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralNuloContext extends ExpresionContext {
		public TerminalNode NULO() { return getToken(LanguageParser.NULO, 0); }
		public LiteralNuloContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MayorOIgualContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR_IGUAL() { return getToken(LanguageParser.MAYOR_IGUAL, 0); }
		public MayorOIgualContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralFalsoContext extends ExpresionContext {
		public TerminalNode FALSO() { return getToken(LanguageParser.FALSO, 0); }
		public LiteralFalsoContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(LanguageParser.DIV, 0); }
		public DivisionContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MayorQueContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MAYOR() { return getToken(LanguageParser.MAYOR, 0); }
		public MayorQueContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentificadorContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public IdentificadorContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class RestaContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MENOS() { return getToken(LanguageParser.MENOS, 0); }
		public RestaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MenorQueContext extends ExpresionContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode MENOR() { return getToken(LanguageParser.MENOR, 0); }
		public MenorQueContext(ExpresionContext ctx) { copyFrom(ctx); }
	}

	public final ExpresionContext expresion() throws RecognitionException {
		return expresion(0);
	}

	private ExpresionContext expresion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpresionContext _localctx = new ExpresionContext(_ctx, _parentState);
		ExpresionContext _prevctx = _localctx;
		int _startState = 12;
		enterRecursionRule(_localctx, 12, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__7:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(61);
				match(T__7);
				setState(62);
				expresion(10);
				}
				break;
			case PARENTESIS_IZQ:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(63);
				match(PARENTESIS_IZQ);
				setState(64);
				expresion(0);
				setState(65);
				match(PARENTESIS_DER);
				}
				break;
			case LIT_ENTERO:
				{
				_localctx = new LiteralEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(67);
				match(LIT_ENTERO);
				}
				break;
			case LIT_FLOAT:
				{
				_localctx = new LiteralFlotanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(68);
				match(LIT_FLOAT);
				}
				break;
			case LIT_RUNE:
				{
				_localctx = new LiteralRuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(69);
				match(LIT_RUNE);
				}
				break;
			case LIT_STRING:
				{
				_localctx = new LiteralCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(70);
				match(LIT_STRING);
				}
				break;
			case VERDADERO:
				{
				_localctx = new LiteralVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(71);
				match(VERDADERO);
				}
				break;
			case FALSO:
				{
				_localctx = new LiteralFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(72);
				match(FALSO);
				}
				break;
			case NULO:
				{
				_localctx = new LiteralNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(73);
				match(NULO);
				}
				break;
			case IDENTIFICADOR:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(74);
				match(IDENTIFICADOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(118);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(116);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(77);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(78);
						match(MAS);
						setState(79);
						expresion(24);
						}
						break;
					case 2:
						{
						_localctx = new RestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(80);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(81);
						match(MENOS);
						setState(82);
						expresion(23);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(83);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(84);
						match(MULT);
						setState(85);
						expresion(22);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(86);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(87);
						match(DIV);
						setState(88);
						expresion(21);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(89);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(90);
						match(MOD);
						setState(91);
						expresion(20);
						}
						break;
					case 6:
						{
						_localctx = new ComparacionIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(92);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(93);
						match(IGUALDAD);
						setState(94);
						expresion(19);
						}
						break;
					case 7:
						{
						_localctx = new ComparacionDiferenteContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(95);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(96);
						match(DIFERENTE);
						setState(97);
						expresion(18);
						}
						break;
					case 8:
						{
						_localctx = new MayorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(98);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(99);
						match(MAYOR);
						setState(100);
						expresion(17);
						}
						break;
					case 9:
						{
						_localctx = new MenorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(101);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(102);
						match(MENOR);
						setState(103);
						expresion(16);
						}
						break;
					case 10:
						{
						_localctx = new MayorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(104);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(105);
						match(MAYOR_IGUAL);
						setState(106);
						expresion(15);
						}
						break;
					case 11:
						{
						_localctx = new MenorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(107);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(108);
						match(MENOR_IGUAL);
						setState(109);
						expresion(14);
						}
						break;
					case 12:
						{
						_localctx = new AndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(110);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(111);
						match(T__5);
						setState(112);
						expresion(13);
						}
						break;
					case 13:
						{
						_localctx = new OrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(113);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(114);
						match(T__6);
						setState(115);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(120);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 6:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 23);
		case 1:
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 21);
		case 3:
			return precpred(_ctx, 20);
		case 4:
			return precpred(_ctx, 19);
		case 5:
			return precpred(_ctx, 18);
		case 6:
			return precpred(_ctx, 17);
		case 7:
			return precpred(_ctx, 16);
		case 8:
			return precpred(_ctx, 15);
		case 9:
			return precpred(_ctx, 14);
		case 10:
			return precpred(_ctx, 13);
		case 11:
			return precpred(_ctx, 12);
		case 12:
			return precpred(_ctx, 11);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001#z\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0005\u0002\u0019\b\u0002\n\u0002\f\u0002\u001c\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003)\b"+
		"\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0005\u00054\b\u0005\n\u0005"+
		"\f\u00057\t\u0005\u0003\u00059\b\u0005\u0001\u0005\u0001\u0005\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006L\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0005\u0006u\b\u0006\n\u0006\f\u0006x\t\u0006\u0001\u0006"+
		"\u0000\u0001\f\u0007\u0000\u0002\u0004\u0006\b\n\f\u0000\u0000\u008d\u0000"+
		"\u000e\u0001\u0000\u0000\u0000\u0002\u0010\u0001\u0000\u0000\u0000\u0004"+
		"\u0016\u0001\u0000\u0000\u0000\u0006(\u0001\u0000\u0000\u0000\b*\u0001"+
		"\u0000\u0000\u0000\n.\u0001\u0000\u0000\u0000\fK\u0001\u0000\u0000\u0000"+
		"\u000e\u000f\u0003\u0002\u0001\u0000\u000f\u0001\u0001\u0000\u0000\u0000"+
		"\u0010\u0011\u0005\u0001\u0000\u0000\u0011\u0012\u0005\u0002\u0000\u0000"+
		"\u0012\u0013\u0005\u000f\u0000\u0000\u0013\u0014\u0005\u0010\u0000\u0000"+
		"\u0014\u0015\u0003\u0004\u0002\u0000\u0015\u0003\u0001\u0000\u0000\u0000"+
		"\u0016\u001a\u0005\u0003\u0000\u0000\u0017\u0019\u0003\u0006\u0003\u0000"+
		"\u0018\u0017\u0001\u0000\u0000\u0000\u0019\u001c\u0001\u0000\u0000\u0000"+
		"\u001a\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000"+
		"\u001b\u001d\u0001\u0000\u0000\u0000\u001c\u001a\u0001\u0000\u0000\u0000"+
		"\u001d\u001e\u0005\u0004\u0000\u0000\u001e\u0005\u0001\u0000\u0000\u0000"+
		"\u001f \u0003\b\u0004\u0000 !\u0005\u0011\u0000\u0000!)\u0001\u0000\u0000"+
		"\u0000\"#\u0003\n\u0005\u0000#$\u0005\u0011\u0000\u0000$)\u0001\u0000"+
		"\u0000\u0000%&\u0003\f\u0006\u0000&\'\u0005\u0011\u0000\u0000\')\u0001"+
		"\u0000\u0000\u0000(\u001f\u0001\u0000\u0000\u0000(\"\u0001\u0000\u0000"+
		"\u0000(%\u0001\u0000\u0000\u0000)\u0007\u0001\u0000\u0000\u0000*+\u0005"+
		" \u0000\u0000+,\u0005\u000e\u0000\u0000,-\u0003\f\u0006\u0000-\t\u0001"+
		"\u0000\u0000\u0000./\u0005\u0012\u0000\u0000/8\u0005\u000f\u0000\u0000"+
		"05\u0003\f\u0006\u000012\u0005\u0005\u0000\u000024\u0003\f\u0006\u0000"+
		"31\u0001\u0000\u0000\u000047\u0001\u0000\u0000\u000053\u0001\u0000\u0000"+
		"\u000056\u0001\u0000\u0000\u000069\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u000080\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u00009:\u0001"+
		"\u0000\u0000\u0000:;\u0005\u0010\u0000\u0000;\u000b\u0001\u0000\u0000"+
		"\u0000<=\u0006\u0006\uffff\uffff\u0000=>\u0005\b\u0000\u0000>L\u0003\f"+
		"\u0006\n?@\u0005\u000f\u0000\u0000@A\u0003\f\u0006\u0000AB\u0005\u0010"+
		"\u0000\u0000BL\u0001\u0000\u0000\u0000CL\u0005\u001f\u0000\u0000DL\u0005"+
		"\u001e\u0000\u0000EL\u0005\u001d\u0000\u0000FL\u0005\u001c\u0000\u0000"+
		"GL\u0005\u0019\u0000\u0000HL\u0005\u001a\u0000\u0000IL\u0005\u001b\u0000"+
		"\u0000JL\u0005 \u0000\u0000K<\u0001\u0000\u0000\u0000K?\u0001\u0000\u0000"+
		"\u0000KC\u0001\u0000\u0000\u0000KD\u0001\u0000\u0000\u0000KE\u0001\u0000"+
		"\u0000\u0000KF\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000KH\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"Lv\u0001\u0000\u0000\u0000MN\n\u0017\u0000\u0000NO\u0005\t\u0000\u0000"+
		"Ou\u0003\f\u0006\u0018PQ\n\u0016\u0000\u0000QR\u0005\n\u0000\u0000Ru\u0003"+
		"\f\u0006\u0017ST\n\u0015\u0000\u0000TU\u0005\u000b\u0000\u0000Uu\u0003"+
		"\f\u0006\u0016VW\n\u0014\u0000\u0000WX\u0005\f\u0000\u0000Xu\u0003\f\u0006"+
		"\u0015YZ\n\u0013\u0000\u0000Z[\u0005\r\u0000\u0000[u\u0003\f\u0006\u0014"+
		"\\]\n\u0012\u0000\u0000]^\u0005\u0017\u0000\u0000^u\u0003\f\u0006\u0013"+
		"_`\n\u0011\u0000\u0000`a\u0005\u0018\u0000\u0000au\u0003\f\u0006\u0012"+
		"bc\n\u0010\u0000\u0000cd\u0005\u0013\u0000\u0000du\u0003\f\u0006\u0011"+
		"ef\n\u000f\u0000\u0000fg\u0005\u0014\u0000\u0000gu\u0003\f\u0006\u0010"+
		"hi\n\u000e\u0000\u0000ij\u0005\u0015\u0000\u0000ju\u0003\f\u0006\u000f"+
		"kl\n\r\u0000\u0000lm\u0005\u0016\u0000\u0000mu\u0003\f\u0006\u000eno\n"+
		"\f\u0000\u0000op\u0005\u0006\u0000\u0000pu\u0003\f\u0006\rqr\n\u000b\u0000"+
		"\u0000rs\u0005\u0007\u0000\u0000su\u0003\f\u0006\ftM\u0001\u0000\u0000"+
		"\u0000tP\u0001\u0000\u0000\u0000tS\u0001\u0000\u0000\u0000tV\u0001\u0000"+
		"\u0000\u0000tY\u0001\u0000\u0000\u0000t\\\u0001\u0000\u0000\u0000t_\u0001"+
		"\u0000\u0000\u0000tb\u0001\u0000\u0000\u0000te\u0001\u0000\u0000\u0000"+
		"th\u0001\u0000\u0000\u0000tk\u0001\u0000\u0000\u0000tn\u0001\u0000\u0000"+
		"\u0000tq\u0001\u0000\u0000\u0000ux\u0001\u0000\u0000\u0000vt\u0001\u0000"+
		"\u0000\u0000vw\u0001\u0000\u0000\u0000w\r\u0001\u0000\u0000\u0000xv\u0001"+
		"\u0000\u0000\u0000\u0007\u001a(58Ktv";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}