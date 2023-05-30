package lesson11;

import java.util.stream.Stream;

/**
 * start() 會啟動 run()，這樣才能真正啟動執行緒的功能，CPU 才會切換
 * 要兩個執行緒以上才能看出效果，結果應該要是執行緒之間相互交錯才是正確的
 * 也有可能看起來的結果和沒執行緒一樣，要多執行幾次才能確定
 * 注意每次結果都是不一定的
 * <p>
 * 一個實體只能執行一次 start()
 * <p>
 * 如果直接調用 run() 方法也能執行，但不會有交錯的情形，還是順序執行，沒有充份利用 CPU
 */
public class MyThread extends Thread {
    /**
     * main 方法也是一個執行緒；而垃圾回收也是一個執行緒，所以一啟動 main 方法至少有兩個執行緒
     */
    public static void main(String[] args) {
        MyThread m1 = new MyThread();
        m1.setName("m1"); // 沒給名稱，預設是 Thread-x，x 從 0 開始；每 new 一個執行緒就會一直加 1

        MyThread m2 = new MyThread();
        m2.setName("m2");

        m1.start(); // 如果真的有 start 方法，就不會調用 run 方法了，且只有 main 執行緒會調用 start 方法
        m2.start();
    }

    @Override
    public void run() {
        Stream.iterate(0, i -> ++i).limit(10).forEach(i ->
                System.out.println(Thread.currentThread().getName() + "=>" + i)
        );
    }
}
