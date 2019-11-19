package structexercise;

public class CircleQueue {

    private String[] items;
    private int n;
    private int head;
    private int tail;

    public CircleQueue(int capacity) {
        n = capacity;
        items = new String[capacity];
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String item) {
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if (head == tail) return null;
        String ret = items[head];
        ++head;
        return ret;
    }

}
