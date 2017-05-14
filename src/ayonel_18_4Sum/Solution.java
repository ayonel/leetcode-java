package ayonel_18_4Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 4Sum
 *
 * @author ayonel
 * @create 2017-05-14 19:35
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] nums, int target) {

        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int lo = i+1, hi = nums.length-1, sum = target - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> res = new LinkedList<>();
        int i = 0;
        while (i <  nums.length-3) {
            if (i == 0 || (i > 0) && nums[i] != nums[i-1]) {
                List<List<Integer>> res3Sum = threeSum(subArray(nums, i+1, nums.length),target-nums[i]);
                if (res3Sum.size() != 0) {
                    for (int j = 0; j < res3Sum.size(); j++) {
                        ArrayList<Integer> tmpList = new ArrayList<>(res3Sum.get(j));
                        tmpList.add(0,nums[i]);
                        res.add(tmpList);
                    }
                }

            }
            i++;
        }

        return res;
    }

    public int[] subArray(int[] nums, int start, int end){
        int[] result = new int[end-start];
        for(int i = start; i < end; i++) {
            result[i-start] = nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int array[] = {1, 0, -1, 0, -2, 2};

        System.out.println(s.fourSum(array, 0));
    }

}
