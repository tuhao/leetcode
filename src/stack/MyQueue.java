package stack;

import java.util.Stack;

/**
 * 232. Implement Queue using Stacks
 */
public class MyQueue {

    Stack<Integer> stackA;
    Stack<Integer> stackB;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        stackA = new Stack();
        stackB = new Stack();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        if (stackA.isEmpty()) {
            Integer result;
            while (!stackB.isEmpty() && (result = stackB.pop()) != null) {
                stackA.push(result);
            }
        }
        stackA.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (stackB.isEmpty()) {
            Integer result;
            while (!stackA.isEmpty() && (result = stackA.pop()) != null) {
                stackB.push(result);
            }
        }
        return stackB.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (stackB.isEmpty()) {
            Integer result;
            while (!stackA.isEmpty() && (result = stackA.pop()) != null) {
                stackB.push(result);
            }
        }
        return stackB.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackA.isEmpty() && stackB.isEmpty();
    }

    public static void main(String[] args) {
        int x = 1;
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.peek();

        obj.push(3);
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();

    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}
