package lesson11;

import java.util.stream.Stream;

/**
 * Object 裡的 wait、notify、notifyAll，都必需寫在 synchronized 裡，否則會出 java.lang.IllegalMonitorStateException 的錯
 * 一、wait 和 sleep 比較：wait 會釋放鎖；sleep 不會釋放鎖
 * 二、wait 和 wait(時間)：wait(0) 等同 wait()；假設等待 100 毫秒，又分成兩種情形
 * 1. 在 100 毫秒內被喚醒：接下來的動作和 wait() 一下
 * 2. 100 毫秒到了也會自動喚醒，這個可以防止永久等待
 * notify 和 notifyAll 比較：notify 隨機喚醒其中一個執行緒；notifyAll 喚醒全部的執行緒
 * <p>
 * 三、spurious wakeup 虛假喚醒
 * 假設有三個執行緒，兩個 wait 後，第三個做完後 notifyAll()，兩個執行緒的 wait 是寫在 wait 裡的
 * 所以就會直接往下執行了，想要防止這種情形，可以使用 while 代替 if，但判斷再執行一次
 */
public class WaitNotifyAllTest {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Runnable r1 = () -> Stream.iterate(1, i -> ++i).limit(10).forEach(i -> factory.product());
        Runnable r2 = () -> Stream.iterate(1, i -> ++i).limit(10).forEach(i -> factory.consume());
        new Thread(r1, "r1").start();
        new Thread(r2, "r2").start();
    }
}

class Factory {
    private int count;

    public synchronized void product() {
        if (count == 10) { // 改用 while 可防止虛假喚醒
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("生產後剩" + ++count);
        notify();
    }

    public synchronized void consume() {
        if (count == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消費後剩" + --count);
        notify();
    }
}
