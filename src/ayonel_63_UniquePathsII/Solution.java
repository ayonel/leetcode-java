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



        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }



        return matrix[m-1][n-1];

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{0,0,0},{0,1,0}, {0,0,0}};
        System.out.println(s.uniquePathsWithObstacles(a));
    }
}
