package ayonel_318_MaximumProductofWordLengths;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ayonel
 * @create 2017-09-02 13:40
 * @blog https://ayonel.me
 * 结题思路：26个字母，如果哪个单词包含'a' 那就在倒数第一位 或 1
 **/
class Solution {



    public int maxProduct(String[] words) {
        int ans = 0;
        Map<String, Integer> lenMap = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            String key = filter(words[i]);
            if (lenMap.containsKey(key) && lenMap.get(key) < words[i].length()){
                lenMap.put(key, words[i].length());
            }
            if (!lenMap.containsKey(key)){
                lenMap.put(key, words[i].length());
            }
        }

        ArrayList<String> list = new ArrayList<>();
        list.addAll(lenMap.keySet());
        Map<String, Integer> map = new HashMap<>();
        for (String key: lenMap.keySet()){
            int tmp = 0;
            for (int i = 0; i < key.length(); i++) {
                tmp |= 1<<(key.charAt(i)-'a');
            }
            map.put(key, tmp);
        }

        for (int i = 0; i < list.size()-1; i++) {
            for (int j = i+1; j < list.size(); j++) {
                if ((map.get(list.get(i)) & map.get(list.get(j))) == 0){
                    ans = Math.max(ans, lenMap.get(list.get(i)) * lenMap.get(list.get(j)));
                }

            }
        }


        System.out.println(ans);

        return  ans;

    }

    public String filter(String str){
        int[] index = new int[26];
        for (int i = 0; i < str.length(); i++) {
            if (index[str.charAt(i)-'a'] == 0){
                index[str.charAt(i)-'a'] = 1;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (index[i] == 1){
                res.append((char)('a'+i));
            }
        }
        return res.toString();
    }




    public static void main(String[] args) {
        String[] words = {"a", "aa", "aaa", "aaaa"};
        new Solution().maxProduct(words);
    }
}