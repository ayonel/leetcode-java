package ayonel_4_MedianOfTwoSortedArrays;

/**
 * Created by dimera on 2017/3/6.
 * 解题思路：两个数组的长度为m，n 则取min(m,n)为遍历的数组
 * 在长度小的数组中，二分遍历，选定m数组的某个位置时，n数组可能成为中位数的点已经就确定了。
 * 所以在min(m,n)中二分查找，最终选择合适的位置
 * Searching i in [0, m], to find an object `i` that:
 B[j-1] <= A[i] and A[i-1] <= B[j], ( where j = (m + n + 1)/2 - i )
 */
//太经典了，智商被碾压啊~~~~~~~~~ORZ----------
public class Solution {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        if (len1 <= len2) {
            return getResult(nums1, nums2);
        } else {
            return getResult(nums2, nums1);
        }
    }

    // 数组长度短的在前
    public static double getResult(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int imin = 0;
        int imax = m;
        double result = 0;
        while(imin <= imax) {
            int i = (imin + imax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (i < m && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            } else if(i > 0 && nums1[i-1] > nums2[j]) {
                imax = i - 1;
            } else {
                int max_of_left;
                if (i == 0) {
                    max_of_left = nums2[j-1];
                } else if (j == 0) {
                    max_of_left = nums1[i-1];
                } else {
                    max_of_left = max(nums1[i-1], nums2[j-1]);
                }
                if ((m + n) % 2 == 1) {
                    result =  max_of_left;
                    break;
                }
                int min_of_right;
                if (i == m) {
                    min_of_right = nums2[j];
                } else if (j == n) {
                    min_of_right = nums1[i];
                } else {
                    min_of_right = min(nums1[i], nums2[j]);
                }
                result = (max_of_left + min_of_right) / 2.0;
                break;

            }
        }
        return result;
    }

    public static int max(int i, int j) {
        return i >= j ? i : j;
    }
    public static int min(int i, int j) {
        return i <= j ? i : j;
    }

    public static void main(String[] args) {
        int nums1[] = {1,3};
        int nums2[] = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
