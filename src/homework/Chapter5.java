package homework;

import java.util.Scanner;

public class Chapter5 {
    public static void main(String[] args) {
//        hw5_2_2();
//        ex5_2_4(93);
//        System.out.println(hw5_3(666, 8));
//        System.out.println(hw5_4(77));
//        System.out.println(077); // 直接轉8進制
//        hw5_8('A');
//        hw5_11(3, 6, 9);
        hw5_13(3456789);
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
    private static int hw5_4(int i) {
        System.out.println(Integer.parseInt(String.valueOf(i), 8));
        System.out.println("=====");

        long ten = 10;
        int j = 1; // 8 的幾次方的結果，一開始是 8 的 0 次方
        final int EIGHT = 8;
        int count = 0;

        while (true) {
            if (i < ten) {
                while (j / EIGHT != 0) {
                    ten /= 10;
                    int left = (int) (i / ten); // 數字的最左邊
                    i -= left * ten; // 將最左邊刪除
                    count += left * j;
                    j /= EIGHT;
                }
                break;
            } else {
                ten *= 10;
                j *= EIGHT;
            }
        }
        return count + i;
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

        if (j < k && j < l) {
            System.out.println("最小與次小的數為" + a + " " + b + ", 兩數相乘結果為" + j);
        } else if (k < j && k < l) {
            System.out.println("最小與次小的數為" + a + " " + c + ", 兩數相乘結果為" + k);
        } else {
            System.out.println("最小與次小的數為" + b + " " + c + ", 兩數相乘結果為" + l);
        }
    }

    private static void hw5_13(int i) {
        int count = 1;
        while (i / 10 != 0) {
            count *= i % 10;
            i /= 10;
        }
        System.out.println(count * i);
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

