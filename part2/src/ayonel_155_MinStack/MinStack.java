package ayonel_155_MinStack;


import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-06-30 20:00
 * @blog https://ayonel.me
 * 解题思路：两个栈，一个存数据，另一个存当前的最小值
 * 也可以用1栈实现，存的数据是与当前最小值的差值，当栈空的时候，存0， min = x；
 *
 **/
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> data;
    Stack<Integer> min;
    public MinStack() {
        data = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        if (data.empty() || x <= min.peek()){
            data.push(x);
            min.push(x);
        } else{
            data.push(x);
        }
    }

    public void pop() {
        int value = data.pop();
        if (value == min.peek())
            min.pop();

    }

    public int top() {
        return data.peek();

    }

    public int getMin() {
        return min.peek();
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());   //Returns -3.
        minStack.pop();
        System.out.println(minStack.top());      // Returns 0.
        System.out.println(minStack.getMin());   // Returns -2.
    }
}
