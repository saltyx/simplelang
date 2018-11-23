package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.main.data.Global;
import me.learn.simplelang.main.data.MethodInfo;
import me.learn.simplelang.main.data.Type;
import org.antlr.v4.runtime.tree.ParseTree;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;

/**
 * identify variable's type
 */
public class VarTypeVisitor extends SimpleLangBaseVisitor<Type> {

    public MethodInfo currentMethod = null;
    public Map<String, Type> currentMethodParameters = new HashMap<>();
    public List<MethodInfo> methodInfos = new LinkedList<>();

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
        MethodInfo methodInfo = getMethodByMethodNameAndParameterNumber(
                ctx.VAR().getText(), ctx.expr().size());

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
    public Type visitNumberCalExpr(SimpleLangParser.NumberCalExprContext ctx) {
        return ctx.number().INT() == null ? Type.INT : Type.FLOAT ;
    }

    @Override
    public Type visitAddOrSubCalExpr(SimpleLangParser.AddOrSubCalExprContext ctx) {
        // if one var is float then use float
        if (visit(ctx.calExpr(0)) == Type.FLOAT
                || visit(ctx.calExpr(1)) == Type.FLOAT) {
            return Type.FLOAT;
        }

        return Type.INT;
    }

    @Override
    public Type visitBracketsCalExpr(SimpleLangParser.BracketsCalExprContext ctx) {
        return visit(ctx.calExpr());
    }

    @Override
    public Type visitFunctionCalExpr(SimpleLangParser.FunctionCalExprContext ctx) {
        // determine the parameters type and return method's return type
        String functionName = ctx.functionCall().VAR().getText();
        int parametersNum = ctx.functionCall().expr().size();
        MethodInfo info = getMethodByMethodNameAndParameterNumber(functionName,
                parametersNum);

        info.parametersType = ctx.functionCall().expr().stream()
                .map(this::visit).collect(Collectors.toList());

        return info.returnType;
    }

    @Override
    public Type visitMudOrDivCalExpr(SimpleLangParser.MudOrDivCalExprContext ctx) {
        if (visit(ctx.calExpr(0)) == Type.FLOAT
                || visit(ctx.calExpr(1)) == Type.FLOAT) {
            return Type.FLOAT;
        }

        return Type.INT;
    }

    @Override
    public Type visitUnaryCalExpr(SimpleLangParser.UnaryCalExprContext ctx) {
        return visit(ctx.calExpr());
    }

    @Override
    public Type visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {
        currentMethod = new MethodInfo();
        currentMethod.methodName = ctx.VAR(0).getText();

        ctx.VAR().stream().map(ParseTree::getText)
                .forEach(item ->
                    currentMethodParameters.put(item, Type.ANYTHING)
                );
        currentMethod.returnType = Type.VOID;

        visit(ctx.block());

        methodInfos.add(currentMethod.clone());

        Type returnType = currentMethod.returnType;

        currentMethod = null;
        currentMethodParameters.clear();

        return returnType;
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

    private MethodInfo getMethodByMethodNameAndParameterNumber(String methodName, int parametersNum) {
        return methodInfos.stream().filter(item ->
            item.methodName.equals(methodName) &&
                    item.parametersType.size() == parametersNum
        ).findFirst()
        .orElseThrow(() ->
            new RuntimeException("can not find method" + methodName));
    }
}
