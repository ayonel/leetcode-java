public class Solution {
    public int numDecodings(String s) {
        int length = s.length();
        if(length == 0)
            return length;
        if(s.charAt(0) == '0')
            return 0;

        int[] dp = new int[length+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 1; i < length; i++) {

            if(s.charAt(i) == '0' && (s.charAt(i-1)=='1' || s.charAt(i-1)=='2')){
                dp[i+1] = dp[i-1];
                continue;
            }
            if(s.charAt(i) == '0' && (s.charAt(i-1) != '1') &&(s.charAt(i-1) != '2'))
                return 0;

            if(s.charAt(i) != '0' && s.charAt(i-1) == '0'){
                dp[i+1] = dp[i];
            } else if(s.charAt(i) != '0' && s.charAt(i-1) == '1'){
                dp[i+1] = dp[i]+dp[i-1];
            } else if(s.charAt(i) != '0' && s.charAt(i-1)== '2' && s.charAt(i) <= '6') {
                dp[i+1] = dp[i]+dp[i-1];
            } else{
                dp[i+1] = dp[i];
            }


        }


        return dp[length];

    }


    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings("120"));
    }

}