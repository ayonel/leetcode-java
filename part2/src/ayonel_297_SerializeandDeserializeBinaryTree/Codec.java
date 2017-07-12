package ayonel_297_SerializeandDeserializeBinaryTree;

import ayonel_141_LinkedListCycle.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ayonel
 * @create 2017-07-12 11:34
 * @blog https://ayonel.me
 * 解题思路：层次遍历，我很厉害！，但tm超时了，草，肯定是树不平衡时候，完全二叉树有太多废节点，最后一个测试用例超时
 * 正确姿势：树🌲的定义是递归，那么序列化与反序列化的时候也可以递归，先序遍历，序列化生成的结果中带有null标志，
 * 所以反序列化的时候能知道左右子树什么时候终止，因此不需要像原来的那道题一样：
 * 需要用2个序的遍历结果才能确定一棵树🌲
 *
 **/
public class Codec {
    // Encodes a tree to a single string.

    public String serialize(TreeNode root) {
        if (root == null)
            return "null";
        TreeNode nullNode = new TreeNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
        StringBuilder str = new StringBuilder();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (true) {
            int size = deque.size(), nullCount = 0;
            TreeNode node;

            //先检查一遍是否全为null
            for (int i = 0; i < size; i++) {
                node = deque.removeFirst();
                if (node == nullNode){
                    nullCount++;
                }
                deque.addLast(node);
            }
            if (nullCount != size) {
                for (int i = 0; i < size; i++) {
                    node = deque.removeFirst();
                    if (node == nullNode) {
                        str.append("null,");
                        deque.addLast(nullNode);
                        deque.addLast(nullNode);
                    } else {
                        str.append(node.val+",");
                        if (node.left != null) deque.addLast(node.left);
                        else deque.addLast(nullNode);

                        if (node.right != null) deque.addLast(node.right);
                        else deque.addLast(nullNode);
                    }
                }
            } else {
                break;
            }
        }
        return str.substring(0,str.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] array = data.split(",");
        int length = array.length, level = log2(length+1);
        if (length == 1){
            if (array[0].equals("null")) return null;
            else return new TreeNode(Integer.parseInt(array[0]));
        }
        TreeNode root = new TreeNode(Integer.parseInt(array[0]));
        TreeNode nullNode = new TreeNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        for(int i = 0; i < level-1; i++) {
            int size = deque.size(), next = (int)Math.pow(2,i+1)-1;
            for (int j = 0; j < size; j++) {
                TreeNode parent = deque.removeFirst();
                if (parent != nullNode) {
                    TreeNode left = generateNode(array[next+j*2], nullNode);
                    if (left != nullNode) {
                        parent.left = left;
                        deque.addLast(left);
                    } else{
                        deque.addLast(nullNode);
                    }
                    TreeNode right = generateNode(array[next+j*2+1], nullNode);
                    if (right != nullNode){
                        parent.right = right;
                        deque.addLast(right);
                    }else{
                        deque.addLast(nullNode);
                    }
                } else {
                    deque.addLast(nullNode);
                    deque.addLast(nullNode);
                }
            }
        }
        return root;

    }

    public int log2(int x) {
        return (int)(Math.log(x)/Math.log(2));
    }
    public TreeNode generateNode(String str, TreeNode nullNode) {
        if (str.equals("null")) return nullNode;
        else return new TreeNode(Integer.parseInt(str));
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;

//        System.out.println(new Codec().serialize(node1));
        TreeNode node = new Codec().deserialize("5,2,3,null,null,2,4,null,null,null,null,3,1,null,null");
        System.out.println();
    }



}
