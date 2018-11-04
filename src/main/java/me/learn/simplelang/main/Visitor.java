package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Visitor extends SimpleLangBaseVisitor<Object> {

    static Map<String, Integer> methodPointer = new HashMap<>();
    static List<Command> methodCommands = new ArrayList<>();

    // temporary memory
    static Map<String, Object> tempMemory = new HashMap<>();

    static Map<String, Object> memory = new HashMap<>();

    @Override
    public Object visitReturnStat(SimpleLangParser.ReturnStatContext ctx) {
        if (ctx.var() != null) {
            String var = ctx.var().getText();
            Object result =  memory.get(var) == null ?
                    tempMemory.get(var) : memory.get(var);
            // clear temporary memory
            tempMemory.clear();
            return result;
        }

        return visit(ctx.expr());
    }

    @Override
    public Object visitFunctionCall(SimpleLangParser.FunctionCallContext ctx) {
        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitExpr(SimpleLangParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Object visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {

        return super.visitFunctionDef(ctx);
    }

    @Override
    public Object visitOpMudAndDiv(SimpleLangParser.OpMudAndDivContext ctx) {
        return super.visitOpMudAndDiv(ctx);
    }

    @Override
    public Object visitOpAddAndSub(SimpleLangParser.OpAddAndSubContext ctx) {
        return super.visitOpAddAndSub(ctx);
    }

    @Override
    public Object visitOpUnary(SimpleLangParser.OpUnaryContext ctx) {
        return super.visitOpUnary(ctx);
    }

    @Override
    public Object visitVar(SimpleLangParser.VarContext ctx) {
        return super.visitVar(ctx);
    }

    @Override
    public Object visitString(SimpleLangParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    @Override
    public Object visitNumber(SimpleLangParser.NumberContext ctx) {
        return super.visitNumber(ctx);
    }

    private static class CommandInterpreter {
        public static Object interpretMethod(String methodName) {
            int idx = methodPointer.get(methodName);
            methodCommands.get(idx);
            return runAt(idx);
            //TODO
        }

        private static Object runAt(int idx) {
            int cIdx = idx;
            Command command = null;
            while ( (command = methodCommands.get(cIdx)) != null
                    && command.op != Command.Op.RET) {

            }
            return null;
        }

        private static Object run(Command cmd) {
            switch (cmd.op) {

            }

            return null;
        }
    }
}
