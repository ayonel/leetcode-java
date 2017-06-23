package ayonel_30_SubstringwithConcatenationofAllWords;

import java.util.*;

/**
 * 30. Substring with Concatenation of All Words
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-12 11:06
 * @blog https://ayonel_113_PathSumII.me
 *
 * 解题思路：广搜,又tm超时,并且words中允许重复单词，所以我的方法中List.remove的时候会一次删除多个单词，有错误,
 * 其实没有必要用广搜，这种情况下广搜与遍历一遍是相等的，广搜还需要递归，更费时间，，，，
 *
 * 利用map来记录words中每个单词的个数，然后搜索
 *
 **/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0 || words[0].length() == 0){
            return res;
        }
        int wordLength = words[0].length();
        for (int i = 0; i <= s.length()-words[0].length(); i++) {
            List<String> target = new ArrayList<>(Arrays.asList(words));
            bfs(target, i, i, s, res, wordLength);
        }

        return res;
    }


    public void bfs(List<String> target, int index, int start, String s,List<Integer> res, int wordLength) {
        if (target.size() == 0){
            res.add(start);
            return;
        }
        if (index > s.length() - wordLength * target.size())
            return;

        for(int i = 1; i <= target.size(); i++) {
            if (target.contains(s.substring(index+wordLength*(i-1), index+wordLength*i))){
                target.remove(s.substring(index+wordLength*(i-1), index+wordLength*i));
                bfs(target, index+wordLength*i, start, s, res, wordLength);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = {"bar","foo"};

        System.out.println(new Solution().findSubstringStandard(s,words));
    }

    public  List<Integer> findSubstringStandard(String S, String[] L) {
        List<Integer> res = new ArrayList<Integer>();
        if (S == null || L == null || L.length == 0) return res;
        int len = L[0].length(); // length of each word

        Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
        for (String w : L) map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

        for (int i = 0; i <= S.length() - len * L.length; i++) {
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            for (int j = 0; j < L.length; j++) { // checkc if match
                String str = S.substring(i + j*len, i + j*len + len); // next word
                if (copy.containsKey(str)) { // is in remaining words
                    int count = copy.get(str);
                    if (count == 1) copy.remove(str);
                    else copy.put(str, count - 1);
                    if (copy.isEmpty()) { // matches
                        res.add(i);
                        break;
                    }
                } else break; // not in L
            }
        }
        return res;
    }

}
