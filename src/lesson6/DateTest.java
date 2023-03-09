package lesson6;

import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        long time = date.getTime();
        date.setTime(time - 86400_000);
        System.out.println(date);


        Date d1 = new Date(100, 1 - 1, 1); // 年會加 1900，月從 0 開始
        Date d2 = new Date(101, 1 - 1, 1); // 年會加 1900，月從 0 開始
        System.out.println(d1);

        System.out.println(d1.after(d2)); // d1 在 d2 之後嗎
        System.out.println(d1.equals(d2)); // d1 和 d2 日期一樣嗎
        System.out.println(d1.before(d2)); // d1 在 d2 之前嗎
    }
}
