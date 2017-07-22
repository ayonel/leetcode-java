package ayonel_461_HammingDistance;

/**
 * @author ayonel
 * @create 2017-07-21 13:56
 * @blog https://ayonel.me
 **/
public class Solution {
    public int hammingDistance(int x, int y) {
        String X = Integer.toBinaryString(x);
        String Y = Integer.toBinaryString(y);
        int hamming = 0;
        int i = 0, j = 0, lenX = X.length(), lenY = Y.length();
        while (i < lenX && j < lenY) {
            if (X.charAt(lenX-1-i) != Y.charAt(lenY-1-j))
                hamming++;
            i++;
            j++;
        }
        if (i < lenX){
            while (i < lenX){
                if (X.charAt(lenX-1-i) == '1')
                    hamming++;
                i++;
            }
        }
        if (j < lenY) {
            while (j < lenY){
                if (Y.charAt(lenY-1-j) == '1')
                    hamming++;
                j++;
            }
        }
        return hamming;


    }

    public int hammingDistanceStandard(int x, int y) {
        int z = x ^ y;
        int hamming = 0;
        while (z > 0) {
            if ((z & 1) == 1)
                hamming++;
            z >>= 1;
        }
        return hamming;

    }
    public int[] constructRectangle(int area) {
        int sqrt = (int)Math.ceil(Math.sqrt(area));
        int[] res = new int[2];
        for(int i = sqrt; i <= area; i++) {
            if (area % i == 0){
                res[0] = i;
                res[1] = area/i;
                return res;
            }

        }
        return res;

    }

    public static void main(String[] args) {
        new Solution().constructRectangle(10);
    }
}
