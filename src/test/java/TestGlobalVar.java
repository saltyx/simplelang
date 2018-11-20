package me.learn.simplelang.test;

import me.learn.simplelang.SimpleLangLexer;
import me.learn.simplelang.SimpleLangParser;
import me.learn.simplelang.main.GlobalVarVisitor;
import me.learn.simplelang.main.data.Global;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.FileInputStream;
import java.io.IOException;

public class TestGlobalVar {

    public static void main(String[] args) throws IOException {
        String filePath = TestGlobalVar.class.getClassLoader().getResource("test.sl").getFile();
        System.out.println(filePath);
        ANTLRInputStream inputStream =  new ANTLRInputStream(
                new FileInputStream(filePath));
        SimpleLangLexer lexer = new SimpleLangLexer(inputStream);
        CommonTokenStream stream = new CommonTokenStream(lexer);
        SimpleLangParser parser = new SimpleLangParser(stream);
        GlobalVarVisitor visitor = new GlobalVarVisitor();
        visitor.visit(parser.simpleLang());

        System.out.println(Global.globalVarType);
    }

}
