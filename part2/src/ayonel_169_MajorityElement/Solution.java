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
        return major;
    }
}
