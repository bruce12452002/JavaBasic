package lesson10;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(new File("src/ocpjp.txt"));
//        read0Param(in);
//        read1Param(in);
        read3Param(in);
        in.close();
    }

    private static void read0Param(FileInputStream in) throws IOException {
        int data;
        while ((data = in.read()) != -1) {
            System.out.print((char) data);
        }
    }

    private static void read1Param(FileInputStream in) throws IOException {
        byte[] buffer = new byte[10];
//        while (in.read(buffer) != -1) { // 有可能會有多餘的
//            for (var i = 0; i < buffer.length; i++) {
//                System.out.print((char) buffer[i]);
//            }
//        }
        System.out.println("====================");
        int len;
        while ((len = in.read(buffer)) != -1) { // 使用 len 來接長度可解決多餘的問題
            for (var i = 0; i < len; i++) {
                System.out.print((char) buffer[i]);
            }
        }
    }

    private static void read3Param(FileInputStream in) throws IOException {
        byte[] buffer = new byte[10];
        int len;
        /**
         *  read(buffer, 0, buffer.length)：將 0 ~ 陣列長度寫到 buffer 裡
         *  read(buffer, 0, 3)：將 [0 ~ 3) 寫到 buffer 裡，全部都會讀到，只不過只用 3 格陣列
         *  read(buffer, 3, 5)：將 [3 ~ 5) 寫到 buffer 裡，但 012 會讀到，讀到的是 byte 的預設值 0，
         *  之後讀到的 012 字元也會被這個 0 覆蓋掉
         */
        while ((len = in.read(buffer, 0, buffer.length)) != -1) {
            for (var i = 0; i < len; i++) {
                System.out.print(buffer[i]);
            }
        }
    }
}
