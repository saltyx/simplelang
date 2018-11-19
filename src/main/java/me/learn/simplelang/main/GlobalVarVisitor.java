package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;

public class GlobalVarVisitor extends SimpleLangBaseVisitor {

    boolean isInMethod = false;

    @Override
    public Object visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {
        isInMethod = true;
        visit(ctx.block());
        isInMethod = false;
        return null;
    }

    @Override
    public Object visitAssign(SimpleLangParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }
}
