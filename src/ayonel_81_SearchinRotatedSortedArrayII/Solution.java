package ayonel_81_SearchinRotatedSortedArrayII;

/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?  Would this affect the run-time complexity? How and why? Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.  (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).  Write a function to determine if a given target is in the array.  The array may contain duplicates.  Subscribe to see which companies asked this question.
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-20 14:24
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public boolean search(int[] nums, int target) {

        int length = nums.length;
        if (length == 0)
            return false;
        if (nums[0] == target || nums[length - 1] == target)
            return true;
        int i = 0;
        int j = length - 1;
        if (nums[0] == nums[length - 1] && length > 1) {
            while(i < length && nums[i] == nums[0]) i++;
            while(j >= 0 && nums[j] == nums[0]) j--;
        }

        int start = i;
        int end = j;
        System.out.println(i+" "+j);
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;

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
        return false;


    }

    public static void main(String[] args) {
        int[] a = {1,1};
        System.out.println(new Solution().search(a, 0));
    }
}
