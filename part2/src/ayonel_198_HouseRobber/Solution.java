package ayonel_198_HouseRobber;

/**
 * @author ayonel
 * @create 2017-07-04 11:09
 * @blog https://ayonel.me
 **/
public class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        if (nums.length == 2)
            return Math.max(nums[0], nums[1]);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], nums[i] + dp[i-2]);
        }

        return dp[nums.length-1];

    }


    public static void main(String[] args) {
        int[] nums = {3,10,7,1,5};
        System.out.println(new Solution().rob(nums));
    }
}
