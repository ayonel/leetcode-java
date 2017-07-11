package ayonel_229_MajorityElementII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-09 17:27
 * @blog https://ayonel.me
 * 解题思路：投票算法
 **/
public class Solution {
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        int count1=0, count2=0, major1=0, major2=0;
        for(int i: nums) {
            if (i == major1)
                count1++;
            else if (i == major2)
                count2++;
            else if(count1 == 0){
                major1 = i;
                count1 = 1;
            } else if(count2 == 0){
                major2 = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }

        }
        int c1 = 0, c2 = 0;
        if (major1 == major2) {
            for(int i : nums){
                if (i == major1) {
                    c1++;
                }
            }
            if (c1 > nums.length / 3){
                res.add(major1);
            }
            return res;
        }

        for(int i : nums){
            if (i == major1) {
                c1++;
            }
            if (i == major2)
                c2++;
        }


        if (c1 > nums.length / 3){
            res.add(major1);
        }
        if (c2 > nums.length / 3){
            res.add(major2);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        System.out.println(new Solution().majorityElement(nums));
    }
}
