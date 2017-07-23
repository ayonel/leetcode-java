package ayonel_594_LongestHarmoniousSubsequence;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ayonel
 * @create 2017-07-23 17:28
 * @blog https://ayonel.me
 **/
public class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for(int num: nums) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            } else {
                map.put(num, 1);
            }
        }
        int res = 0;
        for(int num: map.keySet()){
            if (map.containsKey(num+1)){
                res = Math.max(res, map.get(num) + map.get(num+1));
            }
        }

        return res;
    }
}
