package ayonel_79_WordSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-05-27 21:27
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution1 {
    static boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        if (word.equals(""))
            return true;
        if (board.length*board[0].length < word.length())
            return false;

        visited = new boolean[board.length][board[0].length];


        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && search(board,word,i,j,0)) {
                    return true;
                }
            }
        }
        return false;


    }

    public boolean search(char[][]board, String word, int i, int j, int index){

        if (index == word.length()) {
            return true;
        }

        if (i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j])
            return false;

        //好好消化一下，这两个visit[i][j] 置为true false
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) ||
                search(board, word, i+1, j, index+1) ||
                search(board, word, i, j-1, index+1) ||
                search(board, word, i, j+1, index+1)) {
            return true;
        }

        visited[i][j] = false;
        return false;

    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'},
        };

        String word = "ABCB";
        Solution s = new Solution();
        System.out.println(s.exist(board, word));


    }
}
