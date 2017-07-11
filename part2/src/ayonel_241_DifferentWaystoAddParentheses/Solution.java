package ayonel_241_DifferentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-07-11 14:44
 * @blog https://ayonel.me
 * 解题思路：递归，如果遇到num 或者 num1(*|-|+)num2这样的就返回一个包含结果（大小为1）的list
 * 否则，对该子串按照运算符切割，递归计算出左半部分的结果，和右半部分的结果，对两部分结果分别运算，即是最后的结果
 * 我牛逼！！
 * 但是速度太慢！
 *
 **/
public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        return solve(input, 0, input.length()-1);
    }

    public List<Integer> solve(String input, int s, int e) {
        String sub = input.substring(s,e+1);

        String[] nums = sub.split("\\+|-|\\*");
        if (nums.length == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(Integer.parseInt(nums[0]));
            return res;
        } else if(nums.length == 2) {
            List<Integer> res = new ArrayList<>();
            int num1 = Integer.parseInt(nums[0]);
            int num2 = Integer.parseInt(nums[1]);
            if (sub.contains("+"))
                res.add(num1+num2);
            else if(sub.contains("-"))
                res.add(num1-num2);
            else
                res.add(num1*num2);
            return res;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = s; i <= e; i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                List<Integer> left = solve(input, s, i-1);
                List<Integer> right = solve(input, i+1, e);
                if (input.charAt(i) == '+') {
                    for(int num1 : left) {
                        for(int num2 : right) {
                            res.add(num1+num2);
                        }
                    }
                }
                if (input.charAt(i) == '-') {
                    for(int num1 : left) {
                        for(int num2 : right) {
                            res.add(num1-num2);
                        }
                    }
                }
                if (input.charAt(i) == '*') {
                    for(int num1 : left) {
                        for(int num2 : right) {
                            res.add(num1*num2);
                        }
                    }
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().diffWaysToCompute("2"));

    }
}
