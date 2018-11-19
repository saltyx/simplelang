package me.learn.simplelang.main;

import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/**
 * generate bytecode by asm
 */
public class Visitor extends SimpleLangBaseVisitor<Object> implements Opcodes {

    static ClassWriter classWriter ;
    static MethodVisitor methodVisitor;
    static final String OBJECT_CLASS = "java/lang/Object";
    static final String INIT = "<init>";
    static {
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_8,
                ACC_PUBLIC, "Test", null, OBJECT_CLASS, new String[]{});

        methodVisitor = classWriter.visitMethod(ACC_PUBLIC,
                INIT, "()V", null, null);

        methodVisitor.visitVarInsn(ALOAD, 0);
        methodVisitor.visitMethodInsn(INVOKESPECIAL, OBJECT_CLASS,
                INIT, "()V", false);
        methodVisitor.visitInsn(RETURN);
        methodVisitor.visitMaxs(0, 0);
        methodVisitor.visitEnd();
    }

    @Override
    public Object visitSimpleLang(SimpleLangParser.SimpleLangContext ctx) {
        System.out.println("simpleLang");
        return super.visitSimpleLang(ctx);
    }

    @Override
    public Object visitReturnStat(SimpleLangParser.ReturnStatContext ctx) {

        return visit(ctx.expr());
    }

    @Override
    public Object visitFunctionCall(SimpleLangParser.FunctionCallContext ctx) {

        return super.visitFunctionCall(ctx);
    }

    @Override
    public Object visitExpr(SimpleLangParser.ExprContext ctx) {
        return super.visitExpr(ctx);
    }

    @Override
    public Object visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {
        return super.visitFunctionDef(ctx);
    }

    @Override
    public Object visitOpMudAndDiv(SimpleLangParser.OpMudAndDivContext ctx) {
        return super.visitOpMudAndDiv(ctx);
    }

    @Override
    public Object visitOpAddAndSub(SimpleLangParser.OpAddAndSubContext ctx) {
        return super.visitOpAddAndSub(ctx);
    }

    @Override
    public Object visitOpUnary(SimpleLangParser.OpUnaryContext ctx) {
        return super.visitOpUnary(ctx);
    }

    @Override
    public Object visitVar(SimpleLangParser.VarContext ctx) {
        return super.visitVar(ctx);
    }

    @Override
    public Object visitString(SimpleLangParser.StringContext ctx) {
        return super.visitString(ctx);
    }

    @Override
    public Object visitNumber(SimpleLangParser.NumberContext ctx) {
        if ( ctx.INT() != null ) {

        }
        return super.visitNumber(ctx);
    }

}
