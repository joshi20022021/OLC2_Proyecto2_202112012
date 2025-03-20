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
		IGUALDAD=37, DIFERENTE=38, VERDADERO=39, FALSO=40, NULO=41, LIT_STRING=42, 
		LIT_RUNE=43, LIT_FLOAT=44, LIT_ENTERO=45, IDENTIFICADOR=46, ESPACIOS=47, 
		COMENTARIO=48, COMENTARIO_MULTILINEA=49, IMPRIMIR=50;
	public static final int
		RULE_programa = 0, RULE_funcionMain = 1, RULE_breakStmt = 2, RULE_continueStmt = 3, 
		RULE_returnStmt = 4, RULE_bloque = 5, RULE_sentencia = 6, RULE_ifStmt = 7, 
		RULE_declaracion = 8, RULE_asignacion = 9, RULE_tipo = 10, RULE_switchStmt = 11, 
		RULE_caseBlock = 12, RULE_defaultBlock = 13, RULE_forStmt = 14, RULE_contador = 15, 
		RULE_sliceLiteral = 16, RULE_imprimir = 17, RULE_expresion = 18;
	private static String[] makeRuleNames() {
		return new String[] {
			"programa", "funcionMain", "breakStmt", "continueStmt", "returnStmt", 
			"bloque", "sentencia", "ifStmt", "declaracion", "asignacion", "tipo", 
			"switchStmt", "caseBlock", "defaultBlock", "forStmt", "contador", "sliceLiteral", 
			"imprimir", "expresion"
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
			null, null, null, null, null, null, null, null, "'fmt.Println'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "MAS", "MENOS", 
			"MULT", "DIV", "MOD", "IGUAL", "PARENTESIS_IZQ", "PARENTESIS_DER", "L_CORCHETE", 
			"R_CORCHETE", "PUNTOYCOMA", "MAYOR", "MENOR", "MAYOR_IGUAL", "MENOR_IGUAL", 
			"IGUALDAD", "DIFERENTE", "VERDADERO", "FALSO", "NULO", "LIT_STRING", 
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
			setState(38);
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
			setState(40);
			match(T__0);
			setState(41);
			match(T__1);
			setState(42);
			match(PARENTESIS_IZQ);
			setState(43);
			match(PARENTESIS_DER);
			setState(44);
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
			setState(46);
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
			setState(48);
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
			setState(50);
			match(T__4);
			setState(52);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				{
				setState(51);
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
			setState(54);
			match(T__5);
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1266088983729464L) != 0)) {
				{
				{
				setState(55);
				sentencia();
				}
				}
				setState(60);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(61);
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
			setState(73);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(63);
				declaracion();
				}
				break;
			case 2:
				{
				setState(64);
				asignacion();
				}
				break;
			case 3:
				{
				setState(65);
				imprimir();
				}
				break;
			case 4:
				{
				setState(66);
				expresion(0);
				}
				break;
			case 5:
				{
				setState(67);
				ifStmt();
				}
				break;
			case 6:
				{
				setState(68);
				switchStmt();
				}
				break;
			case 7:
				{
				setState(69);
				forStmt();
				}
				break;
			case 8:
				{
				setState(70);
				breakStmt();
				}
				break;
			case 9:
				{
				setState(71);
				continueStmt();
				}
				break;
			case 10:
				{
				setState(72);
				returnStmt();
				}
				break;
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PUNTOYCOMA) {
				{
				setState(75);
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
			setState(78);
			match(T__7);
			setState(79);
			expresion(0);
			setState(80);
			bloque();
			setState(85);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(81);
				match(T__8);
				setState(82);
				ifStmt();
				}
				break;
			case 2:
				{
				setState(83);
				match(T__8);
				setState(84);
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
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__9:
				enterOuterAlt(_localctx, 1);
				{
				setState(87);
				match(T__9);
				setState(88);
				match(IDENTIFICADOR);
				setState(90);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
				case 1:
					{
					setState(89);
					tipo();
					}
					break;
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IGUAL) {
					{
					setState(92);
					match(IGUAL);
					setState(93);
					expresion(0);
					}
				}

				}
				break;
			case IDENTIFICADOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(IDENTIFICADOR);
				setState(97);
				match(T__10);
				setState(98);
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

	public final AsignacionContext asignacion() throws RecognitionException {
		AsignacionContext _localctx = new AsignacionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_asignacion);
		try {
			_localctx = new AsignarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(IDENTIFICADOR);
			setState(102);
			match(IGUAL);
			setState(103);
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
			setState(105);
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
			setState(107);
			match(T__11);
			setState(108);
			expresion(0);
			setState(109);
			match(T__5);
			setState(113);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(110);
				caseBlock();
				}
				}
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14) {
				{
				setState(116);
				defaultBlock();
				}
			}

			setState(119);
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
			setState(121);
			match(T__12);
			setState(122);
			expresion(0);
			setState(123);
			match(T__13);
			setState(127);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(124);
					sentencia();
					}
					} 
				}
				setState(129);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			setState(131);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(130);
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
			setState(133);
			match(T__14);
			setState(134);
			match(T__13);
			setState(138);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(135);
					sentencia();
					}
					} 
				}
				setState(140);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(141);
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
			setState(172);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				_localctx = new ForCondicionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				match(T__15);
				setState(145);
				expresion(0);
				setState(146);
				bloque();
				}
				break;
			case 2:
				_localctx = new ForClasicoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(148);
				match(T__15);
				setState(151);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(149);
					declaracion();
					}
					break;
				case 2:
					{
					setState(150);
					asignacion();
					}
					break;
				}
				setState(153);
				match(PUNTOYCOMA);
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140189076815872L) != 0)) {
					{
					setState(154);
					expresion(0);
					}
				}

				setState(157);
				match(PUNTOYCOMA);
				setState(160);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(158);
					asignacion();
					}
					break;
				case 2:
					{
					setState(159);
					contador();
					}
					break;
				}
				setState(162);
				bloque();
				}
				break;
			case 3:
				_localctx = new ForRangeContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(163);
				match(T__15);
				setState(164);
				match(IDENTIFICADOR);
				setState(165);
				match(T__16);
				setState(166);
				match(IDENTIFICADOR);
				setState(167);
				match(T__10);
				setState(168);
				match(T__17);
				setState(169);
				expresion(0);
				setState(170);
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
			setState(180);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				_localctx = new IncrementoContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(174);
				match(IDENTIFICADOR);
				setState(175);
				match(MAS);
				setState(176);
				match(MAS);
				}
				break;
			case 2:
				_localctx = new DecrementoContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177);
				match(IDENTIFICADOR);
				setState(178);
				match(MENOS);
				setState(179);
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
		public List<ExpresionContext> expresion() {
			return getRuleContexts(ExpresionContext.class);
		}
		public ExpresionContext expresion(int i) {
			return getRuleContext(ExpresionContext.class,i);
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
			setState(182);
			match(L_CORCHETE);
			setState(183);
			match(R_CORCHETE);
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFICADOR) {
				{
				setState(184);
				match(IDENTIFICADOR);
				}
			}

			setState(187);
			match(T__5);
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140189076815872L) != 0)) {
				{
				setState(188);
				expresion(0);
				setState(193);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(189);
					match(T__16);
					setState(190);
					expresion(0);
					}
					}
					setState(195);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(198);
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
		enterRule(_localctx, 34, RULE_imprimir);
		int _la;
		try {
			_localctx = new ImprimeContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(200);
			match(IMPRIMIR);
			setState(201);
			match(PARENTESIS_IZQ);
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 140189076815872L) != 0)) {
				{
				setState(202);
				expresion(0);
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__16) {
					{
					{
					setState(203);
					match(T__16);
					setState(204);
					expresion(0);
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(212);
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
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_expresion, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(230);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				{
				_localctx = new NotContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(215);
				match(T__20);
				setState(216);
				expresion(11);
				}
				break;
			case PARENTESIS_IZQ:
				{
				_localctx = new ParentesisContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(217);
				match(PARENTESIS_IZQ);
				setState(218);
				expresion(0);
				setState(219);
				match(PARENTESIS_DER);
				}
				break;
			case L_CORCHETE:
				{
				_localctx = new SliceContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(221);
				sliceLiteral();
				}
				break;
			case LIT_ENTERO:
				{
				_localctx = new LiteralEnteroContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(222);
				match(LIT_ENTERO);
				}
				break;
			case LIT_FLOAT:
				{
				_localctx = new LiteralFlotanteContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(223);
				match(LIT_FLOAT);
				}
				break;
			case LIT_RUNE:
				{
				_localctx = new LiteralRuneContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(224);
				match(LIT_RUNE);
				}
				break;
			case LIT_STRING:
				{
				_localctx = new LiteralCadenaContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(225);
				match(LIT_STRING);
				}
				break;
			case VERDADERO:
				{
				_localctx = new LiteralVerdaderoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(226);
				match(VERDADERO);
				}
				break;
			case FALSO:
				{
				_localctx = new LiteralFalsoContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(227);
				match(FALSO);
				}
				break;
			case NULO:
				{
				_localctx = new LiteralNuloContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(228);
				match(NULO);
				}
				break;
			case IDENTIFICADOR:
				{
				_localctx = new IdentificadorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(229);
				match(IDENTIFICADOR);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(273);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(271);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
					case 1:
						{
						_localctx = new SumaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(232);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(233);
						match(MAS);
						setState(234);
						expresion(25);
						}
						break;
					case 2:
						{
						_localctx = new RestaContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(235);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(236);
						match(MENOS);
						setState(237);
						expresion(24);
						}
						break;
					case 3:
						{
						_localctx = new MultiplicacionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(238);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(239);
						match(MULT);
						setState(240);
						expresion(23);
						}
						break;
					case 4:
						{
						_localctx = new DivisionContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(241);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(242);
						match(DIV);
						setState(243);
						expresion(22);
						}
						break;
					case 5:
						{
						_localctx = new ModuloContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(244);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(245);
						match(MOD);
						setState(246);
						expresion(21);
						}
						break;
					case 6:
						{
						_localctx = new ComparacionIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(247);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(248);
						match(IGUALDAD);
						setState(249);
						expresion(20);
						}
						break;
					case 7:
						{
						_localctx = new ComparacionDiferenteContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(250);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(251);
						match(DIFERENTE);
						setState(252);
						expresion(19);
						}
						break;
					case 8:
						{
						_localctx = new MayorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(253);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(254);
						match(MAYOR);
						setState(255);
						expresion(18);
						}
						break;
					case 9:
						{
						_localctx = new MenorQueContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(256);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(257);
						match(MENOR);
						setState(258);
						expresion(17);
						}
						break;
					case 10:
						{
						_localctx = new MayorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(259);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(260);
						match(MAYOR_IGUAL);
						setState(261);
						expresion(16);
						}
						break;
					case 11:
						{
						_localctx = new MenorOIgualContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(262);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(263);
						match(MENOR_IGUAL);
						setState(264);
						expresion(15);
						}
						break;
					case 12:
						{
						_localctx = new AndContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(265);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(266);
						match(T__18);
						setState(267);
						expresion(14);
						}
						break;
					case 13:
						{
						_localctx = new OrContext(new ExpresionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expresion);
						setState(268);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(269);
						match(T__19);
						setState(270);
						expresion(13);
						}
						break;
					}
					} 
				}
				setState(275);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
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
		case 18:
			return expresion_sempred((ExpresionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expresion_sempred(ExpresionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 24);
		case 1:
			return precpred(_ctx, 23);
		case 2:
			return precpred(_ctx, 22);
		case 3:
			return precpred(_ctx, 21);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 19);
		case 6:
			return precpred(_ctx, 18);
		case 7:
			return precpred(_ctx, 17);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 15);
		case 10:
			return precpred(_ctx, 14);
		case 11:
			return precpred(_ctx, 13);
		case 12:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00012\u0115\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0004\u0001\u0004\u0003\u00045\b\u0004\u0001\u0005\u0001\u0005"+
		"\u0005\u00059\b\u0005\n\u0005\f\u0005<\t\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006J\b\u0006"+
		"\u0001\u0006\u0003\u0006M\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007V\b\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0003\b[\b\b\u0001\b\u0001\b\u0003\b_\b\b\u0001"+
		"\b\u0001\b\u0001\b\u0003\bd\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"p\b\u000b\n\u000b\f\u000bs\t\u000b\u0001\u000b\u0003\u000bv\b\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0005\f~\b\f\n\f\f"+
		"\f\u0081\t\f\u0001\f\u0003\f\u0084\b\f\u0001\r\u0001\r\u0001\r\u0005\r"+
		"\u0089\b\r\n\r\f\r\u008c\t\r\u0001\r\u0003\r\u008f\b\r\u0001\u000e\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u0098\b\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u009c\b\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00a1\b\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u00ad\b\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f"+
		"\u00b5\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00ba\b"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u00c0"+
		"\b\u0010\n\u0010\f\u0010\u00c3\t\u0010\u0003\u0010\u00c5\b\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001"+
		"\u0011\u0005\u0011\u00ce\b\u0011\n\u0011\f\u0011\u00d1\t\u0011\u0003\u0011"+
		"\u00d3\b\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u00e7\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u0110\b\u0012\n\u0012\f\u0012\u0113\t\u0012\u0001\u0012\u0000"+
		"\u0001$\u0013\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$\u0000\u0000\u013c\u0000&\u0001\u0000\u0000"+
		"\u0000\u0002(\u0001\u0000\u0000\u0000\u0004.\u0001\u0000\u0000\u0000\u0006"+
		"0\u0001\u0000\u0000\u0000\b2\u0001\u0000\u0000\u0000\n6\u0001\u0000\u0000"+
		"\u0000\fI\u0001\u0000\u0000\u0000\u000eN\u0001\u0000\u0000\u0000\u0010"+
		"c\u0001\u0000\u0000\u0000\u0012e\u0001\u0000\u0000\u0000\u0014i\u0001"+
		"\u0000\u0000\u0000\u0016k\u0001\u0000\u0000\u0000\u0018y\u0001\u0000\u0000"+
		"\u0000\u001a\u0085\u0001\u0000\u0000\u0000\u001c\u00ac\u0001\u0000\u0000"+
		"\u0000\u001e\u00b4\u0001\u0000\u0000\u0000 \u00b6\u0001\u0000\u0000\u0000"+
		"\"\u00c8\u0001\u0000\u0000\u0000$\u00e6\u0001\u0000\u0000\u0000&\'\u0003"+
		"\u0002\u0001\u0000\'\u0001\u0001\u0000\u0000\u0000()\u0005\u0001\u0000"+
		"\u0000)*\u0005\u0002\u0000\u0000*+\u0005\u001c\u0000\u0000+,\u0005\u001d"+
		"\u0000\u0000,-\u0003\n\u0005\u0000-\u0003\u0001\u0000\u0000\u0000./\u0005"+
		"\u0003\u0000\u0000/\u0005\u0001\u0000\u0000\u000001\u0005\u0004\u0000"+
		"\u00001\u0007\u0001\u0000\u0000\u000024\u0005\u0005\u0000\u000035\u0003"+
		"$\u0012\u000043\u0001\u0000\u0000\u000045\u0001\u0000\u0000\u00005\t\u0001"+
		"\u0000\u0000\u00006:\u0005\u0006\u0000\u000079\u0003\f\u0006\u000087\u0001"+
		"\u0000\u0000\u00009<\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000\u0000"+
		":;\u0001\u0000\u0000\u0000;=\u0001\u0000\u0000\u0000<:\u0001\u0000\u0000"+
		"\u0000=>\u0005\u0007\u0000\u0000>\u000b\u0001\u0000\u0000\u0000?J\u0003"+
		"\u0010\b\u0000@J\u0003\u0012\t\u0000AJ\u0003\"\u0011\u0000BJ\u0003$\u0012"+
		"\u0000CJ\u0003\u000e\u0007\u0000DJ\u0003\u0016\u000b\u0000EJ\u0003\u001c"+
		"\u000e\u0000FJ\u0003\u0004\u0002\u0000GJ\u0003\u0006\u0003\u0000HJ\u0003"+
		"\b\u0004\u0000I?\u0001\u0000\u0000\u0000I@\u0001\u0000\u0000\u0000IA\u0001"+
		"\u0000\u0000\u0000IB\u0001\u0000\u0000\u0000IC\u0001\u0000\u0000\u0000"+
		"ID\u0001\u0000\u0000\u0000IE\u0001\u0000\u0000\u0000IF\u0001\u0000\u0000"+
		"\u0000IG\u0001\u0000\u0000\u0000IH\u0001\u0000\u0000\u0000JL\u0001\u0000"+
		"\u0000\u0000KM\u0005 \u0000\u0000LK\u0001\u0000\u0000\u0000LM\u0001\u0000"+
		"\u0000\u0000M\r\u0001\u0000\u0000\u0000NO\u0005\b\u0000\u0000OP\u0003"+
		"$\u0012\u0000PU\u0003\n\u0005\u0000QR\u0005\t\u0000\u0000RV\u0003\u000e"+
		"\u0007\u0000ST\u0005\t\u0000\u0000TV\u0003\n\u0005\u0000UQ\u0001\u0000"+
		"\u0000\u0000US\u0001\u0000\u0000\u0000UV\u0001\u0000\u0000\u0000V\u000f"+
		"\u0001\u0000\u0000\u0000WX\u0005\n\u0000\u0000XZ\u0005.\u0000\u0000Y["+
		"\u0003\u0014\n\u0000ZY\u0001\u0000\u0000\u0000Z[\u0001\u0000\u0000\u0000"+
		"[^\u0001\u0000\u0000\u0000\\]\u0005\u001b\u0000\u0000]_\u0003$\u0012\u0000"+
		"^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_d\u0001\u0000\u0000"+
		"\u0000`a\u0005.\u0000\u0000ab\u0005\u000b\u0000\u0000bd\u0003$\u0012\u0000"+
		"cW\u0001\u0000\u0000\u0000c`\u0001\u0000\u0000\u0000d\u0011\u0001\u0000"+
		"\u0000\u0000ef\u0005.\u0000\u0000fg\u0005\u001b\u0000\u0000gh\u0003$\u0012"+
		"\u0000h\u0013\u0001\u0000\u0000\u0000ij\u0005.\u0000\u0000j\u0015\u0001"+
		"\u0000\u0000\u0000kl\u0005\f\u0000\u0000lm\u0003$\u0012\u0000mq\u0005"+
		"\u0006\u0000\u0000np\u0003\u0018\f\u0000on\u0001\u0000\u0000\u0000ps\u0001"+
		"\u0000\u0000\u0000qo\u0001\u0000\u0000\u0000qr\u0001\u0000\u0000\u0000"+
		"ru\u0001\u0000\u0000\u0000sq\u0001\u0000\u0000\u0000tv\u0003\u001a\r\u0000"+
		"ut\u0001\u0000\u0000\u0000uv\u0001\u0000\u0000\u0000vw\u0001\u0000\u0000"+
		"\u0000wx\u0005\u0007\u0000\u0000x\u0017\u0001\u0000\u0000\u0000yz\u0005"+
		"\r\u0000\u0000z{\u0003$\u0012\u0000{\u007f\u0005\u000e\u0000\u0000|~\u0003"+
		"\f\u0006\u0000}|\u0001\u0000\u0000\u0000~\u0081\u0001\u0000\u0000\u0000"+
		"\u007f}\u0001\u0000\u0000\u0000\u007f\u0080\u0001\u0000\u0000\u0000\u0080"+
		"\u0083\u0001\u0000\u0000\u0000\u0081\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0084\u0003\u0004\u0002\u0000\u0083\u0082\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u0001\u0000\u0000\u0000\u0084\u0019\u0001\u0000\u0000\u0000\u0085"+
		"\u0086\u0005\u000f\u0000\u0000\u0086\u008a\u0005\u000e\u0000\u0000\u0087"+
		"\u0089\u0003\f\u0006\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089\u008c"+
		"\u0001\u0000\u0000\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b"+
		"\u0001\u0000\u0000\u0000\u008b\u008e\u0001\u0000\u0000\u0000\u008c\u008a"+
		"\u0001\u0000\u0000\u0000\u008d\u008f\u0003\u0004\u0002\u0000\u008e\u008d"+
		"\u0001\u0000\u0000\u0000\u008e\u008f\u0001\u0000\u0000\u0000\u008f\u001b"+
		"\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0010\u0000\u0000\u0091\u0092"+
		"\u0003$\u0012\u0000\u0092\u0093\u0003\n\u0005\u0000\u0093\u00ad\u0001"+
		"\u0000\u0000\u0000\u0094\u0097\u0005\u0010\u0000\u0000\u0095\u0098\u0003"+
		"\u0010\b\u0000\u0096\u0098\u0003\u0012\t\u0000\u0097\u0095\u0001\u0000"+
		"\u0000\u0000\u0097\u0096\u0001\u0000\u0000\u0000\u0097\u0098\u0001\u0000"+
		"\u0000\u0000\u0098\u0099\u0001\u0000\u0000\u0000\u0099\u009b\u0005 \u0000"+
		"\u0000\u009a\u009c\u0003$\u0012\u0000\u009b\u009a\u0001\u0000\u0000\u0000"+
		"\u009b\u009c\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000"+
		"\u009d\u00a0\u0005 \u0000\u0000\u009e\u00a1\u0003\u0012\t\u0000\u009f"+
		"\u00a1\u0003\u001e\u000f\u0000\u00a0\u009e\u0001\u0000\u0000\u0000\u00a0"+
		"\u009f\u0001\u0000\u0000\u0000\u00a0\u00a1\u0001\u0000\u0000\u0000\u00a1"+
		"\u00a2\u0001\u0000\u0000\u0000\u00a2\u00ad\u0003\n\u0005\u0000\u00a3\u00a4"+
		"\u0005\u0010\u0000\u0000\u00a4\u00a5\u0005.\u0000\u0000\u00a5\u00a6\u0005"+
		"\u0011\u0000\u0000\u00a6\u00a7\u0005.\u0000\u0000\u00a7\u00a8\u0005\u000b"+
		"\u0000\u0000\u00a8\u00a9\u0005\u0012\u0000\u0000\u00a9\u00aa\u0003$\u0012"+
		"\u0000\u00aa\u00ab\u0003\n\u0005\u0000\u00ab\u00ad\u0001\u0000\u0000\u0000"+
		"\u00ac\u0090\u0001\u0000\u0000\u0000\u00ac\u0094\u0001\u0000\u0000\u0000"+
		"\u00ac\u00a3\u0001\u0000\u0000\u0000\u00ad\u001d\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0005.\u0000\u0000\u00af\u00b0\u0005\u0016\u0000\u0000\u00b0"+
		"\u00b5\u0005\u0016\u0000\u0000\u00b1\u00b2\u0005.\u0000\u0000\u00b2\u00b3"+
		"\u0005\u0017\u0000\u0000\u00b3\u00b5\u0005\u0017\u0000\u0000\u00b4\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b1\u0001\u0000\u0000\u0000\u00b5\u001f"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0005\u001e\u0000\u0000\u00b7\u00b9"+
		"\u0005\u001f\u0000\u0000\u00b8\u00ba\u0005.\u0000\u0000\u00b9\u00b8\u0001"+
		"\u0000\u0000\u0000\u00b9\u00ba\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001"+
		"\u0000\u0000\u0000\u00bb\u00c4\u0005\u0006\u0000\u0000\u00bc\u00c1\u0003"+
		"$\u0012\u0000\u00bd\u00be\u0005\u0011\u0000\u0000\u00be\u00c0\u0003$\u0012"+
		"\u0000\u00bf\u00bd\u0001\u0000\u0000\u0000\u00c0\u00c3\u0001\u0000\u0000"+
		"\u0000\u00c1\u00bf\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c5\u0001\u0000\u0000\u0000\u00c3\u00c1\u0001\u0000\u0000"+
		"\u0000\u00c4\u00bc\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000"+
		"\u0000\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0007\u0000"+
		"\u0000\u00c7!\u0001\u0000\u0000\u0000\u00c8\u00c9\u00052\u0000\u0000\u00c9"+
		"\u00d2\u0005\u001c\u0000\u0000\u00ca\u00cf\u0003$\u0012\u0000\u00cb\u00cc"+
		"\u0005\u0011\u0000\u0000\u00cc\u00ce\u0003$\u0012\u0000\u00cd\u00cb\u0001"+
		"\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf\u00cd\u0001"+
		"\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2\u00ca\u0001"+
		"\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3\u00d4\u0001"+
		"\u0000\u0000\u0000\u00d4\u00d5\u0005\u001d\u0000\u0000\u00d5#\u0001\u0000"+
		"\u0000\u0000\u00d6\u00d7\u0006\u0012\uffff\uffff\u0000\u00d7\u00d8\u0005"+
		"\u0015\u0000\u0000\u00d8\u00e7\u0003$\u0012\u000b\u00d9\u00da\u0005\u001c"+
		"\u0000\u0000\u00da\u00db\u0003$\u0012\u0000\u00db\u00dc\u0005\u001d\u0000"+
		"\u0000\u00dc\u00e7\u0001\u0000\u0000\u0000\u00dd\u00e7\u0003 \u0010\u0000"+
		"\u00de\u00e7\u0005-\u0000\u0000\u00df\u00e7\u0005,\u0000\u0000\u00e0\u00e7"+
		"\u0005+\u0000\u0000\u00e1\u00e7\u0005*\u0000\u0000\u00e2\u00e7\u0005\'"+
		"\u0000\u0000\u00e3\u00e7\u0005(\u0000\u0000\u00e4\u00e7\u0005)\u0000\u0000"+
		"\u00e5\u00e7\u0005.\u0000\u0000\u00e6\u00d6\u0001\u0000\u0000\u0000\u00e6"+
		"\u00d9\u0001\u0000\u0000\u0000\u00e6\u00dd\u0001\u0000\u0000\u0000\u00e6"+
		"\u00de\u0001\u0000\u0000\u0000\u00e6\u00df\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e0\u0001\u0000\u0000\u0000\u00e6\u00e1\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e2\u0001\u0000\u0000\u0000\u00e6\u00e3\u0001\u0000\u0000\u0000\u00e6"+
		"\u00e4\u0001\u0000\u0000\u0000\u00e6\u00e5\u0001\u0000\u0000\u0000\u00e7"+
		"\u0111\u0001\u0000\u0000\u0000\u00e8\u00e9\n\u0018\u0000\u0000\u00e9\u00ea"+
		"\u0005\u0016\u0000\u0000\u00ea\u0110\u0003$\u0012\u0019\u00eb\u00ec\n"+
		"\u0017\u0000\u0000\u00ec\u00ed\u0005\u0017\u0000\u0000\u00ed\u0110\u0003"+
		"$\u0012\u0018\u00ee\u00ef\n\u0016\u0000\u0000\u00ef\u00f0\u0005\u0018"+
		"\u0000\u0000\u00f0\u0110\u0003$\u0012\u0017\u00f1\u00f2\n\u0015\u0000"+
		"\u0000\u00f2\u00f3\u0005\u0019\u0000\u0000\u00f3\u0110\u0003$\u0012\u0016"+
		"\u00f4\u00f5\n\u0014\u0000\u0000\u00f5\u00f6\u0005\u001a\u0000\u0000\u00f6"+
		"\u0110\u0003$\u0012\u0015\u00f7\u00f8\n\u0013\u0000\u0000\u00f8\u00f9"+
		"\u0005%\u0000\u0000\u00f9\u0110\u0003$\u0012\u0014\u00fa\u00fb\n\u0012"+
		"\u0000\u0000\u00fb\u00fc\u0005&\u0000\u0000\u00fc\u0110\u0003$\u0012\u0013"+
		"\u00fd\u00fe\n\u0011\u0000\u0000\u00fe\u00ff\u0005!\u0000\u0000\u00ff"+
		"\u0110\u0003$\u0012\u0012\u0100\u0101\n\u0010\u0000\u0000\u0101\u0102"+
		"\u0005\"\u0000\u0000\u0102\u0110\u0003$\u0012\u0011\u0103\u0104\n\u000f"+
		"\u0000\u0000\u0104\u0105\u0005#\u0000\u0000\u0105\u0110\u0003$\u0012\u0010"+
		"\u0106\u0107\n\u000e\u0000\u0000\u0107\u0108\u0005$\u0000\u0000\u0108"+
		"\u0110\u0003$\u0012\u000f\u0109\u010a\n\r\u0000\u0000\u010a\u010b\u0005"+
		"\u0013\u0000\u0000\u010b\u0110\u0003$\u0012\u000e\u010c\u010d\n\f\u0000"+
		"\u0000\u010d\u010e\u0005\u0014\u0000\u0000\u010e\u0110\u0003$\u0012\r"+
		"\u010f\u00e8\u0001\u0000\u0000\u0000\u010f\u00eb\u0001\u0000\u0000\u0000"+
		"\u010f\u00ee\u0001\u0000\u0000\u0000\u010f\u00f1\u0001\u0000\u0000\u0000"+
		"\u010f\u00f4\u0001\u0000\u0000\u0000\u010f\u00f7\u0001\u0000\u0000\u0000"+
		"\u010f\u00fa\u0001\u0000\u0000\u0000\u010f\u00fd\u0001\u0000\u0000\u0000"+
		"\u010f\u0100\u0001\u0000\u0000\u0000\u010f\u0103\u0001\u0000\u0000\u0000"+
		"\u010f\u0106\u0001\u0000\u0000\u0000\u010f\u0109\u0001\u0000\u0000\u0000"+
		"\u010f\u010c\u0001\u0000\u0000\u0000\u0110\u0113\u0001\u0000\u0000\u0000"+
		"\u0111\u010f\u0001\u0000\u0000\u0000\u0111\u0112\u0001\u0000\u0000\u0000"+
		"\u0112%\u0001\u0000\u0000\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u001b"+
		"4:ILUZ^cqu\u007f\u0083\u008a\u008e\u0097\u009b\u00a0\u00ac\u00b4\u00b9"+
		"\u00c1\u00c4\u00cf\u00d2\u00e6\u010f\u0111";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}