package ayonel_257_BinaryTreePaths;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel
 * @create 2017-07-11 15:39
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        if (root == null)
            return ans;
        solve(root, new ArrayList<>(), res);
        for(List<Integer> path : res) {
            StringBuilder str = new StringBuilder(path.get(0).toString());
            for(int i = 1; i < path.size(); i++) {
                str.append("->"+path.get(i));
            }
            ans.add(str.toString());
        }

        return ans;
    }

    public void solve(TreeNode root, List<Integer> path, List<List<Integer>> res) {
        if (root.left == null && root.right == null) {
            path.add(root.val);
            res.add(path);
            return;
        }
        if (root.left != null) {
            List<Integer> newPath = new ArrayList<>();
            newPath.addAll(path);
            newPath.add(root.val);
            solve(root.left, newPath, res);
        }

        if (root.right != null) {
            List<Integer> newPath = new ArrayList<>();
            newPath.addAll(path);
            newPath.add(root.val);
            solve(root.right, newPath, res);
        }
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node1.left = node2;
        node1.right = node3;
        System.out.println(new Solution().binaryTreePaths(node1));

    }
}
