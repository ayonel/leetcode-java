package ayonel_216_CombinationSumIII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-05 20:04
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<List<Integer>> combinationSum3Mine(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= 9-k+1; i++)
            dfs(i, n, new ArrayList<>(), res, k);

        return res;
    }

    public void dfs(int index, int target, List<Integer> path, List<List<Integer>> res, int k) {
        if (target < 0)
            return;
        if (target == index && path.size() == k-1) {
            path.add(index);
            res.add(path);
            return;
        }
        path.add(index);
        for (int i = index+1; i <= 9; i++) {
            List<Integer> newPath = new ArrayList<>();
            newPath.addAll(path);
            dfs(i, target-index, newPath, res, k);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(2,7));

    }


    //回溯版本
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        combination(ans, new ArrayList<Integer>(), k, 1, 9-k+1);
        return ans;
    }

    private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
        if (comb.size() == k && n == 0) {
            List<Integer> li = new ArrayList<Integer>(comb);
            ans.add(li);
            return;
        }
        for (int i = start; i <= 9; i++) {
            comb.add(i);
            combination(ans, comb, k, i+1, n-i);
            comb.remove(comb.size() - 1);
        }
    }
}



