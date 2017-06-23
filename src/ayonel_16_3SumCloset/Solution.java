package ayonel_16_3SumCloset;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 3SumCloset
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-14 16:37
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num);
        int negativeMinGap = -Integer.MAX_VALUE;
        int positiveMinGap = Integer.MAX_VALUE;

        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (i > 0 && num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = target - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        return target;
                    } else if (num[lo] + num[hi] < sum) {
                        negativeMinGap = Math.max(negativeMinGap, num[lo] + num[hi] - sum);
                        lo++;
                    } else {
                        positiveMinGap = Math.min(positiveMinGap, num[lo] + num[hi] - sum);
                        hi--;
                    }
                }
            }
        }
        if(Math.abs(negativeMinGap) >= positiveMinGap)
            return target+positiveMinGap;
        else
            return target+negativeMinGap;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] array = {0,1,2};
        System.out.println(s.threeSumClosest(array,0));

    }
}
