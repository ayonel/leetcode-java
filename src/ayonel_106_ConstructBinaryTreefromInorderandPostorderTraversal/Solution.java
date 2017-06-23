package ayonel_106_ConstructBinaryTreefromInorderandPostorderTraversal;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 16:54
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：我tm的太强了
 **/
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0)
            return null;
        return buildTree(inorder, postorder, 0, length-1, 0, length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (postStart > postEnd || inStart > inEnd)
            return null;

        if (postStart == postEnd)
            return new TreeNode(postorder[postStart]);
        if (inStart == inEnd)
            return new TreeNode(inorder[inStart]);
        int i = inEnd;
        for (; i >= 0; i--) {
            if (inorder[i] == postorder[postEnd])
                break;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        root.left = buildTree(inorder, postorder, inStart, i-1, postStart, postEnd - (inEnd-i)-1);
        root.right = buildTree(inorder, postorder, i+1, inEnd, postEnd - (inEnd-i), postEnd-1);
        return root;
    }

    public static void main(String[] args) {
        int[] in = {1,2,4,3,6,5,7};
        int[] post = {1,4,2,6,7,5,3};
        TreeNode node = new Solution().buildTree(in, post);
        System.out.println("d");
    }
}