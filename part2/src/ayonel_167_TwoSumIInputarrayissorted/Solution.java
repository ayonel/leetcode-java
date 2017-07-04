package ayonel_167_TwoSumIInputarrayissorted;

/**
 * @author ayonel
 * @create 2017-07-01 15:47
 * @blog https://ayonel.me
 **/
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        int length = numbers.length;
        if (length <= 1)
            return res;

        int i = 0, j = length-1, sum;
        while (i < j) {
            sum = numbers[i]+numbers[j];
            if (sum == target) {
                res[0] = i+1;
                res[1] = j+1;
                return res;
            }
            if (sum > target)
                j--;
            else
                i++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] a = {2,3,4};
        int[] res = new Solution().twoSum(a,6);
        System.out.println();
    }
}
