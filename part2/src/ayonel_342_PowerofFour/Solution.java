package ayonel_342_PowerofFour;

/**
 * @author ayonel
 * @create 2017-07-12 21:41
 * @blog https://ayonel.me
 **/
public class Solution {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        if (num == 1) return true;
        return (num%4)==0 && isPowerOfFour(num/4);
    }
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        return !((n&(n-1))==0);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(8));
//        System.out.println(new Solution().reverseVowels("eeo"));
    }


}
