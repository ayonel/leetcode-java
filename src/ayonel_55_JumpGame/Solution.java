package ayonel_55_JumpGame;

/**
 * Jump Game
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-24 14:33
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：一直扫描，记录能走到的最大值，如果扫描到最大值时，最大值索引位置为0，且还没到最后一位，则表明走不了了，返回false
 * 其他返回true
 **/
public class Solution {
    public boolean canJump(int[] nums) {
        boolean res = true;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i]+i, max);
            if (i == max && nums[max] == 0 && i < nums.length - 1) {
                res = false;
                break;
            }
            if (i == nums.length - 1) {
                res = true;
                break;
            }

        }
        return res;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {0};
        System.out.println(s.canJump(a));
    }
}
