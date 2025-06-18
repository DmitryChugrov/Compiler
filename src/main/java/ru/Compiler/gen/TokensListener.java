// Generated from D:/Compiler/src/main/java/Tokens/Tokens.g4 by ANTLR 4.13.2
package ru.Compiler.gen;


import ru.Compiler.gen.TokensParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TokensParser}.
 */
public interface TokensListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TokensParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(TokensParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(TokensParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNamespaceDeclaration(TokensParser.NamespaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNamespaceDeclaration(TokensParser.NamespaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(TokensParser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(TokensParser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(TokensParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(TokensParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(TokensParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(TokensParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#publicSection}.
	 * @param ctx the parse tree
	 */
	void enterPublicSection(TokensParser.PublicSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#publicSection}.
	 * @param ctx the parse tree
	 */
	void exitPublicSection(TokensParser.PublicSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#privateSection}.
	 * @param ctx the parse tree
	 */
	void enterPrivateSection(TokensParser.PrivateSectionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#privateSection}.
	 * @param ctx the parse tree
	 */
	void exitPrivateSection(TokensParser.PrivateSectionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassMember(TokensParser.ClassMemberContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassMember(TokensParser.ClassMemberContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(TokensParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(TokensParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(TokensParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(TokensParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(TokensParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(TokensParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#nestedClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNestedClassDeclaration(TokensParser.NestedClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#nestedClassDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNestedClassDeclaration(TokensParser.NestedClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(TokensParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(TokensParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#implementationDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImplementationDeclaration(TokensParser.ImplementationDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#implementationDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImplementationDeclaration(TokensParser.ImplementationDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void enterClassMethod(TokensParser.ClassMethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#classMethod}.
	 * @param ctx the parse tree
	 */
	void exitClassMethod(TokensParser.ClassMethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(TokensParser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(TokensParser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#returnMethodBody}.
	 * @param ctx the parse tree
	 */
	void enterReturnMethodBody(TokensParser.ReturnMethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#returnMethodBody}.
	 * @param ctx the parse tree
	 */
	void exitReturnMethodBody(TokensParser.ReturnMethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(TokensParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(TokensParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(TokensParser.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(TokensParser.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(TokensParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(TokensParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCall(TokensParser.MethodCallContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCall(TokensParser.MethodCallContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#methodCallReturn}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallReturn(TokensParser.MethodCallReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#methodCallReturn}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallReturn(TokensParser.MethodCallReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(TokensParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(TokensParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(TokensParser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(TokensParser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(TokensParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(TokensParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#booleanDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterBooleanDeclaration(TokensParser.BooleanDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#booleanDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitBooleanDeclaration(TokensParser.BooleanDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(TokensParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(TokensParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void enterShiftExpression(TokensParser.ShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#shiftExpression}.
	 * @param ctx the parse tree
	 */
	void exitShiftExpression(TokensParser.ShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(TokensParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(TokensParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(TokensParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(TokensParser.FactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(TokensParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(TokensParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#printExpression}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpression(TokensParser.PrintExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#printExpression}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpression(TokensParser.PrintExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#printAddExpr}.
	 * @param ctx the parse tree
	 */
	void enterPrintAddExpr(TokensParser.PrintAddExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#printAddExpr}.
	 * @param ctx the parse tree
	 */
	void exitPrintAddExpr(TokensParser.PrintAddExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#printAtom}.
	 * @param ctx the parse tree
	 */
	void enterPrintAtom(TokensParser.PrintAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#printAtom}.
	 * @param ctx the parse tree
	 */
	void exitPrintAtom(TokensParser.PrintAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#bool}.
	 * @param ctx the parse tree
	 */
	void enterBool(TokensParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#bool}.
	 * @param ctx the parse tree
	 */
	void exitBool(TokensParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void enterBoolExpression(TokensParser.BoolExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#boolExpression}.
	 * @param ctx the parse tree
	 */
	void exitBoolExpression(TokensParser.BoolExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void enterBoolTerm(TokensParser.BoolTermContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#boolTerm}.
	 * @param ctx the parse tree
	 */
	void exitBoolTerm(TokensParser.BoolTermContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void enterBoolFactor(TokensParser.BoolFactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#boolFactor}.
	 * @param ctx the parse tree
	 */
	void exitBoolFactor(TokensParser.BoolFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#comparison}.
	 * @param ctx the parse tree
	 */
	void enterComparison(TokensParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#comparison}.
	 * @param ctx the parse tree
	 */
	void exitComparison(TokensParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#for}.
	 * @param ctx the parse tree
	 */
	void enterFor(TokensParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#for}.
	 * @param ctx the parse tree
	 */
	void exitFor(TokensParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#while}.
	 * @param ctx the parse tree
	 */
	void enterWhile(TokensParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#while}.
	 * @param ctx the parse tree
	 */
	void exitWhile(TokensParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#if}.
	 * @param ctx the parse tree
	 */
	void enterIf(TokensParser.IfContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#if}.
	 * @param ctx the parse tree
	 */
	void exitIf(TokensParser.IfContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#else}.
	 * @param ctx the parse tree
	 */
	void enterElse(TokensParser.ElseContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#else}.
	 * @param ctx the parse tree
	 */
	void exitElse(TokensParser.ElseContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#else_if}.
	 * @param ctx the parse tree
	 */
	void enterElse_if(TokensParser.Else_ifContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#else_if}.
	 * @param ctx the parse tree
	 */
	void exitElse_if(TokensParser.Else_ifContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#prefix}.
	 * @param ctx the parse tree
	 */
	void enterPrefix(TokensParser.PrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#prefix}.
	 * @param ctx the parse tree
	 */
	void exitPrefix(TokensParser.PrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#postfix}.
	 * @param ctx the parse tree
	 */
	void enterPostfix(TokensParser.PostfixContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#postfix}.
	 * @param ctx the parse tree
	 */
	void exitPostfix(TokensParser.PostfixContext ctx);
	/**
	 * Enter a parse tree produced by {@link TokensParser#typeParam}.
	 * @param ctx the parse tree
	 */
	void enterTypeParam(TokensParser.TypeParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link TokensParser#typeParam}.
	 * @param ctx the parse tree
	 */
	void exitTypeParam(TokensParser.TypeParamContext ctx);
}