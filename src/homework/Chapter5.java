package homework;

public class Chapter5 {
    public static void main(String[] args) {
        hw5_12(5);
//        hw5_18();
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
