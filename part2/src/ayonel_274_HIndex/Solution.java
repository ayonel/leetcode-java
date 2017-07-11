package ayonel_274_HIndex;

import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-11 19:48
 * @blog https://ayonel.me
 * 解题思路：先排序数组，然后从最后面开始往前扫，如果当前数，大于等于（包括该数之后的元素个数），则将
 * 和index更新为（包括该数之后的元素个数）
 * （包括该数之后的元素个数） 是逐渐递增的！！
 *
 * 解法：还可以用桶排序，o(n)
 **/
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (n == 0)
            return 0;
        Arrays.sort(citations);

        int hindex = 0;
        for (int i = n-1; i >= 0; i--)
            if (citations[i] >= n-i)
                hindex = n-i;

        System.out.println(hindex);
        return hindex;

    }
    public int hIndexBucket(int[] citations) {
        int n = citations.length;
        int[] buckets = new int[n+1];
        for(int c : citations) {
            if(c >= n) {
                buckets[n]++;
            } else {
                buckets[c]++;
            }
        }
        int count = 0;
        for(int i = n; i >= 0; i--) {
            count += buckets[i];
            if(count >= i) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] citations = {1};
       new Solution().hIndex(citations);
    }
}
