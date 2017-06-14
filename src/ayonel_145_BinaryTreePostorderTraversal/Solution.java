package ayonel_145_BinaryTreePostorderTraversal;

import java.util.*;

/**
 * 145. Binary Tree Postorder Traversal
 *
 * @author ayonel
 * @create 2017-06-14 19:11
 * @blog https://ayonel.me
 * 解题思路：利用堆栈，手动去模拟后序遍历的过程，寻找规律，注意入栈的时候要反着来
 * 前中后序的程序如下
 **/
public class Solution {
    public List<Integer> postorderTraversalMine(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> used = new HashSet<>();
        List<Integer> res = new ArrayList<>();
        if (root == null)
            return res;
        TreeNode p = root;
        stack.push(p);

        while(stack.size() > 0){
            p = stack.peek();

            if (p.left == null && p.right == null && !used.contains(p)) {
                res.add(p.val);
                used.add(p);
                stack.pop();
                continue;
            }

            if (p.left == null && !used.contains(p.right)){
                stack.push(p.right);
            }
            else if (p.right == null && !used.contains(p.left)) {
                stack.push(p.left);
            }else if (!used.contains(p.left) && !used.contains(p.right)){
                stack.push(p.right);
                stack.push(p.left);
            } else {
                res.add(p.val);
                used.add(p);
                stack.pop();
            }
        }
//            used.add(p);
//            stack.pop();



        return res;
    }





    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node4.left = node2;
        node4.right = node6;
        node2.left = node1;
        node2.right = node3;
        node6.left = node5;
        node6.right = node7;



        System.out.println(new Solution().postorderTraversal(node4));
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);  // Add after all left children
                p = node.right;
            }
        }
        return result;
    }


    //巧妙
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while(!stack.isEmpty() || p != null) {
            if(p != null) {
                stack.push(p);
                result.addFirst(p.val);  // Reverse the process of preorder
                p = p.right;             // Reverse the process of preorder
            } else {
                TreeNode node = stack.pop();
                p = node.left;           // Reverse the process of preorder
            }
        }
        return result;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
