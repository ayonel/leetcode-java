package ayonel_121_BestTimetoBuyandSellStock;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;

/**
 * @author ayonel
 * @create 2017-06-24 16:02
 * @blog https://ayonel.me
 * 空间复杂度O(N)
 * 时间复杂度O(N)，保存一个max数组，存的是对应位之后的最大值
 * 正向推的话，根本不用维护数组，复杂度O(1)，草，脑子瓦塔拉
 *
 **/
public class Solution {
    public int maxProfitMine(int[] prices) {
        int length = prices.length;
        if (length <= 1)
            return 0;
        int[] maxArray = new int[length];
        int max = Integer.MIN_VALUE;
        for (int i = length-1; i >= 1; i--) {
            max = Math.max(prices[i], max);
            maxArray[i-1] = max;
        }
        //max 再利用
        max = 0;
        for (int i = 0; i < length - 1; i++)
            max = Math.max(max, maxArray[i] - prices[i]);
       return max;
    }
    public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur += prices[i] - prices[i-1];
            maxCur = Math.max(0, maxCur);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        System.out.println(maxSoFar);
        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] a = {4,5,7,5,9};
       new Solution().maxProfit(a);
    }
}
