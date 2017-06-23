package ayonel_102_BinaryTreeLevelOrderTraversal;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.*;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).  For example: Given binary tree [3,9,20,null,null,15,7],
 *
 * return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]
 * @author ayonel
 * @create 2017-06-23 13:41
 * @blog https://ayonel.me
 * 解题思路：层次遍历, 利用双向队列
 * 用深搜也可以
 **/
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);
        while(queue.size() > 0) {
            List<Integer> list = new ArrayList<>();
            Deque<TreeNode> nodeQueue = new ArrayDeque<>();
            nodeQueue.addAll(queue);
            while (queue.size() > 0) {
                TreeNode node = queue.removeFirst();
                list.add(node.val);
            }
            res.add(list);

            while (nodeQueue.size() > 0) {
                TreeNode node = nodeQueue.removeFirst();
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }

        }
        return res;
    }

    //dfs解法

    public List<List<Integer>> levelOrderDFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }

    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
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

        System.out.println(new Solution().levelOrder(node0));
    }
}
