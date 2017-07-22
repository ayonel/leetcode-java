package ayonel_455_AssignCookies;

import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-07-20 22:46
 * @blog https://ayonel.me
 * 解题思路：先排序，再贪心
 **/
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = 0, j = 0;
        while (i < g.length){
            while (j < s.length){
                if (g[i] <= s[j++]) {
                    res++;
                    break;
                }
            }
            i++;
        }
        return res;
    }


    public static void main(String[] args) {
        int[] g = {7,8,9,10};
        int[] s = {5,6,7,8};
        System.out.println(new Solution().findContentChildren(g,s));
    }
}
