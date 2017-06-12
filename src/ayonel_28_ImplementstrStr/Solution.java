package ayonel_28_ImplementstrStr;

/**
 * @author ayonel
 * @create 2017-06-11 22:26
 * @blog https://ayonel.me
 **/
public class Solution {
    public int strStr(String haystack, String needle) {
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (needleLength > haystackLength)
            return -1;
        if (needleLength == 0)
            return 0;
        int i = 0;
        int j = 0;
        while(i <= haystackLength-needleLength) {
            if(haystack.charAt(i) == needle.charAt(j)) {
                int gap = 0;
                while(j < needleLength && i+j < haystackLength && haystack.charAt(i+j) == needle.charAt(j)) {
                    if(j > 0 && needle.charAt(j) == needle.charAt(0) && gap == 0)
                        gap = j;
                    j++;

                }
                if (j == needleLength)
                    return i;

                if (gap > 0)
                    i+=gap;
                else
                    i++;
                j = 0;
                continue;
            }
            j = 0;
            i++;

        }

        return -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().strStr("aabaaabaaac","aabaaac"));
    }
}
