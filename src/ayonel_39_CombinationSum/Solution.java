package ayonel_39_CombinationSum;

import java.util.*;

/**
 * Combination Sum
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-21 22:36
 * @blog https://ayonel_113_PathSumII.me
 *
 * 解题思路：深度优先搜索
 **/
public class Solution{
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private void dfs(int[] nums, int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(path);
            return;
        }
        for(int i = index; i < nums.length; i++) {
            ArrayList<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            tmpPath.add(nums[i]);
            dfs(nums, target-nums[i], i, tmpPath , res);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {7,3,2};
        System.out.println(s.combinationSum(a,18));
    }
}

