package lesson10.advanced;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

/**
 * SequenceInputStream： 將兩個 InputStream 合併
 */
public class SequenceInputStreamTest {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream in1 = new FileInputStream("src/abc.txt");
                FileInputStream in2 = new FileInputStream("src/ocpjp.txt");
                SequenceInputStream in = new SequenceInputStream(in1, in2);
        ) {
            int len;
            while ((len = in.read()) != -1) {
                System.out.print((char) len);
            }
        }
    }
}
