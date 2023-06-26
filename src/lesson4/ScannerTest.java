package lesson4;

import java.util.Scanner;

public class ScannerTest {
    /**
     * nextXxx() 會等待輸入
     */
    public static void main(String[] args) {
        System.out.println("請輸入：");
        Scanner scanner = new Scanner(System.in);
//         scanner.useDelimiter("\n"); // 輸入多個時，用什麼分開，預設是空格； 如果給 \n 那只能輸入一個值
        while (scanner.hasNext()) { // scanner.hasNextInt()
            String next = scanner.next();
            if ("exit".equals(next)) {
                break;
            }
            System.out.println(next);
        }
        scanner.close();

//        nextXxx();
    }

    /**
     * next() nextLine() 區別在空格
     * next() 取空格之前，但不包括空格(不管空幾格都一樣)，再 next() 會再取下一個，還是不包括空格
     * nextLine() 取整行包括之前的空格
     * <p>
     * nextInt、nextDouble…等，是 next()後再轉換成對應的型態，當然字串還是不能變成數字
     */
    private static void nextXxx() {
        System.out.println("請輸入："); // 輸入「a  bb  ccc」
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.next()); // a
        System.out.println(scanner.nextLine()); // 「  bb  ccc」，有包括前面兩個空格
//        System.out.println(scanner.next());
//        System.out.println(scanner.next());
        scanner.close();
    }
}
