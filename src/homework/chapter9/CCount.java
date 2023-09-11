package homework.chapter9;

public class CCount {
    private static int cnt;
    private int c;

    private int count() {
        return cnt;
    }

    public CCount() {
        cnt++;
        c++;
    }

    public static void setZero() {
        cnt = 0;
    }

    public static void setValue(int n) {
        cnt = n;
    }

    private int xxx() {
        return 1;
    }

    public static void main(String[] args) {
        CCount c1 = new CCount();
        System.out.println(c1.cnt); // 1
        System.out.println(c1.c); // 1

        CCount c2 = new CCount();
        System.out.println(c2.cnt); // 2
        System.out.println(c2.c); // 1

//        setZero();

        CCount c3 = new CCount();
        System.out.println(c3.cnt); // 3
        System.out.println(c3.c);// 1

    }
}
