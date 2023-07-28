package homework;

public class Chapter6 {
    public static void main(String[] args) {
        ex6_1_2();
    }

    private static void ex6_1_2() {
        int a[] = {3, 5, 0, 3, 2, 4, 1, 6, 8, 5, 4, 3, 2};
        System.out.println(a.length);

        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= 3 && a[i] <= 6) {
                System.out.print(a[i] + " ");
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
