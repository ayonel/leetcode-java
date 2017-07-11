package ayonel_238_ProductofArrayExceptSelf;

/**
 * @author ayonel
 * @create 2017-07-10 22:16
 * @blog https://ayonel.me
 * 解题思路：用输出数组存每个数右边的数的乘
 * 在开一个变量，存每个数左边的数的乘积，然后乘以输出数组中对应位置上的数
 **/
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int length = nums.length;
        res[length-1] = 1;
        for (int i = length-2; i >= 0; i--)
            res[i] = res[i+1] * nums[i+1];
        int pre = 1;
        for(int i = 1; i < length; i++) {
            pre = pre*nums[i-1];
            res[i] = res[i]*pre;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        int[] res = new Solution().productExceptSelf(a);
    }
}
