package ayonel_72_EditDistance;


/**
 * @author ayonel
 * @create 2017-06-04 23:20
 * @blog https://ayonel.me
 * 结题思路：2D-动归
 * 如果word1[i] == word[j]  dp[i+1][j+1] = dp[i][j]
 * 如果word1[i] != word[j]  dp[i+1][j+1] = min(dp[i][j+1]+1, dp[i][j]+1, dp[i+1][j]+1)
 *
 **/
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(word2))
            return 0;
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
                dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(word1.charAt(i) == word2.charAt((j))) {
                        dp[i+1][j+1] = dp[i][j];
                } else {
                    dp[i+1][j+1] = min(dp[i][j+1]+1, dp[i+1][j]+1, dp[i][j]+1);
                }

            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[m][n];
    }

    public int min(int x, int y, int z) {
        return Math.min(Math.min(x,y), z);
    }



    public static void main(String[] args) {
        new Solution().minDistance("abcd", "abe");
    }
}
