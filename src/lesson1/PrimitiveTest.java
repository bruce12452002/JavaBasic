package lesson1;

public class PrimitiveTest {
    public static void main(String[] args) {
        System.out.print("haha");
        System.out.println("hehe\n");

        System.out.println("宣告變數");
        int hi = 4;
        System.out.println(hi);
        hi = 5;
        System.out.println(hi);

        int qoo, oqq = 7; // 宣告多個變數
//        System.out.println(qoo); // 區域變數必需給值
        System.out.println(oqq);

        int aaa, bbb, ccc;
        aaa = bbb = ccc = 10; // 一次賦多個值
        System.out.println(aaa + bbb + ccc);

        System.out.println("範圍");
        // byte 範圍為 -128~127
        // byte b = 128; // 直接編譯錯誤，因為操過範圍
        byte b = 127;
//        b = (byte) (b + 1);
//        System.out.println(b); // -128
        System.out.println(++b); // -128
        System.out.println(((Object) b).getClass().getSimpleName());
        System.out.println(((Object) (++b)).getClass().getSimpleName());
        System.out.println(((Object) (b + 1)).getClass().getSimpleName());
        System.out.println();

        System.out.println("除和餘數");
        System.out.println(10 / 4); // 2
        System.out.println(10 % 4); // 2
        System.out.println(10.0 / 4.0); // 2.5
        System.out.println(10 / 4.0); // 2.5
        System.out.println(10.0 / 4); // 2.5
        System.out.println((float) 10 / 4); // 2.5
        System.out.println((double) 10 / 4); // 2.5
        System.out.println(0.1 + 0.2);
        System.out.println();

        System.out.println("implicit casting");
        float f = 0.5f;
        System.out.println();
        System.out.println(1 + f); // 1.5
        System.out.println(1 + 0.5f); // 1.5
        System.out.println(((Object) f).getClass().getSimpleName());
        System.out.println(((Object) (1 + f)).getClass().getSimpleName());
        System.out.println();

        System.out.println("explicit casting");
        System.out.println((int) 1 + f); // 1.5
        System.out.println((int) (1 + f)); // 1
        System.out.println(((Object) ((int) 1 + f)).getClass().getSimpleName());
        System.out.println(((Object) ((int) (1 + f))).getClass().getSimpleName());
        System.out.println();

        System.out.println("尾數 LFD");
        // 預設為 int，LFD 大小寫均可，都基本型態可以不用 LFD，但 wrapper 類別就一定要有 LFD
        long x = 1L;
        float y = 1F;
        double z = 1D;

        // 預設為 double，不管是不是基本型態都要寫 F
        //float f1 = 1.0;
        float f2 = 1.0F;
        float f3 = (float) 1.0;

        // 大寫為物件，必需給小數點或強轉
        double d1 = 67;
        Double d2 = (double) 67;
//         Double d3 = (Double)67; // 0.0 + 67
        Double d4 = 67.0;
        System.out.println();

        System.out.println("底線");
        // JDK7 數字和浮點數(物件和基本型態)支援底線，但最前面和最後面不可用底線；小數點前後也不行
        int underLine1 = 10__0000__0000;
        long underLine2 = 10__0000__0000;
        float underLine3 = 10__0000__0000.0000_01F;
        double underLine4 = 10__0000__0000.0000_01;

        System.out.println("Wrapper 類別");
        // autoBoxing/autoUnboxing
        Byte bb = 5; // autoBoxing
        int c = bb + 1; // autoUnboxing

        Short ss = 5;
        Integer ii = 5;
        Long ll = 5L;
        Float ff = 5f;
        Double dd = 5.0;
        Character cc = '5';
        Boolean bool = true;

        // 注意事項
        float ff1 = 5; // int 可轉 float，但不能轉 Float
        double dd1 = 5; // int 可轉 double，但不能轉 Double
        System.out.println();

        System.out.println("var");
        var i = 8;
        System.out.println(((Object) i).getClass().getSimpleName());

        var d = 5.5;
        System.out.println(((Object) d).getClass().getSimpleName());

        var c1 = '#';
        System.out.println(((Object) c1).getClass().getSimpleName());

        var boo = false;
        System.out.println(((Object) boo).getClass().getSimpleName());
    }

}
