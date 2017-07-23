package ayonel_566_ReshapetheMatrix;

/**
 * @author ayonel
 * @create 2017-07-23 12:30
 * @blog https://ayonel.me
 * 解题思路：通过每行的元素个数确定在第几行，第几列
 **/
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int or = nums.length, oc = nums[0].length;
        if(or*oc != r*c) return nums;
        int[][] res = new int[r][c];

        int  index = 0,i,j;
        while(index < r*c){
            i = index/oc;
            j = index%oc;
            res[index/c][index%c] = nums[i][j];
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3,4}};
        new Solution().matrixReshape(nums,2,2);
    }
}
