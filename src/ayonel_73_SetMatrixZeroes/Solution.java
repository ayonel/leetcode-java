package ayonel_73_SetMatrixZeroes;

import java.util.HashSet;

/**
 * ayonel_73_SetMatrixZeroes
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-25 10:15
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：如果没要求inplace的话，扫描一遍确定哪些行，列有0，存一个set 然后扫描set，清零原数组
 *
 * O（1）空间解题思路：扫一遍matrix,将所有的0映射到第一行跟第一列，并且保存两个数，表示第一行跟第一列有没有0；
 * 然后扫描第一行，第一列，如果扫到0，直接将该列或者该行清0；
 * 最后判断保存的两个数，决定是否对第一行第一列清0
 **/
public class Solution {
    public void setZeroesUseSet(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Integer> colSet = new HashSet<>();
        HashSet<Integer> rowSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    colSet.add(j);
                    rowSet.add(i);
                }
            }
        }

        for (int row : rowSet) {
            for (int i = 0; i < n; i++)
                matrix[row][i] = 0;
        }
        for (int col : colSet) {
            for (int i = 0; i < m; i++)
                matrix[i][col] = 0;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public void setZeroes(int[][] matrix) {

        boolean fr = false,fc = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) fr = true;
                    if(j == 0) fc = true;
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(fc) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }

        public static void main(String[] args) {
        Solution s = new Solution();
        int[][] a = {{0,0,0,5},{4,3,1,4},{0,1,1,4},{1,2,1,3},{0,0,1,1}};
        s.setZeroes(a);
    }
}