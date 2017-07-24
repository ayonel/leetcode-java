package ayonel_637_AverageofLevelsinBinaryTree;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-24 20:18
 * @blog https://ayonel.me
 **/
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int size = 0;
        double sum = 0;
        TreeNode node = null;
        while (deque.size() > 0) {
            size = deque.size();
            sum = 0;
            for(int i = 0; i < size; i++) {
                node = deque.removeFirst();
                sum += node.val;
                if (node.left != null)
                    deque.addLast(node.left);
                if (node.right != null)
                    deque.addLast(node.right);
            }
            res.add(sum / (double)size);
        }
        return res;

    }
}
