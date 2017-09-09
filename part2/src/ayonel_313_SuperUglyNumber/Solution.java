package ayonel_313_SuperUglyNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * @author ayonel
 * @create 2017-09-02 17:45
 * @blog https://ayonel.me
 **/


public class Solution {

    public int nthSuperUglyNumber(int n, int[] primes) {
        Arrays.sort(primes);
        int[] ugly = new int[n];
        int k = primes.length;
        ugly[0] = 1;
        int[] factor = primes.clone();
        int[] index = new int[k];
        ArrayList<int[]> list = null;
        for(int i=1;i<n;i++){
            list = min(factor);
            ugly[i] = list.get(0)[0];
            for (int j = 0; j < list.size(); j++) {
                factor[list.get(j)[1]] = primes[list.get(j)[1]]*ugly[++index[list.get(j)[1]]];

            }

        }
//        for (int i = 0; i < n; i++) {
//            System.out.print(ugly[i]+",");
//        }
        return ugly[n-1];
    }

    public ArrayList<int[]> min(int[] factor){
        ArrayList<int[]> list = new ArrayList<>();
        int MIN = Integer.MAX_VALUE;
        for (int i = 0; i < factor.length; i++) {
            if (factor[i] < MIN){
                MIN = factor[i];
            }
        }

        for (int i = 0; i < factor.length; i++) {
            if (factor[i] == MIN){
                list.add(new int[]{MIN, i});
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] primes = {2, 7, 13, 19};
        System.out.println(new Solution().nthSuperUglyNumber(12, primes));
    }
}
