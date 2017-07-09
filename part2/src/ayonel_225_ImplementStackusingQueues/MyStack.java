package ayonel_225_ImplementStackusingQueues;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * @author ayonel
 * @create 2017-07-07 22:30
 * @blog https://ayonel.me
 * 解题思路：辅助队列，pop，top的时候依次取出来存入辅助队列，然后再从辅助队列取回，效率有些低
 *
 * 可以开两个辅助队列，当push的时候，挑一个空的，add进去，然后，再把另一个队列中的元素，取完，接到这个队列尾部，
 * 此时，这个队列的顺序就是逆向的了，top，pop都有O(1)的效率， 也可以在push的时候，把整个队列逆过来
 **/
public class MyStack {
    Queue<Integer> deque;
    Queue<Integer> copy;

    /** Initialize your data structure here. */
    public MyStack() {
        deque = new ArrayDeque<>();
        copy = new ArrayDeque<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        deque.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        while (deque.size() > 1){
            copy.add(deque.poll());
        }

        int res = deque.poll();
        while (copy.size() > 0) {
            deque.add(copy.poll());
        }
        return res;

    }

    /** Get the top element. */
    public int top() {
        while (deque.size() > 1){
            copy.add(deque.poll());
        }

        int res = deque.poll();
        while (copy.size() > 0) {
            deque.add(copy.poll());
        }
        deque.add(res);
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());
        System.out.println(stack.top());
    }
}
