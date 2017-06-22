package ayonel_88_MergeSortedArray;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.


 * @author ayonel
 * @create 2017-06-21 18:23
 * @blog https://ayonel.me
 * 解题思路：从后往前的就不用开空间，直接从m+n-1处开始存
 **/
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0, j = 0;
        if(m == 0) {
            for(int k = 0; k < n; k++)
                nums1[k] = nums2[k];
            return;
        }
        if(n == 0)
            return;
        int[] array = new int[m+n];

        while (i < m || j < n) {
            if (i >= m) {
                array[i+j] = nums2[j];
                j++;
            } else if (j >= n) {
                array[i+j] = nums1[i];
                i++;
            } else if(nums1[i] < nums2[j]) {
                array[i+j] = nums1[i];
                i++;
            } else {
                array[i+j] = nums2[j];
                j++;
            }
        }
        for (int k = 0; k <= i+j-1; k++) {
            nums1[k] = array[k];

        }

        for (int k = 0; k < nums1.length; k++) {
            System.out.print(nums1[k]+" ");
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1,0};
        int[] nums2 = {2};
        new Solution().merge(nums1, 1, nums2,1);
    }
}