package ayonel_77_Combinations;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.  For example, If n = 4 and k = 2, a solution is:  [   [2,4],   [3,4],   [2,3],   [1,2],   [1,3],   [1,4], ]
 *
 * @author ayonel
 * @create 2017-06-20 14:04
 * @blog https://ayonel.me
 * 解题思路：深搜
 **/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 1; i <= n-k+1; i++) {
            dfs(i, new ArrayList<>(), res, n, k);
        }
        return res;

    }

    public void  dfs(int index, List<Integer> path, List<List<Integer>> res, int n, int k) {
        path.add(index);
        if (path.size() == k) {
            res.add(path);
            return;
        }
        if (n - index + 1 < k - path.size()) {
            return;
        }
        for(int i = index+1; i <= n; i++) {
            List<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            dfs(i, tmpPath, res, n , k);
        }

    }


    public static void main(String[] args) {
        System.out.println(new Solution().combine(0,1));
    }
}
