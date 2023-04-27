package lesson12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ChannelTest {
    public static void main(String[] args) {
        nonDirect();
//        direct1();
//        direct2();
    }

    private static void nonDirect() {
        try (
                FileInputStream fis = new FileInputStream("bufferPicture.jpeg");
                FileOutputStream fos = new FileOutputStream("2.jpg");
                FileChannel in = fis.getChannel();
                FileChannel out = fos.getChannel();
        ) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            while (in.read(buffer) != -1) {
                buffer.flip();
                out.write(buffer);
                buffer.clear();
            }
            System.out.println("copy complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void direct1() {
        OpenOption[] oo = {StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE};
        try (
                FileChannel in = FileChannel.open(Paths.get("bufferPicture.jpeg"), StandardOpenOption.READ);
                FileChannel out = FileChannel.open(Paths.get("2.jpg"), oo);
        ) {
            MappedByteBuffer inMap = in.map(FileChannel.MapMode.READ_ONLY, 0, in.size());
            MappedByteBuffer outMap = out.map(FileChannel.MapMode.READ_WRITE, 0, in.size());

            byte[] dst = new byte[inMap.limit()];
            inMap.get(dst);
            outMap.put(dst);
            System.out.println("copy complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void direct2() {
        OpenOption[] oo = {StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE};
        try (
                FileChannel in = FileChannel.open(Paths.get("bufferPicture.jpeg"), StandardOpenOption.READ);
                FileChannel out = FileChannel.open(Paths.get("2.jpg"), oo);
        ) {
            in.transferTo(0, in.size(), out); // in 到 out
            // out.transferFrom(in, 0, in.size()); // out 從 in 過來的
            System.out.println("copy complete");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
