package ayonel_205_IsomorphicStrings;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-04 17:17
 * @blog https://ayonel.me
 * 解题思路：用map，list辅助，还需要排序，太慢
 *
 *
 **/
public class Solution {

    boolean isIsomorphicStandard(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (m1[s.charAt(i)] != m2[t.charAt(i)]) return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        HashMap<Character, List<Integer>> sMap = constructMap(s);
        HashMap<Character, List<Integer>> tMap = constructMap(t);
        if (sMap.size() != tMap.size())
            return false;

        List<List<Integer>> sList = constructList(sMap);
        List<List<Integer>> tList = constructList(tMap);

        sList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        tList.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        for(int i = 0; i < sList.size(); i++) {
            if (sList.get(i).size() != tList.get(i).size())
                return false;
            for(int j = 0; j < sList.get(i).size(); j++){
                if (!sList.get(i).get(j).equals(tList.get(i).get(j)))
                    return false;
            }
        }
        return true;
    }

    public List<List<Integer>> constructList(HashMap<Character, List<Integer>> map){
        List<List<Integer>> list = new ArrayList<>();
        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
        return list;
    }

    public HashMap<Character, List<Integer>>  constructMap (String s){
        HashMap<Character, List<Integer>> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (sMap.containsKey(s.charAt(i)))
                sMap.get(s.charAt(i)).add(i);
            else {
                sMap.put(s.charAt(i), new ArrayList<>());
                sMap.get(s.charAt(i)).add(i);
            }
        }
        return sMap;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("aba", "baa"));
    }
}
