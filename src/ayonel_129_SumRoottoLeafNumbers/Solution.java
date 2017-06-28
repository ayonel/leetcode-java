package ayonel_129_SumRoottoLeafNumbers;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-27 21:18
 * @blog https://ayonel.me
 * 解题思路：遍历出所有路径，然后转为整数求和
 * 标准答案：直接求和，
 **/
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<String> res = getString(root);
        int sum = 0;
        for(String path : res) sum += Integer.parseInt(path);
        return sum;
    }

    public ArrayList<String> getString(TreeNode root) {
        if (root == null){
            ArrayList<String> path = new ArrayList<>();
            return path;
        }
        ArrayList<String> path = new ArrayList<>();
        ArrayList<String> left = getString(root.left);
        ArrayList<String> right = getString(root.right);
        if (left.size() == 0 && right.size() == 0) {
            path.add(""+root.val);
        } else {
            if (left.size() == 0) {
                for (String s : right) {
                    path.add(root.val + s);
                }
            } else if (right.size() == 0) {
                for (String s : left) {
                    path.add(root.val + s);
                }
            } else {
                for (String s : right) {
                    path.add(root.val + s);
                }
                for (String s : left) {
                    path.add(root.val + s);
                }
            }
        }
        return path;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
//        node1.left = node2;
//        node1.right = node3;
//        node2.left = node4;
//        node2.right = node5;

        System.out.println(new Solution().sumNumbers(node1));
    }

    public int sumNumbersStandard(TreeNode root) {
        if (root == null)
            return 0;
        return sumR(root, 0);
    }
    public int sumR(TreeNode root, int x) {
        if (root.right == null && root.left == null)
            return 10 * x + root.val;
        int val = 0;
        if (root.left != null)
            val += sumR(root.left, 10 * x + root.val);
        if (root.right != null)
            val += sumR(root.right, 10 * x + root.val);
        return val;
    }
}