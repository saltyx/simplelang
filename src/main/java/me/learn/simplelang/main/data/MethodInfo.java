package me.learn.simplelang.main.data;

import java.util.List;
import java.util.Objects;

public class MethodInfo implements Cloneable {
    public String methodName;
    public List<Type> parametersType;
    public Type returnType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodInfo that = (MethodInfo) o;
        return Objects.equals(methodName, that.methodName) &&
                Objects.equals(parametersType, that.parametersType) &&
                Objects.equals(returnType, that.returnType);
    }

    public MethodInfo clone() {
        try {
            return (MethodInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("clone not supported");
        }
    }

    @Override
    public int hashCode() {

        return Objects.hash(methodName, parametersType, returnType);
    }

    @Override
    public String toString() {
        return "MethodInfo{" +
                "methodName='" + methodName + '\'' +
                ", parametersType=" + parametersType +
                ", returnType=" + returnType +
                '}';
    }
}
