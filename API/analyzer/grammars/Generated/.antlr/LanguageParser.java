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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		MAS=25, MENOS=26, MULT=27, DIV=28, MOD=29, IGUAL=30, PARENTESIS_IZQ=31, 
		PARENTESIS_DER=32, L_CORCHETE=33, R_CORCHETE=34, PUNTOYCOMA=35, MAYOR=36, 
		MENOR=37, MAYOR_IGUAL=38, MENOR_IGUAL=39, IGUALDAD=40, DIFERENTE=41, VERDADERO=42, 
		FALSO=43, NULO=44, AGREGAR=45, LONGITUD=46, INDICE=47, UNIR=48, LIT_STRING=49, 
		LIT_RUNE=50, LIT_FLOAT=51, LIT_ENTERO=52, IDENTIFICADOR=53, ESPACIOS=54, 
		COMENTARIO=55, COMENTARIO_MULTILINEA=56, IMPRIMIR=57;
	public static final int
		RULE_programa = 0, RULE_funcionMain = 1, RULE_breakStmt = 2, RULE_continueStmt = 3, 
		RULE_returnStmt = 4, RULE_bloque = 5, RULE_sentencia = 6, RULE_ifStmt = 7, 
		RULE_declaracion = 8, RULE_asignacion = 9, RULE_tipo = 10, RULE_switchStmt = 11, 
		RULE_caseBlock = 12, RULE_defaultBlock = 13, RULE_forStmt = 14, RULE_contador = 15, 
		RULE_sliceLiteral = 16, RULE_listLiteral = 17, RULE_sliceElemento = 18, 
		RULE_funcionCall = 19, RULE_parametros = 20, RULE_parametro = 21, RULE_imprimir = 22, 
		RULE_declaracionStruct = 23, RULE_atributoStruct = 24, RULE_funcionStruct = 25, 
		RULE_expresionLiteralStruct = 26, RULE_atributosInicializacion = 27, RULE_expresion = 28;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "funcionMain", "breakStmt", "continueStmt", "returnStmt", 
			"bloque", "sentencia", "ifStmt", "declaracion", "asignacion", "tipo", 
			"switchStmt", "caseBlock", "defaultBlock", "forStmt", "contador", "sliceLiteral", 
			"listLiteral", "sliceElemento", "funcionCall", "parametros", "parametro", 
			"imprimir", "declaracionStruct", "atributoStruct", "funcionStruct", "expresionLiteralStruct", 
			"atributosInicializacion", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'break'", "'continue'", "'return'", "'{'", 
			"'}'", "'if'", "'else'", "'var'", "':='", "'switch'", "'case'", "':'", 
			"'default'", "'for'", "','", "'range'", "'.'", "'type'", "'struct'", 
			"'&&'", "'||'", "'!'", "'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", 
			"')'", "'['", "']'", "';'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", 
			"'true'", "'false'", "'nil'", "'append'", "'len'", "'slice.Index'", "'strings.Join'", 
			null, null, null, null, null, null, null, null, "'fmt.Println'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, "MAS", "MENOS", "MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", 
			"PARENTESIS_DER", "L_CORCHETE", "R_CORCHETE", "PUNTOYCOMA", "MAYOR", 
			"MENOR", "MAYOR_IGUAL", "MENOR_IGUAL", "IGUALDAD", "DIFERENTE", "VERDADERO", 
			"FALSO", "NULO", "AGREGAR", "LONGITUD", "INDICE", "UNIR", "LIT_STRING", 
			"LIT_RUNE", "LIT_FLOAT", "LIT_ENTERO", "IDENTIFICADOR", "ESPACIOS", "COMENTARIO", 
			"COMENTARIO_MULTILINEA", "IMPRIMIR"
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
		public List<DeclaracionStructContext> declaracionStruct() {
			return getRuleContexts(DeclaracionStructContext.class);
		}
		public DeclaracionStructContext declaracionStruct(int i) {
			return getRuleContext(DeclaracionStructContext.class,i);
		}
		public List<FuncionStructContext> funcionStruct() {
			return getRuleContexts(FuncionStructContext.class);
		}
		public FuncionStructContext funcionStruct(int i) {
			return getRuleContext(FuncionStructContext.class,i);
		}
		public List<DeclaracionContext> declaracion() {
			return getRuleContexts(DeclaracionContext.class);
		}
		public DeclaracionContext declaracion(int i) {
			return getRuleContext(DeclaracionContext.class,i);
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
			int _alt;
			setState(68);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				funcionMain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						setState(62);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case T__19:
							{
							setState(59);
							declaracionStruct();
							}
							break;
						case T__0:
							{
							setState(60);
							funcionStruct();
							}
							break;
						case T__9:
						case IDENTIFICADOR:
							{
							setState(61);
							declaracion();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(64); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(66);
				funcionMain();
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
			setState(70);
			match(T__0);
			setState(71);
			match(T__1);
			setState(72);
			match(PARENTESIS_IZQ);
			setState(73);
			match(PARENTESIS_DER);
			setState(74);
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
	public static class BreakStmtContext extends ParserRuleContext {
		public BreakStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStmt; }
	}

	public final BreakStmtContext breakStmt() throws RecognitionException {
		BreakStmtContext _localctx = new BreakStmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_breakStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(T__2);
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
	public static class ContinueStmtContext extends ParserRuleContext {
		public ContinueStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStmt; }
	}

	public final ContinueStmtContext continueStmt() throws RecognitionException {
		ContinueStmtContext _localctx = new ContinueStmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_continueStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
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
	public static class ReturnStmtContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ReturnStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStmt; }
	}

	public final ReturnStmtContext returnStmt() throws RecognitionException {
		ReturnStmtContext _localctx = new ReturnStmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_returnStmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__4);
			setState(82);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(81);
				expresion(0);
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
		enterRule(_localctx, 10, RULE_bloque);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(84);
			match(T__5);
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 162125199293093176L) != 0)) {
				{
				{
				setState(85);
				sentencia();
				}
				}
				setState(90);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(91);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SentenciaContext extends ParserRuleContext {
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public AsignacionContext asignacion() {
			return getRuleContext(AsignacionContext.class,0);
		}
		public ImprimirContext imprimir() {
			return getRuleContext(ImprimirContext.class,0);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public IfStmtContext ifStmt() {
			return getRuleContext(IfStmtContext.class,0);
		}
		public SwitchStmtContext switchStmt() {
			return getRuleContext(SwitchStmtContext.class,0);
		}
		public ForStmtContext forStmt() {
			return getRuleContext(ForStmtContext.class,0);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public ContinueStmtContext continueStmt() {
			return getRuleContext(ContinueStmtContext.class,0);
		}
		public ReturnStmtContext returnStmt() {
			return getRuleContext(ReturnStmtContext.class,0);
		}
		public TerminalNode PUNTOYCOMA() { return getToken(LanguageParser.PUNTOYCOMA, 0); }
		public SentenciaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sentencia; }
	}

	public final SentenciaContext sentencia() throws RecognitionException {
		SentenciaContext _localctx = new SentenciaContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_sentencia);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(93);
				declaracion();
				}
				break;
			case 2:
				{
				setState(94);
				asignacion();
				}
				break;
			case 3:
				{
				setState(95);
				imprimir();
				}
				break;
			case 4:
				{
				setState(96);
				expresion(0);
				}
				break;
			case 5:
				{
				setState(97);
				ifStmt();
				}
				break;
			case 6:
				{
				setState(98);
				switchStmt();
				}
				break;
			case 7:
				{
				setState(99);
				forStmt();
				}
				break;
			case 8:
				{
				setState(100);
				breakStmt();
				}
				break;
			case 9:
				{
				setState(101);
				continueStmt();
				}
				break;
			case 10:
				{
				setState(102);
				returnStmt();
				}
				break;
			}
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOYCOMA) {
				{
				setState(105);
				match(PUNTOYCOMA);
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
		enterRule(_localctx, 14, RULE_ifStmt);
		try {
			_localctx = new IfElseContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(T__7);
			setState(109);
			expresion(0);
			setState(110);
			bloque();
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(111);
				match(T__8);
				setState(112);
				ifStmt();
				}
				break;
			case 2:
				{
				setState(113);
				match(T__8);
				setState(114);
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
	public static class DeclaracionContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public DeclaracionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracion; }
	}

	public final DeclaracionContext declaracion() throws RecognitionException {
		DeclaracionContext _localctx = new DeclaracionContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_declaracion);
		int _la;
		try {
			setState(129);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(T__9);
				setState(118);
				match(IDENTIFICADOR);
				setState(120);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
				case 1:
					{
					setState(119);
					tipo();
					}
					break;
				}
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(122);
					match(IGUAL);
					setState(123);
					expresion(0);
					}
				}

				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(126);
				match(IDENTIFICADOR);
				setState(127);
				match(T__10);
				setState(128);
				expresion(0);
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
	@SuppressWarnings("CheckReturnValue")
	public static class AsignarSliceContext extends AsignacionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode L_CORCHETE() { return getToken(LanguageParser.L_CORCHETE, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode R_CORCHETE() { return getToken(LanguageParser.R_CORCHETE, 0); }
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public AsignarSliceContext(AsignacionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AsignarMatrizContext extends AsignacionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<TerminalNode> L_CORCHETE() { return getTokens(LanguageParser.L_CORCHETE); }
		public TerminalNode L_CORCHETE(int i) {
			return getToken(LanguageParser.L_CORCHETE, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> R_CORCHETE() { return getTokens(LanguageParser.R_CORCHETE); }
		public TerminalNode R_CORCHETE(int i) {
			return getToken(LanguageParser.R_CORCHETE, i);
		}
		public TerminalNode IGUAL() { return getToken(LanguageParser.IGUAL, 0); }
		public AsignarMatrizContext(AsignacionContext ctx) { copyFrom(ctx); }
	}

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asignacion);
		try {
			setState(151);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new AsignarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(131);
				match(IDENTIFICADOR);
				setState(132);
				match(IGUAL);
				setState(133);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new AsignarSliceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				match(IDENTIFICADOR);
				setState(135);
				match(L_CORCHETE);
				setState(136);
				expresion(0);
				setState(137);
				match(R_CORCHETE);
				setState(138);
				match(IGUAL);
				setState(139);
				expresion(0);
				}
				break;
			case 3:
				_localctx = new AsignarMatrizContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(141);
				match(IDENTIFICADOR);
				setState(142);
				match(L_CORCHETE);
				setState(143);
				expresion(0);
				setState(144);
				match(R_CORCHETE);
				setState(145);
				match(L_CORCHETE);
				setState(146);
				expresion(0);
				setState(147);
				match(R_CORCHETE);
				setState(148);
				match(IGUAL);
				setState(149);
				expresion(0);
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
	public static class TipoContext extends ParserRuleContext {
		public TerminalNode L_CORCHETE() { return getToken(LanguageParser.L_CORCHETE, 0); }
		public TerminalNode R_CORCHETE() { return getToken(LanguageParser.R_CORCHETE, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TipoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo; }
	}

	public final TipoContext tipo() throws RecognitionException {
		TipoContext _localctx = new TipoContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_tipo);
		try {
			setState(157);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CORCHETE:
				enterOuterAlt(_localctx, 1);
				{
				setState(153);
				match(L_CORCHETE);
				setState(154);
				match(R_CORCHETE);
				setState(155);
				tipo();
				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(156);
				match(IDENTIFICADOR);
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
	public static class SwitchStmtContext extends ParserRuleContext {
		public SwitchStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStmt; }
	 
		public SwitchStmtContext() { }
		public void copyFrom(SwitchStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SwitchContext extends SwitchStmtContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public DefaultBlockContext defaultBlock() {
			return getRuleContext(DefaultBlockContext.class,0);
		}
		public SwitchContext(SwitchStmtContext ctx) { copyFrom(ctx); }
	}

	public final SwitchStmtContext switchStmt() throws RecognitionException {
		SwitchStmtContext _localctx = new SwitchStmtContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_switchStmt);
		int _la;
		try {
			_localctx = new SwitchContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(159);
			match(T__11);
			setState(160);
			expresion(0);
			setState(161);
			match(T__5);
			setState(165);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(162);
				caseBlock();
				}
				}
				setState(167);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(168);
				defaultBlock();
				}
			}

			setState(171);
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

	@SuppressWarnings("CheckReturnValue")
	public static class CaseBlockContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_caseBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			match(T__12);
			setState(174);
			expresion(0);
			setState(175);
			match(T__13);
			setState(179);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(176);
					sentencia();
					}
					} 
				}
				setState(181);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(182);
				breakStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultBlockContext extends ParserRuleContext {
		public List<SentenciaContext> sentencia() {
			return getRuleContexts(SentenciaContext.class);
		}
		public SentenciaContext sentencia(int i) {
			return getRuleContext(SentenciaContext.class,i);
		}
		public BreakStmtContext breakStmt() {
			return getRuleContext(BreakStmtContext.class,0);
		}
		public DefaultBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBlock; }
	}

	public final DefaultBlockContext defaultBlock() throws RecognitionException {
		DefaultBlockContext _localctx = new DefaultBlockContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_defaultBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__14);
			setState(186);
			match(T__13);
			setState(190);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(187);
					sentencia();
					}
					} 
				}
				setState(192);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			setState(194);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(193);
				breakStmt();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ForStmtContext extends ParserRuleContext {
		public ForStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStmt; }
	 
		public ForStmtContext() { }
		public void copyFrom(ForStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForClasicoContext extends ForStmtContext {
		public List<TerminalNode> PUNTOYCOMA() { return getTokens(LanguageParser.PUNTOYCOMA); }
		public TerminalNode PUNTOYCOMA(int i) {
			return getToken(LanguageParser.PUNTOYCOMA, i);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public DeclaracionContext declaracion() {
			return getRuleContext(DeclaracionContext.class,0);
		}
		public List<AsignacionContext> asignacion() {
			return getRuleContexts(AsignacionContext.class);
		}
		public AsignacionContext asignacion(int i) {
			return getRuleContext(AsignacionContext.class,i);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public ContadorContext contador() {
			return getRuleContext(ContadorContext.class,0);
		}
		public ForClasicoContext(ForStmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForCondicionContext extends ForStmtContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ForCondicionContext(ForStmtContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForRangeContext extends ForStmtContext {
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(LanguageParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(LanguageParser.IDENTIFICADOR, i);
		}
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ForRangeContext(ForStmtContext ctx) { copyFrom(ctx); }
	}

	public final ForStmtContext forStmt() throws RecognitionException {
		ForStmtContext _localctx = new ForStmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_forStmt);
		int _la;
		try {
			setState(224);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				_localctx = new ForCondicionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				match(T__15);
				setState(197);
				expresion(0);
				setState(198);
				bloque();
				}
				break;
			case 2:
				_localctx = new ForClasicoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				match(T__15);
				setState(203);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
				case 1:
					{
					setState(201);
					declaracion();
					}
					break;
				case 2:
					{
					setState(202);
					asignacion();
					}
					break;
				}
				setState(205);
				match(PUNTOYCOMA);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18010011217166336L) != 0)) {
					{
					setState(206);
					expresion(0);
					}
				}

				setState(209);
				match(PUNTOYCOMA);
				setState(212);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(210);
					asignacion();
					}
					break;
				case 2:
					{
					setState(211);
					contador();
					}
					break;
				}
				setState(214);
				bloque();
				}
				break;
			case 3:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(215);
				match(T__15);
				setState(216);
				match(IDENTIFICADOR);
				setState(217);
				match(T__16);
				setState(218);
				match(IDENTIFICADOR);
				setState(219);
				match(T__10);
				setState(220);
				match(T__17);
				setState(221);
				expresion(0);
				setState(222);
				bloque();
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
	public static class ContadorContext extends ParserRuleContext {
		public ContadorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contador; }
	 
		public ContadorContext() { }
		public void copyFrom(ContadorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DecrementoContext extends ContadorContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<TerminalNode> MENOS() { return getTokens(LanguageParser.MENOS); }
		public TerminalNode MENOS(int i) {
			return getToken(LanguageParser.MENOS, i);
		}
		public DecrementoContext(ContadorContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IncrementoContext extends ContadorContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<TerminalNode> MAS() { return getTokens(LanguageParser.MAS); }
		public TerminalNode MAS(int i) {
			return getToken(LanguageParser.MAS, i);
		}
		public IncrementoContext(ContadorContext ctx) { copyFrom(ctx); }
	}

	public final ContadorContext contador() throws RecognitionException {
		ContadorContext _localctx = new ContadorContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_contador);
		try {
			setState(232);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new IncrementoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(226);
				match(IDENTIFICADOR);
				setState(227);
				match(MAS);
				setState(228);
				match(MAS);
				}
				break;
			case 2:
				_localctx = new DecrementoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(229);
				match(IDENTIFICADOR);
				setState(230);
				match(MENOS);
				setState(231);
				match(MENOS);
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
	public static class SliceLiteralContext extends ParserRuleContext {
		public TerminalNode L_CORCHETE() { return getToken(LanguageParser.L_CORCHETE, 0); }
		public TerminalNode R_CORCHETE() { return getToken(LanguageParser.R_CORCHETE, 0); }
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public List<SliceElementoContext> sliceElemento() {
			return getRuleContexts(SliceElementoContext.class);
		}
		public SliceElementoContext sliceElemento(int i) {
			return getRuleContext(SliceElementoContext.class,i);
		}
		public SliceLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceLiteral; }
	}

	public final SliceLiteralContext sliceLiteral() throws RecognitionException {
		SliceLiteralContext _localctx = new SliceLiteralContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_sliceLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			match(L_CORCHETE);
			setState(235);
			match(R_CORCHETE);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_CORCHETE || _la==IDENTIFICADOR) {
				{
				setState(236);
				tipo();
				}
			}

			setState(239);
			match(T__5);
			setState(248);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18010011217166400L) != 0)) {
				{
				setState(240);
				sliceElemento();
				setState(245);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(241);
					match(T__16);
					setState(242);
					sliceElemento();
					}
					}
					setState(247);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(250);
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

	@SuppressWarnings("CheckReturnValue")
	public static class ListLiteralContext extends ParserRuleContext {
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_listLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(252);
			match(T__5);
			setState(261);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18010011217166336L) != 0)) {
				{
				setState(253);
				expresion(0);
				setState(258);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(254);
					match(T__16);
					setState(255);
					expresion(0);
					}
					}
					setState(260);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(263);
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

	@SuppressWarnings("CheckReturnValue")
	public static class SliceElementoContext extends ParserRuleContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public SliceLiteralContext sliceLiteral() {
			return getRuleContext(SliceLiteralContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public SliceElementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceElemento; }
	}

	public final SliceElementoContext sliceElemento() throws RecognitionException {
		SliceElementoContext _localctx = new SliceElementoContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_sliceElemento);
		try {
			setState(268);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(265);
				expresion(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(266);
				sliceLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(267);
				listLiteral();
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
	public static class FuncionCallContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(LanguageParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(LanguageParser.IDENTIFICADOR, i);
		}
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public FuncionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcionCall; }
	}

	public final FuncionCallContext funcionCall() throws RecognitionException {
		FuncionCallContext _localctx = new FuncionCallContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_funcionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				{
				setState(270);
				match(IDENTIFICADOR);
				setState(271);
				match(T__18);
				}
				break;
			}
			setState(274);
			match(IDENTIFICADOR);
			setState(275);
			match(PARENTESIS_IZQ);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18010011217166336L) != 0)) {
				{
				setState(276);
				expresion(0);
				setState(281);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(277);
					match(T__16);
					setState(278);
					expresion(0);
					}
					}
					setState(283);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(286);
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
	public static class ParametrosContext extends ParserRuleContext {
		public List<ParametroContext> parametro() {
			return getRuleContexts(ParametroContext.class);
		}
		public ParametroContext parametro(int i) {
			return getRuleContext(ParametroContext.class,i);
		}
		public ParametrosContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametros; }
	}

	public final ParametrosContext parametros() throws RecognitionException {
		ParametrosContext _localctx = new ParametrosContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parametros);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			parametro();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(289);
				match(T__16);
				setState(290);
				parametro();
				}
				}
				setState(295);
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
	public static class ParametroContext extends ParserRuleContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ParametroContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametro; }
	}

	public final ParametroContext parametro() throws RecognitionException {
		ParametroContext _localctx = new ParametroContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parametro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			tipo();
			setState(297);
			match(IDENTIFICADOR);
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
		enterRule(_localctx, 44, RULE_imprimir);
		int _la;
		try {
			_localctx = new ImprimeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(IMPRIMIR);
			setState(300);
			match(PARENTESIS_IZQ);
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 18010011217166336L) != 0)) {
				{
				setState(301);
				expresion(0);
				setState(306);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(302);
					match(T__16);
					setState(303);
					expresion(0);
					}
					}
					setState(308);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(311);
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
	public static class DeclaracionStructContext extends ParserRuleContext {
		public DeclaracionStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaracionStruct; }
	 
		public DeclaracionStructContext() { }
		public void copyFrom(DeclaracionStructContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StructDeclaracionContext extends DeclaracionStructContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<AtributoStructContext> atributoStruct() {
			return getRuleContexts(AtributoStructContext.class);
		}
		public AtributoStructContext atributoStruct(int i) {
			return getRuleContext(AtributoStructContext.class,i);
		}
		public StructDeclaracionContext(DeclaracionStructContext ctx) { copyFrom(ctx); }
	}

	public final DeclaracionStructContext declaracionStruct() throws RecognitionException {
		DeclaracionStructContext _localctx = new DeclaracionStructContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_declaracionStruct);
		int _la;
		try {
			_localctx = new StructDeclaracionContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(313);
			match(T__19);
			setState(314);
			match(IDENTIFICADOR);
			setState(315);
			match(T__20);
			setState(316);
			match(T__5);
			setState(320);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==L_CORCHETE || _la==IDENTIFICADOR) {
				{
				{
				setState(317);
				atributoStruct();
				}
				}
				setState(322);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(323);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtributoStructContext extends ParserRuleContext {
		public AtributoStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributoStruct; }
	 
		public AtributoStructContext() { }
		public void copyFrom(AtributoStructContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AtributoContext extends AtributoStructContext {
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public AtributoContext(AtributoStructContext ctx) { copyFrom(ctx); }
	}

	public final AtributoStructContext atributoStruct() throws RecognitionException {
		AtributoStructContext _localctx = new AtributoStructContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_atributoStruct);
		try {
			_localctx = new AtributoContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(325);
			tipo();
			setState(326);
			match(IDENTIFICADOR);
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
	public static class FuncionStructContext extends ParserRuleContext {
		public FuncionStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funcionStruct; }
	 
		public FuncionStructContext() { }
		public void copyFrom(FuncionStructContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MetodoStructContext extends FuncionStructContext {
		public List<TerminalNode> PARENTESIS_IZQ() { return getTokens(LanguageParser.PARENTESIS_IZQ); }
		public TerminalNode PARENTESIS_IZQ(int i) {
			return getToken(LanguageParser.PARENTESIS_IZQ, i);
		}
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(LanguageParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(LanguageParser.IDENTIFICADOR, i);
		}
		public List<TerminalNode> PARENTESIS_DER() { return getTokens(LanguageParser.PARENTESIS_DER); }
		public TerminalNode PARENTESIS_DER(int i) {
			return getToken(LanguageParser.PARENTESIS_DER, i);
		}
		public BloqueContext bloque() {
			return getRuleContext(BloqueContext.class,0);
		}
		public ParametrosContext parametros() {
			return getRuleContext(ParametrosContext.class,0);
		}
		public TipoContext tipo() {
			return getRuleContext(TipoContext.class,0);
		}
		public MetodoStructContext(FuncionStructContext ctx) { copyFrom(ctx); }
	}

	public final FuncionStructContext funcionStruct() throws RecognitionException {
		FuncionStructContext _localctx = new FuncionStructContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_funcionStruct);
		int _la;
		try {
			_localctx = new MetodoStructContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(328);
			match(T__0);
			setState(329);
			match(PARENTESIS_IZQ);
			setState(330);
			match(IDENTIFICADOR);
			setState(331);
			match(IDENTIFICADOR);
			setState(332);
			match(PARENTESIS_DER);
			setState(333);
			match(IDENTIFICADOR);
			setState(334);
			match(PARENTESIS_IZQ);
			setState(336);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_CORCHETE || _la==IDENTIFICADOR) {
				{
				setState(335);
				parametros();
				}
			}

			setState(338);
			match(PARENTESIS_DER);
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_CORCHETE || _la==IDENTIFICADOR) {
				{
				setState(339);
				tipo();
				}
			}

			setState(342);
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
	public static class ExpresionLiteralStructContext extends ParserRuleContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public AtributosInicializacionContext atributosInicializacion() {
			return getRuleContext(AtributosInicializacionContext.class,0);
		}
		public ExpresionLiteralStructContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expresionLiteralStruct; }
	}

	public final ExpresionLiteralStructContext expresionLiteralStruct() throws RecognitionException {
		ExpresionLiteralStructContext _localctx = new ExpresionLiteralStructContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expresionLiteralStruct);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(344);
			match(IDENTIFICADOR);
			setState(345);
			match(T__5);
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFICADOR) {
				{
				setState(346);
				atributosInicializacion();
				}
			}

			setState(349);
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

	@SuppressWarnings("CheckReturnValue")
	public static class AtributosInicializacionContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFICADOR() { return getTokens(LanguageParser.IDENTIFICADOR); }
		public TerminalNode IDENTIFICADOR(int i) {
			return getToken(LanguageParser.IDENTIFICADOR, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public AtributosInicializacionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atributosInicializacion; }
	}

	public final AtributosInicializacionContext atributosInicializacion() throws RecognitionException {
		AtributosInicializacionContext _localctx = new AtributosInicializacionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_atributosInicializacion);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(351);
			match(IDENTIFICADOR);
			setState(352);
			match(T__13);
			setState(353);
			expresion(0);
			setState(360);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__16) {
				{
				{
				setState(354);
				match(T__16);
				setState(355);
				match(IDENTIFICADOR);
				setState(356);
				match(T__13);
				setState(357);
				expresion(0);
				}
				}
				setState(362);
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
	public static class FuncionAppendContext extends ExpresionContext {
		public TerminalNode AGREGAR() { return getToken(LanguageParser.AGREGAR, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public FuncionAppendContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralEnteroContext extends ExpresionContext {
		public TerminalNode LIT_ENTERO() { return getToken(LanguageParser.LIT_ENTERO, 0); }
		public LiteralEnteroContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class AccesoSliceContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public TerminalNode L_CORCHETE() { return getToken(LanguageParser.L_CORCHETE, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode R_CORCHETE() { return getToken(LanguageParser.R_CORCHETE, 0); }
		public AccesoSliceContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class FuncionLlamadaContext extends ExpresionContext {
		public FuncionCallContext funcionCall() {
			return getRuleContext(FuncionCallContext.class,0);
		}
		public FuncionLlamadaContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralRuneContext extends ExpresionContext {
		public TerminalNode LIT_RUNE() { return getToken(LanguageParser.LIT_RUNE, 0); }
		public LiteralRuneContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AccesoSlice2DContext extends ExpresionContext {
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public List<TerminalNode> L_CORCHETE() { return getTokens(LanguageParser.L_CORCHETE); }
		public TerminalNode L_CORCHETE(int i) {
			return getToken(LanguageParser.L_CORCHETE, i);
		}
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public List<TerminalNode> R_CORCHETE() { return getTokens(LanguageParser.R_CORCHETE); }
		public TerminalNode R_CORCHETE(int i) {
			return getToken(LanguageParser.R_CORCHETE, i);
		}
		public AccesoSlice2DContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LiteralFlotanteContext extends ExpresionContext {
		public TerminalNode LIT_FLOAT() { return getToken(LanguageParser.LIT_FLOAT, 0); }
		public LiteralFlotanteContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionJoinContext extends ExpresionContext {
		public TerminalNode UNIR() { return getToken(LanguageParser.UNIR, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public FuncionJoinContext(ExpresionContext ctx) { copyFrom(ctx); }
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
	public static class ExpresionAccesoAtributoContext extends ExpresionContext {
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
		public ExpresionAccesoAtributoContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionLenContext extends ExpresionContext {
		public TerminalNode LONGITUD() { return getToken(LanguageParser.LONGITUD, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public ExpresionContext expresion() {
			return getRuleContext(ExpresionContext.class,0);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public FuncionLenContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ExpresionStructLiteralContext extends ExpresionContext {
		public ExpresionLiteralStructContext expresionLiteralStruct() {
			return getRuleContext(ExpresionLiteralStructContext.class,0);
		}
		public ExpresionStructLiteralContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FuncionIndexContext extends ExpresionContext {
		public TerminalNode INDICE() { return getToken(LanguageParser.INDICE, 0); }
		public TerminalNode PARENTESIS_IZQ() { return getToken(LanguageParser.PARENTESIS_IZQ, 0); }
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
		}
		public TerminalNode PARENTESIS_DER() { return getToken(LanguageParser.PARENTESIS_DER, 0); }
		public FuncionIndexContext(ExpresionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SliceContext extends ExpresionContext {
		public SliceLiteralContext sliceLiteral() {
			return getRuleContext(SliceLiteralContext.class,0);
		}
		public SliceContext(ExpresionContext ctx) { copyFrom(ctx); }
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
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(420);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(364);
				match(T__23);
				setState(365);
				expresion(20);
				}
				break;
			case 2:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(366);
				match(PARENTESIS_IZQ);
				setState(367);
				expresion(0);
				setState(368);
				match(PARENTESIS_DER);
				}
				break;
			case 3:
				{
				_localctx = new SliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(370);
				sliceLiteral();
				}
				break;
			case 4:
				{
				_localctx = new AccesoSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(371);
				match(IDENTIFICADOR);
				setState(372);
				match(L_CORCHETE);
				setState(373);
				expresion(0);
				setState(374);
				match(R_CORCHETE);
				}
				break;
			case 5:
				{
				_localctx = new FuncionAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(376);
				match(AGREGAR);
				setState(377);
				match(PARENTESIS_IZQ);
				setState(378);
				expresion(0);
				setState(379);
				match(T__16);
				setState(380);
				expresion(0);
				setState(381);
				match(PARENTESIS_DER);
				}
				break;
			case 6:
				{
				_localctx = new FuncionLenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(383);
				match(LONGITUD);
				setState(384);
				match(PARENTESIS_IZQ);
				setState(385);
				expresion(0);
				setState(386);
				match(PARENTESIS_DER);
				}
				break;
			case 7:
				{
				_localctx = new FuncionIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(388);
				match(INDICE);
				setState(389);
				match(PARENTESIS_IZQ);
				setState(390);
				expresion(0);
				setState(391);
				match(T__16);
				setState(392);
				expresion(0);
				setState(393);
				match(PARENTESIS_DER);
				}
				break;
			case 8:
				{
				_localctx = new FuncionJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(395);
				match(UNIR);
				setState(396);
				match(PARENTESIS_IZQ);
				setState(397);
				expresion(0);
				setState(398);
				match(T__16);
				setState(399);
				expresion(0);
				setState(400);
				match(PARENTESIS_DER);
				}
				break;
			case 9:
				{
				_localctx = new AccesoSlice2DContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(402);
				match(IDENTIFICADOR);
				setState(403);
				match(L_CORCHETE);
				setState(404);
				expresion(0);
				setState(405);
				match(R_CORCHETE);
				setState(406);
				match(L_CORCHETE);
				setState(407);
				expresion(0);
				setState(408);
				match(R_CORCHETE);
				}
				break;
			case 10:
				{
				_localctx = new FuncionLlamadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(410);
				funcionCall();
				}
				break;
			case 11:
				{
				_localctx = new ExpresionStructLiteralContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(411);
				expresionLiteralStruct();
				}
				break;
			case 12:
				{
				_localctx = new LiteralEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(412);
				match(LIT_ENTERO);
				}
				break;
			case 13:
				{
				_localctx = new LiteralFlotanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(413);
				match(LIT_FLOAT);
				}
				break;
			case 14:
				{
				_localctx = new LiteralRuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(414);
				match(LIT_RUNE);
				}
				break;
			case 15:
				{
				_localctx = new LiteralCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(415);
				match(LIT_STRING);
				}
				break;
			case 16:
				{
				_localctx = new LiteralVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(416);
				match(VERDADERO);
				}
				break;
			case 17:
				{
				_localctx = new LiteralFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(417);
				match(FALSO);
				}
				break;
			case 18:
				{
				_localctx = new LiteralNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(418);
				match(NULO);
				}
				break;
			case 19:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(419);
				match(IDENTIFICADOR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(466);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(464);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
					case 1:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(422);
						if (!(precpred(_ctx, 33))) throw new FailedPredicateException(this, "precpred(_ctx, 33)");
						setState(423);
						match(MAS);
						setState(424);
						expresion(34);
						}
						break;
					case 2:
						{
						_localctx = new RestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(425);
						if (!(precpred(_ctx, 32))) throw new FailedPredicateException(this, "precpred(_ctx, 32)");
						setState(426);
						match(MENOS);
						setState(427);
						expresion(33);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(428);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(429);
						match(MULT);
						setState(430);
						expresion(32);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(431);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(432);
						match(DIV);
						setState(433);
						expresion(31);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(434);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(435);
						match(MOD);
						setState(436);
						expresion(30);
						}
						break;
					case 6:
						{
						_localctx = new ComparacionIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(437);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(438);
						match(IGUALDAD);
						setState(439);
						expresion(29);
						}
						break;
					case 7:
						{
						_localctx = new ComparacionDiferenteContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(440);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(441);
						match(DIFERENTE);
						setState(442);
						expresion(28);
						}
						break;
					case 8:
						{
						_localctx = new MayorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(443);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(444);
						match(MAYOR);
						setState(445);
						expresion(27);
						}
						break;
					case 9:
						{
						_localctx = new MenorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(446);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(447);
						match(MENOR);
						setState(448);
						expresion(26);
						}
						break;
					case 10:
						{
						_localctx = new MayorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(449);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(450);
						match(MAYOR_IGUAL);
						setState(451);
						expresion(25);
						}
						break;
					case 11:
						{
						_localctx = new MenorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(452);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(453);
						match(MENOR_IGUAL);
						setState(454);
						expresion(24);
						}
						break;
					case 12:
						{
						_localctx = new AndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(455);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(456);
						match(T__21);
						setState(457);
						expresion(23);
						}
						break;
					case 13:
						{
						_localctx = new OrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(458);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(459);
						match(T__22);
						setState(460);
						expresion(22);
						}
						break;
					case 14:
						{
						_localctx = new ExpresionAccesoAtributoContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(461);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(462);
						match(T__18);
						setState(463);
						match(IDENTIFICADOR);
						}
						break;
					}
					} 
				}
				setState(468);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,43,_ctx);
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
		case 28:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 33);
		case 1:
			return precpred(_ctx, 32);
		case 2:
			return precpred(_ctx, 31);
		case 3:
			return precpred(_ctx, 30);
		case 4:
			return precpred(_ctx, 29);
		case 5:
			return precpred(_ctx, 28);
		case 6:
			return precpred(_ctx, 27);
		case 7:
			return precpred(_ctx, 26);
		case 8:
			return precpred(_ctx, 25);
		case 9:
			return precpred(_ctx, 24);
		case 10:
			return precpred(_ctx, 23);
		case 11:
			return precpred(_ctx, 22);
		case 12:
			return precpred(_ctx, 21);
		case 13:
			return precpred(_ctx, 9);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00019\u01d6\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000?\b\u0000\u000b\u0000\f\u0000@\u0001\u0000\u0001\u0000\u0003"+
		"\u0000E\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0004\u0001\u0004\u0003\u0004S\b\u0004\u0001\u0005\u0001\u0005\u0005"+
		"\u0005W\b\u0005\n\u0005\f\u0005Z\t\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006h\b\u0006\u0001"+
		"\u0006\u0003\u0006k\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007t\b\u0007\u0001"+
		"\b\u0001\b\u0001\b\u0003\by\b\b\u0001\b\u0001\b\u0003\b}\b\b\u0001\b\u0001"+
		"\b\u0001\b\u0003\b\u0082\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0098\b\t\u0001\n\u0001"+
		"\n\u0001\n\u0001\n\u0003\n\u009e\b\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0005\u000b\u00a4\b\u000b\n\u000b\f\u000b\u00a7\t\u000b\u0001"+
		"\u000b\u0003\u000b\u00aa\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001"+
		"\f\u0001\f\u0001\f\u0005\f\u00b2\b\f\n\f\f\f\u00b5\t\f\u0001\f\u0003\f"+
		"\u00b8\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00bd\b\r\n\r\f\r\u00c0\t\r"+
		"\u0001\r\u0003\r\u00c3\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00cc\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0003\u000e\u00d0\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00d5\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00e1\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00e9\b\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0003\u0010\u00ee\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u00f4\b\u0010\n\u0010\f\u0010\u00f7\t\u0010\u0003"+
		"\u0010\u00f9\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u0101\b\u0011\n\u0011\f\u0011\u0104\t\u0011"+
		"\u0003\u0011\u0106\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u010d\b\u0012\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u0111\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u0118\b\u0013\n\u0013\f\u0013\u011b\t\u0013\u0003\u0013\u011d"+
		"\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0005"+
		"\u0014\u0124\b\u0014\n\u0014\f\u0014\u0127\t\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0005\u0016\u0131\b\u0016\n\u0016\f\u0016\u0134\t\u0016\u0003\u0016\u0136"+
		"\b\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0001\u0017\u0005\u0017\u013f\b\u0017\n\u0017\f\u0017\u0142\t\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0151\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u0155\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u015c\b\u001a\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0005\u001b"+
		"\u0167\b\u001b\n\u001b\f\u001b\u016a\t\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u01a5\b\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u01d1\b\u001c\n\u001c\f\u001c"+
		"\u01d4\t\u001c\u0001\u001c\u0000\u00018\u001d\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468\u0000\u0000\u0210\u0000D\u0001\u0000\u0000\u0000\u0002F\u0001\u0000"+
		"\u0000\u0000\u0004L\u0001\u0000\u0000\u0000\u0006N\u0001\u0000\u0000\u0000"+
		"\bP\u0001\u0000\u0000\u0000\nT\u0001\u0000\u0000\u0000\fg\u0001\u0000"+
		"\u0000\u0000\u000el\u0001\u0000\u0000\u0000\u0010\u0081\u0001\u0000\u0000"+
		"\u0000\u0012\u0097\u0001\u0000\u0000\u0000\u0014\u009d\u0001\u0000\u0000"+
		"\u0000\u0016\u009f\u0001\u0000\u0000\u0000\u0018\u00ad\u0001\u0000\u0000"+
		"\u0000\u001a\u00b9\u0001\u0000\u0000\u0000\u001c\u00e0\u0001\u0000\u0000"+
		"\u0000\u001e\u00e8\u0001\u0000\u0000\u0000 \u00ea\u0001\u0000\u0000\u0000"+
		"\"\u00fc\u0001\u0000\u0000\u0000$\u010c\u0001\u0000\u0000\u0000&\u0110"+
		"\u0001\u0000\u0000\u0000(\u0120\u0001\u0000\u0000\u0000*\u0128\u0001\u0000"+
		"\u0000\u0000,\u012b\u0001\u0000\u0000\u0000.\u0139\u0001\u0000\u0000\u0000"+
		"0\u0145\u0001\u0000\u0000\u00002\u0148\u0001\u0000\u0000\u00004\u0158"+
		"\u0001\u0000\u0000\u00006\u015f\u0001\u0000\u0000\u00008\u01a4\u0001\u0000"+
		"\u0000\u0000:E\u0003\u0002\u0001\u0000;?\u0003.\u0017\u0000<?\u00032\u0019"+
		"\u0000=?\u0003\u0010\b\u0000>;\u0001\u0000\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>=\u0001\u0000\u0000\u0000?@\u0001\u0000\u0000\u0000@>\u0001\u0000"+
		"\u0000\u0000@A\u0001\u0000\u0000\u0000AB\u0001\u0000\u0000\u0000BC\u0003"+
		"\u0002\u0001\u0000CE\u0001\u0000\u0000\u0000D:\u0001\u0000\u0000\u0000"+
		"D>\u0001\u0000\u0000\u0000E\u0001\u0001\u0000\u0000\u0000FG\u0005\u0001"+
		"\u0000\u0000GH\u0005\u0002\u0000\u0000HI\u0005\u001f\u0000\u0000IJ\u0005"+
		" \u0000\u0000JK\u0003\n\u0005\u0000K\u0003\u0001\u0000\u0000\u0000LM\u0005"+
		"\u0003\u0000\u0000M\u0005\u0001\u0000\u0000\u0000NO\u0005\u0004\u0000"+
		"\u0000O\u0007\u0001\u0000\u0000\u0000PR\u0005\u0005\u0000\u0000QS\u0003"+
		"8\u001c\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\t\u0001"+
		"\u0000\u0000\u0000TX\u0005\u0006\u0000\u0000UW\u0003\f\u0006\u0000VU\u0001"+
		"\u0000\u0000\u0000WZ\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XY\u0001\u0000\u0000\u0000Y[\u0001\u0000\u0000\u0000ZX\u0001\u0000\u0000"+
		"\u0000[\\\u0005\u0007\u0000\u0000\\\u000b\u0001\u0000\u0000\u0000]h\u0003"+
		"\u0010\b\u0000^h\u0003\u0012\t\u0000_h\u0003,\u0016\u0000`h\u00038\u001c"+
		"\u0000ah\u0003\u000e\u0007\u0000bh\u0003\u0016\u000b\u0000ch\u0003\u001c"+
		"\u000e\u0000dh\u0003\u0004\u0002\u0000eh\u0003\u0006\u0003\u0000fh\u0003"+
		"\b\u0004\u0000g]\u0001\u0000\u0000\u0000g^\u0001\u0000\u0000\u0000g_\u0001"+
		"\u0000\u0000\u0000g`\u0001\u0000\u0000\u0000ga\u0001\u0000\u0000\u0000"+
		"gb\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000\u0000gd\u0001\u0000\u0000"+
		"\u0000ge\u0001\u0000\u0000\u0000gf\u0001\u0000\u0000\u0000hj\u0001\u0000"+
		"\u0000\u0000ik\u0005#\u0000\u0000ji\u0001\u0000\u0000\u0000jk\u0001\u0000"+
		"\u0000\u0000k\r\u0001\u0000\u0000\u0000lm\u0005\b\u0000\u0000mn\u0003"+
		"8\u001c\u0000ns\u0003\n\u0005\u0000op\u0005\t\u0000\u0000pt\u0003\u000e"+
		"\u0007\u0000qr\u0005\t\u0000\u0000rt\u0003\n\u0005\u0000so\u0001\u0000"+
		"\u0000\u0000sq\u0001\u0000\u0000\u0000st\u0001\u0000\u0000\u0000t\u000f"+
		"\u0001\u0000\u0000\u0000uv\u0005\n\u0000\u0000vx\u00055\u0000\u0000wy"+
		"\u0003\u0014\n\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y|\u0001\u0000\u0000\u0000z{\u0005\u001e\u0000\u0000{}\u00038\u001c\u0000"+
		"|z\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u0082\u0001\u0000"+
		"\u0000\u0000~\u007f\u00055\u0000\u0000\u007f\u0080\u0005\u000b\u0000\u0000"+
		"\u0080\u0082\u00038\u001c\u0000\u0081u\u0001\u0000\u0000\u0000\u0081~"+
		"\u0001\u0000\u0000\u0000\u0082\u0011\u0001\u0000\u0000\u0000\u0083\u0084"+
		"\u00055\u0000\u0000\u0084\u0085\u0005\u001e\u0000\u0000\u0085\u0098\u0003"+
		"8\u001c\u0000\u0086\u0087\u00055\u0000\u0000\u0087\u0088\u0005!\u0000"+
		"\u0000\u0088\u0089\u00038\u001c\u0000\u0089\u008a\u0005\"\u0000\u0000"+
		"\u008a\u008b\u0005\u001e\u0000\u0000\u008b\u008c\u00038\u001c\u0000\u008c"+
		"\u0098\u0001\u0000\u0000\u0000\u008d\u008e\u00055\u0000\u0000\u008e\u008f"+
		"\u0005!\u0000\u0000\u008f\u0090\u00038\u001c\u0000\u0090\u0091\u0005\""+
		"\u0000\u0000\u0091\u0092\u0005!\u0000\u0000\u0092\u0093\u00038\u001c\u0000"+
		"\u0093\u0094\u0005\"\u0000\u0000\u0094\u0095\u0005\u001e\u0000\u0000\u0095"+
		"\u0096\u00038\u001c\u0000\u0096\u0098\u0001\u0000\u0000\u0000\u0097\u0083"+
		"\u0001\u0000\u0000\u0000\u0097\u0086\u0001\u0000\u0000\u0000\u0097\u008d"+
		"\u0001\u0000\u0000\u0000\u0098\u0013\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0005!\u0000\u0000\u009a\u009b\u0005\"\u0000\u0000\u009b\u009e\u0003"+
		"\u0014\n\u0000\u009c\u009e\u00055\u0000\u0000\u009d\u0099\u0001\u0000"+
		"\u0000\u0000\u009d\u009c\u0001\u0000\u0000\u0000\u009e\u0015\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0005\f\u0000\u0000\u00a0\u00a1\u00038\u001c"+
		"\u0000\u00a1\u00a5\u0005\u0006\u0000\u0000\u00a2\u00a4\u0003\u0018\f\u0000"+
		"\u00a3\u00a2\u0001\u0000\u0000\u0000\u00a4\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000"+
		"\u00a8\u00aa\u0003\u001a\r\u0000\u00a9\u00a8\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab"+
		"\u00ac\u0005\u0007\u0000\u0000\u00ac\u0017\u0001\u0000\u0000\u0000\u00ad"+
		"\u00ae\u0005\r\u0000\u0000\u00ae\u00af\u00038\u001c\u0000\u00af\u00b3"+
		"\u0005\u000e\u0000\u0000\u00b0\u00b2\u0003\f\u0006\u0000\u00b1\u00b0\u0001"+
		"\u0000\u0000\u0000\u00b2\u00b5\u0001\u0000\u0000\u0000\u00b3\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000\u0000\u0000\u00b4\u00b7\u0001"+
		"\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b6\u00b8\u0003"+
		"\u0004\u0002\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000\u00b7\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b8\u0019\u0001\u0000\u0000\u0000\u00b9\u00ba\u0005"+
		"\u000f\u0000\u0000\u00ba\u00be\u0005\u000e\u0000\u0000\u00bb\u00bd\u0003"+
		"\f\u0006\u0000\u00bc\u00bb\u0001\u0000\u0000\u0000\u00bd\u00c0\u0001\u0000"+
		"\u0000\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000"+
		"\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0\u00be\u0001\u0000"+
		"\u0000\u0000\u00c1\u00c3\u0003\u0004\u0002\u0000\u00c2\u00c1\u0001\u0000"+
		"\u0000\u0000\u00c2\u00c3\u0001\u0000\u0000\u0000\u00c3\u001b\u0001\u0000"+
		"\u0000\u0000\u00c4\u00c5\u0005\u0010\u0000\u0000\u00c5\u00c6\u00038\u001c"+
		"\u0000\u00c6\u00c7\u0003\n\u0005\u0000\u00c7\u00e1\u0001\u0000\u0000\u0000"+
		"\u00c8\u00cb\u0005\u0010\u0000\u0000\u00c9\u00cc\u0003\u0010\b\u0000\u00ca"+
		"\u00cc\u0003\u0012\t\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00ca"+
		"\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00cd"+
		"\u0001\u0000\u0000\u0000\u00cd\u00cf\u0005#\u0000\u0000\u00ce\u00d0\u0003"+
		"8\u001c\u0000\u00cf\u00ce\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000"+
		"\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000\u00d1\u00d4\u0005#\u0000"+
		"\u0000\u00d2\u00d5\u0003\u0012\t\u0000\u00d3\u00d5\u0003\u001e\u000f\u0000"+
		"\u00d4\u00d2\u0001\u0000\u0000\u0000\u00d4\u00d3\u0001\u0000\u0000\u0000"+
		"\u00d4\u00d5\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d6\u00e1\u0003\n\u0005\u0000\u00d7\u00d8\u0005\u0010\u0000\u0000\u00d8"+
		"\u00d9\u00055\u0000\u0000\u00d9\u00da\u0005\u0011\u0000\u0000\u00da\u00db"+
		"\u00055\u0000\u0000\u00db\u00dc\u0005\u000b\u0000\u0000\u00dc\u00dd\u0005"+
		"\u0012\u0000\u0000\u00dd\u00de\u00038\u001c\u0000\u00de\u00df\u0003\n"+
		"\u0005\u0000\u00df\u00e1\u0001\u0000\u0000\u0000\u00e0\u00c4\u0001\u0000"+
		"\u0000\u0000\u00e0\u00c8\u0001\u0000\u0000\u0000\u00e0\u00d7\u0001\u0000"+
		"\u0000\u0000\u00e1\u001d\u0001\u0000\u0000\u0000\u00e2\u00e3\u00055\u0000"+
		"\u0000\u00e3\u00e4\u0005\u0019\u0000\u0000\u00e4\u00e9\u0005\u0019\u0000"+
		"\u0000\u00e5\u00e6\u00055\u0000\u0000\u00e6\u00e7\u0005\u001a\u0000\u0000"+
		"\u00e7\u00e9\u0005\u001a\u0000\u0000\u00e8\u00e2\u0001\u0000\u0000\u0000"+
		"\u00e8\u00e5\u0001\u0000\u0000\u0000\u00e9\u001f\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0005!\u0000\u0000\u00eb\u00ed\u0005\"\u0000\u0000\u00ec"+
		"\u00ee\u0003\u0014\n\u0000\u00ed\u00ec\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f8"+
		"\u0005\u0006\u0000\u0000\u00f0\u00f5\u0003$\u0012\u0000\u00f1\u00f2\u0005"+
		"\u0011\u0000\u0000\u00f2\u00f4\u0003$\u0012\u0000\u00f3\u00f1\u0001\u0000"+
		"\u0000\u0000\u00f4\u00f7\u0001\u0000\u0000\u0000\u00f5\u00f3\u0001\u0000"+
		"\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f8\u00f0\u0001\u0000"+
		"\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000"+
		"\u0000\u0000\u00fa\u00fb\u0005\u0007\u0000\u0000\u00fb!\u0001\u0000\u0000"+
		"\u0000\u00fc\u0105\u0005\u0006\u0000\u0000\u00fd\u0102\u00038\u001c\u0000"+
		"\u00fe\u00ff\u0005\u0011\u0000\u0000\u00ff\u0101\u00038\u001c\u0000\u0100"+
		"\u00fe\u0001\u0000\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102"+
		"\u0100\u0001\u0000\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103"+
		"\u0106\u0001\u0000\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105"+
		"\u00fd\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106"+
		"\u0107\u0001\u0000\u0000\u0000\u0107\u0108\u0005\u0007\u0000\u0000\u0108"+
		"#\u0001\u0000\u0000\u0000\u0109\u010d\u00038\u001c\u0000\u010a\u010d\u0003"+
		" \u0010\u0000\u010b\u010d\u0003\"\u0011\u0000\u010c\u0109\u0001\u0000"+
		"\u0000\u0000\u010c\u010a\u0001\u0000\u0000\u0000\u010c\u010b\u0001\u0000"+
		"\u0000\u0000\u010d%\u0001\u0000\u0000\u0000\u010e\u010f\u00055\u0000\u0000"+
		"\u010f\u0111\u0005\u0013\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000"+
		"\u0110\u0111\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112\u0113\u00055\u0000\u0000\u0113\u011c\u0005\u001f\u0000\u0000\u0114"+
		"\u0119\u00038\u001c\u0000\u0115\u0116\u0005\u0011\u0000\u0000\u0116\u0118"+
		"\u00038\u001c\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0118\u011b\u0001"+
		"\u0000\u0000\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119\u011a\u0001"+
		"\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b\u0119\u0001"+
		"\u0000\u0000\u0000\u011c\u0114\u0001\u0000\u0000\u0000\u011c\u011d\u0001"+
		"\u0000\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0005"+
		" \u0000\u0000\u011f\'\u0001\u0000\u0000\u0000\u0120\u0125\u0003*\u0015"+
		"\u0000\u0121\u0122\u0005\u0011\u0000\u0000\u0122\u0124\u0003*\u0015\u0000"+
		"\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000"+
		"\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000"+
		"\u0126)\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000\u0128"+
		"\u0129\u0003\u0014\n\u0000\u0129\u012a\u00055\u0000\u0000\u012a+\u0001"+
		"\u0000\u0000\u0000\u012b\u012c\u00059\u0000\u0000\u012c\u0135\u0005\u001f"+
		"\u0000\u0000\u012d\u0132\u00038\u001c\u0000\u012e\u012f\u0005\u0011\u0000"+
		"\u0000\u012f\u0131\u00038\u001c\u0000\u0130\u012e\u0001\u0000\u0000\u0000"+
		"\u0131\u0134\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000"+
		"\u0132\u0133\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000"+
		"\u0134\u0132\u0001\u0000\u0000\u0000\u0135\u012d\u0001\u0000\u0000\u0000"+
		"\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0137\u0001\u0000\u0000\u0000"+
		"\u0137\u0138\u0005 \u0000\u0000\u0138-\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u0005\u0014\u0000\u0000\u013a\u013b\u00055\u0000\u0000\u013b\u013c\u0005"+
		"\u0015\u0000\u0000\u013c\u0140\u0005\u0006\u0000\u0000\u013d\u013f\u0003"+
		"0\u0018\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f\u0142\u0001\u0000"+
		"\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140\u0141\u0001\u0000"+
		"\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000"+
		"\u0000\u0000\u0143\u0144\u0005\u0007\u0000\u0000\u0144/\u0001\u0000\u0000"+
		"\u0000\u0145\u0146\u0003\u0014\n\u0000\u0146\u0147\u00055\u0000\u0000"+
		"\u01471\u0001\u0000\u0000\u0000\u0148\u0149\u0005\u0001\u0000\u0000\u0149"+
		"\u014a\u0005\u001f\u0000\u0000\u014a\u014b\u00055\u0000\u0000\u014b\u014c"+
		"\u00055\u0000\u0000\u014c\u014d\u0005 \u0000\u0000\u014d\u014e\u00055"+
		"\u0000\u0000\u014e\u0150\u0005\u001f\u0000\u0000\u014f\u0151\u0003(\u0014"+
		"\u0000\u0150\u014f\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000"+
		"\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0152\u0154\u0005 \u0000\u0000"+
		"\u0153\u0155\u0003\u0014\n\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0154"+
		"\u0155\u0001\u0000\u0000\u0000\u0155\u0156\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0003\n\u0005\u0000\u01573\u0001\u0000\u0000\u0000\u0158\u0159"+
		"\u00055\u0000\u0000\u0159\u015b\u0005\u0006\u0000\u0000\u015a\u015c\u0003"+
		"6\u001b\u0000\u015b\u015a\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000"+
		"\u0000\u0000\u015c\u015d\u0001\u0000\u0000\u0000\u015d\u015e\u0005\u0007"+
		"\u0000\u0000\u015e5\u0001\u0000\u0000\u0000\u015f\u0160\u00055\u0000\u0000"+
		"\u0160\u0161\u0005\u000e\u0000\u0000\u0161\u0168\u00038\u001c\u0000\u0162"+
		"\u0163\u0005\u0011\u0000\u0000\u0163\u0164\u00055\u0000\u0000\u0164\u0165"+
		"\u0005\u000e\u0000\u0000\u0165\u0167\u00038\u001c\u0000\u0166\u0162\u0001"+
		"\u0000\u0000\u0000\u0167\u016a\u0001\u0000\u0000\u0000\u0168\u0166\u0001"+
		"\u0000\u0000\u0000\u0168\u0169\u0001\u0000\u0000\u0000\u01697\u0001\u0000"+
		"\u0000\u0000\u016a\u0168\u0001\u0000\u0000\u0000\u016b\u016c\u0006\u001c"+
		"\uffff\uffff\u0000\u016c\u016d\u0005\u0018\u0000\u0000\u016d\u01a5\u0003"+
		"8\u001c\u0014\u016e\u016f\u0005\u001f\u0000\u0000\u016f\u0170\u00038\u001c"+
		"\u0000\u0170\u0171\u0005 \u0000\u0000\u0171\u01a5\u0001\u0000\u0000\u0000"+
		"\u0172\u01a5\u0003 \u0010\u0000\u0173\u0174\u00055\u0000\u0000\u0174\u0175"+
		"\u0005!\u0000\u0000\u0175\u0176\u00038\u001c\u0000\u0176\u0177\u0005\""+
		"\u0000\u0000\u0177\u01a5\u0001\u0000\u0000\u0000\u0178\u0179\u0005-\u0000"+
		"\u0000\u0179\u017a\u0005\u001f\u0000\u0000\u017a\u017b\u00038\u001c\u0000"+
		"\u017b\u017c\u0005\u0011\u0000\u0000\u017c\u017d\u00038\u001c\u0000\u017d"+
		"\u017e\u0005 \u0000\u0000\u017e\u01a5\u0001\u0000\u0000\u0000\u017f\u0180"+
		"\u0005.\u0000\u0000\u0180\u0181\u0005\u001f\u0000\u0000\u0181\u0182\u0003"+
		"8\u001c\u0000\u0182\u0183\u0005 \u0000\u0000\u0183\u01a5\u0001\u0000\u0000"+
		"\u0000\u0184\u0185\u0005/\u0000\u0000\u0185\u0186\u0005\u001f\u0000\u0000"+
		"\u0186\u0187\u00038\u001c\u0000\u0187\u0188\u0005\u0011\u0000\u0000\u0188"+
		"\u0189\u00038\u001c\u0000\u0189\u018a\u0005 \u0000\u0000\u018a\u01a5\u0001"+
		"\u0000\u0000\u0000\u018b\u018c\u00050\u0000\u0000\u018c\u018d\u0005\u001f"+
		"\u0000\u0000\u018d\u018e\u00038\u001c\u0000\u018e\u018f\u0005\u0011\u0000"+
		"\u0000\u018f\u0190\u00038\u001c\u0000\u0190\u0191\u0005 \u0000\u0000\u0191"+
		"\u01a5\u0001\u0000\u0000\u0000\u0192\u0193\u00055\u0000\u0000\u0193\u0194"+
		"\u0005!\u0000\u0000\u0194\u0195\u00038\u001c\u0000\u0195\u0196\u0005\""+
		"\u0000\u0000\u0196\u0197\u0005!\u0000\u0000\u0197\u0198\u00038\u001c\u0000"+
		"\u0198\u0199\u0005\"\u0000\u0000\u0199\u01a5\u0001\u0000\u0000\u0000\u019a"+
		"\u01a5\u0003&\u0013\u0000\u019b\u01a5\u00034\u001a\u0000\u019c\u01a5\u0005"+
		"4\u0000\u0000\u019d\u01a5\u00053\u0000\u0000\u019e\u01a5\u00052\u0000"+
		"\u0000\u019f\u01a5\u00051\u0000\u0000\u01a0\u01a5\u0005*\u0000\u0000\u01a1"+
		"\u01a5\u0005+\u0000\u0000\u01a2\u01a5\u0005,\u0000\u0000\u01a3\u01a5\u0005"+
		"5\u0000\u0000\u01a4\u016b\u0001\u0000\u0000\u0000\u01a4\u016e\u0001\u0000"+
		"\u0000\u0000\u01a4\u0172\u0001\u0000\u0000\u0000\u01a4\u0173\u0001\u0000"+
		"\u0000\u0000\u01a4\u0178\u0001\u0000\u0000\u0000\u01a4\u017f\u0001\u0000"+
		"\u0000\u0000\u01a4\u0184\u0001\u0000\u0000\u0000\u01a4\u018b\u0001\u0000"+
		"\u0000\u0000\u01a4\u0192\u0001\u0000\u0000\u0000\u01a4\u019a\u0001\u0000"+
		"\u0000\u0000\u01a4\u019b\u0001\u0000\u0000\u0000\u01a4\u019c\u0001\u0000"+
		"\u0000\u0000\u01a4\u019d\u0001\u0000\u0000\u0000\u01a4\u019e\u0001\u0000"+
		"\u0000\u0000\u01a4\u019f\u0001\u0000\u0000\u0000\u01a4\u01a0\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a1\u0001\u0000\u0000\u0000\u01a4\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a4\u01a3\u0001\u0000\u0000\u0000\u01a5\u01d2\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a7\n!\u0000\u0000\u01a7\u01a8\u0005\u0019\u0000"+
		"\u0000\u01a8\u01d1\u00038\u001c\"\u01a9\u01aa\n \u0000\u0000\u01aa\u01ab"+
		"\u0005\u001a\u0000\u0000\u01ab\u01d1\u00038\u001c!\u01ac\u01ad\n\u001f"+
		"\u0000\u0000\u01ad\u01ae\u0005\u001b\u0000\u0000\u01ae\u01d1\u00038\u001c"+
		" \u01af\u01b0\n\u001e\u0000\u0000\u01b0\u01b1\u0005\u001c\u0000\u0000"+
		"\u01b1\u01d1\u00038\u001c\u001f\u01b2\u01b3\n\u001d\u0000\u0000\u01b3"+
		"\u01b4\u0005\u001d\u0000\u0000\u01b4\u01d1\u00038\u001c\u001e\u01b5\u01b6"+
		"\n\u001c\u0000\u0000\u01b6\u01b7\u0005(\u0000\u0000\u01b7\u01d1\u0003"+
		"8\u001c\u001d\u01b8\u01b9\n\u001b\u0000\u0000\u01b9\u01ba\u0005)\u0000"+
		"\u0000\u01ba\u01d1\u00038\u001c\u001c\u01bb\u01bc\n\u001a\u0000\u0000"+
		"\u01bc\u01bd\u0005$\u0000\u0000\u01bd\u01d1\u00038\u001c\u001b\u01be\u01bf"+
		"\n\u0019\u0000\u0000\u01bf\u01c0\u0005%\u0000\u0000\u01c0\u01d1\u0003"+
		"8\u001c\u001a\u01c1\u01c2\n\u0018\u0000\u0000\u01c2\u01c3\u0005&\u0000"+
		"\u0000\u01c3\u01d1\u00038\u001c\u0019\u01c4\u01c5\n\u0017\u0000\u0000"+
		"\u01c5\u01c6\u0005\'\u0000\u0000\u01c6\u01d1\u00038\u001c\u0018\u01c7"+
		"\u01c8\n\u0016\u0000\u0000\u01c8\u01c9\u0005\u0016\u0000\u0000\u01c9\u01d1"+
		"\u00038\u001c\u0017\u01ca\u01cb\n\u0015\u0000\u0000\u01cb\u01cc\u0005"+
		"\u0017\u0000\u0000\u01cc\u01d1\u00038\u001c\u0016\u01cd\u01ce\n\t\u0000"+
		"\u0000\u01ce\u01cf\u0005\u0013\u0000\u0000\u01cf\u01d1\u00055\u0000\u0000"+
		"\u01d0\u01a6\u0001\u0000\u0000\u0000\u01d0\u01a9\u0001\u0000\u0000\u0000"+
		"\u01d0\u01ac\u0001\u0000\u0000\u0000\u01d0\u01af\u0001\u0000\u0000\u0000"+
		"\u01d0\u01b2\u0001\u0000\u0000\u0000\u01d0\u01b5\u0001\u0000\u0000\u0000"+
		"\u01d0\u01b8\u0001\u0000\u0000\u0000\u01d0\u01bb\u0001\u0000\u0000\u0000"+
		"\u01d0\u01be\u0001\u0000\u0000\u0000\u01d0\u01c1\u0001\u0000\u0000\u0000"+
		"\u01d0\u01c4\u0001\u0000\u0000\u0000\u01d0\u01c7\u0001\u0000\u0000\u0000"+
		"\u01d0\u01ca\u0001\u0000\u0000\u0000\u01d0\u01cd\u0001\u0000\u0000\u0000"+
		"\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000\u0000"+
		"\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d39\u0001\u0000\u0000\u0000\u01d4"+
		"\u01d2\u0001\u0000\u0000\u0000,>@DRXgjsx|\u0081\u0097\u009d\u00a5\u00a9"+
		"\u00b3\u00b7\u00be\u00c2\u00cb\u00cf\u00d4\u00e0\u00e8\u00ed\u00f5\u00f8"+
		"\u0102\u0105\u010c\u0110\u0119\u011c\u0125\u0132\u0135\u0140\u0150\u0154"+
		"\u015b\u0168\u01a4\u01d0\u01d2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}