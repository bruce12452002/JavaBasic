package homework;

public class StarToInteger {
    public static void main(String[] args) {
        final int LINE = 6;
//        one(LINE);
//        two(LINE);
//        threeA(LINE);
        threeB(LINE);
//        four(LINE);
    }

    // 1
    // 12
    // 123
    // 1234
    // 12345

    /**
     * for for
     * 行   1   2   3   4   5
     * 星   1   2   3   4   5
     * 星號公式：行
     */
    private static void one(final int LINE) {
        for (int i = 1; i <= LINE; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    // 12345
    // 1234
    // 123
    // 12
    // 1

    /**
     * for for
     * 行   1   2   3   4   5
     * 星   5   4   3   2   1
     * 星號公式：最後一行 + 1 - 行
     */
    private static void two(final int LINE) {
        for (int i = 1; i <= LINE; i++) {
            for (int j = 1; j <= LINE + 1 - i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //      1
    //     12
    //    123
    //   1234
    //  12345

    /**
     * for for for
     * 行   1   2   3   4   5
     * 空   4   3   2   1   0
     * 星   1   2   3   4   5
     * 空格公式：最後一行 - 行
     * 星號公式：行
     */
    private static void threeA(final int LINE) {
        for (int i = 1; i <= LINE; i++) {
            for (int j = 1; j <= LINE - i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }

    //      1
    //     21
    //    321
    //   4321
    //  54321

    /**
     * for for for
     * 行   1   2   3   4   5
     * 空   4   3   2   1   0
     * 星   1   2   3   4   5
     * 空格公式：最後一行 - 行
     * 星號公式：行
     */
    private static void threeB(final int LINE) {
        for (int i = 1; i <= LINE; i++) {
            int j;
            for (j = 1; j <= LINE - i; j++) {
                System.out.print(" ");
            }
            for (int k = LINE - j; k >= 1; k--) {
                System.out.print(k);
            }
            System.out.println();
        }
    }


    //  12345
    //   1234
    //    123
    //     12
    //      1

    /**
     * for for for
     * 行   1   2   3   4   5
     * 空   0   1   2   3   4
     * 星   5   4   3   2   1
     * 空格公式：行 - 1
     * 星號公式：最後一行 + 1 - 行
     */
    private static void four(final int LINE) {
        for (int i = 1; i <= LINE; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= LINE + 1 - i; k++) {
                System.out.print(k);
            }
            System.out.println();
        }
    }
}
