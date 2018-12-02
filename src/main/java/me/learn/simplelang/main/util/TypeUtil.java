package me.learn.simplelang.main.util;

import me.learn.simplelang.main.data.Type;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

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
