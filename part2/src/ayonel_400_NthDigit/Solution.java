package ayonel_400_NthDigit;

/**
 * @author ayonel
 * @create 2017-07-20 10:54
 * @blog https://ayonel.me
 * 解题思路：不想谈，很傲娇
 **/
public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;

        long[] a = {1*9, 2*90, 3*900, 4*9000, 5*90000, 6*900000, 7*9000000, 8*90000000, (long)9*(long)900000000};
        long[] b = new long[9];
        b[0] = a[0];
        for (int i = 1; i < 9; i++) {
            b[i] = a[i] + b[i-1];
        }
        int i = 1;
        for(; i < 9; i++)
            if (n < b[i]) break;

        long rest = n-b[i-1];
        long number = (long)Math.pow(10, i)+(rest-1)/(i+1);
        long digit = (rest-1) % (i+1);

        for(int j = 0; j < i-digit; j++){
            number /= 10;
        }

        return (int)number % 10;

    }



    public static void main(String[] args) {
        System.out.println(new Solution().findNthDigit(15));
    }
}