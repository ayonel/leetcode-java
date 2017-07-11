package ayonel_258_AddDigits;

/**
 * @author ayonel
 * @create 2017-07-11 16:02
 * @blog https://ayonel.me
 *
 * Could you do it without any loop/recursion in O(1) runtime?

 **/
public class Solution {
    public int addDigitsMine(int num) {
        int next = 0;
        while(num >= 10) {
            next = 0;
            while(num > 0) {
                next += num%10;
                num /= 10;
            }
            num = next;
        }

        return num;
    }




}
