package ayonel_441_ArrangingCoins;

/**
 * @author ayonel
 * @create 2017-07-20 19:53
 * @blog https://ayonel.me
 **/
public class Solution {
    public int arrangeCoins(int n) {
        return (int)((Math.sqrt((long)1+(long)8*(long)n) - 1) / 2);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(1804289383));
    }
}
