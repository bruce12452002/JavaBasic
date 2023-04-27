package lesson11.advance.api;

import java.util.concurrent.Phaser;

/**
 * 有 CountDownLatch 和 CyclicBarrier 的功能，但還可以動態增加 parties
 */
public class PhaserTest extends Phaser {
    public static void main(String[] args) {
        PhaserTest phaser = new PhaserTest();
        phaser.register(); // 每註冊一次，phaser 就會多維護一個執行緒
        for (int i = 0; i < 4; i++) {
            phaser.register();// 每註冊一次，phaser 就會多維護一個執行緒
            new Thread(new Runner(phaser)).start();
        }
        phaser.arriveAndDeregister();
    }

    // 每個階段執行完會自動調用
    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        if (phase == 0) return init();
        else if (phase == 1) return one();
        else if (phase == 2) return two();
        else if (phase == 3) return three();
        return true; // phase 應該結束就給 true
    }

    private boolean one() {
        System.out.println("共幾人=" + getRegisteredParties());
        return false;
    }

    private boolean two() {
        System.out.println("共幾人=" + getRegisteredParties());
        return false;
    }

    private boolean three() {
        System.out.println("共幾人=" + getRegisteredParties());
        return false;
    }

    private boolean init() {
        System.out.println("共幾人=" + getRegisteredParties());
        return false;
    }

    static class Runner implements Runnable {
        private final Phaser phaser;

        public Runner(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            System.out.println("班級" + Thread.currentThread().getName() + ":已到出發站");
            phaser.arriveAndAwaitAdvance(); // 全到才會繼續往下走

            System.out.println("執行緒" + Thread.currentThread().getName() + "已到達1號站");
            phaser.arriveAndAwaitAdvance();

            System.out.println("執行緒" + Thread.currentThread().getName() + "已到達2號站");
            phaser.arriveAndAwaitAdvance();

            System.out.println("執行緒" + Thread.currentThread().getName() + "已到達3號站");
            phaser.arriveAndAwaitAdvance();

        }
    }
}
