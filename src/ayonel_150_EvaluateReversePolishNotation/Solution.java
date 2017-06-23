package ayonel_150_EvaluateReversePolishNotation;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-14 09:45
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                res = b+a;
                stack.push(res);
            } else if (tokens[i].equals("-")) {
                int a = stack.pop();
                int b = stack.pop();
                res = b-a;
                stack.push(res);
            } else if (tokens[i].equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                res = b*a;
                stack.push(res);
            } else if (tokens[i].equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                res = b/a;
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }

        }

        return stack.pop();

    }


    public static void main(String[] args) {
        String[] tokens = {"4", "13", "-"};

        System.out.println(new Solution().evalRPN(tokens));
    }
}
