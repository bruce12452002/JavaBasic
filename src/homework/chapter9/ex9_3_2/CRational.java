package homework.chapter9.ex9_3_2;

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
}
