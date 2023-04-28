package lesson10.paths_and_files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * FileVisitOption 只有一個 enum FOLLOW_LINKS，使用軟連結的意思
 * 軟連結如果是目錄，使用這個 enum 會往下遍歷
 */
public class WalkTest {
    public static void main(String[] args) {
        walkDeep();
    }

    /**
     * 第二個參數是第幾層的意思，如果不給這個參數，會遞迴到最後
     */
    private static void walkDeep() {
        try (Stream<Path> walk = Files.walk(Paths.get("/Users/bruce"), 1)) {
            walk.filter(Files::isDirectory).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
