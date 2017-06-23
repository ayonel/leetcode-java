package ayonel_95_UniqueBinarySearchTreesII;


import ayonel_2_AddTwoNumbers.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ayonel_113_PathSumII
 * @create 2017-06-22 15:41
 * @blog https://ayonel_113_PathSumII.me
 * 解题思路：递归
 **/
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> res = solve(1,n);
        System.out.println(res);
        return res;
    }

    public List<TreeNode> solve(int start, int end) {
        if (start == end) {
            List<TreeNode> finalList = new ArrayList<>();
            finalList.add(new TreeNode(start));
            return finalList;
        }

        if (start > end) {
            return new ArrayList<>();
        }

        List<TreeNode> list = new ArrayList<>();

        for (int i = start; i <= end; i++) {

            List<TreeNode> leftTree = solve(start,i-1);
            List<TreeNode> rightTree = solve(i+1,end);
            //左右子树均为空
            if (leftTree.size() == 0 && rightTree.size() == 0) {
                list.add(new TreeNode(i));
            } else if(leftTree.size() == 0) {
                for (TreeNode rightNode: rightTree) {
                    TreeNode node = new TreeNode(i);
                    node.right = rightNode;
                    list.add(node);
                }
            } else if (rightTree.size() == 0) {
                for (TreeNode leftNode: leftTree) {
                    TreeNode node = new TreeNode(i);
                    node.left = leftNode;
                    list.add(node);
                }
            } else {
                //左右子树均不空
                for (TreeNode leftNode: leftTree) {
                    for (TreeNode rightNode: rightTree) {
                        TreeNode node = new TreeNode(i);
                        node.left = leftNode;
                        node.right = rightNode;
                        list.add(node);
                    }
                }
            }
        }

        return list;

    }





    public static void main(String[] args) {
        new Solution().generateTrees(1);
    }

}
