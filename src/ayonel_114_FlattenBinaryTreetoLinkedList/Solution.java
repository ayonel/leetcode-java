package ayonel_114_FlattenBinaryTreetoLinkedList;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-23 21:37
 * @blog https://ayonel.me
 * 解题思路：前序遍历，保存进list，然后遍历list，更改左右孩子节点
 * inplace,结果是前序遍历的结果，所以用前序遍历的逆过程，先右孩子，再左孩子，再根节点
 *
 **/
public class Solution {

    private TreeNode prev = null;
    static TreeNode res = null;

    public void flattenStandard(TreeNode root) {
        if (root == null)
            return;
        flattenStandard(root.right);
        flattenStandard(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inTravel(root, list);
        for (int i = 0; i < list.size()-1; i++) {
            list.get(i).right = list.get(i+1);
            list.get(i).left = null;
        }
    }

    public void inTravel(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return ;
        list.add(root);
        inTravel(root.left, list);
        inTravel(root.right, list);
    }




    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;

        node1.right = node5;
        node5.right = node6;
        new Solution().flatten(node1);
        while (Solution.res != null) {
            System.out.println(Solution.res.val);
            Solution.res = Solution.res.right;
        }
    }
}
