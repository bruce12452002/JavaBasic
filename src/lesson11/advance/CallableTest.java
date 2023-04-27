package lesson11.advance;

import java.util.concurrent.*;

/**
 * Callable 和 Runnable 類似，但有回傳值
 * <p>
 * Future 可以用 get() 取得 Callable 的回傳值
 */
public class CallableTest {
    public static void main(String[] args) {
        try (ExecutorService es = Executors.newSingleThreadExecutor()) {
            Callable<String> callable = () -> "yeah!";
            Future<String> future = es.submit(callable);

            System.out.println("等一兮呢");
            System.out.println(future.get());

            // 如果超過 get 設定的時間，就會出現 java.util.concurrent.TimeoutException
//            System.out.println(future.get(500L, TimeUnit.MILLISECONDS));
            es.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}