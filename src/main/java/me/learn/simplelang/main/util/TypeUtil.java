package me.learn.simplelang.main.util;

import me.learn.simplelang.main.data.Global;
import me.learn.simplelang.main.data.MethodInfo;
import me.learn.simplelang.main.data.Type;
import me.learn.simplelang.main.data.VarItem;

import java.util.*;
import java.util.stream.Collectors;

public final class TypeUtil {

    public static Type max(Set<Type> a) {
        if (a == null || a.isEmpty())
            return null;

        Integer res = a.stream().map(TypeUtil::getCmpValue)
                .max(Comparator.comparing(Integer::valueOf))
                .orElseThrow(() -> new RuntimeException("can not find the proper type"));
        return getCmpType(res);
    }

    public static Type max(Type a, Type b) {
        Set<Type> types = new HashSet<>();
        types.add(a);
        types.add(b);
        return max(types);
    }

    public static List<VarItem> findVarItem(VarItem param) {
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

    public static Optional<MethodInfo> findMethodInfoByNameAndParams(String name,
                                                               int params) {
        return Global.methodInfos.stream().filter(item ->
                name.equals(item.methodName) && params == item.parameters.size())
                .findAny();
    }

    private static int getCmpValue(Type a) {
        if (a == null)
            return -1;
        switch (a) {
            case INT:
                return 0;
            case FLOAT:
                return 1;
            default:
                return 2;
        }
    }

    private static final Type getCmpType(int a) {
        if (a == -1)
            return null;
        switch (a) {
            case 0 :
                return Type.INT;
            case 1:
                return Type.FLOAT;
            default:
                return Type.STRING;
        }
    }
}
