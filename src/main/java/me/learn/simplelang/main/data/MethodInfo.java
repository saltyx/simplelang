package me.learn.simplelang.main.data;

import java.util.Objects;
import java.util.Set;

public class MethodInfo implements Cloneable {
    public String methodName;
    public Set<String> parameters;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodInfo info = (MethodInfo) o;

        if (parameters == null && info.parameters != null)
            return false;
        if (parameters != null && info.parameters == null)
            return false;
        if (parameters != null &&
                parameters.size() != info.parameters.size())
            return false;
        return Objects.equals(methodName, info.methodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(methodName, parameters);
    }

    public MethodInfo clone() {
        try {
            return (MethodInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("clone not supported");
        }
    }

    @Override
    public String toString() {
        return "MethodInfo{" +
                "methodName='" + methodName + '\'' +
                ", parameters=" + parameters +
                '}';
    }
}
