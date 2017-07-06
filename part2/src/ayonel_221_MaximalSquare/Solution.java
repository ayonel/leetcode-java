package ayonel_221_MaximalSquare;

/**
 * @author ayonel
 * @create 2017-07-06 14:08
 * @blog https://ayonel.me
 * 动归
 * 如果dp[i-1][j]、dp[i][j-1]、dp[i-1][j-1]中有一个为0，则dp[i][j] == 0
 * 如果上述三者都大于0,取三数中的最小值，再加上1就是以i,j为右下角的正方形的边上，最终需要返回res的平方
 **/
public class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int res = 0;
        int[][] dp = new int[m][n];
        //初始化行跟列
        for (int i = 0; i < m; i++) { //初始化第一列
            if (matrix[i][0] == '0')
                dp[i][0] = 0;
            else {
                dp[i][0] = 1;
                res = 1;
            }
        }
        for (int i = 0; i < n; i++) { //初始化第一列
            if (matrix[0][i] == '0')
                dp[0][i] = 0;
            else {
                dp[0][i] = 1;
                res = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1')
                    if (dp[i-1][j] == 0 || dp[i][j-1] == 0 || dp[i-1][j-1] == 0)
                        dp[i][j] = 1;
                    else{
                        dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1;
                        res = Math.max(dp[i][j], res);
                    }
            }
        }

        return res*res;

    }

    public int min(int x, int y, int z) {
        return Math.min(Math.min(x,y),z);
    }

    public static void main(String[] args) {
        char[][] matrixt = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'},
        };
        System.out.println(new Solution().maximalSquare(matrixt));
    }
}
