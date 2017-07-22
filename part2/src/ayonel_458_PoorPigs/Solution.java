package ayonel_458_PoorPigs;

/**
 * @author ayonel
 * @create 2017-07-20 23:23
 * @blog https://ayonel.me
 **/
public class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest / minutesToDie + 1,  pigs) < buckets)
            pigs += 1;
        return pigs;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().poorPigs(1000, 15, 60));
    }
}
