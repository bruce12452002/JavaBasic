package homework;

import java.util.Scanner;

public class Chapter5 {
    public static void main(String[] args) {
//        hw5_2_2();
//        ex5_2_4(93);
//        System.out.println(hw5_3(666, 8));
//        hw5_4(77);
//        System.out.println(077); // 直接轉8進制
//        hw5_8('A');
        hw5_11(9, 9, 3);
//        hw5_12(5);
//        hw5_13(3456789);
//        hw5_14();
//        hw5_15(9, 2);
//        hw5_16(7);
//        hw5_17();
//        hw5_18();
//        hw5_19(6);
//        hw5_20();
    }

    /**
     * 假設某加油站的工讀生每個月打工的薪資，可以依照下列方式計算：
     * 60個小時之內，基本時薪為每小時100元
     * 61~75個小時，以基本時薪的1.5倍計算
     * 76個小時以後以基本時薪的2.5倍計算
     * 例如，如果工作時數為80小時，則薪資為
     * 60*100 + 15*100*1.5 + 5*100*2.5 = 9500元。
     * 試撰寫一程式，設定某工讀生該月的工作時數為93小時，然後計算實領
     * 的薪資。
     * 93 -> 12750.0
     */
    private static void ex5_2_4(double hour) {
        double salary = 0;
        final double HOUR_SALARY = 100;

        if (hour <= 60) {
            salary += hour * HOUR_SALARY;
        } else {
            salary += 60 * HOUR_SALARY;
        }

        if (hour >= 61) {
            double temp = 0;
            if (hour - 75 > 0) {
                temp = hour - 75;
            }
            salary += (hour - 60 - temp) * HOUR_SALARY * 1.5;
        }

        if (hour >= 76) {
            salary += (hour - 75) * HOUR_SALARY * 2.5;
        }
        System.out.println(salary);
    }

    /**
     * 轉 x 進制
     */
    private static int hw5_3(int i, final int CARRY) {
        System.out.println(Integer.toOctalString(i));
        System.out.println("=====");
        int ten = 1;
        int result = 0;
        while (i % CARRY != 0) {
//            System.out.println(i % CARRY);

            // 將數字倒轉
            result += i % CARRY * ten;
            ten *= 10;

            i /= CARRY;
        }
        return result;
    }

    /**
     * 8 轉 10 進制
     */
    private static void hw5_4(int i) {
        System.out.println(Integer.parseInt(String.valueOf(i), 8));
        System.out.println("=====");
        final int EIGHT = 8;
        int j = 1; // 8的幾次方，預設為 8 的 0 次方
        int count = 0;

        while (i / 10 != 0) {
//            System.out.println(i % 10);
            count += (i % 10) * j;
            j *= EIGHT;
            i /= 10;
        }
//        System.out.println(i);
        count += i * j;
        System.out.println(count);
    }

    private static void hw5_8(char c) {
        if (c >= 65 && c <= 90) {
            System.out.println("您輸入的第一個字元經大小寫轉換後為:" + (char) (c + 32));
        } else if (c >= 97 && c <= 122) {
            System.out.println("您輸入的第一個字元經大小寫轉換後為:" + (char) (c - 32));
        } else {
            System.out.println("您所輸入的並不是英文字母");
        }
    }

    private static void hw5_11(int a, int b, int c) {
        int j = a * b;
        int k = a * c;
        int l = b * c;

        if (j <= k && j <= l) {
            System.out.println("最小與次小的數為" + a + " " + b + ", 兩數相乘結果為" + j);
        } else if (k <= j && k <= l) {
            System.out.println("最小與次小的數為" + a + " " + c + ", 兩數相乘結果為" + k);
        } else {
            System.out.println("最小與次小的數為" + b + " " + c + ", 兩數相乘結果為" + l);
        }
    }

    private static void hw5_13(int i) {
        int count = 1;
        while (i % 10 != 0) {
            count *= i % 10;
            i /= 10;
        }
        System.out.println(count);
    }

    private static void hw5_2_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入大於 0 的數字: ");
        final int NUM = scanner.nextInt();
        if (NUM % 5 == 0) {
            if (NUM % 6 == 0) {
                System.out.println("yes");
            }
        } else {
            System.out.println("no");
        }
        scanner.close();
    }

    //      *
    //     **
    //    ***
    //   ****
    //  *****

    /**
     * for for for
     * 行   1   2   3   4   5
     * 空   4   3   2   1   0
     * 星   1   2   3   4   5
     * 空格公式：最後一行 - 行
     * 星號公式：行
     */
    private static void hw5_12(final int START_COUNT) {
        for (int i = 1; i <= START_COUNT; i++) {
            for (int j = 1; j <= START_COUNT - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void hw5_14() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請選擇(1)三角形(2)矩形(3)梯形");
        int shape = scanner.nextInt();

        System.out.println("請輸入(下)底長");
        int down = scanner.nextInt();

        System.out.println("請輸入高");
        int high = scanner.nextInt();

        switch (shape) {
            case 1:
                System.out.println("三角形面積為：" + down * high / 2);
                break;
            case 2:
                System.out.println("矩形面積為：" + down * high);
                break;
            case 3:
                System.out.println("請輸入(上)底長");
                int up = scanner.nextInt();
                System.out.println("梯形面積為：" + (up + down) * high / 2);
                break;
            default:
                System.out.println("選錯了");
        }

        scanner.close();
    }

    private static void hw5_15(int a, int b) {
        if (a > b) { // 使得 a 一定 < b
            int temp = a;
            a = b;
            b = temp;
        }

        int count = 0;
        for (int i = a; i <= b; i++) {
            count += i;
        }
        System.out.println(count);
    }

    /*
     *    *
     *   ***
     *  *****
     * *******
     *  *****
     *   ***
     *    *
     */

    /**
     * 上三角形：
     * 想印的行數：4
     * 行 1 2 3 4
     * 空 3 2 1 0  --> 想印的行數 - 行
     * 星 1 3 5 7  --> 行 * 2 - 1 或 行+(行-1)
     * <p>
     * 下三角形：
     * 想印的行數：4 - 1
     * 行 1 2 3
     * 空 1 2 3  --> 行
     * 星 5 3 1  --> (想印的行數 - 行) * 2 + 1
     */
    private static void hw5_16(int line) {
        line = line / 2 + 1;

        // 上三角形
        for (int i = 1; i <= line; i++) {
            for (int j = 1; j <= line - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i + i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // 下三角形
        line--;
        for (int x = 1; x <= line; x++) {
            for (int y = 1; y <= x; y++) {
                System.out.print(" ");
            }
            for (int z = 1; z <= (line - x) * 2 + 1; z++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 輸入一個四位數密碼，如果輸入錯誤的話，請重新輸入，
     * 錯誤三次終止程式
     */
    private static void hw5_17() {
        Scanner scanner = new Scanner(System.in);
        final int PASSWORD = 1234; // 自定的密碼
        int i = 1;
        while (i <= 3) {
            System.out.println("請輸入一個四位數密碼：");
//            int clientPassword = ;
            if (PASSWORD == scanner.nextInt()) {
                System.out.println("登入成功，終止程式。");
                return;
            } else {
                System.out.println("密碼錯誤，請重新輸入。");
            }
            i++;
        }
        System.out.println("登入失敗，終止程式。");
        scanner.close();
    }

    /**
     * 使用 for for 迴圈設計一個(0~9 * 0~9) 的偶數乘法表
     */
    private static void hw5_18() {
        for (int i = 0; i < 9; i = i + 2) {
            for (int j = 0; j < 9; j = j + 2) {
                System.out.print(j + "=" + i + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 使用迴圈計算 1^1 +2^2+3^3+…+n^n的值（n 由使用者輸入，n 為
     * 個位數的正整數）（不得使用公式，也不得使用
     * java.lang.Math 數學類別）。執行結果如下。
     * • n介於1‐10，超出範圍則重新輸入。
     * • do‐while for‐for
     */
    private static void hw5_19(final int n) {
        if (n <= 0 || n > 10) {
            System.out.println("n 超出範圍，n 必須在 1-10 之間");
            return;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int multiply = 1;
            for (int j = 1; j <= i; j++) {
                multiply *= i;
            }
            count += multiply;
        }
        System.out.println(count);
    }

    private static void hw5_20() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("請輸入選擇(1)矩形(2)正三角形(3)倒三角形(4)菱形(請輸入奇數)：");
            int shape = scanner.nextInt();

            if (shape == 1) {
                System.out.println("輸入寬為：");
                int loop = scanner.nextInt(); // 迴圈數

                System.out.println("輸入高為：");
                int star = scanner.nextInt(); // 星星數

                for (int i = 1; i <= loop; i++) {
                    for (int j = 1; j <= star; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
            } else {
                System.out.println("請輸入高度：");
                int high = scanner.nextInt();
                if (shape == 2) {
                    for (int i = 1; i <= high; i++) {
                        for (int j = 1; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                } else if (shape == 3) {
                    for (int i = 1; i <= high; i++) {
                        for (int j = 1; j <= high + 1 - i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                } else if (shape == 4) {
                    hw5_16(high);
                    break;
                }
            }
        }
        scanner.close();
    }
}

