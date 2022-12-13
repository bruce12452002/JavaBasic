import java.util.stream.Stream;

public class PrimitiveTest {
    public static void main(String[] args) {
        // byte b = 128;
        byte b = 125;
        b = 126;
        System.out.println(++b); // 127

        // 自動轉型 byte -> short -> int -> long -> float -> double，char 只能強轉
        // 只有基本型態會自動轉型，物件不會
        // int -> byte short char 在範圍裡會自動轉換，否則編譯錯誤
        // 以下打開其中一個
//        System.out.println(++b); // -128
        System.out.println(b + 1); // 128


        // implicit casting
        double d = 0.5;
        System.out.println(1 + d); // 1.5
        System.out.println(1 + 0.5f); // 1.5

        // 除的時候
        System.out.println(10 / 4); // 2
        System.out.println(10.0 / 4.0); // 2.5
        System.out.println(10 / 4.0); // 2.5
        System.out.println(10.0 / 4); // 2.5
        System.out.println((float) 10 / 4); // 2.5
        System.out.println((double) 10 / 4); // 2.5

        // explicit casting
        System.out.println((int) 1 + d); // 1.5
        System.out.println((int) (1 + d)); // 1


        // L F D 大小寫均可
        long x = 1L;
        float y = 1F;
        double z = 1D;
        objectWrapper1(x, y, z);
        objectWrapper1(1L, 1F, 1D);
        objectWrapper1(1, 1, 1);
        objectWrapper2(x, y, z);
        objectWrapper2(1L, 1F, 1D);
//        objectWrapper2(1, 1, 1);

        // 預設為 double
        //float f1 = 1.0;
        float f2 = 1.0F;
        float f3 = (float) 1.0;

        // 大寫為物件，必需給小數點或強轉
        double d1 = 67;
        Double d2 = (double) 67;
        // Double d3 = (Double)67;
        Double d4 = 67.0;

        // JDK7 數字和浮點數(物件和基本型態)支援底線，但最前面和最後面不可用底線
        int underLine1 = 10__0000__0000;
        long underLine2 = 10__0000__0000;
        float underLine3 = 10__0000__0000.0000_01F;
        double underLine4 = 10__0000__0000.0000_01;
    }

    private static void objectWrapper1(long x, float y, double z) {
    }

    private static void objectWrapper2(Long x, Float y, Double z) {
    }

}
