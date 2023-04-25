package lesson10;

import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
//        System.out.println(System.getProperty("user.dir"));
//        System.out.println(new File(".").getAbsolutePath());

        // new File 路徑可不存在
        File file = new File("src/ocpjp.txt");
        File dir = new File("src");
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.isHidden());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.length());
        file.toPath(); // 轉成 Path



//        System.out.println(file.mkdir());
//        System.out.println(file.mkdirs());
//        System.out.println(file.createNewFile());
//        System.out.println(file.delete());
//        System.out.println(file.list());
    }
}
