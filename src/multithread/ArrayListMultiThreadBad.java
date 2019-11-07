package multithread;

import java.util.*;

public class ArrayListMultiThreadBad {

//    static List<Integer> al = new ArrayList<>(10);
//    static List<Integer> al = new Vector<>();
    static List<Integer> al = Collections.synchronizedList(new ArrayList<>());

    public static class AddThread implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                al.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread());
        Thread t2 = new Thread(new AddThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(al.size());
    }
}
