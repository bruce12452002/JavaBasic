package homework.chapter9.hw9_3_2;

public class ex9_3_2 {
    public static void main(String[] args) {
        CRational aaa = new CRational();
        aaa.setND(2, 5);
        aaa.show();

        CRational bbb = new CRational();
        bbb.setND(3, 7);
        bbb.show();

        CRational result = CRational.compare(aaa, bbb);
        if (result == aaa) {
            System.out.println(aaa.n + "/" + aaa.d + " is larger");
        } else {
            System.out.println(bbb.n + "/" + bbb.d + " is larger");
        }
    }

}
