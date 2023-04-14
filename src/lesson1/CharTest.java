package lesson1;

public class CharTest {
    /**
     * 多行註解
     */
    // 單行註解
    // C:\Users/user 反斜會報錯
    public static void main(String[] args) {
        char c0 = 'A';
        char c1 = '\\';
        char c2 = '我'; // Unicode UTF-8 UTF-16 UTF-32
        char c3 = '\u0041'; // A
        System.out.println(c0);
        System.out.println((int) c0);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println((char) 65);
    }
}
