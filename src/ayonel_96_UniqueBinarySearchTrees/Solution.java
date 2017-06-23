package ayonel_96_UniqueBinarySearchTrees;

/**
 * @author ayonel
 * @create 2017-06-22 21:29
 * @blog https://ayonel.me
 * 解题思路：动归
 * 第n的结果为，2*[n-1] +  分别以2~n-1为根节点的树的数目
 * 其中以第k为根节点的树， [k-1]*[n-k]
 **/
public class Solution {
    public int numTrees(int n) {

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int num = 2*dp[i-1];
            for(int j = 2; j <= i-1 ; j++) {
                num += dp[j-1] * dp[i-j];
            }
            dp[i] = num;
        }

        for(int i = 0; i <= n; i++) {
            System.out.print(dp[i]+" ");
        }
        return dp[n];

    }

    public static void main(String[] args) {
        new Solution().numTrees(4);
    }
}
