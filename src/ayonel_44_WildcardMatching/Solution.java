package ayonel_44_WildcardMatching;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-13 10:20
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路： 动归，需要对以*开头的p做初始化操作，全为true
 **/
public class Solution {
    public boolean isMatch(String s, String p) {

        int m = s.length()+1;
        int n = p.length()+1;
        boolean[][] dp = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = false;
        }

        int z = 0;
        while(z < n-1 && p.charAt(z) == '*') {
            for(int i = 0 ; i < m; i++) {
                dp[i][z+1] = true;
            }
            z++;
        }
        for (int i = z+1; i < n; i++) {
            dp[0][i] = false;
        }
        dp[0][0] = true;


        for (int i = 0; i < s.length(); i++) {
            for (int j = z; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    dp[i+1][j+1] = dp[i][j];
                    System.out.println(i+" "+j+" " + dp[i][j]);
                    continue;
                }
                if (p.charAt(j) == '*') {
                    dp[i+1][j+1] = dp[i][j+1] || dp[i+1][j];
                    continue;
                }
                if (s.charAt(i) != p.charAt(j))
                    dp[i+1][j+1] = false;
            }
        }

        print(dp);

        return dp[m-1][n-1];



    }

    private void print(boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Solution().isMatch("", "*"));
        System.out.println(new Solution().isMatch("aab", "c*b*a"));
    }

}
