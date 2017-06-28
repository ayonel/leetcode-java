package ayonel_130_SurroundedRegions;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ayonel
 * @create 2017-06-27 21:50
 * @blog https://ayonel.me
 * 解题思路：最外圈找出所有的O点，然后存入集合，然后从这些O点出发，找相邻的O点，直到没有新的O点产生，最后根据生成的
 * 集合，保留O点，其余均为X，效率太慢，主要是以x+","+y为键存储，
 **/
public class Solution {
    public void solve(char[][] board) {
        HashSet<String> zero = new HashSet<>();
        int xLen = board.length;
        if (xLen == 0)
            return;
        int yLen = board[0].length;
        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        HashSet<String> newReachedCopy = new HashSet<>();
        HashSet<String> newReached = new HashSet<>();

        for (int i = 0; i < xLen; i++) {
            if (board[i][0] == 'O') newReached.add(i+","+0);
            if (board[i][yLen-1] == 'O') newReached.add(i+","+(yLen-1));
        }

        for (int i = 0; i < yLen; i++) {
            if (board[0][i] == 'O') newReached.add(0+","+i);
            if (board[xLen-1][i] == 'O') newReached.add((xLen-1)+","+i);
        }

        newReachedCopy.addAll(newReached);
        zero.addAll(newReached);
        int x, y;
        System.out.println(newReached);
        while (newReached.size() > 0) {
            newReached.clear();
            for (String s: newReachedCopy) {
                x = Integer.parseInt(s.split(",")[0]);
                y = Integer.parseInt(s.split(",")[1]);
                if (x-1 > 0 && board[x-1][y] == 'O') {
                    if (!zero.contains((x-1)+","+y)) {
                        zero.add((x-1)+","+y);
                        newReached.add((x-1)+","+y);
                    }
                }
                if (x+1 < xLen-1 && board[x+1][y] == 'O') {
                    if (!zero.contains((x+1)+","+y)) {
                        zero.add((x+1)+","+y);
                        newReached.add((x+1)+","+y);
                    }
                }
                if (y-1 > 0 && board[x][y-1] == 'O') {
                    if (!zero.contains(x+","+(y-1))) {
                        zero.add(x+","+(y-1));
                        newReached.add(x+","+(y-1));
                    }
                }
                if (y+1 < yLen-1 && board[x][y+1] == 'O') {
                    if (!zero.contains(x+","+(y+1))) {
                        zero.add(x+","+(y+1));
                        newReached.add(x+","+(y+1));
                    }
                }
            }
            newReachedCopy.clear();
            newReachedCopy.addAll(newReached);
            System.out.println(newReached);
        }
        System.out.println(zero);

        for (int i = 1; i < xLen-1; i++) {
            for (int j = 1; j < yLen-1; j++) {
                if (!zero.contains(i+","+j))
                    board[i][j] = 'X';
            }
        }

        for (int i = 0; i < xLen; i++) {
            for (int j = 0; j < yLen; j++) {
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        return;


    }
    public static void main(String[] args) {
        char[][] board = {
                {'O','O','O','O','X','X'},
                {'O','O','O','O','O','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},
                {'O','X','O','X','O','O'},
                {'O','X','O','O','O','O'},
        };
        new Solution().solve(board);
    }
}
