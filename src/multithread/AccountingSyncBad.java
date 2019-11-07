package multithread;

import java.util.concurrent.atomic.AtomicInteger;

public class AccountingSyncBad implements Runnable {

//    static int i = 0;

    static AtomicInteger i=new AtomicInteger(0);

    public void increase() {
//        i++;
        i.getAndIncrement();
    }

    @Override
    public void run() {
        for (int j = 0; j < 10000000; j++) {
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AccountingSyncBad());
        Thread t2 = new Thread(new AccountingSyncBad());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
