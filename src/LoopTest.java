public class LoopTest {
    /**
     * 三種迴圈都可以不寫花括號，不寫花括號只能寫一行
     * break
     * continue
     * tag
     */
    public static void main(String[] args) {
        forTest();
//        whileTest();
//        doWhileTest();
//        continueBreakTest();
//        nestedLoop();
    }

    private static void forTest() {
//        for (; ; )
//            System.out.println("for");

        int count = 0;
        for (var i = 1; i <= 10; i++) {
            count += i;
            //System.out.println("i=" + i);
        }
        System.out.println("count=" + count);
    }

    private static void whileTest() {
//        while (true)
//            System.out.println("while");

        int count = 1;
        byte pow = -1;
//        while (count < 1) {
        while (count < 10) {
            count *= 2;
            pow++;
        }
        System.out.println("count=" + count);
        System.out.println("pow=" + pow);
    }

    private static void doWhileTest() {
//        do
//            System.out.println("do while");
//        while (true);

        int count = 1;
        byte pow = -1;
        do {
            count *= 2;
            pow++;
        } while (count < 10);
//        } while (count < 1);
        System.out.println("count=" + count);
        System.out.println("pow=" + pow);
    }

    private static void continueBreakTest() {
        for (var i = 0; i < 10; i = i + 1) {
//            System.out.println(i);
            if (i == 5) {
//                break;
                continue;
            }
            System.out.println(i);
        }
    }

    private static void nestedLoop() {
        for (var i = 0; i < 3; i++) {
            for (var j = 7; j < 10; j++) {
                System.out.println("i=" + i + ",j=" + j);
            }
        }
    }
}
