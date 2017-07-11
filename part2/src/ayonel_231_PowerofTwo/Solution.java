package ayonel_231_PowerofTwo;

/**
 * @author ayonel
 * @create 2017-07-10 17:16
 * @blog https://ayonel.me
 **/
public class Solution {
    public boolean isPowerOfTwo(int n) {
        int count = 0;
        while (n > 0) {

            if ((n&1) == 1){
                if (count != 0)
                    return false;
                else
                    count++;
            }
            n >>= 1;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(80));
    }
}
