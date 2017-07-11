package ayonel_239_SlidingWindowMaximum;


import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * @author ayonel
 * @create 2017-07-10 23:04
 * @blog https://ayonel.me
 * 复杂度不是O(N) 是O(N*logK)
 *
 * o(n):维护一个deque，存索引, 然后移除k范围之外的索引，再跟nums[i]比较，移除所有比nums[i]还小的数的索引。
 * deque里面是个降序的数组，此时deque里面的数都要比nums[i]大
 **/
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1 || k == 1)
            return nums;
        int[] res = new int[nums.length-k+1];
        int i = 0, j = 0, first = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        while (i < nums.length) {
            if (i < k-1) {
                priorityQueue.add(nums[i++]);
            } else {
                priorityQueue.add(nums[i++]);
                res[j++] = priorityQueue.peek();
                if (priorityQueue.peek() == nums[first]){
                    priorityQueue.poll();
                } else {
                    priorityQueue.remove(nums[first]);
                }
                first++;
            }
        }

        for (int ele : res) {
            System.out.print(ele+" ");
        }
        return res;

    }

    public static void main(String[] args) {
        int[] a = {6,5,4,3,2,1};
        new Solution().maxSlidingWindow(a, 3);
    }

    public int[] maxSlidingWindowS(int[] a, int k) {
        if (a == null || k <= 0) {
            return new int[0];
        }
        int n = a.length;
        int[] r = new int[n-k+1];
        int ri = 0;
        // store index
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < a.length; i++) {
            // remove numbers out of range k
            if (!q.isEmpty() && q.peek() < i - k + 1) {
                q.poll();
            }
            // remove smaller numbers in k range as they are useless
            while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
                q.pollLast();
            }
            // q contains index... r contains content
            q.offer(i);
            if (i >= k - 1) {
                r[ri++] = a[q.peek()];
            }
        }
        return r;
    }
}
