package ayonel_98_ValidateBinarySearchTree;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 09:12
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：中序遍历后有序
 *
 **/
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        List<Integer> inOrderResult = inorderTraversal(root);

        for (int i = 1; i < inOrderResult.size(); i++) {
            if (inOrderResult.get(i) <= inOrderResult.get(i-1))
                return false;
        }
        return true;

    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }


    //好巧妙啊
    public boolean isValidBSTStandard(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minVal, long maxVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isValidBST(root.left, minVal, root.val) && isValidBST(root.right, root.val, maxVal);
    }


    public static void main(String[] args) {
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node6 = new TreeNode(6);
//        TreeNode node10 = new TreeNode(10);
//        TreeNode node15 = new TreeNode(15);
//        TreeNode node20 = new TreeNode(20);
//        node10.left = node5;
//        node10.right = node15;
//        node15.left = node6;
//        node15.right = node20;

        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node3_3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node3.left = node1;
        node1.left = node0;
        node1.right = node2;
        node2.right = node3_3;
        node3.right = node5;
        node5.right = node6;
        node5.left = node4;

        System.out.println(new Solution().isValidBST(node3));
    }
}