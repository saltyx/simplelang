import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

import org.objectweb.asm.*;

public class TestASM extends ClassLoader implements Opcodes {
    public static void main(String[] args) throws Throwable {

        ClassWriter cw1 = new ClassWriter(ClassWriter.COMPUTE_FRAMES );

        cw1.visit(V1_8,
                ACC_PUBLIC,
                "TestASM", null, "java/lang/Object", new String[]{});

        cw1.visitField(ACC_PUBLIC+ACC_STATIC, "aaaaa",
                "I", null,
                null).visitEnd();
        MethodVisitor mw = cw1.visitMethod(ACC_PUBLIC+ACC_STATIC,
                "<clinit>", "()V", null,
                null);
//        mw.visitLdcInsn(2F);
        mw.visitIntInsn(BIPUSH, 128);
//        mw.visitInsn(I2F);
//        mw.visitInsn(ICONST_1);
        mw.visitInsn(INEG);
        mw.visitFieldInsn(PUTSTATIC, "TestASM",
                "aaaaa", "I");
//        mw.visitFieldInsn(GETSTATIC,
//              "TestASM",
//                "aaaaa", "I");
        mw.visitInsn(RETURN);
        mw.visitMaxs(0 ,0);
        mw.visitEnd();


        mw = cw1.visitMethod(ACC_PUBLIC,
                "<init>", "()V", null,
                null);

        mw.visitVarInsn(ALOAD, 0);
        mw.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
        mw.visitInsn(RETURN);
        mw.visitMaxs(0, 0);
        mw.visitEnd();

        MethodVisitor mw1 = cw1.visitMethod(ACC_PUBLIC+ACC_STATIC, "main",
                "([Ljava/lang/String;)V", null ,null);
        mw1.visitLdcInsn("hi from asm");
        mw1.visitVarInsn(ASTORE, 1);
        mw1.visitFieldInsn(GETSTATIC, "java/lang/System",
                "out", "Ljava/io/PrintStream;");
        mw1.visitVarInsn(ALOAD, 1);
        mw1.visitMethodInsn(INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(Ljava/lang/String;)V", false);
        mw1.visitFieldInsn(GETSTATIC,
                "java/lang/System",
                "out", "Ljava/io/PrintStream;");
        mw1.visitInsn(ICONST_0);
        mw1.visitInsn(ICONST_3);
        mw1.visitMethodInsn(INVOKESTATIC,
                "TestASM",
                "test",
                "(II)I", false);
        mw1.visitMethodInsn(INVOKEVIRTUAL,
                "java/io/PrintStream",
                "println",
                "(I)V", false);
        mw1.visitInsn(RETURN);
        mw1.visitMaxs(0, 0);
        mw1.visitEnd();

        MethodVisitor instanceMethod = cw1.visitMethod(ACC_PUBLIC
                        +ACC_STATIC,
                "test","(II)I", null, null);
        // 静态方法从0开始取 两个入参，a, b
        Label label = new Label();
        instanceMethod.visitVarInsn(ILOAD, 0); // a
        instanceMethod.visitVarInsn(ILOAD, 1); // b
        instanceMethod.visitJumpInsn(IF_ICMPLE, label); // a<=b 跳转
        instanceMethod.visitVarInsn(ILOAD, 0); // A
        instanceMethod.visitInsn(IRETURN);
        instanceMethod.visitLabel(label);
        instanceMethod.visitIincInsn(0, 1);    // ++a
        instanceMethod.visitVarInsn(ILOAD, 0);
        instanceMethod.visitVarInsn(ILOAD, 1); // b
        instanceMethod.visitMethodInsn(INVOKESTATIC,
                "TestASM", "test", "(II)I", false); // test(a, b)
        instanceMethod.visitInsn(IRETURN); // return
        instanceMethod.visitMaxs(0, 0);
        instanceMethod.visitEnd();


        byte[] data = cw1.toByteArray();
        File file = new File("TestASM.class");
        FileOutputStream fout = new FileOutputStream(file);
        fout.write(data);
        fout.close();

        TestASM loader = new TestASM();
        Class<?> c = loader.defineClass("TestASM", data, 0, data.length);
        System.out.println(c.getName());
        c.getMethods()[0].invoke(null, new Object[] { null });
    }

}
