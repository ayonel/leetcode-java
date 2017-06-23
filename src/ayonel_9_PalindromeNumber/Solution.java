package ayonel_9_PalindromeNumber;

/**
 * 9. Palindrome Number
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-07 16:42
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路: 有个不太科学的特殊考虑：如果是负数，直接返回false
 * 分别计算出倒数第index个数与第index个数，分别比较
 *
 * 注意：不要改变x的大小，比如10021，如果从前后分别删去1，1，则剩下的就直接变成2了，会遗漏0的情况
 *
 **/
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int i = 0;
        int x1 = x;
        while(x1 != 0) {
            x1 /= 10;
            i++;
        }
        // 说明x 是i位数
        int pre = 0;
        int last = 0;
        int index = 1;

        while(index <= i/2) {
            last = (int) (x%Math.pow(10,index));
            last /= Math.pow(10,index-1);
            pre = (int) (x/Math.pow(10,i-index));
            pre %= 10;

            if(last != pre)
                return false;
            index++;
        }

        return true;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isPalindrome(2222222));

    }
}
