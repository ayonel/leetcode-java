package ayonel_581_ShortestUnsortedContinuousSubarray;


import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-07-23 13:05
 * @blog https://ayonel.me
 * 解题思路：用堆栈，两边各扫一遍，确定左右边界，秒啊
 *
 **/
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        Stack < Integer > stack = new Stack <Integer> ();
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
                l = Math.min(l, stack.pop());
            stack.push(i);
        }
        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                r = Math.max(r, stack.pop());
            stack.push(i);
        }
        return r - l > 0 ? r - l + 1 : 0;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3,1};
//        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(new Solution().findUnsortedSubarray(nums));
    }
}
