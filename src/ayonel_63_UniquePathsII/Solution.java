package ayonel_63_UniquePathsII;

/**
 * Unique Paths II
 *
 * @author ayonel
 * @create 2017-05-24 23:09
 * @blog https://ayonel.me
 **/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] matrix = new int[m][n];

        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if (flag) {
                if (obstacleGrid[0][i] == 0)
                    matrix[0][i] = 1;
                else {
                    matrix[0][i] = 0;
                    flag = false;
                }
            } else {
                matrix[0][i] = 0;
            }

        }

        flag = true;
        for (int i = 0; i < m; i++) {
            if (flag) {
                if (obstacleGrid[i][0] == 0)
                    matrix[i][0] = 1;
                else {
                    matrix[i][0] = 0;
                    flag = false;
                }
            } else {
                matrix[i][0] = 0;
            }
        }

        return 0;

    }
}
