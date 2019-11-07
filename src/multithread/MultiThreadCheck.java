package multithread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class MultiThreadCheck {

    private final AtomicLong currentThread = new AtomicLong(-1L);
    private final AtomicInteger refCount = new AtomicInteger(0);

    void acquire() {
        long threadId = Thread.currentThread().getId();
        if (threadId != currentThread.get() && !currentThread.compareAndSet(-1L, threadId))
            throw new RuntimeException("禁止多线程调用");
        refCount.incrementAndGet();
    }

    void release() {
        if (refCount.decrementAndGet() == 0L) {
            currentThread.set(-1L);
        }
    }

    void foo() {
        try {
            long start = System.currentTimeMillis();
            acquire();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + ":" + (System.currentTimeMillis() - start));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            release();

        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultiThreadCheck multiThreadCheck = new MultiThreadCheck();
        Runnable a = () -> multiThreadCheck.foo();
        Thread threadA = new Thread(a);
        Thread threadB = new Thread(a);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

    }
}
