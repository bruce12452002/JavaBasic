package lesson10;

import java.io.*;

public class FlushTest {
    public static void main(String[] args) throws IOException {
        // InputStream 的 DEFAULT_BUFFER_SIZE 為 8192，也就是 8KB
        // buffer 滿了才會自動寫出去，所以如果剛好是 8KB 的倍數不會有問題；如果超過又不滿 8KB，不 flush() 也不 close() 就會寫不出去
        // 使用 try() 可以自動關閉
        BufferedInputStream in = new BufferedInputStream(new FileInputStream(new File("src/ocpjp.txt")));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("src/result.txt"));
        int len;
        while ((len = in.read()) != -1) {
            out.write(len);
//             out.flush(); // 手動刷新
        }
        in.close();
        // out.close(); // 不關閉就不會 flush()
        System.out.println("finish");
    }
}
