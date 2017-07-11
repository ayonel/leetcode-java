package ayonel_279_PerfectSquares;

/**
 * @author ayonel
 * @create 2017-07-11 21:07
 * @blog https://ayonel.me
 * 解题思路：动归，如果n<=2直接返回结果
 * 否则开一个n+1长的数组，对每个数，其结果为： 分别用i 减去2^2,3^2...（保证差大于0），对于每个底，
 * 求得一个结果，取最小的一个，并与dp[i-1]+1相比，最小的为最终结果
 *
 * 比如12： 如果只用12以下的最大平方数（3^2=9），则结果为4，而如果再考虑2^2=4,则可以组成4+4+4， 结果是3
 **/
public class Solution {
    public int numSquares(int n) {
        if (n<=2) return n;

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++) {
            int res = Integer.MAX_VALUE;
            for(int j = (int)Math.floor(Math.sqrt(i)); j >= 2; j--) {
               res = Math.min(1+dp[i - (int)Math.pow(j,2)], res);
           }
           res = Math.min(dp[i-1]+1, res);
           dp[i] = res;
        }

//        for (int i: dp) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
        return dp[n];
    }

    public static void main(String[] args) {
//        System.out.println(Math.pow(2, (int)Math.floor(Math.sqrt(1))));
        System.out.println(new Solution().numSquares(12));
        System.out.println((int)Math.pow((int)Math.floor(Math.sqrt(12)),2));
    }
}
