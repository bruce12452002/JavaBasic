package lesson10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("testWriter.txt"));
        writer.write("test"); // int String char[] 都可以
        writer.flush();
        writer.close();
    }
}
