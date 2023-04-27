package lesson11.advance.api;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 執行緒相互交換資料
 * 可以用偶數個執行緒，但到底是哪兩個交換資料就不一定了
 */
public class ExchangerTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Exchanger<String> exchanger = new Exchanger<>();

        es.execute(() -> {
            try {
                String in = "xxx";
                System.out.println(Thread.currentThread().getName() + "將" + in + "送出去");
                Thread.sleep(1000);
                String out = exchanger.exchange(in);
                System.out.println(Thread.currentThread().getName() + "取得" + out);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        es.execute(() -> {
            try {
                String in = "ooo";
                System.out.println(Thread.currentThread().getName() + "將" + in + "送出去");
                Thread.sleep(1000);
                String out = exchanger.exchange(in);
                System.out.println(Thread.currentThread().getName() + "取得" + out);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        es.shutdown();
    }
}
