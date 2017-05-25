package ayonel_74_Searcha2DMatrix;

/**
 * Search a 2D Matrix
 *
 * @author ayonel
 * @create 2017-05-25 21:14
 * @blog https://ayonel.me
 **/
/**
 * @author ayonel
 * @create 2017-05-24 13:58
 * @blog https://ayonel.me
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
[1,   3,  5,  7],
[10, 11, 16, 20],
[23, 30, 34, 50]
]
 **/
public class Solution {
    //先确定有可能在哪儿些行，再确定在哪一列
    public boolean searchMatrix(int [][] array, int target) {
        int n = array.length;
        if (n == 0)
            return false;
        int m = array[0].length;

        if (m == 0) return false;
        for(int i = 0; i < n; i++) {
            if(target == array[i][0] || target == array[i][m-1])
                return true;
            if(target > array[i][0] && target < array[i][m-1]) {
                int result = bsearch(target, array[i]);
                if (result != -1)
                    return true;
            }

        }

        return false;

    }

    private int bsearch(int target, int[] nums){
        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
            int m = (lo + hi) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                lo = m+1;
            else
                hi = m-1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[][] a = {{0,7,8},{2,8,9},{3,10,11}};
        Solution s = new Solution();
        System.out.println(s.searchMatrixStandard(a,10));
    }

    /**
     * 真正的解法是把他当成一维数组
     */
    public boolean searchMatrixStandard(int [][] array, int target) {
        int m = array.length;
        if (m == 0)
            return false;
        int n = array[0].length;

        int lo = 0;
        int hi = m * n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (array[mid/n][mid%n] == target)
                return true;
            if (array[mid/n][mid%n] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }

        return false;
    }



}
