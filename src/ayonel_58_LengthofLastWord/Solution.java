package ayonel_58_LengthofLastWord;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-15 13:18
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int length = s.length();
        int i = length-1;
        for (; i >= 0; i--) {
            if (s.charAt(i) != ' ')
               break;
        }
        int j = i;
        for (; j >=0 ; j--) {
            if (s.charAt(j) == ' ')
                break;
        }

        return i-j;

    }


    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord(" h"));
    }
}
