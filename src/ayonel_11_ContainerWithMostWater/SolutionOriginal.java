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
 * 从两端向中间扫描，只变化小的那一端 O(n)
 *
 *
 **/
public class SolutionOriginal {
    /**
     *
     * @param height
     * @return
     * 这种O(n)都超时了，费解
     */

    public int maxArea(int[] height) {
        int maxArea = 0;
        int lp = 0;
        int rp = height.length-1;
        int area = 0;
        while(lp < rp) {
            if (height[lp] < height[rp]) {
                area = (rp - lp) * height[lp];
                if (area > maxArea)
                    maxArea = area;
                lp++;
            } else {
                area = (rp - lp) * height[rp];
                if (area > maxArea)
                    maxArea = area;
                rp--;
            }
        }

        return maxArea;
    }

    /**
     * 这一样啊，也是O(n)，为什么就过了！！！草！！！！
     * @param height
     * @return
     */
    public int maxAreaPassed(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                    * (right - left));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }


        return maxArea;
    }

    public static void main(String[] args) {
        SolutionOriginal s = new SolutionOriginal();
        int[] height = {3,1,2,3};
        System.out.println(s.maxArea(height));
    }
}
