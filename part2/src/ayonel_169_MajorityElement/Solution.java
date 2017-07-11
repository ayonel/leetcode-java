package ayonel_169_MajorityElement;

/**
 * @author ayonel
 * @create 2017-07-02 13:09
 * @blog https://ayonel.me
 **/
public class Solution {
    public int majorityElement(int[] nums) {
        int count = 1, major = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count = 1;
            }
            if (nums[i] == major){
                count++;
            }  else
                count--;
        }
        int c = 0;
        for(int i : nums) {
            if (i == major)
                c++;
        }
        if (c > nums.length/2)
            return major;
        else return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(new Solution().majorityElement(nums));
    }
}
