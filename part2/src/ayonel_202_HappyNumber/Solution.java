package ayonel_202_HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ayonel
 * @create 2017-07-04 16:05
 * @blog https://ayonel.me
 * 解题思路：模拟呗，用个set
 * 主要效率满在循环里面的函数调用，直接写成inline形式
 *
 **/
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int copy,sum;
        while (!set.contains(n)) {
            set.add(n);
            copy = n;
            sum = 0;
            while (copy > 0) {
                sum += Math.pow(copy % 10,2);
                copy /= 10;
            }
            n = sum;
            System.out.println(n);
            if (n == 1)
                return true;
        }
        return false;
    }

    public int happyNext(int n) {
        int sum = 0;
        while (n > 0) {
            sum += Math.pow(n % 10,2);
            n /= 10;
        }
        return sum;
    }



}
