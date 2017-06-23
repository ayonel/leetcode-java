package ayonel_113_PathSumII;

import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-06-23 21:15
 * @blog https://ayonel.me
 * 解题思路：深搜
 **/
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;
        dfs(root, sum, new ArrayList<>(), res);
        return res;
    }

    public void dfs(TreeNode node, int target, List<Integer> path, List<List<Integer>> res) {
        if (node.left == null && node.right == null) {
            if (node.val == target) {
                path.add(node.val);
                res.add(path);
                return;
            }
            return;
        }


        if (node.left != null) {
            List<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            tmpPath.add(node.val);
            dfs(node.left, target-node.val, tmpPath, res);
        }
        if (node.right != null) {
            List<Integer> tmpPath = new ArrayList<>();
            tmpPath.addAll(path);
            tmpPath.add(node.val);
            dfs(node.right, target-node.val, tmpPath, res);
        }
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5_5 = new TreeNode(5);

        node5.left = node4;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node5.right = node8;
        node8.left = node13;
        node8.right = node4_4;
        node4_4.right = node1;
        node4_4.left = node5_5;



        System.out.println(new Solution().pathSum(node5, 22));
    }


    // 深搜，但是思路值得借鉴，对于空间开销较小，只用一个path
    public List<List<Integer>> pathSumStandard(TreeNode root, int sum){
        List<List<Integer>> result  = new LinkedList<List<Integer>>();
        List<Integer> currentResult  = new LinkedList<Integer>();
        pathSum(root,sum,currentResult,result);
        return result;
    }

    public void pathSum(TreeNode root, int sum, List<Integer> currentResult,
                        List<List<Integer>> result) {

        if (root == null)
            return;
        currentResult.add(new Integer(root.val));
        if (root.left == null && root.right == null && sum == root.val) {
            result.add(new LinkedList(currentResult));
            currentResult.remove(currentResult.size() - 1);//don't forget to remove the last integer
            return;
        } else {
            pathSum(root.left, sum - root.val, currentResult, result);
            pathSum(root.right, sum - root.val, currentResult, result);
        }
        currentResult.remove(currentResult.size() - 1);
    }
}
