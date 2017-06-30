package ayonel_154_FindMinimuminRotatedSortedArrayII;

/**
 * @author ayonel
 * @create 2017-06-30 16:45
 * @blog https://ayonel.me
 * 解题思路：二分，不过写的好麻烦
 * 先看最左边是不是等于最右边，如果是，将最右边指针一直减，直到不等于左边，这个数组成为初始数组
 * 然后二分，判断的时候需要和当时最右边last的值作比较。没到mid,需要找到左边和右边第一个和mid不相等的值。
 **/
public class Solution {
    public int findMin(int[] nums) {
        int lo = 0, length = nums.length, hi = length-1;

        if (nums[lo] < nums[hi])
            return nums[lo];
        if (nums[lo] == nums[hi]){
            while (hi >= 0 && nums[lo] == nums[hi])
                hi--;
        }

        if (hi < 0)
            return nums[0];

        int i = lo, j = hi, mid, left, right,last = nums[hi];

        while (i < j) {
            mid = (i + j) / 2;
            left = mid - 1;
            right = mid + 1;
            while (left >= lo && nums[left] == nums[mid])
                left--;
            while (right < length && nums[right] == nums[mid])
                right++;
            if (left < lo) {
                if (nums[right] > nums[mid] && nums[mid] < last) {
                    return nums[mid];
                } if (nums[right] > nums[mid] && nums[mid] > last){
                    i = right;
                    continue;
                }
            }
            if (right >= length) {
                if (nums[left] > nums[mid]) {
                    return nums[mid];
                } if (nums[left] < nums[mid]){
                    j = left;
                    continue;
                }
            }

            if (left >= 0 && nums[left] > nums[mid])
                return nums[mid];
            if (right < length && nums[right] < nums[mid])
                return nums[right];
            if (right < length && nums[right] > nums[mid] && nums[mid] > last && nums[left] < nums[mid]) {
                i = right;
                continue;
            }
            if (right < length && nums[right] > nums[mid] && nums[mid] < last && nums[left] < nums[mid]){
                j = left;;
                continue;
            }

        }

        return nums[i];
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 1, 1, 1};
        System.out.println(new Solution().findMinStandard(nums));
    }

    public int findMinStandard(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;
        int mid = 0;

        while(lo < hi) {
            mid = lo + (hi - lo) / 2;

            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else if (nums[mid] < nums[hi]) {
                hi = mid;
            }
            else { // when num[mid] and num[hi] are same
                hi--;
            }
        }
        return nums[lo];
    }
}
