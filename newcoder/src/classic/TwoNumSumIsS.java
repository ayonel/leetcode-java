package classic;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-18 16:47
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路： 先确定较小数，然后二分去找剩下的一个数，复杂度应该是nlogn
 * 还可以有一种o(n)的算法，两头一个指针，分别向中间扫，直到找到array[i]+array[j] == sum
 **/
public class TwoNumSumIsS {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int tmp = -1;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            tmp = bsearch(sum - array[i], array, i, length-1);
            if (tmp != -1){
                res.add(array[i]);
                res.add(tmp);
                break;
            }
        }
        return res;
    }

    public int bsearch(int target, int[] array, int start, int end){
        int mid = start;
        while (start <= end) {
            mid = (start + end) / 2;
            if (array[mid] == target)
                return target;
            if (array[mid] < target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }


}
