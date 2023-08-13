package homework;

import java.util.Scanner;

public class Chapter7 {
    public static void main(String[] args) {
//        System.out.println(ex7_3_1(10));
//        System.out.println(ex7_3_2(5));
//        hw7_1(20);
//        hw7_6();
//        System.out.println(hw7_7(5));
//        hw7_9(2, 3, 6);
//        hw7_12(50);
        hw7_13_and_14();
    }

    /**
     * sum(n)=n+sum(n‐1)，sum(1)=1
     * 用來計算 1+2 + 3 + ….. + n的值，n 值請設值為10
     */
    public static int ex7_3_1(int n) {
        if (n == 1) return 1;
        return n + ex7_3_1(n - 1);
    }

    /**
     * sum(n)=sum(n‐1)+2*n，sum(1)=2
     * 2*5+2*4+2*3+2*2+2*1
     */
    private static int ex7_3_2(int n) {
        if (n == 1) return 2;
        return 2 * n + ex7_3_2(n - 1);
    }

    /**
     * 找出某個整數的質數
     */
    private static int hw7_1(int n) {
        if (n == 1) return 1;

        boolean prime = true;
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.print(n + " ");
        }
        return hw7_1(n - 1);
    }

    /**
     * 使用迴圈設計一個程式，找出2~100 中所有的質數，每印
     * 出 5 個質數後換行顯示
     */
    private static void hw7_6() {
        int data = 100;
        int index = 0;
        int[] primeArray = new int[data / 4];
        for (int i = data; i > 1; i--) {
            boolean prime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    prime = false;
                    break;
                }
            }
            if (prime) {
                primeArray[index++] = i;
            }
        }

        // 印出質數，每 5 個換行
        for (int i = primeArray.length - 1, j = 0; i >= 0; i--, j++) {
            if (j % 5 == 0 && j != 0) {
                System.out.println();
            }
            System.out.print(primeArray[i] + " ");
        }
    }

    /**
     * 1!+2!+...+m!,(0<m<10)
     * m=5 為 153
     */
    private static int hw7_7(int m) {
        if (0 >= m || m >= 10) {
            return 0;
        }

        int sum = 1;
        for (int i = 2; i <= m; i++) {
            sum *= i;
        }
        return sum + hw7_7(m - 1);
    }

    /**
     * 允許輸入3個整
     * 數，並找出這3個整數之間，相差最少的數字差距
     */
    private static void hw7_9(int a, int b, int c) {
        int x = a - b;
        int y = a - c;
        int z = b - c;

        if (x < 0) x = -x;
        if (y < 0) y = -y;
        if (z < 0) z = -z;

        if (x <= y && x <= z) System.out.println(x);
        if (y <= x && y <= z) System.out.println(y);
        if (z <= x && z <= y) System.out.println(z);
    }

    /**
     * for迴圈計算
     * 1^2‐2^2+3^2‐4^2+…+47^2‐48^2+49^2‐n^2的值
     * 傳 50 為 ‐1275
     */
    private static void hw7_12(int n) {
        int count = 0;
        for (int i = 1, j = 1; i <= n; i++, j++) {
            int temp = i * i;
            if (j % 2 == 0) {
                count -= temp;
            } else {
                if (count != 0) {
                    count += temp;
                } else {
                    count = temp; // 第一次
                }
            }
        }
        System.out.println(count);
    }

    /**
     * 一隻蝸牛爬一顆10公尺的大樹，白天
     * 往上爬2公尺，但晚上會掉下1公尺，請問要
     * 幾天才可爬到樹頂？請設計一程式，利用
     * do while迴圈指令來解決蝸牛爬樹問題
     */
    private static void hw7_13_and_14() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入樹高");
        int treeHigh = scanner.nextInt();

        int day = 1;
        float high = 0;
        do {
            high += 2;
            System.out.println("第" + day + "天的白天爬到：" + high);
            if (high >= treeHigh) break;

            high -= 1;
            System.out.println("晚上下降成：" + high);
            System.out.println("‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐");
            day++;
        } while (true);
        System.out.println("蝸牛一共花了：" + day + "天爬到頂。");
        scanner.close();
    }
}
