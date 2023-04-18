package lesson10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class OutputStreamTest {
    public static void main(String[] args) throws IOException {
//        basicWrite();
        writeBuffer();
    }

    private static void basicWrite() throws IOException {
        OutputStream writer = new FileOutputStream("testWriter.txt");
        writer.write(65);
        writer.flush();
        writer.close();
    }

    private static void writeBuffer() throws IOException {
        final String data = "https://education.oracle.com/java-se-8-programmer-ii/pexam_1Z0-809";
        OutputStream writer = new FileOutputStream("testWriter.txt");

        if (Objects.isNull(data) || data.length() == 0) return;

        final int getLetterCount = 10;
        int i = 0;
        do {
            int len = i + getLetterCount <= data.length() ? i - (i / getLetterCount - 1) * getLetterCount
                    : data.length() % getLetterCount;
//            System.out.println(len);
//            writer.write(data.getBytes());
            writer.write(data.getBytes(), i, len);
            i += getLetterCount;
        } while (i < data.length());

        writer.flush();
        writer.close();
    }
}
