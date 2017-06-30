package ayonel_152_MaximumProductSubarray;

/**
 * @author ayonel
 * @create 2017-06-30 11:00
 * @blog https://ayonel.me
 * 解题思路：动归，两个动归数组，positive 和 negative
 * positive 存以该点开的向前连续的最大正乘积
 * negative 存以该点开的向前连续的最小负乘积
 * 如果该点是0，则positive[i]=negative[i] = 0
 * 需要注意，如果之前的一点，positive[i-1]<= 0 或者 negative[i-1]>=0， 则该店的negative[i]=positive[i] = nums[i]
 * 吊吊吊
 * 空间复杂度可以降为O(1)
 **/
public class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, cur = 1, preNeg = 1;
        int[] positive = new int[nums.length];
        int[] negative = new int[nums.length];
        positive[0] = nums[0] > 0 ? nums[0] : 1;
        negative[0] = nums[0] < 0 ? nums[0] : 1;
        max = Math.max(nums[0], max);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                positive[i] = 0;
                negative[i] = 0;
                max = Math.max(0, max);
            }
            if (nums[i] > 0) {
                if (positive[i-1] > 0) positive[i] = nums[i] * positive[i-1];
                else positive[i] = nums[i];

                if (negative[i-1] < 0) negative[i] = nums[i] * negative[i-1];
                else negative[i] = nums[i];

                max = Math.max(max, positive[i]);
            }

            if (nums[i] < 0) {
                if (negative[i-1] < 0) positive[i] = nums[i] * negative[i-1];
                else positive[i] = nums[i];

                if (positive[i-1] > 0) negative[i] = nums[i] * positive[i-1];
                else negative[i] = nums[i];
                max = Math.max(max, positive[i]);
            }
        }


        return max;


    }

    public static void main(String[] args) {
        int [] a = {2,-5,-2,0,-4, 3};
        System.out.println(new Solution().maxProduct(a));
    }
}