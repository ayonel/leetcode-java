package ayonel_54_SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Spiral Matrix
 *
 * @author ayonel
 * @create 2017-05-24 12:57
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<Integer>();
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < (n+1) / 2; i++) {
            for (int j = i; j <= m-1-i; j++) {
                res.add(matrix[i][j]);
//                System.out.print(matrix[i][j]+"a");
            }
            for (int j = i+1; j <= n-1-i; j++) {
                res.add(matrix[j][m-1-i]);
//                System.out.print(matrix[j][m-1-i]+"b");

            }
            for (int j = i+1; j <= m-1-i; j++) {
                res.add(matrix[n-1-i][m-1-j]);
//                System.out.print(matrix[n-1-i][m-1-j]+"c");

            }
            for (int j = i+1; j < n-1-i; j++) {
                res.add(matrix[n-1-j][i]);
//                System.out.print(matrix[n-1-j][i]+"d");
            }

        }
        if (res.size() != m * n)
            res.remove(res.size() - 1);
        return res ;

    }


    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}};
//        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
//        int[][] matrix = {{1,2}, {3,4}, {5,6},{7,8}};
        Solution s = new Solution();
        System.out.println(s.spiralOrder(matrix));
    }

}
