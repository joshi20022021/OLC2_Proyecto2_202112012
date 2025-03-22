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
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, MAS=23, MENOS=24, MULT=25, 
		DIV=26, MOD=27, IGUAL=28, PARENTESIS_IZQ=29, PARENTESIS_DER=30, L_CORCHETE=31, 
		R_CORCHETE=32, PUNTOYCOMA=33, MAYOR=34, MENOR=35, MAYOR_IGUAL=36, MENOR_IGUAL=37, 
		IGUALDAD=38, DIFERENTE=39, VERDADERO=40, FALSO=41, NULO=42, AGREGAR=43, 
		LONGITUD=44, INDICE=45, UNIR=46, LIT_STRING=47, LIT_RUNE=48, LIT_FLOAT=49, 
		LIT_ENTERO=50, IDENTIFICADOR=51, ESPACIOS=52, COMENTARIO=53, COMENTARIO_MULTILINEA=54, 
		IMPRIMIR=55;
	public static final int
		RULE_programa = 0, RULE_funcionMain = 1, RULE_breakStmt = 2, RULE_continueStmt = 3, 
		RULE_returnStmt = 4, RULE_bloque = 5, RULE_sentencia = 6, RULE_ifStmt = 7, 
		RULE_declaracion = 8, RULE_asignacion = 9, RULE_tipo = 10, RULE_switchStmt = 11, 
		RULE_caseBlock = 12, RULE_defaultBlock = 13, RULE_forStmt = 14, RULE_contador = 15, 
		RULE_sliceLiteral = 16, RULE_listLiteral = 17, RULE_sliceElemento = 18, 
		RULE_funcionCall = 19, RULE_imprimir = 20, RULE_expresion = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "funcionMain", "breakStmt", "continueStmt", "returnStmt", 
			"bloque", "sentencia", "ifStmt", "declaracion", "asignacion", "tipo", 
			"switchStmt", "caseBlock", "defaultBlock", "forStmt", "contador", "sliceLiteral", 
			"listLiteral", "sliceElemento", "funcionCall", "imprimir", "expresion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'func'", "'main'", "'break'", "'continue'", "'return'", "'{'", 
			"'}'", "'if'", "'else'", "'var'", "':='", "'switch'", "'case'", "':'", 
			"'default'", "'for'", "','", "'range'", "'.'", "'&&'", "'||'", "'!'", 
			"'+'", "'-'", "'*'", "'/'", "'%'", "'='", "'('", "')'", "'['", "']'", 
			"';'", "'>'", "'<'", "'>='", "'<='", "'=='", "'!='", "'true'", "'false'", 
			"'nil'", "'append'", "'len'", "'slice.Index'", "'strings.Join'", null, 
			null, null, null, null, null, null, null, "'fmt.Println'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, "MAS", 
			"MENOS", "MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", "PARENTESIS_DER", 
			"L_CORCHETE", "R_CORCHETE", "PUNTOYCOMA", "MAYOR", "MENOR", "MAYOR_IGUAL", 
			"MENOR_IGUAL", "IGUALDAD", "DIFERENTE", "VERDADERO", "FALSO", "NULO", 
			"AGREGAR", "LONGITUD", "INDICE", "UNIR", "LIT_STRING", "LIT_RUNE", "LIT_FLOAT", 
			"LIT_ENTERO", "IDENTIFICADOR", "ESPACIOS", "COMENTARIO", "COMENTARIO_MULTILINEA", 
			"IMPRIMIR"
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
			setState(44);
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
			setState(46);
			match(T__0);
			setState(47);
			match(T__1);
			setState(48);
			match(PARENTESIS_IZQ);
			setState(49);
			match(PARENTESIS_DER);
			setState(50);
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
			setState(52);
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
			setState(54);
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
			setState(56);
			match(T__4);
			setState(58);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(57);
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
			setState(60);
			match(T__5);
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 40531299823326520L) != 0)) {
				{
				{
				setState(61);
				sentencia();
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(67);
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
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(69);
				declaracion();
				}
				break;
			case 2:
				{
				setState(70);
				asignacion();
				}
				break;
			case 3:
				{
				setState(71);
				imprimir();
				}
				break;
			case 4:
				{
				setState(72);
				expresion(0);
				}
				break;
			case 5:
				{
				setState(73);
				ifStmt();
				}
				break;
			case 6:
				{
				setState(74);
				switchStmt();
				}
				break;
			case 7:
				{
				setState(75);
				forStmt();
				}
				break;
			case 8:
				{
				setState(76);
				breakStmt();
				}
				break;
			case 9:
				{
				setState(77);
				continueStmt();
				}
				break;
			case 10:
				{
				setState(78);
				returnStmt();
				}
				break;
			}
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOYCOMA) {
				{
				setState(81);
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
			setState(84);
			match(T__7);
			setState(85);
			expresion(0);
			setState(86);
			bloque();
			setState(91);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(87);
				match(T__8);
				setState(88);
				ifStmt();
				}
				break;
			case 2:
				{
				setState(89);
				match(T__8);
				setState(90);
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
			setState(105);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				match(T__9);
				setState(94);
				match(IDENTIFICADOR);
				setState(96);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(95);
					tipo();
					}
					break;
				}
				setState(100);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(98);
					match(IGUAL);
					setState(99);
					expresion(0);
					}
				}

				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				match(IDENTIFICADOR);
				setState(103);
				match(T__10);
				setState(104);
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
			setState(127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				_localctx = new AsignarContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(IDENTIFICADOR);
				setState(108);
				match(IGUAL);
				setState(109);
				expresion(0);
				}
				break;
			case 2:
				_localctx = new AsignarSliceContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(IDENTIFICADOR);
				setState(111);
				match(L_CORCHETE);
				setState(112);
				expresion(0);
				setState(113);
				match(R_CORCHETE);
				setState(114);
				match(IGUAL);
				setState(115);
				expresion(0);
				}
				break;
			case 3:
				_localctx = new AsignarMatrizContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(117);
				match(IDENTIFICADOR);
				setState(118);
				match(L_CORCHETE);
				setState(119);
				expresion(0);
				setState(120);
				match(R_CORCHETE);
				setState(121);
				match(L_CORCHETE);
				setState(122);
				expresion(0);
				setState(123);
				match(R_CORCHETE);
				setState(124);
				match(IGUAL);
				setState(125);
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
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case L_CORCHETE:
				enterOuterAlt(_localctx, 1);
				{
				setState(129);
				match(L_CORCHETE);
				setState(130);
				match(R_CORCHETE);
				setState(131);
				tipo();
				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(132);
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
			setState(135);
			match(T__11);
			setState(136);
			expresion(0);
			setState(137);
			match(T__5);
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(138);
				caseBlock();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(144);
				defaultBlock();
				}
			}

			setState(147);
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
			setState(149);
			match(T__12);
			setState(150);
			expresion(0);
			setState(151);
			match(T__13);
			setState(155);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(152);
					sentencia();
					}
					} 
				}
				setState(157);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(158);
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
			setState(161);
			match(T__14);
			setState(162);
			match(T__13);
			setState(166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(163);
					sentencia();
					}
					} 
				}
				setState(168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			setState(170);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(169);
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
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new ForCondicionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(T__15);
				setState(173);
				expresion(0);
				setState(174);
				bloque();
				}
				break;
			case 2:
				_localctx = new ForClasicoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(176);
				match(T__15);
				setState(179);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(177);
					declaracion();
					}
					break;
				case 2:
					{
					setState(178);
					asignacion();
					}
					break;
				}
				setState(181);
				match(PUNTOYCOMA);
				setState(183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4502502804291584L) != 0)) {
					{
					setState(182);
					expresion(0);
					}
				}

				setState(185);
				match(PUNTOYCOMA);
				setState(188);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
				case 1:
					{
					setState(186);
					asignacion();
					}
					break;
				case 2:
					{
					setState(187);
					contador();
					}
					break;
				}
				setState(190);
				bloque();
				}
				break;
			case 3:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(T__15);
				setState(192);
				match(IDENTIFICADOR);
				setState(193);
				match(T__16);
				setState(194);
				match(IDENTIFICADOR);
				setState(195);
				match(T__10);
				setState(196);
				match(T__17);
				setState(197);
				expresion(0);
				setState(198);
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
			setState(208);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				_localctx = new IncrementoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(202);
				match(IDENTIFICADOR);
				setState(203);
				match(MAS);
				setState(204);
				match(MAS);
				}
				break;
			case 2:
				_localctx = new DecrementoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(205);
				match(IDENTIFICADOR);
				setState(206);
				match(MENOS);
				setState(207);
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
			setState(210);
			match(L_CORCHETE);
			setState(211);
			match(R_CORCHETE);
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==L_CORCHETE || _la==IDENTIFICADOR) {
				{
				setState(212);
				tipo();
				}
			}

			setState(215);
			match(T__5);
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4502502804291648L) != 0)) {
				{
				setState(216);
				sliceElemento();
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(217);
					match(T__16);
					setState(218);
					sliceElemento();
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(226);
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
			setState(228);
			match(T__5);
			setState(237);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4502502804291584L) != 0)) {
				{
				setState(229);
				expresion(0);
				setState(234);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(230);
					match(T__16);
					setState(231);
					expresion(0);
					}
					}
					setState(236);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(239);
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
			setState(244);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(241);
				expresion(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242);
				sliceLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(243);
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
			setState(248);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(246);
				match(IDENTIFICADOR);
				setState(247);
				match(T__18);
				}
				break;
			}
			setState(250);
			match(IDENTIFICADOR);
			setState(251);
			match(PARENTESIS_IZQ);
			setState(260);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4502502804291584L) != 0)) {
				{
				setState(252);
				expresion(0);
				setState(257);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(253);
					match(T__16);
					setState(254);
					expresion(0);
					}
					}
					setState(259);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(262);
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
		enterRule(_localctx, 40, RULE_imprimir);
		int _la;
		try {
			_localctx = new ImprimeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(264);
			match(IMPRIMIR);
			setState(265);
			match(PARENTESIS_IZQ);
			setState(274);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4502502804291584L) != 0)) {
				{
				setState(266);
				expresion(0);
				setState(271);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(267);
					match(T__16);
					setState(268);
					expresion(0);
					}
					}
					setState(273);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(276);
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
		int _startState = 42;
		enterRecursionRule(_localctx, 42, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,32,_ctx) ) {
			case 1:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(279);
				match(T__21);
				setState(280);
				expresion(18);
				}
				break;
			case 2:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(281);
				match(PARENTESIS_IZQ);
				setState(282);
				expresion(0);
				setState(283);
				match(PARENTESIS_DER);
				}
				break;
			case 3:
				{
				_localctx = new SliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(285);
				sliceLiteral();
				}
				break;
			case 4:
				{
				_localctx = new AccesoSliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(286);
				match(IDENTIFICADOR);
				setState(287);
				match(L_CORCHETE);
				setState(288);
				expresion(0);
				setState(289);
				match(R_CORCHETE);
				}
				break;
			case 5:
				{
				_localctx = new FuncionAppendContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				match(AGREGAR);
				setState(292);
				match(PARENTESIS_IZQ);
				setState(293);
				expresion(0);
				setState(294);
				match(T__16);
				setState(295);
				expresion(0);
				setState(296);
				match(PARENTESIS_DER);
				}
				break;
			case 6:
				{
				_localctx = new FuncionLenContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(298);
				match(LONGITUD);
				setState(299);
				match(PARENTESIS_IZQ);
				setState(300);
				expresion(0);
				setState(301);
				match(PARENTESIS_DER);
				}
				break;
			case 7:
				{
				_localctx = new FuncionIndexContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(303);
				match(INDICE);
				setState(304);
				match(PARENTESIS_IZQ);
				setState(305);
				expresion(0);
				setState(306);
				match(T__16);
				setState(307);
				expresion(0);
				setState(308);
				match(PARENTESIS_DER);
				}
				break;
			case 8:
				{
				_localctx = new FuncionJoinContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(310);
				match(UNIR);
				setState(311);
				match(PARENTESIS_IZQ);
				setState(312);
				expresion(0);
				setState(313);
				match(T__16);
				setState(314);
				expresion(0);
				setState(315);
				match(PARENTESIS_DER);
				}
				break;
			case 9:
				{
				_localctx = new AccesoSlice2DContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(317);
				match(IDENTIFICADOR);
				setState(318);
				match(L_CORCHETE);
				setState(319);
				expresion(0);
				setState(320);
				match(R_CORCHETE);
				setState(321);
				match(L_CORCHETE);
				setState(322);
				expresion(0);
				setState(323);
				match(R_CORCHETE);
				}
				break;
			case 10:
				{
				_localctx = new FuncionLlamadaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(325);
				funcionCall();
				}
				break;
			case 11:
				{
				_localctx = new LiteralEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(326);
				match(LIT_ENTERO);
				}
				break;
			case 12:
				{
				_localctx = new LiteralFlotanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(327);
				match(LIT_FLOAT);
				}
				break;
			case 13:
				{
				_localctx = new LiteralRuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(328);
				match(LIT_RUNE);
				}
				break;
			case 14:
				{
				_localctx = new LiteralCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(329);
				match(LIT_STRING);
				}
				break;
			case 15:
				{
				_localctx = new LiteralVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(330);
				match(VERDADERO);
				}
				break;
			case 16:
				{
				_localctx = new LiteralFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(331);
				match(FALSO);
				}
				break;
			case 17:
				{
				_localctx = new LiteralNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(332);
				match(NULO);
				}
				break;
			case 18:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(333);
				match(IDENTIFICADOR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(377);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(375);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
					case 1:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(336);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(337);
						match(MAS);
						setState(338);
						expresion(32);
						}
						break;
					case 2:
						{
						_localctx = new RestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(339);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(340);
						match(MENOS);
						setState(341);
						expresion(31);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(342);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(343);
						match(MULT);
						setState(344);
						expresion(30);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(345);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(346);
						match(DIV);
						setState(347);
						expresion(29);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(348);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(349);
						match(MOD);
						setState(350);
						expresion(28);
						}
						break;
					case 6:
						{
						_localctx = new ComparacionIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(351);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(352);
						match(IGUALDAD);
						setState(353);
						expresion(27);
						}
						break;
					case 7:
						{
						_localctx = new ComparacionDiferenteContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(354);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(355);
						match(DIFERENTE);
						setState(356);
						expresion(26);
						}
						break;
					case 8:
						{
						_localctx = new MayorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(357);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(358);
						match(MAYOR);
						setState(359);
						expresion(25);
						}
						break;
					case 9:
						{
						_localctx = new MenorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(360);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(361);
						match(MENOR);
						setState(362);
						expresion(24);
						}
						break;
					case 10:
						{
						_localctx = new MayorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(363);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(364);
						match(MAYOR_IGUAL);
						setState(365);
						expresion(23);
						}
						break;
					case 11:
						{
						_localctx = new MenorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(366);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(367);
						match(MENOR_IGUAL);
						setState(368);
						expresion(22);
						}
						break;
					case 12:
						{
						_localctx = new AndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(369);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(370);
						match(T__19);
						setState(371);
						expresion(21);
						}
						break;
					case 13:
						{
						_localctx = new OrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(372);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(373);
						match(T__20);
						setState(374);
						expresion(20);
						}
						break;
					}
					} 
				}
				setState(379);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
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
		case 21:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 31);
		case 1:
			return precpred(_ctx, 30);
		case 2:
			return precpred(_ctx, 29);
		case 3:
			return precpred(_ctx, 28);
		case 4:
			return precpred(_ctx, 27);
		case 5:
			return precpred(_ctx, 26);
		case 6:
			return precpred(_ctx, 25);
		case 7:
			return precpred(_ctx, 24);
		case 8:
			return precpred(_ctx, 23);
		case 9:
			return precpred(_ctx, 22);
		case 10:
			return precpred(_ctx, 21);
		case 11:
			return precpred(_ctx, 20);
		case 12:
			return precpred(_ctx, 19);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00017\u017d\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u0004;\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0005\u0005?\b\u0005\n\u0005\f\u0005B\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006P\b\u0006"+
		"\u0001\u0006\u0003\u0006S\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\\\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0003\ba\b\b\u0001\b\u0001\b\u0003\be\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bj\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u0080\b\t\u0001"+
		"\n\u0001\n\u0001\n\u0001\n\u0003\n\u0086\b\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0005\u000b\u008c\b\u000b\n\u000b\f\u000b\u008f\t\u000b"+
		"\u0001\u000b\u0003\u000b\u0092\b\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0005\f\u009a\b\f\n\f\f\f\u009d\t\f\u0001\f\u0003"+
		"\f\u00a0\b\f\u0001\r\u0001\r\u0001\r\u0005\r\u00a5\b\r\n\r\f\r\u00a8\t"+
		"\r\u0001\r\u0003\r\u00ab\b\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00b4\b\u000e\u0001"+
		"\u000e\u0001\u000e\u0003\u000e\u00b8\b\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00bd\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001"+
		"\u000e\u0003\u000e\u00c9\b\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u00d1\b\u000f\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u00d6\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u00dc\b\u0010\n\u0010\f\u0010\u00df\t\u0010"+
		"\u0003\u0010\u00e1\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0005\u0011\u00e9\b\u0011\n\u0011\f\u0011\u00ec"+
		"\t\u0011\u0003\u0011\u00ee\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0003\u0012\u00f5\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0003\u0013\u00f9\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0005\u0013\u0100\b\u0013\n\u0013\f\u0013\u0103\t\u0013\u0003"+
		"\u0013\u0105\b\u0013\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u010e\b\u0014\n\u0014\f\u0014"+
		"\u0111\t\u0014\u0003\u0014\u0113\b\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0003\u0015\u014f\b\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0005\u0015\u0178\b\u0015\n\u0015\f\u0015\u017b\t\u0015\u0001\u0015"+
		"\u0000\u0001*\u0016\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"+
		"\u0016\u0018\u001a\u001c\u001e \"$&(*\u0000\u0000\u01b2\u0000,\u0001\u0000"+
		"\u0000\u0000\u0002.\u0001\u0000\u0000\u0000\u00044\u0001\u0000\u0000\u0000"+
		"\u00066\u0001\u0000\u0000\u0000\b8\u0001\u0000\u0000\u0000\n<\u0001\u0000"+
		"\u0000\u0000\fO\u0001\u0000\u0000\u0000\u000eT\u0001\u0000\u0000\u0000"+
		"\u0010i\u0001\u0000\u0000\u0000\u0012\u007f\u0001\u0000\u0000\u0000\u0014"+
		"\u0085\u0001\u0000\u0000\u0000\u0016\u0087\u0001\u0000\u0000\u0000\u0018"+
		"\u0095\u0001\u0000\u0000\u0000\u001a\u00a1\u0001\u0000\u0000\u0000\u001c"+
		"\u00c8\u0001\u0000\u0000\u0000\u001e\u00d0\u0001\u0000\u0000\u0000 \u00d2"+
		"\u0001\u0000\u0000\u0000\"\u00e4\u0001\u0000\u0000\u0000$\u00f4\u0001"+
		"\u0000\u0000\u0000&\u00f8\u0001\u0000\u0000\u0000(\u0108\u0001\u0000\u0000"+
		"\u0000*\u014e\u0001\u0000\u0000\u0000,-\u0003\u0002\u0001\u0000-\u0001"+
		"\u0001\u0000\u0000\u0000./\u0005\u0001\u0000\u0000/0\u0005\u0002\u0000"+
		"\u000001\u0005\u001d\u0000\u000012\u0005\u001e\u0000\u000023\u0003\n\u0005"+
		"\u00003\u0003\u0001\u0000\u0000\u000045\u0005\u0003\u0000\u00005\u0005"+
		"\u0001\u0000\u0000\u000067\u0005\u0004\u0000\u00007\u0007\u0001\u0000"+
		"\u0000\u00008:\u0005\u0005\u0000\u00009;\u0003*\u0015\u0000:9\u0001\u0000"+
		"\u0000\u0000:;\u0001\u0000\u0000\u0000;\t\u0001\u0000\u0000\u0000<@\u0005"+
		"\u0006\u0000\u0000=?\u0003\f\u0006\u0000>=\u0001\u0000\u0000\u0000?B\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"AC\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0005\u0007\u0000"+
		"\u0000D\u000b\u0001\u0000\u0000\u0000EP\u0003\u0010\b\u0000FP\u0003\u0012"+
		"\t\u0000GP\u0003(\u0014\u0000HP\u0003*\u0015\u0000IP\u0003\u000e\u0007"+
		"\u0000JP\u0003\u0016\u000b\u0000KP\u0003\u001c\u000e\u0000LP\u0003\u0004"+
		"\u0002\u0000MP\u0003\u0006\u0003\u0000NP\u0003\b\u0004\u0000OE\u0001\u0000"+
		"\u0000\u0000OF\u0001\u0000\u0000\u0000OG\u0001\u0000\u0000\u0000OH\u0001"+
		"\u0000\u0000\u0000OI\u0001\u0000\u0000\u0000OJ\u0001\u0000\u0000\u0000"+
		"OK\u0001\u0000\u0000\u0000OL\u0001\u0000\u0000\u0000OM\u0001\u0000\u0000"+
		"\u0000ON\u0001\u0000\u0000\u0000PR\u0001\u0000\u0000\u0000QS\u0005!\u0000"+
		"\u0000RQ\u0001\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000S\r\u0001\u0000"+
		"\u0000\u0000TU\u0005\b\u0000\u0000UV\u0003*\u0015\u0000V[\u0003\n\u0005"+
		"\u0000WX\u0005\t\u0000\u0000X\\\u0003\u000e\u0007\u0000YZ\u0005\t\u0000"+
		"\u0000Z\\\u0003\n\u0005\u0000[W\u0001\u0000\u0000\u0000[Y\u0001\u0000"+
		"\u0000\u0000[\\\u0001\u0000\u0000\u0000\\\u000f\u0001\u0000\u0000\u0000"+
		"]^\u0005\n\u0000\u0000^`\u00053\u0000\u0000_a\u0003\u0014\n\u0000`_\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ad\u0001\u0000\u0000\u0000"+
		"bc\u0005\u001c\u0000\u0000ce\u0003*\u0015\u0000db\u0001\u0000\u0000\u0000"+
		"de\u0001\u0000\u0000\u0000ej\u0001\u0000\u0000\u0000fg\u00053\u0000\u0000"+
		"gh\u0005\u000b\u0000\u0000hj\u0003*\u0015\u0000i]\u0001\u0000\u0000\u0000"+
		"if\u0001\u0000\u0000\u0000j\u0011\u0001\u0000\u0000\u0000kl\u00053\u0000"+
		"\u0000lm\u0005\u001c\u0000\u0000m\u0080\u0003*\u0015\u0000no\u00053\u0000"+
		"\u0000op\u0005\u001f\u0000\u0000pq\u0003*\u0015\u0000qr\u0005 \u0000\u0000"+
		"rs\u0005\u001c\u0000\u0000st\u0003*\u0015\u0000t\u0080\u0001\u0000\u0000"+
		"\u0000uv\u00053\u0000\u0000vw\u0005\u001f\u0000\u0000wx\u0003*\u0015\u0000"+
		"xy\u0005 \u0000\u0000yz\u0005\u001f\u0000\u0000z{\u0003*\u0015\u0000{"+
		"|\u0005 \u0000\u0000|}\u0005\u001c\u0000\u0000}~\u0003*\u0015\u0000~\u0080"+
		"\u0001\u0000\u0000\u0000\u007fk\u0001\u0000\u0000\u0000\u007fn\u0001\u0000"+
		"\u0000\u0000\u007fu\u0001\u0000\u0000\u0000\u0080\u0013\u0001\u0000\u0000"+
		"\u0000\u0081\u0082\u0005\u001f\u0000\u0000\u0082\u0083\u0005 \u0000\u0000"+
		"\u0083\u0086\u0003\u0014\n\u0000\u0084\u0086\u00053\u0000\u0000\u0085"+
		"\u0081\u0001\u0000\u0000\u0000\u0085\u0084\u0001\u0000\u0000\u0000\u0086"+
		"\u0015\u0001\u0000\u0000\u0000\u0087\u0088\u0005\f\u0000\u0000\u0088\u0089"+
		"\u0003*\u0015\u0000\u0089\u008d\u0005\u0006\u0000\u0000\u008a\u008c\u0003"+
		"\u0018\f\u0000\u008b\u008a\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000"+
		"\u0000\u0000\u008d\u008b\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000"+
		"\u0000\u0000\u008e\u0091\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000"+
		"\u0000\u0000\u0090\u0092\u0003\u001a\r\u0000\u0091\u0090\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u0094\u0005\u0007\u0000\u0000\u0094\u0017\u0001\u0000\u0000"+
		"\u0000\u0095\u0096\u0005\r\u0000\u0000\u0096\u0097\u0003*\u0015\u0000"+
		"\u0097\u009b\u0005\u000e\u0000\u0000\u0098\u009a\u0003\f\u0006\u0000\u0099"+
		"\u0098\u0001\u0000\u0000\u0000\u009a\u009d\u0001\u0000\u0000\u0000\u009b"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009f\u0001\u0000\u0000\u0000\u009d\u009b\u0001\u0000\u0000\u0000\u009e"+
		"\u00a0\u0003\u0004\u0002\u0000\u009f\u009e\u0001\u0000\u0000\u0000\u009f"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a0\u0019\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0005\u000f\u0000\u0000\u00a2\u00a6\u0005\u000e\u0000\u0000\u00a3"+
		"\u00a5\u0003\f\u0006\u0000\u00a4\u00a3\u0001\u0000\u0000\u0000\u00a5\u00a8"+
		"\u0001\u0000\u0000\u0000\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a6\u00a7"+
		"\u0001\u0000\u0000\u0000\u00a7\u00aa\u0001\u0000\u0000\u0000\u00a8\u00a6"+
		"\u0001\u0000\u0000\u0000\u00a9\u00ab\u0003\u0004\u0002\u0000\u00aa\u00a9"+
		"\u0001\u0000\u0000\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u001b"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0005\u0010\u0000\u0000\u00ad\u00ae"+
		"\u0003*\u0015\u0000\u00ae\u00af\u0003\n\u0005\u0000\u00af\u00c9\u0001"+
		"\u0000\u0000\u0000\u00b0\u00b3\u0005\u0010\u0000\u0000\u00b1\u00b4\u0003"+
		"\u0010\b\u0000\u00b2\u00b4\u0003\u0012\t\u0000\u00b3\u00b1\u0001\u0000"+
		"\u0000\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b3\u00b4\u0001\u0000"+
		"\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b7\u0005!\u0000"+
		"\u0000\u00b6\u00b8\u0003*\u0015\u0000\u00b7\u00b6\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00b9\u0001\u0000\u0000\u0000"+
		"\u00b9\u00bc\u0005!\u0000\u0000\u00ba\u00bd\u0003\u0012\t\u0000\u00bb"+
		"\u00bd\u0003\u001e\u000f\u0000\u00bc\u00ba\u0001\u0000\u0000\u0000\u00bc"+
		"\u00bb\u0001\u0000\u0000\u0000\u00bc\u00bd\u0001\u0000\u0000\u0000\u00bd"+
		"\u00be\u0001\u0000\u0000\u0000\u00be\u00c9\u0003\n\u0005\u0000\u00bf\u00c0"+
		"\u0005\u0010\u0000\u0000\u00c0\u00c1\u00053\u0000\u0000\u00c1\u00c2\u0005"+
		"\u0011\u0000\u0000\u00c2\u00c3\u00053\u0000\u0000\u00c3\u00c4\u0005\u000b"+
		"\u0000\u0000\u00c4\u00c5\u0005\u0012\u0000\u0000\u00c5\u00c6\u0003*\u0015"+
		"\u0000\u00c6\u00c7\u0003\n\u0005\u0000\u00c7\u00c9\u0001\u0000\u0000\u0000"+
		"\u00c8\u00ac\u0001\u0000\u0000\u0000\u00c8\u00b0\u0001\u0000\u0000\u0000"+
		"\u00c8\u00bf\u0001\u0000\u0000\u0000\u00c9\u001d\u0001\u0000\u0000\u0000"+
		"\u00ca\u00cb\u00053\u0000\u0000\u00cb\u00cc\u0005\u0017\u0000\u0000\u00cc"+
		"\u00d1\u0005\u0017\u0000\u0000\u00cd\u00ce\u00053\u0000\u0000\u00ce\u00cf"+
		"\u0005\u0018\u0000\u0000\u00cf\u00d1\u0005\u0018\u0000\u0000\u00d0\u00ca"+
		"\u0001\u0000\u0000\u0000\u00d0\u00cd\u0001\u0000\u0000\u0000\u00d1\u001f"+
		"\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u001f\u0000\u0000\u00d3\u00d5"+
		"\u0005 \u0000\u0000\u00d4\u00d6\u0003\u0014\n\u0000\u00d5\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001"+
		"\u0000\u0000\u0000\u00d7\u00e0\u0005\u0006\u0000\u0000\u00d8\u00dd\u0003"+
		"$\u0012\u0000\u00d9\u00da\u0005\u0011\u0000\u0000\u00da\u00dc\u0003$\u0012"+
		"\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00df\u0001\u0000\u0000"+
		"\u0000\u00dd\u00db\u0001\u0000\u0000\u0000\u00dd\u00de\u0001\u0000\u0000"+
		"\u0000\u00de\u00e1\u0001\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000"+
		"\u0000\u00e0\u00d8\u0001\u0000\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e2\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005\u0007\u0000"+
		"\u0000\u00e3!\u0001\u0000\u0000\u0000\u00e4\u00ed\u0005\u0006\u0000\u0000"+
		"\u00e5\u00ea\u0003*\u0015\u0000\u00e6\u00e7\u0005\u0011\u0000\u0000\u00e7"+
		"\u00e9\u0003*\u0015\u0000\u00e8\u00e6\u0001\u0000\u0000\u0000\u00e9\u00ec"+
		"\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea\u00eb"+
		"\u0001\u0000\u0000\u0000\u00eb\u00ee\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ed\u00e5\u0001\u0000\u0000\u0000\u00ed\u00ee"+
		"\u0001\u0000\u0000\u0000\u00ee\u00ef\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0005\u0007\u0000\u0000\u00f0#\u0001\u0000\u0000\u0000\u00f1\u00f5\u0003"+
		"*\u0015\u0000\u00f2\u00f5\u0003 \u0010\u0000\u00f3\u00f5\u0003\"\u0011"+
		"\u0000\u00f4\u00f1\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f3\u0001\u0000\u0000\u0000\u00f5%\u0001\u0000\u0000\u0000"+
		"\u00f6\u00f7\u00053\u0000\u0000\u00f7\u00f9\u0005\u0013\u0000\u0000\u00f8"+
		"\u00f6\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fb\u00053\u0000\u0000\u00fb\u0104"+
		"\u0005\u001d\u0000\u0000\u00fc\u0101\u0003*\u0015\u0000\u00fd\u00fe\u0005"+
		"\u0011\u0000\u0000\u00fe\u0100\u0003*\u0015\u0000\u00ff\u00fd\u0001\u0000"+
		"\u0000\u0000\u0100\u0103\u0001\u0000\u0000\u0000\u0101\u00ff\u0001\u0000"+
		"\u0000\u0000\u0101\u0102\u0001\u0000\u0000\u0000\u0102\u0105\u0001\u0000"+
		"\u0000\u0000\u0103\u0101\u0001\u0000\u0000\u0000\u0104\u00fc\u0001\u0000"+
		"\u0000\u0000\u0104\u0105\u0001\u0000\u0000\u0000\u0105\u0106\u0001\u0000"+
		"\u0000\u0000\u0106\u0107\u0005\u001e\u0000\u0000\u0107\'\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u00057\u0000\u0000\u0109\u0112\u0005\u001d\u0000\u0000"+
		"\u010a\u010f\u0003*\u0015\u0000\u010b\u010c\u0005\u0011\u0000\u0000\u010c"+
		"\u010e\u0003*\u0015\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u0111"+
		"\u0001\u0000\u0000\u0000\u010f\u010d\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0001\u0000\u0000\u0000\u0110\u0113\u0001\u0000\u0000\u0000\u0111\u010f"+
		"\u0001\u0000\u0000\u0000\u0112\u010a\u0001\u0000\u0000\u0000\u0112\u0113"+
		"\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000\u0000\u0114\u0115"+
		"\u0005\u001e\u0000\u0000\u0115)\u0001\u0000\u0000\u0000\u0116\u0117\u0006"+
		"\u0015\uffff\uffff\u0000\u0117\u0118\u0005\u0016\u0000\u0000\u0118\u014f"+
		"\u0003*\u0015\u0012\u0119\u011a\u0005\u001d\u0000\u0000\u011a\u011b\u0003"+
		"*\u0015\u0000\u011b\u011c\u0005\u001e\u0000\u0000\u011c\u014f\u0001\u0000"+
		"\u0000\u0000\u011d\u014f\u0003 \u0010\u0000\u011e\u011f\u00053\u0000\u0000"+
		"\u011f\u0120\u0005\u001f\u0000\u0000\u0120\u0121\u0003*\u0015\u0000\u0121"+
		"\u0122\u0005 \u0000\u0000\u0122\u014f\u0001\u0000\u0000\u0000\u0123\u0124"+
		"\u0005+\u0000\u0000\u0124\u0125\u0005\u001d\u0000\u0000\u0125\u0126\u0003"+
		"*\u0015\u0000\u0126\u0127\u0005\u0011\u0000\u0000\u0127\u0128\u0003*\u0015"+
		"\u0000\u0128\u0129\u0005\u001e\u0000\u0000\u0129\u014f\u0001\u0000\u0000"+
		"\u0000\u012a\u012b\u0005,\u0000\u0000\u012b\u012c\u0005\u001d\u0000\u0000"+
		"\u012c\u012d\u0003*\u0015\u0000\u012d\u012e\u0005\u001e\u0000\u0000\u012e"+
		"\u014f\u0001\u0000\u0000\u0000\u012f\u0130\u0005-\u0000\u0000\u0130\u0131"+
		"\u0005\u001d\u0000\u0000\u0131\u0132\u0003*\u0015\u0000\u0132\u0133\u0005"+
		"\u0011\u0000\u0000\u0133\u0134\u0003*\u0015\u0000\u0134\u0135\u0005\u001e"+
		"\u0000\u0000\u0135\u014f\u0001\u0000\u0000\u0000\u0136\u0137\u0005.\u0000"+
		"\u0000\u0137\u0138\u0005\u001d\u0000\u0000\u0138\u0139\u0003*\u0015\u0000"+
		"\u0139\u013a\u0005\u0011\u0000\u0000\u013a\u013b\u0003*\u0015\u0000\u013b"+
		"\u013c\u0005\u001e\u0000\u0000\u013c\u014f\u0001\u0000\u0000\u0000\u013d"+
		"\u013e\u00053\u0000\u0000\u013e\u013f\u0005\u001f\u0000\u0000\u013f\u0140"+
		"\u0003*\u0015\u0000\u0140\u0141\u0005 \u0000\u0000\u0141\u0142\u0005\u001f"+
		"\u0000\u0000\u0142\u0143\u0003*\u0015\u0000\u0143\u0144\u0005 \u0000\u0000"+
		"\u0144\u014f\u0001\u0000\u0000\u0000\u0145\u014f\u0003&\u0013\u0000\u0146"+
		"\u014f\u00052\u0000\u0000\u0147\u014f\u00051\u0000\u0000\u0148\u014f\u0005"+
		"0\u0000\u0000\u0149\u014f\u0005/\u0000\u0000\u014a\u014f\u0005(\u0000"+
		"\u0000\u014b\u014f\u0005)\u0000\u0000\u014c\u014f\u0005*\u0000\u0000\u014d"+
		"\u014f\u00053\u0000\u0000\u014e\u0116\u0001\u0000\u0000\u0000\u014e\u0119"+
		"\u0001\u0000\u0000\u0000\u014e\u011d\u0001\u0000\u0000\u0000\u014e\u011e"+
		"\u0001\u0000\u0000\u0000\u014e\u0123\u0001\u0000\u0000\u0000\u014e\u012a"+
		"\u0001\u0000\u0000\u0000\u014e\u012f\u0001\u0000\u0000\u0000\u014e\u0136"+
		"\u0001\u0000\u0000\u0000\u014e\u013d\u0001\u0000\u0000\u0000\u014e\u0145"+
		"\u0001\u0000\u0000\u0000\u014e\u0146\u0001\u0000\u0000\u0000\u014e\u0147"+
		"\u0001\u0000\u0000\u0000\u014e\u0148\u0001\u0000\u0000\u0000\u014e\u0149"+
		"\u0001\u0000\u0000\u0000\u014e\u014a\u0001\u0000\u0000\u0000\u014e\u014b"+
		"\u0001\u0000\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014d"+
		"\u0001\u0000\u0000\u0000\u014f\u0179\u0001\u0000\u0000\u0000\u0150\u0151"+
		"\n\u001f\u0000\u0000\u0151\u0152\u0005\u0017\u0000\u0000\u0152\u0178\u0003"+
		"*\u0015 \u0153\u0154\n\u001e\u0000\u0000\u0154\u0155\u0005\u0018\u0000"+
		"\u0000\u0155\u0178\u0003*\u0015\u001f\u0156\u0157\n\u001d\u0000\u0000"+
		"\u0157\u0158\u0005\u0019\u0000\u0000\u0158\u0178\u0003*\u0015\u001e\u0159"+
		"\u015a\n\u001c\u0000\u0000\u015a\u015b\u0005\u001a\u0000\u0000\u015b\u0178"+
		"\u0003*\u0015\u001d\u015c\u015d\n\u001b\u0000\u0000\u015d\u015e\u0005"+
		"\u001b\u0000\u0000\u015e\u0178\u0003*\u0015\u001c\u015f\u0160\n\u001a"+
		"\u0000\u0000\u0160\u0161\u0005&\u0000\u0000\u0161\u0178\u0003*\u0015\u001b"+
		"\u0162\u0163\n\u0019\u0000\u0000\u0163\u0164\u0005\'\u0000\u0000\u0164"+
		"\u0178\u0003*\u0015\u001a\u0165\u0166\n\u0018\u0000\u0000\u0166\u0167"+
		"\u0005\"\u0000\u0000\u0167\u0178\u0003*\u0015\u0019\u0168\u0169\n\u0017"+
		"\u0000\u0000\u0169\u016a\u0005#\u0000\u0000\u016a\u0178\u0003*\u0015\u0018"+
		"\u016b\u016c\n\u0016\u0000\u0000\u016c\u016d\u0005$\u0000\u0000\u016d"+
		"\u0178\u0003*\u0015\u0017\u016e\u016f\n\u0015\u0000\u0000\u016f\u0170"+
		"\u0005%\u0000\u0000\u0170\u0178\u0003*\u0015\u0016\u0171\u0172\n\u0014"+
		"\u0000\u0000\u0172\u0173\u0005\u0014\u0000\u0000\u0173\u0178\u0003*\u0015"+
		"\u0015\u0174\u0175\n\u0013\u0000\u0000\u0175\u0176\u0005\u0015\u0000\u0000"+
		"\u0176\u0178\u0003*\u0015\u0014\u0177\u0150\u0001\u0000\u0000\u0000\u0177"+
		"\u0153\u0001\u0000\u0000\u0000\u0177\u0156\u0001\u0000\u0000\u0000\u0177"+
		"\u0159\u0001\u0000\u0000\u0000\u0177\u015c\u0001\u0000\u0000\u0000\u0177"+
		"\u015f\u0001\u0000\u0000\u0000\u0177\u0162\u0001\u0000\u0000\u0000\u0177"+
		"\u0165\u0001\u0000\u0000\u0000\u0177\u0168\u0001\u0000\u0000\u0000\u0177"+
		"\u016b\u0001\u0000\u0000\u0000\u0177\u016e\u0001\u0000\u0000\u0000\u0177"+
		"\u0171\u0001\u0000\u0000\u0000\u0177\u0174\u0001\u0000\u0000\u0000\u0178"+
		"\u017b\u0001\u0000\u0000\u0000\u0179\u0177\u0001\u0000\u0000\u0000\u0179"+
		"\u017a\u0001\u0000\u0000\u0000\u017a+\u0001\u0000\u0000\u0000\u017b\u0179"+
		"\u0001\u0000\u0000\u0000#:@OR[`di\u007f\u0085\u008d\u0091\u009b\u009f"+
		"\u00a6\u00aa\u00b3\u00b7\u00bc\u00c8\u00d0\u00d5\u00dd\u00e0\u00ea\u00ed"+
		"\u00f4\u00f8\u0101\u0104\u010f\u0112\u014e\u0177\u0179";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}