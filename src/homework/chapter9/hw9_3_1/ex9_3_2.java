package homework.chapter9.hw9_3_1;

public class ex9_3_2 {
    public static void main(String[] args) {
        CRational aaa = new CRational();
        aaa.setN(2);
        aaa.setD(5);
        aaa.show();

//        aaa.setND(3, 7);
        aaa.show();

        // -----------------------------------------
        CRational bbb = new CRational();
        ex9_3_2 e = new ex9_3_2();
//        bbb.setN(2);
//        bbb.setD(5);
//        e.show(bbb);

        bbb.setND(3, 7);
//        e.show(bbb);

        CRational.add(aaa, bbb);
        CRational.sub(aaa, bbb);
        CRational.mul(aaa, bbb);
        CRational.div(aaa, bbb);
    }

    public void show(CRational r) {
        System.out.println(r.n + "/" + r.d);
    }


}
