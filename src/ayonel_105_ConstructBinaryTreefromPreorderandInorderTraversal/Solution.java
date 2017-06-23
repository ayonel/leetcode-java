package ayonel_105_ConstructBinaryTreefromPreorderandInorderTraversal;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author ayonel
 * @create 2017-06-23 15:45
 * @blog https://ayonel.me
 * 递归，牛逼，我太牛逼了
 **/
public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = preorder.length;
        if (length == 0)
            return null;
        return buildTree(preorder, inorder, 0, length-1, 0, length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd || preStart >= preorder.length || inEnd >= inorder.length)
            return null;

        if (preStart == preEnd)
            return new TreeNode(preorder[preStart]);
        if (inStart == inEnd)
            return new TreeNode(inorder[inStart]);
        int i = inStart;
        for (; i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart])
                break;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        root.left = buildTree(preorder, inorder, preStart+1, preStart+i-inStart, inStart, i-1);
        root.right = buildTree(preorder, inorder, preStart+i-inStart+1, preEnd, i+1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {3,2,1,4,5,6,7};
        int[] in = {1,2,4,3,6,5,7};
        TreeNode node = new Solution().buildTree(pre, in);
        System.out.println("d");
    }
}
