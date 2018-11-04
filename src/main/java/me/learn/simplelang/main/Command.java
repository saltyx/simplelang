package me.learn.simplelang.main;

public class Command {

    public Op op;
    public Object[] values;

    public enum Op {
        PUSH, POP,
        ADD, SUB, MUL, DIV,
        CALL, RET
    }
}
