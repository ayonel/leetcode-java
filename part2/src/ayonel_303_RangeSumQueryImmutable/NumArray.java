package ayonel_303_RangeSumQueryImmutable;

/**
 * @author ayonel
 * @create 2017-07-12 21:07
 * @blog https://ayonel.me
 **/
public class NumArray {
    int[] sums;
    int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        sums = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sums[i] = sum+nums[i];
            sum = sums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j]-sums[i]+nums[i];
    }
}
