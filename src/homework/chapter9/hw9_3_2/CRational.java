package homework.chapter9.hw9_3_2;

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

    static CRational compare(CRational r1, CRational r2) {
        float a = (float) r1.n / r1.d;
        float b = (float) r2.n / r2.d;
        System.out.println(a + ":" + b);
        return a > b ? r1 : r2;
    }
}
