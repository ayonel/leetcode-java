package ayonel_38_countAndSay;

/**
 * countAndSay
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-12 20:54
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public String countAndSay(int n) {
        if (n == 0)
            return "";
        if (n == 1)
            return "1";

        String[] res = new String[n];
        res[0] = "1";
        for (int i = 1; i < n; i++) {
            String tmp = "";
            int k = 1;
            for(int j = 1; j < res[i-1].length(); j++) {
                if (res[i-1].charAt(j) == res[i-1].charAt(j-1)){
                    k++;
                } else {
                    tmp+=""+k+res[i-1].charAt(j-1);
                    k=1;
                }
            }
            res[i] = tmp+k+res[i-1].charAt(res[i-1].length()-1);
        }

        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);

        }
        return res[n-1];

    }

    public static void main(String[] args) {
        new Solution().countAndSay(8);
    }
}
