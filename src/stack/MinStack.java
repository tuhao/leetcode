package stack;

import java.util.Stack;

public class MinStack {

    class Node {

        Node(int val) {
            this.val = val;
        }

        int val;
        Node next;
        Node prev;
    }

    Node tail;
    Stack<Integer> minStack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        tail = null;
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (tail == null) {
            tail = new Node(x);
        } else {
            tail.next = new Node(x);
            tail.next.prev = tail;
            tail = tail.next;
        }
        if (minStack.size() == 0 || x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (tail == null) return;
        if (tail.prev == null) {
            tail = null;
        } else {

            tail.prev.next = null;
            tail = tail.prev;
        }
        minStack.pop();
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        if (minStack.size() == 0) throw new RuntimeException("栈中元素为空，此操作非法");
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */

