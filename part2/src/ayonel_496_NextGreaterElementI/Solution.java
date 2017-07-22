package ayonel_496_NextGreaterElementI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ayonel
 * @create 2017-07-22 15:09
 * @blog https://ayonel.me
 * 解题思路：可以考虑用栈+map
 * map.getOrDefault(i,1)
 **/
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map  = new HashMap<>();
        int[] res = new int[findNums.length];
        if(nums.length == 0) return res;

        int max = nums[nums.length-1];

        for (int i = nums.length-1; i >= 0; i--) {
            if(i == nums.length-1){
                map.put(nums[i], -1);
            } else{

                if(nums[i+1] > nums[i])
                    map.put(nums[i], nums[i+1]);
                else if(nums[i] > max){
                    map.put(nums[i], -1);
                } else {
                    for(int j = i+1; j < nums.length; j++) {
                        if (nums[j] > nums[i]){
                            map.put(nums[i], nums[j]);
                            break;
                        }
                    }
                }
                max = Math.max(nums[i], max);
            }
        }

        for (int i = 0; i < findNums.length; i++) {
            res[i] = map.get(findNums[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] findNums = {1,3,5,2,4};
        int[] nums = {6,5,4,3,2,1,7};
        new Solution().nextGreaterElement(findNums, nums);

    }
}
