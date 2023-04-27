package lesson13;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Properties 只能打 ISO8859-1 編碼，也就是英文字，但可以用 java 安裝目錄裡的 bin 資料夾，裡面有個 native2ascii，
 * 執行之後打非英文字會幫我們轉換，最後將轉換好的編碼複製到 properties 裡即可
 */
public class I18nTest {
    public static void main(String[] args) {
        final String fileNamePrefix = "xxx";
        final String keyName = "msg";

        ResourceBundle simple = ResourceBundle.getBundle(fileNamePrefix, Locale.PRC);
        ResourceBundle traditional = ResourceBundle.getBundle(fileNamePrefix, Locale.TAIWAN);
        ResourceBundle english = ResourceBundle.getBundle(fileNamePrefix, Locale.US);

        System.out.println("简中：" + simple.getString(keyName));
        System.out.println("繁中：" + traditional.getString(keyName));
        System.out.println("English：" + english.getString(keyName));
        System.out.println();

        // 參數超過或不夠也不會報錯
        System.out.println(MessageFormat.format(simple.getString(keyName), "龙", "测试", 3));
        System.out.println(MessageFormat.format(traditional.getString(keyName), "龍", "測試"));
        System.out.println(MessageFormat.format(english.getString(keyName), "dragon"));
    }
}
