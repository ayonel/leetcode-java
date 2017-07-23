package ayonel_575_DistributeCandies;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author ayonel
 * @create 2017-07-23 12:57
 * @blog https://ayonel.me
 * 解题思路：弱智题
 **/
public class Solution {
    public int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();
        for(int i : candies) set.add(i);
        return Math.min(set.size(), candies.length/2);
    }

    public static void main(String[] args) {
        int[] candies = {1,1,1,1,1,11};
        System.out.println(new Solution().distributeCandies(candies));
    }

}
