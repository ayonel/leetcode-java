package ayonel_187_RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author ayonel
 * @create 2017-07-03 15:23
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int length = s.length();
        List<String> res = new ArrayList<>();
        Set<String> resSet = new HashSet<>();
        if (length <= 10)
            return res;
        Set<String> set = new HashSet<>();

        for (int i = 0; i <= length-10; i++) {
            String sub = s.substring(i, i+10);
            if (set.contains(sub))
                resSet.add(sub);
            else
                set.add(sub);
        }
        res.addAll(resSet);
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findRepeatedDnaSequences("AAAAAAAAAAAA"));
    }
}
