package lesson10.paths_and_files;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

/**
 * StandardOpenOption
 * READ：連接檔案時，使用讀的方式
 * WRITE：連接檔案時，使用寫的方式
 * APPEND：將資料附加到原本檔案的最後面
 * TRUNCATE_EXISTING：以 WRITE 連接時，之前的資料會被覆蓋；以 READ 連接會被忽略
 * CREATE：如果檔案不存在則創建一個新檔案。如果還設置了 CREATE_NEW 選項，會被忽略
 * CREATE_NEW：創建一個新檔案，如果檔案已經存在則失敗
 * DELETE_ON_CLOSE：會盡最大努力在方法關閉時刪除檔案
 * SPARSE：稀疏檔案。當與 CREATE_NEW 選項一起使用時，此選項會提示新檔案將是稀疏的。當檔案系統不支持創建稀疏文件時，該選項將被忽略。
 * SYNC：要求對檔案內容或 metadata 的每次更新都同步寫入底層存儲設備
 * DSYNC：要求對檔案內容的每次更新都同步寫入底層存儲設備
 * <p>
 * <p>
 * LinkOption
 * NOFOLLOW_LINKS：不偵測軟連結是否存在，如果來源檔是軟連結，複製時是複製軟連結這個檔案，如果是複複製軟連結指向的檔案，那就加這個選項
 * <p>
 * <p>
 * StandardCopyOption
 * REPLACE_EXISTING：如果存在就取代之前的檔案
 * COPY_ATTRIBUTES：複製屬性到新檔案
 * ATOMIC_MOVE：將檔案作為原子檔案系統操作移動
 */
public class OptionTest {
    public static void main(String[] args) {
        final Path path = Paths.get("src/ocpjp.txt");
//        writeMethod(path);
        readMethod(path);
//        copyMethod(path);
//        moveMethod(path);
//        urlCopyToLocal();
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
//            Files.readAllLines(path).forEach(System.out::println);
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

    private static void urlCopyToLocal() {
        Path local = Paths.get("src/xxx.png");
        try {
            URL url = URI.create("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSxUpjqIdRU3Du0VpgGCxk7Xcd9aIkPnQ-yHw&usqp=CAU").toURL();
            try (InputStream is = url.openStream()) {
                Files.copy(is, local, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("finish");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
