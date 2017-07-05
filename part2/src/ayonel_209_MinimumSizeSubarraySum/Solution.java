package ayonel_209_MinimumSizeSubarraySum;

/**
 * @author ayonel
 * @create 2017-07-04 23:16
 * @blog https://ayonel.me
 * O(N^2)解法超时
 * 下面是我的O(n)解法，空间复杂度可以进一步降低，只是用两个指针

 **/
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int n = nums.length, ans = Integer.MAX_VALUE;
        int[] sum = new int[n];
        int[] last = new int[n];
        if (n == 0)
            return 0;
        if (nums[0] >= s)
            return 1;
        sum[0] = nums[0];
        last[0] = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] >= s){
                return 1;
            }
            if (sum[i-1] + nums[i] >= s) {
                int j = last[i-1], tmp=sum[i-1]+nums[i];
                while (tmp >= s){
                    tmp = tmp-nums[j];
                    j++;
                }
                sum[i] = tmp;
                last[i] = j;
                ans = Math.min(i-j+2, ans);
            } else {
                sum[i] = nums[i]+sum[i-1];
                last[i] = last[i-1];
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


    public int minSubArrayLenN2(int s, int[] nums) {
        int  n = nums.length;
        int[][] matrix = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            matrix[0][i] = sum;
        }
        for(int i = 1; i < n; i++) {
            for(int j = i; j < n; j++)
                matrix[i][j] = matrix[i-1][j] - nums[i-1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


        for(int gap = 0; gap < n; gap++) {
            for (int i = 0; i+gap < n; i++) {
                if (matrix[i][i+gap] >= s)
                    return gap+1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new Solution().minSubArrayLen(7,nums));
    }
}
