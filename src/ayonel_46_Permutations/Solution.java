package ayonel_46_Permutations;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * 46. Permutations
 *
 * @author ayonel
 * @create 2017-06-13 14:55
 * @blog https://ayonel.me
 * 解题思路：递归，也可以传值进去，用空间换时间
 **/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        solve(res, nums, 0, nums.length-1);
        return res;

    }

    public void solve(List<List<Integer>> res, int[] nums, int from, int to) {
        if (to < 0)
            return;

        if (from == to) {
            List<Integer> list = new ArrayList<Integer>();
            for (int ele:
                    nums) {
                list.add(ele);
            }
            res.add(list);
            return;
        } else {
            for (int i = from; i <= to; i++) {
                swap(nums, i, from);
                solve(res, nums, from+1, to);
                swap(nums, i, from);
            }
        }

    }



    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(new Solution().permute(nums));
    }

}
