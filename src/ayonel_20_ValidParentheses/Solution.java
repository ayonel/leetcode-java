package ayonel_20_ValidParentheses;

import java.util.Stack;

/**
 * Valid Parentheses
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-08 15:39
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：利用堆栈，遇见(,[,{压栈，遇见),],}弹栈
 **/
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if(stack.isEmpty()){
                    return false;
                }

                if(s.charAt(i) == ')') {
                    if(stack.peek() != '(')
                        return false;
                    else
                        stack.pop();

                } else if(s.charAt(i) == ']') {
                    if(stack.peek() != '[')
                        return false;
                    else
                        stack.pop();
                } else {
                    if(stack.peek() != '{')
                        return false;
                    else
                        stack.pop();
                }

            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()[]{}"));
    }
}
