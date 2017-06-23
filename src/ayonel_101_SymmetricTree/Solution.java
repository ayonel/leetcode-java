package ayonel_101_SymmetricTree;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).  For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 * @author ayonel
 * @create 2017-06-23 13:22
 * @blog https://ayonel.me
 **/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null)
            return true;
        if (node1 == null || node2 == null)
            return false;
        if (node1.val != node2.val)
            return false;
        return isSymmetric(node1.left, node2.right) && isSymmetric(node1.right, node2.left);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node2_2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node3_3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node2_2;
        node2.left = node3;
        node2_2.right = node3_3;

        System.out.println(new Solution().isSymmetric(node1));
    }

}