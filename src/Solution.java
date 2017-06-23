import java.util.InputMismatchException;

/**
 * String to Integer (atoi)
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-07 15:29
 * @blog https://ayonel_113_PathSumII.me
 * 就是各种特殊条件，很无聊的题
 **/
public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() == 0)
            return 0;//
        str = str.trim();
        char firstChar = str.charAt(0);
        int sign = 1, start = 0, len = str.length();
        long sum = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }
        for (int i = start; i < len; i++) {
            if (!Character.isDigit(str.charAt(i)))
                return (int) sum * sign;
            sum = sum * 10 + str.charAt(i) - '0';
            if (sign == 1 && sum > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if (sign == -1 && (-1) * sum < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
        }

        return (int) sum * sign;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().myAtoi("        +004500"));
    }
}
