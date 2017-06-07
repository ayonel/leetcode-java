package ayonel_70_ClimbingStairs;

/**
 * @author ayonel
 * @create 2017-06-04 23:15
 * @blog https://ayonel.me
 **/
public class Solution {
    public int climbStairs(int n) {
        int[] res = new int[n+1];
        if ( n < 3)
            return n;
        res[0] = 0;
        res[1] = 1;
        res[2] = 2;

        for(int i = 3; i <= n; i++) {
            res[i] = res[i-1] + res[i-2];
        }

        return res[n];



    }
}
