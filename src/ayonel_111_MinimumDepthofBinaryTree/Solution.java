package ayonel_111_MinimumDepthofBinaryTree;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-14 09:21
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：递归
 **/
public class Solution {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        else
            return dfs(root, 1);
    }


    public int dfs(TreeNode root, int min) {
        if (root.left == null && root.right == null)
            return min;
        min+=1;
        if (root.left != null && root.right == null)
            return dfs(root.left, min);
        if (root.left == null && root.right != null)
            return dfs(root.right, min);

        return Math.min(dfs(root.left, min), dfs(root.right, min));
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node4.right = node5;
        node5.right = node6;

        System.out.println(new Solution().minDepth(node1));
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
