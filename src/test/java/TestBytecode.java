
public class TestBytecode {

//    static int aa = 128;
//    static float bb = f2(aa);
//    static float cc = f2((float) 1.2);

    public static void main(String[] args) {
        int test = -9;
        test = -(8+test);
        test = -(7);
        test = 6;
        test = 5;
        test = 4;
        test = 0;

        System.out.println("2147483648".compareTo("2097483648"));
        String tttt = "string value";
        float test1 = (float) 0.1;

    }

//    public static float f2(float arg1) {
//        arg1 = f1(aa, 10);
//        return arg1;
//    }
//
//    public static float f1 (float a, float b) {
//        a = (float) 1.2 + a;
//        aa = 2;
//        int d = 1000;
//        float c = a + aa;
//        c = f2(c);
//        return a + b;
//    }

}
