package ayonel_49_GroupAnagrams;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-05-31 15:56
 * @blog https://ayonel.me
 * 解题思路：排序，再搜索，结果他么超时。。。
 * 不用排序，直接计算索引，扔进结果
 **/
public class Solution {
    static HashMap<String, String> wordMap = new HashMap<>();

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int length = strs.length;
        if (length == 0)
            return res;

        for (String word: strs) {
            wordMap.put(word, getSortedWord(word));
        }

        qsort(strs, 0, length - 1);

        List<String> list = new ArrayList<>();
        list.add(strs[0]);

        for (int i = 1; i < length; i++) {
            if (wordMap.get(strs[i-1]).compareTo(wordMap.get(strs[i])) != 0) {
                res.add(list);
                list = new ArrayList<>();
                list.add(strs[i]);
            } else {
                list.add(strs[i]);
            }
        }
        res.add(list);
        return res;
    }

    public String getSortedWord(String word) {
        char[] sortedWord = word.toCharArray();
        Arrays.sort(sortedWord);
        return String.valueOf(sortedWord);
    }


    public void qsort(String[] strs, int start, int end) {
        if (start == end)
            return;
        int lo = start;
        int hi = end;
        String pivot = wordMap.get(strs[start]);

        while(lo < hi) {
            while(lo < hi && wordMap.get(strs[hi]).compareTo(pivot) >= 0)
                hi--;
            if (wordMap.get(strs[hi]).compareTo(pivot) < 0) {
                swap(strs, hi, lo);
            }

            while (lo < hi && wordMap.get(strs[lo]).compareTo(pivot) <= 0)
                lo++;
            if (wordMap.get(strs[lo]).compareTo(pivot) > 0) {
                swap(strs, hi, lo);
            }

            //递归
            if(lo > start) qsort(strs,start,lo-1);//左边序列。第一个索引位置到关键值索引-1
            if(hi < end) qsort(strs,hi+1,end);//右边序列
        }


    }
    public void swap(String[] strs, int i, int j) {
        String tmp;
        tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("aaa");
        str.replace(0,1,"ss");
        System.out.println(str.toString());

    }


    public List<List<String>> groupAnagramsStandard(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for (String word:
             strs) {
            String index = getSortedWord(word);
            if (map.containsKey(index)){
                map.get(index).add(word);
            } else {
                map.put(index, new ArrayList<>());
                map.get(index).add(word);
            }
        }

        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            res.add(entry.getValue());
        }

        return res;
    }




}