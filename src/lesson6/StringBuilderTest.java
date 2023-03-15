package lesson6;

/**
 * StringBuffer StringBuilder
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        // 只有 append 時，和 String 結果是一樣的，因為 JVM 優化成 StringBuilder；但在迴圈裡就不會優化了
        StringBuilder sb = new StringBuilder(); // View -> Show Bytecode，注意，必須先有 class
        sb.append("aaa").append("bbb").append("ccc");
        System.out.println(sb.toString());

//        common();
    }

    /**
     * charAt(index)
     * delete(index, index) 類似 substring
     * substring
     * insert(index, content)
     * indexOf
     * length
     * replace
     * reverse
     */
    private static void common(){
        StringBuilder sb = new StringBuilder("abc");
        System.out.println(sb);
    }
}
