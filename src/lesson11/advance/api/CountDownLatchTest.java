package lesson11.advance.api;

import java.util.concurrent.CountDownLatch;

/**
 * 執行緒的倒數計時器，全部的計時器都到了，再做想做的事
 * 如果想知道執行緒執行完需要多少時間可以使用這個工具
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch cdt = new CountDownLatch(3);
        Runnable run = () -> {
            for (int i = 0; i < 1000_0000; i++) {
            }
            System.out.println(Thread.currentThread().getName());
            cdt.countDown(); // 將倒數計時器減1
        };

        Thread t1 = new Thread(run, "t1");
        Thread t2 = new Thread(run, "t2");
        Thread t3 = new Thread(run, "t3");

        long start = System.currentTimeMillis();
        t1.start();
        t2.start();
        t3.start();

        try {
            System.out.println("wait...");
            cdt.await(); // 等待全部的執行緒(此例是3)都到時才能通過
            System.out.println(System.currentTimeMillis() - start);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
