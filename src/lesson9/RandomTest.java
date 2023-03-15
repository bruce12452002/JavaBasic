package lesson9;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        double random = Math.random(); // 0~1(不包括1)
        System.out.println(random);

        int y = (int) (Math.random() * 10); // 0~9
        System.out.println(y);
    }

    private static void utilRandom() {
        Random random = new Random();
        System.out.println(random.nextInt());
        System.out.println(random.nextInt(50)); // 0~49
        System.out.println();

        Random r2 = new Random(2); // 種子可讓每次都產生相同的隨機數，調試時有用
        for (var i = 0; i < 5; i++) {
            System.out.println(r2.nextInt(1, 20 + 1)); // 1~20
        }
    }
}
