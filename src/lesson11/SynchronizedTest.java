package lesson11;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 寫在「一般」方法和 synchronized(this) 一樣，只差在範圍而已，鎖當前「實體synchronized」範圍
 * synchronized 寫在「靜態」方法和 synchronized(Xxx.class) 一樣，只差在範圍而已，鎖整個類別裡的「類別 synchronized」範圍
 * <p>
 * 鎖範圍越小越快
 */
public class SynchronizedTest implements Runnable {
    private int ticket = 10;

    @Override
    public /*synchronized*/ void run() {
        for (var i = 10; i > 0; i--) {
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        TimeUnit.MILLISECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println(Thread.currentThread().getName() + "=>" + ticket--);
                }
            }
        }
    }

    public static void main(String[] args) {
        sameTicket();
    }

    private static void sameTicket() {
        SynchronizedTest r = new SynchronizedTest(); // 為 synchronized 的 this
        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        Thread t3 = new Thread(r);
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
