package ayonel_217_ContainsDuplicate;

/**
 * Created by dimera on 2017/4/10.
 * 基于桶排序，但是当数组中的最大值比较大时，会内存溢出
 */
public class Solution1 {
    public boolean containsDuplicate(int[] nums) {

        char array[] = new char[1000000];
        for (int i=0; i< nums.length; i++) {
            array[i] = ' ';
        }
        System.out.println(array[0]);
        for (int i=0; i< nums.length; i++) {
            if (array[abs(nums[i])] ==  ' ') {
                if (nums[i] > 0) {
                    array[abs(nums[i])] = '+';
                } else {
                    array[abs(nums[i])] = '-';
                }
            }
            if (array[abs(nums[i])] == '+') {
                if (nums[i] > 0) {
                    return true;
                } else {
                    array[abs(nums[i])] = '#';
                }
            }

            if (array[abs(nums[i])] == '-') {
                if (nums[i] <= 0) {
                    return true;
                } else {
                    array[abs(nums[i])] = '#';
                }
            }

            if (array[abs(nums[i])] == '#') {
                return true;
            }
        }
        return false;
    }

    public static int abs(int i) {
        int abs = i>0?i:i*(-1);
        return abs;
    }


}