package ayonel_59_SpiralMatrixII;

/**
 * Spiral Matrix II
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-24 15:49
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int colBegin = 0;
        int rowBegin = 0;
        int colEnd = n - 1;
        int rowEnd = n - 1;
        int number = 0;
        while (colBegin <= colEnd && rowBegin <= rowEnd) {
            // right
            for(int i = colBegin; i <= colEnd; i++) {
                number += 1;
                matrix[rowBegin][i] = number;
            }
            rowBegin++;
//            print(matrix);

            // down
            for (int i = rowBegin; i <= rowEnd ; i++) {
                number += 1;
                matrix[i][colEnd] = number;
            }
            colEnd--;
//            print(matrix);


            // left
            for (int i = colEnd; i >= colBegin; i--) {
                number += 1;
                matrix[rowEnd][i] = number;
            }
            rowEnd--;
//            print(matrix);

            //up
            for (int i = rowEnd; i >= rowBegin ; i--) {
                number += 1;
                matrix[i][colBegin] = number;
            }
            colBegin++;
//            print(matrix);

        }


        return matrix;

    }

    private void print(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("***************");
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.generateMatrix(3);
    }
}
