package ayonel_27_RemoveElement;

/**
 * Remove Element
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-15 22:17
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public  int removeElement(int[] nums, int val) {
        int id = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] != val) {
                nums[id++] = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
        return id;

    }


}