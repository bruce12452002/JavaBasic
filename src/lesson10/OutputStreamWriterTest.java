package lesson10;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;

public class OutputStreamWriterTest {
    public static void main(String[] args) throws IOException {
        basicWrite();
//        writeBuffer();
    }

    private static void basicWrite() throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("testWriter.txt"));
        writer.write("test\nwriter\nyeah"); // int String char[] 都可以
        writer.write(65); // int String char[] 都可以，int 會自動轉 Unicode
        writer.write("test\nwriter\nyeah".toCharArray()); // int String char[] 都可以
        writer.flush();
        writer.close();
    }

    private static void writeBuffer() throws IOException {
        final String data = "https://education.oracle.com/java-se-8-programmer-ii/pexam_1Z0-809";
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream("testWriter.txt"));

        if (Objects.isNull(data) || data.length() == 0) return;

        final int getLetterCount = 10;
        int i = 0;
        do {
            int len = i + getLetterCount <= data.length() ? i - (i / getLetterCount - 1) * getLetterCount
                    : data.length() % getLetterCount;
//            System.out.println(len);
//            writer.write(data, i, len);
            writer.write(data.toCharArray(), i, len); // char 陣列和 String 做法一樣
            i += getLetterCount;
        } while (i < data.length());

        writer.flush();
        writer.close();
    }
}
