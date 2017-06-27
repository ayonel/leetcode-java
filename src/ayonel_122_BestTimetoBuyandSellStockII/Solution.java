package ayonel_122_BestTimetoBuyandSellStockII;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * @author ayonel
 * @create 2017-06-26 22:59
 * @blog https://ayonel.me
 * 解题思路：扫描，设置一个标记为，表示现在需要买还是卖，遇到拐点，决定买还是卖
 * 看standard 草
 **/
public class Solution {
    public int maxProfit(int[] prices) {
        boolean buy = true;
        int curBuy = Integer.MIN_VALUE, curProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy && prices[i] > prices[i-1]) {
                curBuy  = prices[i-1];
                buy = !buy;
                continue;
            }
            if (!buy && prices[i] < prices[i-1]) {
                curProfit += prices[i-1] - curBuy;
                buy = !buy;
                curBuy = Integer.MIN_VALUE;
            }
        }
        if (curBuy != Integer.MIN_VALUE && prices[prices.length-1] > curBuy)
            curProfit += prices[prices.length-1] - curBuy;

        return curProfit;
    }

    public int maxProfitStandard(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
        }

        return total;
    }

    public static void main(String[] args) {
        int[] prices = {0,3,2,8,9,10};
        System.out.println(new Solution().maxProfit(prices));
    }
}
