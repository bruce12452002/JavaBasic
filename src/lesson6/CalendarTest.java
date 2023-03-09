package lesson6;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.println(cal.getTime());

        cal.set(Calendar.MONTH, 3 - 1); // 從 0 開始
        System.out.println(cal.getTime());

        cal.add(Calendar.MONTH, 3);
        System.out.println(cal.getTime());

        System.out.println(cal.get(Calendar.MONTH)); // 從 0 開始

        /**
         * 儒略曆（Julian calendar)、格里曆（Gregorian calendar）
         */
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        System.out.println(gregorianCalendar.isLeapYear(1900));
        System.out.println(gregorianCalendar.isLeapYear(2000));
    }
}
