package lesson2;

/**
 * Byte Short Integer Long Character -> Cache
 */
public class PrimitiveCacheTest {
    public static void main(String[] args) {
        Integer i1 = 100;
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i3.intValue() == i4);

        Integer i5 = null;
        Integer i6 = 50;
//        System.out.println(i5.intValue() == i6);
    }
}
