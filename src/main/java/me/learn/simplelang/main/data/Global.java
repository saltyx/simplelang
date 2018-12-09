package me.learn.simplelang.main.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * global instance
 */
public final class Global {
    public static Map<String, Type> globalVarType = new HashMap<>();
    public static List<MethodInfo> methodInfos = new LinkedList<>();
    public static List<VarItem> typeRef = new LinkedList<>();
}
