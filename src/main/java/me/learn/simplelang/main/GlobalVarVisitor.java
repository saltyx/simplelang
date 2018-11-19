package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.main.data.Global;
import me.learn.simplelang.main.data.Type;

/**
 * record global variable
 */
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
        Global.globalVarType.put(ctx.VAR().getText(), Type.ANYTHING);
        return visit(ctx.expr());
    }
}
