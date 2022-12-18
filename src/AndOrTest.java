public class AndOrTest {
    /*
    OR
    || 只要第一個判斷為 true 就「會」執行之後的程式碼
    |  全部都會判斷

    AND
    && 只要第一個判斷為 false 就「不會」執行之後的程式碼
    &  全部都會判斷

    結論：只用 || 和 && 就好
     */
    public static void main(String[] args) {
        if (or1() || or2()) {
        }
        System.out.println("=====");
        if (or1() | or2()) {
        }
        System.out.println("=====");
        if (and1() && and2()) {
        }
        System.out.println("=====");
        if (and1() & and2()) {
        }
    }

    private static boolean or1() {
        System.out.println("or1");
        return true;
    }

    private static boolean or2() {
        System.out.println("or2");
        return false;
    }

    private static boolean and1() {
        System.out.println("and1");
        return false;
    }

    private static boolean and2() {
        System.out.println("and2");
        return true;
    }
}
