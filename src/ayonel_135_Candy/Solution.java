package ayonel_135_Candy;

import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-06-28 17:02
 * @blog https://ayonel.me
 * 解题思路：超时，草，MMP
 * 左右扫一遍，我勒个日,第一遍往右扫，形成了山的左侧，第二遍往左扫，补上了山的右侧，我日
 **/
public class Solution {
    public int candyMine(int[] ratings) {
        int n = ratings.length;
        if (n <= 1)
            return n;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1])
                dp[i] = dp[i-1]+1;
            else{
                if (dp[i-1] == 1) {
                    dp[i] = 1;
                    int k = i-1;
                    while (k >= 0) {
                        if (ratings[k] <= ratings[k+1] || dp[k] > dp[k+1])
                            break;
                        dp[k] += 1;
                        k--;
                    }
                }else{
                    dp[i] = 1;
                }
            }
        }

        int sum = 0;
        for(int ele : dp) {
            sum += ele;
            System.out.print(ele+" ");
        }
        System.out.println();
        return sum;
    }

    public int candy(int[] ratings) {
        int candies[] = new int[ratings.length];
        Arrays.fill(candies, 1);// Give each child 1 candy

        for (int i = 1; i < candies.length; i++){// Scan from left to right, to make sure right higher rated child gets 1 more candy than left lower rated child
            if (ratings[i] > ratings[i - 1]) candies[i] = (candies[i - 1] + 1);
        }

        for (int i = candies.length - 2; i >= 0; i--) {// Scan from right to left, to make sure left higher rated child gets 1 more candy than right lower rated child
            if (ratings[i] > ratings[i + 1]) candies[i] = Math.max(candies[i], (candies[i + 1] + 1));
        }

        int sum = 0;
        for (int candy : candies)
            sum += candy;
        return sum;
    }

    public static void main(String[] args) {
        int[] ratings = {1,3,3,3,2};
//        int[] ratings = {4,3,2,1};
        System.out.println(new Solution().candy(ratings));
    }
}
