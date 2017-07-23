package ayonel_563_BinaryTreeTilt;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-22 23:45
 * @blog https://ayonel.me
 * 解题思路：理解递归回来的过程。
 **/
public class Solution {
    int tilt=0;
    public int findTilt(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
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
        node3.left = node5;
        new Solution().findTilt(node1);

    }



}