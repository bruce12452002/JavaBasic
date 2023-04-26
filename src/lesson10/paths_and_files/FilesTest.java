package lesson10.paths_and_files;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

public class FilesTest {
    public static void main(String[] args) {
//        commonMethod();
//        createDeleteMethod();
        listDir();
    }

    private static void commonMethod() {
        Path path = Paths.get("src/ocpjp.txt");
        System.out.println(Files.exists(path));
        System.out.println(Files.notExists(path));
        System.out.println(Files.exists(path, LinkOption.NOFOLLOW_LINKS));
        System.out.println(Files.isReadable(path));
        System.out.println(Files.isWritable(path));
        System.out.println(Files.isExecutable(path));
        System.out.println(Files.isDirectory(path));
        System.out.println(Files.isRegularFile(path));
        System.out.println(Files.isSymbolicLink(path));
        // 硬連結：不可跨槽，來源檔案被刪除還是可以讀到
        // 軟連結：可以跨槽，來源檔案被刪除就讀不到了 (Symbolic Link)，類似捷徑，但軟連結沒有容量；捷徑有 2 kb

        try {
            System.out.println(Files.isSameFile(Paths.get(""), path));
            System.out.println(Files.isHidden(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDeleteMethod() {
        Path dir = Paths.get("src/ooo/xxx/");
        Path file = Paths.get("123.txt");
        Path dirAndFile = dir.resolve(file);

        try {
            if (!Files.exists(dir)) {
                Files.createDirectories(dir); // Files.createDirectory
            }
            if (!Files.exists(file)) {
                Files.createFile(dirAndFile);
            }

            Files.delete(dirAndFile); // 最好使用 deleteIfExists
            Files.deleteIfExists(dir); // deleteIfExists 判斷存存才會刪除，這可以避免檔案不存在和刪除的目錄不是空的錯誤
            Files.deleteIfExists(Paths.get("src/ooo/"));
            System.out.println("finish");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void listDir() {
        Path path = Paths.get("/Users/bruce/JavaBasic");
        try (
                // 只有當前層
//                DirectoryStream<Path> dir = Files.newDirectoryStream(path, p -> true)
//                DirectoryStream<Path> dir = Files.newDirectoryStream(path, p -> !p.getFileName().toString().startsWith("."))
//                DirectoryStream<Path> dir = Files.newDirectoryStream(path, "*")
                DirectoryStream<Path> dir = Files.newDirectoryStream(path, "*.iml")
        ) {
            dir.forEach(d -> System.out.println(d.getFileName()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
