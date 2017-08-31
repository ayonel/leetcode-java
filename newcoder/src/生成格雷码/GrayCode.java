package 生成格雷码;

/**
 * @author ayonel
 * @create 2017-08-27 16:47
 * @blog https://ayonel.me
 **/
import java.util.*;

public class GrayCode {

    public ArrayList<String> solve(int n) {
        if (n == 1)
            return new ArrayList<String>(Arrays.asList("0","1"));
        ArrayList<String> next = solve(n-1);
        int size = next.size();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add("0"+next.get(i));
        }
        for (int i = 0; i < size; i++) {
            list.add("1"+next.get(size-1-i));
        }
        return list;

    }

    public String[] getGray(int n) {
        ArrayList<String> ans = solve(n);
        String[] res = new String[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }


}
