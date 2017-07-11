package ayonel_236_LowestCommonAncestorofaBinaryTree;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.*;

/**
 * @author ayonel
 * @create 2017-07-10 20:31
 * @blog https://ayonel.me
 * 解题思路：这tm也能过，构造一棵新树，带有指向父节点的指针，我自己都写得好无语
 * 4行的递归，草草草
 **/
public class Solution {


    public TreeNode lowestCommonAncestorStandard(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestorStandard(root.left, p, q);
        TreeNode right = lowestCommonAncestorStandard(root.right, p, q);
        if(left != null && right != null)   return root; //如果在左右子树中找见，则返回
        return left == null ? right : left;  //左右子树有一个不为null，返回不为null的子树
    }
    class TreeNodeParent {
        public int val;
        public TreeNodeParent left;
        public TreeNodeParent right;
        public TreeNodeParent parent;
        public TreeNodeParent(int x, TreeNodeParent p) {
            val = x;
            parent = p;
        }
    }


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == q)
            return p;
        Map<TreeNode, TreeNodeParent> map1 = new HashMap<>();
        Map<TreeNodeParent, TreeNode> map2 = new HashMap<>();
        TreeNodeParent rootP = travel(root, null, map1, map2);
        List<TreeNodeParent> list1 = new ArrayList<>();
        List<TreeNodeParent> list2 = new ArrayList<>();

        TreeNodeParent pp = map1.get(p);
        TreeNodeParent qq = map1.get(q);

        while (pp != null) {
            list1.add(pp);
            pp = pp.parent;
        }
        while (qq != null) {
            list2.add(qq);
            qq = qq.parent;
        }

        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i) == list2.get(j)){
                    return map2.get(list1.get(i));
                }
            }
        }

        return null;

    }

    public TreeNodeParent travel(TreeNode root, TreeNodeParent parent, Map<TreeNode, TreeNodeParent> map1, Map<TreeNodeParent, TreeNode> map2) {
        if (root != null) {
            TreeNodeParent node = new TreeNodeParent(root.val, parent);
            map2.put(node, root);
            map1.put(root, node);
            node.left = travel(root.left, node, map1, map2);
            node.right = travel(root.right, node, map1, map2);
            return node;
        } else{
            return null;
        }
    }



    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.right = node2;
        node1.left = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(new Solution().lowestCommonAncestor(node1, node5,node4).val);

    }




}
