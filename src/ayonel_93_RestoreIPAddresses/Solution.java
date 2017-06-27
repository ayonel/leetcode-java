package ayonel_93_RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-21 21:12
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(s, 0, new ArrayList<>(), res);

        List<String> ans = new ArrayList<>();
        for (List<Integer> list : res) {
            String str = "";
            for (Integer i: list) {
                str += i+".";
            }
            ans.add(str.substring(0, str.length()-1));
        }
        return ans;

    }

    public void dfs(String s, int index, List<Integer> path, List<List<Integer>> res){
        if(index == s.length()) {
            if(path.size() == 4){
                res.add(path);
                return;
            } else {
                return;
            }
        }

        if (index < s.length() && path.size() == 4)
            return;
        if (s.charAt(index) == '0'){
            List<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            tmpPath.add(0);
            dfs(s, index+1, tmpPath, res);
        } else {
            for(int i = index; i < s.length() && i <= index + 2; i++) {
                List<Integer> tmpPath = new ArrayList<>();
                tmpPath.addAll(path);
                int tmp = Integer.parseInt(s.substring(index, i+1));
                if (tmp <= 255) {
                    tmpPath.add(tmp);
                    dfs(s, i+1, tmpPath, res);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("01000"));
    }
}
