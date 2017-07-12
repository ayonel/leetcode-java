package ayonel_350_IntersectionofTwoArraysII;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-12 22:36
 * @blog https://ayonel.me
 * 解题思路：如果用一个map更好，nums[1]加数，遍历nums[2]的时候，给list添加元素，知道对应的value等于0，小于0就不减了
 **/
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<>();
        for(int i: nums1)  {
            if (!map1.containsKey(i)) {
                map1.put(i, 1);
            } else {
                map1.put(i, map1.get(i)+1);
            }
        }

        HashMap<Integer, Integer> map2 = new HashMap<>();
        for(int i: nums2)  {
            if (!map2.containsKey(i)) {
                map2.put(i, 1);
            } else {
                map2.put(i, map2.get(i)+1);
            }
        }

        Set<Integer> set1 = map1.keySet();
        Set<Integer> set2 = map2.keySet();
        set1.retainAll(set2);

        List<Integer> list = new ArrayList<>();
        int i = 0;
        for(int num : set1) {
            int min = Math.min(map1.get(num), map2.get(num));
            for(int j = 0; j < min;j++)
                list.add(num);
        }
        int[] res = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            res[j] = list.get(j);
        }
        return res;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {1, 2, 2 };
        int[] res = new Solution().intersect(nums1, nums2);
        System.out.println();
    }
}
