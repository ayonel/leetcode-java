package ayonel_12_IntegertoRoman;

/**
 * Integer to Roman
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-08 10:44
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public String intToRoman(int num) {
        String[][] roman = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        String ret = "";
        int digit = 0;
        while (num != 0) {
            int remain = num % 10;
            ret = roman[digit][remain] + ret;
            digit++;
            num /= 10;
        }

        return ret;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(102));
    }
}
