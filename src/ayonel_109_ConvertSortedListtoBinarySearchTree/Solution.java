package ayonel_109_ConvertSortedListtoBinarySearchTree;

import ayonel_2_AddTwoNumbers.ListNode;
import ayonel_2_AddTwoNumbers.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 18:57
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：转成数组，但效率很慢
 **/
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return sortedArrayToBST(array);

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return null;
        return solve(nums, 0 , length-1);
    }

    public TreeNode solve(int[] nums, int start, int end) {
        if (start == end)
            return new TreeNode(nums[start]);
        if (start > end)
            return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = solve(nums, start, mid - 1);
        node.right = solve(nums, mid+1, end);
        return node;
    }



    private ListNode node;

    public TreeNode sortedListToBSTStandard(ListNode head) {
        if(head == null){
            return null;
        }

        int size = 0;
        ListNode runner = head;
        node = head;

        while(runner != null){
            runner = runner.next;
            size ++;
        }

        return inorderHelper(0, size - 1);
    }

    public TreeNode inorderHelper(int start, int end){
        if(start > end){
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode left = inorderHelper(start, mid - 1);

        TreeNode treenode = new TreeNode(node.val);
        treenode.left = left;
        node = node.next;
        treenode.right = inorderHelper(mid + 1, end);

        return treenode;
    }
}