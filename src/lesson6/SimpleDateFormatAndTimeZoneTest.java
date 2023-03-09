package lesson6;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatAndTimeZoneTest {
    public static void main(String[] args) throws ParseException {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        sdf.setTimeZone(TimeZone.getTimeZone("GMT") ); // 表示設定的時間是什麼時區的時間
        System.out.println(sdf.getTimeZone().getRawOffset());  // offset 單位為毫秒
        Date date = sdf.parse("2000-01-01 17:00:00.000");
        System.out.println(date);
    }
}
