// Generated from D:/simplelang/src/main/java/me/learn/simplelang\SimpleLang.g4 by ANTLR 4.7
package me.learn.simplelang;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SimpleLangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SimpleLangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#simpleLang}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleLang(SimpleLangParser.SimpleLangContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SimpleLangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link SimpleLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SimpleLangParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code callFunction}
	 * labeled alternative in {@link SimpleLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunction(SimpleLangParser.CallFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defFunction}
	 * labeled alternative in {@link SimpleLangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefFunction(SimpleLangParser.DefFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#returnStat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStat(SimpleLangParser.ReturnStatContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(SimpleLangParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SimpleLangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#calExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCalExpr(SimpleLangParser.CalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(SimpleLangParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#opMudAndDiv}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpMudAndDiv(SimpleLangParser.OpMudAndDivContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#opAddAndSub}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpAddAndSub(SimpleLangParser.OpAddAndSubContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#opUnary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpUnary(SimpleLangParser.OpUnaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar(SimpleLangParser.VarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#string}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(SimpleLangParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by {@link SimpleLangParser#number}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumber(SimpleLangParser.NumberContext ctx);
}