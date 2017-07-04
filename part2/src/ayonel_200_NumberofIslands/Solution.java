package ayonel_200_NumberofIslands;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ayonel
 * @create 2017-07-04 14:51
 * @blog https://ayonel.me
 * 解题思路：通过扫描，构造一个visited数组，遇到1，且visted数组不存在，就开始expand，这个新岛
 * 草，深搜居然管用，130那道题不是深搜直接超时么。。草
 *
 **/
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0)
            return 0;
        int res = 0;
        HashSet<String> visted = new HashSet<>();


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visted.contains(i+","+j) && grid[i][j] == '1') {
                    res += 1;
                    expand( visted, grid, i, j);
                }
            }
        }
        return res;
    }


    public void expand(HashSet<String> visited, char[][] grid, int i, int j) {
        Set<String> newGenerated = new HashSet<>();
        Set<String> copy = new HashSet<>();
        newGenerated.add(i+","+j);
        visited.add(i+","+j);
        while (!newGenerated.isEmpty()) {
            copy.clear();
            copy.addAll(newGenerated);
            newGenerated.clear();
            int x,y;

            for(String index : copy) {
                x = Integer.parseInt(index.split(",")[0]);
                y = Integer.parseInt(index.split(",")[1]);

                if (x > 0 &&!visited.contains((x-1)+","+y) && grid[x-1][y] == '1'){
                    newGenerated.add((x-1)+","+y);
                    visited.add((x-1)+","+y);
                }
                if (y > 0 &&!visited.contains(x+","+(y-1)) && grid[x][y-1] == '1'){
                    newGenerated.add(x+","+(y-1));
                    visited.add(x+","+(y-1));
                }

                if (x < grid.length-1 &&!visited.contains((x+1)+","+y) && grid[x+1][y] == '1') {
                    newGenerated.add((x+1)+","+y);
                    visited.add((x+1)+","+(y));
                }
                if (y < grid[0].length-1 &&!visited.contains(x+","+(y+1)) && grid[x][y+1] == '1'){
                    newGenerated.add(x+","+(y+1));
                    visited.add(x+","+(y+1));
                }
            }
        }

    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','1','0'},
                {'0','0','0','1','0'},
        };

        System.out.println(new Solution().numIslands(grid));
    }
}
