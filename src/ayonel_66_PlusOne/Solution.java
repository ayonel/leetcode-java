package ayonel_66_PlusOne;

import java.util.ArrayList;
import java.util.List;

/**
 * Plus One
 *
 * @author ayonel
 * @create 2017-05-25 09:57
 * @blog https://ayonel.me
 * 解题思路：从后往前扫
 **/
public class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> list = new ArrayList<>();

        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (i != 0) {
                if (digits[i] + carry == 10) {
                    list.add(0,0);
                    carry = 1;
                } else {
                    list.add(0, digits[i]+carry);
                    carry = 0;
                }
            } else {
                if (digits[i] + carry == 10) {
                    list.add(0,0);
                    list.add(0,1);
                } else {
                    list.add(0, digits[i]+carry);
                }
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {9,9};
        int[] res = s.plusOne(a);
        for (int i: res)
            System.out.print(i);
    }

}
