package ayonel_212_WordSearchII;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-05 11:27
 * @blog https://ayonel.me
 * 解题思路：深搜果然超时，草
 * 需要用Trie
 * 很有启发意义的深搜，用到了剪枝，回溯
 **/
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) dfs(board, i - 1, j ,p, res);
        if (j > 0) dfs(board, i, j - 1, p, res);
        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'a','a'},

        };
//        char[][] board = {{'a'}};

        String[] words = {"aaa"};

        System.out.println(new Solution().findWords(board, words));
    }

//    public List<String> findWordsNew(char[][] board, String[] words) {
//
//
//    }
}
