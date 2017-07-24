package ayonel_628_MaximumProductofThreeNumbers;

import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-24 17:22
 * @blog https://ayonel.me
 **/
public class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[0] >= 0 || nums[n-1] <= 0)
            return nums[n-1]*nums[n-2]*nums[n-3];

        return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[0]*nums[1]*nums[n-1]);
    }

    public static void main(String[] args) {
        int[] nums = {-6,-1,1,2,3};
        System.out.println(new Solution().maximumProduct(nums));
    }
}
