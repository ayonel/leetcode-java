package ayonel_438_FindAllAnagramsinaString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-20 18:54
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] P = new int[26];
        HashSet<Character> set = new HashSet<>();
        for (char c: p.toCharArray()) {
            P[c-'a'] += 1;
            set.add(c);
        }

        int[] S = new int[26];
        int sLen = s.length(), pLen = p.length();
        for (int i = 0; i <= sLen-pLen; i++) {
            if (!set.contains(s.charAt(i))) continue;
            Arrays.fill(S, 0);
            for(int j = 0; j < pLen; j++) {
                S[s.charAt(j+i)-'a'] += 1;
            }
            int j = 0;
            for (; j < 26; j++) {
                if (P[j] != S[j])
                    break;
            }
            if (j == 26) res.add(i);
        }
        return res;
    }
    public List<Integer> findAnagramsStandard(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s == null || s.length() == 0 || p == null || p.length() == 0) return list;
        int[] hash = new int[256]; //character hash
        //record each character in p to hash
        for (char c : p.toCharArray()) {
            hash[c]++;
        }
        //two points, initialize count to p's length
        int left = 0, right = 0, count = p.length();
        while (right < s.length()) {
            //move right everytime, if the character exists in p's hash, decrease the count
            //current hash value >= 1 means the character is existing in p
            if (hash[s.charAt(right++)]-- >= 1) count--;

            //when the count is down to 0, means we found the right anagram
            //then add window's left to result list
            if (count == 0) list.add(left);

            //if we find the window's size equals to p, then we have to move left (narrow the window) to find the new match window
            //++ to reset the hash because we kicked out the left
            //only increase the count if the character is in p
            //the count >= 0 indicate it was original in the hash, cuz it won't go below 0
            if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) count++;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findAnagrams("cbaebabacd","abc"));
    }
}
