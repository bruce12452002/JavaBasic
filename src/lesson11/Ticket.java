package lesson11;

public class Ticket implements Runnable {
    private /*static*/ int ticket = 10;

    @Override
    public void run() {
        for (var i = 10; i > 0; i--) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "=>" + ticket--);
            }
        }
    }

    public static void main(String[] args) {
        // 不同的 Ticket 不一定可以共享票
        differentTicket();

        // 同個 Ticket 可以共享票
//        sameTicket();
    }

    private static void differentTicket() {
        // new Ticket() 3 次，所以票也是 3 倍
        // 這種寫法可將 ticket 改成 static，這樣子的變通也是一種改法
        Thread t1 = new Thread(new Ticket());
        Thread t2 = new Thread(new Ticket());
        Thread t3 = new Thread(new Ticket());
        t1.setName("t1");
        t2.setName("t2");
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }

    private static void sameTicket() {
        Ticket r = new Ticket();
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
