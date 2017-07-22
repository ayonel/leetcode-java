package ayonel_453_MinimumMovestoEqualArrayElements;

import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-20 21:48
 * @blog https://ayonel.me
 * 解题思路：数学题
 * let's define sum as the sum of all the numbers, before any moves; minNum as the min number int the list; n is the length of the list;

After, say m moves, we get all the numbers as x , and we will get the following equation

sum + m * (n - 1) = x * n
and actually,

x = minNum + m
and finally, we will get

sum - minNum * n = m
So, it is clear and easy now.
 还有一种解释：
Adding 1 to n - 1 elements is the same as subtracting 1 from one element, w.r.t goal of making the elements in the array equal.
So, best way to do this is make all the elements in the array equal to the min element.
sum(array) - n * minimum
 **/
public class Solution {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i: nums) {
            sum+=i;
            if(i < min)
                min = i;
        }
        return sum-min*(nums.length);

    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,5};
        System.out.println(new Solution().minMoves(nums));
    }


}
