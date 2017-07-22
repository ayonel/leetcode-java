package ayonel_538_ConvertBSTtoGreaterTree;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-22 21:01
 * @blog https://ayonel.me
 * 解题思路：中序遍历的反过程，保存一个pre
 **/
public class Solution {
    private int pre = 0;
    public TreeNode convertBST(TreeNode root) {
        pre = 0;
        List<Integer> list = new ArrayList<>();
        inTravel(root, list);
        return root;
    }
    private void inTravel(TreeNode root, List<Integer> list){
        if(root == null) return;
        inTravel(root.right, list);
        root.val += pre;
        pre = root.val;
        inTravel(root.left, list);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(13);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new Solution().convertBST(node1));
    }




}