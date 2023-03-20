package lesson10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReaderTest {
    public static void main(String[] args) throws IOException {
//        FileReader reader = new FileReader("src/ocpjp.txt");
        FileReader reader = new FileReader(new File("src/ocpjp.txt"));
//        basicRead(reader);
        readChar(reader);
//        withBufferedReader(reader);

        reader.close();
    }

    private static void basicRead(FileReader reader) throws IOException {
        int data;
        while ((data = reader.read()) != -1) {
            System.out.print((char) data);
        }
    }

    private static void readChar(FileReader reader) throws IOException {
        char[] buffer = new char[10];
        while (reader.read(buffer) != -1) {
            System.out.print(buffer);
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
