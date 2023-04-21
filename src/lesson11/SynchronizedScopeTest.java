package lesson11;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class SynchronizedScopeTest {
    public static void main(String[] args) {
        // 調用不同方法
        nonStaticAndNonStatic();
//        staticAndStatic();
//        nonStaticAndStatic();

        // 調用相同方法
//        nonStaticSameMethod();
//        staticSameMethod();
    }

    /**
     * 不互斥
     */
    private static void nonStaticAndNonStatic() {
        // 鎖的 this 相同
        Sync ss = new Sync();
        Thread b = new Thread(ss::syncWithMethod, "b");
        Thread a = new Thread(ss::syncAddMethod, "a");

        // 鎖的 this 不同為不互斥
//        Thread b = new Thread(() -> new Sync().syncWithMethod(), "b");
//        Thread a = new Thread(() -> new Sync().syncAddMethod(), "a");

        a.start();
        b.start();
    }

    /**
     * 互斥
     */
    private static void staticAndStatic() {
        Thread c = new Thread(Sync::syncAddStaticMethod, "c");
        Thread d = new Thread(() -> new Sync().syncWithStaticMethod(), "d");
        c.start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            d.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 不互斥：鎖的東西不同，所以是不互斥
     */
    private static void nonStaticAndStatic() {
        Sync ss = new Sync();
        Thread b = new Thread(ss::syncWithMethod, "b");
        Thread d = new Thread(ss::syncWithStaticMethod, "d");
        d.start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
            b.start();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 互斥
     */
    private static void nonStaticSameMethod() {
        // 鎖的 this 相同
        Sync ss = new Sync();
        Thread a = new Thread(ss::syncWithMethod, "a");
        Thread b = new Thread(ss::syncWithMethod, "b");

        // 鎖的 this 不同為不互斥
//        Thread a = new Thread(() -> new Sync().syncWithMethod(), "a");
//        Thread b = new Thread(() -> new Sync().syncWithMethod(), "b");

        a.start();
        b.start();
    }

    /**
     * 互斥
     */
    private static void staticSameMethod() {
        Thread c = new Thread(Sync::syncAddStaticMethod, "c");
        Thread d = new Thread(Sync::syncAddStaticMethod, "d");
        c.start();
        d.start();
    }
}

class Sync {
    synchronized void syncAddMethod() {
        System.out.println("syncAddMethod=>" + Thread.currentThread().getName() + " " + new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void syncWithMethod() {
        System.out.println("syncWithMethod 即將進入 synchronized" + " " + new Date());

        synchronized (this) {
            System.out.println("syncWithMethod=>" + Thread.currentThread().getName() + " " + new Date());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static synchronized void syncAddStaticMethod() {
        System.out.println("syncAddStaticMethod=>" + Thread.currentThread().getName() + " " + new Date());
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void syncWithStaticMethod() {
        System.out.println("syncWithStaticMethod 即將進入 synchronized" + " " + new Date());

        synchronized (Sync.class) {
            System.out.println("syncWithStaticMethod=>" + Thread.currentThread().getName() + " " + new Date());
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
