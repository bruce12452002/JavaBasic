package lesson11;

import java.util.stream.Stream;

/**
 * Thread 類別也是實作 Runnable，所以也可以執行實作 Runnable 來達到多執行緒
 * 實作 Runnable 比 繼承 Thread 好一點，因為 extends 後面只能是一個類別；而 implements 可以多個
 * 如果某個類別已經繼承別的類別了，那就無法再繼承了，只能使用實作 Runnable 的方式
 */
public class MyRunnable implements Runnable {
    public static void main(String[] args) {
        MyRunnable a = new MyRunnable();
        Thread m1 = new Thread(a);
        m1.setName("m1");

        MyRunnable b = new MyRunnable();
        Thread m2 = new Thread(b);
        m2.setName("m2");

        m1.start();
        m1.start();
        m2.start();
    }

    @Override
    public void run() {
        Stream.iterate(0, i -> ++i).limit(10).forEach(i ->
                System.out.println(Thread.currentThread().getName() + "=>" + i)
        );
    }
}
