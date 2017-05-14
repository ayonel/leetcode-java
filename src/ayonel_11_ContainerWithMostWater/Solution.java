package ayonel_11_ContainerWithMostWater;

/**
 * Container With Most Water
 *
 * @author ayonel
 * @create 2017-04-17 19:37
 * @blog https://ayonel.me
 * Given n non-negative integers a1, a2, ..., an, where e
 * ach represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines,
 * which together with x-axis forms a container, such that the container contains the most water.
 *Note: You may not slant the container and n is at least 2.
 * 包含中间的，自定义的，
 *解题思路：中心扩展发？？
 *
 **/
public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i <= height.length-1; i++) {
            int lp = i-1;
            int rp = i+1;
            int area = 0;
            while( lp >= 0 && height[lp] >= height[i]) {
                area += height[i];
                lp--;
            }
            while(rp <= height.length-1 && height[rp] >= height[i]) {
                area += height[i];
                rp++;
            }
            if (area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] height = {3,2,1,3};
        System.out.println(s.maxArea(height));
    }
}
