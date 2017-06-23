package ayonel_10_RegularExpressionMatching;

/**
 * 10. Regular Expression Matching
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-04 16:22
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();

        }

        System.out.println("***********");

        for (int i = 0 ; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    } else {
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();

        }
        return dp[s.length()][p.length()];
    }


    public static void main(String[] args) {
        new Solution().isMatch("aab","c*a*b");
    }
}
