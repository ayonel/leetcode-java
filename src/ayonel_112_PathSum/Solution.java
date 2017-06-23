package ayonel_112_PathSum;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 20:48
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    static boolean result = false;

    public boolean hasPathSum(TreeNode root, int sum) {
        result = false;
        if (root == null)
            return false;
        dfs(root, sum);
        return result;
    }
    public void dfs(TreeNode node, int target) {
        if (result)
            return;

        if (node.left == null && node.right == null) {
            if (node.val == target) {
                result = true;
                return;
            }
        }

        if (node.left != null)
            dfs(node.left, target-node.val);
        if (node.right != null)
            dfs(node.right, target-node.val);
    }

    public boolean hasPathSumStandard(TreeNode root, int sum) {
        if (root == null)
            return false;
        if (root.val == sum && root.left == null && root.right == null) return true;
        return hasPathSumStandard(root.left, sum-root.val) || hasPathSumStandard(root.right, sum-root.val);

    }


    public static void main(String[] args) {
//        TreeNode node5 = new TreeNode(5);
//        TreeNode node4 = new TreeNode(4);
//        TreeNode node8 = new TreeNode(8);
//        TreeNode node11 = new TreeNode(11);
//        TreeNode node13 = new TreeNode(13);
//        TreeNode node4_4 = new TreeNode(4);
//        TreeNode node7 = new TreeNode(7);
//        TreeNode node2 = new TreeNode(2);
//        TreeNode node1 = new TreeNode(1);
//
//        node5.left = node4;
//        node4.left = node11;
//        node11.left = node7;
//        node11.right = node2;
//        node5.right = node8;
//        node8.left = node13;
//        node8.right = node4_4;
//        node4_4.right = node1;

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;

        System.out.println(new Solution().hasPathSumStandard(node1, 1));
    }
}
