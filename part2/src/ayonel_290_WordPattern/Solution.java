package ayonel_290_WordPattern;

import java.util.HashMap;

/**
 * @author ayonel
 * @create 2017-07-12 10:50
 * @blog https://ayonel.me
 * 解题思路：构建两个map，形成双射， 这两个map其实可以合为一个，都<String, String>
 **/
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strArray =  str.split(" ");
        if(strArray.length != pattern.length()) return false;

        HashMap<String, Character> sTc = new HashMap<>();
        HashMap<Character, String> cTs = new HashMap<>();
        for(int i = 0; i < strArray.length; i++) {
            if(!cTs.containsKey(pattern.charAt(i)) && !sTc.containsKey(strArray[i])){
                cTs.put(pattern.charAt(i),strArray[i]);
                sTc.put(strArray[i], pattern.charAt(i));
            } else if (cTs.containsKey(pattern.charAt(i)) && sTc.containsKey(strArray[i]) &&
                    cTs.get(pattern.charAt(i)).equals(strArray[i]) && sTc.get(strArray[i])==(pattern.charAt(i))){
                continue;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("abba", "dog cat cadt dog"));
    }
}
