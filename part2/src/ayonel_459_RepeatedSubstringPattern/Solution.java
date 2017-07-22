package ayonel_459_RepeatedSubstringPattern;



/**
 * @author ayonel
 * @create 2017-07-21 11:17
 * @blog https://ayonel.me
 * 解题思路：正则匹配
 **/
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 0; i < s.length()/2; i++) {
            if (len % (i+1) == 0) {
                if (check(i+1, s))
                    return true;
            }
        }
        return false;

    }

    private boolean check(int i, String s) {
        return s.substring(i).matches("("+s.substring(0,i)+")+");
    }

    public static void main(String[] args) {
        System.out.println(new Solution().repeatedSubstringPattern("ababacb"));
    }
}
