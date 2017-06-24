package ayonel_116_PopulatingNextRightPointersinEachNode;

import ayonel_2_AddTwoNumbers.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ayonel
 * @create 2017-06-23 22:14
 * @blog https://ayonel.me
 * 解题思路：层次遍历
 * 还可以直接递归，空间复杂度满足inplace,并且效率高，有个trick，就是这棵树是完全二叉树，所以standard解法，效率高，要是
 * 普通树，还是我的层次遍历吧
 **/
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null)
            return;
        Deque<TreeLinkNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (queue.size() > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.removeFirst();
                if (i < size - 1)
                    node.next = queue.getFirst();
                else
                    node.next = null;

                if (node.left != null) {
                    queue.addLast(node.left);
                    queue.addLast(node.right);
                }
            }
        }

    }
    //巧妙啊 concise

    public void connectStandard(TreeLinkNode root) {
        if(root == null)
            return;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null)
                root.right.next = root.next.left;
        }

        connectStandard(root.left);
        connectStandard(root.right);
    }

    public static void main(String[] args) {
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);

        node1.left = node2;
        node2.left = node4;
        node2.right = node5;
        node1.right = node3;
        node3.left = node6;
        node3.right = node7;
        new Solution().connect(node1);
        System.out.println();
    }
}
