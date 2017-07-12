package ayonel_289_GameofLife;

/**
 * @author ayonel
 * @create 2017-07-11 23:15
 * @blog https://ayonel.me
 **/
public class Solution {
    /**
     *  0 表示生，1表示死，
     *  3表示现在生，下一代生
     *  4表示现在生，下一代死
     *  5表示现在死，下一代生
     *  6表示现在死，下一代死
     */

    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                nextState(board, i, j);
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3 || board[i][j] == 5)
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }

    public void nextState(int[][] board, int i, int j) {
        int liveNeighbors = 0;

        if (i > 0){ //上
            if (board[i-1][j] == 1 ||board[i-1][j] == 3 ||board[i-1][j] == 4) liveNeighbors++;
        }

        if (i < board.length-1) {//下
            if (board[i+1][j] == 1 ||board[i+1][j] == 3 ||board[i+1][j] == 4) liveNeighbors++;
        }

        if (j > 0) {//左
            if (board[i][j-1] == 1 ||board[i][j-1] == 3 ||board[i][j-1] == 4) liveNeighbors++;
        }
        if (j < board[0].length-1) {//右
            if (board[i][j+1] == 1 ||board[i][j+1] == 3 ||board[i][j+1] == 4) liveNeighbors++;
        }

        if (i > 0 && j > 0) {//左上
            if (board[i-1][j-1] == 1 ||board[i-1][j-1] == 3 ||board[i-1][j-1] == 4) liveNeighbors++;
        }
        if (i > 0 && j < board[0].length-1) {//右上
            if (board[i-1][j+1] == 1 ||board[i-1][j+1] == 3 ||board[i-1][j+1] == 4) liveNeighbors++;
        }

        if (i < board.length-1 && j > 0) {//左下
            if (board[i+1][j-1] == 1 ||board[i+1][j-1] == 3 ||board[i+1][j-1] == 4) liveNeighbors++;
        }
        if (i < board.length-1 && j < board[0].length-1) {//左下
            if (board[i+1][j+1] == 1 ||board[i+1][j+1] == 3 ||board[i+1][j+1] == 4) liveNeighbors++;
        }

        if (board[i][j] == 0) {
            if (liveNeighbors == 3) board[i][j] = 5;
            else board[i][j] = 6;
        } else {
            if (liveNeighbors < 2 || liveNeighbors > 3) board[i][j] = 4;
            else board[i][j] = 3;
        }
        System.out.println(i+","+j+":"+liveNeighbors);

    }

    public static void main(String[] args) {
        int[][] board = {
                {1,0,1,1},
                {0,0,1,0},
                {0,1,0,1},
        };

//        int[][] board = {
//                {1,1},{1,0}
//        };
        new Solution().gameOfLife(board);
    }
}
