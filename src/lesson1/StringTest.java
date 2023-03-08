package lesson1;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringTest {
    public static void main(String[] args) {
        String str = new String("hi!");
        str = str.concat("abc");
        System.out.println(str);

        String str2 = "hi!" + "abc";
        System.out.println(str2);

//        common();
//        escape();
//        pair();
//        compare();
//        stringPool();
//        unicode();
//        jdk8();
//        jdk11();
    }

    /**
     * +
     * concat  v
     * valueOf
     * trim
     * replace  v
     * contains
     * length  v
     * isEmpty
     * charAt
     * split
     */
    private static void common() {
        System.out.println(1 + 2 + "3" + 4 + 5);
    }

    /**
     * n：new line
     * t：tab
     * b：backspace
     * r：return，回到第一行，如果後面有文字，之前的都會清空
     * \：反斜槓
     * '：使用在 char
     * "：使用在字串
     */
    private static void escape() {

    }

    /**
     * startsWith
     * endsWith
     * <p>
     * indexOf
     * lastIndexOf
     * <p>
     * subSequence
     * substring  v
     * <p>
     * toLowerase  v
     * toUpperCase  v
     */
    private static void pair() {

    }

    /**
     * equals
     * equalsIgnoreCase
     * <p>
     * compareTo
     * compareToIgnoreCase
     * <p>
     * ==
     */
    private static void compare() {

    }

    private static void stringPool() {
        String s1 = "a";
        String s2 = "a";
        String s3 = new String("a");
        System.out.println(s1 == s2); // true
        System.out.println(s1 == s3); // false
    }

    /**
     * codePointAt
     * codePointBefore
     * codePointCount
     */
    private static void unicode() {
        System.out.println("ab".codePointAt(1)); // 98
        System.out.println("bell".codePointBefore(1)); // 98

        String str = "\uD840\uDC3E";
        System.out.println(str.length()); // 2
        System.out.println(str.codePointCount(0, str.length())); // 1
        System.out.println(str);
    }

    /**
     * join
     */
    private static void jdk8() {
        System.out.println(String.join(",,", "aa", "bb", "cc"));
        System.out.println(String.join("--", Arrays.asList("11", "22", "33")));
    }

    /**
     * strip  11
     * isBlank 11
     * repeat 11
     */
    private static void jdk11() {
    }

    private static void get131100After() {
        StringBuilder sb = new StringBuilder();
        Stream.iterate(0, x -> x).limit(1000).reduce((i, j) -> {
            sb.appendCodePoint(131100 + i);
            return ++i;
        });
        System.out.print(sb);
    }
}
