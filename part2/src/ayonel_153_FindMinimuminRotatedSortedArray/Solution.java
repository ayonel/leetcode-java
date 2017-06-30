package ayonel_153_FindMinimuminRotatedSortedArray;

/**
 * @author ayonel
 * @create 2017-06-30 16:27
 * @blog https://ayonel.me
 * 解题思路：二分搜索，lo | hi变化的时候，根据nums[mid] 与 最后一个数来定
 **/
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length-1,mid, last = hi;
        if (nums[lo] <= nums[hi]) {
            return nums[lo];
        }
        while (lo < hi) {
            mid = (lo + hi) / 2;
            if (mid > 0 && mid < last && nums[mid] < nums[mid-1])
                return nums[mid];
            if (nums[mid] < nums[last])
                hi = mid - 1;
            if(nums[mid] > nums[last])
                lo = mid + 1;
        }

        return nums[lo];

    }

    public static void main(String[] args) {
        int[] nums = {4 ,5, 6, 7};
        System.out.println(new Solution().findMin(nums));
    }

}
