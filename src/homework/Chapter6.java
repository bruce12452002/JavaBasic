package homework;

import java.util.Scanner;

public class Chapter6 {
    public static void main(String[] args) {
//        ex6_1_2();
        hw6_1();
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

    private static void hw6_1() {
        Scanner scanner = new Scanner(System.in);
        int[] ten = new int[10];
        System.out.println("請輸入 10 個整數：");

        for (int i = 0; i < ten.length; i++) {
            System.out.println("第" + (i + 1) + "個整數：");
            ten[i] = scanner.nextInt();
        }

        double count60 = 0;
        int sum = 0;
        for (int i : ten) {
            if (i > 60) {
                count60++;
                sum += i;
            }
        }
        System.out.println("陣列中大於60的有" + (int) count60 + "個");
        System.out.println("總合為" + sum);
        System.out.println("平均值為" + sum / count60);

        scanner.close();
    }
}
