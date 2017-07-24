package ayonel_643_MaximumAverageSubarrayI;

/**
 * @author ayonel
 * @create 2017-07-24 20:34
 * @blog https://ayonel.me
 **/
public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int  length = nums.length;
        long max = 0, sum = 0;
        for(int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        max = sum;

        for (int i = k; i < length; i++) {
            max = Math.max(max, sum-nums[i-k]+nums[i]);
            sum = sum-nums[i-k]+nums[i];
        }

        return (double) max/k;
    }



}
