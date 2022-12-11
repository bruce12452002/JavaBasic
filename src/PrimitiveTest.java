public class PrimitiveTest {
    public static void main(String[] args) {
        // byte b = 128;

        // 自動轉型 byte -> short -> int -> long -> float -> double
        byte b = 126;
        System.out.println(++b); // 127

        // 以下打開其中一個
//        System.out.println(++b); // -128
        System.out.println(b + 1); // 128


        // implicit casting
        double d = 0.5;
        System.out.println(1 + d); // 1.5
        System.out.println((int) 1 + d); // 1.5

        // explicit casting
        System.out.println((int) (1 + d)); // 1


        // 除的時候返回有小數點
        System.out.println(10 / 4); // 2
        System.out.println((float) 10 / 4); // 2.5
        System.out.println((double) 10 / 4); // 2.5

        // 預設為 double
        //float f1 = 1.0;
        float f2 = 1.0f;

        // 大寫為物件，必需給小數點或強轉
        double d1 = 67;
        Double d2 = (double) 67;
        // Double d3 = (Double)67;
        Double d4 = 67.0;
    }

}
