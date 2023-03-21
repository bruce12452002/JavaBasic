package lesson1;

import java.util.Arrays;

public class MainTest {
    public static void main(String[] args) { // Program arguments，多個參數用空格隔開
        System.out.println(args.length);
        if (args.length != 0) {
            System.out.println(args[0]);
        }
        System.out.println("============================");
        Arrays.stream(args).forEach(System.out::println);
    }
}
