package lesson10.advanced;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class ZipInputStreamTest {
    public static void main(String[] args) throws IOException {

        File file = new File("testZip.zip");


        try (ZipInputStream zipIn = new ZipInputStream(new FileInputStream(file));
             ZipFile zipFile = new ZipFile(file)) {

            ZipEntry entry;
            while ((entry = zipIn.getNextEntry()) != null) {
                System.out.println("檔名是=" + entry.getName());

                InputStream is = zipFile.getInputStream(entry);
                int len;
                while ((len = is.read()) != -1) {
                    System.out.println((char) len);
                }
            }
        }
    }
}
