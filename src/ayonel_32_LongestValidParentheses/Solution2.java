package ayonel_32_LongestValidParentheses;

/**
 * @author ayonel
 * @create 2017-06-12 19:09
 * @blog https://ayonel.me
 **/
public class Solution2 {
    public int longestValidParentheses(String s) {
        int len = s.length();
        int[] stack = new int[len];
        int cnt =0;
        int[] dp = new int[len];
        int ans = 0;
        for(int i=0;i<len;i++)
        {
            if(s.charAt(i)==')')
            {
                if(cnt>0)
                {
                    int start = stack[--cnt];
                    dp[i] = i - start +1;
                    if(start>1)
                        dp[i] += dp[start-1];
                }
                else
                {
                    dp[i] = 0;
                }
            }else {
                stack[cnt++] = i;
                dp[i] = 0;
            }
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}