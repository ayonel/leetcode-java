package ayonel_50_powerXN;

import java.util.Date;

/**
 * Pow(x, n)
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-13 17:41
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：二分
 **/
public class Solution {
    public double myPow(double x, int n) {
        if (x == 0.0)
            return 0;
        if (n == 0)
            return 1;
        if (n == 1)
            return x;
        boolean positiveFlag = true;
        if (n < 0)
            positiveFlag = false;
        double positiveRes = positivePow(x, Math.abs(n));

        if (positiveFlag)
            return positiveRes;
        else
            return 1.0/positiveRes;

    }

    public double positivePow(double x, int n) {

        if (n == 0)
            return 1;
        double res = x;
        if (n == 1)
            return res;
        return (n%2 == 0) ? positivePow(x*x, n/2) : x*pow(x*x, n/2);

    }

    public static void main(String[] args) {
        long start = new Date().getTime();
        System.out.println(new Solution().myPow(2, 7));
        System.out.println(new Date().getTime()-start);
    }


    public double pow(double x, int n) {
        if(n == 0)
            return 1;
        if(n<0){
            n = -n;
            x = 1/x;
        }
        double res = 1.0;
        while(n != 0) {
            if ((n&1) == 1) {
                res *=x;
            }
            x *= x;
            n >>= 1;
        }

        return res;
    }


}
