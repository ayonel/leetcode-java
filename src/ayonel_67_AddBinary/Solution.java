package ayonel_67_AddBinary;

/**
 * 67. Add Binary
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-15 16:01
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        if (aLen == 0)
            return b;
        if (bLen == 0)
            return a;

        if (aLen > bLen)
            return solve(a, b);
        else
            return solve(b, a);

    }

    public String solve(String a, String b) {
        // a是长度更长的
        int aLen = a.length();
        int bLen = b.length();

        int carry = 0;
        int value = 0;
        StringBuilder str = new StringBuilder();
        int i = 0;
        for (; i < bLen; i++) {
            value = carry + (a.charAt(aLen-1-i)-'0') + (b.charAt(bLen-1-i)-'0');
            carry = value / 2;
            value = value % 2;
            str.insert(0, value);
        }
        for(int j = i; j < aLen; j++) {
            value = carry + (a.charAt(aLen-1-j)-'0');
            carry = value / 2;
            value = value % 2;
            str.insert(0, value);
        }

        if (carry == 1){
            str.insert(0,'1');
        }

        return str.toString();
    }

    public String addBinaryStandard(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("1011","1"));
    }
}
