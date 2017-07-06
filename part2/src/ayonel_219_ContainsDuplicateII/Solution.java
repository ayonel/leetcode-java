package ayonel_219_ContainsDuplicateII;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-05 22:51
 * @blog https://ayonel.me
 * 用一个map就行了
 **/
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k >= nums.length)
            return false;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                if (i-map.get(nums[i]) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public boolean test(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true; //如果出现main里面的那种情况，直接返回了，所以在i<k的时候，如果出现相同元素直接返回
        }
        return false;
    }

    public static void main(String[] args) {
        int [] nums = {0,1,0,1,0};
        System.out.println(new Solution().test(nums, 1));
    }



}
