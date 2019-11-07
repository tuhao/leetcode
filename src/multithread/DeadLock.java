package multithread;

import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    private static ReentrantLock lockA = new ReentrantLock();
    private static ReentrantLock lockB = new ReentrantLock();


    public static void main(String[] args) {
        Runnable runnableA = () -> {
            try {
                System.out.println(Thread.currentThread() + "lockA");
                lockA.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread() + "lockB");
                lockB.tryLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockA.unlock();
                lockB.unlock();
                System.out.println(Thread.currentThread() + "finish");
            }
        };
        Runnable runnableB = () -> {
            try {
                System.out.println(Thread.currentThread() + "lockB");
                lockB.lock();
                Thread.sleep(1000);
                System.out.println(Thread.currentThread() + "lockA");
                lockA.lock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lockB.unlock();
                lockA.unlock();
                System.out.println(Thread.currentThread() + "finish");
            }
        };
        new Thread(runnableA).start();
        new Thread(runnableB).start();
    }

}
