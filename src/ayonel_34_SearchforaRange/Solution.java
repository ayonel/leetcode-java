package ayonel_34_SearchforaRange;

/**
 * Search for a Range
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-21 21:22
 * @blog https://ayonel_113_PathSumII.me
 * Given an array of integers sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4].

 解题思路：
 **/
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int targetIndex = bsearch(nums, target);
        int[] result = {-1, -1};

        if (targetIndex == -1) {
            return result;
        }
        int i = targetIndex;
        int j = targetIndex;
        while (i >= 0 && nums[i] == target){
            i--;
        }
        while (j < nums.length && nums[j] == target){
            j++;
        }

        result[0] = i + 1;
        result[1] = j - 1;
        return result;



    }

    private int bsearch(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;

        while(l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target)
                h = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }




 }
