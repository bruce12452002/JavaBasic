package lesson2;

public class SwitchTest {
    /**
     * switch case break default，除了 switch 以外，其他都可以不寫
     * 只支援 整數、char、字串(jdk7)
     * case 用「|」可判斷多個值，但不支援 > <
     */
    public static void main(String[] args) {
        String str = "A";
        switch (str) {
            case "A":
                System.out.println("A");
                break;
            case "B":
                System.out.println("B");
                break;
            case "C":
                System.out.println("C");
                break;
            default:
                System.out.println("default");
        }

        jdk14('a');
        jdk17("123");
        jdk17(123);
    }

    private static void jdk14(char c) {
        // JDK14 可以不寫 break，寫了是多餘的
        // case default 也可以不寫
        switch (c) {
//            case 'a' -> {
//                System.out.println("a");
//                System.out.println("yeah");
//                break;
//            }
//            case 'b' -> System.out.println("b");
//            case 'c' -> System.out.println("c");
//            default -> System.out.println("default");
        }
    }

    private static <T> void jdk17(T t) {
        // 判斷型態可以沒有 case，但一定要有 default
//        switch (t) {
//            case String s -> System.out.println("s=" + s);
//            case Double d -> System.out.println("d=" + d);
//            case Integer i -> System.out.println("i=" + i);
//            default -> System.out.println("default");
//        }
    }
}
