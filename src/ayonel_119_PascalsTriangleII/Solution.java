package ayonel_119_PascalsTriangleII;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-23 23:09
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        List<Integer> copy = new ArrayList<>();

        int size = 0;
        res.add(1);

        for (int i = 0; i < rowIndex; i++) {
            copy.addAll(res);
            copy.add(0);
            res.add(0,0);
            size = res.size();
            for (int j = 0; j < size; j++) {
                res.add(res.remove(0)+copy.remove(0));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getRow(1));
    }
}
