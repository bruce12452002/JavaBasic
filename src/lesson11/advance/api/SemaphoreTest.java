package lesson11.advance.api;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 限制最多可以有幾個執行緒執行，以公共廁所為例
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        final int toilet = 3; // 設定3個廁所
        final int user = 30; // 使用人數
        final ExecutorService es = Executors.newFixedThreadPool(user);
        final Semaphore sp = new Semaphore(toilet, true); // 誰先等誰就先用(公平鎖)

        for (int i = 0; i < user; i++) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Runnable runnable = () -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " 要求使用廁所");
                    sp.acquire(); // 要求上廁所，如果還不滿3人才能使用
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 拉屎中，目前有"
                        + (toilet - sp.availablePermits()) + "個在使用");

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + " 在沖馬桶了");
                sp.release(); // 歸還廁所

                System.out.println(Thread.currentThread().getName() + " 離開，目前有"
                        + (toilet - sp.availablePermits()) + "個在使用\r\n");
            };
            es.execute(runnable);
        }
        es.shutdown();
        // es.close(); // java 19，ExecutorService 繼承了 AutoCloseable
    }
}
