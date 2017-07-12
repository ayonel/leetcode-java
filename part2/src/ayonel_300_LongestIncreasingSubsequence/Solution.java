package ayonel_300_LongestIncreasingSubsequence;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-12 15:52
 * @blog https://ayonel.me
 * 解题思路：动归，我的思路可以，但是超时了。。。，主要感觉是数组开太多
 **/
public class Solution {
    int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size <= 1) return size;

        int[] dp = new int[size];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 1; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }
    public int lengthOfLISOLOGN(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size) ++size;
        }
        return size;
    }

    public int lengthOfLISCHAOSHI(int[] nums) {
        int n = nums.length;
        if (n <= 1) return n;
        if (n == 2) return nums[0] < nums[1] ? 2:1;


        int[][][] dp = new int[n][n][3];


        //初始化对角线
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][i][0] = nums[i];
                dp[i][i][1] = nums[i];
                dp[i][i][2] = 1;
            }
        }


        for (int gap = 1; gap < n; gap++) {
            for (int i = 0; i+gap < n; i++) {
                int[] left = dp[i][i+gap-1];
                int[] right = dp[i+1][i+gap];
                if (nums[i] < right[0]){
                    dp[i][i+gap][0] = nums[i];
                    dp[i][i+gap][1] = right[1];
                    dp[i][i+gap][2] = right[2]+1;
                    continue;
                }

                if (nums[i+gap] > left[1]) {
                    dp[i][i+gap][0] = left[0];
                    dp[i][i+gap][1] = nums[i+gap];
                    dp[i][i+gap][2] = left[2]+1;
                    continue;
                }
                if (left[2] >= right[2]) {
                    dp[i][i+gap][0] = left[0];
                    dp[i][i+gap][1] = left[1];
                    dp[i][i+gap][2] = left[2];
                } else {
                    dp[i][i+gap][0] = right[0];
                    dp[i][i+gap][1] = right[1];
                    dp[i][i+gap][2] = right[2];
                }
            }
        }
        print(dp);
        return dp[0][n-1][2];
    }

    void print(int[][][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j][0]+","+dp[i][j][1]+","+dp[i][j][2]+"      ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Solution().lengthOfLISOLOGN(nums));
    }


}
