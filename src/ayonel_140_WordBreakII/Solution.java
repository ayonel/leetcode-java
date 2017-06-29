package ayonel_140_WordBreakII;

import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-29 14:24
 * @blog https://ayonel.me
 * 先用广搜，形成图结构，然后深搜路径,注意visited，访问过的别再访问了，很重要
 * 还可以用记忆化的深搜
 **/
import java.util.*;

public class Solution {

    public List<String> wordBreak(String s, List<String> wordDict) {
        Deque<Integer> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        HashMap<Integer, Set<Integer>> map = new HashMap<>();
        //通过广搜形成图结构，map中每个键表示目的地，值表示能到达目的地的起始点集合
        while (queue.size() > 0) {
            int start = queue.removeFirst();
            if (!visited.contains(start)) {
                visited.add(start);
                for (int i = start+1; i <= s.length() ; i++) {
                    if (wordDict.contains(s.substring(start, i))) {
                        queue.add(i);
                        if (map.containsKey(i)) {
                            map.get(i).add(start);
                        } else {
                            map.put(i, new HashSet<Integer>());
                            map.get(i).add(start);
                        }
                    }
                }
            }
        }
        List<List<Integer>> validPath = new ArrayList<>();
        //搜索图
        System.out.println(map);
        dfs(map, s.length(), new ArrayList<>(), validPath);
        List<String> result = new ArrayList<>();
        //在路径前面添加0
        for(List<Integer> list : validPath) {
            list.add(0,0);
        }
        System.out.println(validPath);


        for(List<Integer> list : validPath) {
            String ans = "";
            for (int i = 1; i < list.size(); i++) {
                ans += s.substring(list.get(i-1), list.get(i))+" ";
            }
            ans = ans.trim();
            result.add(ans);
        }

        System.out.println(result);
        return result;


    }

    public void dfs(HashMap<Integer, Set<Integer>> map, int position,List<Integer> path, List<List<Integer>> validPath) {
        if (position == 0) {
            validPath.add(path);
            return;
        }
        if (!map.containsKey(position))
            return;

        for(Integer next : map.get(position)) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(0,position);
            dfs(map, next, newPath, validPath);
        }
    }


    public static void main(String[] args) {
        String[] a = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(a));
        new Solution().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", wordDict);
    }


    public List<String> wordBreak(String s, Set<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    //妙啊
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}