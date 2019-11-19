package structexercise;

public class ArrayQueue {

    private String[] items;
    private int n;
    private int head;
    private int tail;

    public ArrayQueue(int capacity) {
        n = capacity;
        items = new String[capacity];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String item) {
        if (tail == n) {
            //head = 0 表示整个队列满
            if (head == 0) return false;
            //集中出发一次数据搬移操作
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }
            tail = tail - head;
            head = 0;
        }
        items[tail] = item;
        ++tail;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }
}
