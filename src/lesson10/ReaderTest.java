package lesson10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
//        FileReader reader = new FileReader("src/ocpjp.txt");
        FileReader reader = new FileReader(new File("src/ocpjp.txt"));
//        read0Param(reader);
        read1Param(reader);
//        read3Param(reader);
//        withBufferedReader(reader);

        reader.close();
    }

    private static void read0Param(FileReader reader) throws IOException {
        // 方法一
//        int data;
//        while ((data = reader.read()) != -1) {
//            System.out.print((char) data);
//        }

        // 方法二
        while (reader.ready()) { // ready() 表示已準備好，可以開始讀取了
            int data = reader.read();
            if (data == -1) {
                break;
            }
            System.out.print((char) data);
        }
    }

    private static void read1Param(FileReader reader) throws IOException {
        char[] buffer = new char[10];
//        while (reader.read(buffer) != -1) { // 有可能會有多餘的
//            System.out.print(buffer);
//        }
        System.out.println("====================");
        // 方法一
        int len;
        while ((len = reader.read(buffer)) != -1) { // 使用 len 來接長度可解決多餘的問題
            for (var i = 0; i < len; i++) {
                System.out.print(buffer[i]);
            }
        }

        // 方法二
//        while (reader.ready()) {
//            int data = reader.read(buffer);
//            if (data == -1) {
//                break;
//            }
//            System.out.print(buffer);
//        }
    }

    private static void read3Param(FileReader reader) throws IOException {
        char[] buffer = new char[10];
        int len;
        /**
         *  read(buffer, 0, buffer.length)：將 0 ~ 陣列長度寫到 buffer 裡
         *  read(buffer, 0, 3)：將 [0 ~ 3) 寫到 buffer 裡，全部都會讀到，只不過只用 3 格陣列
         *  read(buffer, 3, 5)：將 [3 ~ 5) 寫到 buffer 裡，但 012 會讀到，讀到的是 char 的預設值 \u0000，
         *  之後讀到的 012 字元也會被 \u0000 覆蓋掉
         */
        while ((len = reader.read(buffer, 0, buffer.length)) != -1) {
            for (var i = 0; i < len; i++) {
                System.out.print(buffer[i]);
            }
        }
    }

    private static void withBufferedReader(FileReader reader) throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String data;

        while ((data = br.readLine()) != null) {
            System.out.println(data);
        }
        br.close();
    }
}
