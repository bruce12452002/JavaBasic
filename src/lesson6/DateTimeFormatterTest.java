package lesson6;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * java.time.format  DateTimeFormatter
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        LocalDateTime.parse("2000-10-10 10:10:10.999", dateTimeFormatter);

        /**
         * X
         */
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss XXX");
        ZonedDateTime tmpTimestamp = ZonedDateTime.parse("2018-07-31 12:13:14 +03:00", formatter);
        /*
        偏移量X和x:它將根據圖案字母的數量來格式化偏移量。
        除非分鐘非零，否則一個字母僅輸出小時，例如“+01”，在這種情況下，分鐘也會輸出，例如“+0130”。
        兩個字母輸出小時和分鐘，不帶冒號，例如'+0130'。
        三個字母輸出小時和分鐘，並帶有冒號，例如'+01:30'。
        四個字母輸出小時和分鐘，可選秒，不帶冒號，例如“+013015”。
        五個字母輸出小時和分鐘，可選秒，以冒號表示，例如“+01:30:15”。
        六個或更多字母會引發IllegalArgumentException。
        當要輸出的偏移量為零時，模式字母“X”(大寫)將輸出“Z”，而模式字母“x”(小寫)將輸出“+00”，“+ 0000”或“+00” :00'。

        或者，您可以使用五個字母(XXXXX)，也可以使用ZZZ或ZZZZZ代替XXX或XXXXX。
        */
    }
}
