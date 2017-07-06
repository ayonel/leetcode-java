package ayonel_215_KthLargestElementinanArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author ayonel
 * @create 2017-07-05 17:31
 * @blog https://ayonel.me
 * 解题思路：题目要求输出排序后的倒数第K个数，排序做法太easy了吧，题目考点应该不是这个，tm还击败了86.16%的人。。。复杂度(nlogn)
 * 优先队列的算法复杂度是O(nlogk)
 *
 **/
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        final int N = nums.length;
        Arrays.sort(nums);
        return nums[N - k];
    }

    public int findKthLargestQueue(int[] nums, int k) {

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.offer(val);
            if(pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int[] a=  {2,1,1,2};
        System.out.println(new Solution().findKthLargest(a,2));
    }
}
