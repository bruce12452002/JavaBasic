package lesson12;

import java.nio.ByteBuffer;

/**
 * Channel 就好比是鐵軌上的通道，而且是雙通道，可以來回的
 * Buffer 就好比是載乘客的車箱，可以裝載資料的地方
 * 要把資料傳到另一個地方，必需兩個都有
 * <p>
 * ．capacity：是加入 Buffer 的大小，一經設定，無法改變
 * ．limit：第一個元素不該被讀寫的索引
 * ．position：下一個元素不該被讀寫索引
 * 以上三者不可為負
 * CLPM：從大到小
 * capacity >= limit >= position >= mark >= 0
 * ．mark：設定 mark 後，會記住 position，然後可用 reset() 回復
 * <p>
 * clear()：將 position 設置為0，limit 設置為和 capacity 一樣，並且將 mark 丟棄
 * flip()：將 limit 設置為當前位置和將 position 設置為0，如果 mark 未定義，則丟棄
 * rewind()：將 position 設置為0，並且將 mark 丟棄，因為 limit 沒動，所以通常是讀取重覆的資料
 * <p>
 * flip 和 rewind 有點像，position 都會歸 0，但 flip 在歸 0 前，會將值給 limit
 * <p>
 * 八種基本型態，除了 boolean，都有對應的 XXXBuffer
 */
public class BufferTest {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(8);
        displayBuffer(1, "初始值", buffer);

        String str = "abcde";
        buffer.put(str.getBytes());
        displayBuffer(2, "存入資料後", buffer);

        buffer.flip();
        displayBuffer(3, "翻到最前面後", buffer);

        byte[] b = new byte[buffer.limit()];
        buffer.get(b);
        // System.out.println(new String(b, 0, b.length)); // 偷看一下
        displayBuffer(4, "讀取資料後", buffer);

        buffer.rewind();
        displayBuffer(5, "倒帶後", buffer);

        buffer.clear();
        displayBuffer(6, "清除buffer後", buffer);
        // System.out.println((char)buffer.get()); // 其實 buffer 還有，只是不好控制了
    }

    private static void displayBuffer(int i, String s, ByteBuffer buffer) {
        System.out.println(System.getProperty("line.separator") + "-----" + i + s + "-----");
        System.out.println("capacity=" + buffer.capacity());
        System.out.println("limit=" + buffer.limit());
        System.out.println("position=" + buffer.position());
    }
}
