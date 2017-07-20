package ayonel_414_ThirdMaximumNumber;

/**
 * @author ayonel
 * @create 2017-07-20 15:09
 * @blog https://ayonel.me
 **/
public class Solution {
    public int thirdMax(int[] nums) {
        long first = (long)Integer.MIN_VALUE-1,second = first, third = first;

        for(int i : nums) {
            if(i == first || i == second || i <= third)
                continue;
            if(i < second) {
                third = i;
                continue;
            } else {
                if (i < first) {
                    third = second;
                    second = i;
                } else {
                    third = second;
                    second = first;
                    first =  i;
                }

            }
        }

        if (third == (long)Integer.MIN_VALUE-1) {
            return (int)first;
        } else {
            return (int)third;
        }
    }


    public static void main(String[] args) {
        int [] a = {1,2,-2147483648};
        System.out.println(new Solution().thirdMax(a));

    }
}
