package lesson6;

/**
 * StringBuffer StringBuilder
 */
public class StringBuilderTest {
    public static void main(String[] args) {
//        StringBuilder sb = new StringBuilder();
//        sb.append("aaa").append("bbb").append("ccc");
//        System.out.println(sb.toString());
        common();
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
