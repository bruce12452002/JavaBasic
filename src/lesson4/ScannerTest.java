package lesson4;

import java.util.Scanner;

public class ScannerTest {
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
    }
}
