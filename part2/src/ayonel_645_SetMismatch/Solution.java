package ayonel_645_SetMismatch;

/**
 * @author ayonel
 * @create 2017-07-24 21:52
 * @blog https://ayonel.me
 **/
public class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            if (nums[i] > n) {
                if (nums[nums[i]-n-1] > n)
                    res[0] = nums[i]-n;
                else
                    nums[nums[i]-n-1] += n;
            } else {
                if (nums[nums[i]-1] > n)
                    res[0] = nums[i];
                else
                    nums[nums[i]-1] += n;
            }
        }
        for(int i = 0; i < n; i++){
            if(nums[i] <= n)
                res[1] = i+1;
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,4};
        System.out.println(new Solution().findErrorNums(nums));
    }
}
