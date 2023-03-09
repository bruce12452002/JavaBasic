package lesson1;

import java.util.Calendar;
import java.util.Date;

/**
 * java.util.Formatter
 */
public class StringFormatTest {
    public static void main(String[] args) {
        /**
         * %第一次出現表示第一個參數；第二次出現表示第二個參數，依此類推；
         * 如果只有一個參數，仍然要有 %，也就是 % 至少要出現 1 次
         * 如果想特別表示第幾個參數要用 %2，表示第2個參數，然後顯示方式用 $ 隔開
         */
        System.out.println(String.format("%1$3s", "a", "b", "c", "d")); // 第一個參數佔3個格子
        System.out.format("%1$3s %2$5s", "a", "b", "c", "d");
        System.out.println();
        System.out.format("%3s %5s", "a", "b", "c", "d");
        System.out.println();
        System.out.format("PI = % 10.4f", Math.PI); // 包括小數點佔 10 格 -> Flags
        System.out.println();
        System.out.format("Local time: %tT", Calendar.getInstance()); // Date/Time
        System.out.println();
        System.out.format("%tH:%tM:%tS\n", new Date(), new Date(), new Date()); // Date/Time
        System.out.format("%TH:%TM:%TS\n", new Date(), new Date(), new Date()); // Date/Time
        System.out.format("%tH:%1$tM:%1$tS\n", new Date()); // Date/Time
    }
}
