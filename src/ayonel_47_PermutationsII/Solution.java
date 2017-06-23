package ayonel_47_PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-13 16:13
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：用46的递归也行，但是由于有重复元素，但是要注意，不要传引用，因为传引用的话，在递归方法返回时还要swap回来，所有会很费时间，
 * 如果传复制品，也就是传值的时候，就不需要swap回来了，相当于是尾递归，能大大提高效率,
 * permuteUnique1跟permuteUnique2方法时间几乎一样
 * dfs有一个boolean数组，值得注意
 *
 **/
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        solve(res, nums, 0 , nums.length-1);
        return res;

    }

    public void solve(List<List<Integer>> res, int[] nums, int from, int to) {
        if (from == to) {
            List<Integer> list = new ArrayList<>();
            for (int ele : nums) {
                list.add(ele);
            }
            if (!res.contains(list))
                res.add(list);
            return;
        } else {
            for (int i = from; i <= to; i++) {
                if (nums[i] == nums[from] && i != from) {
                    continue;
                } else {
                    swap(nums, i, from);
                    solve(res, nums, from+1, to);
                    swap(nums, i, from);
                }
            }
        }


    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,2,0,3,3,5,5};
        long start = new Date().getTime();
        System.out.println(new Solution().permuteUnique1(nums));
        System.out.println(new Date().getTime()- start);
//        System.out.println(new Solution().permuteUnique1(nums).size());

    }

    public List<List<Integer>> permuteUnique1(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];

        dfs(nums, used, new ArrayList<>(), res);

        return res;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res){
        if (list.size() == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i])
                continue;
            if(i>0 && nums[i-1]==nums[i] && !used[i-1])
                continue;
            used[i]=true;
            list.add(nums[i]);
            dfs(nums,used,list,res);
            used[i]=false;
            list.remove(list.size()-1);
        }

    }


    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        permutating(ans, nums, 0);
        return ans;
    }

    private void permutating(List<List<Integer>> ans, int[] nums, int start) {
        if (start == nums.length) {
            List<Integer> li = new ArrayList<>();
            for (int n : nums) {
                li.add(n);
            }
            ans.add(li);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i != start && nums[start] == nums[i]) {
                continue;
            }
            swap(nums, start, i);
            permutating(ans, Arrays.copyOf(nums, nums.length), start+1);
        }
    }

}
