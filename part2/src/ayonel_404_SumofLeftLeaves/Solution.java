package ayonel_404_SumofLeftLeaves;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-20 14:35
 * @blog https://ayonel.me
 **/
public class Solution {
    int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        if (root == null) return sum;
        sumOfLeftLeaves(root, false);
        return sum;
    }

    public void sumOfLeftLeaves(TreeNode root, boolean left){
        if (root.left == null && root.right == null){ //叶子节点
            if (left) //左边的叶子节点
                sum += root.val;
        }
        if (root.left != null)
            sumOfLeftLeaves(root.left, true);
        if (root.right != null)
            sumOfLeftLeaves(root.right, false);

    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node9 = new TreeNode(9);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        node3.left = node9;
        node3.right = node20;
        node20.left = node15;
        node20.right = node7;
        System.out.println(new Solution().sumOfLeftLeaves(node7));
    }
}
