package ayonel_226_InvertBinaryTree;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-08 12:26
 * @blog https://ayonel.me
 **/
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode node = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = node;
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        TreeNode node = new Solution().invertTree(node1);
        System.out.println();

    }
}
