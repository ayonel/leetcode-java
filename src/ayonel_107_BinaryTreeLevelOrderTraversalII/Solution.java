package ayonel_107_BinaryTreeLevelOrderTraversalII;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).
 *
 * @author ayonel_113_PathSumII
 * @create 2017-06-23 17:14
 * @blog https://ayonel_113_PathSumII.me
 **/
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
            res.add(0,list);

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

    static List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        DFS(root, 0);
        //反转res
        List<List<Integer>> reversRes = new ArrayList<>();
        for (List<Integer> list: res) {
            reversRes.add(0, list);
        }
        return reversRes;
    }

    public void DFS(TreeNode root, int deep) {
        if (root == null)
            return;
        if (deep == res.size())
            res.add(new ArrayList<>());
        res.get(deep).add(root.val);
        DFS(root.left, deep+1);
        DFS(root.right, deep+1);
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

        System.out.println(new Solution().levelOrderBottomDFS(node0));
    }
}
