package ayonel_166_FractiontoRecurringDecimal;


import java.util.ArrayList;

/**
 * @author ayonel
 * @create 2017-07-01 11:36
 * @blog https://ayonel.me
 * 用long
 * 用list存余数，如果新出现的余数在list中又出现，说明出现循环，终止
 **/
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0)
            return "0";
        long numeratorCopy;
        long denominatorCopy;
        boolean isPositive = true;
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0)
            isPositive = false;

        numeratorCopy = Math.abs((long)numerator);
        denominatorCopy = Math.abs((long)denominator);
        String INT = ""+numeratorCopy/denominatorCopy;
        StringBuilder DEC = new StringBuilder();
        System.out.println(isPositive);
        numeratorCopy = numeratorCopy%denominatorCopy;
        if (numeratorCopy == 0) //整数 直接返回
            return isPositive?INT: ("-"+INT);
        long next = numeratorCopy *10;
        ArrayList<Long> list = new ArrayList<>();

//        System.out.println(numeratorCopy);
        System.out.println(denominatorCopy);
        boolean hasLoop = false;
        while (true) {
            numeratorCopy = next;
            if (list.contains(numeratorCopy)) {
                hasLoop = true;
                break;
            }
            list.add(numeratorCopy);
            DEC = DEC.append(numeratorCopy/denominatorCopy);
            next = numeratorCopy%denominatorCopy * 10;
            if (next == 0)
                break;
        }


        if (hasLoop) {
            //有循环
            int start = list.indexOf(numeratorCopy);
            String loop = DEC.substring(start, DEC.length());
            DEC = new StringBuilder(DEC.substring(0,start) + "(" + loop+")");
        }
        if (isPositive) return DEC.equals("")? INT : INT+"."+DEC;
        else {
            return   "-" +(DEC.equals("")? INT : INT+"."+DEC);
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(-2147483648
                ,1));
    }
}
