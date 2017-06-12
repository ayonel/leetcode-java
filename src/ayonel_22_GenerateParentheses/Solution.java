package ayonel_22_GenerateParentheses;

import java.util.*;

/**
 * Generate Parentheses
 *
 * @author ayonel
 * @create 2017-06-08 17:08
 * @blog https://ayonel.me
 * 解题思路：深搜
 **/
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<String>();
        generateOneByOne("", list, n, n);
        return list;
    }
    public void generateOneByOne(String sublist, List<String> list, int left, int right){
        if(left > right){
            return;
        }
        if(left > 0){
            generateOneByOne( sublist + "(" , list, left-1, right);
        }
        if(right > 0){
            generateOneByOne( sublist + ")" , list, left, right-1);
        }
        if(left == 0 && right == 0){
            list.add(sublist);
            return;
        }
    }


    public static void main(String[] args) {
        String[] a1 = {"()()()()","(()())()","(()(()))","()()(())","(((())))","(())()()","()((()))","()(())()","()(()())","(()()())","((()()))","((()))()","((())())"};
        String[] a2 = {"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        Arrays.sort(a1);
        Arrays.sort(a2);

        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < a2.length; i++) {
            System.out.print(a2[i]+" ");
        }
        System.out.println();
//        System.out.println(a2);
        new Solution().generateParenthesis(4);
    }
}
