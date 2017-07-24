package ayonel_606_ConstructStringfromBinaryTree;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-07-24 14:43
 * @blog https://ayonel.me
 **/
public class Solution {

    public String tree2str(TreeNode t) {
        if (t == null) return "";

        String left = tree2str(t.left);
        String right = tree2str(t.right);
        if (right.equals("")&& left.equals(""))
            return t.val+"";
        if (right.equals(""))
            return t.val+"("+left+")";
        if (left.equals(""))
            return t.val+"()("+right+")";
        return t.val+"("+left+")("+right+")";
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        System.out.println(new Solution().tree2str(node1));
    }

}
