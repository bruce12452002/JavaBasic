package lesson5;

public class RecursiveTest {
    public static void main(String[] args) {
        System.out.println(fib(5, "init"));

//        for (int i = 1; i <= 13; i++) {
//            System.out.println(fib(i));
//        }
    }

    /**
     * DFS，一路到最下面，再由右邊一層層往上爬
     * <p>
     * *             5
     * *          /     \
     * *        4        3
     * *      /  \      / \
     * *     3    2    2   1
     * *    / \  / \  / \
     * *   2  1 1  0  1 0
     * *  / \
     * * 1  0 (所以給2時，會是 1 + 0)
     */
    private static int fib(int n, String s) {
        System.out.println(s);
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = fib(n - 1, "a" + (n - 1));
        int b = fib(n - 2, "b" + (n - 2));
        System.out.println(a + ":" + b);
        return a + b;
    }

    private static int fib(int n) {
        System.out.println(n);
        if (n == 0) return 0;
        if (n == 1) return 1;
        int a = fib(n - 1);
        int b = fib(n - 2);
        System.out.println(a + ":" + b);
        return a + b;
    }
}
