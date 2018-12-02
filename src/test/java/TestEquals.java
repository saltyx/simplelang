
import me.learn.simplelang.main.data.VarItem;

import java.util.*;

public class TestEquals {

    public static void main(String[] args) {

        VarItem varItem1 = new VarItem();
        varItem1.varTypeRef = new LinkedHashSet<>();
        varItem1.var = "var";

        VarItem varItem2 = new VarItem();
        varItem2.varTypeRef = new LinkedHashSet<>();
        varItem2.var = "var";



//        List<Type> types = new ArrayList<>();
//        types.add(Type.INT);
//        types.add(Type.FLOAT);
//
//        List<Type> types1 = new ArrayList<>();
//        types1.add(Type.INT);
//        types1.add(Type.INT);
//
//
//        MethodInfo info = new MethodInfo();
//        info.parametersType = types;
//
//        MethodInfo info1 = new MethodInfo();
//        info1.parametersType = types1;
//
//        Map<MethodInfo, Boolean> map = new HashMap<>();
//
//        map.put(info, false);
//        map.put(info1, true);
//
//        System.out.println(map.get(info));
//        System.out.println(map.get(info1));

        HashSet<String> h = new HashSet<>();
        h.add("arg3");
        h.add("arg1");
        h.add("arg2");

        for (String str: h) {
            System.out.println(str);
        }
    }

}
