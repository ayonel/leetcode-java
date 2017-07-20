package ayonel_371_SumofTwoIntegers;

/**
 * @author ayonel
 * @create 2017-07-12 23:11
 * @blog https://ayonel.me
 * 解题思路：记住咯
 **/
public class Solution {
    public int getSum(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }


}
