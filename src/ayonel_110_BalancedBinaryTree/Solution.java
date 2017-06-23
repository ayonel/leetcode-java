package ayonel_110_BalancedBinaryTree;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 19:52
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：对每个节点，计算左右高度差，但是复杂度有些高，O(n^2)
 * 自下而上，效率很高
 *
 **/
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(maxDepth(root.left)- maxDepth(root.right)) > 1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);

        node1.left = node2;
        node2.left = node3;
        node1.right = node4;
        node3.left = node5;

        System.out.println(new Solution().isBalanced(node1));
    }

    public boolean isBalancedStandard(TreeNode root) {
        return dfsHeight (root) != -1;
    }

    public int dfsHeight(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = dfsHeight (root.left);
        if (leftHeight == -1) return -1;
        int rightHeight = dfsHeight (root.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)  return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }




}
