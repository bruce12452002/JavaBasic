package lesson1;

/**
 * https://docs.oracle.com/javase/tutorial/java/data/characters.html
 */
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
        System.out.println('\101'); // 8 進位

        // \b backspace 刪除一個字
        // \r 回最左邊，但如果要繼續輸入文字，\r 左邊所有的字都會清空
        // \n 換行
        System.out.println("ab\bc"); // ac
        System.out.println("ab\r"); // ab
        System.out.println("ab\rc"); // c
        System.out.println("ab\nc"); // ab換行c
    }
}
