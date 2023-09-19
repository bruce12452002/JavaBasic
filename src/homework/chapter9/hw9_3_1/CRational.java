package homework.chapter9.hw9_3_1;

public class CRational {
    public int n;
    public int d;

    public void setN(int num) {// 設定分子
        n = num;
    }

    public void setD(int num) {// 設定分母
        d = num;
    }

    public void show() {
        System.out.println(n + "/" + d);
    }

    public void setND(int num, int den) {
        n = num;
        d = den;
    }

    public static void add(CRational a, CRational b) {
        final int N = a.n * b.d + b.n * a.d;
        final int D = a.d * b.d;
        System.out.println(N + "/" + D);
    }

    public static void sub(CRational a, CRational b) {
        final int N = a.n * b.d - b.n * a.d;
        final int D = a.d * b.d;
        System.out.println(N + "/" + D);
    }

    public static void mul(CRational a, CRational b) {
        final int N = a.n * b.n;
        final int D = a.d * b.d;
        System.out.println(N + "/" + D);
    }

    public static void div(CRational a, CRational b) {
        final int N = a.n * b.d;
        final int D = a.d * b.n;
        System.out.println(N + "/" + D);
    }
}
