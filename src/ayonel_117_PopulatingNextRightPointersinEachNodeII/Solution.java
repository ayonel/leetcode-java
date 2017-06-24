package ayonel_117_PopulatingNextRightPointersinEachNodeII;

import ayonel_2_AddTwoNumbers.TreeLinkNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ayonel
 * @create 2017-06-23 22:34
 * @blog https://ayonel.me
 * 解题思路：层次遍历, standard是一个很简洁的层次遍历
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

                if (node.left != null)
                    queue.addLast(node.left);
                if (node.right != null)
                    queue.addLast(node.right);

            }
        }
    }

    public void connectStandard(TreeLinkNode root) {

        while(root != null){
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while(root!=null){
                if(root.left != null) { currentChild.next = root.left; currentChild = currentChild.next;}
                if(root.right != null) { currentChild.next = root.right; currentChild = currentChild.next;}
                root = root.next;
            }
            root = tempChild.next;
        }
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
//        node2.left = node4;
//        node2.right = node5;
//        node1.right = node3;
//        node3.left = node6;
//        node3.right = node7;
        new Solution().connect(node1);
        System.out.println();
    }
}
