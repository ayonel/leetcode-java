package ayonel_134_GasStation;

/**
 * @author ayonel
 * @create 2017-06-28 15:24
 * @blog https://ayonel.me
 * 解题思路：别暴力搜索，会超时
 * 把gas与cost的差值作为新数组，任务就变为在这个数组中找出 任意连续子向量的和大于等于0，且这个子向量的长度为length
 * 即 最终要走一圈。那么如果遍历到哪个点，子向量的和小于0了，直接将i更新到这个点。就跳过了很多步
 * 另外，如果这个点是小于i的，说明比i大的都不行，而我们的i是从0开始的，所以直接返回-1
 **/
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int[] diff = new int[length];
        for (int i = 0; i < length; i++) {
            diff[i] = gas[i]-cost[i];
        }
        int cur = 0;
        int i = 0;
        while (i < length){
            cur = diff[i];
            if (cur >= 0) {
                int k = i;
                int gap = 0;
                while (gap < length && cur >= 0) {
                    gap++;
                    k++;
                    k = k == length ? 0: k;
                    cur += diff[k];
                }
                if (i == k)
                    return i;
                else if (i < k){
                    i = k+1;
                    continue;
                } else {
                    return -1;
                }
            } else{
                i++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas =  {3,2,2,1};
        int[] cost = {4,0,3,1};
        System.out.println(new Solution().canCompleteCircuit(gas, cost));
    }

    //神一样的解法

    /**
     * start从最后开始，end从最前开始，如果sum一直是大于等于0的，++end,知道end == start, 说明找见了
     * end还没等于start呢，sum<0了，说明这个start不对，我们需要把start--;如果还是sum < 0,说明，还不够，需要把star
     * 再向end靠近。
     * 解法太妙了，有点类似双指针，如果sum<0了，就开始移动start； 否则移动end
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuitStandard(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        int sum = gas[start] - cost[start];
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                ++end;
            } else {
                --start;
                sum += gas[start] - cost[start];
            }
        }
        return sum >= 0 ? start : -1;
    }

}
