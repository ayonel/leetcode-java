package ayonel_201_BitwiseANDofNumbersRange;

/**
 * @author ayonel
 * @create 2017-07-04 15:39
 * @blog https://ayonel.me
 * 解题思路：
 * 转成二进制数组，然后在最左边补0对齐，然后从头开始扫，直到两个二进制串不相等，则最终结果为前面的相等的数 右移还剩的位数。
 **/
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if (m == n)
            return m;
        String M = Integer.toBinaryString(m);
        String N = Integer.toBinaryString(n);
        if (M.length() > N.length()){
            String headZero = "";
            for (int i = 0; i < M.length()-N.length(); i++) {
                headZero = headZero+"0";
            }
            N = headZero + N;
        }

        if (M.length() < N.length()){
            String headZero = "";
            for (int i = 0; i < N.length()-M.length(); i++) {
                headZero = headZero+"0";
            }
            M = headZero + M;
        }

        int res = 0;
        int i = 0;
        for (; i < M.length(); i++) {
            if (M.charAt(i) == N.charAt(i)) {
                res <<= 1;
                res = res + Integer.parseInt(""+M.charAt(i));
            } else break;

        }
        res <<= (M.length()-i);

        System.out.println(M);
        System.out.println(N);
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        new Solution().rangeBitwiseAnd(10,11);
    }

    /**
     * 直接拿位运算，原理类似
     * @param m
     * @param n
     * @return
     */
    public int rangeBitwiseAndStandard(int m, int n) {
        if(m==0 || m==n)
            return m;
        int step = 0;
        while(m != n){
            m>>=1;
            n>>=1;
            step+=1;
        }
        return m<<=step;

    }
}
