package ayonel_309_BestTimetoBuyandSellStockwithCooldown;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author ayonel
 * @create 2017-08-21 10:51
 * @blog https://ayonel.me
 **/
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] sum = new int[n];
        int[] last = new int[n];

        if (n <= 1)
            return 0;
        if (n == 2)
            return prices[0] >= prices[1] ? 0 : prices[1]-prices[0];

        sum[0] = 0;
        sum[1] = prices[0] >= prices[1] ? 0 : prices[1]-prices[0];

        last[0] = -1;
        last[1] = sum[1] > 0 ? 1 : -1;


        for (int i = 2; i < n; i++) {

            if (prices[i] > prices[i-1] && (last[i-1] == -1 || last[i-1]==i-1)){
                sum[i] = sum[i-1]+prices[i]-prices[i-1];
                last[i] = i;
                continue;
            }

            if (prices[i] <= prices[i-1]){
                sum[i] = sum[i-1];
                last[i] = last[i-1];
            }


            if (prices[i] > prices[i-1]){

                if (prices[last[i-1]] < prices[i]){
                    sum[i] = prices[i]-prices[last[i-1]]+sum[last[i-1]];
                    last[i] = i;
                    continue;
                }
                if (last[i-1] == i-2){
                    if (i-3 >= 0 && sum[i-3] + prices[i]-prices[i-1] > sum[i-1]){
                        sum[i] = sum[i-3] + prices[i]-prices[i-1];
                        last[i] = i;
                    } else {
                        sum[i] = sum[i-1];
                        last[i] = i-1;
                    }
                } else {
                    sum[i] = sum[i-1] + prices[i]-prices[i-1];
                    last[i] = i;
                }

            }



        }

        for (int i = 0; i < n; i++) {
            System.out.print(sum[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(last[i]+" ");
        }

        return sum[n-1];

    }

    public static void main(String[] args) {
        int[] prices = {3,2,6,5,0,3};
        String s1 = "112";
        String s2 = "11";
        System.out.println(s1.compareTo(s2));
    }
}