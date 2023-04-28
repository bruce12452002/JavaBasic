package lesson10.paths_and_files;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * FileVisitor
 * preVisitDirectory()：方法返回 CONTINUE，才會訪問
 * visitFile()：在目錄裡調用檔案
 * visitFileFailed()：無法讀取屬性、無法打開目錄等原因，會調用這個方法
 * postVisitDirectory()：
 * <p>
 * FileVisitResult
 * CONTINUE：從 preVisitDirectory() 返回時，繼續
 * TERMINATE：終止
 * SKIP_SUBTREE：忽略子目錄，但是子檔案會訪問，此結果僅在從 preVisitDirectory() 返回時才有意義，否則和 CONTINUE 一構
 * SKIP_SIBLINGS：忽略當前層的所有目錄和檔案，直接返回上一層繼續遊歷，不會調用 postVisitDirectory()
 */
public class WalkFileTreeTest {
    public static void main(String[] args) {
        walkFileTree();
    }


    private static void walkFileTree() {
        try {
            Files.walkFileTree(Paths.get("/Users/bruce"), new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
                    final String pathStr = path.toString();
                    if (pathStr.endsWith("log") || pathStr.endsWith("html")) {
                        System.out.println(path);
                    }
                    return FileVisitResult.SKIP_SUBTREE;
                }
            });

            // 四個參數的用法和兩個參數差不多，多個深度和要不要軟連結
//            Set<FileVisitOption> set = new HashSet<>();
//            set.add(FileVisitOption.FOLLOW_LINKS);
//            Files.walkFileTree(Paths.get(""), set, 3, new SimpleFileVisitor<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
