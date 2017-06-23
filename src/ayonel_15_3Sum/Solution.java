package ayonel_15_3Sum;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * 3Sum
 *
 * @author ayonel_113_PathSumII
 * @create 2017-04-17 22:31
 * @blog https://ayonel_113_PathSumII.me
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note: The solution set must not contain duplicate triplets.
 解题思路：先排序，再顺序遍历，O（n^2）
 **/
public class Solution {
    public List<List<Integer>> threeSum(int[] num) {

        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {-3,-1,-1,-1,2};
        System.out.println(s.threeSum(array));

    }
}
