package multithread;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class HashMapMultiThreadBad {

//    static Map<String, String> map = new HashMap<>();
//    static Map<String, String> map = new Hashtable<>();
    static Map<String, String> map = new ConcurrentSkipListMap<>();

    public static class AddThread implements Runnable {

        int start = 0;

        public AddThread(int start) {
            this.start = start;
        }

        @Override
        public void run() {
            for (int i = start; i < 10000; i += 2) {
                map.put(Integer.toString(i), Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new HashMapMultiThreadBad.AddThread(0));
        Thread t2 = new Thread(new HashMapMultiThreadBad.AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
