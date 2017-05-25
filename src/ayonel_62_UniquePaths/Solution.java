package ayonel_62_UniquePaths;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-05-24 16:16
 * @blog https://ayonel.me
 * 解题思路：广搜，妈的超时了。。。。
 **/
public class Solution {
    public int uniquePaths(int m, int n) {
        List<List<Integer>> allPath = new ArrayList<>();
        bfs(m, n, 0, 0, new ArrayList<Integer>(), allPath);
        return allPath.size();

    }

    // 定义向右为1，向下为0
    private void bfs(int m, int n, int curX, int curY, List<Integer> path, List<List<Integer>> allPath) {
        if (curX == m - 1 && curY == n - 1) {
            allPath.add(path);
            return;
        }
        if (curX == m - 1 && curY < n - 1) {
            List<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            tmpPath.add(1);
            bfs(m,n,curX,curY+1, tmpPath, allPath);
        }
        if (curY == n - 1 && curX < m - 1) {
            List<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            tmpPath.add(0);
            bfs(m,n,curX+1,curY, tmpPath, allPath);
        }

        if (curY < n - 1 && curX < m - 1) {
            List<Integer> tmpPath1 = new ArrayList<>();
            List<Integer> tmpPath2 = new ArrayList<>();
            tmpPath1.addAll(path);
            tmpPath1.add(0);
            tmpPath2.addAll(path);
            tmpPath2.add(1);
            bfs(m,n,curX,curY+1, tmpPath1, allPath);
            bfs(m,n,curX+1,curY, tmpPath2, allPath);
        }

    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.uniquePathsDP(3,3));
    }

    //递归也超时，。。。。。。草

    public int uniquePathsRec(int m, int n) {
        return recur(m-1, n-1);

    }

    private int recur(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        return recur(m - 1, n) + recur(m, n - 1);
    }


    // 动态规划
    public int uniquePathsDP(int m, int n) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            matrix[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i][j-1] + matrix[i-1][j];
            }
        }

        return matrix[m-1][n-1];


    }


}
