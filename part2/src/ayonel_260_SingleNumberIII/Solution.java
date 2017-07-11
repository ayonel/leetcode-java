package ayonel_260_SingleNumberIII;

/**
 * @author ayonel
 * @create 2017-07-11 19:24
 * @blog https://ayonel.me
 **/
public class Solution {
    public int[] singleNumber(int[] nums) {
        int s = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s ^= nums[i];
        }
        int base = 1;
        for(int i = 0; i <= 31; i++) {
            if ((s & base) != 0){
                break;
            } else {
                base <<= 1;
            }
        }
        System.out.println(base);

        int num1 = 0, num2 = 0;
        for(int num : nums) {
            if ((base & num) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        int[] res = new int[2];
        res[0] = num1;
        res[1] = num2;
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,2,1,3,2,5};
        new Solution().singleNumber(a);
    }
}
