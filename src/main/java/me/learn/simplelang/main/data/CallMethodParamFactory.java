package me.learn.simplelang.main.data;

import java.util.List;

public class CallMethodParamFactory {

    public static String create(List<Type> types) {
        if (types.size() < 1)
            return null;
        if (types.size()== 1)
            return "()" + getTypeString(types.get(0));

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("(");
        for (int i = 0; i < types.size()-1; i++) {
             stringBuilder.append(getTypeString(types.get(i)));
        }
        stringBuilder.append(")");
        stringBuilder.append(getTypeString(types.get(types.size()-1)));

        return stringBuilder.toString();
    }

    public static String getTypeString(Type type) {
        switch (type) {
            case INT:
                return "I";
            case FLOAT:
                return "F";
            case STRING:
                return "Ljava/lang/String;";
        }
        return null;
    }

}
