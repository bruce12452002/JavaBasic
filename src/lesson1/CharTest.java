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

        // \b backspace 刪除一個字
        // \r 回最左邊並清空，也就是 \r 左邊所有的字都會清空
        // \n 換行
        System.out.println("ab\bc"); // ac
        System.out.println("ab\rc"); // c
        System.out.println("ab\nc"); // ab換行c
    }
}
