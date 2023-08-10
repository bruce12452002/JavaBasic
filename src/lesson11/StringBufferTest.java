package lesson11;

import java.util.concurrent.TimeUnit;

public class StringBufferTest {
    public static void main(String[] args) throws InterruptedException {
//        StringBuffer sb = new StringBuffer();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    sb.append("a");
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        // 睡眠确保所有线程都执行完
        Thread.sleep(2000);
        System.out.println(sb.length());
    }
}
