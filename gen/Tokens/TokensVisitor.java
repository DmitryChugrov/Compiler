// Generated from D:/Compiler/src/main/java/Tokens/Tokens.g4 by ANTLR 4.13.2
package Tokens;

package ru.Compiler;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link TokensParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface TokensVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link TokensParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(TokensParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#namespaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamespaceDeclaration(TokensParser.NamespaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaceDeclaration(TokensParser.InterfaceDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(TokensParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(TokensParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#publicSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPublicSection(TokensParser.PublicSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#privateSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrivateSection(TokensParser.PrivateSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMember(TokensParser.ClassMemberContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(TokensParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#parameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterList(TokensParser.ParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(TokensParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#nestedClassDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedClassDeclaration(TokensParser.NestedClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(TokensParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#implementationDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplementationDeclaration(TokensParser.ImplementationDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#classMethod}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMethod(TokensParser.ClassMethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#methodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodBody(TokensParser.MethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#returnMethodBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnMethodBody(TokensParser.ReturnMethodBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(TokensParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(TokensParser.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(TokensParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCall(TokensParser.MethodCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#methodCallReturn}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallReturn(TokensParser.MethodCallReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(TokensParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(TokensParser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(TokensParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#booleanDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanDeclaration(TokensParser.BooleanDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(TokensParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(TokensParser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(TokensParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(TokensParser.FactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(TokensParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#printExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpression(TokensParser.PrintExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#printAddExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintAddExpr(TokensParser.PrintAddExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#printAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintAtom(TokensParser.PrintAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#bool}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(TokensParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#boolExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpression(TokensParser.BoolExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#boolTerm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolTerm(TokensParser.BoolTermContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#boolFactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolFactor(TokensParser.BoolFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(TokensParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#for}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(TokensParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#while}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(TokensParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(TokensParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse(TokensParser.ElseContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#else_if}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElse_if(TokensParser.Else_ifContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#prefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefix(TokensParser.PrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#postfix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix(TokensParser.PostfixContext ctx);
	/**
	 * Visit a parse tree produced by {@link TokensParser#typeParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParam(TokensParser.TypeParamContext ctx);
}