package ayonel_165_CompareVersionNumbers;

/**
 * @author ayonel
 * @create 2017-07-01 11:09
 * @blog https://ayonel.me
 **/
public class Solution {
    public int compareVersion(String version1, String version2) {
        if (version1.equals(version2))
            return 0;
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        long num1, num2;
        int i = 0;
        for (; i < v1.length && i < v2.length ; i++) {
            num1 = Integer.parseInt(v1[i]);
            num2 = Integer.parseInt(v2[i]);

            if (num1 == num2)
                continue;
            if (num1 > num2)
                return 1;
            else
                return -1;
        }

        if (i == v1.length && i == v2.length)
            return 0;
        if (i < v1.length) {
            for( ; i < v1.length; i++) {
                if (Integer.parseInt(v1[i]) != 0)
                    return 1;
            }
            return 0;
        } else {
            for( ; i < v2.length; i++) {
                if (Integer.parseInt(v2[i]) != 0)
                    return -1;
            }
            return 0;
        }

    }


    public static void main(String[] args) {
        System.out.println(new Solution().compareVersion("1.0", "1.0.0"));
    }
}
