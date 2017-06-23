package ayonel_79_WordSearch;

import sun.security.krb5.internal.PAData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * ayonel_79_WordSearch
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-27 19:07
 * @blog https://ayonel_113_PathSumII.me
 * //深搜tm超时了，可能是开List的问题
 **/
public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        if (word.equals(""))
            return true;

        if (board.length*board[0].length < word.length())
            return false;

        char[] wordArray = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            wordArray[i] = word.charAt(i);
        }

        List<HashSet<String>> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wordArray[0] && res.size() == 0) {
                    HashSet<String> hashSet = new HashSet<>();
                    hashSet.add(i+","+j);
                    dfs(board, wordArray, i, j, 0, word.length(), hashSet, res);
                }

            }
        }

        return res.size() != 0;

    }

    public void dfs(char[][] board, char[] wordArray, int i, int j, int index, int length, HashSet<String> path, List<HashSet<String>> res){
        if (res.size() != 0)
            return;
        if (index == length - 1) {
            res.add(path);
            return;
        }
        if (board[i][j] != wordArray[index])
            return;

        if (i != 0 && board[i-1][j] == wordArray[index+1] && !path.contains((i-1)+","+j)) {
            HashSet<String> newPath = new HashSet<>();
            newPath.addAll(path);
            newPath.add((i-1)+","+j);
            dfs(board,wordArray,i-1,j,index+1,length, newPath, res);
        }

        if (i != board.length-1 && board[i+1][j] == wordArray[index+1] && !path.contains((i+1)+","+j)) {
            HashSet<String> newPath = new HashSet<>();
            newPath.addAll(path);
            newPath.add((i+1)+","+j);
            dfs(board,wordArray,i+1,j,index+1,length, newPath, res);
        }
        if (j != 0 && board[i][j-1] == wordArray[index+1] && !path.contains(i+","+(j-1))) {
            HashSet<String> newPath = new HashSet<>();
            newPath.addAll(path);
            newPath.add(i+","+(j-1));
            dfs(board,wordArray,i,j-1,index+1,length, newPath, res);
        }
        if (j != board[0].length-1 && board[i][j+1] == wordArray[index+1] && !path.contains(i+","+(j+1))) {
            HashSet<String> newPath = new HashSet<>();
            newPath.addAll(path);
            newPath.add(i+","+(j+1));
            dfs(board,wordArray,i,j+1,index+1,length, newPath, res);
        }

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
