package ayonel_572_SubtreeofAnotherTree;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-23 12:36
 * @blog https://ayonel.me
 **/
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (solve(s, t)) return true;
        else return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean solve(TreeNode s, TreeNode t){
        if (s == null && t == null)
            return true;
        if (s == null || t == null)
            return false;
        if (s.val == t.val)
            return solve(s.left, t.left) && solve(s.right, t.right);
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node3.left = node4;
        node3.right = node5;
        node4.left = node1;
        node5.left = node2;


        TreeNode node1_1 = new TreeNode(1);
        TreeNode node1_2 = new TreeNode(2);
        TreeNode node1_3 = new TreeNode(3);
        node1_3.left = node1_1;
        node1_3.right = node1_2;

        System.out.println(new Solution().solve(node3, node1_3));
    }
}