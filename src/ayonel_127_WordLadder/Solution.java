package ayonel_127_WordLadder;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-06-27 17:17
 * @blog https://ayonel.me
 *
 **/
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<String>();
        reached.add(beginWord);
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (wordList.contains(word)) {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        return distance;
    }



    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>();
        String[] a = {"aa"};
        wordList.addAll(Arrays.asList(a));
        new Solution().ladderLength("qa", "sq", wordList);
    }
}
