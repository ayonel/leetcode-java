package ayonel_104_MaximumDepthofBinaryTree;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * Given a binary tree, find its maximum depth.  The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 14:26
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：为什么我的不对，草，没毛病啊，老铁
 **/
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        return dfs(root, 1);
    }

    public int dfs(TreeNode root, int deep) {
        if (root.left == null && root.right == null) {
            return deep;
        }
        deep+=1;
        if (root.left != null)
            return dfs(root.left, deep);
        if (root.right != null)
            return dfs(root.right, deep);
        return Math.max(dfs(root.left, deep+1), dfs(root.right, deep+1));
    }

    public int maxDepth1(TreeNode root) {
        if(root==null){
            return 0;
        }
        return 1+Math.max(maxDepth1(root.left),maxDepth1(root.right));
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(0);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(0);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(0);
        TreeNode node7 = new TreeNode(0);
        node1.left = node2;
        node2.left = node3;

        node1.right = node4;
        node4.right = node5;
        node5.right = node6;
        node6.right = node7;
        System.out.println(new Solution().maxDepth(node1));
    }

}
