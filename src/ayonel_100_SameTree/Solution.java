package ayonel_100_SameTree;

import ayonel_2_AddTwoNumbers.TreeNode;

/**
 * @author ayonel
 * @create 2017-06-23 10:49
 * @blog https://ayonel.me
 **/
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null)
            return false;
        if (q == null)
            return false;
        if (q.val == p.val)
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node2_2 = new TreeNode(3);
        node1.left = node2;
        node1_1.left = node2_2;
        System.out.println(new Solution().isSameTree(node1, node1_1));
    }
}
