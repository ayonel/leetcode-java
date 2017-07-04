package ayonel_168_ExcelSheetColumnTitle;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * @author ayonel
 * @create 2017-07-02 12:27
 * @blog https://ayonel.me
 *
 * //10进制转26进制
 **/
public class Solution {
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
            res  = "" + transform(n % 26)+ res;
            if(n % 26 == 0)
                n = (n/26)-1;
            else
                n /= 26;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(28*26));
    }

    public String transform(int i){
        switch (i){
            case 0: return "Z";
            case 1: return "A";
            case 2: return "B";
            case 3: return "C";
            case 4: return "D";
            case 5: return "E";
            case 6: return "F";
            case 7: return "G";
            case 8: return "H";
            case 9: return "I";
            case 10: return "J";
            case 11: return "K";
            case 12: return "L";
            case 13: return "M";
            case 14: return "N";
            case 15: return "O";
            case 16: return "P";
            case 17: return "Q";
            case 18: return "R";
            case 19: return "S";
            case 20: return "T";
            case 21: return "U";
            case 22: return "V";
            case 23: return "W";
            case 24: return "X";
            case 25: return "Y";
            default: return "";
        }
    }
}

