package ayonel_223_RectangleArea;

/**
 * @author ayonel
 * @create 2017-07-07 20:45
 * @blog https://ayonel.me
 * 结题思路：题目是求两个矩形覆盖的面积,如果不想交直接相加
 * SHIT,
 **/
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        System.out.println((C-A)*(D-B));
        System.out.println((G-E)*(H-F));
        if (C<=E || G<=A || B>=H || F>=D)
            return (C-A)*(D-B)+(G-E)*(H-F);
        int x = Math.min(C,G) - Math.max(A,E);
        int y = Math.min(D,H) - Math.max(B,F);
        return  (C-A)*(D-B)+(G-E)*(H-F)-x*y;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().computeArea(-3,-3,3,3,-5,-5,-4,0));
    }
}
