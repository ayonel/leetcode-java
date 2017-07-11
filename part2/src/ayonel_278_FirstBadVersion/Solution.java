package ayonel_278_FirstBadVersion;

/**
 * @author ayonel
 * @create 2017-07-11 20:51
 * @blog https://ayonel.me
 * 结题思路二分
 **/
public class Solution {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n, mid;
        while (lo < hi) {
            mid = lo + (hi-lo)/2; //(lo+hi)/2会溢出
            if (isBadVersion(mid)){
                hi = mid;
            } else {
                lo = mid+1;
            }
        }

        return hi;

    }


    private boolean isBadVersion(int n) {
        if (n>=1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().firstBadVersion(2));
    }
}
