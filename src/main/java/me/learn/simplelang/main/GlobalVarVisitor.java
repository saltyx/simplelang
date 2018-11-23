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
        if (!isInMethod) {
            Global.globalVarType.put(ctx.VAR().getText(), Type.ANYTHING);
        }
        return visit(ctx.expr());
    }

    //TODO 检查全局变量值，如果可以确定值，记录下来，供判断变量类型参考
}
