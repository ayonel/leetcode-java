package ayonel_69_SqrtX;

/**
 * 69. Sqrt(x)
 *
 * @author ayonel
 * @create 2017-06-15 20:41
 * @blog https://ayonel.me
 * 解题思路：二分搜索
 **/
public class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1)
            return x;
        int lo = 1, hi = x;
        int mid = 0;
        double tmpSquare = 0.0;
        while(lo <= hi) {
            mid = lo +(hi-lo)/2;
            tmpSquare = (double)mid * mid;
            if (tmpSquare == x)
                return mid;
            else if (tmpSquare < (double)x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo-1;

    }

    public boolean isOverflow(double x) {
        return x > Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().mySqrt(2147395599));
//        System.out.println(new Solution().mySqrt(10));
    }
}
