package lesson11;

import java.util.concurrent.TimeUnit;

public class DeadLockTest implements Runnable {
    public static void main(String[] args) {
        DeadLockTest d1 = new DeadLockTest();
        DeadLockTest d2 = new DeadLockTest();
        d1.flag = true;
        d2.flag = false;

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();
    }

    private static final A A = new A();
    private static final B B = new B();
    private boolean flag;

    @Override
    public void run() {
        if (flag) {
            synchronized (A) {
                A.show();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (B) {
                    A.get();
                }
            }
        } else {
            synchronized (B) {
                B.show();

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (A) {
                    B.get();
                }
            }
        }
    }

    private static class A {
        void show() {
            System.out.println("給我錢，我給你西瓜");
        }

        void get() {
            System.out.println("A 拿到錢了");
        }
    }

    private static class B {
        void show() {
            System.out.println("給我西瓜，我給你錢");
        }

        void get() {
            System.out.println("B 拿到西瓜了");
        }
    }

}
