package lesson1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class NumberFormatTest {
    public static void main(String[] args) {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMinimumIntegerDigits(6); // 整數位位數
        numberFormat.setMaximumFractionDigits(2); // 小數位位數
        System.out.println(numberFormat.format(123.456));

        // java.text.DecimalFormat
        DecimalFormat decimalFormat = new DecimalFormat("######.00");
        System.out.println(decimalFormat.format(123.456));
    }
}
