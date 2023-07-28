package homework;

import java.util.Scanner;

public class Chapter4ChickenAndRabbit {
    /**
     * 8隻26腳
     * 20隻56腳
     */
    public static void main(String[] args) {
        h2_4_3_one();
//        h2_4_3_two();
//        chatgpt();
    }

    /**
     * 一元一次方程式
     * x=雞
     * 雞有 x 隻，兔有 8-x隻
     * 2x+4(8-x)=26
     * 2x+32-4x=26
     * -2x=-6
     * x=3雞
     * y=8-x => 5兔
     */
    private static void h2_4_3_one() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入總隻數: ");
        int totalAnimals = scanner.nextInt();
        System.out.print("請輸入總腳數: ");
        int totalLegs = scanner.nextInt();

        // 先算=右邊的數字，26-32
        int c = totalLegs - 4 * totalAnimals;
        if (-c % 2 != 0) {
            System.out.println("無法算出");
            return;
        }
        c = -c / 2; // 2x-4x 固定是 -2x，所以乘 -1 後再除 2
        int y = totalAnimals - c;

        System.out.println("雞有" + c + "隻，兔有" + y + "隻");
        scanner.close();
    }

    /**
     * 二元一次方程式
     * x=雞 y=兔
     * 2x+4y=26
     * x+y=8  => *2
     * 2x+2y=16
     * 互減
     * 2y=10
     * y=5兔
     * x+y=8
     * y=3雞
     */
    private static void h2_4_3_two() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入總隻數: ");
        int totalAnimals = scanner.nextInt();
        System.out.print("請輸入總腳數: ");
        int totalLegs = scanner.nextInt();

        if ((totalLegs - 2 * totalAnimals) % 2 != 0) {
            System.out.println("無法算出");
            return;
        }

        // 先算=右邊的數字，26-16
        int y = (totalLegs - 2 * totalAnimals) / 2;
        int x = totalAnimals - y;
        System.out.println("雞有" + x + "隻，兔有" + y + "隻");
        scanner.close();
    }

    private static void chatgpt() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入總隻數: ");
        int totalAnimals = scanner.nextInt();
        System.out.print("請輸入總腳數: ");
        int totalLegs = scanner.nextInt();

        int chickenCount = 0;
        int rabbitCount = 0;

        // i為雞；j為兔
        for (int i = 0; i <= totalAnimals; i++) {
            int j = totalAnimals - i;
            if (2 * i + 4 * j == totalLegs) {
                chickenCount = i;
                rabbitCount = j;
                break;
            }
        }

        System.out.println("雞有" + chickenCount + "隻，兔有" + rabbitCount + "隻");
        scanner.close();
    }
}
