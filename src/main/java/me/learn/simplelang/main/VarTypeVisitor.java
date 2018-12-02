package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.main.data.Global;
import me.learn.simplelang.main.data.MethodInfo;
import me.learn.simplelang.main.data.Type;
import me.learn.simplelang.main.data.VarItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 确认每个变量依赖
 */
public class VarTypeVisitor extends SimpleLangBaseVisitor<Set<VarItem>> {

    private final static Logger log = LoggerFactory.getLogger(VarTypeVisitor.class);

    private static MethodInfo currentMethod = null;
    private static List<MethodInfo> methods = Global.methodInfos;

    @Override
    public Set<VarItem> visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {
        String methodName = ctx.VAR(0).getText();
        Optional<MethodInfo> existMethod = findMethodInfoByNameAndParams(
                methodName, ctx.VAR().size() - 1);
        if (existMethod.isPresent())
            throw new RuntimeException("method <" + methodName + "> already exists");

        currentMethod = new MethodInfo();
        currentMethod.methodName = methodName;
        currentMethod.parameters = new LinkedHashSet<>();

        for (int i = 1; i < ctx.VAR().size(); i++) {
            String var = ctx.VAR(i).getText();
            if (currentMethod.parameters.contains(var))
                throw new RuntimeException("parameter <" + var + "> already exists");

            currentMethod.parameters.add(var);

            VarItem item = new VarItem();
            item.scope = VarItem.Scope.METHOD_ARG;
            item.methodArgIndex = i-1;
            item.var = var;
            item.belongedMethod = currentMethod.clone();

            Global.typeRef.add(item);
        }

        methods.add(currentMethod.clone());

        visit(ctx.block());

        currentMethod = null;
        return null;
    }

    /**
     * return 依赖于右侧
     * @param ctx
     * @return
     */
    @Override
    public Set<VarItem> visitReturnStat(SimpleLangParser.ReturnStatContext ctx) {
        VarItem retVar = new VarItem();
        retVar.belongedMethod = currentMethod.clone();
        retVar.scope = VarItem.Scope.METHOD_RETURN;

        if (ctx.var() != null) {
            retVar.varTypeRef = (LinkedHashSet<VarItem>) visit(ctx.var());
        } else {
            retVar.varTypeRef = (LinkedHashSet<VarItem>) visit(ctx.expr());
        }
        Global.typeRef.add(retVar);
        currentMethod = null;
        return null;
    }

    /**
     * 调用方法可以确定方法的参数依赖于哪个变量，
     * 以及如果有左值，则看出左值的依赖于此方法的返回
     * @param ctx
     * @return
     */
    @Override
    public Set<VarItem> visitFunctionCall(SimpleLangParser.FunctionCallContext ctx) {
        String methodName = ctx.VAR().getText();
        int params = ctx.expr().size();
        Optional<MethodInfo> existMethod = findMethodInfoByNameAndParams(methodName,
                params);
        MethodInfo methodInfo = existMethod.orElseThrow(
                () -> new RuntimeException("can not find method <" + methodName + ">"));

        // 需要找出来这个方法的参数对应的var
        VarItem param = new VarItem();
        param.scope = VarItem.Scope.METHOD_ARG;
        param.belongedMethod = methodInfo;

        List<VarItem> items = findVarItem(param);
        for (int i = 0; i < items.size(); i++) {
            VarItem item = items.get(i);

            if (item.varTypeRef == null) {
                item.varTypeRef = new LinkedHashSet<>();
            }
            item.varTypeRef.addAll(visit(ctx.expr(i)));
        }

        param.scope = VarItem.Scope.METHOD_RETURN;
        return new LinkedHashSet<>(findVarItem(param));
    }

    @Override
    public Set<VarItem> visitAssign(SimpleLangParser.AssignContext ctx) {
        log.debug("current method : {}", currentMethod);
        final String var = ctx.var().getText();
        VarItem item = visit(ctx.var()).stream().findAny()
                .orElseThrow(() -> new RuntimeException("can not find variable <" + var + ">"));
        if (item.varTypeRef == null)
            item.varTypeRef = new LinkedHashSet<>();
        item.varTypeRef.addAll(visit(ctx.expr()));
        return null;
    }

    @Override
    public Set<VarItem> visitVar(SimpleLangParser.VarContext ctx) {
        String var = ctx.VAR().getText();
        log.debug("visit {}", var);
        Set<VarItem> result = new LinkedHashSet<>();

        if (isInMethod()) {
            if (isCurrentMethodArgVar(var)) {
                VarItem param = new VarItem();
                param.var = var;
                param.scope = VarItem.Scope.METHOD_ARG;
                param.belongedMethod = currentMethod;

                result.add(findVarItem(param).get(0));

            } else if (isGlobalVar(var)) {
                VarItem param = new VarItem();
                param.var = var;
                param.scope = VarItem.Scope.GLOBAL;

                result.add(findVarItem(param).get(0));
            } else {
                // 认为是局部变量
                VarItem param = new VarItem();
                param.scope = VarItem.Scope.METHOD_TEMP_VAR;
                param.var = var;
                param.belongedMethod = currentMethod;

                VarItem tempVarItem = findVarItem(param).stream().findAny()
                        .orElseGet(() -> {
                            VarItem item = new VarItem();
                            item.scope = VarItem.Scope.METHOD_TEMP_VAR;
                            item.var = var;
                            item.belongedMethod = currentMethod;
                            return item;
                        });
                Global.typeRef.add(tempVarItem);
                result.add(tempVarItem);
            }
        } else {
            if (isGlobalVar(var)) {
                VarItem param = new VarItem();
                param.var = var;
                param.scope = VarItem.Scope.GLOBAL;

                result.add(findVarItem(param).get(0));
            }
        }
        return result;
    }

    /**
     * 有可能出现 var1 = var1 + 1这种，暂时不去除这种重复依赖
     * @param ctx
     * @return
     */
    @Override
    public Set<VarItem> visitAddOrSubCalExpr(SimpleLangParser.AddOrSubCalExprContext ctx) {
        Set<VarItem> result = visit(ctx.calExpr(0));
        result.addAll(visit(ctx.calExpr(1)));
        return result;
    }

    @Override
    public Set<VarItem> visitMudOrDivCalExpr(SimpleLangParser.MudOrDivCalExprContext ctx) {
        Set<VarItem> result = visit(ctx.calExpr(0));
        result.addAll(visit(ctx.calExpr(1)));
        return result;
    }

    @Override
    public Set<VarItem> visitString(SimpleLangParser.StringContext ctx) {
        VarItem varItem = new VarItem();
        varItem.type = Type.STRING;
        varItem.isTerminal = true;

        Set<VarItem> items = new LinkedHashSet<>();
        items.add(varItem);

        if (findVarItem(varItem).isEmpty()) {
            Global.typeRef.add(varItem);
        }
        return items;
    }

    @Override
    public Set<VarItem> visitNumber(SimpleLangParser.NumberContext ctx) {
        Set<VarItem> items = new LinkedHashSet<>();
        if (ctx.INT() != null) {
            VarItem varItem = new VarItem();
            varItem.type = Type.INT;
            varItem.isTerminal = true;
            items.add(varItem);
            if (findVarItem(varItem).isEmpty()) {
                Global.typeRef.add(varItem);
            }
        }

        if (ctx.FLOAT() != null) {
            VarItem varItem = new VarItem();
            varItem.type = Type.FLOAT;
            varItem.isTerminal = true;
            items.add(varItem);
            if (findVarItem(varItem).isEmpty()) {
                Global.typeRef.add(varItem);
            }
        }

        return items;
    }

    private Optional<MethodInfo> findMethodInfoByNameAndParams(String name,
                                                               int params) {
        return methods.stream().filter(item ->
            name.equals(item.methodName) && params == item.parameters.size())
                .findAny();
    }

    private List<VarItem> findVarItem(VarItem param) {
        return Global.typeRef.stream().filter(item -> {
            boolean result = true;
            if (param.belongedMethod != null) {
                result = param.belongedMethod.equals(item.belongedMethod);
            }

            if (param.var != null) {
                result = result &&
                        param.var.equals(item.var);
            }

            if (param.scope != null) {
                result = result &&
                        param.scope == item.scope;
            }

            if (param.methodArgIndex != null) {
                result = result &&
                        param.methodArgIndex.equals(item.methodArgIndex);
            }

            if (param.isTerminal != null) {
                result = result &&
                        param.isTerminal.equals(item.isTerminal);
            }

            if (param.type != null) {
                result = result &&
                        param.type == item.type;
            }

            return result;
        }).collect(Collectors.toList());
    }

    private static boolean isInMethod() {
        return currentMethod != null;
    }

    private static boolean isGlobalVar(String var) {
        return Global.globalVarType.containsKey(var);
    }

    private static boolean isCurrentMethodArgVar(String var) {
        return currentMethod.parameters.contains(var);
    }
}
