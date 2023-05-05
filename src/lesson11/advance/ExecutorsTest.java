package lesson11.advance;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executors.newXxx 有四種，底層都是 ThreadPoolExecutor，建構子有 7 個參數
 * new ThreadPoolExecutor(5,
 * 20,
 * 10,
 * TimeUnit.MILLISECONDS,
 * new LinkedBlockingQueue<>(),
 * Executors.defaultThreadFactory(),
 * new ThreadPoolExecutor.AbortPolicy());
 * <p>
 * 表示一開始就有 5 個執行緒可以用，最多20個
 * 假設有30個 request 進來，5個先執行，然後25個會放在第5個參數的 queue 裡
 * 再來15個執行緒(20-5)去 queue 抓來執行，最後10個看第7個參數的放棄策略
 * 執行完的15個執行緒，過10毫秒 (第3和4的參數) 就關閉，如果是0，表示永遠不過期
 * 第六個參數是將 Runnable 包裝成 Thread
 * <p>
 * 以下是第 5~7 可用的參數
 * BlockingQueue
 * ArrayBlockingQueue
 * DelayedWorkQueue 基於 heap 的資料結構，按照時間順序將每個任務進行排序
 * BlockingDeque
 * LinkedBlockingDeque 預設是 Integer.MAX_VALUE，所以有 OOM 的風險
 * SynchronousQueue 一生產就消費，如沒有消費者就阻塞，所以沒有容量大小
 * DelayQueue 只能消費已過期的
 * TransferQueue
 * LinkedTransferQueue 很像 SynchronousQueue，但有容量，消費者沒取到就會阻塞
 * LinkedBlockingQueue 預設是 Integer.MAX_VALUE，所以有 OOM 的風險
 * PriorityBlockingQueue 按照自定義的優先級消費
 * <p>
 * ThreadFactory
 * DaemonThreadFactory 創建背景執行的執行緒，之後出來的執行緒都是背景執行緒
 * DefaultThreadFactory 預設的執行緒工廠
 * PrivilegedThreadFactory 創建與當前執行緒具有相同權限的新執行緒
 * <p>
 * RejectedExecutionHandler
 * DiscardOldestPolicy 丟棄最老的任務，就是在 queue 裡面的
 * AbortPolicy 新來的任務直接丟棄並報異常
 * CallerRunsPolicy 同步調用，start() 調用後執行 run()，但這個策略是直接調用 run()
 * DiscardPolicy 新來的任務直接丟棄但不報異常
 * <p>
 * <p>
 * newXxx() 7 個參數如下：
 * Executors.newSingleThreadExecutor()      1   1               0    毫秒   LinkedBlockingQueue
 * Executors.newFixedThreadPool(n)          n   n               0    毫秒   LinkedBlockingQueue
 * Executors.newCachedThreadPool()          0   Integer最大值    60   秒     SynchronousQueue
 * Executors.newScheduledThreadPool(n)      n   Integer最大值    10   毫秒   DelayedWorkQueue
 * 以上第 6 和 7 參數都是
 * Executors.defaultThreadFactory()     AbortPolicy
 * <p>
 * 尤於第一二種的 LinkedBlockingQueue，用的都是無參建構子，queue 是 Integer 的最大值，正常來說不會用那麼多來放執行緒
 * 第三四種的第二個參數也是 Integer 的最大值，正常也不會開那麼多的執行緒池
 * 以上在記憶體不夠時，容易造成 OOM，所以最好是使用底層的 ThreadPoolExecutor
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
//         ExecutorService es = Executors.newFixedThreadPool(3);
//         ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 1; i <= 7; i++) {
            es.execute(() -> {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for (int j = 1; j <= 5; j++) {
                    System.out.println(Thread.currentThread().getName() + "->" + j);
                }
            });
        }
        es.shutdown();
        // es.close(); // java 19，ExecutorService 繼承了 AutoCloseable

        schedule();
    }

    private static void schedule() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        ses.schedule(() -> {
            System.out.println("yeah");
        }, 2L, TimeUnit.SECONDS);
        ses.shutdown();

        ScheduledExecutorService sess = Executors.newScheduledThreadPool(3);
        sess.scheduleAtFixedRate(() -> {
            System.out.println("xxx");
        }, 2L, 1L, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000L);
            sess.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ScheduledExecutorService seas = Executors.newSingleThreadScheduledExecutor();
        seas.scheduleAtFixedRate(() -> {
            System.out.println("xxx");
        }, 2L, 1L, TimeUnit.SECONDS);
        try {
            Thread.sleep(5000L);
            seas.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // java 19，ExecutorService 繼承了 AutoCloseable
//        ses.close();
//        sess.close();
//        seas.close();
    }
}
