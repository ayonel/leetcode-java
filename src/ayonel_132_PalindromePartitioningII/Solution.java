package ayonel_132_PalindromePartitioningII;

/**
 * @author ayonel
 * @create 2017-06-28 11:26
 * @blog https://ayonel.me
 **/
public class Solution {
    public int minCut(String s) {
        int length = s.length();
        if (length < 2)
           return 0;
        int[] dp = new int[length+1];
        for (int i = 0; i <= length; i++) {
            dp[i] = i-1;
        }
        boolean[][] isPal = new boolean[length+1][length+1];



        for (int i = 2; i <= length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (s.charAt(i-1) == s.charAt(j) && (i - 1 - j < 2 || isPal[j+1][i-1])) {
                    isPal[j][i] = true;
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        System.out.println(dp[length]);
        return dp[length];


    }

    public static void main(String[] args) {
        String s = "cabababcbc";
        new Solution().minCut(s);
    }
}
