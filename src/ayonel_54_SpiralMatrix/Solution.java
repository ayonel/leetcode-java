package ayonel_54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-24 12:57
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();


        // 判断两种特殊情况
        if (m == 1) {
            for (int i = 0; i < n; i++)
            {
                res.add(matrix[i][0]);
            }
            return res;
        }

        if (n == 1) {
            for (int i = 0; i < m; i++)
            {
                res.add(matrix[0][i]);
            }
            return res;
        }

        for (int i = 0; i < (Math.min(m,n)+1) / 2; i++) {
            for (int j = i; j <= m-1-i; j++) {
                res.add(matrix[i][j]);
                System.out.print(matrix[i][j]+"a");
            }
            for (int j = i+1; j <= n-1-i; j++) {
                res.add(matrix[j][m-1-i]);
                System.out.print(matrix[j][m-1-i]+"b");

            }
            for (int j = i+1; j <= m-1-i; j++) {
                res.add(matrix[n-1-i][m-1-j]);
                System.out.print(matrix[n-1-i][m-1-j]+"c");

            }
            for (int j = i+1; j < n-1-i; j++) {
                res.add(matrix[n-1-j][i]);
                System.out.print(matrix[n-1-j][i]+"d");
            }
        }
        if (res.size() != m * n) {
            res.remove(res.size()-1);
        }
        return res ;

    }


    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12},{13,14,15,16}};
//        int[][] matrix = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
//        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] matrix = {{1,}, {3,}, {5,},{7,}};
        int[][] matrix = {{1,2}, {3,4}, {5,6},{7,8}};
        Solution s = new Solution();
        System.out.println(s.spiralOrder(matrix));
    }


    //

    /**
     * This is a very simple and easy to understand solution. I traverse right and increment rowBegin, then traverse down and decrement colEnd, then I traverse left and decrement rowEnd, and finally I traverse up and increment colBegin.

     The only tricky part is that when I traverse left or up I have to check whether the row or col still exists to prevent duplicates. If anyone can do the same thing without that check, please let me know!

     Any comments greatly appreciated.
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrderStandard(int[][] matrix) {

        List<Integer> res = new ArrayList<Integer>();

        if (matrix.length == 0) {
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;

        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;

            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }

        return res;
    }

}
