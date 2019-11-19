package structexercise;

public class LinkNodeQueue {

    class Node {
        Node next;
        String val;

        public Node(String item) {
            this.val = item;
        }
    }

    private Node head = null;
    private Node tail = null;

    public boolean enqueue(String item) {
        if (tail == null) {
            tail = new Node(item);
            head = tail;
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
        return true;
    }

    public String dequeue() {
        if (head == null) return null;
        String ret = head.val;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return ret;
    }

}
