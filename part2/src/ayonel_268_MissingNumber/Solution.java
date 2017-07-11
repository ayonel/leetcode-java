package ayonel_268_MissingNumber;

/**
 * @author ayonel
 * @create 2017-07-11 19:40
 * @blog https://ayonel.me
 * 解题思路：累加，看缺了谁
 **/
public class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0, n = nums.length;
        for (int i: nums) {
            sum+=i;
        }
        return n*(n+1)/2-sum;
    }

    public static void main(String[] args) {
        int[] a = {0,1,3};
        System.out.println(new Solution().missingNumber(a));
    }
}
