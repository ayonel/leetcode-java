package ayonel_275_HIndexII;

/**
 * @author ayonel
 * @create 2017-07-11 20:27
 * @blog https://ayonel.me
 * Follow up for H-Index: What if the citations array is sorted in ascending order? Could you optimize your algorithm?
 * 已经是升序的，考虑用二分,我是真的皮
 * 如果找到符合的和hindex，将hi置为mid，而不是mid-1，防止过站，是我的写法，标准写法不会出现这样的问题
 * 否则 将lo置为mid+1，最终lo将会在最小的符合条件的那个mid上，所以此时n-mid最大
 **/
public class Solution {
    public int hIndex(int[] citations) {
        int lo = 0, hi = citations.length-1, n = citations.length,mid=0;

        if (n == 0 || citations[n-1] == 0)
            return 0;

        while (lo < hi) {
            mid = (lo+hi)/2;
            if (citations[mid] >= n-mid)
                hi = mid-1;
            else
                lo = mid + 1;
        }
        System.out.println(n-lo);
        return n-lo;

    }

    public static void main(String[] args) {
//        int[] citations = {0,1,3,5,6};
        int[] citations = {0,0,0,0,0,1};
        new Solution().hIndex(citations);
    }
    public int hIndexStandard(int[] citations) {
        int len = citations.length;
        int lo = 0, hi = len - 1;
        while (lo <= hi) {
            int med = (hi + lo) / 2;
            if (citations[med] == len - med) { //只要相等，就是最小的mid,仔细想想，是这么个理儿，肯定是最小的，0，1，【3】，5，6

                return len - med;
            } else if (citations[med] < len - med) {
                lo = med + 1;
            } else {
                //(citations[med] > len-med), med qualified as a hIndex,
                // but we have to continue to search for a higher one.
                hi = med - 1;
            }
        }
        return len - lo;
    }

}
