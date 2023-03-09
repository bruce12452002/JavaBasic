package lesson5;

import java.util.Arrays;

public class MethodTest {
    public static void main(String[] args) {
        System.out.println(new MethodTest().m3());
        System.out.println(new MethodTest().m3(1, 2, 3));
    }

    private static String m1(int i, int j) {
        return i + "" + j;
    }

    private void m2() {
        return; // 如果沒有回傳值(void)，return 可不寫
    }

    private long m3(int... i) {
        return Arrays.stream(i).boxed().mapToInt(t -> t).summaryStatistics().getSum();
    }

    // recursive
    // with generic
}
