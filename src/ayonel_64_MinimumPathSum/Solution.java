package ayonel_64_MinimumPathSum;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimum Path Sum
 *
 * @author ayonel
 * @create 2017-05-25 09:39
 * @blog https://ayonel.me
 *
 * 解题思路：记录了所有的可能的总和(有可能超时，果然超时了)，优化算法是开一个int[][] matrix, 只记录到当前位置的最小值
 **/
public class Solution {
    public int minPathSumAll(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        List<Integer>[][] matrix = new ArrayList[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }


        int sum= 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            matrix[i][0].add(sum);
        }

        sum= 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            matrix[0][i].add(sum);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int step : matrix[i-1][j]) {
                    matrix[i][j].add(step + grid[i][j]);
                }

                for (int step : matrix[i][j-1]) {
                    matrix[i][j].add(step + grid[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i : matrix[m-1][n-1]) {
            if (i < res)
                res = i;
        }

        return res;

    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] matrix = new int[m][n];



        int sum= 0;
        for (int i = 0; i < m; i++) {
            sum += grid[i][0];
            matrix[i][0] = (sum);
        }

        sum= 0;
        for (int i = 0; i < n; i++) {
            sum += grid[0][i];
            matrix[0][i] = (sum);
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = Math.min(matrix[i-1][j] ,matrix[i][j-1]) + grid[i][j];
            }
        }


        return matrix[m-1][n-1];

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{1,2},{1,1}};

        System.out.println(s.minPathSum(a));
    }


}
