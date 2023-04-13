package lesson10;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

public class WriterTest {
    public static void main(String[] args) throws IOException {
//        basicWrite();
//        writeBuffer();
        withBufferedWriter(new FileWriter("testWriter.txt"));
//        tryWithResource();
    }

    private static void basicWrite() throws IOException {
//        FileWriter writer = new FileWriter("testWriter.txt");
        FileWriter writer = new FileWriter(new File("testWriter.txt"));
        writer.write("test\nwriter\nyeah"); // int String char[] 都可以
        writer.write(65); // int String char[] 都可以，int 會自動轉 Unicode
        writer.write("test\nwriter\nyeah".toCharArray()); // int String char[] 都可以
        writer.flush();
        writer.close();
    }

    private static void writeBuffer() throws IOException {
        final String data = "https://education.oracle.com/java-se-8-programmer-ii/pexam_1Z0-809";
        FileWriter writer = new FileWriter(new File("testWriter.txt"));

        if (Objects.isNull(data) || data.length() == 0) return;

//        final String az = "abcdefghijklmnopqrstuvwxyz";
//        writer.write(az, 0, 5); // a~e，從 index 0，取 5 個
//        writer.write(az, 5, 3); // fgh，從 index 5，取 3 個

        final int getLetterCount = 10;
        int i = 0;
        do {
            int len = i + getLetterCount <= data.length() ? i - (i / getLetterCount - 1) * getLetterCount
                    : data.length() % getLetterCount;
//            System.out.println(len);
            writer.write(data, i, len);
//            writer.write(data.toCharArray(), i, len); // char 陣列和 String 做法一樣
            i += getLetterCount;
        } while (i < data.length());

        writer.flush();
        writer.close();
    }

    /**
     * 繼承 AutoCloseable，不用顯示關閉
     */
    private static void tryWithResource() {
        try (FileWriter writer = new FileWriter(new File("testWriter.txt"))) {
            writer.write("test\nwriter\nyeah");
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void withBufferedWriter(FileWriter writer) throws IOException {
        BufferedWriter br = new BufferedWriter(writer);
        br.write("test");
        br.newLine();
        br.write("yeah");
        br.close();
    }
}
