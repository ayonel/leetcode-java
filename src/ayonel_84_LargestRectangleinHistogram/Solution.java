package ayonel_84_LargestRectangleinHistogram;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-20 15:30
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：动归超时,用了高级数据结构，把所有高度存进map，也超时
 *
 * We have discussed a Divide and Conquer based O(nLogn) solution for this problem. In this post, O(n) time solution is discussed. Like the previous post, width of all bars is assumed to be 1 for simplicity. For every bar ‘x’, we calculate the area with ‘x’ as the smallest bar in the rectangle. If we calculate such area for every bar ‘x’ and find the maximum of all areas, our task is done. How to calculate area with ‘x’ as smallest bar? We need to know index of the first smaller (smaller than ‘x’) bar on left of ‘x’ and index of first smaller bar on right of ‘x’. Let us call these indexes as ‘left index’ and ‘right index’ respectively.
We traverse all bars from left to right, maintain a stack of bars. Every bar is pushed to stack once. A bar is popped from stack when a bar of smaller height is seen. When a bar is popped, we calculate the area with the popped bar as smallest bar. How do we get left and right indexes of the popped bar – the current index tells us the ‘right index’ and index of previous item in stack is the ‘left index’. Following is the complete algorithm.
 *https://leetcode.com/problems/largest-rectangle-in-histogram/#/solutions
 * */
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return heights[0];
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = heights[i];
        }

        for(int gap = 1; gap < n; gap++) {
            for (int i = 0;  gap + i < n; i++) {
                dp[i][i+gap] = (gap+1) * Math.min(dp[i][i+gap-1]/gap, heights[gap+i]);
            }
        }
        print(dp);

        int ans = 0;
        for(int gap = 0; gap < n; gap++) {
            for (int i = 0;  gap + i < n; i++) {
                ans = Math.max(ans, dp[i][i+gap]);
            }
        }

        System.out.println(ans);
        return ans;


    }

    public void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int largestRectangleAreaMine(int[] heights) {
        int n = heights.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return heights[0];

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (map.containsKey(heights[i])) {
                map.get(heights[i]).add(i);
            } else {
                ArrayList<Integer> tmpList = new ArrayList<>();
                tmpList.add(i);
                map.put(heights[i], tmpList);
            }
        }

        ArrayList<Integer> heightList = new ArrayList<>();
        heightList.addAll(map.keySet());
        if (heightList.size() == 1)
            return n * heightList.get(0);
        Collections.sort(heightList);

        int ans = 0;
        ArrayList<Integer> updateList = new ArrayList<>();
        updateList.add(-1);
        updateList.add(n);

        for (int i = 1; i < heightList.size(); i++) {
            updateList.addAll(map.get(heightList.get(i-1)));
            Collections.sort(updateList);
            ans = Math.max(n*heightList.get(0), ans);
            for (int j = 0; j < updateList.size()-1; j++) {

                ans = Math.max(ans, (updateList.get(j+1) - updateList.get(j) -1) * heightList.get(i));
            }
        }
        return ans;

    }

    public int largestRectangleAreaStandard(int[] height) {
        int len = height.length;
        Stack<Integer> s = new Stack<Integer>();
        int maxArea = 0;
        for(int i = 0; i <= len; i++){
            int h = (i == len ? 0 : height[i]);
            if(s.isEmpty() || h >= height[s.peek()]){
                s.push(i);
            }else{
                int tp = s.pop();
                maxArea = Math.max(maxArea, height[tp] * (s.isEmpty() ? i : i - 1 - s.peek()));
                i--;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1,1};
        System.out.println(new Solution().largestRectangleAreaMine(heights));
    }
}
