package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.main.data.Global;
import me.learn.simplelang.main.data.Type;
import me.learn.simplelang.main.data.VarItem;

import java.util.HashSet;
import java.util.LinkedHashSet;

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
    public Object visitVar(SimpleLangParser.VarContext ctx) {
        if (!isInMethod) {
            String var = ctx.VAR().getText();
            if (!Global.globalVarType.containsKey(var)) {
                Global.globalVarType.put(var, null);

                VarItem globalVar = new VarItem();
                globalVar.varTypeRef = new LinkedHashSet<>();
                globalVar.var = var;
                globalVar.scope = VarItem.Scope.GLOBAL;

                Global.typeRef.add(globalVar);
            }
        }
        return super.visitVar(ctx);
    }

}
