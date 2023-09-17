package homework.chapter9.ex9_3_2;

public class ex9_3_2 {
    public static void main(String[] args) {
        CRational aaa = new CRational();
        aaa.setN(2);
        aaa.setD(5);
        aaa.show();

        aaa.setND(3, 7);
        aaa.show();

        // -----------------------------------------
        CRational bbb = new CRational();
        ex9_3_2 e = new ex9_3_2();
        bbb.setN(2);
        bbb.setD(5);
        e.show(bbb);

        bbb.setND(3, 7);
        e.show(bbb);
    }

    public void show(CRational c) {
        System.out.println(c.n + "/" + c.d);
    }
}
