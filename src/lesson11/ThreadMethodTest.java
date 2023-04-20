package lesson11;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ThreadMethodTest {
    private static Runnable r = () -> {
        Stream.iterate(0, i -> ++i).limit(10).forEach(i ->
                System.out.print(Thread.currentThread().getName() + "=>" + i + " ")
        );
    };

    public static void main(String[] args) {
//        isAlive();
//        join();
//        yieldd();
//        interrupt();
        daemon();
    }

    private static void isAlive() {
        Thread t = new Thread(r, "t");
        System.out.println("before=>" + t.isAlive()); // false
        t.start();
        System.out.println("after=>" + t.isAlive()); // true
        try {
            Thread.sleep(30); // 毫秒
//            TimeUnit.SECONDS.sleep(3);
            System.out.println();
            System.out.println("final=>" + t.isAlive()); // 此行結果不確定，因為 main 執行緒和 t 執行緒不曉得誰會先執行完
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 執行緒.join：誰點就會讓這個執行緒先做完，再跑其他執行緒
     */
    private static void join() {
        Thread t = new Thread(r, "t");
        t.start();

        for (var i = 0; i < 50; i++) {
            if (i > 20) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.print(Thread.currentThread().getName() + "=>" + i + " ");
        }
    }

    /**
     * Thread.yield：讓其他執行緒先執行
     * 只是讓一次，並不是讓其他執行緒執行完
     * 讓的執行緒會馬上進入下一波的執行緒競爭
     */
    private static void yieldd() {
        Runnable r = () ->
                Stream.iterate(0, i -> ++i).limit(20).forEach(i -> {
                    if ("t2".equals(Thread.currentThread().getName()) && i % 3 == 0) {
                        System.out.println("讓一下");
                        Thread.yield();
                    }
                    System.out.print(Thread.currentThread().getName() + "=>" + i + " ");
                });

        Thread t1 = new Thread(r, "t1");
        Thread t2 = new Thread(r, "t2");
        t1.start();
        t2.start();
    }

    /**
     * 中斷
     */
    private static void interrupt() {
        Runnable r = () -> {
            System.out.println(1);
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println(2);
            } catch (InterruptedException e) {
                System.out.println(3);
                return;
            }
            System.out.println(4);
        };

        Thread t = new Thread(r, "t");
        t.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }
        t.interrupt();
    }

    /**
     * 後台執行緒：main 執行緒結束後，還想讓程序運行，可以設定 setDaemon(true)
     */
    private static void daemon() {
        Runnable r = () -> {
            while (true) System.out.println("yeah");
        };

        Thread thread = new Thread(r);
        thread.setDaemon(true);
        thread.start();
    }
}
