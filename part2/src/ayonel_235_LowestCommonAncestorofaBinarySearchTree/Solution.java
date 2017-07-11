package ayonel_235_LowestCommonAncestorofaBinarySearchTree;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-10 20:15
 * @blog https://ayonel.me
 * 解题思路：6666
 **/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= q.val)
            return solve(root, p, q);
        else
            return solve(root, q, p);
    }

    public TreeNode solve(TreeNode root, TreeNode p, TreeNode q) {
        if (p == root || q == root)
            return root;
        if (p.val < root.val && q.val > root.val){
            return root;
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        TreeNode res = new Solution().lowestCommonAncestor(node2, node3, node1);
        System.out.println(res.val);
    }
}
