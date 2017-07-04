package ayonel_172_Factorial_Trailing_Zeroes;

/**
 * @author ayonel
 * @create 2017-07-02 14:02
 * @blog https://ayonel.me
 * 解题思路：
 * return n/5 + n/25 + n/125 + n/625 + n/3125+...;
    25算2个5
 **/
public class Solution {
    public int trailingZeroes(int n) {
        int ans = 0;
        while (n >= 5) {
            ans += n/5;
            n/=5;
        }

        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().trailingZeroes(1808548329));
    }
}
