package ayonel_124_BinaryTreeMaximumPathSum;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * @author ayonel
 * @create 2017-06-27 15:17
 * @blog https://ayonel.me
 * 解题思路：递归左右子树，保存当前的最大值结果，返回的是以经过该节点的最大路径的值
 * 思想一样，但是Standard是更简洁的代码，利用0来做规约，值得学习,左右子树如果返回值小于0，直接将left，right置为0
 **/
public class Solution {
    static int MAX = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        MAX = Integer.MIN_VALUE;
        if (root == null)
            return 0;
        maxSubTree(root);
        return MAX;
    }

    public int maxSubTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            MAX = max(MAX, root.val);
            return root.val;
        }

        //右子树为空
        if (root.right == null) {
            int left = maxSubTree(root.left);
            if (left <= 0) {
                MAX = max(MAX, root.val);
                return root.val;
            } else {
                MAX = max(MAX, root.val + left);
                return root.val + left;
            }
        }
        //左子树为空
        if (root.left == null) {
            int right = maxSubTree(root.right);
            if (right <= 0) {
                MAX = max(MAX, root.val);
                return root.val;
            } else {
                MAX = max(MAX, root.val + right);
                return root.val + right;
            }
        }
        //左右均不空
        int left = maxSubTree(root.left);
        int right = maxSubTree(root.right);
        if (left <= 0 && right <= 0) {
            MAX = max(MAX, root.val);
            return root.val;
        }
        if (left <= 0) {
            MAX = max(MAX, root.val+right);
            return root.val+right;
        }
        if (right <= 0) {
            MAX = max(MAX, root.val+left);
            return root.val+left;
        }
        int tmp = max(root.val+left, root.val+right,root.val + left + right);
        MAX = max(tmp, MAX);
        return max(root.val + left, root.val + right);
    }

    public int max(int a, int b, int c) {
        return Math.max(Math.max(a,b),c);
    }
    public int max(int a, int b) {
        return Math.max(a,b);
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(-3);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(-7);
        TreeNode node7 = new TreeNode(-1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;

        System.out.println(new Solution().maxPathSum(node1));
    }



    int maxValue;

    public int maxPathSumStandard(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxValue = Math.max(maxValue, left + right + node.val);
        return Math.max(left, right) + node.val;
    }
}
