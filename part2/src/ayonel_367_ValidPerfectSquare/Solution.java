package ayonel_367_ValidPerfectSquare;

/**
 * @author ayonel
 * @create 2017-07-12 23:00
 * @blog https://ayonel.me
 * 解题思路：二分，考虑溢出的情况
 * A square number is 1+3+5+7+..., JAVA code
 **/
public class Solution {
    public boolean isPerfectSquare(int num) {
        long lo = 1, hi = num, mid;
        while(lo <= hi) {
            mid = lo + ((hi-lo)>>1);
            if (mid*mid == num) {
                return true;
            } else if(mid*mid < num) {
                lo = mid+1;
            } else {
                hi = mid-1;
            }
        }
        return false;
    }

    public boolean isOverflow(long x) {
        return x >(long)Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPerfectSquare(2));
    }
}
