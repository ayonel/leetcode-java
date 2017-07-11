package ayonel_230_KthSmallestElementinaBST;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.Stack;

/**
 * @author ayonel
 * @create 2017-07-10 16:33
 * @blog https://ayonel.me
 * 中序遍历？
 **/
public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        int count = 0;

        while (!stack.isEmpty() || p != null){
            if(p!=null){
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                if (++count == k){
                    return p.val;
                }
                p = p.right;
            }

        }
        return -1;

    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        node3.left = node1;
        node1.right = node2;
        node3.right = node4;

        System.out.println(new Solution().kthSmallest(node3,4));
    }

}
