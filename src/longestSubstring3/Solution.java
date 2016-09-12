package longestSubstring3;

import java.util.HashSet;

/**
 * @author ayonel
 * @created_at 16/9/12
 */

public class Solution {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("aab"));
    }
    public static  int lengthOfLongestSubstring(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int tmpMaxLength = 1;
        int max = 1;
        HashSet tmpSubstringSet = new HashSet();

        for (int i = 0; i < length; i++) {
            tmpSubstringSet.add(s.charAt(i));
            for (int j = i+1; j < length; j++) {
                if(!tmpSubstringSet.contains(s.charAt(j))) {
                    tmpSubstringSet.add(s.charAt(j));
                    tmpMaxLength ++;
                } else {
                    if (tmpMaxLength >= max)
                        max = tmpMaxLength;
                    tmpMaxLength=1;
                    tmpSubstringSet.clear();
                    break;
                }
            }
            if (tmpMaxLength == length)
                return length;
            if (tmpMaxLength >= max)
                max = tmpMaxLength;
        }
        return max;
    }
}
