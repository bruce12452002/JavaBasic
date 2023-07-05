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

        int x = totalLegs - 4 * totalAnimals; // 先算=右邊的數字
        if (-x % 2 != 0) {
            System.out.println("無法算出");
            return;
        }
        x = -x / 2; // 2x-4x 固定是 -2x，所以乘 -1後再除2
        int y = totalAnimals - x;

        System.out.println("雞有" + x + "隻，兔有" + y + "隻");
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
        int y = (totalLegs - 2 * totalAnimals) / 2;
        int x = totalAnimals - y;
        System.out.println("雞有" + x + "隻，兔有" + y + "隻");
        scanner.close();
    }
}
