package lesson10.advance;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayXxxputStreamTest {
    public static void main(String[] args) throws IOException {
        try (ByteArrayInputStream in = new ByteArrayInputStream("abcdef".getBytes());
             ByteArrayOutputStream out = new ByteArrayOutputStream() // 寫到陣列，預設 32 bytes
        ) {
            int len;
            while ((len = in.read()) != -1) {
                out.write(Character.toUpperCase((char) len));
            }
            System.out.println(out);
        }
    }
}
