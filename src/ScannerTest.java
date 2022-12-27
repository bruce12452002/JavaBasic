import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // scanner.useDelimiter("\n"); // 預設是空格
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
