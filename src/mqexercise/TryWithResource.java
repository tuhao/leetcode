package mqexercise;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryWithResource implements Closeable {

    public TryWithResource(Lock lock) {
        this.lock = lock;
    }

    private Lock lock;

    public void lock() {
        lock.lock();
    }

    @Override
    public void close() throws IOException {
        lock.unlock();
        System.out.println("释放锁");
    }

    public void tryLock(Long time, TimeUnit unit) throws InterruptedException {
        lock.tryLock(time, unit);
    }

    public static void main(String[] args) {
        try (TryWithResource autoUnlockProxy = new TryWithResource(new ReentrantLock())) {
            autoUnlockProxy.lock();
            System.out.println("加锁了");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
