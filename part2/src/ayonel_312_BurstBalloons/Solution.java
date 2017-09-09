package ayonel_312_BurstBalloons;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.TreeMap;

/**
 * @author ayonel
 * @create 2017-09-02 21:18
 * @blog https://ayonel.me
 **/
class Solution {
    public int maxCoins(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;

        int[][] memo = new int[n][n];
        return burst(memo, nums, 0, n - 1);
    }

    public int burst(int[][] memo, int[] nums, int left, int right) {
        if (left + 1 == right) return 0;
//        if (memo[left][right] > 0) return memo[left][right];
        int ans = 0;
        for (int i = left + 1; i < right; ++i)
            ans = Math.max(ans, nums[left] * nums[i] * nums[right]
                    + burst(memo, nums, left, i) + burst(memo, nums, i, right));
        memo[left][right] = ans;
        return ans;
    }


    public int maxCoinsDP(int[] iNums) {
        int[] nums = new int[iNums.length + 2];
        int n = 1;
        for (int x : iNums) if (x > 0) nums[n++] = x;
        nums[0] = nums[n++] = 1;


        int[][] dp = new int[n][n];
        for (int k = 2; k < n; ++k)
            for (int left = 0; left < n - k; ++left) {
                int right = left + k;
                for (int i = left + 1; i < right; ++i)
                    dp[left][right] = Math.max(dp[left][right],
                            nums[left] * nums[i] * nums[right] + dp[left][i] + dp[i][right]);
            }

        return dp[0][n - 1];
    }
    boolean ans = true;
    public boolean isBalanced(TreeNode root) {
        return ans;
    }

    public int dfsHeight(TreeNode root) {
        if(ans == false)
            return 0;
        if (root == null) return 0;
        int leftHeight = dfsHeight (root.left);

        int rightHeight = dfsHeight (root.right);


        if (Math.abs(leftHeight - rightHeight) > 1)  {
            ans = false;
            return 0;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int first = 1;
        int second = 1;
        int tmp;
        for(int i = 2; i<=10; i++){
            tmp = first+second;
            System.out.println(tmp);
            first = second;
            second = tmp;
        }


    }
}