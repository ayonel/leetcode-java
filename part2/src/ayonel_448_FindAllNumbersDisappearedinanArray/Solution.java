package ayonel_448_FindAllNumbersDisappearedinanArray;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-20 21:11
 * @blog https://ayonel.me
 * 解题思路：对于出现的每个数字，将他的索引位+n,如果遇到大于n的数字，真实索引为该数字-n,再将该索引位+n
 * 最后扫描一遍数组，凡是小于等于n的索引位，说明没出现过
 **/
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int num: nums) {
            if (num <= n){
                if (nums[num-1] <= n)
                    nums[num-1]+=n;
            } else {
                if (nums[num-n-1] <= n)
                    nums[num-n-1] += n;
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if (nums[i] <= n) list.add(i+1);
        }
        return list;

    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(new Solution().findDisappearedNumbers(nums));

    }
}
