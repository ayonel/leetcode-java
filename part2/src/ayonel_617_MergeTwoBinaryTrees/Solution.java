package ayonel_617_MergeTwoBinaryTrees;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-24 15:06
 * @blog https://ayonel.me
 **/
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null)
            return null;
        if (t1 == null){
            return t2;
        }
        if (t2 == null){
            return t1;
        }
        t1.val = t1.val+t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
//        node1.right = node3;


        TreeNode node1_1 = new TreeNode(1);
        TreeNode node1_2 = new TreeNode(2);
        node1_1.right = node1_2;

        new Solution().mergeTrees(node1, node1_1);
        System.out.println();
    }
}
