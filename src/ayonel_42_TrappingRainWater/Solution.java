package ayonel_42_TrappingRainWater;

/**
 * Trapping Rain Water
 *
 * @author ayonel_113_PathSumII
 * @create 2017-05-22 22:39
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {


    public int trap(int[] height) {
        if (height.length < 3)
            return 0;
        int ans = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                // add volum until an edge larger than the left edge
                while (l < r && left >= height[++l]) {
                    ans += left - height[l];
                }
            } else {
                // add volum until an edge larger than the right volum
                while (l < r && height[--r] <= right) {
                    ans += right - height[r];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(s.trap(a));
    }

}
