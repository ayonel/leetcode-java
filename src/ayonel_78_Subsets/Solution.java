package ayonel_78_Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Subsets
 *
 * @author ayonel
 * @create 2017-05-25 22:59
 * @blog https://ayonel.me
 * 解题思路：广搜与深搜
 **/
public class Solution {
    //广搜
    public List<List<Integer>> subsetsBFS(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        for (int i = 0; i< nums.length; i++)
            bfs(nums, i, new ArrayList<>(), res);
        System.out.println(res);
        return res;

    }

    public void bfs(int[] nums, int index, List<Integer> path ,List<List<Integer>> res) {
        res.add(path);
        if (index == nums.length)
            return;
        path.add(nums[index]);
        for (int i = index+1; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(path);
            bfs(nums, i, list, res);
        }

    }

    //深搜
    public List<List<Integer>> subsetsDFS(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<>(), res);
        System.out.println(res);
        return res;

    }



    public void dfs(int[] nums, int index, List<Integer> path ,List<List<Integer>> res) {
        res.add(path);
        for (int i = index; i < nums.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            list.addAll(path);
            list.add(nums[i]);
            dfs(nums, i+1, list, res);
        }

    }




    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {1,2,3};
        s.subsetsDFS(a);

    }
}