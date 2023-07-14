package homework;

import java.util.Scanner;

public class Chapter5 {
    public static void main(String[] args) {
        ex5_2_4(93);
//        hw5_2_2();
//        hw5_12(5);
//        hw5_18();
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
        if (hour >= 60) {
            salary += 60 * HOUR_SALARY;

            if (hour >= 75) {
                double temp = 0;
                if (hour - 75 > 0) {
                    temp = hour - 75;
                }
                salary += (hour - 60 - temp) * HOUR_SALARY * 1.5;
            }
            if (hour >= 76) {
                salary += (hour - 75) * HOUR_SALARY * 2.5;
            }
        }
        System.out.println(salary);
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
}
