package ayonel_43_MultiplyStrings;

import java.util.Arrays;

/**
 * 43. Multiply Strings
 *
 * @author ayonel
 * @create 2017-06-12 21:22
 * @blog https://ayonel.me
 * 解题思路：就是模拟，但是写的太丑了
 **/
public class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() <= num2.length())
            return solve(num1, num2);
        else
            return solve(num2, num1);
    }

    public String solve(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0"))
            return "0";
        String[] mid = new String[num1.length()];
        Arrays.fill(mid, "");
        String res="0";
        for (int i = num1.length()-1; i >= 0; i--) {
            int carry = 0;
            int value = 0;
            for(int j = num2.length()-1; j >= 0; j--) {
                int mulRes = unitMul(num2.charAt(j), num1.charAt(i));
                mulRes+=carry;
                value = mulRes % 10;
                mid[i] = ""+(value)+mid[i];
                carry = (mulRes / 10);
            }
            if (carry > 0)
                mid[i] = ""+(carry)+mid[i];
            for (int k = 0; k < num1.length()-1-i; k++) {
                mid[i] += "0";
            }
        }



        for (int i = 0; i < num1.length(); i++) {
            res =  strAdd(res, mid[i]);
        }
        return res;


    }

    public int unitMul(char x, char y) {
        return (x-'0') * (y-'0');
    }
    public int unitAdd(char x, char y) {
        return (x-'0') + (y-'0');
    }


    public String strAdd(String x, String y) {
        if (x.length() > y.length()) {
            String tmp = x;
            x = y;
            y = tmp;
        }
        String res = "";
        int carry = 0;
        int value = 0;
        int i = x.length()-1;
        int gap = y.length() - x.length();

        for(; i >= 0; i--) {
            int addRes = unitAdd(x.charAt(i), y.charAt(i+gap));
            addRes += carry;
            value = addRes % 10;
            res = ""+(value)+res;
            carry = (addRes / 10);
        }
//        System.out.println(res);

        for(int j = gap-1; j >= 0; j--) {
            int addRes = unitAdd(y.charAt(j), String.valueOf(carry).charAt(0));
            value = addRes % 10;
            res = ""+(value)+res;
            carry = (addRes / 10);
        }
        if (carry > 0)
            res = ""+(carry)+res;
        return res;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().multiply("1","1"));
//        System.out.println(new Solution().strAdd("10488","45600"));
    }

}
