public class IfTest {
    /**
     * if 的三種行式
     * 1. 只有 if
     * 2. if-else 一對
     * 3. 在 2 的基礎上，中間有 1~多個 else if
     */
    public static void main(String[] args) {
        boolean test = true;
        if (test) {
            System.out.println("yeah");
        }

        if (!test) {
            System.out.println("yeah");
        } else {
            System.out.println("to bad");
        }

//        final int score = 85;
        final int score = 70;
        if1(score);
        if2(score);
    }

    private static void if1(int i) {
        // TODO B C 互換有問題
        if (i == 100) {
            System.out.println("A");
        } else if (i > 80) {
            System.out.println("B");
        } else if (i > 60) {
            System.out.println("C");
        } else {
            System.out.println("D");
        }
    }

    private static void if2(int i) {
        if (i == 100) {
            System.out.println("A");
        } else if (i > 60 && i < 80) {
            System.out.println("C");
        } else if (i > 80 && i < 100) {
            System.out.println("B");
        } else {
            System.out.println("D");
        }
    }
}