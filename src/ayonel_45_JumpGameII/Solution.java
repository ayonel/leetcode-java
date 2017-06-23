package ayonel_45_JumpGameII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-05-23 20:02
 * @blog https://ayonel_113_PathSumII.me
 *
 * 解题思路：广度优先搜索(太慢了)，内存爆了，但是解法应该没问题，不能用
 **/
public class Solution {
    public int jump(int[] nums) {
        int res = 0xFFFFFF;

        List<Integer> resList = new ArrayList<>();

        wfs(nums, 0, 0, resList);
        for(int number : resList) {
            if (number < res)
                res = number;
        }

        return res;

    }
    private void wfs(int[] nums, int step, int index, List<Integer> resList) {
        if (index == nums.length - 1) {
            resList.add(step);
            return;
        }
        if (index >= nums.length)
            return;

        for (int i = 1; i <= nums[index]; i++) {
            wfs(nums, step + 1, index + i, resList);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {5,9,3,2,1,0,2,3,3,1,0,0};
        System.out.println(s.jumpStandard(a));
    }


    // 太巧秒了
    public int jumpStandard(int[] A) {
        int sc = 0;
        int e = 0;
        int max = 0;
        for(int i=0; i<A.length-1; i++) {
            max = Math.max(max, i+A[i]);
            if( i == e ) {
                sc++;
                e = max;
            }
        }
        return sc;
    }

    /**
     * 有些测试样例过不了
     * @param nums
     * @return
     */
    public int jumpMy(int[] nums) {
        if (nums.length < 2)
            return 0;

        int i = 0;
        int max = 0;
        int step = 0;
        while(i < nums.length && i + nums[i] < nums.length - 1) {
            for (int j = i + 1; j <= i + nums[i]; j++) {
                if(j + nums[j] >= nums.length - 1) {
                    return step+2;
                }
                if (j + nums[j] >= max) {
                    max = j + nums[j];
                }
            }

            i = max;
            step+=2;
            if (nums[max] == 0) {

                while (true) {
                    if (nums[--i] + i <= nums.length - 1) {
                        if (nums[nums[--i]+i] != 0)
                            break;
                    } else{
                        return step + 1;
                    }
                i = nums[i] + i;
                step += 1;
                }
            }
        }
        if (i < nums.length)
            return step+1;
        else
            return step;
    }


}
