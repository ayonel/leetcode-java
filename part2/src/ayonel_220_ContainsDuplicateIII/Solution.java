package ayonel_220_ContainsDuplicateIII;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-06 12:32
 * @blog https://ayonel.me
 * 解题思路：O(NlogK)
 * 反正需要维护一个大小为K的集合，扫描一遍nums， 核心就是在K大小的集合里寻找有没有在某个区间的数字，用treeSET。。。
 * 数据结构需要温习一下
 *
 **/
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Long> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Long floor = values.floor((long)nums[ind] +(long)t);
            final Long ceil = values.ceiling((long)nums[ind] - (long)t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add((long)nums[ind]);
            if (ind >= k) {
                values.remove((long)nums[ind - k]);
            }
        }

        return false;
    }



    public static void main(String[] args) {
        int [] nums = {Integer.MIN_VALUE, Integer.MIN_VALUE+1};
        System.out.println(new Solution().containsNearbyAlmostDuplicate(nums, 3,3));
    }
}
