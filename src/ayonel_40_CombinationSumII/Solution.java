package ayonel_40_CombinationSumII;

import sun.security.krb5.internal.PAData;
import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.util.*;

/**
 * Combination Sum II
 *
 * @author ayonel
 * @create 2017-05-22 21:15
 * @blog https://ayonel.me
 * 结题思路：这个题目需要不带重复元素的解集
 * 深度优先搜索，
 **/
public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<Integer>(), res);
        HashSet<List<Integer>> hashSet = new HashSet<>();
        hashSet.addAll(res);
        res = new ArrayList<>();
        res.addAll(hashSet);
        return res;

    }

    private void dfs(int[] candicates, int target, int index, List<Integer> path, List<List<Integer>> res) {
        if (target < 0)
            return;
        if (target == 0) {
            res.add(path);
            return;
        }
        for (int i = index; i < candicates.length; i++) {

            List<Integer> tmpList = new ArrayList<>();
            tmpList.addAll(path);
            tmpList.add(candicates[i]);
            dfs(candicates, target-candicates[i], i+1, tmpList, res);
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {10, 1, 2, 7, 6, 1, 5};
        System.out.println(s.combinationSum2(a,8));
    }

}
