package ayonel_118_PascalTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-23 22:56
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        res.add(list);
        for (int i = 1; i < numRows; i++) {
            list = res.get(i-1);
            List<Integer> newList = new ArrayList<>();
            newList.add(1);
            for (int j = 0; j < list.size()-1; j++) {
                newList.add(list.get(j) + list.get(j+1));
            }
            newList.add(1);
            res.add(newList);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(0));
    }
}
