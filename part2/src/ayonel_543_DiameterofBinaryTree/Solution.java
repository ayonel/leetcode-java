package ayonel_543_DiameterofBinaryTree;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-22 22:13
 * @blog https://ayonel.me
 **/
public class Solution {
    private int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
       max = 0;
       solve(root);
       return max-1;
    }

    public void solve(TreeNode root){
        if (root == null) return;
        max = Math.max(max, 1+longPath(root.left)+longPath(root.right));
        solve(root.left);
        solve(root.right);
    }

    public int longPath(TreeNode root){
        if (root == null)
            return 0;
        return 1 + Math.max(longPath(root.left), longPath(root.right));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.left = node5;
        System.out.println(new Solution().diameterOfBinaryTree(node1));
    }

}