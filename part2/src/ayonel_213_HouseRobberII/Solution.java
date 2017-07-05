package ayonel_213_HouseRobberII;

import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-05 14:20
 * @blog https://ayonel.me
 * 解题思路：假设数组为[0-N] 结果为MAX([0-N-1],[1,N]),
 * 原理：最终的结果对于nums[0]来看只有2种，能抢了或者不能抢，如果能抢，那么最后一个肯定不能抢，所以[0,N-1](当然，[0,n-1]也可以不抢0)
 * 如果不能抢，那么最后一个可以抢也可以不抢，所以[1,N]
 **/
public class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        return Math.max(rob(nums, 1, n), rob(nums, 0, n-1));
    }

    public int rob(int[] nums, int s, int e) {
        int n = e-s;

        if (n == 1)
            return nums[s];
        if (n == 2)
            return Math.max(nums[s], nums[s+1]);

        int[] dp = new int[n];

        dp[0] = nums[s];
        dp[1] = Math.max(nums[s], nums[s+1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[+i-1], nums[s+i] + dp[i-2]);
        }

        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Solution().rob(nums));
    }
}
