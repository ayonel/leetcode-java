package ayonel_322_CoinChange;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ayonel
 * @create 2017-09-09 16:27
 * @blog https://ayonel.me
 **/
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount<1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;

        while(++sum<=amount) {
            int min = -1;
            for(int coin : coins) {
                if(sum >= coin && dp[sum-coin]!=-1) {
                    int temp = dp[sum-coin]+1;

                    min = min<0 ? temp : (temp < min ? temp : min);
                }
            }
            dp[sum] = min;
        }
        return dp[amount];
    }
}