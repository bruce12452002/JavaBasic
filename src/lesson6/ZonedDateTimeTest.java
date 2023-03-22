package lesson6;

import java.time.*;
import java.util.Calendar;
import java.util.Date;

public class ZonedDateTimeTest {
    public static void main(String[] args) {
        // ZoneId.getAvailableZoneIds().forEach(System.out::println);
        ZonedDateTime d = ZonedDateTime.parse("2007-12-03T10:15:30+05:30[Asia/Karachi]");
        System.out.println("d=" + d);

        ZoneId id = ZoneId.of("Europe/Paris"); // ZoneId.of(ZoneId.SHORT_IDS.get("ECT"));
        System.out.println("ZoneId=" + id);

        System.out.println("================================");
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println("zoneId=" + zoneId);
        ZonedDateTime zonedDateTime2 = ZonedDateTime.of(
                LocalDateTime.of(2021, 2, 20, 10, 0, 0),
                zoneId);
        System.out.println(zonedDateTime2.getOffset().getTotalSeconds() / 60 / 60); // 取得 UTC 差幾小時

        /**
         * 時間類別轉換
         */
        Date today = new Date();
        System.out.println("現在時間=" + today);

        Instant dateInstant = today.toInstant();

        // Date轉LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.ofInstant(dateInstant, zoneId);
        System.out.println("LocalDateTime=" + localDateTime);

        // Date轉ZonedDateTime
        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(dateInstant, zoneId);
        System.out.println("ZonedDateTime=" + zonedDateTime);

        // LocalDateTime轉Date
        Instant instant = localDateTime.toInstant(ZoneOffset.ofHours(8));
        Date date = Date.from(instant);
        System.out.println(date);

        // ZonedDateTime轉Date
        System.out.println(Date.from(zonedDateTime.toInstant()));

        System.out.println("================================");
        Calendar calendar = Calendar.getInstance();
        Instant calendarInstant = calendar.toInstant();

        // Calendar轉LocalDateTime
        LocalDateTime localDateTime2 = LocalDateTime.ofInstant(calendarInstant, zoneId);
        System.out.println("LocalDateTime2=" + localDateTime2);

        // Calendar轉ZonedDateTime
        ZonedDateTime zonedDateTime3 = ZonedDateTime.ofInstant(calendarInstant, zoneId);
        System.out.println("ZonedDateTime3=" + zonedDateTime3);
        OffsetDateTime offsetDateTime2 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.of("-5"));

        /*
        ZonedDateTime比LocalDateTime多了ZoneOffset和ZoneId
        ZoneOffset就是+08:00這種東東；而parse裡面的[]就是ZoneId，可以使用 ZoneId.systemDefault() 取得
        ZoneOffset.ofHours(8)裡的8，上一行印出ZonedDateTime時，可以知道
        Date和Calendar在1.8也新增了toInstant方法，可以和新的日期做轉換使用
        Date有from可以轉成ZonedDateTime和LocalDateTime；Calendar沒看到有轉換成Instant的方法，只好和以前一樣，轉換成Date了
        OffsetDateTime 並沒有考慮日光節約時間；而 ZonedDateTime 有考慮到
        GMT 是用地球公轉來表示；UTC 是用銫原子去做，是人為的，但因為地球公轉有變慢的趨勢，所以有做加 1 秒的動作，會變成 23:59:60，時間越久，GMT 和 UTC 會越差越多
        */
    }
}
