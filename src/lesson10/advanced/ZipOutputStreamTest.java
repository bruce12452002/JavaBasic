package lesson10.advanced;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipOutputStreamTest {
    public static void main(String[] args) throws IOException {
        try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream("testZip.zip"));) {
            zipOut.putNextEntry(new ZipEntry("123.txt")); // 壓縮檔裡的檔名
            zipOut.setComment("測試壓縮檔");
            zipOut.write("xxx".getBytes());
        }
    }
}
