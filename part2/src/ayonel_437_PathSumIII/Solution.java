package ayonel_437_PathSumIII;

import ayonel_141_LinkedListCycle.TreeNode;

/**
 * @author ayonel
 * @create 2017-07-20 16:10
 * @blog https://ayonel.me
 * 解题思路：递归
 **/
public class Solution {

    int res = 0;
    public int pathSum(TreeNode root, int sum) {
        res = 0;
        solve(root, sum);
        return res;
    }

    public void solve(TreeNode root, int sum) {
        if (root == null)
            return;
        find(root, sum);
        solve(root.left, sum);
        solve(root.right, sum);

    }


    public void find(TreeNode node, int sum) {
        if (node == null)
            return;
        if (node.val == sum){
            res += 1;
        }
        find(node.left, sum-node.val);
        find(node.right, sum-node.val);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(-2);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(-2);
        TreeNode node7 = new TreeNode(-1);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;


        System.out.println(new Solution().pathSum(node1, -1));
//        System.out.println(new Solution().find(node2, 8));
    }
}
