package ayonel_240_Searcha2DMatrixII;

/**
 * @author ayonel
 * @create 2017-07-11 09:55
 * @blog https://ayonel.me
 * 但是复杂度有些高 m*log(n), 对每行搜索
 * 标准答案：从右上角开始，判断大小，然后决定向左走还是向下走，复杂度是（m+n）
 **/
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n==0)
            return false;

        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == target || matrix[i][n-1] == target) return true;
            if (matrix[i][0] > target || matrix[i][n-1] < target) continue;
            if (bsearch(matrix[i], target)) return true;
        }
        return false;

    }

    private boolean bsearch(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) return true;
            if (nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[][] a = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] a = {{}};
        System.out.println(new Solution().searchMatrix(a, 5));
    }
}
