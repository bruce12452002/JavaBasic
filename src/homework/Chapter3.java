package homework;

public class Chapter3 {
    public static void main(String[] args) {
        hw3_2();
    }

    private static void hw3_2() {
        int a = 2, b = 6, c = 4, d = 5, e = 6;
        int up = b * b - 4 * a * c;
        // System.out.println(up); // 36-32=4

        double down = d + 1.0 / (2 * e);
        double result = up / down;
        System.out.println(result);
    }
}
