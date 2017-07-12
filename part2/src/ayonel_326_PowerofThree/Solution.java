package ayonel_326_PowerofThree;

/**
 * @author ayonel
 * @create 2017-07-12 21:18
 * @blog https://ayonel.me
 **/
public class Solution {
    //以下是循环版本
    public boolean isPowerOfThree(int n) {
        while (n >= 3) {
            if (n%3 != 0)
                return false;
            n = n/3;
        }

        return n==1;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfThree(2));
    }
    //非循环版本
    public boolean isPowerOfThreeStandard(int n) {
        // 1162261467 is 3^19,  3^20 is bigger than int
        return ( n>0 &&  1162261467%n==0);
    }
}
