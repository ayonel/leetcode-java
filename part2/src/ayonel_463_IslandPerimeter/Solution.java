package ayonel_463_IslandPerimeter;

/**
 * @author ayonel
 * @create 2017-07-21 16:54
 * @blog https://ayonel.me
 **/
public class Solution {
    public static int islandPerimeterStandard(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
    public int islandPerimeter(int[][] grid) {
        int m = grid.length+2, n = grid[0].length+2, res = 0;
        int[][] copy = new int[m][n]; //copy添加一圈水
        for(int i = 1; i < m-1; i++) {
            for (int j = 1; j < n-1; j++) {
                copy[i][j] = grid[i-1][j-1];
            }
        }
        print(copy);
        //从上往下找，找上面的横着的边
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 0 && copy[i+1][j] == 1)
                    res++;
            }
        }
        //从下往上找，找下面的横着的边
        for (int i = m-1; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                if (copy[i][j] == 0 && copy[i-1][j] == 1)
                    res++;
            }
        }

        //从左往右找，找左面的竖着的边
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                if (copy[j][i] == 0 && copy[j][i+1] == 1)
                    res++;
            }
        }
        //从右往左找，找右面的竖着的边
        for (int i = n-1; i > 0; i--) {
            for (int j = 0; j < m; j++) {
                if (copy[j][i] == 0 && copy[j][i-1] == 1)
                    res++;
            }
        }
        System.out.println(res);
        return res;
    }

    void print(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0,1,0,0},
                {1,1,1,0},
                {0,1,0,0},
                {1,1,0,0}};
        new Solution().islandPerimeter(grid);
    }
}
