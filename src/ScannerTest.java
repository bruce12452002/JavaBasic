import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // scanner.useDelimiter("\n"); // 預設是空格
        while (scanner.hasNext()) { // scanner.hasNextInt()
            System.out.println(scanner.next());
        }
    }
}
