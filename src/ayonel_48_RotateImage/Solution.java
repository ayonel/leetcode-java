package ayonel_48_RotateImage;

import java.util.Arrays;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-05-23 21:48
 * @blog https://ayonel_113_PathSumII.me
 *
 * 解题思路，一圈一圈旋转
 **/
public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length ;
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-1-i; j++) {  // 大于等于 改成 小于号 每个折线的最后一个元素不动
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;

                System.out.println("****************");

                System.out.println(matrix[3][0]+" "+matrix[3][1]+" "+matrix[3][2]+" "+matrix[3][3]+"\n");

            }
            System.out.println("+++++++++++++++");

        }


        System.out.println("\n");

        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();

        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = new int[4][4];
        Arrays.fill(matrix[0], 1);
        Arrays.fill(matrix[1], 2);
        Arrays.fill(matrix[2], 3);
        Arrays.fill(matrix[3], 4);

        s.rotate(matrix);
    }
}
