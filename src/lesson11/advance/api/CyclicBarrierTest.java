package lesson11.advance.api;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * 類似 CountDownLatch，但可以執行多次
 * <p>
 * 一個班級到達玩的地點，全部都上車才能去下一個地點
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("barrier被觸發時呼叫，也就是所有執行緒都到時呼叫"));
        System.out.println("總共有" + cb.getParties() + "個執行緒\r\n");
        Runnable run = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                cb.await();
                System.out.println("執行緒" + Thread.currentThread().getName() + "已到達一號站");

                TimeUnit.SECONDS.sleep(1);
                cb.await();
                System.out.println("執行緒" + Thread.currentThread().getName() + "已到達二號站");

                TimeUnit.SECONDS.sleep(1);
                cb.await();
                System.out.println("執行緒" + Thread.currentThread().getName() + "已到達三號站");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(run, "t1");
        Thread t2 = new Thread(run, "t2");
        Thread t3 = new Thread(run, "t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
