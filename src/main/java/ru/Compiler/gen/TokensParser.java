// Generated from D:/Compiler/src/main/java/Tokens/Tokens.g4 by ANTLR 4.13.2
package ru.Compiler.gen;


import ru.Compiler.gen.TokensVisitor;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class TokensParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, INT=5, DOUBLE=6, STRING=7, BOOLEAN=8, 
		BLANK=9, NAMESPACE=10, INTERFACE=11, CLASS=12, METHOD=13, IMPLMT=14, USES=15, 
		BEGIN=16, END_M=17, END_P=18, FOR=19, WHILE=20, BREAK=21, IF=22, ELSE=23, 
		ELSE_IF=24, RETURN=25, PLUS=26, MINUS=27, MULT=28, DIV=29, R_DIV=30, EQUALLY=31, 
		COMMENT=32, POINT=33, PC=34, Q_MARK=35, MANY=36, LESS=37, EQUALLY_BOOL=38, 
		NOT_EQUALLY=39, L_EQUALLY=40, M_EQUALLY=41, INCREM=42, DECREM=43, AND=44, 
		OR=45, TRUE=46, FALSE=47, LSHIFT=48, RSHIFT=49, INT_M=50, DOUBLE_M=51, 
		STRING_M=52, BOOLEAN_M=53, PUBLIC=54, PRIVATE=55, NUMBER_INT=56, DOUBLE_NUMBER=57, 
		STRING_LITERAL=58, MAIN=59, PRINT=60, ID_UP=61, ID_LOW=62;
	public static final int
		RULE_program = 0, RULE_namespaceDeclaration = 1, RULE_interfaceDeclaration = 2, 
		RULE_classDeclaration = 3, RULE_classBody = 4, RULE_publicSection = 5, 
		RULE_privateSection = 6, RULE_classMember = 7, RULE_methodDeclaration = 8, 
		RULE_parameterList = 9, RULE_parameter = 10, RULE_nestedClassDeclaration = 11, 
		RULE_type = 12, RULE_implementationDeclaration = 13, RULE_classMethod = 14, 
		RULE_methodBody = 15, RULE_returnMethodBody = 16, RULE_returnStatement = 17, 
		RULE_statementList = 18, RULE_statement = 19, RULE_methodCall = 20, RULE_methodCallReturn = 21, 
		RULE_assignment = 22, RULE_argumentList = 23, RULE_variableDeclaration = 24, 
		RULE_booleanDeclaration = 25, RULE_expression = 26, RULE_shiftExpression = 27, 
		RULE_term = 28, RULE_factor = 29, RULE_print = 30, RULE_printExpression = 31, 
		RULE_printAddExpr = 32, RULE_printAtom = 33, RULE_bool = 34, RULE_boolExpression = 35, 
		RULE_boolTerm = 36, RULE_boolFactor = 37, RULE_comparison = 38, RULE_for = 39, 
		RULE_while = 40, RULE_if = 41, RULE_else = 42, RULE_else_if = 43, RULE_prefix = 44, 
		RULE_postfix = 45, RULE_typeParam = 46;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "namespaceDeclaration", "interfaceDeclaration", "classDeclaration", 
			"classBody", "publicSection", "privateSection", "classMember", "methodDeclaration", 
			"parameterList", "parameter", "nestedClassDeclaration", "type", "implementationDeclaration", 
			"classMethod", "methodBody", "returnMethodBody", "returnStatement", "statementList", 
			"statement", "methodCall", "methodCallReturn", "assignment", "argumentList", 
			"variableDeclaration", "booleanDeclaration", "expression", "shiftExpression", 
			"term", "factor", "print", "printExpression", "printAddExpr", "printAtom", 
			"bool", "boolExpression", "boolTerm", "boolFactor", "comparison", "for", 
			"while", "if", "else", "else_if", "prefix", "postfix", "typeParam"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "')'", "':'", "','", "'int'", "'double'", "'String'", "'boolean'", 
			null, "'namespace'", "'interface'", "'class'", "'method'", "'implementation'", 
			"'uses'", "'begin'", "'end;'", "'end.'", "'for'", "'while'", "'break'", 
			"'if'", "'else'", "'else if'", "'return'", "'+'", "'-'", "'*'", "'/'", 
			"'%'", "'='", null, "'.'", "';'", "'''", "'>'", "'<'", "'=='", "'!='", 
			"'<='", "'=>'", "'++'", "'--'", "'&'", "'|'", "'true'", "'false'", "'<<'", 
			"'>>'", "'Integer'", "'Double'", "'STRING'", "'Boolean'", "'public'", 
			"'private'", null, null, null, "'main'", "'print'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, "INT", "DOUBLE", "STRING", "BOOLEAN", "BLANK", 
			"NAMESPACE", "INTERFACE", "CLASS", "METHOD", "IMPLMT", "USES", "BEGIN", 
			"END_M", "END_P", "FOR", "WHILE", "BREAK", "IF", "ELSE", "ELSE_IF", "RETURN", 
			"PLUS", "MINUS", "MULT", "DIV", "R_DIV", "EQUALLY", "COMMENT", "POINT", 
			"PC", "Q_MARK", "MANY", "LESS", "EQUALLY_BOOL", "NOT_EQUALLY", "L_EQUALLY", 
			"M_EQUALLY", "INCREM", "DECREM", "AND", "OR", "TRUE", "FALSE", "LSHIFT", 
			"RSHIFT", "INT_M", "DOUBLE_M", "STRING_M", "BOOLEAN_M", "PUBLIC", "PRIVATE", 
			"NUMBER_INT", "DOUBLE_NUMBER", "STRING_LITERAL", "MAIN", "PRINT", "ID_UP", 
			"ID_LOW"
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
	public String getGrammarFileName() { return "Tokens.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public TokensParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ImplementationDeclarationContext implementationDeclaration() {
			return getRuleContext(ImplementationDeclarationContext.class,0);
		}
		public TerminalNode END_P() { return getToken(TokensParser.END_P, 0); }
		public NamespaceDeclarationContext namespaceDeclaration() {
			return getRuleContext(NamespaceDeclarationContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor) return ((TokensVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NAMESPACE) {
				{
				setState(94);
				namespaceDeclaration();
				}
			}

			setState(97);
			interfaceDeclaration();
			setState(98);
			implementationDeclaration();
			setState(99);
			match(END_P);
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
	public static class NamespaceDeclarationContext extends ParserRuleContext {
		public TerminalNode NAMESPACE() { return getToken(TokensParser.NAMESPACE, 0); }
		public TerminalNode ID_UP() { return getToken(TokensParser.ID_UP, 0); }
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public NamespaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterNamespaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitNamespaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitNamespaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NamespaceDeclarationContext namespaceDeclaration() throws RecognitionException {
		NamespaceDeclarationContext _localctx = new NamespaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_namespaceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(NAMESPACE);
			setState(102);
			match(ID_UP);
			setState(103);
			match(PC);
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
	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(TokensParser.INTERFACE, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitInterfaceDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitInterfaceDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(105);
			match(INTERFACE);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID_UP) {
				{
				{
				setState(106);
				classDeclaration();
				}
				}
				setState(111);
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
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode ID_UP() { return getToken(TokensParser.ID_UP, 0); }
		public TerminalNode EQUALLY() { return getToken(TokensParser.EQUALLY, 0); }
		public TerminalNode CLASS() { return getToken(TokensParser.CLASS, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_classDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			match(ID_UP);
			setState(113);
			match(EQUALLY);
			setState(114);
			match(CLASS);
			setState(115);
			classBody();
			setState(116);
			match(END_M);
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
	public static class ClassBodyContext extends ParserRuleContext {
		public PrivateSectionContext privateSection() {
			return getRuleContext(PrivateSectionContext.class,0);
		}
		public PublicSectionContext publicSection() {
			return getRuleContext(PublicSectionContext.class,0);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitClassBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PRIVATE:
				{
				setState(118);
				privateSection();
				setState(120);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PUBLIC) {
					{
					setState(119);
					publicSection();
					}
				}

				}
				break;
			case PUBLIC:
				{
				setState(122);
				publicSection();
				setState(124);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==PRIVATE) {
					{
					setState(123);
					privateSection();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class PublicSectionContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(TokensParser.PUBLIC, 0); }
		public ClassMemberContext classMember() {
			return getRuleContext(ClassMemberContext.class,0);
		}
		public PublicSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_publicSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPublicSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPublicSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPublicSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PublicSectionContext publicSection() throws RecognitionException {
		PublicSectionContext _localctx = new PublicSectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_publicSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			match(PUBLIC);
			setState(129);
			classMember();
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
	public static class PrivateSectionContext extends ParserRuleContext {
		public TerminalNode PRIVATE() { return getToken(TokensParser.PRIVATE, 0); }
		public ClassMemberContext classMember() {
			return getRuleContext(ClassMemberContext.class,0);
		}
		public PrivateSectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_privateSection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPrivateSection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPrivateSection(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPrivateSection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrivateSectionContext privateSection() throws RecognitionException {
		PrivateSectionContext _localctx = new PrivateSectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_privateSection);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131);
			match(PRIVATE);
			setState(132);
			classMember();
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
	public static class ClassMemberContext extends ParserRuleContext {
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public NestedClassDeclarationContext nestedClassDeclaration() {
			return getRuleContext(NestedClassDeclarationContext.class,0);
		}
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterClassMember(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitClassMember(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitClassMember(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classMember);
		int _la;
		try {
			setState(141);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
			case END_M:
			case PUBLIC:
			case PRIVATE:
				enterOuterAlt(_localctx, 1);
				{
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CLASS) {
					{
					{
					setState(134);
					methodDeclaration();
					}
					}
					setState(139);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case ID_UP:
				enterOuterAlt(_localctx, 2);
				{
				setState(140);
				nestedClassDeclaration();
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
	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(TokensParser.CLASS, 0); }
		public TerminalNode METHOD() { return getToken(TokensParser.METHOD, 0); }
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(TokensParser.MAIN, 0); }
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitMethodDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitMethodDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(CLASS);
			setState(144);
			match(METHOD);
			setState(149);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_LOW:
				{
				setState(145);
				match(ID_LOW);
				}
				break;
			case T__0:
			case MAIN:
				{
				setState(147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==MAIN) {
					{
					setState(146);
					match(MAIN);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(151);
			match(T__0);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
				{
				setState(152);
				parameterList();
				}
			}

			setState(155);
			match(T__1);
			setState(158);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(156);
				match(T__2);
				setState(157);
				type();
				}
			}

			setState(160);
			match(PC);
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
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitParameterList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitParameterList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			parameter();
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(163);
				match(T__3);
				setState(164);
				parameter();
				}
				}
				setState(169);
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
	public static class ParameterContext extends ParserRuleContext {
		public TypeParamContext typeParam() {
			return getRuleContext(TypeParamContext.class,0);
		}
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			typeParam();
			setState(171);
			match(ID_LOW);
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
	public static class NestedClassDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public NestedClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nestedClassDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterNestedClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitNestedClassDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitNestedClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NestedClassDeclarationContext nestedClassDeclaration() throws RecognitionException {
		NestedClassDeclarationContext _localctx = new NestedClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_nestedClassDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(173);
			classDeclaration();
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
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT_M() { return getToken(TokensParser.INT_M, 0); }
		public TerminalNode DOUBLE_M() { return getToken(TokensParser.DOUBLE_M, 0); }
		public TerminalNode STRING_M() { return getToken(TokensParser.STRING_M, 0); }
		public TerminalNode BOOLEAN_M() { return getToken(TokensParser.BOOLEAN_M, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 16888498602639360L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class ImplementationDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPLMT() { return getToken(TokensParser.IMPLMT, 0); }
		public List<ClassMethodContext> classMethod() {
			return getRuleContexts(ClassMethodContext.class);
		}
		public ClassMethodContext classMethod(int i) {
			return getRuleContext(ClassMethodContext.class,i);
		}
		public ImplementationDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementationDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterImplementationDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitImplementationDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitImplementationDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplementationDeclarationContext implementationDeclaration() throws RecognitionException {
		ImplementationDeclarationContext _localctx = new ImplementationDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_implementationDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(177);
			match(IMPLMT);
			setState(181);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(178);
				classMethod();
				}
				}
				setState(183);
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
	public static class ClassMethodContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(TokensParser.CLASS, 0); }
		public TerminalNode METHOD() { return getToken(TokensParser.METHOD, 0); }
		public TerminalNode ID_UP() { return getToken(TokensParser.ID_UP, 0); }
		public TerminalNode POINT() { return getToken(TokensParser.POINT, 0); }
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public TerminalNode MAIN() { return getToken(TokensParser.MAIN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReturnMethodBodyContext returnMethodBody() {
			return getRuleContext(ReturnMethodBodyContext.class,0);
		}
		public ClassMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterClassMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitClassMethod(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitClassMethod(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMethodContext classMethod() throws RecognitionException {
		ClassMethodContext _localctx = new ClassMethodContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classMethod);
		int _la;
		try {
			setState(216);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184);
				match(CLASS);
				setState(185);
				match(METHOD);
				setState(186);
				match(ID_UP);
				setState(187);
				match(POINT);
				setState(192);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case ID_LOW:
					{
					setState(188);
					match(ID_LOW);
					}
					break;
				case T__0:
				case MAIN:
					{
					setState(190);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==MAIN) {
						{
						setState(189);
						match(MAIN);
						}
					}

					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(194);
				match(T__0);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
					{
					setState(195);
					parameterList();
					}
				}

				setState(198);
				match(T__1);
				setState(199);
				match(PC);
				setState(200);
				methodBody();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(201);
				match(CLASS);
				setState(202);
				match(METHOD);
				setState(203);
				match(ID_UP);
				setState(204);
				match(POINT);
				setState(205);
				match(ID_LOW);
				setState(206);
				match(T__0);
				setState(208);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) {
					{
					setState(207);
					parameterList();
					}
				}

				setState(210);
				match(T__1);
				setState(211);
				match(T__2);
				setState(212);
				type();
				setState(213);
				match(PC);
				setState(214);
				returnMethodBody();
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
	public static class MethodBodyContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(TokensParser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_methodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			match(BEGIN);
			setState(219);
			statementList();
			setState(220);
			match(END_M);
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
	public static class ReturnMethodBodyContext extends ParserRuleContext {
		public TerminalNode BEGIN() { return getToken(TokensParser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public ReturnMethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnMethodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterReturnMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitReturnMethodBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitReturnMethodBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnMethodBodyContext returnMethodBody() throws RecognitionException {
		ReturnMethodBodyContext _localctx = new ReturnMethodBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnMethodBody);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(222);
			match(BEGIN);
			setState(223);
			statementList();
			setState(224);
			returnStatement();
			setState(225);
			match(END_M);
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
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(TokensParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitReturnStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitReturnStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_returnStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(RETURN);
			setState(228);
			expression();
			setState(229);
			match(PC);
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
	public static class StatementListContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitStatementList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitStatementList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementListContext statementList() throws RecognitionException {
		StatementListContext _localctx = new StatementListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_statementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(231);
					statement();
					}
					} 
				}
				setState(236);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BooleanDeclarationContext booleanDeclaration() {
			return getRuleContext(BooleanDeclarationContext.class,0);
		}
		public ForContext for_() {
			return getRuleContext(ForContext.class,0);
		}
		public IfContext if_() {
			return getRuleContext(IfContext.class,0);
		}
		public WhileContext while_() {
			return getRuleContext(WhileContext.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_statement);
		try {
			setState(246);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ID_LOW:
				enterOuterAlt(_localctx, 1);
				{
				setState(237);
				assignment();
				}
				break;
			case INT:
			case DOUBLE:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(238);
				variableDeclaration();
				}
				break;
			case ID_UP:
				enterOuterAlt(_localctx, 3);
				{
				setState(239);
				methodCall();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 4);
				{
				setState(240);
				returnStatement();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 5);
				{
				setState(241);
				booleanDeclaration();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 6);
				{
				setState(242);
				for_();
				}
				break;
			case IF:
				enterOuterAlt(_localctx, 7);
				{
				setState(243);
				if_();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 8);
				{
				setState(244);
				while_();
				}
				break;
			case PRINT:
				enterOuterAlt(_localctx, 9);
				{
				setState(245);
				print();
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
	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode ID_UP() { return getToken(TokensParser.ID_UP, 0); }
		public TerminalNode POINT() { return getToken(TokensParser.POINT, 0); }
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode MAIN() { return getToken(TokensParser.MAIN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterMethodCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitMethodCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitMethodCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_methodCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(248);
			match(ID_UP);
			setState(249);
			match(POINT);
			setState(250);
			_la = _input.LA(1);
			if ( !(_la==MAIN || _la==ID_LOW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(251);
			match(T__0);
			setState(253);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7422143292139110402L) != 0)) {
				{
				setState(252);
				argumentList();
				}
			}

			setState(255);
			match(T__1);
			setState(256);
			match(PC);
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
	public static class MethodCallReturnContext extends ParserRuleContext {
		public TerminalNode ID_UP() { return getToken(TokensParser.ID_UP, 0); }
		public TerminalNode POINT() { return getToken(TokensParser.POINT, 0); }
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode MAIN() { return getToken(TokensParser.MAIN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodCallReturnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallReturn; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterMethodCallReturn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitMethodCallReturn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitMethodCallReturn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MethodCallReturnContext methodCallReturn() throws RecognitionException {
		MethodCallReturnContext _localctx = new MethodCallReturnContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_methodCallReturn);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(ID_UP);
			setState(259);
			match(POINT);
			setState(260);
			_la = _input.LA(1);
			if ( !(_la==MAIN || _la==ID_LOW) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(261);
			match(T__0);
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7422143292139110402L) != 0)) {
				{
				setState(262);
				argumentList();
				}
			}

			setState(265);
			match(T__1);
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
	public static class AssignmentContext extends ParserRuleContext {
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode EQUALLY() { return getToken(TokensParser.EQUALLY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			match(ID_LOW);
			setState(268);
			match(EQUALLY);
			setState(269);
			expression();
			setState(270);
			match(PC);
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
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitArgumentList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitArgumentList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272);
			expression();
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3) {
				{
				{
				setState(273);
				match(T__3);
				setState(274);
				expression();
				}
				}
				setState(279);
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
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public TerminalNode INT() { return getToken(TokensParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(TokensParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(TokensParser.STRING, 0); }
		public TerminalNode EQUALLY() { return getToken(TokensParser.EQUALLY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitVariableDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(280);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 224L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(281);
			match(ID_LOW);
			setState(284);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALLY) {
				{
				setState(282);
				match(EQUALLY);
				setState(283);
				expression();
				}
			}

			setState(286);
			match(PC);
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
	public static class BooleanDeclarationContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(TokensParser.BOOLEAN, 0); }
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public TerminalNode EQUALLY() { return getToken(TokensParser.EQUALLY, 0); }
		public TerminalNode TRUE() { return getToken(TokensParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TokensParser.FALSE, 0); }
		public BooleanDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterBooleanDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitBooleanDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitBooleanDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanDeclarationContext booleanDeclaration() throws RecognitionException {
		BooleanDeclarationContext _localctx = new BooleanDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_booleanDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			match(BOOLEAN);
			setState(289);
			match(ID_LOW);
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUALLY) {
				{
				setState(290);
				match(EQUALLY);
				setState(291);
				_la = _input.LA(1);
				if ( !(_la==TRUE || _la==FALSE) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(294);
			match(PC);
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<ShiftExpressionContext> shiftExpression() {
			return getRuleContexts(ShiftExpressionContext.class);
		}
		public ShiftExpressionContext shiftExpression(int i) {
			return getRuleContext(ShiftExpressionContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(TokensParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(TokensParser.PLUS, i);
		}
		public List<TerminalNode> MINUS() { return getTokens(TokensParser.MINUS); }
		public TerminalNode MINUS(int i) {
			return getToken(TokensParser.MINUS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			shiftExpression();
			setState(301);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(297);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(298);
					shiftExpression();
					}
					} 
				}
				setState(303);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
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
	public static class ShiftExpressionContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public List<TerminalNode> LSHIFT() { return getTokens(TokensParser.LSHIFT); }
		public TerminalNode LSHIFT(int i) {
			return getToken(TokensParser.LSHIFT, i);
		}
		public List<TerminalNode> RSHIFT() { return getTokens(TokensParser.RSHIFT); }
		public TerminalNode RSHIFT(int i) {
			return getToken(TokensParser.RSHIFT, i);
		}
		public ShiftExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shiftExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterShiftExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitShiftExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitShiftExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ShiftExpressionContext shiftExpression() throws RecognitionException {
		ShiftExpressionContext _localctx = new ShiftExpressionContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_shiftExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			term();
			setState(309);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LSHIFT || _la==RSHIFT) {
				{
				{
				setState(305);
				_la = _input.LA(1);
				if ( !(_la==LSHIFT || _la==RSHIFT) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(306);
				term();
				}
				}
				setState(311);
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
	public static class TermContext extends ParserRuleContext {
		public List<FactorContext> factor() {
			return getRuleContexts(FactorContext.class);
		}
		public FactorContext factor(int i) {
			return getRuleContext(FactorContext.class,i);
		}
		public List<TerminalNode> MULT() { return getTokens(TokensParser.MULT); }
		public TerminalNode MULT(int i) {
			return getToken(TokensParser.MULT, i);
		}
		public List<TerminalNode> DIV() { return getTokens(TokensParser.DIV); }
		public TerminalNode DIV(int i) {
			return getToken(TokensParser.DIV, i);
		}
		public List<TerminalNode> R_DIV() { return getTokens(TokensParser.R_DIV); }
		public TerminalNode R_DIV(int i) {
			return getToken(TokensParser.R_DIV, i);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(312);
			factor();
			setState(317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) {
				{
				{
				setState(313);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1879048192L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(314);
				factor();
				}
				}
				setState(319);
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode DOUBLE_NUMBER() { return getToken(TokensParser.DOUBLE_NUMBER, 0); }
		public TerminalNode NUMBER_INT() { return getToken(TokensParser.NUMBER_INT, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(TokensParser.STRING_LITERAL, 0); }
		public TerminalNode TRUE() { return getToken(TokensParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TokensParser.FALSE, 0); }
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public MethodCallReturnContext methodCallReturn() {
			return getRuleContext(MethodCallReturnContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_factor);
		try {
			setState(331);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLE_NUMBER:
				enterOuterAlt(_localctx, 1);
				{
				setState(320);
				match(DOUBLE_NUMBER);
				}
				break;
			case NUMBER_INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(321);
				match(NUMBER_INT);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(322);
				match(STRING_LITERAL);
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 4);
				{
				setState(323);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 5);
				{
				setState(324);
				match(FALSE);
				}
				break;
			case ID_LOW:
				enterOuterAlt(_localctx, 6);
				{
				setState(325);
				match(ID_LOW);
				}
				break;
			case ID_UP:
				enterOuterAlt(_localctx, 7);
				{
				setState(326);
				methodCallReturn();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 8);
				{
				setState(327);
				match(T__0);
				setState(328);
				expression();
				setState(329);
				match(T__1);
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
	public static class PrintContext extends ParserRuleContext {
		public TerminalNode PRINT() { return getToken(TokensParser.PRINT, 0); }
		public PrintExpressionContext printExpression() {
			return getRuleContext(PrintExpressionContext.class,0);
		}
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPrint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(PRINT);
			setState(334);
			match(T__0);
			setState(335);
			printExpression();
			setState(336);
			match(T__1);
			setState(337);
			match(PC);
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
	public static class PrintExpressionContext extends ParserRuleContext {
		public PrintAddExprContext printAddExpr() {
			return getRuleContext(PrintAddExprContext.class,0);
		}
		public PrintExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPrintExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPrintExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPrintExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintExpressionContext printExpression() throws RecognitionException {
		PrintExpressionContext _localctx = new PrintExpressionContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_printExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(339);
			printAddExpr();
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
	public static class PrintAddExprContext extends ParserRuleContext {
		public List<PrintAtomContext> printAtom() {
			return getRuleContexts(PrintAtomContext.class);
		}
		public PrintAtomContext printAtom(int i) {
			return getRuleContext(PrintAtomContext.class,i);
		}
		public List<TerminalNode> PLUS() { return getTokens(TokensParser.PLUS); }
		public TerminalNode PLUS(int i) {
			return getToken(TokensParser.PLUS, i);
		}
		public PrintAddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printAddExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPrintAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPrintAddExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPrintAddExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintAddExprContext printAddExpr() throws RecognitionException {
		PrintAddExprContext _localctx = new PrintAddExprContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_printAddExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(341);
			printAtom();
			setState(346);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==PLUS) {
				{
				{
				setState(342);
				match(PLUS);
				setState(343);
				printAtom();
				}
				}
				setState(348);
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
	public static class PrintAtomContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING_LITERAL() { return getToken(TokensParser.STRING_LITERAL, 0); }
		public PrintAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_printAtom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPrintAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPrintAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPrintAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintAtomContext printAtom() throws RecognitionException {
		PrintAtomContext _localctx = new PrintAtomContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_printAtom);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,30,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(349);
				expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(350);
				match(STRING_LITERAL);
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
	public static class BoolContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MANY() { return getToken(TokensParser.MANY, 0); }
		public TerminalNode LESS() { return getToken(TokensParser.LESS, 0); }
		public TerminalNode EQUALLY_BOOL() { return getToken(TokensParser.EQUALLY_BOOL, 0); }
		public TerminalNode NOT_EQUALLY() { return getToken(TokensParser.NOT_EQUALLY, 0); }
		public TerminalNode M_EQUALLY() { return getToken(TokensParser.M_EQUALLY, 0); }
		public TerminalNode L_EQUALLY() { return getToken(TokensParser.L_EQUALLY, 0); }
		public BoolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterBool(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitBool(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitBool(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolContext bool() throws RecognitionException {
		BoolContext _localctx = new BoolContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_bool);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			expression();
			setState(354);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327034368L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(355);
			expression();
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
	public static class BoolExpressionContext extends ParserRuleContext {
		public List<BoolTermContext> boolTerm() {
			return getRuleContexts(BoolTermContext.class);
		}
		public BoolTermContext boolTerm(int i) {
			return getRuleContext(BoolTermContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(TokensParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(TokensParser.OR, i);
		}
		public BoolExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterBoolExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitBoolExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitBoolExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolExpressionContext boolExpression() throws RecognitionException {
		BoolExpressionContext _localctx = new BoolExpressionContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_boolExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(357);
			boolTerm();
			setState(362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(358);
				match(OR);
				setState(359);
				boolTerm();
				}
				}
				setState(364);
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
	public static class BoolTermContext extends ParserRuleContext {
		public List<BoolFactorContext> boolFactor() {
			return getRuleContexts(BoolFactorContext.class);
		}
		public BoolFactorContext boolFactor(int i) {
			return getRuleContext(BoolFactorContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(TokensParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(TokensParser.AND, i);
		}
		public BoolTermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolTerm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterBoolTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitBoolTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitBoolTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolTermContext boolTerm() throws RecognitionException {
		BoolTermContext _localctx = new BoolTermContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_boolTerm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(365);
			boolFactor();
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(366);
				match(AND);
				setState(367);
				boolFactor();
				}
				}
				setState(372);
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
	public static class BoolFactorContext extends ParserRuleContext {
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public BoolFactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolFactor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterBoolFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitBoolFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitBoolFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BoolFactorContext boolFactor() throws RecognitionException {
		BoolFactorContext _localctx = new BoolFactorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_boolFactor);
		try {
			setState(378);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(373);
				match(T__0);
				setState(374);
				boolExpression();
				setState(375);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(377);
				comparison();
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
	public static class ComparisonContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MANY() { return getToken(TokensParser.MANY, 0); }
		public TerminalNode LESS() { return getToken(TokensParser.LESS, 0); }
		public TerminalNode EQUALLY_BOOL() { return getToken(TokensParser.EQUALLY_BOOL, 0); }
		public TerminalNode NOT_EQUALLY() { return getToken(TokensParser.NOT_EQUALLY, 0); }
		public TerminalNode M_EQUALLY() { return getToken(TokensParser.M_EQUALLY, 0); }
		public TerminalNode L_EQUALLY() { return getToken(TokensParser.L_EQUALLY, 0); }
		public TerminalNode TRUE() { return getToken(TokensParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(TokensParser.FALSE, 0); }
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(380);
			expression();
			setState(381);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4329327034368L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(385);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,34,_ctx) ) {
			case 1:
				{
				setState(382);
				expression();
				}
				break;
			case 2:
				{
				setState(383);
				match(TRUE);
				}
				break;
			case 3:
				{
				setState(384);
				match(FALSE);
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
	public static class ForContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(TokensParser.FOR, 0); }
		public BoolContext bool() {
			return getRuleContext(BoolContext.class,0);
		}
		public TerminalNode PC() { return getToken(TokensParser.PC, 0); }
		public TerminalNode BEGIN() { return getToken(TokensParser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public PrefixContext prefix() {
			return getRuleContext(PrefixContext.class,0);
		}
		public PostfixContext postfix() {
			return getRuleContext(PostfixContext.class,0);
		}
		public ForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForContext for_() throws RecognitionException {
		ForContext _localctx = new ForContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_for);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			match(FOR);
			setState(388);
			match(T__0);
			setState(391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case DOUBLE:
			case STRING:
				{
				setState(389);
				variableDeclaration();
				}
				break;
			case T__0:
			case TRUE:
			case FALSE:
			case NUMBER_INT:
			case DOUBLE_NUMBER:
			case STRING_LITERAL:
			case ID_UP:
			case ID_LOW:
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(393);
			bool();
			setState(394);
			match(PC);
			setState(397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCREM:
			case DECREM:
				{
				setState(395);
				prefix();
				}
				break;
			case ID_LOW:
				{
				setState(396);
				postfix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(399);
			match(T__1);
			setState(400);
			match(BEGIN);
			setState(401);
			statementList();
			setState(402);
			match(END_M);
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
	public static class WhileContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(TokensParser.WHILE, 0); }
		public TerminalNode BEGIN() { return getToken(TokensParser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public WhileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterWhile(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitWhile(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitWhile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileContext while_() throws RecognitionException {
		WhileContext _localctx = new WhileContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_while);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			match(WHILE);
			setState(405);
			match(T__0);
			{
			setState(406);
			boolExpression();
			}
			setState(407);
			match(T__1);
			setState(408);
			match(BEGIN);
			setState(409);
			statementList();
			setState(410);
			match(END_M);
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
	public static class IfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(TokensParser.IF, 0); }
		public TerminalNode BEGIN() { return getToken(TokensParser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(TokensParser.BREAK, 0); }
		public ElseContext else_() {
			return getRuleContext(ElseContext.class,0);
		}
		public Else_ifContext else_if() {
			return getRuleContext(Else_ifContext.class,0);
		}
		public IfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfContext if_() throws RecognitionException {
		IfContext _localctx = new IfContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			match(IF);
			setState(413);
			match(T__0);
			{
			setState(414);
			boolExpression();
			}
			setState(415);
			match(T__1);
			setState(416);
			match(BEGIN);
			setState(417);
			statementList();
			setState(419);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BREAK) {
				{
				setState(418);
				match(BREAK);
				}
			}

			setState(421);
			match(END_M);
			setState(424);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELSE:
				{
				setState(422);
				else_();
				}
				break;
			case ELSE_IF:
				{
				setState(423);
				else_if();
				}
				break;
			case INT:
			case DOUBLE:
			case STRING:
			case BOOLEAN:
			case END_M:
			case FOR:
			case WHILE:
			case BREAK:
			case IF:
			case RETURN:
			case PRINT:
			case ID_UP:
			case ID_LOW:
				break;
			default:
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
	public static class ElseContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(TokensParser.ELSE, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public ElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterElse(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitElse(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitElse(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElseContext else_() throws RecognitionException {
		ElseContext _localctx = new ElseContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(426);
			match(ELSE);
			setState(427);
			statementList();
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
	public static class Else_ifContext extends ParserRuleContext {
		public TerminalNode ELSE_IF() { return getToken(TokensParser.ELSE_IF, 0); }
		public BoolExpressionContext boolExpression() {
			return getRuleContext(BoolExpressionContext.class,0);
		}
		public TerminalNode BEGIN() { return getToken(TokensParser.BEGIN, 0); }
		public StatementListContext statementList() {
			return getRuleContext(StatementListContext.class,0);
		}
		public TerminalNode END_M() { return getToken(TokensParser.END_M, 0); }
		public TerminalNode BREAK() { return getToken(TokensParser.BREAK, 0); }
		public Else_ifContext else_if() {
			return getRuleContext(Else_ifContext.class,0);
		}
		public Else_ifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_if; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterElse_if(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitElse_if(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitElse_if(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_ifContext else_if() throws RecognitionException {
		Else_ifContext _localctx = new Else_ifContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_else_if);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(429);
			match(ELSE_IF);
			setState(430);
			match(T__0);
			setState(431);
			boolExpression();
			setState(432);
			match(T__1);
			setState(433);
			match(BEGIN);
			setState(434);
			statementList();
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BREAK) {
				{
				setState(435);
				match(BREAK);
				}
			}

			setState(438);
			match(END_M);
			setState(440);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE_IF) {
				{
				setState(439);
				else_if();
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
	public static class PrefixContext extends ParserRuleContext {
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode INCREM() { return getToken(TokensParser.INCREM, 0); }
		public TerminalNode DECREM() { return getToken(TokensParser.DECREM, 0); }
		public PrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPrefix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPrefix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixContext prefix() throws RecognitionException {
		PrefixContext _localctx = new PrefixContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_prefix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(442);
			_la = _input.LA(1);
			if ( !(_la==INCREM || _la==DECREM) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(443);
			match(ID_LOW);
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
	public static class PostfixContext extends ParserRuleContext {
		public TerminalNode ID_LOW() { return getToken(TokensParser.ID_LOW, 0); }
		public TerminalNode INCREM() { return getToken(TokensParser.INCREM, 0); }
		public TerminalNode DECREM() { return getToken(TokensParser.DECREM, 0); }
		public PostfixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterPostfix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitPostfix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitPostfix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixContext postfix() throws RecognitionException {
		PostfixContext _localctx = new PostfixContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_postfix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(445);
			match(ID_LOW);
			setState(446);
			_la = _input.LA(1);
			if ( !(_la==INCREM || _la==DECREM) ) {
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

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParamContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(TokensParser.INT, 0); }
		public TerminalNode DOUBLE() { return getToken(TokensParser.DOUBLE, 0); }
		public TerminalNode STRING() { return getToken(TokensParser.STRING, 0); }
		public TerminalNode BOOLEAN() { return getToken(TokensParser.BOOLEAN, 0); }
		public TypeParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParam; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).enterTypeParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof TokensListener ) ((TokensListener)listener).exitTypeParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof TokensVisitor ) return ((TokensVisitor<? extends T>)visitor).visitTypeParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParamContext typeParam() throws RecognitionException {
		TypeParamContext _localctx = new TypeParamContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_typeParam);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(448);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 480L) != 0)) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001>\u01c3\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0001\u0000\u0003\u0000`\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0002\u0001\u0002\u0005\u0002l\b\u0002\n\u0002\f\u0002o\t"+
		"\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0004\u0001\u0004\u0003\u0004y\b\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004}\b\u0004\u0003\u0004\u007f\b\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0005"+
		"\u0007\u0088\b\u0007\n\u0007\f\u0007\u008b\t\u0007\u0001\u0007\u0003\u0007"+
		"\u008e\b\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0094\b\b\u0003"+
		"\b\u0096\b\b\u0001\b\u0001\b\u0003\b\u009a\b\b\u0001\b\u0001\b\u0001\b"+
		"\u0003\b\u009f\b\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0005\t\u00a6"+
		"\b\t\n\t\f\t\u00a9\t\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0005\r\u00b4\b\r\n\r\f\r\u00b7\t\r\u0001"+
		"\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0003"+
		"\u000e\u00bf\b\u000e\u0003\u000e\u00c1\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00c5\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0003\u000e\u00d1\b\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u00d9\b\u000e\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012"+
		"\u0005\u0012\u00e9\b\u0012\n\u0012\f\u0012\u00ec\t\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0003\u0013\u00f7\b\u0013\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u00fe\b\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u0108\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001"+
		"\u0017\u0005\u0017\u0114\b\u0017\n\u0017\f\u0017\u0117\t\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018\u011d\b\u0018\u0001\u0018"+
		"\u0001\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u0125\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0005\u001a\u012c\b\u001a\n\u001a\f\u001a\u012f\t\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u0134\b\u001b\n\u001b\f\u001b\u0137\t\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u013c\b\u001c\n\u001c"+
		"\f\u001c\u013f\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u014c\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0005 \u0159\b \n \f \u015c\t \u0001!\u0001!\u0003!\u0160\b!"+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0005#\u0169\b#"+
		"\n#\f#\u016c\t#\u0001$\u0001$\u0001$\u0005$\u0171\b$\n$\f$\u0174\t$\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0003%\u017b\b%\u0001&\u0001&\u0001&\u0001"+
		"&\u0001&\u0003&\u0182\b&\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0188"+
		"\b\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u018e\b\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0001(\u0001(\u0001"+
		"(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0003)\u01a4"+
		"\b)\u0001)\u0001)\u0001)\u0003)\u01a9\b)\u0001*\u0001*\u0001*\u0001+\u0001"+
		"+\u0001+\u0001+\u0001+\u0001+\u0001+\u0003+\u01b5\b+\u0001+\u0001+\u0003"+
		"+\u01b9\b+\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001.\u0001.\u0001"+
		".\u0000\u0000/\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\\u0000\n\u0001"+
		"\u000025\u0002\u0000;;>>\u0001\u0000\u0005\u0007\u0001\u0000./\u0001\u0000"+
		"\u001a\u001b\u0001\u000001\u0001\u0000\u001c\u001e\u0001\u0000$)\u0001"+
		"\u0000*+\u0001\u0000\u0005\b\u01cb\u0000_\u0001\u0000\u0000\u0000\u0002"+
		"e\u0001\u0000\u0000\u0000\u0004i\u0001\u0000\u0000\u0000\u0006p\u0001"+
		"\u0000\u0000\u0000\b~\u0001\u0000\u0000\u0000\n\u0080\u0001\u0000\u0000"+
		"\u0000\f\u0083\u0001\u0000\u0000\u0000\u000e\u008d\u0001\u0000\u0000\u0000"+
		"\u0010\u008f\u0001\u0000\u0000\u0000\u0012\u00a2\u0001\u0000\u0000\u0000"+
		"\u0014\u00aa\u0001\u0000\u0000\u0000\u0016\u00ad\u0001\u0000\u0000\u0000"+
		"\u0018\u00af\u0001\u0000\u0000\u0000\u001a\u00b1\u0001\u0000\u0000\u0000"+
		"\u001c\u00d8\u0001\u0000\u0000\u0000\u001e\u00da\u0001\u0000\u0000\u0000"+
		" \u00de\u0001\u0000\u0000\u0000\"\u00e3\u0001\u0000\u0000\u0000$\u00ea"+
		"\u0001\u0000\u0000\u0000&\u00f6\u0001\u0000\u0000\u0000(\u00f8\u0001\u0000"+
		"\u0000\u0000*\u0102\u0001\u0000\u0000\u0000,\u010b\u0001\u0000\u0000\u0000"+
		".\u0110\u0001\u0000\u0000\u00000\u0118\u0001\u0000\u0000\u00002\u0120"+
		"\u0001\u0000\u0000\u00004\u0128\u0001\u0000\u0000\u00006\u0130\u0001\u0000"+
		"\u0000\u00008\u0138\u0001\u0000\u0000\u0000:\u014b\u0001\u0000\u0000\u0000"+
		"<\u014d\u0001\u0000\u0000\u0000>\u0153\u0001\u0000\u0000\u0000@\u0155"+
		"\u0001\u0000\u0000\u0000B\u015f\u0001\u0000\u0000\u0000D\u0161\u0001\u0000"+
		"\u0000\u0000F\u0165\u0001\u0000\u0000\u0000H\u016d\u0001\u0000\u0000\u0000"+
		"J\u017a\u0001\u0000\u0000\u0000L\u017c\u0001\u0000\u0000\u0000N\u0183"+
		"\u0001\u0000\u0000\u0000P\u0194\u0001\u0000\u0000\u0000R\u019c\u0001\u0000"+
		"\u0000\u0000T\u01aa\u0001\u0000\u0000\u0000V\u01ad\u0001\u0000\u0000\u0000"+
		"X\u01ba\u0001\u0000\u0000\u0000Z\u01bd\u0001\u0000\u0000\u0000\\\u01c0"+
		"\u0001\u0000\u0000\u0000^`\u0003\u0002\u0001\u0000_^\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0003\u0004"+
		"\u0002\u0000bc\u0003\u001a\r\u0000cd\u0005\u0012\u0000\u0000d\u0001\u0001"+
		"\u0000\u0000\u0000ef\u0005\n\u0000\u0000fg\u0005=\u0000\u0000gh\u0005"+
		"\"\u0000\u0000h\u0003\u0001\u0000\u0000\u0000im\u0005\u000b\u0000\u0000"+
		"jl\u0003\u0006\u0003\u0000kj\u0001\u0000\u0000\u0000lo\u0001\u0000\u0000"+
		"\u0000mk\u0001\u0000\u0000\u0000mn\u0001\u0000\u0000\u0000n\u0005\u0001"+
		"\u0000\u0000\u0000om\u0001\u0000\u0000\u0000pq\u0005=\u0000\u0000qr\u0005"+
		"\u001f\u0000\u0000rs\u0005\f\u0000\u0000st\u0003\b\u0004\u0000tu\u0005"+
		"\u0011\u0000\u0000u\u0007\u0001\u0000\u0000\u0000vx\u0003\f\u0006\u0000"+
		"wy\u0003\n\u0005\u0000xw\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000\u0000"+
		"y\u007f\u0001\u0000\u0000\u0000z|\u0003\n\u0005\u0000{}\u0003\f\u0006"+
		"\u0000|{\u0001\u0000\u0000\u0000|}\u0001\u0000\u0000\u0000}\u007f\u0001"+
		"\u0000\u0000\u0000~v\u0001\u0000\u0000\u0000~z\u0001\u0000\u0000\u0000"+
		"\u007f\t\u0001\u0000\u0000\u0000\u0080\u0081\u00056\u0000\u0000\u0081"+
		"\u0082\u0003\u000e\u0007\u0000\u0082\u000b\u0001\u0000\u0000\u0000\u0083"+
		"\u0084\u00057\u0000\u0000\u0084\u0085\u0003\u000e\u0007\u0000\u0085\r"+
		"\u0001\u0000\u0000\u0000\u0086\u0088\u0003\u0010\b\u0000\u0087\u0086\u0001"+
		"\u0000\u0000\u0000\u0088\u008b\u0001\u0000\u0000\u0000\u0089\u0087\u0001"+
		"\u0000\u0000\u0000\u0089\u008a\u0001\u0000\u0000\u0000\u008a\u008e\u0001"+
		"\u0000\u0000\u0000\u008b\u0089\u0001\u0000\u0000\u0000\u008c\u008e\u0003"+
		"\u0016\u000b\u0000\u008d\u0089\u0001\u0000\u0000\u0000\u008d\u008c\u0001"+
		"\u0000\u0000\u0000\u008e\u000f\u0001\u0000\u0000\u0000\u008f\u0090\u0005"+
		"\f\u0000\u0000\u0090\u0095\u0005\r\u0000\u0000\u0091\u0096\u0005>\u0000"+
		"\u0000\u0092\u0094\u0005;\u0000\u0000\u0093\u0092\u0001\u0000\u0000\u0000"+
		"\u0093\u0094\u0001\u0000\u0000\u0000\u0094\u0096\u0001\u0000\u0000\u0000"+
		"\u0095\u0091\u0001\u0000\u0000\u0000\u0095\u0093\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0099\u0005\u0001\u0000\u0000"+
		"\u0098\u009a\u0003\u0012\t\u0000\u0099\u0098\u0001\u0000\u0000\u0000\u0099"+
		"\u009a\u0001\u0000\u0000\u0000\u009a\u009b\u0001\u0000\u0000\u0000\u009b"+
		"\u009e\u0005\u0002\u0000\u0000\u009c\u009d\u0005\u0003\u0000\u0000\u009d"+
		"\u009f\u0003\u0018\f\u0000\u009e\u009c\u0001\u0000\u0000\u0000\u009e\u009f"+
		"\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0\u00a1"+
		"\u0005\"\u0000\u0000\u00a1\u0011\u0001\u0000\u0000\u0000\u00a2\u00a7\u0003"+
		"\u0014\n\u0000\u00a3\u00a4\u0005\u0004\u0000\u0000\u00a4\u00a6\u0003\u0014"+
		"\n\u0000\u00a5\u00a3\u0001\u0000\u0000\u0000\u00a6\u00a9\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a5\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000"+
		"\u0000\u00a8\u0013\u0001\u0000\u0000\u0000\u00a9\u00a7\u0001\u0000\u0000"+
		"\u0000\u00aa\u00ab\u0003\\.\u0000\u00ab\u00ac\u0005>\u0000\u0000\u00ac"+
		"\u0015\u0001\u0000\u0000\u0000\u00ad\u00ae\u0003\u0006\u0003\u0000\u00ae"+
		"\u0017\u0001\u0000\u0000\u0000\u00af\u00b0\u0007\u0000\u0000\u0000\u00b0"+
		"\u0019\u0001\u0000\u0000\u0000\u00b1\u00b5\u0005\u000e\u0000\u0000\u00b2"+
		"\u00b4\u0003\u001c\u000e\u0000\u00b3\u00b2\u0001\u0000\u0000\u0000\u00b4"+
		"\u00b7\u0001\u0000\u0000\u0000\u00b5\u00b3\u0001\u0000\u0000\u0000\u00b5"+
		"\u00b6\u0001\u0000\u0000\u0000\u00b6\u001b\u0001\u0000\u0000\u0000\u00b7"+
		"\u00b5\u0001\u0000\u0000\u0000\u00b8\u00b9\u0005\f\u0000\u0000\u00b9\u00ba"+
		"\u0005\r\u0000\u0000\u00ba\u00bb\u0005=\u0000\u0000\u00bb\u00c0\u0005"+
		"!\u0000\u0000\u00bc\u00c1\u0005>\u0000\u0000\u00bd\u00bf\u0005;\u0000"+
		"\u0000\u00be\u00bd\u0001\u0000\u0000\u0000\u00be\u00bf\u0001\u0000\u0000"+
		"\u0000\u00bf\u00c1\u0001\u0000\u0000\u0000\u00c0\u00bc\u0001\u0000\u0000"+
		"\u0000\u00c0\u00be\u0001\u0000\u0000\u0000\u00c1\u00c2\u0001\u0000\u0000"+
		"\u0000\u00c2\u00c4\u0005\u0001\u0000\u0000\u00c3\u00c5\u0003\u0012\t\u0000"+
		"\u00c4\u00c3\u0001\u0000\u0000\u0000\u00c4\u00c5\u0001\u0000\u0000\u0000"+
		"\u00c5\u00c6\u0001\u0000\u0000\u0000\u00c6\u00c7\u0005\u0002\u0000\u0000"+
		"\u00c7\u00c8\u0005\"\u0000\u0000\u00c8\u00d9\u0003\u001e\u000f\u0000\u00c9"+
		"\u00ca\u0005\f\u0000\u0000\u00ca\u00cb\u0005\r\u0000\u0000\u00cb\u00cc"+
		"\u0005=\u0000\u0000\u00cc\u00cd\u0005!\u0000\u0000\u00cd\u00ce\u0005>"+
		"\u0000\u0000\u00ce\u00d0\u0005\u0001\u0000\u0000\u00cf\u00d1\u0003\u0012"+
		"\t\u0000\u00d0\u00cf\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000"+
		"\u0000\u00d1\u00d2\u0001\u0000\u0000\u0000\u00d2\u00d3\u0005\u0002\u0000"+
		"\u0000\u00d3\u00d4\u0005\u0003\u0000\u0000\u00d4\u00d5\u0003\u0018\f\u0000"+
		"\u00d5\u00d6\u0005\"\u0000\u0000\u00d6\u00d7\u0003 \u0010\u0000\u00d7"+
		"\u00d9\u0001\u0000\u0000\u0000\u00d8\u00b8\u0001\u0000\u0000\u0000\u00d8"+
		"\u00c9\u0001\u0000\u0000\u0000\u00d9\u001d\u0001\u0000\u0000\u0000\u00da"+
		"\u00db\u0005\u0010\u0000\u0000\u00db\u00dc\u0003$\u0012\u0000\u00dc\u00dd"+
		"\u0005\u0011\u0000\u0000\u00dd\u001f\u0001\u0000\u0000\u0000\u00de\u00df"+
		"\u0005\u0010\u0000\u0000\u00df\u00e0\u0003$\u0012\u0000\u00e0\u00e1\u0003"+
		"\"\u0011\u0000\u00e1\u00e2\u0005\u0011\u0000\u0000\u00e2!\u0001\u0000"+
		"\u0000\u0000\u00e3\u00e4\u0005\u0019\u0000\u0000\u00e4\u00e5\u00034\u001a"+
		"\u0000\u00e5\u00e6\u0005\"\u0000\u0000\u00e6#\u0001\u0000\u0000\u0000"+
		"\u00e7\u00e9\u0003&\u0013\u0000\u00e8\u00e7\u0001\u0000\u0000\u0000\u00e9"+
		"\u00ec\u0001\u0000\u0000\u0000\u00ea\u00e8\u0001\u0000\u0000\u0000\u00ea"+
		"\u00eb\u0001\u0000\u0000\u0000\u00eb%\u0001\u0000\u0000\u0000\u00ec\u00ea"+
		"\u0001\u0000\u0000\u0000\u00ed\u00f7\u0003,\u0016\u0000\u00ee\u00f7\u0003"+
		"0\u0018\u0000\u00ef\u00f7\u0003(\u0014\u0000\u00f0\u00f7\u0003\"\u0011"+
		"\u0000\u00f1\u00f7\u00032\u0019\u0000\u00f2\u00f7\u0003N\'\u0000\u00f3"+
		"\u00f7\u0003R)\u0000\u00f4\u00f7\u0003P(\u0000\u00f5\u00f7\u0003<\u001e"+
		"\u0000\u00f6\u00ed\u0001\u0000\u0000\u0000\u00f6\u00ee\u0001\u0000\u0000"+
		"\u0000\u00f6\u00ef\u0001\u0000\u0000\u0000\u00f6\u00f0\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f1\u0001\u0000\u0000\u0000\u00f6\u00f2\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f4\u0001\u0000\u0000"+
		"\u0000\u00f6\u00f5\u0001\u0000\u0000\u0000\u00f7\'\u0001\u0000\u0000\u0000"+
		"\u00f8\u00f9\u0005=\u0000\u0000\u00f9\u00fa\u0005!\u0000\u0000\u00fa\u00fb"+
		"\u0007\u0001\u0000\u0000\u00fb\u00fd\u0005\u0001\u0000\u0000\u00fc\u00fe"+
		"\u0003.\u0017\u0000\u00fd\u00fc\u0001\u0000\u0000\u0000\u00fd\u00fe\u0001"+
		"\u0000\u0000\u0000\u00fe\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0005"+
		"\u0002\u0000\u0000\u0100\u0101\u0005\"\u0000\u0000\u0101)\u0001\u0000"+
		"\u0000\u0000\u0102\u0103\u0005=\u0000\u0000\u0103\u0104\u0005!\u0000\u0000"+
		"\u0104\u0105\u0007\u0001\u0000\u0000\u0105\u0107\u0005\u0001\u0000\u0000"+
		"\u0106\u0108\u0003.\u0017\u0000\u0107\u0106\u0001\u0000\u0000\u0000\u0107"+
		"\u0108\u0001\u0000\u0000\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109"+
		"\u010a\u0005\u0002\u0000\u0000\u010a+\u0001\u0000\u0000\u0000\u010b\u010c"+
		"\u0005>\u0000\u0000\u010c\u010d\u0005\u001f\u0000\u0000\u010d\u010e\u0003"+
		"4\u001a\u0000\u010e\u010f\u0005\"\u0000\u0000\u010f-\u0001\u0000\u0000"+
		"\u0000\u0110\u0115\u00034\u001a\u0000\u0111\u0112\u0005\u0004\u0000\u0000"+
		"\u0112\u0114\u00034\u001a\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0114"+
		"\u0117\u0001\u0000\u0000\u0000\u0115\u0113\u0001\u0000\u0000\u0000\u0115"+
		"\u0116\u0001\u0000\u0000\u0000\u0116/\u0001\u0000\u0000\u0000\u0117\u0115"+
		"\u0001\u0000\u0000\u0000\u0118\u0119\u0007\u0002\u0000\u0000\u0119\u011c"+
		"\u0005>\u0000\u0000\u011a\u011b\u0005\u001f\u0000\u0000\u011b\u011d\u0003"+
		"4\u001a\u0000\u011c\u011a\u0001\u0000\u0000\u0000\u011c\u011d\u0001\u0000"+
		"\u0000\u0000\u011d\u011e\u0001\u0000\u0000\u0000\u011e\u011f\u0005\"\u0000"+
		"\u0000\u011f1\u0001\u0000\u0000\u0000\u0120\u0121\u0005\b\u0000\u0000"+
		"\u0121\u0124\u0005>\u0000\u0000\u0122\u0123\u0005\u001f\u0000\u0000\u0123"+
		"\u0125\u0007\u0003\u0000\u0000\u0124\u0122\u0001\u0000\u0000\u0000\u0124"+
		"\u0125\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000\u0126"+
		"\u0127\u0005\"\u0000\u0000\u01273\u0001\u0000\u0000\u0000\u0128\u012d"+
		"\u00036\u001b\u0000\u0129\u012a\u0007\u0004\u0000\u0000\u012a\u012c\u0003"+
		"6\u001b\u0000\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000"+
		"\u0000\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000"+
		"\u0000\u0000\u012e5\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000"+
		"\u0000\u0130\u0135\u00038\u001c\u0000\u0131\u0132\u0007\u0005\u0000\u0000"+
		"\u0132\u0134\u00038\u001c\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0134"+
		"\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001\u0000\u0000\u0000\u0135"+
		"\u0136\u0001\u0000\u0000\u0000\u01367\u0001\u0000\u0000\u0000\u0137\u0135"+
		"\u0001\u0000\u0000\u0000\u0138\u013d\u0003:\u001d\u0000\u0139\u013a\u0007"+
		"\u0006\u0000\u0000\u013a\u013c\u0003:\u001d\u0000\u013b\u0139\u0001\u0000"+
		"\u0000\u0000\u013c\u013f\u0001\u0000\u0000\u0000\u013d\u013b\u0001\u0000"+
		"\u0000\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e9\u0001\u0000\u0000"+
		"\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u0140\u014c\u00059\u0000\u0000"+
		"\u0141\u014c\u00058\u0000\u0000\u0142\u014c\u0005:\u0000\u0000\u0143\u014c"+
		"\u0005.\u0000\u0000\u0144\u014c\u0005/\u0000\u0000\u0145\u014c\u0005>"+
		"\u0000\u0000\u0146\u014c\u0003*\u0015\u0000\u0147\u0148\u0005\u0001\u0000"+
		"\u0000\u0148\u0149\u00034\u001a\u0000\u0149\u014a\u0005\u0002\u0000\u0000"+
		"\u014a\u014c\u0001\u0000\u0000\u0000\u014b\u0140\u0001\u0000\u0000\u0000"+
		"\u014b\u0141\u0001\u0000\u0000\u0000\u014b\u0142\u0001\u0000\u0000\u0000"+
		"\u014b\u0143\u0001\u0000\u0000\u0000\u014b\u0144\u0001\u0000\u0000\u0000"+
		"\u014b\u0145\u0001\u0000\u0000\u0000\u014b\u0146\u0001\u0000\u0000\u0000"+
		"\u014b\u0147\u0001\u0000\u0000\u0000\u014c;\u0001\u0000\u0000\u0000\u014d"+
		"\u014e\u0005<\u0000\u0000\u014e\u014f\u0005\u0001\u0000\u0000\u014f\u0150"+
		"\u0003>\u001f\u0000\u0150\u0151\u0005\u0002\u0000\u0000\u0151\u0152\u0005"+
		"\"\u0000\u0000\u0152=\u0001\u0000\u0000\u0000\u0153\u0154\u0003@ \u0000"+
		"\u0154?\u0001\u0000\u0000\u0000\u0155\u015a\u0003B!\u0000\u0156\u0157"+
		"\u0005\u001a\u0000\u0000\u0157\u0159\u0003B!\u0000\u0158\u0156\u0001\u0000"+
		"\u0000\u0000\u0159\u015c\u0001\u0000\u0000\u0000\u015a\u0158\u0001\u0000"+
		"\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015bA\u0001\u0000\u0000"+
		"\u0000\u015c\u015a\u0001\u0000\u0000\u0000\u015d\u0160\u00034\u001a\u0000"+
		"\u015e\u0160\u0005:\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f"+
		"\u015e\u0001\u0000\u0000\u0000\u0160C\u0001\u0000\u0000\u0000\u0161\u0162"+
		"\u00034\u001a\u0000\u0162\u0163\u0007\u0007\u0000\u0000\u0163\u0164\u0003"+
		"4\u001a\u0000\u0164E\u0001\u0000\u0000\u0000\u0165\u016a\u0003H$\u0000"+
		"\u0166\u0167\u0005-\u0000\u0000\u0167\u0169\u0003H$\u0000\u0168\u0166"+
		"\u0001\u0000\u0000\u0000\u0169\u016c\u0001\u0000\u0000\u0000\u016a\u0168"+
		"\u0001\u0000\u0000\u0000\u016a\u016b\u0001\u0000\u0000\u0000\u016bG\u0001"+
		"\u0000\u0000\u0000\u016c\u016a\u0001\u0000\u0000\u0000\u016d\u0172\u0003"+
		"J%\u0000\u016e\u016f\u0005,\u0000\u0000\u016f\u0171\u0003J%\u0000\u0170"+
		"\u016e\u0001\u0000\u0000\u0000\u0171\u0174\u0001\u0000\u0000\u0000\u0172"+
		"\u0170\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173"+
		"I\u0001\u0000\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0175\u0176"+
		"\u0005\u0001\u0000\u0000\u0176\u0177\u0003F#\u0000\u0177\u0178\u0005\u0002"+
		"\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u017b\u0003L&\u0000"+
		"\u017a\u0175\u0001\u0000\u0000\u0000\u017a\u0179\u0001\u0000\u0000\u0000"+
		"\u017bK\u0001\u0000\u0000\u0000\u017c\u017d\u00034\u001a\u0000\u017d\u0181"+
		"\u0007\u0007\u0000\u0000\u017e\u0182\u00034\u001a\u0000\u017f\u0182\u0005"+
		".\u0000\u0000\u0180\u0182\u0005/\u0000\u0000\u0181\u017e\u0001\u0000\u0000"+
		"\u0000\u0181\u017f\u0001\u0000\u0000\u0000\u0181\u0180\u0001\u0000\u0000"+
		"\u0000\u0182M\u0001\u0000\u0000\u0000\u0183\u0184\u0005\u0013\u0000\u0000"+
		"\u0184\u0187\u0005\u0001\u0000\u0000\u0185\u0188\u00030\u0018\u0000\u0186"+
		"\u0188\u0001\u0000\u0000\u0000\u0187\u0185\u0001\u0000\u0000\u0000\u0187"+
		"\u0186\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189"+
		"\u018a\u0003D\"\u0000\u018a\u018d\u0005\"\u0000\u0000\u018b\u018e\u0003"+
		"X,\u0000\u018c\u018e\u0003Z-\u0000\u018d\u018b\u0001\u0000\u0000\u0000"+
		"\u018d\u018c\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000"+
		"\u018f\u0190\u0005\u0002\u0000\u0000\u0190\u0191\u0005\u0010\u0000\u0000"+
		"\u0191\u0192\u0003$\u0012\u0000\u0192\u0193\u0005\u0011\u0000\u0000\u0193"+
		"O\u0001\u0000\u0000\u0000\u0194\u0195\u0005\u0014\u0000\u0000\u0195\u0196"+
		"\u0005\u0001\u0000\u0000\u0196\u0197\u0003F#\u0000\u0197\u0198\u0005\u0002"+
		"\u0000\u0000\u0198\u0199\u0005\u0010\u0000\u0000\u0199\u019a\u0003$\u0012"+
		"\u0000\u019a\u019b\u0005\u0011\u0000\u0000\u019bQ\u0001\u0000\u0000\u0000"+
		"\u019c\u019d\u0005\u0016\u0000\u0000\u019d\u019e\u0005\u0001\u0000\u0000"+
		"\u019e\u019f\u0003F#\u0000\u019f\u01a0\u0005\u0002\u0000\u0000\u01a0\u01a1"+
		"\u0005\u0010\u0000\u0000\u01a1\u01a3\u0003$\u0012\u0000\u01a2\u01a4\u0005"+
		"\u0015\u0000\u0000\u01a3\u01a2\u0001\u0000\u0000\u0000\u01a3\u01a4\u0001"+
		"\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01a8\u0005"+
		"\u0011\u0000\u0000\u01a6\u01a9\u0003T*\u0000\u01a7\u01a9\u0003V+\u0000"+
		"\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a8\u01a7\u0001\u0000\u0000\u0000"+
		"\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9S\u0001\u0000\u0000\u0000\u01aa"+
		"\u01ab\u0005\u0017\u0000\u0000\u01ab\u01ac\u0003$\u0012\u0000\u01acU\u0001"+
		"\u0000\u0000\u0000\u01ad\u01ae\u0005\u0018\u0000\u0000\u01ae\u01af\u0005"+
		"\u0001\u0000\u0000\u01af\u01b0\u0003F#\u0000\u01b0\u01b1\u0005\u0002\u0000"+
		"\u0000\u01b1\u01b2\u0005\u0010\u0000\u0000\u01b2\u01b4\u0003$\u0012\u0000"+
		"\u01b3\u01b5\u0005\u0015\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000"+
		"\u01b4\u01b5\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000"+
		"\u01b6\u01b8\u0005\u0011\u0000\u0000\u01b7\u01b9\u0003V+\u0000\u01b8\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9W\u0001"+
		"\u0000\u0000\u0000\u01ba\u01bb\u0007\b\u0000\u0000\u01bb\u01bc\u0005>"+
		"\u0000\u0000\u01bcY\u0001\u0000\u0000\u0000\u01bd\u01be\u0005>\u0000\u0000"+
		"\u01be\u01bf\u0007\b\u0000\u0000\u01bf[\u0001\u0000\u0000\u0000\u01c0"+
		"\u01c1\u0007\t\u0000\u0000\u01c1]\u0001\u0000\u0000\u0000)_mx|~\u0089"+
		"\u008d\u0093\u0095\u0099\u009e\u00a7\u00b5\u00be\u00c0\u00c4\u00d0\u00d8"+
		"\u00ea\u00f6\u00fd\u0107\u0115\u011c\u0124\u012d\u0135\u013d\u014b\u015a"+
		"\u015f\u016a\u0172\u017a\u0181\u0187\u018d\u01a3\u01a8\u01b4\u01b8";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}