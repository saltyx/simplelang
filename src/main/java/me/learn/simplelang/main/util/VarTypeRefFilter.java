package me.learn.simplelang.main.util;

import com.sun.istack.internal.NotNull;
import me.learn.simplelang.main.data.MethodInfo;
import me.learn.simplelang.main.data.Type;
import me.learn.simplelang.main.data.VarItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;

public final class VarTypeRefFilter {
    private final static Logger log = LoggerFactory.getLogger(VarTypeRefFilter.class);

    private final static Queue<VarItem> determinedVarQueue = new LinkedList<>();

    public static Queue<VarItem> filter(@NotNull List<VarItem> varRefs) {
        // 过滤掉ref中和引用相同的： 例如 var1 -> [var1, int] 去除var1
        for (VarItem item : varRefs) {
            if (item.isTerminal != null && item.isTerminal)
                continue;
            item.varTypeRef.remove(item);
            log.debug("{} => {}", item, item.varTypeRef);
            item.varTypeRef.removeAll(process(item));
            if (item.varTypeRef.isEmpty()) {
                item.isTerminal = true;
                determinedVarQueue.offer(item);
            }
        }

        return determinedVarQueue;
    }

    public static void identifyVarType(List<VarItem> varRefs) {
        while (!determinedVarQueue.isEmpty()) {
            VarItem dependency = determinedVarQueue.poll();
            findVarItemByDependency(dependency, varRefs);
        }
    }

    /**
     * 查找所有的依赖，替换当前确定的类型为terminal类型
     * @param dependency
     * @param varRefs
     * @return
     */
    private static void findVarItemByDependency(VarItem dependency,
                                                List<VarItem> varRefs) {

        varRefs.stream().filter(tmp -> tmp.varTypeRef != null &&
                (tmp.isTerminal == null || !tmp.isTerminal)).forEach(ref -> {
                    ref.varTypeRef.forEach(item -> {
                        if (equalVarItem(item, dependency)) {
                            ref.type = dependency.type;
                            ref.varTypeRef.remove(item);
                        }
                    });
                    // process 如同filter 函数做法
                    Set<VarItem> items = process(ref);
                    ref.varTypeRef.removeAll(items);
                    if (ref.varTypeRef.isEmpty()) {
                        ref.isTerminal = true;
                        determinedVarQueue.offer(ref);
                    }
                });
    }

    /**
     * 遍历set 确定能够发现的类型，返回确定的类型
     * @param varItem
     * @return
     */
    private static Set<VarItem> process(VarItem varItem) {
        Set<VarItem> terminalRefs = varItem.varTypeRef.stream()
                .filter(ref -> ref.isTerminal != null &&
                        ref.isTerminal)
                .collect(Collectors.toSet());

        Type tmp = TypeUtil.max(terminalRefs.stream()
                .map(refType -> refType.type)
                .collect(Collectors.toSet()));

        varItem.type = TypeUtil.max(tmp, varItem.type);

        return terminalRefs;
    }

    /**
     * 确定是否是同一个var item，但不判断类型[type]字段
     * @param item1
     * @param item2
     * @return
     */
    private static boolean equalVarItem(VarItem item1, VarItem item2) {
        return stringEquals(item1.var, item2.var) &&
               methodInfoEquals(item1.belongedMethod, item2.belongedMethod) &&
               objectEquals(item1.scope, item2.scope) &&
               objectEquals(item1.methodArgIndex, item2.methodArgIndex);
    }

    private static boolean stringEquals(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equals(str2);
    }

    private static boolean methodInfoEquals(MethodInfo methodInfo1, MethodInfo methodInfo2) {
        return methodInfo1 == null ? methodInfo2 == null : methodInfo1.equals(methodInfo2);
    }

    private static boolean objectEquals(Object obj1, Object obj2) {
        return obj1 == null ? obj2 == null : obj1.equals(obj2);
    }
}
