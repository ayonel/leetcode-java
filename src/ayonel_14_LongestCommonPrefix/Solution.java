package ayonel_14_LongestCommonPrefix;

/**
 * 14. Longest Common Prefix
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-08 11:18
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public String longestCommonPrefix(String[] strs) {

        int i = 0;
        int length = strs.length;
        if(length == 0 || strs[0].equals(""))
            return "";

        while(i < strs[0].length()) {
            char c = strs[0].charAt(i);
            for(int j = 1; j < length; j++) {
                if(i < strs[j].length()){
//                    System.out.println(strs[j].charAt(i));
                    if(strs[j].charAt(i) != c)
                        return strs[0].substring(0,i);
                } else{
                    return strs[0].substring(0,i);
                }
            }

            i++;
        }
        return strs[0].substring(0,i);

    }


    public static void main(String[] args) {
        String[] strings = {"11","1"};

        new Solution().longestCommonPrefix(strings);
    }
}
