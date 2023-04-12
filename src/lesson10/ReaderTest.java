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
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
    }

    private static void read1Param(FileReader reader) throws IOException {
        char[] buffer = new char[10];
//        while (reader.read(buffer) != -1) { // 有可能會有多餘的
//            System.out.print(buffer);
//        }
        System.out.println("====================");
        int len;
        while ((len = reader.read(buffer)) != -1) { // 使用 len 來接長度可解決多餘的問題
            for (var i = 0; i < len; i++) {
                System.out.print(buffer[i]);
            }
        }
    }

    private static void read3Param(FileReader reader) throws IOException {
        char[] buffer = new char[10];
        int len;
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
