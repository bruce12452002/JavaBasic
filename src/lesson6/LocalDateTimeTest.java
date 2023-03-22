package lesson6;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

/**
 * LocalDate
 * LocalTime
 * LocalDateTime
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();

        System.out.println("年月日=" + currentTime.toLocalDate());// 2016-12-13
        System.out.println("年=" + currentTime.getYear());// 2016
        System.out.println("1月1日到現在是第幾天=" + currentTime.getDayOfYear());// 348
        System.out.println("英文月=" + currentTime.getMonth());// DECEMBER
        System.out.println("月=" + currentTime.getMonthValue());// 12
        System.out.println("x月1日到現在是第幾天=" + currentTime.getDayOfMonth());// 13
        System.out.println("星期=" + currentTime.getDayOfWeek());// TUESDAY
        System.out.println("時=" + currentTime.getHour());// 17
        System.out.println("分=" + currentTime.getMinute());// 43
        System.out.println("秒=" + currentTime.getSecond());// 0
        System.out.println("奈秒=" + currentTime.getNano());// 427000000
        System.out.println("毫秒=" + currentTime.get(ChronoField.MILLI_OF_SECOND));

        System.out.println("getChronology=" + currentTime.getChronology());// ISO

        /**
         * 時間增減
         */
        currentTime.plusDays(-1);
        currentTime.minus(1, ChronoUnit.SECONDS);
        currentTime.plus(1, ChronoUnit.WEEKS);

        /**
         * 設定時間
         */
        LocalDateTime defineYMD = currentTime.withDayOfMonth(10).withYear(2012);
        System.out.println(defineYMD);

        /**
         * 上/下 一個日期
         * nextXXX lastXXX
         */
        LocalDateTime nextTuesday = defineYMD.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        System.out.println("下個星期二=" + nextTuesday);

        LocalDateTime one = LocalDateTime.of(defineYMD.getYear(), defineYMD.getMonth().getValue(),
                1, 0, 0); // 這個月的第一天
        LocalDateTime two = one.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println("下一個星期六(如果1號也是星期六，那就是1號)=" + two);

        LocalDateTime three = two.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("下一個星期五=" + three);


        /**
         * 日期相差
         * 開頭的P和PT固定會有，可以再 getXXX 取得數字，但時分秒是分開的，要小心
         */
        LocalDate date1 = LocalDate.now();
        System.out.println("date1=" + date1);

        LocalDate date2 = date1.plus(1, ChronoUnit.MONTHS);
        System.out.println("date2=" + date2);

        // 右邊減左邊
        Period period = Period.between(date1, date2);
        System.out.println("相差=" + period);// P1M

        LocalTime time1 = LocalTime.now();
        System.out.println("time1=" + time1);

        Duration twoHours = Duration.ofHours(-2);
        LocalTime time2 = time1.plus(twoHours);
        System.out.println("time2=" + time2);

        // 右邊減左邊
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration: " + duration);// PT-2H
    }
}
