package ayonel_51_NQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N-Queens
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-13 20:01
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
//        for (List<String> ans:
//             res) {
//            System.out.println(ans);
//
//        }
        return res;

    }

    public boolean dfs(char[][] board, int colIndex, List<List<String>> res) {
        if (colIndex == board.length) {
            res.add(construct(board));
            return true;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                dfs(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }

        return true;

    }


    private boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }


    private void print(boolean[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().solveNQueens(4);
    }
}
