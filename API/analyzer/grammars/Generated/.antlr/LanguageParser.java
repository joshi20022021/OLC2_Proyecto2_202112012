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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, MAS=11, MENOS=12, MULT=13, DIV=14, MOD=15, IGUAL=16, PARENTESIS_IZQ=17, 
		PARENTESIS_DER=18, PUNTOYCOMA=19, IMPRIMIR=20, MAYOR=21, MENOR=22, MAYOR_IGUAL=23, 
		MENOR_IGUAL=24, IGUALDAD=25, DIFERENTE=26, VERDADERO=27, FALSO=28, NULO=29, 
		LIT_STRING=30, LIT_RUNE=31, LIT_FLOAT=32, LIT_ENTERO=33, IDENTIFICADOR=34, 
		ESPACIOS=35, COMENTARIO=36, COMENTARIO_MULTILINEA=37;
	public static final int
		RULE_programa = 0, RULE_funcionMain = 1, RULE_bloque = 2, RULE_sentencia = 3, 
		RULE_ifStmt = 4, RULE_asignacion = 5, RULE_imprimir = 6, RULE_expresion = 7;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "funcionMain", "bloque", "sentencia", "ifStmt", "asignacion", 
			"imprimir", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'{'", "'}'", "'if'", "'else'", "','", "'&&'", 
			"'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", 
			"';'", "'fmt.Println'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'true'", "'false'", "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "MAS", 
			"MENOS", "MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", "PARENTESIS_DER", 
			"PUNTOYCOMA", "IMPRIMIR", "MAYOR", "MENOR", "MAYOR_IGUAL", "MENOR_IGUAL", 
			"IGUALDAD", "DIFERENTE", "VERDADERO", "FALSO", "NULO", "LIT_STRING", 
			"LIT_RUNE", "LIT_FLOAT", "LIT_ENTERO", "IDENTIFICADOR", "ESPACIOS", "COMENTARIO", 
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
			setState(16);
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
			setState(18);
			match(T__0);
			setState(19);
			match(T__1);
			setState(20);
			match(PARENTESIS_IZQ);
			setState(21);
			match(PARENTESIS_DER);
			setState(22);
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
			setState(24);
			match(T__2);
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34226701344L) != 0)) {
				{
				{
				setState(25);
				sentencia();
				}
				}
				setState(30);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(31);
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
	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaIfContext extends SentenciaContext {
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public SentenciaIfContext(SentenciaContext ctx) { copyFrom(ctx); }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sentencia);
		try {
			setState(43);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				_localctx = new SentenciaAsignacionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(33);
				asignacion();
				setState(34);
				match(PUNTOYCOMA);
				}
				break;
			case 2:
				_localctx = new SentenciaImprimirContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(36);
				imprimir();
				setState(37);
				match(PUNTOYCOMA);
				}
				break;
			case 3:
				_localctx = new SentenciaExpresionContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(39);
				expresion(0);
				setState(40);
				match(PUNTOYCOMA);
				}
				break;
			case 4:
				_localctx = new SentenciaIfContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(42);
				ifStmt();
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
	public static class IfStmtContext extends ParserRuleContext {
		public IfStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStmt; }
	 
		public IfStmtContext() { }
		public void copyFrom(IfStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfElseContext extends IfStmtContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<BloqueContext> bloque() {
			return getRuleContexts(BloqueContext.class);
		}
		public BloqueContext bloque(int i) {
			return getRuleContext(BloqueContext.class,i);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public IfElseContext(IfStmtContext ctx) { copyFrom(ctx); }
	}

	public final IfStmtContext ifStmt() throws RecognitionException {
		IfStmtContext _localctx = new IfStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_ifStmt);
		try {
			_localctx = new IfElseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(45);
			match(T__4);
			setState(46);
			expresion(0);
			setState(47);
			bloque();
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(48);
				match(T__5);
				setState(49);
				ifStmt();
				}
				break;
			case 2:
				{
				setState(50);
				match(T__5);
				setState(51);
				bloque();
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
		enterRule(_localctx, 10, RULE_asignacion);
		try {
			_localctx = new AsignarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			match(IDENTIFICADOR);
			setState(55);
			match(IGUAL);
			setState(56);
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
		enterRule(_localctx, 12, RULE_imprimir);
		int _la;
		try {
			_localctx = new ImprimeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(IMPRIMIR);
			setState(59);
			match(PARENTESIS_IZQ);
			setState(68);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 34225652736L) != 0)) {
				{
				setState(60);
				expresion(0);
				setState(65);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__6) {
					{
					{
					setState(61);
					match(T__6);
					setState(62);
					expresion(0);
					}
					}
					setState(67);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(70);
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
		int _startState = 14;
		enterRecursionRule(_localctx, 14, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(73);
				match(T__9);
				setState(74);
				expresion(10);
				}
				break;
			case PARENTESIS_IZQ:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(75);
				match(PARENTESIS_IZQ);
				setState(76);
				expresion(0);
				setState(77);
				match(PARENTESIS_DER);
				}
				break;
			case LIT_ENTERO:
				{
				_localctx = new LiteralEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(79);
				match(LIT_ENTERO);
				}
				break;
			case LIT_FLOAT:
				{
				_localctx = new LiteralFlotanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(80);
				match(LIT_FLOAT);
				}
				break;
			case LIT_RUNE:
				{
				_localctx = new LiteralRuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(81);
				match(LIT_RUNE);
				}
				break;
			case LIT_STRING:
				{
				_localctx = new LiteralCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(82);
				match(LIT_STRING);
				}
				break;
			case VERDADERO:
				{
				_localctx = new LiteralVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(83);
				match(VERDADERO);
				}
				break;
			case FALSO:
				{
				_localctx = new LiteralFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(84);
				match(FALSO);
				}
				break;
			case NULO:
				{
				_localctx = new LiteralNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(85);
				match(NULO);
				}
				break;
			case IDENTIFICADOR:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(86);
				match(IDENTIFICADOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(130);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(128);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
					case 1:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(89);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(90);
						match(MAS);
						setState(91);
						expresion(24);
						}
						break;
					case 2:
						{
						_localctx = new RestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(92);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(93);
						match(MENOS);
						setState(94);
						expresion(23);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(95);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(96);
						match(MULT);
						setState(97);
						expresion(22);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(98);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(99);
						match(DIV);
						setState(100);
						expresion(21);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(101);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(102);
						match(MOD);
						setState(103);
						expresion(20);
						}
						break;
					case 6:
						{
						_localctx = new ComparacionIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(104);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(105);
						match(IGUALDAD);
						setState(106);
						expresion(19);
						}
						break;
					case 7:
						{
						_localctx = new ComparacionDiferenteContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(107);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(108);
						match(DIFERENTE);
						setState(109);
						expresion(18);
						}
						break;
					case 8:
						{
						_localctx = new MayorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(110);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(111);
						match(MAYOR);
						setState(112);
						expresion(17);
						}
						break;
					case 9:
						{
						_localctx = new MenorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(113);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(114);
						match(MENOR);
						setState(115);
						expresion(16);
						}
						break;
					case 10:
						{
						_localctx = new MayorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(116);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(117);
						match(MAYOR_IGUAL);
						setState(118);
						expresion(15);
						}
						break;
					case 11:
						{
						_localctx = new MenorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(119);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(120);
						match(MENOR_IGUAL);
						setState(121);
						expresion(14);
						}
						break;
					case 12:
						{
						_localctx = new AndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(122);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(123);
						match(T__7);
						setState(124);
						expresion(13);
						}
						break;
					case 13:
						{
						_localctx = new OrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(125);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(126);
						match(T__8);
						setState(127);
						expresion(12);
						}
						break;
					}
					} 
				}
				setState(132);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		case 7:
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
		"\u0004\u0001%\u0086\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0001"+
		"\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002\u001b\b\u0002\n"+
		"\u0002\f\u0002\u001e\t\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003,\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u00045\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006@\b"+
		"\u0006\n\u0006\f\u0006C\t\u0006\u0003\u0006E\b\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007X\b\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u0081\b\u0007\n\u0007\f\u0007"+
		"\u0084\t\u0007\u0001\u0007\u0000\u0001\u000e\b\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0000\u0000\u009b\u0000\u0010\u0001\u0000\u0000\u0000\u0002"+
		"\u0012\u0001\u0000\u0000\u0000\u0004\u0018\u0001\u0000\u0000\u0000\u0006"+
		"+\u0001\u0000\u0000\u0000\b-\u0001\u0000\u0000\u0000\n6\u0001\u0000\u0000"+
		"\u0000\f:\u0001\u0000\u0000\u0000\u000eW\u0001\u0000\u0000\u0000\u0010"+
		"\u0011\u0003\u0002\u0001\u0000\u0011\u0001\u0001\u0000\u0000\u0000\u0012"+
		"\u0013\u0005\u0001\u0000\u0000\u0013\u0014\u0005\u0002\u0000\u0000\u0014"+
		"\u0015\u0005\u0011\u0000\u0000\u0015\u0016\u0005\u0012\u0000\u0000\u0016"+
		"\u0017\u0003\u0004\u0002\u0000\u0017\u0003\u0001\u0000\u0000\u0000\u0018"+
		"\u001c\u0005\u0003\u0000\u0000\u0019\u001b\u0003\u0006\u0003\u0000\u001a"+
		"\u0019\u0001\u0000\u0000\u0000\u001b\u001e\u0001\u0000\u0000\u0000\u001c"+
		"\u001a\u0001\u0000\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d"+
		"\u001f\u0001\u0000\u0000\u0000\u001e\u001c\u0001\u0000\u0000\u0000\u001f"+
		" \u0005\u0004\u0000\u0000 \u0005\u0001\u0000\u0000\u0000!\"\u0003\n\u0005"+
		"\u0000\"#\u0005\u0013\u0000\u0000#,\u0001\u0000\u0000\u0000$%\u0003\f"+
		"\u0006\u0000%&\u0005\u0013\u0000\u0000&,\u0001\u0000\u0000\u0000\'(\u0003"+
		"\u000e\u0007\u0000()\u0005\u0013\u0000\u0000),\u0001\u0000\u0000\u0000"+
		"*,\u0003\b\u0004\u0000+!\u0001\u0000\u0000\u0000+$\u0001\u0000\u0000\u0000"+
		"+\'\u0001\u0000\u0000\u0000+*\u0001\u0000\u0000\u0000,\u0007\u0001\u0000"+
		"\u0000\u0000-.\u0005\u0005\u0000\u0000./\u0003\u000e\u0007\u0000/4\u0003"+
		"\u0004\u0002\u000001\u0005\u0006\u0000\u000015\u0003\b\u0004\u000023\u0005"+
		"\u0006\u0000\u000035\u0003\u0004\u0002\u000040\u0001\u0000\u0000\u0000"+
		"42\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u00005\t\u0001\u0000\u0000"+
		"\u000067\u0005\"\u0000\u000078\u0005\u0010\u0000\u000089\u0003\u000e\u0007"+
		"\u00009\u000b\u0001\u0000\u0000\u0000:;\u0005\u0014\u0000\u0000;D\u0005"+
		"\u0011\u0000\u0000<A\u0003\u000e\u0007\u0000=>\u0005\u0007\u0000\u0000"+
		">@\u0003\u000e\u0007\u0000?=\u0001\u0000\u0000\u0000@C\u0001\u0000\u0000"+
		"\u0000A?\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BE\u0001\u0000"+
		"\u0000\u0000CA\u0001\u0000\u0000\u0000D<\u0001\u0000\u0000\u0000DE\u0001"+
		"\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000FG\u0005\u0012\u0000\u0000"+
		"G\r\u0001\u0000\u0000\u0000HI\u0006\u0007\uffff\uffff\u0000IJ\u0005\n"+
		"\u0000\u0000JX\u0003\u000e\u0007\nKL\u0005\u0011\u0000\u0000LM\u0003\u000e"+
		"\u0007\u0000MN\u0005\u0012\u0000\u0000NX\u0001\u0000\u0000\u0000OX\u0005"+
		"!\u0000\u0000PX\u0005 \u0000\u0000QX\u0005\u001f\u0000\u0000RX\u0005\u001e"+
		"\u0000\u0000SX\u0005\u001b\u0000\u0000TX\u0005\u001c\u0000\u0000UX\u0005"+
		"\u001d\u0000\u0000VX\u0005\"\u0000\u0000WH\u0001\u0000\u0000\u0000WK\u0001"+
		"\u0000\u0000\u0000WO\u0001\u0000\u0000\u0000WP\u0001\u0000\u0000\u0000"+
		"WQ\u0001\u0000\u0000\u0000WR\u0001\u0000\u0000\u0000WS\u0001\u0000\u0000"+
		"\u0000WT\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WV\u0001\u0000"+
		"\u0000\u0000X\u0082\u0001\u0000\u0000\u0000YZ\n\u0017\u0000\u0000Z[\u0005"+
		"\u000b\u0000\u0000[\u0081\u0003\u000e\u0007\u0018\\]\n\u0016\u0000\u0000"+
		"]^\u0005\f\u0000\u0000^\u0081\u0003\u000e\u0007\u0017_`\n\u0015\u0000"+
		"\u0000`a\u0005\r\u0000\u0000a\u0081\u0003\u000e\u0007\u0016bc\n\u0014"+
		"\u0000\u0000cd\u0005\u000e\u0000\u0000d\u0081\u0003\u000e\u0007\u0015"+
		"ef\n\u0013\u0000\u0000fg\u0005\u000f\u0000\u0000g\u0081\u0003\u000e\u0007"+
		"\u0014hi\n\u0012\u0000\u0000ij\u0005\u0019\u0000\u0000j\u0081\u0003\u000e"+
		"\u0007\u0013kl\n\u0011\u0000\u0000lm\u0005\u001a\u0000\u0000m\u0081\u0003"+
		"\u000e\u0007\u0012no\n\u0010\u0000\u0000op\u0005\u0015\u0000\u0000p\u0081"+
		"\u0003\u000e\u0007\u0011qr\n\u000f\u0000\u0000rs\u0005\u0016\u0000\u0000"+
		"s\u0081\u0003\u000e\u0007\u0010tu\n\u000e\u0000\u0000uv\u0005\u0017\u0000"+
		"\u0000v\u0081\u0003\u000e\u0007\u000fwx\n\r\u0000\u0000xy\u0005\u0018"+
		"\u0000\u0000y\u0081\u0003\u000e\u0007\u000ez{\n\f\u0000\u0000{|\u0005"+
		"\b\u0000\u0000|\u0081\u0003\u000e\u0007\r}~\n\u000b\u0000\u0000~\u007f"+
		"\u0005\t\u0000\u0000\u007f\u0081\u0003\u000e\u0007\f\u0080Y\u0001\u0000"+
		"\u0000\u0000\u0080\\\u0001\u0000\u0000\u0000\u0080_\u0001\u0000\u0000"+
		"\u0000\u0080b\u0001\u0000\u0000\u0000\u0080e\u0001\u0000\u0000\u0000\u0080"+
		"h\u0001\u0000\u0000\u0000\u0080k\u0001\u0000\u0000\u0000\u0080n\u0001"+
		"\u0000\u0000\u0000\u0080q\u0001\u0000\u0000\u0000\u0080t\u0001\u0000\u0000"+
		"\u0000\u0080w\u0001\u0000\u0000\u0000\u0080z\u0001\u0000\u0000\u0000\u0080"+
		"}\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000\u0082\u0080"+
		"\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000\u0083\u000f"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\b\u001c+"+
		"4ADW\u0080\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}