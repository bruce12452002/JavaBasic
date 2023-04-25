package lesson10.paths_and_files;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathsTest {
    public static void main(String[] args) {
        // 取得 Path，方法一
        FileSystem fs = FileSystems.getDefault();
        Path path = fs.getPath("");

        // 取得 Path，方法二
        // Paths.get 路徑可不存在
//        Path path = Paths.get(".").toAbsolutePath();
//        System.out.println(path); // 當前路徑
//        File file = path.toFile(); // 轉成 File
//
        commonMethod();
//        normalizeMethod();
//        subPathMethod();
//        resolveMethod();
//        relativizeMethod();
    }

    private static void commonMethod() {
        Path path = Paths.get("aaa/bbb.txt");
        System.out.println(path.getFileName());
        System.out.println(path.getParent());
        System.out.println(path.getRoot());
        System.out.println(path.toUri());
        System.out.println(path.isAbsolute());
        System.out.println(path.toAbsolutePath());
        System.out.println(path.getNameCount());
        System.out.println(path.getName(0)); // 超過會 IllegalArgumentException
        System.out.println(path.startsWith("aaa")); // true
        System.out.println(path.endsWith(Paths.get("bbb.txt"))); // true
        System.out.println(path.endsWith(Paths.get(".txt"))); // 以 / 到 / 為基準，不可用裡面的字串
        System.out.println(path.equals(Paths.get("aaa/bbb.txt"))); // true
    }

    private static void normalizeMethod() {
        Path path1 = Paths.get("aaa/./qoo.txt");
        System.out.println(path1.normalize()); // aaa/qoo.txt
        Path path2 = Paths.get("aaa/bbb/../qoo.txt");
        System.out.println(path2.normalize()); // aaa/qoo.txt
        System.out.println(path2.normalize().toAbsolutePath());
    }

    private static void subPathMethod() {
        Path path1 = Paths.get("aaa/bbb.txt");
        System.out.println(path1.subpath(0, 1)); // aaa

        Path path2 = Paths.get("/aaa/bbb/ccc/ddd/eee.txt");
        System.out.println(path2.subpath(1, 4)); // bbb/ccc/ddd
    }

    private static void resolveMethod() {
        System.out.println(Paths.get("aaa/bbb").resolve("ccc/ddd")); // aaa/bbb/ccc/ddd
        System.out.println(Paths.get("/aaa/bbb/ccc/ddd/eee.txt").resolve("/xxx/yyy")); // /xxx/yyy
        // resolve 裡面如果是絕對路徑，那就會把前面的覆蓋掉
    }

    private static void relativizeMethod() {
        Path p1 = Paths.get("aaa/bbb");
        Path p2 = Paths.get("ccc/ddd/eee");
        System.out.println(p1.relativize(p2)); // ../../ccc/ddd/eee
        System.out.println(p2.relativize(p1)); // ../../../aaa/bbb
    }
}
