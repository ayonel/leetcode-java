package ayonel_121_BestTimetoBuyandSellStock;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.HashMap;

/**
 * @author ayonel
 * @create 2017-06-24 16:02
 * @blog https://ayonel.me
 * 空间复杂度O(N)
 * 时间复杂度O(N)，保存一个max数组，存的是对应位之后的最大值
 * 草本来就是线性的问题，我想这么复杂干嘛，一直判断是否增，如果增直接将当前max增，直到减，则开始重新计数。
 **/
public class Solution {
    public int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        int[] a = {5,5,4,9,3,8,5,5,1,6,8,3,4};
       new Solution().maxProfit(a);
    }
}
