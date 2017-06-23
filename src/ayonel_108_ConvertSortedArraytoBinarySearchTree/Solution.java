package ayonel_108_ConvertSortedArraytoBinarySearchTree;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 17:30
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
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

    public static void main(String[] args) {
        int[] nums = {1};
        TreeNode node = new Solution().sortedArrayToBST(nums);
        System.out.println(node);
    }
}
