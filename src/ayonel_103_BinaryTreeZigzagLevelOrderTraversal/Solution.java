package ayonel_103_BinaryTreeZigzagLevelOrderTraversal;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 14:12
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        boolean leftTOright = true;
        while(queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> nodeQueue = new ArrayDeque<>();
            nodeQueue.addAll(queue);
            if (leftTOright) {
                while (queue.size() > 0) {
                    TreeNode node = queue.removeFirst();
                    list.add(node.val);
                }
            } else {
                while (queue.size() > 0) {
                    TreeNode node = queue.removeLast();
                    list.add(node.val);
                }
            }
            res.add(list);

            while (nodeQueue.size() > 0) {
                TreeNode node = nodeQueue.removeFirst();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            leftTOright = !leftTOright;

        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node_1 = new TreeNode(-1);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1_1 = new TreeNode(1);
        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);

        node0.left = node2;
        node0.right = node4;
        node2.left = node1;
        node1.right = node1_1;
        node1.left = node5;
        node4.left = node3;
        node3.right = node6;
        node4.right = node_1;
        node_1.right = node8;

        System.out.println(new Solution().zigzagLevelOrder(node0));
    }
}
