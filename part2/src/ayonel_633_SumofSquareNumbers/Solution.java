package ayonel_633_SumofSquareNumbers;

/**
 * @author ayonel
 * @create 2017-07-24 19:47
 * @blog https://ayonel.me
 * 解题思路：我这个是两个指针夹逼，其实还可以用二分
 *
 **/
public class Solution {

    public boolean judgeSquareSum(int c) {
        if (isSquare(c)) return true;
        long sum = 0;
        long i = 1, j = (long)Math.sqrt(c);
        while (i <= j) {
            sum =  i*i + j*j;
            if (sum == c)
                return true;
            if (sum > c)
                j--;
            else
                i++;
        }
        return false;

    }
    public boolean isSquare(int num){
        int sqr = (int)Math.sqrt(num);
        return sqr*sqr == num;
    }
    public static void main(String[] args) {
        System.out.println(new Solution().judgeSquareSum(261));
    }

}
