package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.main.data.Global;
import me.learn.simplelang.main.data.MethodInfo;
import me.learn.simplelang.main.data.Type;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.*;

/**
 * identify variable's type
 */
public class VarTypeVisitor extends SimpleLangBaseVisitor<Type> {

    MethodInfo currentMethod = null;
    Map<String, Type> currentMethodParameters = new HashMap<>();
    List<MethodInfo> methodInfos = new LinkedList<>();

    @Override
    public Type visitBlock(SimpleLangParser.BlockContext ctx) {
        return super.visitBlock(ctx);
    }

    @Override
    public Type visitReturnStat(SimpleLangParser.ReturnStatContext ctx) {
        if (ctx.expr() != null) {
            Type type = visit(ctx.expr());
            currentMethod.returnType = type;
            return type;
        } else if (ctx.var() != null) {
            Type type = visit(ctx.var());
            currentMethod.returnType = type;
            return type;
        }
        return null;
    }

    @Override
    public Type visitFunctionCall(SimpleLangParser.FunctionCallContext ctx) {
        MethodInfo methodInfo = getMethodByMethodNameAndParamterNumber(
                ctx.VAR().getText(), ctx.expr().size());
        if (methodInfo == null)
            throw new RuntimeException("can not find method " + ctx.VAR().getText());
        return methodInfo.returnType;
    }

    @Override
    public Type visitExpr(SimpleLangParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Type visitAssign(SimpleLangParser.AssignContext ctx) {
        Type type = visit(ctx.expr());
        String var = ctx.VAR().getText();
        if (currentMethod == null) {
            // not in a method body
            Global.globalVarType.put(var, type);
        } else {
            currentMethodParameters.put(var, type);
        }
        return null;
    }

    @Override
    public Type visitCalExpr(SimpleLangParser.CalExprContext ctx) {
        if (ctx.number() != null) {
            return ctx.number().INT() != null ? Type.INT : Type.FLOAT;
        }
        if (ctx.var() != null) {
            return visit(ctx.var());
        }
        // TODO
        return null;
    }

    @Override
    public Type visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {
        currentMethod = new MethodInfo();

        String functionName = ctx.VAR(0).getText();
        currentMethod.methodName = functionName;

        ctx.VAR().stream().map(ParseTree::getText)
                .forEach(item ->
                    currentMethodParameters.put(item, Type.ANYTHING)
                );
        currentMethod.returnType = Type.VOID;

        visit(ctx.block());

        methodInfos.add(currentMethod.clone());

        currentMethod = null;
        currentMethodParameters.clear();

        return currentMethod.returnType;
    }

    @Override
    public Type visitOpMudAndDiv(SimpleLangParser.OpMudAndDivContext ctx) {
        return super.visitOpMudAndDiv(ctx);
    }

    @Override
    public Type visitOpAddAndSub(SimpleLangParser.OpAddAndSubContext ctx) {
        return super.visitOpAddAndSub(ctx);
    }

    @Override
    public Type visitOpUnary(SimpleLangParser.OpUnaryContext ctx) {
        return super.visitOpUnary(ctx);
    }

    @Override
    public Type visitVar(SimpleLangParser.VarContext ctx)  {
        if (currentMethod == null) {
            // not in a method
            return Global.globalVarType.get(ctx.VAR().getText());
        } else if (currentMethodParameters.get(ctx.VAR().getText()) == null) {
            // in a method
            return Global.globalVarType.get(ctx.VAR().getText());
        } else {
            return currentMethodParameters.get(ctx.VAR().getText());
        }
    }

    @Override
    public Type visitString(SimpleLangParser.StringContext ctx) {
        return Type.STRING;
    }

    @Override
    public Type visitNumber(SimpleLangParser.NumberContext ctx) {
        return ctx.INT() == null ? Type.INT : Type.FLOAT;
    }

    private MethodInfo getMethodByMethodNameAndParamterNumber(String methodName,
                                                              int paramtersNum) {
        return methodInfos.stream().filter(item ->
            item.methodName.equals(methodName) &&
                    item.parametersType.size() == paramtersNum
        ).findFirst().get();
    }
}
