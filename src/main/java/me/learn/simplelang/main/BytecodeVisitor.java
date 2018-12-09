package me.learn.simplelang.main;

import com.sun.org.apache.bcel.internal.generic.ICONST;
import me.learn.simplelang.SimpleLangBaseVisitor;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.SimpleLangVisitor;
import me.learn.simplelang.main.data.*;
import me.learn.simplelang.main.util.TypeUtil;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * generate bytecode by asm
 */
public class BytecodeVisitor extends SimpleLangBaseVisitor<Type> implements Opcodes {

    private static final Logger log = LoggerFactory.getLogger(BytecodeVisitor.class);

    private static final String CLASS_NAME = "Test";
    private static final String MAX_INT = "2147483648".intern();

    private static ClassWriter classWriter ;

    private static MethodVisitor mainMethodVisitor;
    private static MethodVisitor currentMethodVisitor;
    private static MethodVisitor clinitMethodVistor;

    private static MethodInfo currentMethod;

    private static Map<String, Integer> localVarIndex = new HashMap<>();

    // 用于判断是否是负数，如果是负数，整数的范围有变化
    private static boolean isNeg = false;

    public static final String OBJECT_CLASS = "java/lang/Object";
    public static final String INIT = "<init>";
    public static final String CLINIT ="<clinit>";

    static {
        classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        classWriter.visit(V1_8,
                ACC_PUBLIC, CLASS_NAME, null, OBJECT_CLASS, new String[]{});

        // 构造构造函数
        MethodVisitor constructMethodVisitor = classWriter.visitMethod(ACC_PUBLIC,
                INIT, "()V", null, null);

        constructMethodVisitor.visitVarInsn(ALOAD, 0);
        constructMethodVisitor.visitMethodInsn(INVOKESPECIAL, OBJECT_CLASS,
                INIT, "()V", false);
        constructMethodVisitor.visitInsn(RETURN);
        constructMethodVisitor.visitMaxs(0, 0);
        constructMethodVisitor.visitEnd();

        clinitMethodVistor = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC,
                CLINIT, "()V", null, null);
    }

    /**
     * 构造main方法
     * @param ctx
     * @return
     */
    @Override
    public Type visitSimpleLang(SimpleLangParser.SimpleLangContext ctx) {
        mainMethodVisitor = classWriter.visitMethod(ACC_PUBLIC + ACC_STATIC, "main",
                "([Ljava/lang/String;)V", // String[]
                null, null);
        super.visitSimpleLang(ctx);

        mainMethodVisitor.visitInsn(RETURN);
        mainMethodVisitor.visitMaxs(0 ,0);
        mainMethodVisitor.visitEnd();
        return null;
    }

    @Override
    public Type visitFunctionDef(SimpleLangParser.FunctionDefContext ctx) {
        currentMethod = TypeUtil.findMethodInfoByNameAndParams(ctx.VAR().get(0).getText(),
                ctx.VAR().size()-1).get();

        List<VarItem> methodBodyVars = TypeUtil.findVarItem(VarItemFactory.createBelondedMethodVarItem(currentMethod));
        Type retType = null;

        for (VarItem item : methodBodyVars) {
            switch (item.scope) {
                case METHOD_RETURN:
                    retType = item.type;
                    break;
                case METHOD_ARG:
                    localVarIndex.put(item.var, item.methodArgIndex);
                    break;
            }
        }

        visit(ctx.block());
        return retType;
    }

    @Override
    public Type visitReturnStat(SimpleLangParser.ReturnStatContext ctx) {
        visit(ctx.expr());
        VarItem param = VarItemFactory.createReturnVarItem(currentMethod);
        VarItem ret = TypeUtil.findVarItem(param).get(0);
        switch (ret.type) {
            case INT:
                // return int
                currentMethodVisitor.visitInsn(IRETURN);
                break;
            case FLOAT:
                // return float
                currentMethodVisitor.visitInsn(FRETURN);
                break;
            case STRING:
                // return reference
                currentMethodVisitor.visitInsn(ARETURN);
                break;
            default:
                currentMethodVisitor.visitInsn(RETURN);
                break;
        }
        currentMethodVisitor.visitMaxs(0, 0);
        currentMethodVisitor.visitEnd();

        currentMethod = null;
        localVarIndex.clear();
        return ret.type;
    }

    @Override
    public Type visitFunctionCall(SimpleLangParser.FunctionCallContext ctx) {
        MethodInfo callMethod = TypeUtil.findMethodInfoByNameAndParams(ctx.VAR().getText(),
                ctx.expr().size()).get();
        VarItem param = VarItemFactory.createMethodArgVarItem(callMethod);
        List<VarItem> methodArgs = TypeUtil.findVarItem(param);
        methodArgs.sort(Comparator.comparing((VarItem item) -> item.methodArgIndex));

        ctx.expr().forEach(this::visit);

        currentMethodVisitor.visitMethodInsn(INVOKESTATIC,
                CLASS_NAME,
                callMethod.methodName,
                CallMethodParamFactory.create(methodArgs.stream()
                        .map(varItem -> varItem.type)
                        .collect(Collectors.toList())),
                false
        );

        return TypeUtil.findVarItem(VarItemFactory.createReturnVarItem(callMethod))
                .get(0).type;
    }

    @Override
    public Type visitUnaryCalExpr(SimpleLangParser.UnaryCalExprContext ctx) {
        isNeg = ctx.opUnary().getText().equals("-");
        Type type = visit(ctx.calExpr());
        if (isNeg) {
            getMethodVisitor().visitInsn(getNegInstruction(type));
            isNeg = false;
        }
        return type;
    }

    @Override
    public Type visitAssign(SimpleLangParser.AssignContext ctx) {
        return super.visitAssign(ctx);
    }

    @Override
    public Type visitAddOrSubCalExpr(SimpleLangParser.AddOrSubCalExprContext ctx) {
        Type type1 = visit(ctx.calExpr(0));
        Type type2 = visit(ctx.calExpr(1));
        //TODO
        return super.visitAddOrSubCalExpr(ctx);
    }

    @Override
    public Type visitMudOrDivCalExpr(SimpleLangParser.MudOrDivCalExprContext ctx) {
        //TODO
        return super.visitMudOrDivCalExpr(ctx);
    }

    @Override
    public Type visitString(SimpleLangParser.StringContext ctx) {
        String string = ctx.STRING() == null ? ctx.CHARSTRING().getText() : ctx.STRING().getText();
        getMethodVisitor().visitLdcInsn(string);
        return Type.STRING;
    }

    @Override
    public Type visitNumber(SimpleLangParser.NumberContext ctx) {
        if (ctx.INT() != null) {
            String intStr = ctx.INT().getText();
            if (intStr.length() >= MAX_INT.length() &&
                    (intStr.length() > MAX_INT.length() || // 长度超过int
                     intStr.compareTo(MAX_INT) > 0      || // 大于绝对值的最大值
                    (intStr.equals(MAX_INT) && !isNeg) ) ) // 绝对值等于最大值，但是是正数
                throw new RuntimeException("number[int] is too long");

            Integer temp = Integer.valueOf(intStr);
            if (temp > 5) {
                if (temp <= 127 || (isNeg && temp == 128)) {
                    getMethodVisitor().visitIntInsn(BIPUSH, isNeg ? 0 - temp : temp);

                } else if (temp <= 32767 || (isNeg && temp == 32768)) {
                    getMethodVisitor().visitIntInsn(SIPUSH, isNeg ? 0 - temp : temp);

                } else if (temp <= 2147483647 || (isNeg && intStr.equals(MAX_INT))) {
                    if (intStr.equals(MAX_INT)) {
                        getMethodVisitor().visitLdcInsn(-2147483648);
                    } else {
                        getMethodVisitor().visitLdcInsn(isNeg ? 0 - temp : temp);
                    }

                } else {
                    throw new RuntimeException("number[int] is too long");
                }
                isNeg = !isNeg && isNeg;

            } else {
                switch (temp) {
                    case 0:
                        getMethodVisitor().visitInsn(ICONST_0);
                        break;
                    case 1:
                        getMethodVisitor().visitInsn(ICONST_1);
                        break;
                    case 2:
                        getMethodVisitor().visitInsn(ICONST_2);
                        break;
                    case 3:
                        getMethodVisitor().visitInsn(ICONST_3);
                        break;
                    case 4:
                        getMethodVisitor().visitInsn(ICONST_4);
                        break;
                    case 5:
                        getMethodVisitor().visitInsn(ICONST_5);
                        break;
                }
            }
        }

        if (ctx.FLOAT() != null) {
            getMethodVisitor().visitLdcInsn(Float.valueOf(ctx.FLOAT().getText()));
        }

        return ctx.INT() == null ? Type.FLOAT : Type.INT;
    }

    /**
     * 需要判断变量的作用域，计算临时变量需要在本地变更量表的索引
     * @param ctx
     * @return
     */
    @Override
    public Type visitVar(SimpleLangParser.VarContext ctx) {
        String var = ctx.VAR().getText();
        if (currentMethod != null) {
            // 其他方法区域
            VarItem param = VarItemFactory.createVarMethodVarItem(currentMethod, var);
            VarItem varItem = TypeUtil.findVarItem(param).get(0);
            switch (varItem.scope) {
                case GLOBAL:
                    currentMethodVisitor.visitFieldInsn(GETSTATIC,
                            CLASS_NAME,
                            var,
                            CallMethodParamFactory.getTypeString(varItem.type));
                    break;
                case METHOD_ARG: case METHOD_TEMP_VAR:
                    Integer argIndex = localVarIndex.get(var);
                    if (argIndex != null) {
                        currentMethodVisitor.visitVarInsn(getLoadInstruction(varItem.type),
                                argIndex);
                    } else {
                        // 局部变量第一次出现没有下标
                        localVarIndex.put(var, localVarIndex.keySet().size());
                    }
                    break;
            }
        } else {
            // TODO main 方法区域

        }
        return super.visitVar(ctx);
    }

    private static MethodVisitor getMethodVisitor() {
        return currentMethodVisitor == null ? mainMethodVisitor : currentMethodVisitor;
    }

    private static Integer getLoadInstruction(Type type) {
        switch (type) {
            case FLOAT:
                return FLOAD;
            case INT:
                return ILOAD;
            case STRING:
                return ALOAD;
            default:
                throw new RuntimeException("can not find proper instruction");
        }
    }

    private static Integer getNegInstruction(Type type) {
        switch (type) {
            case INT:
                return INEG;
            case FLOAT:
                return FNEG;
            default:
                throw new RuntimeException("can not find proper instruction");
        }
    }

}
