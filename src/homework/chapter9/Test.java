package homework.chapter9;

/**
 * static 會先載入，然後再載入 non-static
 * 所以 static 只能調用 static
 */
public class Test {
    static int a;
    int b;

    static void fa() {
    }

    void fb() {
    }

    public static void main(String[] args) {
        /*
        System.out.println(Test.a);
        Test t = new Test();
        System.out.println(t.b);
        int ooo = new Test().b;
        Test.fa();
        t.fb();
        */

/*
        Test t1 = new Test();
        Test t2 = new Test();
        t1.b = 5;
        t2.b = 6;

        System.out.println(t1.b);
        System.out.println(t2.b);
*/

//        new Test().ooo();

        new Test().ex9_2_1();
    }

    private void ooo() {
        fa();
        fb(); // 編譯錯是正常的
    }

    private void xxx() {
        fa();
        this.fa();
        Test.fa(); // 建議用這個

        fb(); // 建議用這個
        this.fb(); // 建議用這個
    }

    private void ex9_2_1() {
        int result = Test.add2n(10);
        System.out.println(result);
    }

    private static int add2n(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += i;
        }
        return count;
    }
}
