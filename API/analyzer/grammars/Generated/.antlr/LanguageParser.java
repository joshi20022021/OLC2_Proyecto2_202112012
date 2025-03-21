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
		T__17=18, T__18=19, T__19=20, T__20=21, MAS=22, MENOS=23, MULT=24, DIV=25, 
		MOD=26, IGUAL=27, PARENTESIS_IZQ=28, PARENTESIS_DER=29, L_CORCHETE=30, 
		R_CORCHETE=31, PUNTOYCOMA=32, MAYOR=33, MENOR=34, MAYOR_IGUAL=35, MENOR_IGUAL=36, 
		IGUALDAD=37, DIFERENTE=38, VERDADERO=39, FALSO=40, NULO=41, AGREGAR=42, 
		LONGITUD=43, INDICE=44, UNIR=45, LIT_STRING=46, LIT_RUNE=47, LIT_FLOAT=48, 
		LIT_ENTERO=49, IDENTIFICADOR=50, ESPACIOS=51, COMENTARIO=52, COMENTARIO_MULTILINEA=53, 
		IMPRIMIR=54;
	public static final int
		RULE_programa = 0, RULE_funcionMain = 1, RULE_breakStmt = 2, RULE_continueStmt = 3, 
		RULE_returnStmt = 4, RULE_bloque = 5, RULE_sentencia = 6, RULE_ifStmt = 7, 
		RULE_declaracion = 8, RULE_asignacion = 9, RULE_tipo = 10, RULE_switchStmt = 11, 
		RULE_caseBlock = 12, RULE_defaultBlock = 13, RULE_forStmt = 14, RULE_contador = 15, 
		RULE_sliceLiteral = 16, RULE_sliceElemento = 17, RULE_imprimir = 18, RULE_expresion = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "funcionMain", "breakStmt", "continueStmt", "returnStmt", 
			"bloque", "sentencia", "ifStmt", "declaracion", "asignacion", "tipo", 
			"switchStmt", "caseBlock", "defaultBlock", "forStmt", "contador", "sliceLiteral", 
			"sliceElemento", "imprimir", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'break'", "'continue'", "'return'", "'{'", 
			"'}'", "'if'", "'else'", "'var'", "':='", "'switch'", "'case'", "':'", 
			"'default'", "'for'", "','", "'range'", "'&&'", "'||'", "'!'", "'+'", 
			"'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", "'['", "']'", "';'", 
			"'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'true'", "'false'", "'nil'", 
			"'append'", "'len'", "'slice.Index'", "'strings.Join'", null, null, null, 
			null, null, null, null, null, "'fmt.Println'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "MAS", "MENOS", 
			"MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", "PARENTESIS_DER", "L_CORCHETE", 
			"R_CORCHETE", "PUNTOYCOMA", "MAYOR", "MENOR", "MAYOR_IGUAL", "MENOR_IGUAL", 
			"IGUALDAD", "DIFERENTE", "VERDADERO", "FALSO", "NULO", "AGREGAR", "LONGITUD", 
			"INDICE", "UNIR", "LIT_STRING", "LIT_RUNE", "LIT_FLOAT", "LIT_ENTERO", 
			"IDENTIFICADOR", "ESPACIOS", "COMENTARIO", "COMENTARIO_MULTILINEA", "IMPRIMIR"
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
			setState(40);
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
			setState(42);
			match(T__0);
			setState(43);
			match(T__1);
			setState(44);
			match(PARENTESIS_IZQ);
			setState(45);
			match(PARENTESIS_DER);
			setState(46);
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
			setState(48);
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
			setState(50);
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
			setState(52);
			match(T__4);
			setState(54);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(53);
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
			setState(56);
			match(T__5);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 20265649911698744L) != 0)) {
				{
				{
				setState(57);
				sentencia();
				}
				}
				setState(62);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(63);
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
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(65);
				declaracion();
				}
				break;
			case 2:
				{
				setState(66);
				asignacion();
				}
				break;
			case 3:
				{
				setState(67);
				imprimir();
				}
				break;
			case 4:
				{
				setState(68);
				expresion(0);
				}
				break;
			case 5:
				{
				setState(69);
				ifStmt();
				}
				break;
			case 6:
				{
				setState(70);
				switchStmt();
				}
				break;
			case 7:
				{
				setState(71);
				forStmt();
				}
				break;
			case 8:
				{
				setState(72);
				breakStmt();
				}
				break;
			case 9:
				{
				setState(73);
				continueStmt();
				}
				break;
			case 10:
				{
				setState(74);
				returnStmt();
				}
				break;
			}
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOYCOMA) {
				{
				setState(77);
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
			setState(80);
			match(T__7);
			setState(81);
			expresion(0);
			setState(82);
			bloque();
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(83);
				match(T__8);
				setState(84);
				ifStmt();
				}
				break;
			case 2:
				{
				setState(85);
				match(T__8);
				setState(86);
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
			setState(101);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(89);
				match(T__9);
				setState(90);
				match(IDENTIFICADOR);
				setState(92);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(91);
					tipo();
					}
					break;
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(94);
					match(IGUAL);
					setState(95);
					expresion(0);
					}
				}

				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(98);
				match(IDENTIFICADOR);
				setState(99);
				match(T__10);
				setState(100);
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
			setState(123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AsignarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(103);
				match(IDENTIFICADOR);
				setState(104);
				match(IGUAL);
				setState(105);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new AsignarSliceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(106);
				match(IDENTIFICADOR);
				setState(107);
				match(L_CORCHETE);
				setState(108);
				expresion(0);
				setState(109);
				match(R_CORCHETE);
				setState(110);
				match(IGUAL);
				setState(111);
				expresion(0);
				}
				break;
			case 3:
				_localctx = new AsignarMatrizContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
				match(IDENTIFICADOR);
				setState(114);
				match(L_CORCHETE);
				setState(115);
				expresion(0);
				setState(116);
				match(R_CORCHETE);
				setState(117);
				match(L_CORCHETE);
				setState(118);
				expresion(0);
				setState(119);
				match(R_CORCHETE);
				setState(120);
				match(IGUAL);
				setState(121);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
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
			setState(127);
			match(T__11);
			setState(128);
			expresion(0);
			setState(129);
			match(T__5);
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(130);
				caseBlock();
				}
				}
				setState(135);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(137);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(136);
				defaultBlock();
				}
			}

			setState(139);
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
			setState(141);
			match(T__12);
			setState(142);
			expresion(0);
			setState(143);
			match(T__13);
			setState(147);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(144);
					sentencia();
					}
					} 
				}
				setState(149);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			setState(151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(150);
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
			setState(153);
			match(T__14);
			setState(154);
			match(T__13);
			setState(158);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(155);
					sentencia();
					}
					} 
				}
				setState(160);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(161);
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
			setState(192);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new ForCondicionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(164);
				match(T__15);
				setState(165);
				expresion(0);
				setState(166);
				bloque();
				}
				break;
			case 2:
				_localctx = new ForClasicoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(168);
				match(T__15);
				setState(171);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
				case 1:
					{
					setState(169);
					declaracion();
					}
					break;
				case 2:
					{
					setState(170);
					asignacion();
					}
					break;
				}
				setState(173);
				match(PUNTOYCOMA);
				setState(175);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251251402145792L) != 0)) {
					{
					setState(174);
					expresion(0);
					}
				}

				setState(177);
				match(PUNTOYCOMA);
				setState(180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
				case 1:
					{
					setState(178);
					asignacion();
					}
					break;
				case 2:
					{
					setState(179);
					contador();
					}
					break;
				}
				setState(182);
				bloque();
				}
				break;
			case 3:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(183);
				match(T__15);
				setState(184);
				match(IDENTIFICADOR);
				setState(185);
				match(T__16);
				setState(186);
				match(IDENTIFICADOR);
				setState(187);
				match(T__10);
				setState(188);
				match(T__17);
				setState(189);
				expresion(0);
				setState(190);
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
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new IncrementoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(194);
				match(IDENTIFICADOR);
				setState(195);
				match(MAS);
				setState(196);
				match(MAS);
				}
				break;
			case 2:
				_localctx = new DecrementoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(197);
				match(IDENTIFICADOR);
				setState(198);
				match(MENOS);
				setState(199);
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
		public TerminalNode IDENTIFICADOR() { return getToken(LanguageParser.IDENTIFICADOR, 0); }
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
			setState(202);
			match(L_CORCHETE);
			setState(203);
			match(R_CORCHETE);
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFICADOR) {
				{
				setState(204);
				match(IDENTIFICADOR);
				}
			}

			setState(207);
			match(T__5);
			setState(216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251251402145792L) != 0)) {
				{
				setState(208);
				sliceElemento();
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(209);
					match(T__16);
					setState(210);
					sliceElemento();
					}
					}
					setState(215);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(218);
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
		public SliceElementoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceElemento; }
	}

	public final SliceElementoContext sliceElemento() throws RecognitionException {
		SliceElementoContext _localctx = new SliceElementoContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_sliceElemento);
		try {
			setState(222);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(220);
				expresion(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				sliceLiteral();
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
		enterRule(_localctx, 36, RULE_imprimir);
		int _la;
		try {
			_localctx = new ImprimeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			match(IMPRIMIR);
			setState(225);
			match(PARENTESIS_IZQ);
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2251251402145792L) != 0)) {
				{
				setState(226);
				expresion(0);
				setState(231);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(227);
					match(T__16);
					setState(228);
					expresion(0);
					}
					}
					setState(233);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(236);
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
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(239);
				match(T__20);
				setState(240);
				expresion(17);
				}
				break;
			case 2:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(241);
				match(PARENTESIS_IZQ);
				setState(242);
				expresion(0);
				setState(243);
				match(PARENTESIS_DER);
				}
				break;
			case 3:
				{
				_localctx = new SliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(245);
				sliceLiteral();
				}
				break;
			case 4:
				{
				_localctx = new AccesoSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(246);
				match(IDENTIFICADOR);
				setState(247);
				match(L_CORCHETE);
				setState(248);
				expresion(0);
				setState(249);
				match(R_CORCHETE);
				}
				break;
			case 5:
				{
				_localctx = new FuncionAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(251);
				match(AGREGAR);
				setState(252);
				match(PARENTESIS_IZQ);
				setState(253);
				expresion(0);
				setState(254);
				match(T__16);
				setState(255);
				expresion(0);
				setState(256);
				match(PARENTESIS_DER);
				}
				break;
			case 6:
				{
				_localctx = new FuncionLenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(258);
				match(LONGITUD);
				setState(259);
				match(PARENTESIS_IZQ);
				setState(260);
				expresion(0);
				setState(261);
				match(PARENTESIS_DER);
				}
				break;
			case 7:
				{
				_localctx = new FuncionIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(263);
				match(INDICE);
				setState(264);
				match(PARENTESIS_IZQ);
				setState(265);
				expresion(0);
				setState(266);
				match(T__16);
				setState(267);
				expresion(0);
				setState(268);
				match(PARENTESIS_DER);
				}
				break;
			case 8:
				{
				_localctx = new FuncionJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(270);
				match(UNIR);
				setState(271);
				match(PARENTESIS_IZQ);
				setState(272);
				expresion(0);
				setState(273);
				match(T__16);
				setState(274);
				expresion(0);
				setState(275);
				match(PARENTESIS_DER);
				}
				break;
			case 9:
				{
				_localctx = new AccesoSlice2DContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(IDENTIFICADOR);
				setState(278);
				match(L_CORCHETE);
				setState(279);
				expresion(0);
				setState(280);
				match(R_CORCHETE);
				setState(281);
				match(L_CORCHETE);
				setState(282);
				expresion(0);
				setState(283);
				match(R_CORCHETE);
				}
				break;
			case 10:
				{
				_localctx = new LiteralEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				match(LIT_ENTERO);
				}
				break;
			case 11:
				{
				_localctx = new LiteralFlotanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(LIT_FLOAT);
				}
				break;
			case 12:
				{
				_localctx = new LiteralRuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(287);
				match(LIT_RUNE);
				}
				break;
			case 13:
				{
				_localctx = new LiteralCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(288);
				match(LIT_STRING);
				}
				break;
			case 14:
				{
				_localctx = new LiteralVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(289);
				match(VERDADERO);
				}
				break;
			case 15:
				{
				_localctx = new LiteralFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(290);
				match(FALSO);
				}
				break;
			case 16:
				{
				_localctx = new LiteralNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				match(NULO);
				}
				break;
			case 17:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(292);
				match(IDENTIFICADOR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(336);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(334);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
					case 1:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(295);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(296);
						match(MAS);
						setState(297);
						expresion(31);
						}
						break;
					case 2:
						{
						_localctx = new RestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(298);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(299);
						match(MENOS);
						setState(300);
						expresion(30);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(301);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(302);
						match(MULT);
						setState(303);
						expresion(29);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(304);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(305);
						match(DIV);
						setState(306);
						expresion(28);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(307);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(308);
						match(MOD);
						setState(309);
						expresion(27);
						}
						break;
					case 6:
						{
						_localctx = new ComparacionIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(310);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(311);
						match(IGUALDAD);
						setState(312);
						expresion(26);
						}
						break;
					case 7:
						{
						_localctx = new ComparacionDiferenteContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(313);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(314);
						match(DIFERENTE);
						setState(315);
						expresion(25);
						}
						break;
					case 8:
						{
						_localctx = new MayorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(316);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(317);
						match(MAYOR);
						setState(318);
						expresion(24);
						}
						break;
					case 9:
						{
						_localctx = new MenorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(319);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(320);
						match(MENOR);
						setState(321);
						expresion(23);
						}
						break;
					case 10:
						{
						_localctx = new MayorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(322);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(323);
						match(MAYOR_IGUAL);
						setState(324);
						expresion(22);
						}
						break;
					case 11:
						{
						_localctx = new MenorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(325);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(326);
						match(MENOR_IGUAL);
						setState(327);
						expresion(21);
						}
						break;
					case 12:
						{
						_localctx = new AndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(328);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(329);
						match(T__18);
						setState(330);
						expresion(20);
						}
						break;
					case 13:
						{
						_localctx = new OrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(331);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(332);
						match(T__19);
						setState(333);
						expresion(19);
						}
						break;
					}
					} 
				}
				setState(338);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,28,_ctx);
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
		case 19:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 30);
		case 1:
			return precpred(_ctx, 29);
		case 2:
			return precpred(_ctx, 28);
		case 3:
			return precpred(_ctx, 27);
		case 4:
			return precpred(_ctx, 26);
		case 5:
			return precpred(_ctx, 25);
		case 6:
			return precpred(_ctx, 24);
		case 7:
			return precpred(_ctx, 23);
		case 8:
			return precpred(_ctx, 22);
		case 9:
			return precpred(_ctx, 21);
		case 10:
			return precpred(_ctx, 20);
		case 11:
			return precpred(_ctx, 19);
		case 12:
			return precpred(_ctx, 18);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00016\u0154\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0003\u00047\b\u0004"+
		"\u0001\u0005\u0001\u0005\u0005\u0005;\b\u0005\n\u0005\f\u0005>\t\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006L\b\u0006\u0001\u0006\u0003\u0006O\b\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003"+
		"\u0007X\b\u0007\u0001\b\u0001\b\u0001\b\u0003\b]\b\b\u0001\b\u0001\b\u0003"+
		"\ba\b\b\u0001\b\u0001\b\u0001\b\u0003\bf\b\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t|\b"+
		"\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005"+
		"\u000b\u0084\b\u000b\n\u000b\f\u000b\u0087\t\u000b\u0001\u000b\u0003\u000b"+
		"\u008a\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f"+
		"\u0005\f\u0092\b\f\n\f\f\f\u0095\t\f\u0001\f\u0003\f\u0098\b\f\u0001\r"+
		"\u0001\r\u0001\r\u0005\r\u009d\b\r\n\r\f\r\u00a0\t\r\u0001\r\u0003\r\u00a3"+
		"\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00ac\b\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00b0\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b5"+
		"\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00c1"+
		"\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u00c9\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u00ce\b\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005"+
		"\u0010\u00d4\b\u0010\n\u0010\f\u0010\u00d7\t\u0010\u0003\u0010\u00d9\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0003\u0011\u00df"+
		"\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u00e6\b\u0012\n\u0012\f\u0012\u00e9\t\u0012\u0003\u0012\u00eb\b"+
		"\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0126\b\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u014f\b\u0013\n\u0013\f\u0013"+
		"\u0152\t\u0013\u0001\u0013\u0000\u0001&\u0014\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&\u0000"+
		"\u0000\u0183\u0000(\u0001\u0000\u0000\u0000\u0002*\u0001\u0000\u0000\u0000"+
		"\u00040\u0001\u0000\u0000\u0000\u00062\u0001\u0000\u0000\u0000\b4\u0001"+
		"\u0000\u0000\u0000\n8\u0001\u0000\u0000\u0000\fK\u0001\u0000\u0000\u0000"+
		"\u000eP\u0001\u0000\u0000\u0000\u0010e\u0001\u0000\u0000\u0000\u0012{"+
		"\u0001\u0000\u0000\u0000\u0014}\u0001\u0000\u0000\u0000\u0016\u007f\u0001"+
		"\u0000\u0000\u0000\u0018\u008d\u0001\u0000\u0000\u0000\u001a\u0099\u0001"+
		"\u0000\u0000\u0000\u001c\u00c0\u0001\u0000\u0000\u0000\u001e\u00c8\u0001"+
		"\u0000\u0000\u0000 \u00ca\u0001\u0000\u0000\u0000\"\u00de\u0001\u0000"+
		"\u0000\u0000$\u00e0\u0001\u0000\u0000\u0000&\u0125\u0001\u0000\u0000\u0000"+
		"()\u0003\u0002\u0001\u0000)\u0001\u0001\u0000\u0000\u0000*+\u0005\u0001"+
		"\u0000\u0000+,\u0005\u0002\u0000\u0000,-\u0005\u001c\u0000\u0000-.\u0005"+
		"\u001d\u0000\u0000./\u0003\n\u0005\u0000/\u0003\u0001\u0000\u0000\u0000"+
		"01\u0005\u0003\u0000\u00001\u0005\u0001\u0000\u0000\u000023\u0005\u0004"+
		"\u0000\u00003\u0007\u0001\u0000\u0000\u000046\u0005\u0005\u0000\u0000"+
		"57\u0003&\u0013\u000065\u0001\u0000\u0000\u000067\u0001\u0000\u0000\u0000"+
		"7\t\u0001\u0000\u0000\u00008<\u0005\u0006\u0000\u00009;\u0003\f\u0006"+
		"\u0000:9\u0001\u0000\u0000\u0000;>\u0001\u0000\u0000\u0000<:\u0001\u0000"+
		"\u0000\u0000<=\u0001\u0000\u0000\u0000=?\u0001\u0000\u0000\u0000><\u0001"+
		"\u0000\u0000\u0000?@\u0005\u0007\u0000\u0000@\u000b\u0001\u0000\u0000"+
		"\u0000AL\u0003\u0010\b\u0000BL\u0003\u0012\t\u0000CL\u0003$\u0012\u0000"+
		"DL\u0003&\u0013\u0000EL\u0003\u000e\u0007\u0000FL\u0003\u0016\u000b\u0000"+
		"GL\u0003\u001c\u000e\u0000HL\u0003\u0004\u0002\u0000IL\u0003\u0006\u0003"+
		"\u0000JL\u0003\b\u0004\u0000KA\u0001\u0000\u0000\u0000KB\u0001\u0000\u0000"+
		"\u0000KC\u0001\u0000\u0000\u0000KD\u0001\u0000\u0000\u0000KE\u0001\u0000"+
		"\u0000\u0000KF\u0001\u0000\u0000\u0000KG\u0001\u0000\u0000\u0000KH\u0001"+
		"\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KJ\u0001\u0000\u0000\u0000"+
		"LN\u0001\u0000\u0000\u0000MO\u0005 \u0000\u0000NM\u0001\u0000\u0000\u0000"+
		"NO\u0001\u0000\u0000\u0000O\r\u0001\u0000\u0000\u0000PQ\u0005\b\u0000"+
		"\u0000QR\u0003&\u0013\u0000RW\u0003\n\u0005\u0000ST\u0005\t\u0000\u0000"+
		"TX\u0003\u000e\u0007\u0000UV\u0005\t\u0000\u0000VX\u0003\n\u0005\u0000"+
		"WS\u0001\u0000\u0000\u0000WU\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000"+
		"\u0000X\u000f\u0001\u0000\u0000\u0000YZ\u0005\n\u0000\u0000Z\\\u00052"+
		"\u0000\u0000[]\u0003\u0014\n\u0000\\[\u0001\u0000\u0000\u0000\\]\u0001"+
		"\u0000\u0000\u0000]`\u0001\u0000\u0000\u0000^_\u0005\u001b\u0000\u0000"+
		"_a\u0003&\u0013\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000"+
		"af\u0001\u0000\u0000\u0000bc\u00052\u0000\u0000cd\u0005\u000b\u0000\u0000"+
		"df\u0003&\u0013\u0000eY\u0001\u0000\u0000\u0000eb\u0001\u0000\u0000\u0000"+
		"f\u0011\u0001\u0000\u0000\u0000gh\u00052\u0000\u0000hi\u0005\u001b\u0000"+
		"\u0000i|\u0003&\u0013\u0000jk\u00052\u0000\u0000kl\u0005\u001e\u0000\u0000"+
		"lm\u0003&\u0013\u0000mn\u0005\u001f\u0000\u0000no\u0005\u001b\u0000\u0000"+
		"op\u0003&\u0013\u0000p|\u0001\u0000\u0000\u0000qr\u00052\u0000\u0000r"+
		"s\u0005\u001e\u0000\u0000st\u0003&\u0013\u0000tu\u0005\u001f\u0000\u0000"+
		"uv\u0005\u001e\u0000\u0000vw\u0003&\u0013\u0000wx\u0005\u001f\u0000\u0000"+
		"xy\u0005\u001b\u0000\u0000yz\u0003&\u0013\u0000z|\u0001\u0000\u0000\u0000"+
		"{g\u0001\u0000\u0000\u0000{j\u0001\u0000\u0000\u0000{q\u0001\u0000\u0000"+
		"\u0000|\u0013\u0001\u0000\u0000\u0000}~\u00052\u0000\u0000~\u0015\u0001"+
		"\u0000\u0000\u0000\u007f\u0080\u0005\f\u0000\u0000\u0080\u0081\u0003&"+
		"\u0013\u0000\u0081\u0085\u0005\u0006\u0000\u0000\u0082\u0084\u0003\u0018"+
		"\f\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000\u0000"+
		"\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000\u0000"+
		"\u0000\u0086\u0089\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000\u0000"+
		"\u0000\u0088\u008a\u0003\u001a\r\u0000\u0089\u0088\u0001\u0000\u0000\u0000"+
		"\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000\u0000\u0000"+
		"\u008b\u008c\u0005\u0007\u0000\u0000\u008c\u0017\u0001\u0000\u0000\u0000"+
		"\u008d\u008e\u0005\r\u0000\u0000\u008e\u008f\u0003&\u0013\u0000\u008f"+
		"\u0093\u0005\u000e\u0000\u0000\u0090\u0092\u0003\f\u0006\u0000\u0091\u0090"+
		"\u0001\u0000\u0000\u0000\u0092\u0095\u0001\u0000\u0000\u0000\u0093\u0091"+
		"\u0001\u0000\u0000\u0000\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0097"+
		"\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000\u0096\u0098"+
		"\u0003\u0004\u0002\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098"+
		"\u0001\u0000\u0000\u0000\u0098\u0019\u0001\u0000\u0000\u0000\u0099\u009a"+
		"\u0005\u000f\u0000\u0000\u009a\u009e\u0005\u000e\u0000\u0000\u009b\u009d"+
		"\u0003\f\u0006\u0000\u009c\u009b\u0001\u0000\u0000\u0000\u009d\u00a0\u0001"+
		"\u0000\u0000\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f\u0001"+
		"\u0000\u0000\u0000\u009f\u00a2\u0001\u0000\u0000\u0000\u00a0\u009e\u0001"+
		"\u0000\u0000\u0000\u00a1\u00a3\u0003\u0004\u0002\u0000\u00a2\u00a1\u0001"+
		"\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u001b\u0001"+
		"\u0000\u0000\u0000\u00a4\u00a5\u0005\u0010\u0000\u0000\u00a5\u00a6\u0003"+
		"&\u0013\u0000\u00a6\u00a7\u0003\n\u0005\u0000\u00a7\u00c1\u0001\u0000"+
		"\u0000\u0000\u00a8\u00ab\u0005\u0010\u0000\u0000\u00a9\u00ac\u0003\u0010"+
		"\b\u0000\u00aa\u00ac\u0003\u0012\t\u0000\u00ab\u00a9\u0001\u0000\u0000"+
		"\u0000\u00ab\u00aa\u0001\u0000\u0000\u0000\u00ab\u00ac\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00af\u0005 \u0000\u0000"+
		"\u00ae\u00b0\u0003&\u0013\u0000\u00af\u00ae\u0001\u0000\u0000\u0000\u00af"+
		"\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1"+
		"\u00b4\u0005 \u0000\u0000\u00b2\u00b5\u0003\u0012\t\u0000\u00b3\u00b5"+
		"\u0003\u001e\u000f\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00c1\u0003\n\u0005\u0000\u00b7\u00b8\u0005"+
		"\u0010\u0000\u0000\u00b8\u00b9\u00052\u0000\u0000\u00b9\u00ba\u0005\u0011"+
		"\u0000\u0000\u00ba\u00bb\u00052\u0000\u0000\u00bb\u00bc\u0005\u000b\u0000"+
		"\u0000\u00bc\u00bd\u0005\u0012\u0000\u0000\u00bd\u00be\u0003&\u0013\u0000"+
		"\u00be\u00bf\u0003\n\u0005\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0"+
		"\u00a4\u0001\u0000\u0000\u0000\u00c0\u00a8\u0001\u0000\u0000\u0000\u00c0"+
		"\u00b7\u0001\u0000\u0000\u0000\u00c1\u001d\u0001\u0000\u0000\u0000\u00c2"+
		"\u00c3\u00052\u0000\u0000\u00c3\u00c4\u0005\u0016\u0000\u0000\u00c4\u00c9"+
		"\u0005\u0016\u0000\u0000\u00c5\u00c6\u00052\u0000\u0000\u00c6\u00c7\u0005"+
		"\u0017\u0000\u0000\u00c7\u00c9\u0005\u0017\u0000\u0000\u00c8\u00c2\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c5\u0001\u0000\u0000\u0000\u00c9\u001f\u0001"+
		"\u0000\u0000\u0000\u00ca\u00cb\u0005\u001e\u0000\u0000\u00cb\u00cd\u0005"+
		"\u001f\u0000\u0000\u00cc\u00ce\u00052\u0000\u0000\u00cd\u00cc\u0001\u0000"+
		"\u0000\u0000\u00cd\u00ce\u0001\u0000\u0000\u0000\u00ce\u00cf\u0001\u0000"+
		"\u0000\u0000\u00cf\u00d8\u0005\u0006\u0000\u0000\u00d0\u00d5\u0003\"\u0011"+
		"\u0000\u00d1\u00d2\u0005\u0011\u0000\u0000\u00d2\u00d4\u0003\"\u0011\u0000"+
		"\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d4\u00d7\u0001\u0000\u0000\u0000"+
		"\u00d5\u00d3\u0001\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000"+
		"\u00d6\u00d9\u0001\u0000\u0000\u0000\u00d7\u00d5\u0001\u0000\u0000\u0000"+
		"\u00d8\u00d0\u0001\u0000\u0000\u0000\u00d8\u00d9\u0001\u0000\u0000\u0000"+
		"\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00db\u0005\u0007\u0000\u0000"+
		"\u00db!\u0001\u0000\u0000\u0000\u00dc\u00df\u0003&\u0013\u0000\u00dd\u00df"+
		"\u0003 \u0010\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00dd\u0001"+
		"\u0000\u0000\u0000\u00df#\u0001\u0000\u0000\u0000\u00e0\u00e1\u00056\u0000"+
		"\u0000\u00e1\u00ea\u0005\u001c\u0000\u0000\u00e2\u00e7\u0003&\u0013\u0000"+
		"\u00e3\u00e4\u0005\u0011\u0000\u0000\u00e4\u00e6\u0003&\u0013\u0000\u00e5"+
		"\u00e3\u0001\u0000\u0000\u0000\u00e6\u00e9\u0001\u0000\u0000\u0000\u00e7"+
		"\u00e5\u0001\u0000\u0000\u0000\u00e7\u00e8\u0001\u0000\u0000\u0000\u00e8"+
		"\u00eb\u0001\u0000\u0000\u0000\u00e9\u00e7\u0001\u0000\u0000\u0000\u00ea"+
		"\u00e2\u0001\u0000\u0000\u0000\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ed\u0005\u001d\u0000\u0000\u00ed"+
		"%\u0001\u0000\u0000\u0000\u00ee\u00ef\u0006\u0013\uffff\uffff\u0000\u00ef"+
		"\u00f0\u0005\u0015\u0000\u0000\u00f0\u0126\u0003&\u0013\u0011\u00f1\u00f2"+
		"\u0005\u001c\u0000\u0000\u00f2\u00f3\u0003&\u0013\u0000\u00f3\u00f4\u0005"+
		"\u001d\u0000\u0000\u00f4\u0126\u0001\u0000\u0000\u0000\u00f5\u0126\u0003"+
		" \u0010\u0000\u00f6\u00f7\u00052\u0000\u0000\u00f7\u00f8\u0005\u001e\u0000"+
		"\u0000\u00f8\u00f9\u0003&\u0013\u0000\u00f9\u00fa\u0005\u001f\u0000\u0000"+
		"\u00fa\u0126\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005*\u0000\u0000\u00fc"+
		"\u00fd\u0005\u001c\u0000\u0000\u00fd\u00fe\u0003&\u0013\u0000\u00fe\u00ff"+
		"\u0005\u0011\u0000\u0000\u00ff\u0100\u0003&\u0013\u0000\u0100\u0101\u0005"+
		"\u001d\u0000\u0000\u0101\u0126\u0001\u0000\u0000\u0000\u0102\u0103\u0005"+
		"+\u0000\u0000\u0103\u0104\u0005\u001c\u0000\u0000\u0104\u0105\u0003&\u0013"+
		"\u0000\u0105\u0106\u0005\u001d\u0000\u0000\u0106\u0126\u0001\u0000\u0000"+
		"\u0000\u0107\u0108\u0005,\u0000\u0000\u0108\u0109\u0005\u001c\u0000\u0000"+
		"\u0109\u010a\u0003&\u0013\u0000\u010a\u010b\u0005\u0011\u0000\u0000\u010b"+
		"\u010c\u0003&\u0013\u0000\u010c\u010d\u0005\u001d\u0000\u0000\u010d\u0126"+
		"\u0001\u0000\u0000\u0000\u010e\u010f\u0005-\u0000\u0000\u010f\u0110\u0005"+
		"\u001c\u0000\u0000\u0110\u0111\u0003&\u0013\u0000\u0111\u0112\u0005\u0011"+
		"\u0000\u0000\u0112\u0113\u0003&\u0013\u0000\u0113\u0114\u0005\u001d\u0000"+
		"\u0000\u0114\u0126\u0001\u0000\u0000\u0000\u0115\u0116\u00052\u0000\u0000"+
		"\u0116\u0117\u0005\u001e\u0000\u0000\u0117\u0118\u0003&\u0013\u0000\u0118"+
		"\u0119\u0005\u001f\u0000\u0000\u0119\u011a\u0005\u001e\u0000\u0000\u011a"+
		"\u011b\u0003&\u0013\u0000\u011b\u011c\u0005\u001f\u0000\u0000\u011c\u0126"+
		"\u0001\u0000\u0000\u0000\u011d\u0126\u00051\u0000\u0000\u011e\u0126\u0005"+
		"0\u0000\u0000\u011f\u0126\u0005/\u0000\u0000\u0120\u0126\u0005.\u0000"+
		"\u0000\u0121\u0126\u0005\'\u0000\u0000\u0122\u0126\u0005(\u0000\u0000"+
		"\u0123\u0126\u0005)\u0000\u0000\u0124\u0126\u00052\u0000\u0000\u0125\u00ee"+
		"\u0001\u0000\u0000\u0000\u0125\u00f1\u0001\u0000\u0000\u0000\u0125\u00f5"+
		"\u0001\u0000\u0000\u0000\u0125\u00f6\u0001\u0000\u0000\u0000\u0125\u00fb"+
		"\u0001\u0000\u0000\u0000\u0125\u0102\u0001\u0000\u0000\u0000\u0125\u0107"+
		"\u0001\u0000\u0000\u0000\u0125\u010e\u0001\u0000\u0000\u0000\u0125\u0115"+
		"\u0001\u0000\u0000\u0000\u0125\u011d\u0001\u0000\u0000\u0000\u0125\u011e"+
		"\u0001\u0000\u0000\u0000\u0125\u011f\u0001\u0000\u0000\u0000\u0125\u0120"+
		"\u0001\u0000\u0000\u0000\u0125\u0121\u0001\u0000\u0000\u0000\u0125\u0122"+
		"\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0124"+
		"\u0001\u0000\u0000\u0000\u0126\u0150\u0001\u0000\u0000\u0000\u0127\u0128"+
		"\n\u001e\u0000\u0000\u0128\u0129\u0005\u0016\u0000\u0000\u0129\u014f\u0003"+
		"&\u0013\u001f\u012a\u012b\n\u001d\u0000\u0000\u012b\u012c\u0005\u0017"+
		"\u0000\u0000\u012c\u014f\u0003&\u0013\u001e\u012d\u012e\n\u001c\u0000"+
		"\u0000\u012e\u012f\u0005\u0018\u0000\u0000\u012f\u014f\u0003&\u0013\u001d"+
		"\u0130\u0131\n\u001b\u0000\u0000\u0131\u0132\u0005\u0019\u0000\u0000\u0132"+
		"\u014f\u0003&\u0013\u001c\u0133\u0134\n\u001a\u0000\u0000\u0134\u0135"+
		"\u0005\u001a\u0000\u0000\u0135\u014f\u0003&\u0013\u001b\u0136\u0137\n"+
		"\u0019\u0000\u0000\u0137\u0138\u0005%\u0000\u0000\u0138\u014f\u0003&\u0013"+
		"\u001a\u0139\u013a\n\u0018\u0000\u0000\u013a\u013b\u0005&\u0000\u0000"+
		"\u013b\u014f\u0003&\u0013\u0019\u013c\u013d\n\u0017\u0000\u0000\u013d"+
		"\u013e\u0005!\u0000\u0000\u013e\u014f\u0003&\u0013\u0018\u013f\u0140\n"+
		"\u0016\u0000\u0000\u0140\u0141\u0005\"\u0000\u0000\u0141\u014f\u0003&"+
		"\u0013\u0017\u0142\u0143\n\u0015\u0000\u0000\u0143\u0144\u0005#\u0000"+
		"\u0000\u0144\u014f\u0003&\u0013\u0016\u0145\u0146\n\u0014\u0000\u0000"+
		"\u0146\u0147\u0005$\u0000\u0000\u0147\u014f\u0003&\u0013\u0015\u0148\u0149"+
		"\n\u0013\u0000\u0000\u0149\u014a\u0005\u0013\u0000\u0000\u014a\u014f\u0003"+
		"&\u0013\u0014\u014b\u014c\n\u0012\u0000\u0000\u014c\u014d\u0005\u0014"+
		"\u0000\u0000\u014d\u014f\u0003&\u0013\u0013\u014e\u0127\u0001\u0000\u0000"+
		"\u0000\u014e\u012a\u0001\u0000\u0000\u0000\u014e\u012d\u0001\u0000\u0000"+
		"\u0000\u014e\u0130\u0001\u0000\u0000\u0000\u014e\u0133\u0001\u0000\u0000"+
		"\u0000\u014e\u0136\u0001\u0000\u0000\u0000\u014e\u0139\u0001\u0000\u0000"+
		"\u0000\u014e\u013c\u0001\u0000\u0000\u0000\u014e\u013f\u0001\u0000\u0000"+
		"\u0000\u014e\u0142\u0001\u0000\u0000\u0000\u014e\u0145\u0001\u0000\u0000"+
		"\u0000\u014e\u0148\u0001\u0000\u0000\u0000\u014e\u014b\u0001\u0000\u0000"+
		"\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000\u0000"+
		"\u0000\u0150\u0151\u0001\u0000\u0000\u0000\u0151\'\u0001\u0000\u0000\u0000"+
		"\u0152\u0150\u0001\u0000\u0000\u0000\u001d6<KNW\\`e{\u0085\u0089\u0093"+
		"\u0097\u009e\u00a2\u00ab\u00af\u00b4\u00c0\u00c8\u00cd\u00d5\u00d8\u00de"+
		"\u00e7\u00ea\u0125\u014e\u0150";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}