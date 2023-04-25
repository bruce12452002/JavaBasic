package lesson10.paths_and_files;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class OptionTest {
    public static void main(String[] args) {
        final Path path = Paths.get("src/ocpjp.txt");
//        writeMethod(path);
//        readMethod(path);
//        copyMethod(path);
        moveMethod(path);
    }

    private static void writeMethod(Path path) {
        try {
            // OpenOption 不傳，預設有三個，StandardOpenOption.CREATE、TRUNCATE_EXISTING、WRITE，
            // 也就是會把剩的內容都刪除，只有新的內容
            Files.write(path, "hahaha".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
            Files.writeString(path, "hehehe", StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readMethod(Path path) {
        try {
            System.out.println(new String(Files.readAllBytes(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyMethod(Path path) {
        try {
            Files.copy(path, Paths.get("src", "ocpjp2.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void moveMethod(Path path) {
        try {
            Files.move(path, Paths.get("src/ocpjp2.txt"), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
