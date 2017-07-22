package ayonel_501_FindModeinBinarySearchTree;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-22 15:35
 * @blog https://ayonel.me
 * 解题思路：遍历，排序计数吧
 **/
public class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preTravel(root, list);
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        int maxCount = 1;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : array) {
            if (map.containsKey(i))
                map.put(i, map.get(i)+1);
            else
                map.put(i, 1);
        }
        for(int count : map.values()){
            if (count > maxCount)
                maxCount = count;
        }
        //复用list
        list.clear();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() == maxCount)
                list.add(entry.getKey());
        }

        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            res[i] = list.get(i);
        }
        return res;
    }

    public Solution() {
        super();
    }

    public void preTravel(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        preTravel(root.left, list);
        preTravel(root.right, list);
        int[] nums = {1,3,2};


    }




}