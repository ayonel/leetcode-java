package ayonel_7_ReverseInteger;

/**
 * Reverse Integer
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-07 15:06
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路： 先用字符数组逆转原数字，注意要区分+ -
 * 然后用double来存逆转后的结果，最后判断是否溢出
 **/
public class Solution {
    public int reverse(int x) {
        String xString = String.valueOf(x);
        char[] xArray = xString.toCharArray();


        if(xArray[0] == '-'){
            reverse(xArray, 1, xArray.length-1);
        } else {
            reverse(xArray, 0, xArray.length-1);
        }
        System.out.println(xArray);
        double res = Double.valueOf(String.valueOf(xArray));
        if (isOverflow(res))
            return 0;
        else
            return (int)res;

    }

    public void reverse(char[] x, int start, int end) {
        while(start < end) {
            swap(x, start, end);
            start++;
            end--;
        }

    }

    public void swap(char[] x, int i, int j) {
        char tmp;
        tmp = x[i];
        x[i] = x[j];
        x[j] = tmp;
    }

    public boolean isOverflow(double x) {
        return  (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(901000));
    }


}
