package homework;

public class Chapter7 {
    public static void main(String[] args) {
//        System.out.println(ex7_3_1(10));
//        System.out.println(ex7_3_2(5));
//        hw7_1(20);
//        hw7_6();
//        System.out.println(hw7_7(5));
//        hw7_9(2, 3, 6);
        hw7_12(50);
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
}
