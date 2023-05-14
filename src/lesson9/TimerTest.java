package lesson9;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TimerTest extends TimerTask {
    public static void main(String[] args) {
//        testSchedule();
        scheduleAndScheduleAtFixedRate();
    }

    private static void testSchedule() {
        Timer timer = new Timer();

        // 第一個參數為"欲執行的工作"，會呼叫run()
        // 第二個參數為第一次執行的時間(Date)或延遲的時間(long)
        // 第三個參數為每幾毫秒做一次，沒加就是只執行一次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(LocalDateTime.now());
            }
        }, new Date(), 2000L);

        try {
            TimeUnit.SECONDS.sleep(10);
            timer.cancel(); // 取消排程
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * schedule、scheduleAtFixedRate 差別
     * schedule 設定完後，下次才會開始
     * scheduleAtFixedRate 設定完後，連同之前的都會做
     */
    private static void scheduleAndScheduleAtFixedRate() {
        Calendar cal = new GregorianCalendar(2022, Calendar.MAY, 1, 10, 0);
        System.out.println(new Date());
        // new Timer().schedule(new TimerTest(), cal.getTime(), 2000);
        new Timer().scheduleAtFixedRate(new TimerTest(), cal.getTime(), 2000);
    }

    @Override
    public void run() {
        System.out.println(LocalDateTime.now());
    }
}
