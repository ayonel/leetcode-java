package ayonel_29_DivideTwoIntegers;

import java.util.InputMismatchException;

/**
 * 29. Divide Two Integers
 *
 * @author ayonel
 * @create 2017-06-11 22:55
 * @blog https://ayonel.me
 *
 * 解题思路：逐个加除数，直到大于被除数，但是会超时，需要二分
 **/
public class Solution {
    public int divide(int dividend, int divisor) {
        long res = 0;
        if (dividend == 0)
            return 0;
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            flag = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            flag = true;
        long absDivisor = Math.abs((long)divisor);
        long absDividend = Math.abs((long)dividend);
        long realDivisor = absDivisor;

        if(realDivisor == 1) {
            res = absDividend;
        } else {
            while(realDivisor <= absDividend) {
                realDivisor += absDivisor;
                res++;
            }
        }

        if (isOverflow(res, flag))
            return Integer.MAX_VALUE;

        if (flag)
            return (int)res;
        else{
            System.out.println("dd");
            return (int)(-res);
        }

    }

    public boolean isOverflow(long num, boolean flag) {
        if (flag) {
            if (num > Integer.MAX_VALUE)
                return true;
        } else {
            if (num > (long)Integer.MAX_VALUE+1)
                return true;
        }
        return false;
    }




    public int divideStandard(int dividend, int divisor) {
        long res = 0;
        if (dividend == 0)
            return 0;
        boolean flag = true;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0))
            flag = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
            flag = true;
        long absDivisor = Math.abs((long)divisor);
        long absDividend = Math.abs((long)dividend);
        long realDivisor = absDivisor;

        res = ldivide(absDivisor, absDividend);

        System.out.println(res);
        if (isOverflow(res, flag))
            return Integer.MAX_VALUE;

        if (flag)
            return (int)res;
        else{
            return (int)(-res);
        }

    }

    private long ldivide(long ldividend, long ldivisor) {
        // Recursion exit condition
        if (ldividend < ldivisor) return 0;

        //  Find the largest multiple so that (divisor * multiple <= dividend),
        //  whereas we are moving with stride 1, 2, 4, 8, 16...2^n for performance reason.
        //  Think this as a binary search.
        long sum = ldivisor;
        long multiple = 1;
        while ((sum+sum) <= ldividend) {
            sum += sum;
            multiple += multiple;
        }
        //Look for additional value for the multiple from the reminder (dividend - sum) recursively.
        return multiple + ldivide(ldividend - sum, ldivisor);
    }



    public static void main(String[] args) {
        System.out.println(new Solution().divideStandard(-2147483648, -1));

//        System.out.println(new Solution().bSearch(1,Long.parseLong("2147483648")));
    }



}
