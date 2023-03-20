package lesson10;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterTest {
    public static void main(String[] args) throws IOException {
//        tryWithResource();

//        FileWriter writer = new FileWriter("testWriter.txt");
        FileWriter writer = new FileWriter(new File("testWriter.txt"));
        writer.write("test\nwriter\nyeah");
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
}
