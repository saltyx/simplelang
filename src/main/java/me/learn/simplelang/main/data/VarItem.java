package me.learn.simplelang.main.data;

import java.util.LinkedHashSet;
import java.util.Objects;

public class VarItem implements Cloneable {
    public LinkedHashSet<VarItem> varTypeRef;
    public MethodInfo belongedMethod;
    public String var;
    public Type type;
    public Scope scope;
    public Integer methodArgIndex;
    public Boolean isTerminal;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VarItem varItem = (VarItem) o;

        if (varItem.varTypeRef == null && varTypeRef != null)
            return false;
        if (varItem.varTypeRef != null && varTypeRef == null)
            return false;
        if (varItem.varTypeRef != null) {
            if (varItem.varTypeRef.size() != varTypeRef.size())
                return false;
            for (VarItem t : varTypeRef) {
                if (!varItem.varTypeRef.contains(t))
                    return false;
            }
        }
        return Objects.equals(belongedMethod, varItem.belongedMethod) &&
                Objects.equals(var, varItem.var) &&
                Objects.equals(scope, varItem.scope) &&
                Objects.equals(type, varItem.type) &&
                Objects.equals(methodArgIndex, varItem.methodArgIndex) &&
                Objects.equals(isTerminal, varItem.isTerminal);
    }

    public VarItem clone() {
        try {
            return (VarItem) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("clone is not supported");
        }
    }

    @Override
    public String toString() {
        return "VarItem{" +
                "belongedMethod=" + belongedMethod +
                ", var='" + var + '\'' +
                ", type=" + type +
                ", scope=" + scope +
                ", methodArgIndex=" + methodArgIndex +
                ", isTerminal=" + isTerminal +
                '}';
    }

    public enum Scope {
        GLOBAL,
        METHOD_RETURN,
        METHOD_ARG,
        METHOD_TEMP_VAR,
    }
}
