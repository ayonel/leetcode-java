package ayonel_227_BasicCalculatorII;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ayonel
 * @create 2017-07-08 15:21
 * @blog https://ayonel.me
 * 解题思路：用一个栈，如果当前符号是+|-|数字，直接进栈，如果是*|/则说明要运算了，从栈中弹出一个数字，作为操作数1，
 * 再从str中获取下一个token，为操作数2，然后根据是*还是/做运算，把结果再压入栈，知道遍历完str
 * 最后这个栈中只保留数字，+，- 从以需要从头到尾依次进行运算。
 * 所以这个栈是个deque, 从头到尾依次判断是+ 还是 -,知道栈中个元素个数为1，说明运算完了
 **/
public class Solution {
    public int calculate(String s) {
        char[] str = s.replace(" ", "").toCharArray();
        int i,j, length = str.length;
        String token;
        Deque<String> stack = new ArrayDeque<>();
        String firstToken = getToken(0, str);
        i = Integer.parseInt(firstToken.split(",")[1]);
        stack.addLast(firstToken.split(",")[0]);

        while (i < length && !stack.isEmpty()) {
            token = getToken(i, str);
            if (token.equals("*")) {
                int num1 = Integer.parseInt(stack.removeLast());
                i++;
                token = getToken(i, str);
                int num2 = Integer.parseInt(token.split(",")[0]);
                i = Integer.parseInt(token.split(",")[1]);
                stack.addLast(String.valueOf(num1*num2));
                continue;
            }

            if (token.equals("/")) {
                int num1 = Integer.parseInt(stack.removeLast());
                i++;
                token = getToken(i, str);
                int num2 = Integer.parseInt(token.split(",")[0]);
                i = Integer.parseInt(token.split(",")[1]);
                stack.addLast(String.valueOf(num1 / num2));
                continue;
            }

            if (token.equals("+") || token.equals("-")) {
                stack.addLast(token);
                i++;
            } else {
                token = getToken(i, str);
                stack.addLast(token.split(",")[0]);
                i = Integer.parseInt(token.split(",")[1]);
            }
        }
        while (stack.size() > 1) {
            int num1 = Integer.parseInt(stack.removeFirst());
            String op = stack.removeFirst();
            int num2 = Integer.parseInt(stack.removeFirst());
            if (op.equals("+")){
                stack.addFirst(String.valueOf(num1 + num2));
            } else {
                stack.addFirst(String.valueOf(num1 - num2));
            }
        }

        return Integer.parseInt(stack.removeFirst());
    }

    public String getToken(int i, char[] str) {
        switch (str[i]) {
            case '+':
                return "+";
            case '-':
                return "-";
            case '*':
                return "*";
            case '/':
                return "/";
            default:
                int  j = i;
                while (j < str.length && Character.isDigit(str[j])){
                    j++;
                }
                return String.copyValueOf(str, i, j-i) + ","+j;
        }
    }

    public static void main(String[] args) {
        char [] a = {'1','2','3'};
//        System.out.println(String.valueOf(a,1,2));

        System.out.println(new Solution().calculate("5+5+5*10"));

    }


}
