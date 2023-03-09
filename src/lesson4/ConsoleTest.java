package lesson4;

import java.io.Console;

/**
 * java.util.Formatter
 */
public class ConsoleTest {
    /**
     * because "console" is null --> 在 command line 操作才行
     */
    public static void main(String[] args) {
        Console console = System.console();
        String name = console.readLine("%s", "please typing your name:  ");
        char[] password = console.readPassword("%s", "please typing your password:  ");
        console.printf("your name is %s, pwd is %s", name, String.valueOf(password));
    }
}
