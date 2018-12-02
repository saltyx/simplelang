package me.learn.simplelang.main.util;

import com.sun.istack.internal.NotNull;
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
            HashSet<VarItem> refs = item.varTypeRef;
            refs.remove(item);
            log.debug("{} => {}", item, refs);

            refs.removeAll(process(refs, item));

            if (refs.isEmpty()) {
                item.isTerminal = true;
                determinedVarQueue.offer(item);
            }
        }

        return determinedVarQueue;
    }

    /**
     *
     * @param queue
     */
    public static void identifyVarType(Queue<VarItem> queue, List<VarItem> varRefs) {
        while (!queue.isEmpty()) {

        }
    }

    /**
     * 查找所有的依赖，替换当前确定的类型为terminal类型
     * @param dependency
     * @param varRefs
     * @return
     */
    private static List<VarItem> findVarItemByDependency(VarItem dependency,
                                                         List<VarItem> varRefs) {
        List<VarItem> result = new LinkedList<>();
        varRefs.forEach(ref -> {
            ref.varTypeRef.forEach(item -> {
                if (equalVarItem(item, dependency)) {
                    item.type = dependency.type;
                    item.isTerminal = true;
                    // TODO process 如同filter 函数做法
                    process(ref.varTypeRef, item);
                }
            });
        });

        return result;
    }

    /**
     * 遍历set 确定能够发现的类型，返回确定的类型
     * @param refs
     * @param varItem
     * @return
     */
    private static Set<VarItem> process(Set<VarItem> refs, VarItem varItem) {
        Set<VarItem> terminalRefs = refs.stream()
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
        return item1.var.equals(item2.var) &&
               ( (item1.belongedMethod == null && item2.belongedMethod == null) ||
                       (item1.belongedMethod != null && item2.belongedMethod != null &&
                        item1.belongedMethod.equals(item2.belongedMethod) ) ) &&
               item1.scope == item2.scope &&
               item1.methodArgIndex.equals(item2.methodArgIndex);
    }
}
