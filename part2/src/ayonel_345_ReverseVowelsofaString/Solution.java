package ayonel_345_ReverseVowelsofaString;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ayonel
 * @create 2017-07-12 22:19
 * @blog https://ayonel.me
 **/
public class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        if(n <= 1) return s;
        char[] str = s.toCharArray();
        int i =0, j=n-1;
        while(i < j) {
            while (i < j && !isVowel(str[i])){
                i++;
            }
            while (i < j && !isVowel(str[j])){
                j--;
            }
            if (i >= j) break;
            swap(str,i++,j--);
        }
        return String.copyValueOf(str);

    }
    public boolean isVowel(char c) {
        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U';
    }

    public void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;

    }
}