package ayonel_139_WordBreak;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 *
 * @author ayonel
 * @create 2017-06-29 10:36
 * @blog https://ayonel.me
 * 解题思路：深搜超时
 * 动归,cao,维护一个,还可以用BFS,图搜索
 **/
public class Solution {


    public boolean wordBreak(String s, List<String> dict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
//         First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }

        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }

        return f[s.length()];
    }

    public static void main(String[] args) {
//        String[] a = {"aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba"};
//        List<String> wordDict = new ArrayList<>(Arrays.asList(a));
        List<String> wordDict = new ArrayList<>();
        wordDict.add("leet");
        wordDict.add("code");
//        wordDict.add("bbb");
//        wordDict.add("bbbb");

//        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", wordDict));
        System.out.println(new Solution().wordBreak("leetcode", wordDict));
//        System.out.println(new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict));
    }

    public boolean wordBreakBFS(String s, List<String> wordDict) {
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (queue.size() > 0) {
            int start = queue.removeFirst();
            if (!visited.contains(start)) {
                visited.add(start);
                for (int i = start+1; i <= s.length() ; i++) {
                    if (wordDict.contains(s.substring(start, i))) {
                        queue.add(i);
                        if (i == s.length())
                            return true;
                    }
                }
            }
        }
        return false;
    }


}
