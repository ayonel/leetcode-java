package ayonel_35_SearchInsertPosition;

/**
 * Search Insert Position
 *
 * @author ayonel
 * @create 2017-05-21 22:20
 * @blog https://ayonel.me
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 **/
public class Solution {

    public int bsearch(int[] nums, int target) {
        int l = 0;
        int h = nums.length - 1;
        while(l <= h) {
            int m = (l + h) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] > target)
                h = m - 1;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,3,5,6};
        System.out.println(s.bsearch(a,4));
    }


}
