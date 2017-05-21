package ayonel_33_SearchinRotatedSortedArray;

/**
 * SearchinRotatedSortedArray
 *
 * @author ayonel
 * @create 2017-05-21 20:19
 * @blog https://ayonel.me
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.


 解题思路：
 先利用二分查找找出pivot
 然后根据target属于左半部分还是右半部分来决定是从左半部分二分查找还是右半部分二分查找

 **/

public class Solution {
    public int search(int[] nums, int target) {
        // 先找pivot
        int len = nums.length;
        if (len  == 0)
            return -1;


        if (nums[len-1] >= nums[0]) {
            return bsearch(nums, 0, len - 1, target);
        }

        //寻找出pivot
        int pivot = bserachPivot(nums);
        if (target >= nums[pivot] && target <= nums[len-1]) {
            return bsearch(nums, pivot, len-1, target);
        } else {
            return bsearch(nums,0, pivot-1, target);
        }

    }

    public int bsearch(int[] nums, int start, int end, int target) {
        int l = start;
        int h = end;

        while (l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] < target) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;
    }

    public int bserachPivot(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        int endNum = nums[h];
        while (l <= h) {
            int m = (l + h) / 2;
            if (m >= 1 && nums[m] < nums[m - 1]) {
                return m;
            }
            if (nums[m] > endNum) {
                l = m + 1;
            } else {
                h = m - 1;
            }
        }
        return -1;

    }


    //完美的方案
    public int standardSearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]){
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {4,5,6,7,0};
        System.out.println(s.bserachPivot(a));
        System.out.println(s.search(a,0));
    }

}
