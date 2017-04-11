package ayonel_5_LongestPalindromicSubstring;

/**
 * Created by dimera on 2017/4/10.
 * 给出一个字符串，求出第一个最长的回文子串
 *例如： Input: "babad"
 *      Output: "bab"
 *      Note: "aba" is also a valid answer.
 *
 *      Input: "cbbd"
 *      Output: "bb"
 *
 * 解题思路：中心扩展法
 */
public class Solution {
    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        int longestLength = 0;
        for (int i = 0; i < s.length(); i++) {
            //  判断奇数的情况
            int lp = i;
            int rp = i;
            while(lp >= 0 && rp < s.length()) {
                if (s.charAt(lp) == s.charAt(rp)) {
                    lp--;
                    rp++;
                } else {
                    break;
                }
            }
            if (rp - lp - 1 > longestLength) {
                longestLength = rp - lp - 1;
                longestPalindrome = s.substring(lp+1, rp);
            }
            //判断是偶数的情况
            if ( i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                lp = i;
                rp = i + 1;
                while(lp >= 0 && rp < s.length()) {
                    if (s.charAt(lp) == s.charAt(rp)) {
                        lp--;
                        rp++;
                    } else {
                        break;
                    }
                }
                if (rp - lp - 1 > longestLength) {
                    longestLength = rp - lp - 1;
                    longestPalindrome = s.substring(lp+1, rp);
                }
            }
        }
        return  longestPalindrome;
    }

}
