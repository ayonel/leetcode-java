package ayonel_89_GrayCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-21 19:13
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：找规律，从最后一位推到第一位，从最后一位开始，每一列先是1个0，2个0，4个0....
 * 然后对于每一列分别是2个1，0交替，4个1，0交替，8个1，0交替
 **/
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        int length = pow2(n);
        List<Integer>[] res = new ArrayList[length];
        for (int i = 0; i < res.length; i++) {
            res[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            //先初始化最开始的0
            int j = 0;
            for (; j < pow2(i); j++) {
                res[j].add(0,0);
            }
            //开始1，0交替，直到half
            boolean flag = true; //是否填1
            int gap = 0;
            for(int k = 0; k+j < length; k++) {
                if (gap == pow2(i+1)) {
                    flag = !flag;
                    k--;
                    gap = 0;
                    continue;
                }
                if (flag && gap < pow2(i+1)) {
                    res[k+j].add(0, 1);
                    gap++;
                }
                if (!flag && gap < pow2(i+1)) {
                    res[k+j].add(0, 0);
                    gap++;
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            ans.add(list01ToInt(res[i]));
            System.out.println(list01ToInt(res[i]));
        }

        return ans;
    }

    //返回2^x

    public int pow2(int x){
        return (int)Math.pow(2,x);
    }


    // ArrayList<Integer> 转化为整型
    public int list01ToInt(List<Integer> list) {
        int res = 0;
        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i)*pow2(size-1-i);
        }
        return res;
    }


    //神答案，orz
    public List<Integer> grayCodeStandard(int n) {
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < 1<<n; i++) result.add(i ^ i>>1);
        return result;
    }

    //另一种神答案

    /**
     * My idea is to generate the sequence iteratively. For example, when n=3, we can get the result based on n=2.
     00,01,11,10 -> (000,001,011,010 ) (110,111,101,100). The middle two numbers only differ at their highest bit, while the rest numbers of part two are exactly symmetric of part one. It is easy to see its correctness.
     Code is simple:
     */
    public List<Integer> grayCodeStandard2(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);
        }
        return rs;
    }

    public static void main(String[] args) {
        new Solution().grayCode(2);
    }
}
