package ayonel_151_ReverseString;

/**
 * @author ayonel
 * @create 2017-06-30 10:51
 * @blog https://ayonel.me
 **/
public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        //压缩空格
        System.out.println(s);
        String[] wordlist = s.split("\\s+");
        StringBuilder res = new StringBuilder(wordlist[0]);
        for(int i = 1; i < wordlist.length; i++) {
            res.insert(0, wordlist[i]+" ");
        }


        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverseWords("   a   b  ccc"));
    }
}
