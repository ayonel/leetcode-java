package ayonel_232_ImplementQueueusingStacks;


import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-07-10 17:29
 * @blog https://ayonel.me
 **/
public class MyQueue {

    Stack<Integer> stack;
    Stack<Integer> aux;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
        aux = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            aux.push(stack.pop());
        }
        stack.push(x);
        for (int i = 0; i < size; i++) {
            stack.push(aux.pop());
        }

    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println();
    }
}
