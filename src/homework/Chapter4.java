package homework;

import java.util.Scanner;

public class Chapter4 {
    public static void main(String[] args) {
        hw4_2();
//        hw4_4();
    }

    private static void hw4_2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入啟始和終點位置：");
        final int START = scanner.nextInt();
        final int END = scanner.nextInt();
        System.out.println((START + END) * (END - START + 1) / 2);
        scanner.close();
    }

    private static void hw4_4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入金額：");
        int money = scanner.nextInt();
        int ten = 10;
        int five = 5;

        int tenCount = money / ten;
        System.out.println("10元要 " + tenCount + " 個");
        money = money - tenCount * ten;

        int fiveCount = money / five;
        System.out.println("5元要 " + fiveCount + " 個");
        money = money - fiveCount * five;

        System.out.println("1元要 " + money + " 個");

        scanner.close();
    }

}
