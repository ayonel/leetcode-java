package ayonel_283_MoveZeroes;

/**
 * @author ayonel
 * @create 2017-07-11 21:46
 * @blog https://ayonel.me
 * 初始一个j=0；遇到不为0的，nums[j++]=0;
 * 最后把j之后的数置为0
 **/
public class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
            }
        }
        for(; j < nums.length; j++)
            nums[j] = 0;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
    }
}
