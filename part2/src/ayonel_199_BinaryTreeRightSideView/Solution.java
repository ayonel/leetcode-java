package ayonel_199_BinaryTreeRightSideView;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-04 11:23
 * @blog https://ayonel.me
 * 解题思路：层次遍历
 **/
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;

        queue.add(root);
        TreeNode node;
        int size;
        while (queue.size() > 0) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.removeFirst();
                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);
                if (i == size-1)
                    res.add(node.val);
            }
        }

        return res;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);


        node1.left=node2;
        node2.right=node5;
        node1.right = node3;
        node3.right = node4;
        System.out.println(new Solution().rightSideView(node1));
    }
}
