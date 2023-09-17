package homework.chapter9.ex9_3_1;

public class app9_11 {
    public static void main(String[] args) {
        CCircle cir1 = new CCircle(1.0);
        CCircle cir2 = new CCircle(2.0);
        CCircle obj;

//        obj = cir1.compare(cir2);  // 呼叫compare() method
        obj = app9_11.compare(cir1, cir2);  // 呼叫compare() method

        if (cir1 == obj)
            System.out.println("radius of cir1 is larger");
        else
            System.out.println("radius of cir2 is larger");
    }

    public static CCircle compare(CCircle cir, CCircle cir2) { // Compare() method
        if (cir.radius > cir2.radius)
            return cir; // 傳回呼叫compare() method的物件
        else
            return cir2; // 傳回傳入compare() method的物件
    }

}
