package ayonel_53_MaximumSubarray;

/**
 * Maximum Subarray
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author ayonel
 * @create 2017-05-24 11:10
 * @blog https://ayonel.me
 * 解题思路：一遍扫描，判断当前子串总和是否大于等于0，如果是继续，否则的话，需要重新开始计算子串，sum清零
 * 或者利用动态规划
 **/
public class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;

        int max = -Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum >= 0) {
                max = Math.max(sum, max);
            } else {
                sum = 0;
                max = Math.max(max, nums[i]);
            }
        }
        return max;
    }


    //动态规划解决    dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);

    public int maxSubArrayDP(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        int[] a = {0};
        int[] a = {-2,1,2,3};
        System.out.println(s.maxSubArrayDP(a));
    }

}