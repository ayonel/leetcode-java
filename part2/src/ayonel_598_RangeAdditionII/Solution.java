package ayonel_598_RangeAdditionII;

/**
 * @author ayonel
 * @create 2017-07-23 20:39
 * @blog https://ayonel.me
 **/
public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int opNum = ops.length, minRow = Integer.MAX_VALUE, minCol = Integer.MAX_VALUE;
        if(opNum == 0) return m*n;
        for(int i = 0; i < opNum; i++) {
            minRow = Math.min(minRow, ops[i][0]);
            minCol = Math.min(minCol, ops[i][1]);
        }
        return (minRow)*(minCol);

    }

    public static void main(String[] args) {
        int[][] ops = {{3,3},{2,2},{3,3}};
        System.out.println(new Solution().maxCount(3,3, ops));
    }
}
